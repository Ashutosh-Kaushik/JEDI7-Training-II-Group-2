package com.flipkart.application;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDaoImplementation;
import com.flipkart.service.StudentOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrsStudentMenu {

        public void studentMenu(Student student) throws IOException, SQLException {
            while(true) {
                System.out.println("---Student Menu-----");
                System.out.println("1.view Details\n2.view Courses\n3.Register for Courses\n4.View Report Card\n5.Pay Fee\n6.Check Fee Status\n7.View Registered Courses\n8.Exit\n");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter the choice");
                int option = Integer.parseInt(br.readLine());
                StudentOperations studentOperations=new StudentOperations();
                StudentDaoImplementation studentDaoImplementation=new StudentDaoImplementation();
                switch (option) {
                    case 1:
                        System.out.println("Details");
                        System.out.println("Id: "+student.getUserId()+"\nStudentName: "+student.getUserName()+"\nEmailId: "+student.getEmailId()+"\nSemester "+student.getSemester());
                        break;
                    case 2:
                        System.out.println("View Courses");
                        ArrayList<Course> courses= (ArrayList<Course>) studentOperations.viewCourses();
                        System.out.println("CourseId-CourseName");
                        for(Course c:courses)
                            System.out.println(c.getCourseId()+"\t-\t"+c.getCourseName());
                        break;
                    case 3:
                        System.out.println("Register for the courses");
                        studentOperations.registerCourses(student.getUserId());
                        break;
                    case 4:
                        System.out.println("View Report Card");
                        studentOperations.viewGradeCard(student.getUserId());
                        break;
                    case 5:
                        System.out.println("Pay Fee");

                        break;
                    case 6:
                        System.out.println("Check Fee Status");
                        System.out.println(studentDaoImplementation.getfeeStatus(student.getUserId()));
                        break;
                    case 7:
                        System.out.println("View Registered Courses");
                        studentOperations.registeredCourseList(student.getUserId());
                        break;
                    case 8:
                        return;
                    default:
                        System.out.println("Exit");
                }
            }
        }

    }