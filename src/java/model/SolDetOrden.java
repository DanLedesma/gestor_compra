/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author grego
 */
@Entity
@Table(name = "sol_det_orden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolDetOrden.findAll", query = "SELECT s FROM SolDetOrden s")
    , @NamedQuery(name = "SolDetOrden.findByIdOrden", query = "SELECT s FROM SolDetOrden s WHERE s.solDetOrdenPK.idOrden = :idOrden")
    , @NamedQuery(name = "SolDetOrden.findByArticulo", query = "SELECT s FROM SolDetOrden s WHERE s.solDetOrdenPK.articulo = :articulo")
    , @NamedQuery(name = "SolDetOrden.findByCantidad", query = "SELECT s FROM SolDetOrden s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "SolDetOrden.findByUnidadMed", query = "SELECT s FROM SolDetOrden s WHERE s.unidadMed = :unidadMed")
    , @NamedQuery(name = "SolDetOrden.findByMarca", query = "SELECT s FROM SolDetOrden s WHERE s.marca = :marca")
    , @NamedQuery(name = "SolDetOrden.findByCostoUni", query = "SELECT s FROM SolDetOrden s WHERE s.costoUni = :costoUni")})
public class SolDetOrden implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SolDetOrdenPK solDetOrdenPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "unidad_med")
    private Integer unidadMed;
    @Column(name = "marca")
    private Integer marca;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_uni")
    private BigDecimal costoUni;

    public SolDetOrden() {
    }

    public SolDetOrden(SolDetOrdenPK solDetOrdenPK) {
        this.solDetOrdenPK = solDetOrdenPK;
    }

    public SolDetOrden(int idOrden, int articulo) {
        this.solDetOrdenPK = new SolDetOrdenPK(idOrden, articulo);
    }

    public SolDetOrdenPK getSolDetOrdenPK() {
        return solDetOrdenPK;
    }

    public void setSolDetOrdenPK(SolDetOrdenPK solDetOrdenPK) {
        this.solDetOrdenPK = solDetOrdenPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getUnidadMed() {
        return unidadMed;
    }

    public void setUnidadMed(Integer unidadMed) {
        this.unidadMed = unidadMed;
    }

    public Integer getMarca() {
        return marca;
    }

    public void setMarca(Integer marca) {
        this.marca = marca;
    }

    public BigDecimal getCostoUni() {
        return costoUni;
    }

    public void setCostoUni(BigDecimal costoUni) {
        this.costoUni = costoUni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solDetOrdenPK != null ? solDetOrdenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolDetOrden)) {
            return false;
        }
        SolDetOrden other = (SolDetOrden) object;
        if ((this.solDetOrdenPK == null && other.solDetOrdenPK != null) || (this.solDetOrdenPK != null && !this.solDetOrdenPK.equals(other.solDetOrdenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SolDetOrden[ solDetOrdenPK=" + solDetOrdenPK + " ]";
    }
    
}
