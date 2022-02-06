package com.flipkart.restController;

        import com.flipkart.bean.Course;
        import com.flipkart.bean.Student;
        import com.flipkart.dao.StudentDaoImplementation;
        import com.flipkart.dao.StudentDaoInterface;
        import com.flipkart.service.StudentInterface;
        import com.flipkart.service.StudentOperations;

        import java.sql.SQLException;
        import java.util.Vector;

        import javax.validation.constraints.NotNull;
        import javax.ws.rs.Consumes;
        import javax.ws.rs.DELETE;
        import javax.ws.rs.GET;
        import javax.ws.rs.POST;
        import javax.ws.rs.PUT;
        import javax.ws.rs.Path;
        import javax.ws.rs.PathParam;
        import javax.ws.rs.Produces;
        import javax.ws.rs.QueryParam;
        import javax.ws.rs.core.MediaType;
        import javax.ws.rs.core.Response;


@Path("/student")
public class StudentRestAPI {

    StudentInterface studentInterface= StudentOperations.getInstance();
    StudentDaoInterface studentDaoInterface= StudentDaoImplementation.getInstance();
    double fee;
    int invoiceId;

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
*/

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

    @GET
    @Path("/getStudent/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStudent(
            @PathParam("studentId") String studentId
    ) {
        String student = null;
        try {
            student = studentDaoInterface.getfeeStatus(studentId);
        }catch(SQLException se) {
            se.printStackTrace();
        }
        return student;
    }



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
