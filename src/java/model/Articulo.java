/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author grego
 */
@Entity
@Table(name = "articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a")
    , @NamedQuery(name = "Articulo.findByIdArticulo", query = "SELECT a FROM Articulo a WHERE a.idArticulo = :idArticulo")
    , @NamedQuery(name = "Articulo.findByDescripcion", query = "SELECT a FROM Articulo a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Articulo.findByMarca", query = "SELECT a FROM Articulo a WHERE a.marca = :marca")
    , @NamedQuery(name = "Articulo.findByUnidadMed", query = "SELECT a FROM Articulo a WHERE a.unidadMed = :unidadMed")
    , @NamedQuery(name = "Articulo.findByExistencia", query = "SELECT a FROM Articulo a WHERE a.existencia = :existencia")
    , @NamedQuery(name = "Articulo.findByCosto", query = "SELECT a FROM Articulo a WHERE a.costo = :costo")
    , @NamedQuery(name = "Articulo.findByEstado", query = "SELECT a FROM Articulo a WHERE a.estado = :estado")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_articulo")
    private Integer idArticulo;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "marca")
    private Integer marca;
    @Column(name = "unidad_med")
    private Integer unidadMed;
    @Column(name = "existencia")
    private Integer existencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo")
    private BigDecimal costo;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articulo1")
    private Collection<SolDetArticulo> solDetArticuloCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articulo1")
    private Collection<SolDetOrden> solDetOrdenCollection;

    public Articulo() {
    }

    public Articulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getMarca() {
        return marca;
    }

    public void setMarca(Integer marca) {
        this.marca = marca;
    }

    public Integer getUnidadMed() {
        return unidadMed;
    }

    public void setUnidadMed(Integer unidadMed) {
        this.unidadMed = unidadMed;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
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

    @XmlTransient
    public Collection<SolDetOrden> getSolDetOrdenCollection() {
        return solDetOrdenCollection;
    }

    public void setSolDetOrdenCollection(Collection<SolDetOrden> solDetOrdenCollection) {
        this.solDetOrdenCollection = solDetOrdenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticulo != null ? idArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.idArticulo == null && other.idArticulo != null) || (this.idArticulo != null && !this.idArticulo.equals(other.idArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Articulo[ idArticulo=" + idArticulo + " ]";
    }
    
}
