/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.AppointmentDAO;
import com.example.dao.DoctorDAO;
import com.example.dao.PatientDAO;
import com.example.dao.PersonDAO;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Appointment;
import com.example.model.AppointmentResponse;
import com.example.model.Doctor;
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
@Path("/appointment")
public class AppointmentResource {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(PersonResource.class);

    private AppointmentDAO appointmentDAO = new AppointmentDAO();
    private PersonDAO personDAO = new PersonDAO();
    private DoctorDAO doctorDAO = new DoctorDAO();
    private PatientDAO patientDAO = new PatientDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAppointment() {
        List<Appointment> apt = appointmentDAO.getAllAppointment();
        LOGGER.info("Successfully retrieved all appointments");
        return Response.status(Response.Status.OK).entity(apt).build();
    }

    @GET
    @Path("/{appointmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAppointmentId(@PathParam("appointmentId") int appointmentId) {
        Appointment appointment = appointmentDAO.getApppointmentById(appointmentId);
        if (appointment == null) {
            throw new ResourceNotFoundException("Appointment with ID " + appointmentId + " not found");
        }

        //Fetch patient and doctor details
        Patient patient = patientDAO.getPatientById(appointment.getPatientId());
        Doctor doctor = doctorDAO.getDoctorById(appointment.getDoctorId());

        //Create response object that includes appointment, patient and doctor information
        AppointmentResponse appointmentResponse = new AppointmentResponse(
                appointment.getAppointmentId(),
                appointment.getDate(),
                appointment.getTime(),
                patient,
                doctor
        );

        return Response.status(Response.Status.OK).entity(appointmentResponse).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAppointment(Appointment appointment) {
        appointmentDAO.addAppointment(appointment);
        return Response.status(Response.Status.CREATED).entity("Successfully added the appointment").build();
    }

    @PUT
    @Path("/{appointmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAppointment(@PathParam("appointmentId") int appointmentId, Appointment updatedAppointment) {
        Appointment existingAppointment = appointmentDAO.getApppointmentById(appointmentId);

        if (existingAppointment == null) {
            throw new ResourceNotFoundException("Appointment with ID " + appointmentId + " not found");
        }
        updatedAppointment.setAppointmentId(appointmentId);
        appointmentDAO.updateAppointment(updatedAppointment);

        // Return a 200 OK response
        return Response.status(Response.Status.OK).entity("Successfully updated the appointment with id: " + appointmentId).build();
    }

    @DELETE
    @Path("/{appointmentId}")
    public Response deleteAppointment(@PathParam("appointmentId") int appointmentId) {
        boolean isAppointmentAvailable = appointmentDAO.deleteAppointment(appointmentId);
        if (isAppointmentAvailable) {
            return Response.status(Response.Status.OK).entity("Sucessfully deleted the appointment with the id: " + appointmentId).build();
        } else {
            throw new ResourceNotFoundException("Appointment with ID " + appointmentId + " not found");
        }
    }
}
