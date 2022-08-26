/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbm.web.rest.webappmysqlrest.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tebogo
 */
@Entity
@Table(name = "login_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginDetails.findAll", query = "SELECT l FROM LoginDetails l")
    , @NamedQuery(name = "LoginDetails.findByLoginDetailsId", query = "SELECT l FROM LoginDetails l WHERE l.loginDetailsId = :loginDetailsId")
    , @NamedQuery(name = "LoginDetails.findByUsername", query = "SELECT l FROM LoginDetails l WHERE l.username = :username")
    , @NamedQuery(name = "LoginDetails.findByPassword", query = "SELECT l FROM LoginDetails l WHERE l.password = :password")
    , @NamedQuery(name = "LoginDetails.findByPersonId", query = "SELECT l FROM LoginDetails l WHERE l.personId = :personId")})
public class LoginDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "login_details_id")
    private Integer loginDetailsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "person_id")
    private int personId;

    public LoginDetails() {
    }

    public LoginDetails(Integer loginDetailsId) {
        this.loginDetailsId = loginDetailsId;
    }

    public LoginDetails(Integer loginDetailsId, String username, String password, int personId) {
        this.loginDetailsId = loginDetailsId;
        this.username = username;
        this.password = password;
        this.personId = personId;
    }

    public Integer getLoginDetailsId() {
        return loginDetailsId;
    }

    public void setLoginDetailsId(Integer loginDetailsId) {
        this.loginDetailsId = loginDetailsId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginDetailsId != null ? loginDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginDetails)) {
            return false;
        }
        LoginDetails other = (LoginDetails) object;
        if ((this.loginDetailsId == null && other.loginDetailsId != null) || (this.loginDetailsId != null && !this.loginDetailsId.equals(other.loginDetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cbm.web.rest.webappmysqlrest.entity.LoginDetails[ loginDetailsId=" + loginDetailsId + " ]";
    }
    
}
