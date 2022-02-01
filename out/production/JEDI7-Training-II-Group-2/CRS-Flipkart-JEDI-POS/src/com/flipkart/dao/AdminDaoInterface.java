package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface AdminDaoInterface {
    default boolean addProfessor(Professor professor) {
        return false;
    }
    boolean addCourse(Course course);
    boolean dropCourse(int courseId);
    boolean approveStudents(int abc);
    boolean validateCredentials(String adminId, String password);

//    ArrayList<Grade> fetchGrade(int userId);
}
