/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import DAO.TrackerDAO;
import controle.ConexaoWeb;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import modelo.Arquivo;
import modelo.Peer;

/**
 *
 * @author Helbert Monteiro
 */
public class TrackerAplicacao{
    
    public static void main(String[] args) throws InterruptedException{
        
        new TrackerDAO().limparPeer();
        
        /*List<String> peers = new ArrayList<>();
        Thread thread;
        while(true){
            peers = new TrackerDAO().listarPeer();
            if(!peers.isEmpty()){
                for(int i = 0; i < peers.size(); i++){
                    String ip = peers.get(i);
                    System.out.println("Ip verificado: " + ip);
                    thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String url = "http://"+ip+":8080/Peer/webresources/peer/disponivel/";
                            if(!Boolean.parseBoolean(new ConexaoWeb().conectaWebService(url, null, "GET"))){
                                System.out.println("Ip off... deletando " + ip);
                                new TrackerDAO().deletaPeer(ip);
                            }
                        }
                    });
                    thread.start();
                    thread.sleep(5000);
                }
            }
        }*/
    }
    
}
