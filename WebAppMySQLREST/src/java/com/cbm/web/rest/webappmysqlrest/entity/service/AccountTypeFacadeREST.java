/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbm.web.rest.webappmysqlrest.entity.service;

import com.cbm.web.rest.webappmysqlrest.entity.AccountType;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Sakkie
 */
@Stateless
@Path("com.cbm.web.rest.webappmysqlrest.entity.accounttype")
public class AccountTypeFacadeREST extends AbstractFacade<AccountType> {

    @PersistenceContext(unitName = "WebAppMySQLRESTPU")
    private EntityManager em;

    public AccountTypeFacadeREST() {
        super(AccountType.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(AccountType entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, AccountType entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public AccountType find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("{name}/{n1}/{n2}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public AccountType findByName(@PathParam("name") String name) {
        return (AccountType)getEntityManager().createQuery("select a from AccountType a where a.accountName=:accountName")
                .setParameter("accountName", name)
                .setMaxResults(1)
                .getResultList()
                .get(0);
        //return super.findByName(name, table, field);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AccountType> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AccountType> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
