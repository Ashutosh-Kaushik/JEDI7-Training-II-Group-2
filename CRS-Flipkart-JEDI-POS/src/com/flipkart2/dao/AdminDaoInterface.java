package com.flipkart2.dao;

import com.flipkart2.bean.Course;
import com.flipkart2.bean.Professor;

public interface AdminDaoInterface {
    default boolean addProfessor(Professor professor) {
        return false;
    }
    boolean addCourse(Course course);
    boolean dropCourse(int courseId);
    boolean approveStudents(int abc);
//    ArrayList<Grade> fetchGrade(int userId);
}
