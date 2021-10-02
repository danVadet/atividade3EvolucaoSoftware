package modelo;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Helbert Monteiro
 */
public class Arquivo {
    
    private String       nome;
    private double       tamanhoArquivo;
    private int          tamanhoVetor;
    private String       hashArquivo;
    private List<String> peers;
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public double getTamanhoArquivo(){
        return tamanhoArquivo;
    }
    
    public void setTamanhoArquivo(double tamanhoArquivo){
        this.tamanhoArquivo = tamanhoArquivo;
    }
    
    public int getTamanhoVetor(){
        return tamanhoVetor;
    }
    
    public void setTamanhoVetor(int tamanhoVetor){
        this.tamanhoVetor = tamanhoVetor;
    }
    
    public String getHashArquivo(){
        return hashArquivo;
    }
    
    public void setHashArquivo(String hashArquivo){
        this.hashArquivo = hashArquivo;
    }
    
    public List<String> getPeers(){
        return peers;
    }
    
    public void setPeers(List<String> peers){
        this.peers = peers;
    }
    
}