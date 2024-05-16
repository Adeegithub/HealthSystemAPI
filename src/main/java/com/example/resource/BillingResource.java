/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.BillingDAO;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Billing;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ishara
 */
@Path("/billing")
public class BillingResource {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(PersonResource.class);

    private BillingDAO billingDAO = new BillingDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBilling() {
        List<Billing> bills = billingDAO.getAllBilling();
        LOGGER.info("Successfully retrieved all Billings");
        return Response.status(Response.Status.OK).entity(bills).build();
    }

    @GET
    @Path("/{billingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBillingId(@PathParam("billingId") int billingId) {
        Billing billing = billingDAO.getBillingById(billingId);
        if (billing == null) {
            throw new ResourceNotFoundException("Billing with ID " + billingId + " not found");
        }
        return Response.status(Response.Status.OK).entity(billing).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBilling(Billing billing) {
        billingDAO.addBilling(billing);
        return Response.status(Response.Status.CREATED).entity("Successfully added the billing").build();
    }

    @PUT
    @Path("/{billingId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBilling(@PathParam("billingId") int billingId, Billing updatedBilling) {
        Billing existingBilling = billingDAO.getBillingById(billingId);

        if (existingBilling == null) {
            throw new ResourceNotFoundException("Billing ID " + billingId + " not found");
        }
        updatedBilling.setBillingId(billingId);
        billingDAO.updateBilling(updatedBilling);

        // Return a 200 OK response
        return Response.status(Response.Status.OK).entity("Successfully updated the bill ith id: " + billingId).build();
    }

    @DELETE
    @Path("/{billingId}")
    public Response deleteBilling(@PathParam("billingId") int billingId) {
        boolean isBillingAvailable = billingDAO.deleteBill(billingId);
        if (isBillingAvailable) {
            return Response.status(Response.Status.OK).entity("Sucessfully deleted the bill with the id: " + billingId).build();
        } else {
            throw new ResourceNotFoundException("Bill with ID " + billingId + " not found");
        }
    }
}
