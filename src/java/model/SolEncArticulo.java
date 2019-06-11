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
@Table(name = "sol_enc_articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolEncArticulo.findAll", query = "SELECT s FROM SolEncArticulo s")
    , @NamedQuery(name = "SolEncArticulo.findByIdSolicitud", query = "SELECT s FROM SolEncArticulo s WHERE s.idSolicitud = :idSolicitud")
    , @NamedQuery(name = "SolEncArticulo.findByIdProv", query = "SELECT s FROM SolEncArticulo s WHERE s.idProv = :idProv")
    , @NamedQuery(name = "SolEncArticulo.findByEmpSol", query = "SELECT s FROM SolEncArticulo s WHERE s.empSol = :empSol")
    , @NamedQuery(name = "SolEncArticulo.findByFecSol", query = "SELECT s FROM SolEncArticulo s WHERE s.fecSol = :fecSol")
    , @NamedQuery(name = "SolEncArticulo.findByEstado", query = "SELECT s FROM SolEncArticulo s WHERE s.estado = :estado")})
public class SolEncArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_solicitud")
    private Integer idSolicitud;
    @Column(name = "id_prov")
    private Integer idProv;
    @Column(name = "emp_sol")
    private Integer empSol;
    @Column(name = "fec_sol")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecSol;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;

    public SolEncArticulo() {
    }

    public SolEncArticulo(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Integer getIdProv() {
        return idProv;
    }

    public void setIdProv(Integer idProv) {
        this.idProv = idProv;
    }

    public Integer getEmpSol() {
        return empSol;
    }

    public void setEmpSol(Integer empSol) {
        this.empSol = empSol;
    }

    public Date getFecSol() {
        return fecSol;
    }

    public void setFecSol(Date fecSol) {
        this.fecSol = fecSol;
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
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolEncArticulo)) {
            return false;
        }
        SolEncArticulo other = (SolEncArticulo) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SolEncArticulo[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
