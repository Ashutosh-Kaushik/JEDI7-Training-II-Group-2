package com.flipkart2.service;

import com.flipkart2.bean.Course;
import com.flipkart2.bean.Professor;

public interface AdminInterface {
    public void addProfessor(Professor professor);
    public void addCourse(Course course);
    public void dropCourse(int courseId);
    public boolean approveStudents(int abc);
//    public void generateReportCard(String studentId);
}
