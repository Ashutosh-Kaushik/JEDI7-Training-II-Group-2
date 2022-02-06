package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.StudentDaoImplementation;
import com.flipkart.exception.CourseAlreadyRegisteredException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentOperations implements StudentInterface {

    private static volatile StudentOperations instance = null;
    private int value;
    // private constructor
    public StudentOperations() {
    }
    StudentDaoImplementation studentDaoImplementation=new StudentDaoImplementation();
    public static StudentOperations getInstance() {
        if (instance == null) {
            synchronized (StudentOperations.class) {
                instance = new StudentOperations();
            }
        }
        return instance;
    }

    @Override
    public void registeredCourseList(String studentId) throws SQLException {
      ArrayList<Integer> courses= studentDaoImplementation.registeredCoursesList(studentId);
      value = courses.size();
      for(Integer c:courses)
      {
          Course course=studentDaoImplementation.viewCourse(c);
        System.out.println(c+"-"+course.getCourseName());
      }
    }

    @Override
    public void registerCourses(String studentID) throws SQLException,CourseAlreadyRegisteredException{
        Scanner sc=new Scanner(System.in);
        System.out.println("The courses are: ");
        ArrayList<Course> courses= (ArrayList<Course>) viewCourses();
        System.out.println("CourseId-CourseName");
        for(Course c:courses)
            System.out.println(c.getCourseId()+"\t-\t"+c.getCourseName());
        if(courses.size()==4)
            System.out.println("You have reached your limit of max courses");
        else {

            System.out.println("Enter number of courses you want to register : ");
            int count = sc.nextInt();
            while(count>4) {
                System.out.println("You can register for max 4 courses");
                System.out.println("Enter number of courses you want to register : ");
                count = sc.nextInt();
            }
            ArrayList<Integer> selectedCourse = new ArrayList<Integer>();
            for (int i = 0; i < count; i++) {
                selectedCourse.add(sc.nextInt());
            }
            studentDaoImplementation.registerCourses(studentID, selectedCourse);
        }
    }

    @Override
    public void viewGradeCard(String studentId) throws SQLException {
     ArrayList<GradeCard> gradeCards=studentDaoImplementation.viewGrades(studentId);
     for(GradeCard g:gradeCards)
     {
         System.out.println(studentDaoImplementation.viewCourse(g.getCourseId()).getCourseName()+"-"+g.getGrade());
     }
    }


    @Override
    public List<Course> viewCourses() throws SQLException {
        return studentDaoImplementation.viewCourses();
    }
}
