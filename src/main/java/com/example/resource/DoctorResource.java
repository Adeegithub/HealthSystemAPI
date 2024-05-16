/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.DoctorDAO;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Doctor;
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
@Path("/doctor")
public class DoctorResource {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(PersonResource.class);

    private DoctorDAO doctorDAO = new DoctorDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDoctors() {
        List<Doctor> doctor = doctorDAO.getAllDoctors();
        LOGGER.info("Successfully retrieved all Doctors");
        return Response.status(Response.Status.OK).entity(doctor).build();
    }

    @GET
    @Path("/{doctorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoctorId(@PathParam("doctorId") int doctorId) {
        Doctor doctor = doctorDAO.getDoctorById(doctorId);
        if (doctor == null) {
            throw new ResourceNotFoundException("Doctor with ID " + doctorId + " not found");
        }
        return Response.status(Response.Status.OK).entity(doctor).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);
        return Response.status(Response.Status.CREATED).entity("Successfully added the doctor").build();
    }

    @PUT
    @Path("/{doctorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDoctor(@PathParam("doctorId") int doctorId, Doctor updatedDoctor) {
        Doctor existingDoctor = doctorDAO.getDoctorById(doctorId);

        if (existingDoctor == null) {
            throw new ResourceNotFoundException("Doctor ID " + doctorId + " not found");
        }
        updatedDoctor.setDoctorId(doctorId);
        doctorDAO.updateDoctor(updatedDoctor);

        // Return a 200 OK response
        return Response.status(Response.Status.OK).entity("Successfully updated the doctor with id: " + doctorId).build();
    }

    @DELETE
    @Path("/{doctorId}")
    public Response deleteDoctor(@PathParam("doctorId") int doctorId) {
        boolean isDoctorAvailable = doctorDAO.deleteDoctor(doctorId);
        if (isDoctorAvailable) {
            return Response.status(Response.Status.OK).entity("Sucessfully deleted the doctor with the id: " + doctorId).build();
        } else {
            throw new ResourceNotFoundException("Doctor with ID " + doctorId + " not found");
        }
    }
}
