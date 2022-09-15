/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.mercaya.servicios.ws;

import com.mycompany.mercaya.controllers.MerProductoFacade;
import com.mycompany.mercaya.entities.MerProducto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author rguamantica
 */
//WS SOAP
@WebService(name = "ServiceProducto")
public class WSProducto {

    @Resource
    WebServiceContext wsctx;
        
     @Inject
    private MerProductoFacade adminProducto;
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    
    
    @WebMethod
    public String guardarProducto(MerProducto producto) {
        String mensaje =  null;
        try {
            MessageContext mctx = wsctx.getMessageContext();

            Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
            List<String> usuario = (List<String>) http_headers.get("username");
            List<String> password = (List<String>) http_headers.get("password");

            if (usuario != null && usuario.get(0).equals("rguamantica") && password != null && password.get(0).equals("1234")) {

                adminProducto.guardar(producto);
                mensaje = "Producto guardado correctamente";
                return mensaje;
            } else {
                return "Usuario Incorrecto";
            }
        } catch (Exception e) {
            mensaje = "Error al guardar un producto:" + e.getMessage();
        }
        return mensaje;
    }
    
    
    @WebMethod
    public String actualizarProducto(MerProducto producto) {
        String mensaje = null;
        try {
            adminProducto.actualizar(producto);
            mensaje = "Producto guardado correctamente";
        } catch (Exception e) {
            mensaje = "Error al guardar un producto:" + e.getMessage();
        }
        return mensaje;
    }
    
    @WebMethod
    public String eliminar(@WebParam(name = "idProducto ") Integer idProducto) {
        String mensaje = null;
        try {
            adminProducto.eliminar(adminProducto.consultarPorId(idProducto));
            mensaje = "Producto eliminado correctamente";
        } catch (Exception e) {
            mensaje = "Error al eliminar un producto:" + e.getMessage();
        }
        return mensaje;
    }


    @WebMethod(operationName = "consultarTodos")
    public List<MerProducto> consultar() throws Exception {
        List<MerProducto> productos = new ArrayList<>();
        try {
            productos = adminProducto.ConsultarTodos();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return productos;
    }

    
}
