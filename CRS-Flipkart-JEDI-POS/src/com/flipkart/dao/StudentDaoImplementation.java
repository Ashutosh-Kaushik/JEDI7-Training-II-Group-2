package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StudentDaoImplementation implements StudentDaoInterface {


    @Override
    public String addStudent() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement stmt = connection.createStatement();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter userId:");
        String userId=sc.next();
        System.out.println("Enter password:");
        String password= sc.next();
        System.out.println("Enter userName:");
        String studentName= sc.next();
        System.out.println("Enter emaiId:");
        String emaiId= sc.next();
        System.out.println("Enter contactNo:");
        String contactNo= sc.next();
        System.out.println("Enter semester:");
        int semester=sc.nextInt();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.ADD_USER_QUERY);
        preparedStatement.setString(1,userId);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,studentName);
        preparedStatement.setString(4, emaiId);
        preparedStatement.setString(5, contactNo);
        int rows=preparedStatement.executeUpdate();

        PreparedStatement preparedStatement1 = connection.prepareStatement(SQLQueriesConstants.ADD_STUDENT_QUERY);
        preparedStatement1.setString(1,userId);
        preparedStatement1.setInt(2,semester);
        preparedStatement1.setString(3, " NA ");
        preparedStatement1.setString(4, " NA ");
        int rowsAffected1 = preparedStatement1.executeUpdate();
        if (rowsAffected1 == 1&&rows==1) {
            return "Student Added!";
        }
        return null;
    }

    @Override
    public Student getStudent(String studentId) throws SQLException {
        Connection conn = DBUtils.getConnection();
        String sql = "SELECT * FROM student where studentId="+studentId;
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        String sql1 = "SELECT * FROM user where userid="+studentId;
        PreparedStatement statement1 = conn.prepareStatement(sql1);
        ResultSet rs1 = statement1.executeQuery();
        while(rs.next()&& rs1.next())
        {
            Student student=new Student(studentId,rs1.getString(3),rs1.getString(4), rs1.getString(2),rs1.getString(5),studentId,rs.getInt(2),rs.getString(3),rs.getString(4),true);
            return student;
        }
        return null;
    }

    public Student validateCredentials(String studentId, String password){
        try{
            Connection conn = DBUtils.getConnection();
            String sql = "SELECT * FROM user where userid="+studentId+" and password="+password;
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Student student= getStudent(studentId);
                //  Student student=new Student(studentId,rs1.getString(3),rs1.getString(4), rs1.getString(2),rs1.getString(5),studentId,rs.getInt(2),rs.getString(3),rs.getString(4),true);
                return student;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public String getfeeStatus(String studentId) throws SQLException {
        Connection conn = DBUtils.getConnection();
        String sql = "SELECT feeStatus FROM student where studentId="+studentId;
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next())
        {
            return rs.getString("feeStatus");
        }
        return null;
    }

    @Override
    public ArrayList<Course> registeredCoursesList(String studentId) {
        return null;
    }

    @Override
    public String removeStudent(String studentId) throws SQLException {

        boolean st = true;
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            String sql = "delete from student where studentId = " + studentId;
        int rowsAffected = stmt.executeUpdate(sql);
        if (rowsAffected == 1) {
            return "Student Removed!";
        }
        return null;
    }

    @Override
    public GradeCard viewGrades(String studentId) throws SQLException {
        GradeCard gradeCard=null;
        Connection conn = DBUtils.getConnection();
        PreparedStatement stmt=conn.prepareStatement(SQLQueriesConstants.VIEW_GRADE_CARD);
        stmt.setString(1, studentId);
        ResultSet queryResult1 = stmt.executeQuery();
        stmt = conn.prepareStatement(SQLQueriesConstants.VIEW_REGISTERED_COURSES);
        stmt.setString(1, studentId);
        ResultSet queryResult2 = stmt.executeQuery();
        HashMap<String, String> grades = new HashMap<String, String>();
        while(queryResult2.next()) {
                grades.put(queryResult2.getString("course.courseId"), queryResult2.getString("gradeCard.grade"));
        }
        while(queryResult1.next()) {

        }
        return gradeCard;
    }
}
