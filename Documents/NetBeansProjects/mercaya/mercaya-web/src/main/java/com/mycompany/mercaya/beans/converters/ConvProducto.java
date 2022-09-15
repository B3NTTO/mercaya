/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercaya.beans.converters;

import com.mycompany.mercaya.controllers.MerProductoFacade;
import com.mycompany.mercaya.entities.MerProducto;
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
@Named ("convProducto")
@RequestScoped
public class ConvProducto implements Converter<MerProducto> {
    
     @Inject
    private MerProductoFacade adminProducto;

    @Override
    public MerProducto getAsObject(FacesContext fc, UIComponent uic, String valorPantalla) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                MerProducto producto=null;
        if(valorPantalla!=null)
        {
           producto=adminProducto.consultarPorId(Integer.parseInt(valorPantalla));
        }
        return producto;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, MerProducto valorBdd) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                String idProducto="";
        if(valorBdd!=null)
        {
            idProducto=valorBdd.getProdCodigo().toString();
        }
        return idProducto;
    }
    
}
