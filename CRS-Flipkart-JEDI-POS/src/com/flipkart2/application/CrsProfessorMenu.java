package com.flipkart.application;

import com.flipkart.bean.Professor;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CrsProfessorMenu {
    public void professorMenu(Professor professor)throws IOException {
        while(true) {
            System.out.println("---Professor Menu-----");
            System.out.println("1.view Details\n2.view Courses\n3.Register for Courses\n4.View Enrolled Students in courses\n5.Make Report Card for a student\n6.Exit");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the choice");
            int option = Integer.parseInt(br.readLine());
            switch (option) {
                case 1:
                    System.out.println("Details");
                    System.out.println("Id: "+professor.getUserId()+"\nProfessorName: "+professor.getUserName()+"\nEmailId: "+professor.getEmailId()+"\nAreaOfExpertise: "+professor.getAreaOfExpertise()+"\nYearsOfExperience: "+professor.getYearsOfExperience());
                    break;
                case 2:
                    System.out.println("View Courses");
                    break;
                case 3:
                    System.out.println("Register for the courses");
                    break;
                case 4:
                    System.out.println("View enrolled students in each course");
                    break;
                case 5:
                    System.out.println("Make a report card for a student");
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid Choice");

            }
        }
    }

}
