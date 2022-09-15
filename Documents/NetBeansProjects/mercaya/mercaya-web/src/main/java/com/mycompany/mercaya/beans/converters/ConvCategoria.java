/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercaya.beans.converters;

import com.mycompany.mercaya.controllers.MerCategoriaFacade;
import com.mycompany.mercaya.entities.MerCategoria;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rguamantica
 */
@Named ("convCategoria")
@RequestScoped
public class ConvCategoria implements Converter<MerCategoria> {
    
    @Inject
    private MerCategoriaFacade adminCategoria;

    
    @Override
    public MerCategoria getAsObject(FacesContext fc, UIComponent uic, String valorPantalla) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        MerCategoria categoria=null;
        if(valorPantalla!=null)
        {
           categoria=adminCategoria.consultarPorId(Integer.parseInt(valorPantalla));
        }
        return categoria;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, MerCategoria valorBdd) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String idCategoria="";
        if(valorBdd!=null)
        {
            idCategoria=valorBdd.getCateCodigo().toString();
        }
        return idCategoria;
    }
    
    
}
