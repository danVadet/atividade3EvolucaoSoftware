/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import DAO.TrackerDAO;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import modelo.Peer;

/**
 * REST Web Service
 *
 * @author Helbert Monteiro
 */
@Path("tracker")
public class TrackerWebService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TrackerResource
     */
    public TrackerWebService() {
    }

    /**
     * Retrieves representation of an instance of webservice.TrackerWebService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of TrackerWebService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @Path("/participar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean participar(String json){
        try{
            return new TrackerDAO().inserirPeer(new Gson().fromJson(json, Peer.class));
        }catch(Exception erro){
            System.out.println("Participar: " + erro.getMessage());
            return false;
        }
    }
    
    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listar(){
        return new Gson().toJson(new TrackerDAO().listarArquivo());
    }    
}
