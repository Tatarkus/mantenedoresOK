/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author matia
 */
@Entity
@Table(name = "SERVICIO", catalog = "", schema = "OKCASA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s")
    , @NamedQuery(name = "Servicio.findByIdservicio", query = "SELECT s FROM Servicio s WHERE s.idservicio = :idservicio")
    , @NamedQuery(name = "Servicio.findByDescripcion", query = "SELECT s FROM Servicio s WHERE s.descripcion = :descripcion")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSERVICIO")
    private BigDecimal idservicio;
    @Size(max = 64)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinTable(name = "SERVICIOSOLICITUD", joinColumns = {
        @JoinColumn(name = "IDSERVICIO", referencedColumnName = "IDSERVICIO")}, inverseJoinColumns = {
        @JoinColumn(name = "IDSOLICITUD", referencedColumnName = "IDSOLICITUD")})
    @ManyToMany
    private Collection<Solicitud> solicitudCollection;

    public Servicio() {
    }

    public Servicio(BigDecimal idservicio) {
        this.idservicio = idservicio;
    }

    public BigDecimal getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(BigDecimal idservicio) {
        this.idservicio = idservicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(Collection<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idservicio != null ? idservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idservicio == null && other.idservicio != null) || (this.idservicio != null && !this.idservicio.equals(other.idservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Servicio[ idservicio=" + idservicio + " ]";
    }
    
}
