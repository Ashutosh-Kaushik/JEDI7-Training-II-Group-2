package com.flipkart.application;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDaoImplementation;
import org.apache.log4j.Logger;

import java.lang.*;
import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class CrsApplication {
    public static void main(String[] args) throws IOException, SQLException {
        final Logger logger = Logger.getLogger(CrsApplication.class);
        while(true){
            System.out.println("----------Welcome to Course Registration System----------");
            System.out.println("Main Menu \n1. Register\n2. Login\n3.Update Password\n4. Exit");
            System.out.println("---------------------------------------------------------");
            System.out.println("Enter your choice:");
            logger.debug("Abcdefg");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int choice=Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    StudentDaoImplementation studentDaoImplementation=new StudentDaoImplementation();
                    studentDaoImplementation.addStudent();
                    break;
                case 2:
                    CrsLoginMenu login = new CrsLoginMenu();
                    login.crsLoginMenu();
                    break;
                case 3:
                    System.out.println("Updating the password");
                    break;
                case 4:
                    System.out.println("Bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice!!!! Please enter Details Again");
            }

        }
    }
}
