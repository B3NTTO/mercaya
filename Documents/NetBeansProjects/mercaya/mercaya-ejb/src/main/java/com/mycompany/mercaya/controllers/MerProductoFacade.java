/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercaya.controllers;

import com.mycompany.mercaya.entities.MerProducto;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rguamantica
 */
@TransactionManagement(TransactionManagementType.CONTAINER) //Tx Automático, por defecto
@Stateless
public class MerProductoFacade extends AbstractFacade<MerProducto> {

    @PersistenceContext(unitName = "mercayaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MerProductoFacade() {
        super(MerProducto.class);
    }
    
}