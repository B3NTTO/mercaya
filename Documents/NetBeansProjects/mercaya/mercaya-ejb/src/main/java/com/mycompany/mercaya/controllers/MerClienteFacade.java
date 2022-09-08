/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercaya.controllers;

import com.mycompany.mercaya.entities.MerCliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rguamantica
 */
@Stateless
public class MerClienteFacade extends AbstractFacade<MerCliente> {

    @PersistenceContext(unitName = "mercayaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MerClienteFacade() {
        super(MerCliente.class);
    }
    
}
