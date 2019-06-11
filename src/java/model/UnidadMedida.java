/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author grego
 */
@Entity
@Table(name = "unidad_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadMedida.findAll", query = "SELECT u FROM UnidadMedida u")
    , @NamedQuery(name = "UnidadMedida.findByIdUnidades", query = "SELECT u FROM UnidadMedida u WHERE u.idUnidades = :idUnidades")
    , @NamedQuery(name = "UnidadMedida.findByDescripcion", query = "SELECT u FROM UnidadMedida u WHERE u.descripcion = :descripcion")
    , @NamedQuery(name = "UnidadMedida.findByEstado", query = "SELECT u FROM UnidadMedida u WHERE u.estado = :estado")})
public class UnidadMedida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_unidades")
    private Integer idUnidades;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;

    public UnidadMedida() {
    }

    public UnidadMedida(Integer idUnidades) {
        this.idUnidades = idUnidades;
    }

    public Integer getIdUnidades() {
        return idUnidades;
    }

    public void setIdUnidades(Integer idUnidades) {
        this.idUnidades = idUnidades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idUnidades != null ? idUnidades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadMedida)) {
            return false;
        }
        UnidadMedida other = (UnidadMedida) object;
        if ((this.idUnidades == null && other.idUnidades != null) || (this.idUnidades != null && !this.idUnidades.equals(other.idUnidades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UnidadMedida[ idUnidades=" + idUnidades + " ]";
    }
    
}
