/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.PersonDAO;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Person;
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
@Path("/person")
public class PersonResource {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(PersonResource.class);

    private PersonDAO personDAO = new PersonDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPerson() {
        List<Person> prs = personDAO.getAllPerson();
        LOGGER.info("Successfully retrieved all person");
        return Response.status(Response.Status.OK).entity(prs).build();
    }

    @GET
    @Path("/{personId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonById(@PathParam("personId") int personId) {
        Person person = personDAO.getPersonById(personId);
        if (person == null) {
            throw new ResourceNotFoundException("Person with ID " + personId + " not found");
        }

        return Response.status(Response.Status.OK).entity(person).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        personDAO.addPerson(person);
        return Response.status(Response.Status.CREATED).entity("Successfully added the person").build();
    }

    @PUT
    @Path("/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("personId") int personId, Person updatedPerson) {
        Person existingPerson = personDAO.getPersonById(personId);

        if (existingPerson == null) {
            throw new ResourceNotFoundException("Person with ID " + personId + " not found");
        }
        updatedPerson.setPersonId(personId);
        personDAO.updatePerson(updatedPerson);

        // Return a 200 OK response
        return Response.status(Response.Status.OK).entity("Successfully updated the person with id: " + personId).build();
    }

    @DELETE
    @Path("/{personId}")
    public Response deletePerson(@PathParam("personId") int personId) {
        boolean isPersonAvailable = personDAO.deletePerson(personId);
        if (isPersonAvailable) {
            return Response.status(Response.Status.OK).entity("Sucessfully deleted the person with the id: " + personId).build();
        } else {
            throw new ResourceNotFoundException("Appointment with ID " + personId + " not found");
        }
    }
}
