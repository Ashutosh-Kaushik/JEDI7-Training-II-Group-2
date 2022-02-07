package com.flipkart.restController;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.dao.AdminDaoImplementation;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class AdminRestAPI {

    @POST
    @Path("/addProfessor")
    @Consumes("application/json")
    public Response addProfessor(@Valid Professor professor) {
        try {
            AdminInterface adminInterface = AdminOperation.getInstance();
            adminInterface.addProfessor(professor);
        }
        catch (Exception e) {
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Professor Added Successfully !!").build();
    }

    @POST
    @Path("/addCourse")
    @Consumes("application/json")
    public Response addCourse(@Valid Course course) {
        try {
            AdminInterface adminInterface = AdminOperation.getInstance();
            adminInterface.addCourse(course);
        }
        catch (Exception e) {
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Course Added Successfully !!").build();
    }

    @POST
    @Path("/dropCourse")
    @Consumes("application/json")
    public Response dropCourse(@Valid Course course) {
        try {
            AdminInterface adminInterface = AdminOperation.getInstance();
            adminInterface.dropCourse(course.getCourseId());
        }
        catch (Exception e) {
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Course dropped Successfully !!").build();
    }

    @POST
    @Path("/approveStudent")
    public Response approveStudent(@QueryParam("studentId") String studentId) {
        try {
            AdminDaoImplementation adminDaoImplementation = new AdminDaoImplementation();
            if(adminDaoImplementation.isApproved(studentId)) {
                return Response.status(201).entity("Already Approved").build();
            }
            adminDaoImplementation.approveStudents(studentId);
        }
        catch (Exception e) {
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Student Approved Successfully!!").build();
    }
}
