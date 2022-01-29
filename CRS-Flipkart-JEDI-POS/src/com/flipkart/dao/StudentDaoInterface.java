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

    ArrayList<Course> registeredCoursesList(String studentId);

    GradeCard viewGrades(String studentId) throws SQLException;

}
