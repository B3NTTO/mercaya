/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercaya.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rguamantica
 */
@Entity
@Table(name = "mer_cabfact")
@NamedQueries({
    @NamedQuery(name = "MerCabfact.findAll", query = "SELECT m FROM MerCabfact m"),
    @NamedQuery(name = "MerCabfact.findByCafaCodigo", query = "SELECT m FROM MerCabfact m WHERE m.cafaCodigo = :cafaCodigo"),
    @NamedQuery(name = "MerCabfact.findByProdCodigo", query = "SELECT m FROM MerCabfact m WHERE m.prodCodigo = :prodCodigo"),
    @NamedQuery(name = "MerCabfact.findByCafaEmpresa", query = "SELECT m FROM MerCabfact m WHERE m.cafaEmpresa = :cafaEmpresa"),
    @NamedQuery(name = "MerCabfact.findByCafaFecha", query = "SELECT m FROM MerCabfact m WHERE m.cafaFecha = :cafaFecha")})
public class MerCabfact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cafa_codigo")
    private Integer cafaCodigo;
    @Column(name = "prod_codigo")
    private Integer prodCodigo;
    @Column(name = "cafa_empresa")
    private Serializable cafaEmpresa;
    @Column(name = "cafa_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cafaFecha;
    @OneToMany(mappedBy = "cafaCodigo")
    private List<MerDetfact> merDetfactList;
    @JoinColumn(name = "clie_codigo", referencedColumnName = "clie_codigo")
    @ManyToOne
    private MerCliente clieCodigo;

    public MerCabfact() {
    }

    public MerCabfact(Integer cafaCodigo) {
        this.cafaCodigo = cafaCodigo;
    }

    public Integer getCafaCodigo() {
        return cafaCodigo;
    }

    public void setCafaCodigo(Integer cafaCodigo) {
        this.cafaCodigo = cafaCodigo;
    }

    public Integer getProdCodigo() {
        return prodCodigo;
    }

    public void setProdCodigo(Integer prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    public Serializable getCafaEmpresa() {
        return cafaEmpresa;
    }

    public void setCafaEmpresa(Serializable cafaEmpresa) {
        this.cafaEmpresa = cafaEmpresa;
    }

    public Date getCafaFecha() {
        return cafaFecha;
    }

    public void setCafaFecha(Date cafaFecha) {
        this.cafaFecha = cafaFecha;
    }

    public List<MerDetfact> getMerDetfactList() {
        return merDetfactList;
    }

    public void setMerDetfactList(List<MerDetfact> merDetfactList) {
        this.merDetfactList = merDetfactList;
    }

    public MerCliente getClieCodigo() {
        return clieCodigo;
    }

    public void setClieCodigo(MerCliente clieCodigo) {
        this.clieCodigo = clieCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cafaCodigo != null ? cafaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MerCabfact)) {
            return false;
        }
        MerCabfact other = (MerCabfact) object;
        if ((this.cafaCodigo == null && other.cafaCodigo != null) || (this.cafaCodigo != null && !this.cafaCodigo.equals(other.cafaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mercaya.entities.MerCabfact[ cafaCodigo=" + cafaCodigo + " ]";
    }
    
}
