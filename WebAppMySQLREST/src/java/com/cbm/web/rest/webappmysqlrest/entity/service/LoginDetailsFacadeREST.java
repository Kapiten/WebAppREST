/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbm.web.rest.webappmysqlrest.entity.service;

import com.cbm.web.rest.webappmysqlrest.entity.LoginDetails;
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
 * @author Tebogo
 */
@Stateless
@Path("com.cbm.web.rest.webappmysqlrest.entity.logindetails")
public class LoginDetailsFacadeREST extends AbstractFacade<LoginDetails> {

    @PersistenceContext(unitName = "WebAppMySQLRESTPU")
    private EntityManager em;

    public LoginDetailsFacadeREST() {
        super(LoginDetails.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(LoginDetails entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, LoginDetails entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @DELETE
    @Path("/removeByPersonId/{pid}")
    public void removeByPersonId(@PathParam("pid") Integer pid) {
        getEntityManager().createQuery("delete from from LoginDetails l where l.personId=:pid")
                .setParameter("pid", pid)
                .executeUpdate();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public LoginDetails find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("/findByUsername/{username}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public LoginDetails findByUsername(@PathParam("username") String username) {
        return (LoginDetails)getEntityManager().createQuery("select l from LoginDetails l where l.username = :username")
                .setParameter("username", username)
                .setMaxResults(1)
                .getResultList()
                .get(0);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<LoginDetails> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<LoginDetails> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
