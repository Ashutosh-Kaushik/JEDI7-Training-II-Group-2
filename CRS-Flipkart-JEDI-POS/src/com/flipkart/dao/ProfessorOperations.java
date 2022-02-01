package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.utils.ConnectionWithDB;
import com.flipkart.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProfessorOperations implements ProfessorUtilsInterface {
    public Map<String, ArrayList<String>> viewEnrolledStudentsWithDB(Professor professor) throws SQLException {

        Map<String,ArrayList<String>> students=new LinkedHashMap<>();
        ConnectionWithDB con=new ConnectionWithDB();
        Connection conn = con.getConnection();
        String sql = "select registrar.userId,user.userName,course.courseId,course.courseName " +
                "from registrar,user,course where registrar.courseId in(select courseId from professorreg " +
                "where professorreg.userId='"+professor.getProfessorId()+"' ) and registrar.userId=user.userId and " +
                "registrar.courseId=course.courseId ";

        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while(rs.next())
        {
            String user=rs.getString(1)+" "+rs.getString(2);
            String course=rs.getString(3)+" "+rs.getString(4);
            if(!students.containsKey(course))
                students.put(course,new ArrayList<>());
            students.get(course).add(user);
        }
        return students;
    }
    public void provideGrade(int courseId,String studentId,String Grade) throws SQLException {
        ConnectionWithDB connObj=new ConnectionWithDB();
        Connection con=connObj.getConnection();
        String SQL = "UPDATE registrar set grade='"+Grade+"' where userId='"+studentId+"' and courseId="+courseId;

        long id = 0;
        //inserting into table
        try (
                PreparedStatement pstmt = con.prepareStatement(SQL,
                        Statement.RETURN_GENERATED_KEYS)) {

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    public void registerCoursesWithDB(Professor professor,Course course) throws SQLException {
        ArrayList<Course> courses=new ArrayList<Course>();
        ConnectionWithDB connObj=new ConnectionWithDB();
        Connection con=connObj.getConnection();
        String SQL = "INSERT INTO professorreg(userId,courseId)"
                + "VALUES(?,?)";

        long id = 0;
        //inserting into table
        try (
                PreparedStatement pstmt = con.prepareStatement(SQL,
                        Statement.RETURN_GENERATED_KEYS)) {


            pstmt.setString(1, professor.getProfessorId());
            pstmt.setString(2, String.valueOf(course.getCourseId()));



            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    public ArrayList<Course> viewAvailableCoursesWithDB(Professor professor) throws SQLException {
        ArrayList<Course> courses=new ArrayList<Course>();
        ConnectionWithDB connObj=new ConnectionWithDB();
        Connection con=connObj.getConnection();
        String sql="select courseId,courseName from course where courseId not in (select courseId from professorReg)";
        PreparedStatement statement = con.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next())
        {
            Course course=new Course();
            course.setCourseId(rs.getInt(1));
            course.setCourseName(rs.getString(2));
            courses.add(course);
        }
        return courses;
    }
    public Professor validateCredentialsWithDB(String userId, String password){
        try{
            ConnectionWithDB connObj=new ConnectionWithDB();
            Connection con=connObj.getConnection();
            String SQL = "select * from user,professor where user.userId like '"+userId+"' and professor.professorId like '"+userId+"' and user.password like '"+password+"'";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(SQL);
            if(rs.next()) {
                Professor professor=new Professor(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8));
                con.close();
                return professor;
            }
            //while(rs.next())
            //    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8));
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        return null;
    }

    public ArrayList<Course> viewCoursesWithDB() throws SQLException{

            ArrayList<Course> courses=new ArrayList<Course>();
            ConnectionWithDB connection=new ConnectionWithDB();
            Connection conn = connection.getConnection();
            String sql = "SELECT * FROM course";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Course course=new Course();
                course.setCourseId(rs.getInt(1));
                course.setCourseName(rs.getString(2));
                courses.add(course);
            }
            return courses;

    }
    /*public static boolean validateCredentials2(int userId)throws ClassNotFoundException, SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crsregistration","root","root");
            String SQL = "select * from user,professor where user.userId="+userId+" and professor.professorId="+userId;
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(SQL);
            if(rs.next()) {
                con.close();
                return true;
            }
            //while(rs.next())
            //    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8));
            //con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        return false;
    }*/

    public static void main(String[] args)throws ClassNotFoundException, SQLException {

        try{
            Connection conn = DBUtils.getConnection();
            String sql = "SELECT * FROM user where userId = ? and password = ?";
//            String sql = "select * from user where userid="+studentId+" and password="+password;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,"B");
            statement.setString(2,"B");
            ResultSet rs = statement.executeQuery();
            /*while(rs.next())
            {
                Student student= getStudent(studentId);
                //  Student student=new Student(studentId,rs1.getString(3),rs1.getString(4), rs1.getString(2),rs1.getString(5),studentId,rs.getInt(2),rs.getString(3),rs.getString(4),true);
                return student;
            }*/
        }
        catch(Exception e){
            System.out.println(e);
        }



        /*ConnectionWithDB connObj=new ConnectionWithDB();
        Connection con=connObj.getConnection();

        String SQL = "INSERT INTO user(userId,userName,emailId,password,contactNo) "
                + "VALUES(?,?,?,?,?)";
        String SQL2 = "INSERT INTO student(studentId,semester,grade,feeStatus) " + "VALUES(?,?,?,?)";
        //Professor professor = new Professor("102", "Harika", "harika@gmai.com", "Harika", "8977284355",
        //"102", "Finance", 12);
        Student student =new Student("110","rama","rama@gmail.com","Rama","0123456789","110",1,"","NotPaid",true);


        long id = 0;
        //inserting into table
        try (
                PreparedStatement pstmt = con.prepareStatement(SQL,
                        Statement.RETURN_GENERATED_KEYS)) {


            pstmt.setString(1, student.getUserId());
            pstmt.setString(2, student.getUserName());
            pstmt.setString(3, student.getEmailId());
            pstmt.setString(4, student.getPassword());
            pstmt.setString(5, student.getContactNo());


            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        //inserting into professor
        try (
                PreparedStatement pstmt = con.prepareStatement(SQL2,
                        Statement.RETURN_GENERATED_KEYS)) {


            pstmt.setString(1, student.getUserId());
            pstmt.setString(2, String.valueOf(student.getSemester()));
            pstmt.setString(3, student.getGrade());
            pstmt.setString(4,student.isFeeStatus());


            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/

        /*ConnectionWithDB connObj=new ConnectionWithDB();
        Connection con=connObj.getConnection();
        String SQL = "INSERT INTO registrar(userId,courseId,grade) "
                + "VALUES(?,?,?)";

        long id = 0;
        //inserting into table
        try (
                PreparedStatement pstmt = con.prepareStatement(SQL,
                        Statement.RETURN_GENERATED_KEYS)) {
                        pstmt.setString(1,"104");
                        pstmt.setString(2,"1");
                        pstmt.setString(3,"");

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
        //inserting into professor

    }
}
/*
import java.sql.*;
class MysqlCon{
public static void main(String args[]){
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/sonoo","root","root");
//here sonoo is database name, root is username and password
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from emp");
while(rs.next())
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
con.close();
}catch(Exception e){ System.out.println(e);}
}
}


String SQL = "INSERT INTO actor(first_name,last_name) "
                + "VALUES(?,?)";

        long id = 0;

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, actor.getFirstName());
            pstmt.setString(2, actor.getLastName());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }




//validateCredentials2(102);
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/crsregistration", "root", "root");
        String SQL = "INSERT INTO user(userId,userName,emailId,password,contactNo) "
                + "VALUES(?,?,?,?,?)";
        String SQL2 = "INSERT INTO professor(professorId,areaOfExpertise,yoe) " + "VALUES(?,?,?)";
        //Professor professor = new Professor(103, "Meghana", "meghana@gmai.com", "Meghana", "9391645314",
                103, "Cloud", 24);

        long id = 0;
        //inserting into table
        try (
                PreparedStatement pstmt = con.prepareStatement(SQL,
                        Statement.RETURN_GENERATED_KEYS)) {


            pstmt.setString(1, String.valueOf(professor.getUserId()));
            pstmt.setString(2, professor.getUserName());
            pstmt.setString(3, professor.getEmailId());
            pstmt.setString(4, professor.getPassword());
            pstmt.setString(5, professor.getContactNo());


            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        //inserting into professor
        try (
                PreparedStatement pstmt = con.prepareStatement(SQL2,
                        Statement.RETURN_GENERATED_KEYS)) {


            pstmt.setString(1, String.valueOf(professor.getUserId()));
            pstmt.setString(2, professor.getAreaOfExpertise());
            pstmt.setString(3, String.valueOf(professor.getYearsOfExperience()));


            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


 */