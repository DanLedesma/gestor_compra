/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author grego
 */
@Entity
@Table(name = "sol_det_articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolDetArticulo.findAll", query = "SELECT s FROM SolDetArticulo s")
    , @NamedQuery(name = "SolDetArticulo.findByIdSolicitud", query = "SELECT s FROM SolDetArticulo s WHERE s.solDetArticuloPK.idSolicitud = :idSolicitud")
    , @NamedQuery(name = "SolDetArticulo.findByArticulo", query = "SELECT s FROM SolDetArticulo s WHERE s.solDetArticuloPK.articulo = :articulo")
    , @NamedQuery(name = "SolDetArticulo.findByCantidad", query = "SELECT s FROM SolDetArticulo s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "SolDetArticulo.findByUnidadMed", query = "SELECT s FROM SolDetArticulo s WHERE s.unidadMed = :unidadMed")})
public class SolDetArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SolDetArticuloPK solDetArticuloPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "unidad_med")
    private Integer unidadMed;
    @JoinColumn(name = "articulo", referencedColumnName = "id_articulo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Articulo articulo1;
    @JoinColumn(name = "id_solicitud", referencedColumnName = "id_solicitud", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SolEncArticulo solEncArticulo;

    public SolDetArticulo() {
    }

    public SolDetArticulo(SolDetArticuloPK solDetArticuloPK) {
        this.solDetArticuloPK = solDetArticuloPK;
    }

    public SolDetArticulo(int idSolicitud, int articulo) {
        this.solDetArticuloPK = new SolDetArticuloPK(idSolicitud, articulo);
    }

    public SolDetArticuloPK getSolDetArticuloPK() {
        return solDetArticuloPK;
    }

    public void setSolDetArticuloPK(SolDetArticuloPK solDetArticuloPK) {
        this.solDetArticuloPK = solDetArticuloPK;
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

    public Articulo getArticulo1() {
        return articulo1;
    }

    public void setArticulo1(Articulo articulo1) {
        this.articulo1 = articulo1;
    }

    public SolEncArticulo getSolEncArticulo() {
        return solEncArticulo;
    }

    public void setSolEncArticulo(SolEncArticulo solEncArticulo) {
        this.solEncArticulo = solEncArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solDetArticuloPK != null ? solDetArticuloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolDetArticulo)) {
            return false;
        }
        SolDetArticulo other = (SolDetArticulo) object;
        if ((this.solDetArticuloPK == null && other.solDetArticuloPK != null) || (this.solDetArticuloPK != null && !this.solDetArticuloPK.equals(other.solDetArticuloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SolDetArticulo[ solDetArticuloPK=" + solDetArticuloPK + " ]";
    }
    
}
