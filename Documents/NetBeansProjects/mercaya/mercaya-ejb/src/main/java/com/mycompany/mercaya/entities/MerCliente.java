/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercaya.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rguamantica
 */
@Entity
@Table(name = "mer_cliente")
@NamedQueries({
    @NamedQuery(name = "MerCliente.findAll", query = "SELECT m FROM MerCliente m"),
    @NamedQuery(name = "MerCliente.findByClieCodigo", query = "SELECT m FROM MerCliente m WHERE m.clieCodigo = :clieCodigo"),
    @NamedQuery(name = "MerCliente.findByClieNombres", query = "SELECT m FROM MerCliente m WHERE m.clieNombres = :clieNombres"),
    @NamedQuery(name = "MerCliente.findByClieApellidos", query = "SELECT m FROM MerCliente m WHERE m.clieApellidos = :clieApellidos"),
    @NamedQuery(name = "MerCliente.findByClieDireccion", query = "SELECT m FROM MerCliente m WHERE m.clieDireccion = :clieDireccion"),
    @NamedQuery(name = "MerCliente.findByClieTelefono", query = "SELECT m FROM MerCliente m WHERE m.clieTelefono = :clieTelefono"),
    @NamedQuery(name = "MerCliente.findByClieCorreo", query = "SELECT m FROM MerCliente m WHERE m.clieCorreo = :clieCorreo")})
public class MerCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clie_codigo")
    private Integer clieCodigo;
    @Column(name = "clie_nombres")
    private Serializable clieNombres;
    @Column(name = "clie_apellidos")
    private Serializable clieApellidos;
    @Column(name = "clie_direccion")
    private Serializable clieDireccion;
    @Column(name = "clie_telefono")
    private Serializable clieTelefono;
    @Column(name = "clie_correo")
    private Serializable clieCorreo;
    @OneToMany(mappedBy = "clieCodigo")
    private List<MerCabfact> merCabfactList;

    public MerCliente() {
    }

    public MerCliente(Integer clieCodigo) {
        this.clieCodigo = clieCodigo;
    }

    public Integer getClieCodigo() {
        return clieCodigo;
    }

    public void setClieCodigo(Integer clieCodigo) {
        this.clieCodigo = clieCodigo;
    }

    public Serializable getClieNombres() {
        return clieNombres;
    }

    public void setClieNombres(Serializable clieNombres) {
        this.clieNombres = clieNombres;
    }

    public Serializable getClieApellidos() {
        return clieApellidos;
    }

    public void setClieApellidos(Serializable clieApellidos) {
        this.clieApellidos = clieApellidos;
    }

    public Serializable getClieDireccion() {
        return clieDireccion;
    }

    public void setClieDireccion(Serializable clieDireccion) {
        this.clieDireccion = clieDireccion;
    }

    public Serializable getClieTelefono() {
        return clieTelefono;
    }

    public void setClieTelefono(Serializable clieTelefono) {
        this.clieTelefono = clieTelefono;
    }

    public Serializable getClieCorreo() {
        return clieCorreo;
    }

    public void setClieCorreo(Serializable clieCorreo) {
        this.clieCorreo = clieCorreo;
    }

    public List<MerCabfact> getMerCabfactList() {
        return merCabfactList;
    }

    public void setMerCabfactList(List<MerCabfact> merCabfactList) {
        this.merCabfactList = merCabfactList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clieCodigo != null ? clieCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MerCliente)) {
            return false;
        }
        MerCliente other = (MerCliente) object;
        if ((this.clieCodigo == null && other.clieCodigo != null) || (this.clieCodigo != null && !this.clieCodigo.equals(other.clieCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mercaya.entities.MerCliente[ clieCodigo=" + clieCodigo + " ]";
    }
    
}
