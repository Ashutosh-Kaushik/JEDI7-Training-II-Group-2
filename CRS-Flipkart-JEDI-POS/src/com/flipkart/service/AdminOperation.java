package com.flipkart2.service;

import com.flipkart2.bean.Course;
import com.flipkart2.bean.Professor;
import com.flipkart2.dao.AdminDaoImplementation;
import com.flipkart2.dao.AdminDaoInterface;

public class AdminOperation implements AdminInterface {
    private static volatile AdminOperation instance = null;

    // private constructor
    private AdminOperation() {
    }

    public static AdminOperation getInstance() {
        if (instance == null) {
            synchronized (AdminOperation.class) {
                instance = new AdminOperation();
            }
        }
        return instance;
    }

    @Override
    public void addProfessor(Professor professor) {
        AdminDaoInterface admin = AdminDaoImplementation.getInstance();
        boolean ok = admin.addProfessor(professor);
        if(ok) {
            System.out.println("Professor added");
            System.out.println("+++++++++++++++++++++++");
        }
        else {
            System.out.println("Professor not added");
        }
    }

    @Override
    public void addCourse(Course course){
        AdminDaoInterface admin = AdminDaoImplementation.getInstance();
        boolean ok = admin.addCourse(course);
        if(ok) {
            System.out.println("Course added");
            System.out.println("+++++++++++++++++++++++");
        }
        else {
            System.out.println("Course not added");
        }

    }

    @Override
    public void dropCourse(int courseId){
        AdminDaoInterface admin = AdminDaoImplementation.getInstance();
        boolean ok = admin.dropCourse(courseId);
        if(ok) {
            System.out.println("Course Dropped");
            System.out.println("+++++++++++++++++++++++");
        }
        else {
            System.out.println("Cant drop course");
        }

    }

    @Override
    public boolean approveStudents(int abc) {
        AdminDaoInterface admin = AdminDaoImplementation.getInstance();
        boolean ok = admin.approveStudents(abc);
        if(ok) {
            System.out.println("Approved");
            System.out.println("+++++++++++++++++++++++");
            return true;
        }
        else {
            System.out.println("Cant drop course");
            return false;
        }
    }

//    @Override
//    public void generateReportCard(String studentId) {
//
//    }
}