/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercaya.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rguamantica
 */
@Entity
@Table(name = "mer_producto")
@NamedQueries({
    @NamedQuery(name = "MerProducto.findAll", query = "SELECT m FROM MerProducto m"),
    @NamedQuery(name = "MerProducto.findByProdCodigo", query = "SELECT m FROM MerProducto m WHERE m.prodCodigo = :prodCodigo"),
    @NamedQuery(name = "MerProducto.findByProdNombre", query = "SELECT m FROM MerProducto m WHERE m.prodNombre = :prodNombre"),
    @NamedQuery(name = "MerProducto.findByProdPrecio", query = "SELECT m FROM MerProducto m WHERE m.prodPrecio = :prodPrecio"),
    @NamedQuery(name = "MerProducto.findByProdFecelab", query = "SELECT m FROM MerProducto m WHERE m.prodFecelab = :prodFecelab"),
    @NamedQuery(name = "MerProducto.findByProdFecvenc", query = "SELECT m FROM MerProducto m WHERE m.prodFecvenc = :prodFecvenc")})
public class MerProducto implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "prod_nombre")
    private Serializable prodNombre;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prod_codigo")
    private Integer prodCodigo;
    @Column(name = "prod_precio")
    private BigInteger prodPrecio;
    @Column(name = "prod_fecelab")
    @Temporal(TemporalType.DATE)
    private Date prodFecelab;
    @Column(name = "prod_fecvenc")
    @Temporal(TemporalType.DATE)
    private Date prodFecvenc;
    @JoinColumn(name = "cate_codigo", referencedColumnName = "cate_codigo")
    @ManyToOne
    private MerCategoria cateCodigo;

    public MerProducto() {
    }

    public MerProducto(Integer prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    public MerProducto(Integer prodCodigo, Serializable prodNombre) {
        this.prodCodigo = prodCodigo;
        this.prodNombre = prodNombre;
    }

    public Integer getProdCodigo() {
        return prodCodigo;
    }

    public void setProdCodigo(Integer prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    public Serializable getProdNombre() {
        return prodNombre;
    }

    public void setProdNombre(Serializable prodNombre) {
        this.prodNombre = prodNombre;
    }

    public BigInteger getProdPrecio() {
        return prodPrecio;
    }

    public void setProdPrecio(BigInteger prodPrecio) {
        this.prodPrecio = prodPrecio;
    }

    public Date getProdFecelab() {
        return prodFecelab;
    }

    public void setProdFecelab(Date prodFecelab) {
        this.prodFecelab = prodFecelab;
    }

    public Date getProdFecvenc() {
        return prodFecvenc;
    }

    public void setProdFecvenc(Date prodFecvenc) {
        this.prodFecvenc = prodFecvenc;
    }

    public MerCategoria getCateCodigo() {
        return cateCodigo;
    }

    public void setCateCodigo(MerCategoria cateCodigo) {
        this.cateCodigo = cateCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodCodigo != null ? prodCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MerProducto)) {
            return false;
        }
        MerProducto other = (MerProducto) object;
        if ((this.prodCodigo == null && other.prodCodigo != null) || (this.prodCodigo != null && !this.prodCodigo.equals(other.prodCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mercaya.entities.MerProducto[ prodCodigo=" + prodCodigo + " ]";
    }

  

 
    
}
