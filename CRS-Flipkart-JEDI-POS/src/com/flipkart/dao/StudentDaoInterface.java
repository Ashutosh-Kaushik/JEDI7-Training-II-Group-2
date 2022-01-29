package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDaoInterface
{
    String addStudent(Student student) throws SQLException, ClassNotFoundException;

    String getfeeStatus(String studentId, int semester, String paymentID) throws SQLException;

    Student getStudent(String studentId) throws SQLException;

    ArrayList<Student> getAllStudents() throws SQLException;

    ArrayList<Course> registeredCoursesList(String studentId);

    String removeStudent(String studentId) throws SQLException;

    GradeCard viewGrades(String studentId) throws SQLException;

}
