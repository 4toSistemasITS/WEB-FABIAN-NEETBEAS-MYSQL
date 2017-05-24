/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bianca_Valentina
 */
@Stateless
public class HolaFacade extends AbstractFacade<Hola> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HolaFacade() {
        super(Hola.class);
    }
    
}
