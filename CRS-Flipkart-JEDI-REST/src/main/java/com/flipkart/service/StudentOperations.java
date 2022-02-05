package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.dao.StudentDaoImplementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentOperations implements StudentInterface {

    private static volatile StudentOperations instance = null;

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
      for(Integer c:courses)
      {
          Course course=studentDaoImplementation.viewCourse(c);
        System.out.println(c+"-"+course.getCourseName());
      }
    }

    @Override
    public void registerCourses(String studentID) throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("The courses are: ");
        System.out.println("View Courses");
        ArrayList<Course> courses= (ArrayList<Course>) viewCourses();
        System.out.println("CourseId-CourseName");
        for(Course c:courses)
            System.out.println(c.getCourseId()+"\t-\t"+c.getCourseName());
        System.out.println("Enter the course ids to be registered");
        ArrayList<Integer> selectedCourse=new ArrayList<Integer>();
        for(int i=0;i<4;i++)
        {
            selectedCourse.add(sc.nextInt());
        }
        studentDaoImplementation.registerCourses(studentID,selectedCourse);
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
