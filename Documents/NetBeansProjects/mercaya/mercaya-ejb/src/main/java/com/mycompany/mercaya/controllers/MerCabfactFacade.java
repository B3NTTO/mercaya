/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercaya.controllers;

import com.mycompany.mercaya.entities.MerCabfact;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rguamantica
 */
@Stateless
public class MerCabfactFacade extends AbstractFacade<MerCabfact> {

    @PersistenceContext(unitName = "mercayaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MerCabfactFacade() {
        super(MerCabfact.class);
    }
    
}
