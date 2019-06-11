/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class SolDetArticuloPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_solicitud")
    private int idSolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "articulo")
    private int articulo;

    public SolDetArticuloPK() {
    }

    public SolDetArticuloPK(int idSolicitud, int articulo) {
        this.idSolicitud = idSolicitud;
        this.articulo = articulo;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
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
        hash += (int) idSolicitud;
        hash += (int) articulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolDetArticuloPK)) {
            return false;
        }
        SolDetArticuloPK other = (SolDetArticuloPK) object;
        if (this.idSolicitud != other.idSolicitud) {
            return false;
        }
        if (this.articulo != other.articulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SolDetArticuloPK[ idSolicitud=" + idSolicitud + ", articulo=" + articulo + " ]";
    }
    
}
