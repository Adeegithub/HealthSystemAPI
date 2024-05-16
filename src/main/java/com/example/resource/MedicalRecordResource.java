/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.MedicalRecordDAO;
import com.example.exception.ResourceNotFoundException;
import com.example.model.MedicalRecord;
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
@Path("/medicalRecord")
public class MedicalRecordResource {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(PersonResource.class);

    private MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMedicalRecords() {
        List<MedicalRecord> medicalRecord = medicalRecordDAO.getAllMedicalRecords();
        LOGGER.info("Successfully retrieved all Meical Records");
        return Response.status(Response.Status.OK).entity(medicalRecord).build();
    }

    @GET
    @Path("/{medicalRecordId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicalRecordId(@PathParam("medicalRecordId") int medicalRecordId) {
        MedicalRecord medicalRecord = medicalRecordDAO.getMedicalRecordById(medicalRecordId);
        if (medicalRecord == null) {
            throw new ResourceNotFoundException("Medical Record with ID " + medicalRecordId + " not found");
        }
        return Response.status(Response.Status.OK).entity(medicalRecord).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordDAO.addMedicalRecord(medicalRecord);
        return Response.status(Response.Status.CREATED).entity("Successfully added the medical record").build();
    }

    @PUT
    @Path("/{medicalRecordId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMedicalRecord(@PathParam("medicalRecordId") int medicalRecordId, MedicalRecord updatedMedicalRecord) {
        
        MedicalRecord existingMedicalRecord  = medicalRecordDAO.getMedicalRecordById(medicalRecordId);

        if (existingMedicalRecord == null) {
            throw new ResourceNotFoundException("Medical Record ID " + medicalRecordId + " not found");
        }
        updatedMedicalRecord.setMedicalRecordId(medicalRecordId);
        medicalRecordDAO.updateMedicalRecord(updatedMedicalRecord);

        // Return a 200 OK response
        return Response.status(Response.Status.OK).entity("Successfully updated the medical record with id: " + medicalRecordId).build();
    }

    @DELETE
    @Path("/{medicalRecordId}")
    public Response deleteMedicalReport(@PathParam("medicalRecordId") int medicalRecordId) {
        boolean isMedicalRecordAvailable = medicalRecordDAO.deleteMedicalRecord(medicalRecordId);
        if (isMedicalRecordAvailable) {
            return Response.status(Response.Status.OK).entity("Sucessfully deleted the medical record with the id: " + medicalRecordId).build();
        } else {
            throw new ResourceNotFoundException("Medical Record with ID " + medicalRecordId + " not found");
        }
    }
}
