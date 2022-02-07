package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.dao.ProfessorOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;


public class ProfessorService implements ProfessorServiceInterface {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    ProfessorOperations profOp=new ProfessorOperations();

    public Professor validateCredentials(String userId,String password){

        return profOp.validateCredentialsWithDB(userId,password);
    }
    public ArrayList<Course> viewAllCourses() throws SQLException{
        return profOp.viewCoursesWithDB();
    }
    public Map<String, ArrayList<String>> viewEnrolledStudents(String professor) throws SQLException {
        Map<String,ArrayList<String>> students=profOp.viewEnrolledStudentsWithDB(professor);
        return students;
    }
    public void assignGrades(String professorId, int courseId, String studentId, String grade) throws SQLException, IOException {

        profOp.provideGrade(courseId,studentId,grade);
    }
    public void registerCourses(String professorId,int courseId) throws SQLException, IOException {
        profOp.registerCoursesWithDB(professorId,courseId);
    }

}
