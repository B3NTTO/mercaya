/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercaya.entities;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rguamantica
 */

@Entity

@XmlRootElement
@Table(name = "mer_categoria", schema="rguamantica")
@NamedQueries({
    @NamedQuery(name = "MerCategoria.findAll", query = "SELECT m FROM MerCategoria m"),
    @NamedQuery(name = "MerCategoria.findByCateCodigo", query = "SELECT m FROM MerCategoria m WHERE m.cateCodigo = :cateCodigo"),
    @NamedQuery(name = "MerCategoria.findByCateNombre", query = "SELECT m FROM MerCategoria m WHERE m.cateNombre = :cateNombre"),
    @NamedQuery(name = "MerCategoria.findByCateDescrip", query = "SELECT m FROM MerCategoria m WHERE m.cateDescrip = :cateDescrip")})
public class MerCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cate_codigo")
    private Integer cateCodigo;
    @Column(name = "cate_nombre")
    private String cateNombre;
    @Column(name = "cate_descrip")
    private String cateDescrip;
    @OneToMany(mappedBy = "cateCodigo")
    private List<MerProducto> merProductoList;

    public MerCategoria() {
    }

    public MerCategoria(Integer cateCodigo) {
        this.cateCodigo = cateCodigo;
    }

    public Integer getCateCodigo() {
        return cateCodigo;
    }

    public void setCateCodigo(Integer cateCodigo) {
        this.cateCodigo = cateCodigo;
    }

    public String getCateNombre() {
        return cateNombre;
    }

    public void setCateNombre(String cateNombre) {
        this.cateNombre = cateNombre;
    }

    public String getCateDescrip() {
        return cateDescrip;
    }

    public void setCateDescrip(String cateDescrip) {
        this.cateDescrip = cateDescrip;
    }

    public List<MerProducto> getMerProductoList() {
        return merProductoList;
    }
    @XmlTransient //SOAP
    @JsonbTransient //REST
    public void setMerProductoList(List<MerProducto> merProductoList) {
        this.merProductoList = merProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cateCodigo != null ? cateCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MerCategoria)) {
            return false;
        }
        MerCategoria other = (MerCategoria) object;
        if ((this.cateCodigo == null && other.cateCodigo != null) || (this.cateCodigo != null && !this.cateCodigo.equals(other.cateCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mercaya.entities.MerCategoria[ cateCodigo=" + cateCodigo + " ]";
    }
    
}
