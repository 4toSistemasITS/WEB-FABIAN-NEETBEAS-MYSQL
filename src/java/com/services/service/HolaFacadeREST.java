/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.service;

import com.model.Hola;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Bianca_Valentina
 */
@Stateless
@Path("com.model.hola")
public class HolaFacadeREST extends AbstractFacade<Hola> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    public HolaFacadeREST() {
        super(Hola.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Hola entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Hola entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Hola find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Hola> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Hola> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @POST
    @Path ("consultarValidos")
    @Produces ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Hola> consultarValidos(@PathParam("eliminado")boolean eliminado){
        List<Hola> retorno=obtenerporeliminado(eliminado);
        return retorno;
    }
    
    //nuevo

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
     
    
    List<Hola> obtenerporeliminado (boolean valor){
        TypedQuery<Hola>qry;
        qry=getEntityManager().createQuery("SELECT h FROM Hola h WHERE h.eliminar = :eliminar",Hola.class);
        qry.setParameter("eliminar", valor);
        try {
            return qry.getResultList();
        } catch (Exception e) {
            return null;
        }
            
        
        
        
        
}

    
}
