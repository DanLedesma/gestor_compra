/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author grego
 */
@Embeddable
public class SolDetOrdenPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_orden")
    private int idOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "articulo")
    private int articulo;

    public SolDetOrdenPK() {
    }

    public SolDetOrdenPK(int idOrden, int articulo) {
        this.idOrden = idOrden;
        this.articulo = articulo;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getArticulo() {
        return articulo;
    }

    public void setArticulo(int articulo) {
        this.articulo = articulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrden;
        hash += (int) articulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolDetOrdenPK)) {
            return false;
        }
        SolDetOrdenPK other = (SolDetOrdenPK) object;
        if (this.idOrden != other.idOrden) {
            return false;
        }
        if (this.articulo != other.articulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SolDetOrdenPK[ idOrden=" + idOrden + ", articulo=" + articulo + " ]";
    }
    
}
