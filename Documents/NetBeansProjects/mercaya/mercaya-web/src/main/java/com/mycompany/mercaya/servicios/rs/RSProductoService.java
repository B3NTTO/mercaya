/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercaya.servicios.rs;

import com.mycompany.mercaya.controllers.MerProductoFacade;
import com.mycompany.mercaya.entities.MerProducto;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rguamantica
 */
@Path("producto-rs")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class RSProductoService {
    
    @Inject
    private MerProductoFacade adminProducto;

    @POST
    @Path("/opeGua")
    public String guardar(MerProducto producto) {
        try {
            adminProducto.guardar(producto);
            return "Producto guardado correctamente";
        } catch (Exception e) {
            return "Error al guardar el producto:" + e.getMessage();
        }
    }

    @PUT
    public String actualizar(MerProducto producto) {
        try {
            adminProducto.actualizar(producto);
            return "Producto actualizado correctamente";
        } catch (Exception e) {
            return "Error al actualizar el producto:" + e.getMessage();
        }
    }

    @PATCH
    public String actualizarParcial(MerProducto producto) {
        try {
            adminProducto.actualizar(producto);
            return "Producto actualizado correctamente";
        } catch (Exception e) {
            return "Error al actualizar el producto:" + e.getMessage();
        }
    }

    @GET
    public List<MerProducto> ConsultarTodos() {
        return adminProducto.ConsultarTodos();
    }

    @GET
    @Path("/{id}")
    public MerProducto consultarPorId(@PathParam("id") Integer id) {
        return adminProducto.consultarPorId(id);
    }

    @DELETE
    @Path("/{id}")
    public String eliminar(@PathParam("id") Integer id) {
        try {
            adminProducto.eliminar(adminProducto.consultarPorId(id));
            return "Producto eliminado correctamente";
        } catch (Exception e) {
            return "Error al eliminar el producto:" + e.getMessage();
        }
    }
    
    
}
