package com.flipkart.restController;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.service.ProfessorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

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

    @GET
    @Path("/viewAllCourses")
    public Response viewCourses() throws SQLException {
        ArrayList<Course> courses=professorService.viewAllCourses();
        if (courses != null)
            return Response.ok(courses).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/ViewEnrolStud/{professorId}")
    public Response viewStudents(@PathParam("professorId") String professorId) throws SQLException {
        Map<String, ArrayList<String>> students=professorService.viewEnrolledStudents(professorId);
        if (students != null)
            return Response.ok(students).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("/registerCourses")
    public String registerCourses(@QueryParam("professorId") String professorId,@QueryParam("courseId") int courseId) throws SQLException, IOException, IOException {
        professorService.registerCourses(professorId,courseId);
        return "Course is successfully Registered";
    }

    @POST
    @Path("/assignGrades")
    public String assignGrades(@QueryParam("professorId") String professorId,@QueryParam("courseId") int courseId,@QueryParam("studentId") String studentId,@QueryParam("Grade") String Grade) throws SQLException, IOException {
        professorService.assignGrades(professorId,courseId,studentId,Grade);
        return "Student is assigned Grade";
    }

}
