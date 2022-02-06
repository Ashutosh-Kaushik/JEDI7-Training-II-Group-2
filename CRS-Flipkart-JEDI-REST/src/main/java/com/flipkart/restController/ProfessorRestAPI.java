package com.flipkart.restController;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.service.ProfessorService;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperations;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;


@Path("/professor")
@Produces(MediaType.APPLICATION_JSON)
public class ProfessorRestAPI{

    ProfessorService professorService=new ProfessorService();

    @GET
    @Path("/test")
    public String test(){
        return "test";
    }
    @GET
    @Path("/loginWithCred")
    public String ValidateProfCredentials(@QueryParam("userId") String userId,@QueryParam("password") String password) {

        Professor professor=professorService.validateCredentials(userId,password);
        if (professor != null)
            return "Welcome to the Portal, Professor"+professor.getUserName();
        else
            return "Invalid Credentials";
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
        Map<String,ArrayList<String>> students=professorService.viewEnrolledStudents(professorId);
        if (students != null)
            return Response.ok(students).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/registerCourses")
    public String registerCourses(@QueryParam("professorId") String professorId,@QueryParam("courseId") int courseId) throws SQLException, IOException {
        professorService.registerCourses(professorId,courseId);
        return "Course is successfully Added";
    }

    @GET
    @Path("/assignGrades")
    public String assignGrades(@QueryParam("professorId") String professorId,@QueryParam("courseId") int courseId,@QueryParam("studentId") String studentId,@QueryParam("Grade") String Grade) throws SQLException, IOException {
        professorService.assignGrades(professorId,courseId,studentId,Grade);
        return "Student is assigned Grade";
    }


/*
    @GET
    @Path("/totalRegisteredCourses/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalRegisteredCourses(
            @PathParam("studentId") String studentId
    ) {
        int totalcourses = 0;
        try {
            totalcourses = studentInterface.registeredCourseList(studentId);
        }catch(SQLException se) {
            se.printStackTrace();
        }

        return Response.status(200).entity("Total Registered Course of StudentId : " + studentId + " is " + totalcourses + ".").build();
    }


    @POST
    @Path("/registerCourses")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerCourses(
            @QueryParam("course1") int course1,
            @QueryParam("course2") int course2,
            @QueryParam("course3") int course3,
            @QueryParam("course4") int course4,
            @QueryParam("course5") int course5,
            @QueryParam("course6") int course6,
            @NotNull
            @QueryParam("studentId") int studentId)	throws SQLException, CourseLimitExceededException, SeatNotAvailableException, CourseNotFoundException{

        try
        {
            Vector<Course> availableCourseList = registrationInterface.viewCourses(studentId);
            Vector<Integer> courseList = new Vector<Integer>();

            courseList.add(course1);
            courseList.add(course2);
            courseList.add(course3);
            courseList.add(course4);
            courseList.add(course5);
            courseList.add(course6);

            for(int courseCode:courseList)
                registrationInterface.addCourse(courseCode, studentId, availableCourseList);

            registrationInterface.setRegistrationStatus(studentId);

        } catch (SQLException e) {
            return Response.status(500).entity("Error : " + e).build();
        } catch (SeatNotAvailableException e) {
            return Response.status(500).entity("Error : " + e).build();
        } catch (CourseLimitExceededException e) {
            return Response.status(500).entity("Error : " + e).build();
        } catch (CourseNotFoundException e) {
            return Response.status(500).entity("Error : " + e).build();
        } catch (CourseAlreadyRegisteredException e) {
            return Response.status(500).entity("Error : " + e).build();
        }


        return Response.status(201).entity( "Registration Successful").build();

    }


    @GET
    @Path("/viewAvailableCourses/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vector<Course> viewAvailableCourses(
            @PathParam("studentId") int studentId
    ) {
        Vector<Course> availableCourses = null;
        try {
            availableCourses = registrationInterface.viewCourses(studentId);
        }catch(SQLException se) {
            se.printStackTrace();
        }

        return availableCourses;
    }


    @GET
    @Path("/viewRegisteredCourses/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vector<Course> viewRegisteredCourses(
            @PathParam("studentId") String studentId
    ) {
        Vector<Course> registeredCourses = null;
        try {
            registeredCourses = studentInterface.registeredCourseList(studentId);
        }catch(SQLException se) {
            se.printStackTrace();
        }

        return registeredCourses;
    }

*/

    /**
     * View Grade Card
     * @param studentId
     */
  /*  @GET
    @Path("/viewGradeCard/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vector<String> viewGradeCard(
            @NotNull
            @PathParam("studentId") int studentId
    ) {
        // TODO Auto-generated method stub

        Vector<String>response=new Vector<String>();

        try {
            boolean isGenerated = registrationInterface.isGenerated(studentId);

            if(!isGenerated) {

                response.addElement("GradeCard is not generated yet.");
                return response;
            }
            else {

                try {
                    Vector<GradeCard> grades = registrationInterface.viewGradeCard(studentId);

                    if(grades.isEmpty()) {
                        response.addElement("You haven't registered for any course.");
                        return response;

                    }

                    double overallgpa = 0.0;

                    for(GradeCard course_grade : grades) {
                        response.add("Course Code:" + course_grade.getCourseId() + " GPA:" + course_grade.getGpa());
                        overallgpa += course_grade.getGpa();
                    }

                    overallgpa /= (double)grades.size();
                    response.add("Overall GPA: " + overallgpa);

                    return response;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
*/
}
