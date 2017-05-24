/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bianca_Valentina
 */
@Entity
@Table(name = "hola")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hola.findAll", query = "SELECT h FROM Hola h")
    , @NamedQuery(name = "Hola.findByIdHOLA", query = "SELECT h FROM Hola h WHERE h.idHOLA = :idHOLA")
    , @NamedQuery(name = "Hola.findByEliminar", query = "SELECT h FROM Hola h WHERE h.eliminar = :eliminar")//este va
    , @NamedQuery(name = "Hola.findByNombre", query = "SELECT h FROM Hola h WHERE h.nombre = :nombre")})
public class Hola implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHOLA")
    private Integer idHOLA;
    //este metodo
    @Column(name = "ELIMINAR")
    private Boolean eliminar;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;

    public Hola() {
    }

    public Hola(Integer idHOLA) {
        this.idHOLA = idHOLA;
    }

    public Integer getIdHOLA() {
        return idHOLA;
    }

    public void setIdHOLA(Integer idHOLA) {
        this.idHOLA = idHOLA;
    }

    public Boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(Boolean eliminar) {
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
        hash += (idHOLA != null ? idHOLA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hola)) {
            return false;
        }
        Hola other = (Hola) object;
        if ((this.idHOLA == null && other.idHOLA != null) || (this.idHOLA != null && !this.idHOLA.equals(other.idHOLA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Hola[ idHOLA=" + idHOLA + " ]";
    }
}