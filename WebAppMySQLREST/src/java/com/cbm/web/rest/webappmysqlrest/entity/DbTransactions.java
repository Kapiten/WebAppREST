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
@Table(name = "db_transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DbTransactions.findAll", query = "SELECT d FROM DbTransactions d")
    , @NamedQuery(name = "DbTransactions.findByDbTransactionsId", query = "SELECT d FROM DbTransactions d WHERE d.dbTransactionsId = :dbTransactionsId")
    , @NamedQuery(name = "DbTransactions.findByDescription", query = "SELECT d FROM DbTransactions d WHERE d.description = :description")
    , @NamedQuery(name = "DbTransactions.findByDateDone", query = "SELECT d FROM DbTransactions d WHERE d.dateDone = :dateDone")
    , @NamedQuery(name = "DbTransactions.findByPersonId", query = "SELECT d FROM DbTransactions d WHERE d.personId = :personId")})
public class DbTransactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "db_transactions_id")
    private Integer dbTransactionsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "date_done")
    private String dateDone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "person_id")
    private int personId;

    public DbTransactions() {
    }

    public DbTransactions(Integer dbTransactionsId) {
        this.dbTransactionsId = dbTransactionsId;
    }

    public DbTransactions(Integer dbTransactionsId, String description, String dateDone, int personId) {
        this.dbTransactionsId = dbTransactionsId;
        this.description = description;
        this.dateDone = dateDone;
        this.personId = personId;
    }

    public Integer getDbTransactionsId() {
        return dbTransactionsId;
    }

    public void setDbTransactionsId(Integer dbTransactionsId) {
        this.dbTransactionsId = dbTransactionsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateDone() {
        return dateDone;
    }

    public void setDateDone(String dateDone) {
        this.dateDone = dateDone;
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
        hash += (dbTransactionsId != null ? dbTransactionsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DbTransactions)) {
            return false;
        }
        DbTransactions other = (DbTransactions) object;
        if ((this.dbTransactionsId == null && other.dbTransactionsId != null) || (this.dbTransactionsId != null && !this.dbTransactionsId.equals(other.dbTransactionsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cbm.web.rest.webappmysqlrest.entity.DbTransactions[ dbTransactionsId=" + dbTransactionsId + " ]";
    }
    
}
