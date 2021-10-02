package Modelo;

import Controle.TorrentFilesManage;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
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
    
    private String           nome;
    private double           tamanhoArquivo;
    private int              tamanhoVetor;
    private String           hashArquivo;
    private List<String>     peers;
    
    public Arquivo(File file) throws IOException, NoSuchAlgorithmException{
        this.nome           = file.getName();
        this.tamanhoArquivo = file.length() / 1024 + 1;
        this.tamanhoVetor   = (int) file.length();
        this.hashArquivo    = new TorrentFilesManage().getHashCode(new TorrentFilesManage().createFullArrayFromFile(file));
    }
    
    public Arquivo(){}
    
    public String getNome(){
        return nome;
    }
    
    public String getHashArquivo() {
        return hashArquivo;
    }

    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }
    
    public List<String> getPeer(){
        return peers;
    }
    
    public int getTamanhoVetor(){
        return tamanhoVetor;
    }
    
	public List<PeerModelo> getPeersList() {
		List<PeerModelo> peers = new ArrayList<>();

        for(int i = 0; i < this.getPeer().size(); i ++){
        	PeerModelo peer = new PeerModelo();
        	
            peer.setIp(this.getPeer().get(i));
            peer.setDisponibilidade(true);
            peers.add(peer);
        }
		return peers;
	}
}