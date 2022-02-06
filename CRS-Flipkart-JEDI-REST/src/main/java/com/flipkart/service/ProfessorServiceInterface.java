package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public interface ProfessorServiceInterface {
    public Professor validateCredentials(String userId,String password);
    public ArrayList<Course> viewAllCourses() throws SQLException, ClassNotFoundException;
    public void registerCourses(String professorId,int courseId) throws SQLException, IOException;
    public Map<String, ArrayList<String>> viewEnrolledStudents(String professorId) throws SQLException;
    public void assignGrades(String professorId, int courseId, String studentId, String grade) throws SQLException, IOException;
    }
