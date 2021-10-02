package Controle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.istack.Nullable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Conexao {

    private static URL                url;
    private static HttpURLConnection  connection;
    private static OutputStreamWriter outputStreamWriter;
    private static InputStream        inputStream;
    private static BufferedReader     reader;
    private static String             linha, parametroLength, retorno;
    private static StringBuffer       resposta;
    
    public static final String IP_TRACKER = "192.168.43.220";
    
    public String conectaWebService(String url, String parametro, String metodo){
        if(metodo.equals("GET") || metodo.equals("DELETE")){
            retorno = conectaWSGD(url, metodo);
        }
        if(metodo.equals("POST") || metodo.equals("PUT")){
            retorno = conectaWSPP(url, parametro, metodo);
        }
        return retorno;
    }

    //PARA CONEXOES GET E DELETE
    @Nullable
    private String conectaWSGD(String urlUsuario, String metodo){
        try{
              URL                url;
              HttpURLConnection  connection;
             OutputStreamWriter outputStreamWriter;
             InputStream        inputStream;
             BufferedReader     reader;
             String             linha, parametroLength, retorno;
             StringBuffer       resposta;
            url = new URL(urlUsuario);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(metodo);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Contetn-Language", "pt-BR");
            connection.setUseCaches(false);
            connection.connect();

            inputStream = connection.getInputStream();

            if(inputStream == null){
                return null;
            }

            reader   = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            resposta = new StringBuffer();

            while((linha = reader.readLine()) != null){
                resposta.append(linha);
            }

            if(resposta.length() == 0){
                connection.disconnect();
                return null;
            }else {

                if (connection != null) {
                    connection.disconnect();
                }

                if (reader != null) {
                    reader.close();
                }

                return resposta.toString();
            }

        }catch (IOException erro){
            System.out.println("Conexao - Get:\n" + erro.getMessage());
            return null;
        }
    }

    //PARA CONEXOES POST E PUT
    @Nullable
    private String conectaWSPP(String urlUsuario, String parametro, String metodo){
        try{
            url = new URL(urlUsuario);
            connection = (HttpURLConnection) url.openConnection();

            parametroLength  = Integer.toString(parametro.getBytes().length);

            connection.setRequestMethod(metodo);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Length", parametroLength);
            connection.setRequestProperty("Contetn-Language", "pt-BR");
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();

            outputStreamWriter = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            outputStreamWriter.write(parametro);
            outputStreamWriter.flush();

            inputStream = connection.getInputStream();

            if(inputStream == null){
                return null;
            }

            reader   = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            resposta = new StringBuffer();

            while((linha = reader.readLine()) != null){
                resposta.append(linha);
            }

            if(resposta.length() == 0){
                return null;
            }

            if(connection != null){
                connection.disconnect();
            }

            if(reader != null){
                reader.close();
            }

            return resposta.toString();

        }catch (Exception erro){
            System.out.println("POST: " + erro.getMessage());
            return null;
        }
    }

}
