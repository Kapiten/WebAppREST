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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sakkie
 */
@Entity
@Table(name = "db_transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DbTransactions.findAll", query = "SELECT d FROM DbTransactions d")
    , @NamedQuery(name = "DbTransactions.findByDbTransactionId", query = "SELECT d FROM DbTransactions d WHERE d.dbTransactionId = :dbTransactionId")
    , @NamedQuery(name = "DbTransactions.findByDescription", query = "SELECT d FROM DbTransactions d WHERE d.description = :description")
    , @NamedQuery(name = "DbTransactions.findByPersonId", query = "SELECT d FROM DbTransactions d WHERE d.personId = :personId")
    , @NamedQuery(name = "DbTransactions.findByDateDone", query = "SELECT d FROM DbTransactions d WHERE d.dateDone = :dateDone")})
public class DbTransactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "db_transaction_id")
    private Integer dbTransactionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "person_id")
    private int personId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "date_done")
    private String dateDone;

    public DbTransactions() {
    }

    public DbTransactions(Integer dbTransactionId) {
        this.dbTransactionId = dbTransactionId;
    }

    public DbTransactions(Integer dbTransactionId, String description, int personId, String dateDone) {
        this.dbTransactionId = dbTransactionId;
        this.description = description;
        this.personId = personId;
        this.dateDone = dateDone;
    }

    public Integer getDbTransactionId() {
        return dbTransactionId;
    }

    public void setDbTransactionId(Integer dbTransactionId) {
        this.dbTransactionId = dbTransactionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getDateDone() {
        return dateDone;
    }

    public void setDateDone(String dateDone) {
        this.dateDone = dateDone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbTransactionId != null ? dbTransactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DbTransactions)) {
            return false;
        }
        DbTransactions other = (DbTransactions) object;
        if ((this.dbTransactionId == null && other.dbTransactionId != null) || (this.dbTransactionId != null && !this.dbTransactionId.equals(other.dbTransactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cbm.web.rest.webappmysqlrest.entity.DbTransactions[ dbTransactionId=" + dbTransactionId + " ]";
    }
    
}
