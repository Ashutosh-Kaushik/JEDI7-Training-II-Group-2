package com.flipkart.service;

import com.flipkart.bean.Course;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public interface StudentInterface {

    public Vector<Course> registeredCourseList(String studentId) throws SQLException;
    public void registerCourses(String studentID) throws SQLException;

    void viewGradeCard(String studentId) throws SQLException;

    public List<Course> viewCourses() throws SQLException;
}

