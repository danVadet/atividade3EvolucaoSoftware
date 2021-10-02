/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Helbert Monteiro
 */
public class ArquivoDownload{
    private String hash;
    private byte[] vetor;
    private String nome;

    public ArquivoDownload(String hash, byte[] vetor){
        this.hash = hash;
        this.vetor = vetor;
    }
    
    

    public ArquivoDownload(){}

    /**
     * @return the hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * @param hash the hash to set
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * @return the vetor
     */
    public byte[] getVetor() {
        return vetor;
    }

    /**
     * @param vetor the vetor to set
     */
    public void setVetor(byte[] vetor) {
        this.vetor = vetor;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
