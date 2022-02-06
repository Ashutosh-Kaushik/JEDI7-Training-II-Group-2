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
@Produces(MediaType.APPLICATION_JSON)
public class StudentRestAPI {

    StudentInterface studentInterface= StudentOperations.getInstance();
    StudentDaoInterface studentDaoInterface= StudentDaoImplementation.getInstance();
    double fee;
    int invoiceId;

    @GET
    public Response getStudent(@QueryParam("StudentId") String studentId) throws SQLException {
            StudentDaoInterface sdi = new StudentDaoImplementation();
            Student student =  sdi.getStudent(studentId);
        if (student != null)
            return Response.ok(student).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();

    }


//    @POST
//    @Path("/semesterRegistration/{semester}/{studentId}")
//    @Consumes("application/json")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response semesterRegistration(
//            @PathParam("semester")  int semester,
//            @PathParam("studentId")  int studentId
//    ) {
//        boolean check = false;
//        try {
////            check = studentDaoInterface.r
//        }catch(SQLException se) {
//            return Response.status(500).entity("Error : " + se).build();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        if(check)
//            return Response.status(201).entity("Semester Registration done Sucessfully").build();
//        return Response.status(201).entity("Semester Registration is already done.").build();
//    }
}
