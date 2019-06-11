/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author grego
 */
@Entity
@Table(name = "sol_enc_orden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolEncOrden.findAll", query = "SELECT s FROM SolEncOrden s")
    , @NamedQuery(name = "SolEncOrden.findByIdOrden", query = "SELECT s FROM SolEncOrden s WHERE s.idOrden = :idOrden")
    , @NamedQuery(name = "SolEncOrden.findByIdSol", query = "SELECT s FROM SolEncOrden s WHERE s.idSol = :idSol")
    , @NamedQuery(name = "SolEncOrden.findByFecOrd", query = "SELECT s FROM SolEncOrden s WHERE s.fecOrd = :fecOrd")
    , @NamedQuery(name = "SolEncOrden.findByEstado", query = "SELECT s FROM SolEncOrden s WHERE s.estado = :estado")})
public class SolEncOrden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden")
    private Integer idOrden;
    @Column(name = "id_sol")
    private Integer idSol;
    @Column(name = "fec_ord")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecOrd;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;

    public SolEncOrden() {
    }

    public SolEncOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Integer getIdSol() {
        return idSol;
    }

    public void setIdSol(Integer idSol) {
        this.idSol = idSol;
    }

    public Date getFecOrd() {
        return fecOrd;
    }

    public void setFecOrd(Date fecOrd) {
        this.fecOrd = fecOrd;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolEncOrden)) {
            return false;
        }
        SolEncOrden other = (SolEncOrden) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SolEncOrden[ idOrden=" + idOrden + " ]";
    }
    
}
