package com.flipkart.application;

import com.flipkart.bean.Professor;
import com.flipkart.business.ProfessorService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CrsLoginMenu {
    public void crsLoginMenu()throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the User Type\n1.Student \n2.Professor \n3.Admin");
        int userType=Integer.parseInt(br.readLine());
        System.out.println("Enter the userId:");
        int userId=Integer.parseInt(br.readLine());
        System.out.println("Enter the password:");
        String password=br.readLine();
        switch(userType){
            case 1:
                System.out.println("Student Details are validated");
                break;
            case 2:
                System.out.println("Validating Professor credentials");
                ProfessorService profServ=new ProfessorService();
                Professor professor=profServ.validateCredentials(userId,password);
                if(professor!=null){
                    System.out.println("Hey Professor. Welcome to the portal");
                    CrsProfessorMenu crsProfessorMenu=new CrsProfessorMenu();
                    crsProfessorMenu.professorMenu(professor);
                }
                else{
                    System.out.println("Invalid User ID");
                    return;
                }
                break;
            case 3:
                System.out.println("Admin");
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
}
