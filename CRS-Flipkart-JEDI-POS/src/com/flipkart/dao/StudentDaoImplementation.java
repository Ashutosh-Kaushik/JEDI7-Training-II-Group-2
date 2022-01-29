package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentDaoImplementation implements StudentDaoInterface {


    @Override
    public String addStudent(Student student) throws SQLException {
        Connection connection = DbUtil.getConnection();
        Statement stmt = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.ADD_STUDENT_QUERY);
        preparedStatement.setString(1, student.getUserId().toString());
        preparedStatement.setInt(4, (student.getSemester()));
        preparedStatement.setString(5, " NA ");
        preparedStatement.setBoolean(6, false);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected == 1) {
            return "Student Added!";
        }
        return null;
    }


    @Override
    public String getfeeStatus(String studentId, int semester, String paymentId) throws SQLException {
        Connection conn = DbUtil.getConnection();
        String sql = "SELECT feeStatus FROM student";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next())
        {
            return rs.getString("feeStatus");
        }
        return null;
    }

    @Override
    public Student getStudent(String studentId) throws SQLException {
        Connection conn = DbUtil.getConnection();
        String sql = "SELECT * FROM student where studentId='studentId'";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            Student student = new Student();
            student.setUserId(rs.getString("studentId"));
            student.setUserName(rs.getString("studentName"));
            student.setContactNo(rs.getString("contactNo"));
            student.setSemester(rs.getInt("semester"));
            student.setGrade(rs.getString("grade"));
            student.setFeeStatus(rs.getBoolean("feeStatus"));
            return student;
        }
        return null;
    }

    @Override
    public ArrayList<Student> getAllStudents() throws SQLException {
        ArrayList<Student> students = new ArrayList<Student>();
            Connection conn = DbUtil.getConnection();
            String sql = "SELECT * FROM student";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Student student = new Student();
                student.setUserId(rs.getString("studentId"));
                student.setUserName(rs.getString("studentName"));
                student.setContactNo(rs.getString("contactNo"));
                student.setSemester(rs.getInt("semester"));
                student.setGrade(rs.getString("grade"));
                student.setFeeStatus(rs.getBoolean("feeStatus"));
                students.add(student);
            }
        return students;
    }

    @Override
    public ArrayList<Course> registeredCoursesList(String studentId) {
        return null;
    }

    @Override
    public String removeStudent(String studentId) throws SQLException {

        boolean st = true;
            Connection con = DbUtil.getConnection();
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
        Connection conn = DbUtil.getConnection();
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
