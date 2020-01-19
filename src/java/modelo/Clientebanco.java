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
@Table(name = "CLIENTEBANCO", catalog = "", schema = "OKCASA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientebanco.findAll", query = "SELECT c FROM Clientebanco c")
    , @NamedQuery(name = "Clientebanco.findByIdcliente", query = "SELECT c FROM Clientebanco c WHERE c.idcliente = :idcliente")
    , @NamedQuery(name = "Clientebanco.findByEmail", query = "SELECT c FROM Clientebanco c WHERE c.email = :email")
    , @NamedQuery(name = "Clientebanco.findByNombre", query = "SELECT c FROM Clientebanco c WHERE c.nombre = :nombre")})
public class Clientebanco implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCLIENTE")
    private BigDecimal idcliente;
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

    public Clientebanco() {
    }

    public Clientebanco(BigDecimal idcliente) {
        this.idcliente = idcliente;
    }

    public Clientebanco(BigDecimal idcliente, String email, String nombre) {
        this.idcliente = idcliente;
        this.email = email;
        this.nombre = nombre;
    }

    public BigDecimal getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(BigDecimal idcliente) {
        this.idcliente = idcliente;
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
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientebanco)) {
            return false;
        }
        Clientebanco other = (Clientebanco) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Clientebanco[ idcliente=" + idcliente + " ]";
    }
    
}
