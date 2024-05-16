/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.PrecriptionDAO;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Prescription;
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
@Path("/prescription")
public class PrescriptionResource {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(PersonResource.class);

    private PrecriptionDAO prescriptionDAO = new PrecriptionDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrescription() {
        List<Prescription> prescription = prescriptionDAO.getAllPrescriptions();
        LOGGER.info("Successfully retrieved all prescriptions");
        return Response.status(Response.Status.OK).entity(prescription).build();
    }

    @GET
    @Path("/{prescriptionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getprescription(@PathParam("prescriptionId") int prescriptionId) {
        Prescription prescription = prescriptionDAO.getPrescriptionById(prescriptionId);

        if (prescription == null) {
            throw new ResourceNotFoundException("Prescription with ID " + prescriptionId + " not found");
        }
        return Response.status(Response.Status.OK).entity(prescription).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPrescription(Prescription prescription) {
        prescriptionDAO.addPrescription(prescription);
        return Response.status(Response.Status.CREATED).entity("Successfully added the prescription").build();
    }

    @PUT
    @Path("/{prescriptionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePrescreption(@PathParam("prescriptionId") int prescriptionId, Prescription updatedPrecription) {

        Prescription existingPrecription = prescriptionDAO.getPrescriptionById(prescriptionId);

        if (existingPrecription == null) {
            throw new ResourceNotFoundException("Prescription ID " + prescriptionId + " not found");
        }
        updatedPrecription.setPrescriptionId(prescriptionId);
        prescriptionDAO.updatePrescription(updatedPrecription);

        // Return a 200 OK response
        return Response.status(Response.Status.OK).entity("Successfully updated the prescription with id: " + prescriptionId).build();
    }

    @DELETE
    @Path("/{prescriptionId}")
    public Response deletePrescription(@PathParam("prescriptionId") int prescriptionId) {
        boolean isPrescriptionAvailable = prescriptionDAO.deletePrecription(prescriptionId);
        if (isPrescriptionAvailable) {
            return Response.status(Response.Status.OK).entity("Sucessfully deleted the prescription with the id: " + prescriptionId).build();
        } else {
            throw new ResourceNotFoundException("Prescription with ID " + prescriptionId + " not found");
        }
    }
}
