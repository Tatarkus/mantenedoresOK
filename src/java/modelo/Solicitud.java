/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author matia
 */
@Entity
@Table(name = "SOLICITUD", catalog = "", schema = "OKCASA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")
    , @NamedQuery(name = "Solicitud.findByIdsolicitud", query = "SELECT s FROM Solicitud s WHERE s.idsolicitud = :idsolicitud")
    , @NamedQuery(name = "Solicitud.findByValorinsp", query = "SELECT s FROM Solicitud s WHERE s.valorinsp = :valorinsp")
    , @NamedQuery(name = "Solicitud.findByDescuento", query = "SELECT s FROM Solicitud s WHERE s.descuento = :descuento")
    , @NamedQuery(name = "Solicitud.findByFechasolicitud", query = "SELECT s FROM Solicitud s WHERE s.fechasolicitud = :fechasolicitud")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSOLICITUD")
    private BigDecimal idsolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALORINSP")
    private BigInteger valorinsp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESCUENTO")
    private BigInteger descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHASOLICITUD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasolicitud;
    @ManyToMany(mappedBy = "solicitudCollection")
    private Collection<Servicio> servicioCollection;
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE")
    @ManyToOne(optional = false)
    private Cliente idcliente;

    public Solicitud() {
    }

    public Solicitud(BigDecimal idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Solicitud(BigDecimal idsolicitud, BigInteger valorinsp, BigInteger descuento, Date fechasolicitud) {
        this.idsolicitud = idsolicitud;
        this.valorinsp = valorinsp;
        this.descuento = descuento;
        this.fechasolicitud = fechasolicitud;
    }

    public BigDecimal getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(BigDecimal idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public BigInteger getValorinsp() {
        return valorinsp;
    }

    public void setValorinsp(BigInteger valorinsp) {
        this.valorinsp = valorinsp;
    }

    public BigInteger getDescuento() {
        return descuento;
    }

    public void setDescuento(BigInteger descuento) {
        this.descuento = descuento;
    }

    public Date getFechasolicitud() {
        return fechasolicitud;
    }

    public void setFechasolicitud(Date fechasolicitud) {
        this.fechasolicitud = fechasolicitud;
    }

    @XmlTransient
    public Collection<Servicio> getServicioCollection() {
        return servicioCollection;
    }

    public void setServicioCollection(Collection<Servicio> servicioCollection) {
        this.servicioCollection = servicioCollection;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsolicitud != null ? idsolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idsolicitud == null && other.idsolicitud != null) || (this.idsolicitud != null && !this.idsolicitud.equals(other.idsolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Solicitud[ idsolicitud=" + idsolicitud + " ]";
    }
    
}
