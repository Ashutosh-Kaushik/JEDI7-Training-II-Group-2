package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDaoInterface
{
    String addStudent() throws SQLException, ClassNotFoundException;

    Student getStudent(String studentId) throws SQLException;

    Student validateCredentials(String studentId, String password);

    String getfeeStatus(String studentId) throws SQLException;

    ArrayList<Course> registeredCoursesList(String studentId);

    String removeStudent(String studentId) throws SQLException;

    GradeCard viewGrades(String studentId) throws SQLException;

}
