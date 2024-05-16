/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.PatientDAO;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Patient;
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
@Path("patient")
public class PatientResource {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(PersonResource.class);

    private PatientDAO patientDAO = new PatientDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPatient() {
        List<Patient> patient = patientDAO.getAllPatient();
        LOGGER.info("Successfully retrieved all patients");
        return Response.status(Response.Status.OK).entity(patient).build();
    }

    @GET
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientId(@PathParam("patientId") int patientId) {
        Patient patient = patientDAO.getPatientById(patientId);

        if (patient == null) {
            throw new ResourceNotFoundException("Patient with ID " + patientId + " not found");
        }
        return Response.status(Response.Status.OK).entity(patient).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPatient(Patient patient) {
        patientDAO.addPatient(patient);
        return Response.status(Response.Status.CREATED).entity("Successfully added the patient").build();
    }

    @PUT
    @Path("/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePatient(@PathParam("patientId") int patientId, Patient updatedPatient) {

        Patient existingPatient = patientDAO.getPatientById(patientId);

        if (existingPatient == null) {
            throw new ResourceNotFoundException("Patient ID " + patientId + " not found");
        }
        updatedPatient.setPatientId(patientId);
        patientDAO.updatePatient(updatedPatient);

        // Return a 200 OK response
        return Response.status(Response.Status.OK).entity("Successfully updated the patient with id: " + patientId).build();
    }

    @DELETE
    @Path("/{patientId}")
    public Response deletePatient(@PathParam("patientId") int patientId) {
        boolean isPatientAvailable = patientDAO.deletePatient(patientId);
        if (isPatientAvailable) {
            return Response.status(Response.Status.OK).entity("Sucessfully deleted the patient with the id: " + patientId).build();
        } else {
            throw new ResourceNotFoundException("Patient with ID " + patientId + " not found");
        }
    }
}
