/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercaya.beans;

import com.mycompany.mercaya.controllers.MerCategoriaFacade;
import com.mycompany.mercaya.controllers.MerProductoFacade;
import com.mycompany.mercaya.util.AbstractManagedBean;

import com.mycompany.mercaya.entities.MerProducto;
import com.mycompany.mercaya.entities.MerCategoria;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author rguamantica
 */
@Named
@ViewScoped
public class ProductoBean extends AbstractManagedBean implements Serializable{
    
    private MerProducto producto; // Guardar o Actualizar
    private MerProducto productoSel; //Selecccionar el producto desde la tabla
    private List<MerProducto> listaProductos; //Desplegar los prodcutos en la tabla
    private List<SelectItem> listaCategorias;

    public Integer getIdCat() {
        return idCat;
    }

    public void setIdCat(Integer idCat) {
        this.idCat = idCat;
    }
    private Integer idCat;
    
    @Inject //Luego del constructor
    private MerProductoFacade adminProducto;

    @Inject
    private MerCategoriaFacade adminCategoria;
    
    public ProductoBean() {
        this.producto = new MerProducto(); //Encerando un registro de la tabla
        this.listaProductos = new ArrayList<>(); //Encerando la lista
        this.listaCategorias = new ArrayList<>();
    }

    public List<SelectItem> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<SelectItem> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    private void cargarCategorias() {
        adminCategoria.ConsultarTodos().forEach(cat -> this.listaCategorias
                .add(new SelectItem(cat.getCateCodigo(), cat.getCateNombre())));
    }
    
    
    public MerProducto getProducto() {
        return producto;
    }

    public void setProducto(MerProducto producto) {
        this.producto = producto;
    }

    public MerProducto getProductoSel() {
        return productoSel;
    }

    public void setProductoSel(MerProducto productoSel) {
        this.productoSel = productoSel;
    }

    public List<MerProducto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<MerProducto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    
 /**
     * Método para guardar o actualizar
     */
    public void guardar() {
        try {
            if (producto.getProdCodigo()!= null) {
                //Actualizar
                adminProducto.actualizar(producto);
                anadirInfo("Producto actualizado correctamente");
            } else {
                //Guardar
                adminProducto.guardar(producto);
                anadirInfo("Producto guardado correctamente");
            }
            cargarProductos();
            resetearFormulario();
        } catch (Exception e) {
            anadirError("Error al procesar la operación:" + e.getMessage());
        }
    }    
    /**
     * Método para cargar los productos
     */
    private void cargarProductos() {
        this.listaProductos = adminProducto.ConsultarTodos();
    }

 /**
     * Método para seleccionar un producto
     *
     * @param ev
     */
    public void seleccionarFila(SelectEvent<MerProducto> ev) {
        this.productoSel = ev.getObject();
    }

    /**
     * Método para cargar el producto seleccionado
     */
    public void editar() {
        if (productoSel != null) {
            this.producto = productoSel;
        } else {
            anadirError("Se debe seleccionar un producto");
        }
    }

    /**
     * Método para eliminar un producto
     */
    public void eliminar() {
        try {
            if (productoSel != null) {
                adminProducto.eliminar(productoSel);
                cargarProductos();
                resetearFormulario();
            } else {
                anadirError("Se debe seleccionar un producto");
            }
        } catch (Exception e) {
            anadirError("Error al eliminar:" + e.getMessage());
        }
    }

    
        /**
     * Método para resetear el formulario
     */
    public void resetearFormulario() {
        this.producto = new MerProducto();
        this.productoSel = null; //No selección
    }

    /**
     * Método para inicializar el formulario
     */
    @PostConstruct
    public void inicializar() {
        cargarCategorias();
        cargarProductos();
    }


    
    
}
