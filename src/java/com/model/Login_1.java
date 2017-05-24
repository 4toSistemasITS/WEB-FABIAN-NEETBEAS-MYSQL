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
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login_1.findAll", query = "SELECT l FROM Login_1 l")
    , @NamedQuery(name = "Login_1.findByPkLogin", query = "SELECT l FROM Login_1 l WHERE l.pkLogin = :pkLogin")
    , @NamedQuery(name = "Login_1.findByUsuario", query = "SELECT l FROM Login_1 l WHERE l.usuario = :usuario")
    , @NamedQuery(name = "Login_1.findByContrase\u00f1a", query = "SELECT l FROM Login_1 l WHERE l.contrase\u00f1a = :contrase\u00f1a")})
public class Login_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_login")
    private Integer pkLogin;
    @Size(max = 45)
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "contrase\u00f1a")
    private Boolean contraseña;

    public Login_1() {
    }

    public Login_1(Integer pkLogin) {
        this.pkLogin = pkLogin;
    }

    public Integer getPkLogin() {
        return pkLogin;
    }

    public void setPkLogin(Integer pkLogin) {
        this.pkLogin = pkLogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getContraseña() {
        return contraseña;
    }

    public void setContraseña(Boolean contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkLogin != null ? pkLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login_1)) {
            return false;
        }
        Login_1 other = (Login_1) object;
        if ((this.pkLogin == null && other.pkLogin != null) || (this.pkLogin != null && !this.pkLogin.equals(other.pkLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Login_1[ pkLogin=" + pkLogin + " ]";
    }
    
}
