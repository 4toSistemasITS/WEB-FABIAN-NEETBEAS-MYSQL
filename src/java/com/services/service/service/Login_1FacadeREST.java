/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.service.service;

import com.model.Hola;
import com.model.Login_1;
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
@Path("com.model.login_1")
public class Login_1FacadeREST extends AbstractFacade<Login_1> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    public Login_1FacadeREST() {
        super(Login_1.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Login_1 entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Login_1 entity) {
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
    public Login_1 find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Login_1> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Login_1> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    public List<Login_1> consultarValidos(@PathParam("clave")boolean clave){
        List<Login_1> retorno=obtenerlogin(clave);
        return retorno;
    }
    
    
    
//       @POST
//    @Path ("consultarValidos")
//    @Produces ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
//    public List<Hola> consultarValidos(@PathParam("eliminado")boolean eliminado){
//        List<Hola> retorno=obtenerporeliminado(eliminado);
//        return retorno;
//    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    List<Login_1>obtenerlogin(boolean valor){
        TypedQuery<Login_1>qry;
        qry=getEntityManager().createQuery("SELECT l FROM Login_1 l WHERE l.contrase\u00f1a = :contrase\u00f1a",Login_1.class);
        qry.setParameter("contrase\u00f1a", valor);
        try {
            return qry.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
