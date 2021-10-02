/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import Controle.TorrentFilesManage;
import Modelo.Arquivo;
import Modelo.ArquivoDownload;
import Modelo.Listas;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Raphael Felipe
 */
@Path("peer")
public class Peer {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Peer
     */
    public Peer() {
    }

    /**
     * Retrieves representation of an instance of webservice.Peer
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of Peer
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @Path("/lista")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listar() throws IOException, NoSuchAlgorithmException{
        
        List<Arquivo> listaArquivos = new ArrayList<>();
        
        File diretorio = new File("C:\\ThorEnt");
        File[] arquivos = diretorio.listFiles();
        
        for(int i = 0; i < arquivos.length; i++){
            Arquivo arquivo = new Arquivo(arquivos[i]);
            listaArquivos.add(arquivo);
        }
        
        return new Gson().toJson(listaArquivos);   
    }
    
    @Path("/download/{tamanho_bloco}/{inicio_bloco}/{hashArquivo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String download(@PathParam("tamanho_bloco") int tamanho_bloco, @PathParam("hashArquivo") String hashArquivo, @PathParam("inicio_bloco") int inicio_bloco) throws IOException, NoSuchAlgorithmException{
        //int tamanho_bloco = TorrentFilesManage.TAMANHO_BLOCO;
        System.out.println(inicio_bloco);
        byte[] vetor_arquivo = new TorrentFilesManage().createFullArrayFromFile(new TorrentFilesManage().getFileByHash(hashArquivo));
        byte[] vetor = new byte[tamanho_bloco];
        for(int i = 0; i < tamanho_bloco; i++){
            if(inicio_bloco < vetor_arquivo.length){
                vetor[i] = vetor_arquivo[inicio_bloco];
                inicio_bloco++;
            }
        }
        
        return new Gson().toJson(new ArquivoDownload(new TorrentFilesManage().getHashCode(vetor), vetor));
        
        
        //return new TorrentFilesManage().downloadBytesFile(hashArquivo);
    }
    
    @Path("disponivel")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String disponibilidade(){
        return "true";
    }
    
    @Path("salvar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String salvarLista(String jsonLista){
        Type typeLista = new TypeToken<ArrayList<Arquivo>>(){}.getType();
        Listas.LISTA_ARQUIVOS = new Gson().fromJson(jsonLista, typeLista);
        return "true";
    }
}
