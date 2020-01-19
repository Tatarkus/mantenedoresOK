/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matia
 */
@Entity
@Table(name = "TECNICO", catalog = "", schema = "OKCASA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnico.findAll", query = "SELECT t FROM Tecnico t")
    , @NamedQuery(name = "Tecnico.findByIdtecnico", query = "SELECT t FROM Tecnico t WHERE t.idtecnico = :idtecnico")
    , @NamedQuery(name = "Tecnico.findByEmail", query = "SELECT t FROM Tecnico t WHERE t.email = :email")
    , @NamedQuery(name = "Tecnico.findByNombre", query = "SELECT t FROM Tecnico t WHERE t.nombre = :nombre")})
public class Tecnico implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTECNICO")
    private BigDecimal idtecnico;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NOMBRE")
    private String nombre;

    public Tecnico() {
    }

    public Tecnico(BigDecimal idtecnico) {
        this.idtecnico = idtecnico;
    }

    public Tecnico(BigDecimal idtecnico, String email, String nombre) {
        this.idtecnico = idtecnico;
        this.email = email;
        this.nombre = nombre;
    }

    public BigDecimal getIdtecnico() {
        return idtecnico;
    }

    public void setIdtecnico(BigDecimal idtecnico) {
        this.idtecnico = idtecnico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtecnico != null ? idtecnico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnico)) {
            return false;
        }
        Tecnico other = (Tecnico) object;
        if ((this.idtecnico == null && other.idtecnico != null) || (this.idtecnico != null && !this.idtecnico.equals(other.idtecnico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tecnico[ idtecnico=" + idtecnico + " ]";
    }
    
}
