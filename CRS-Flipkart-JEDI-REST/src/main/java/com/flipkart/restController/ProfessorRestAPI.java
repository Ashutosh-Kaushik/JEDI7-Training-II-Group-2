package com.flipkart.restController;

import com.flipkart.bean.Professor;
import com.flipkart.service.ProfessorService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/professor")
@Produces(MediaType.APPLICATION_JSON)
public class ProfessorRestAPI {

    ProfessorService professorService = new ProfessorService();

    @GET
    @Path("/test")
    public String test() {
        return "test";
    }

    @GET
    @Path("/loginWithCred")
    public Response getEmployeeById(@QueryParam("userId") String userId, @QueryParam("password") String password) {

        Professor professor = professorService.validateCredentials(userId, password);
        if (professor != null)
            return Response.ok(professor).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
