/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

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
 * @author Bianca_Valentina
 */
@Entity
@Table(name = "nuevo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nuevo.findAll", query = "SELECT n FROM Nuevo n")
    , @NamedQuery(name = "Nuevo.findByIdnuevo", query = "SELECT n FROM Nuevo n WHERE n.idnuevo = :idnuevo")
    , @NamedQuery(name = "Nuevo.findByEliminar", query = "SELECT n FROM Nuevo n WHERE n.eliminar = :eliminar")
    , @NamedQuery(name = "Nuevo.findByNombre", query = "SELECT n FROM Nuevo n WHERE n.nombre = :nombre")})
public class Nuevo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnuevo")
    private Integer idnuevo;
    @Size(max = 45)
    @Column(name = "eliminar")
    private String eliminar;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;

    public Nuevo() {
    }

    public Nuevo(Integer idnuevo) {
        this.idnuevo = idnuevo;
    }

    public Integer getIdnuevo() {
        return idnuevo;
    }

    public void setIdnuevo(Integer idnuevo) {
        this.idnuevo = idnuevo;
    }

    public String getEliminar() {
        return eliminar;
    }

    public void setEliminar(String eliminar) {
        this.eliminar = eliminar;
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
        hash += (idnuevo != null ? idnuevo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nuevo)) {
            return false;
        }
        Nuevo other = (Nuevo) object;
        if ((this.idnuevo == null && other.idnuevo != null) || (this.idnuevo != null && !this.idnuevo.equals(other.idnuevo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Nuevo[ idnuevo=" + idnuevo + " ]";
    }
    
}
