/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.compra;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 20162645
 */
@Entity
@Table(name = "sol_enc_articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolEncArticulo.findAll", query = "SELECT s FROM SolEncArticulo s")
    , @NamedQuery(name = "SolEncArticulo.findByIdSolicitud", query = "SELECT s FROM SolEncArticulo s WHERE s.idSolicitud = :idSolicitud")
    , @NamedQuery(name = "SolEncArticulo.findByFecSol", query = "SELECT s FROM SolEncArticulo s WHERE s.fecSol = :fecSol")
    , @NamedQuery(name = "SolEncArticulo.findByEstado", query = "SELECT s FROM SolEncArticulo s WHERE s.estado = :estado")})
public class SolEncArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_solicitud")
    private Integer idSolicitud;
    @Column(name = "fec_sol")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecSol;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solEncArticulo")
    private Collection<SolDetArticulo> solDetArticuloCollection;
    @JoinColumn(name = "emp_sol", referencedColumnName = "id_empleado")
    @ManyToOne
    private Empleado empSol;
    @JoinColumn(name = "id_prov", referencedColumnName = "id_proveedor")
    @ManyToOne
    private Proveedor idProv;

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

    @XmlTransient
    public Collection<SolDetArticulo> getSolDetArticuloCollection() {
        return solDetArticuloCollection;
    }

    public void setSolDetArticuloCollection(Collection<SolDetArticulo> solDetArticuloCollection) {
        this.solDetArticuloCollection = solDetArticuloCollection;
    }

    public Empleado getEmpSol() {
        return empSol;
    }

    public void setEmpSol(Empleado empSol) {
        this.empSol = empSol;
    }

    public Proveedor getIdProv() {
        return idProv;
    }

    public void setIdProv(Proveedor idProv) {
        this.idProv = idProv;
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
        return "com.gestion.compra.SolEncArticulo[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
