/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author Helbert Monteiro
 */
public class Peer {
    
    private String ip;
    private List<Arquivo> arquivos;
    
    public Peer(String ip, List<Arquivo> arquivos){
        this.ip       = ip;
        this.arquivos = arquivos;
    }
    
    public String getIp(){
        return ip;
    }
    
    public List<Arquivo> getArquivos(){
        return arquivos;
    }

    
}
