/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Helbert Monteiro
 */
public class PeerModelo {
    
    private String ip;
    private List<Arquivo> arquivos;
    private boolean disponibilidade;
    
    public PeerModelo(){}
    
    public PeerModelo(String ip, List<Arquivo> arquivos){
        this.ip       = ip;
        this.arquivos = arquivos;
    }
    
    public List<Arquivo> getArquivos() throws IOException, NoSuchAlgorithmException{
        List<Arquivo> listaArquivos = new ArrayList<>();
        
        File diretorio = new File("C:\\ThorEnt");
        File[] arquivos = diretorio.listFiles();
        
        for(int i = 0; i < arquivos.length; i++){
            if(!arquivos[i].isDirectory()){
                Arquivo arquivo = new Arquivo(arquivos[i]);
                listaArquivos.add(arquivo);
            }
        }
        
        return listaArquivos;
    }
    
    public void setIp(String ip){
        this.ip = ip;
    }
    
    public String getIp(){
        return this.ip;
    }
    
    public void setDisponibilidade(boolean disponibilidade){
        this.disponibilidade = disponibilidade;
    }
    
    public boolean getDisponibilidade(){
        return disponibilidade;
    }
    
}
