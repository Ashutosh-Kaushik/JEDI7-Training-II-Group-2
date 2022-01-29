package com.flipkart.application;

import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDaoImplementation;

import java.sql.SQLException;

public class User {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Student s=new Student("1","2", "a","a","2");
        StudentDaoImplementation studentDaoImplementation=new StudentDaoImplementation();
        studentDaoImplementation.addStudent(s);
    }
}
