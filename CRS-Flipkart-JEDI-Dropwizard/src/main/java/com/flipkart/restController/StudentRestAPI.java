package com.flipkart.restController;

        import ch.qos.logback.core.encoder.EchoEncoder;
        import com.flipkart.bean.Course;
        import com.flipkart.bean.GradeCard;
        import com.flipkart.bean.Student;
        import com.flipkart.dao.StudentDaoImplementation;
        import com.flipkart.dao.StudentDaoInterface;
        import com.flipkart.service.*;
        import org.checkerframework.checker.units.qual.A;

        import java.sql.SQLException;
        import java.util.ArrayList;

        import javax.validation.Valid;
        import javax.ws.rs.*;
        import javax.ws.rs.core.MediaType;
        import javax.ws.rs.core.Response;


@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentRestAPI {

    StudentInterface studentInterface= new StudentOperations();
    StudentDaoInterface studentDaoInterface= new StudentDaoImplementation();
    double fee;
    int invoiceId;

    @POST
    @Path("/addStudent")
    @Consumes("application/json")
    public Response dropCourse(@Valid Student student) {
        try {
            studentDaoInterface.addStudent(student);
        } catch (Exception e) {
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Student added successfully !!").build();
    }

    @GET
    @Path("/viewDetails")
    public Response getStudent(@QueryParam("StudentId") String studentId) throws SQLException {
            StudentDaoInterface sdi = new StudentDaoImplementation();
            Student student =  sdi.getStudent(studentId);
        if (student != null)
            return Response.ok(student).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();

    }


    @POST
    @Path("/semesterRegistration/{studentId}")
    public Response semesterRegistration(
            @PathParam("studentId")  String studentId
    ) {
        try {

            ArrayList<Integer> list = studentDaoInterface.registeredCoursesList(studentId);
            studentDaoInterface.registerCourses(studentId,list);
        }catch(Exception e) {
            return Response.status(201).entity("Semester Registration is already done.").build();

        }
        return Response.status(201).entity("Semester Registration done Sucessfully").build();
    }

    @GET
    @Path("/viewCourses/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewAvailableCourses() {
        ArrayList<Course> availableCourses = null;
        try {
            availableCourses = studentDaoInterface.viewCourses();
        }catch(SQLException se) {
            se.printStackTrace();
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.ok(availableCourses).build();
    }

    @POST
    @Path("/RegisterCourses")
    public Response registerCourses(
            @QueryParam("course1") int c1,
            @QueryParam("course2") int c2,
            @QueryParam("course3") int c3,
            @QueryParam("course4") int c4,
            @QueryParam("studentId") String studentId
    ) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(c1);list.add(c2);list.add(c3);list.add(c4);
        try {
            studentDaoInterface.registerCourses(studentId, list);
        }
        catch (Exception e) {
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Course Registration is completed successfully !! congratulations").build();

    }

    @GET
    @Path("/viewReportCard/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewReportCard(@QueryParam("studentId") String studentId) {
        ArrayList<GradeCard> gradeCards;
        try {
            gradeCards = studentDaoInterface.viewGrades(studentId);
        }catch(SQLException se) {
            se.printStackTrace();
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.ok(gradeCards).build();
    }
    @GET
    @Path("/checkFeesStatus")
    @Produces(MediaType.APPLICATION_JSON)
    public Response payFess(@QueryParam("studentId") String studentId) {
        String ret;
        try {
            ret = studentDaoInterface.getfeeStatus(studentId);
        }catch(Exception e) {
            e.printStackTrace();
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.ok(ret).build();
    }


}
