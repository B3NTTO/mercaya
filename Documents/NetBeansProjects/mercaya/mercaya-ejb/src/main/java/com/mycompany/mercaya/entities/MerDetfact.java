/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercaya.entities;

import java.io.Serializable;
import java.math.BigInteger;
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

/**
 *
 * @author rguamantica
 */
@Entity
@Table(name = "mer_detfact")
@NamedQueries({
    @NamedQuery(name = "MerDetfact.findAll", query = "SELECT m FROM MerDetfact m"),
    @NamedQuery(name = "MerDetfact.findByDetaCodigo", query = "SELECT m FROM MerDetfact m WHERE m.detaCodigo = :detaCodigo"),
    @NamedQuery(name = "MerDetfact.findByDetaCantidad", query = "SELECT m FROM MerDetfact m WHERE m.detaCantidad = :detaCantidad"),
    @NamedQuery(name = "MerDetfact.findByCafaPrecio", query = "SELECT m FROM MerDetfact m WHERE m.cafaPrecio = :cafaPrecio"),
    @NamedQuery(name = "MerDetfact.findByCafaDescuento", query = "SELECT m FROM MerDetfact m WHERE m.cafaDescuento = :cafaDescuento")})
public class MerDetfact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deta_codigo")
    private Integer detaCodigo;
    @Column(name = "deta_cantidad")
    private BigInteger detaCantidad;
    @Column(name = "cafa_precio")
    private BigInteger cafaPrecio;
    @Column(name = "cafa_descuento")
    private BigInteger cafaDescuento;
    @JoinColumn(name = "cafa_codigo", referencedColumnName = "cafa_codigo")
    @ManyToOne
    private MerCabfact cafaCodigo;

    public MerDetfact() {
    }

    public MerDetfact(Integer detaCodigo) {
        this.detaCodigo = detaCodigo;
    }

    public Integer getDetaCodigo() {
        return detaCodigo;
    }

    public void setDetaCodigo(Integer detaCodigo) {
        this.detaCodigo = detaCodigo;
    }

    public BigInteger getDetaCantidad() {
        return detaCantidad;
    }

    public void setDetaCantidad(BigInteger detaCantidad) {
        this.detaCantidad = detaCantidad;
    }

    public BigInteger getCafaPrecio() {
        return cafaPrecio;
    }

    public void setCafaPrecio(BigInteger cafaPrecio) {
        this.cafaPrecio = cafaPrecio;
    }

    public BigInteger getCafaDescuento() {
        return cafaDescuento;
    }

    public void setCafaDescuento(BigInteger cafaDescuento) {
        this.cafaDescuento = cafaDescuento;
    }

    public MerCabfact getCafaCodigo() {
        return cafaCodigo;
    }

    public void setCafaCodigo(MerCabfact cafaCodigo) {
        this.cafaCodigo = cafaCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detaCodigo != null ? detaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MerDetfact)) {
            return false;
        }
        MerDetfact other = (MerDetfact) object;
        if ((this.detaCodigo == null && other.detaCodigo != null) || (this.detaCodigo != null && !this.detaCodigo.equals(other.detaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mercaya.entities.MerDetfact[ detaCodigo=" + detaCodigo + " ]";
    }
    
}
