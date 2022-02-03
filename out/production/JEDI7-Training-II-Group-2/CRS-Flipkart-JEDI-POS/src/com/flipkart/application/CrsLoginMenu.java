package com.flipkart.application;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.business.ProfessorService;
import com.flipkart.dao.AdminDaoImplementation;
import com.flipkart.dao.StudentDaoImplementation;
import com.flipkart.service.StudentOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class CrsLoginMenu {
    public void crsLoginMenu() throws IOException, SQLException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the User Type\n1.Student \n2.Professor \n3.Admin");
        int userType=Integer.parseInt(br.readLine());
        System.out.println("Enter the userId:");
        String userId=br.readLine();
        System.out.println("Enter the password:");
        String password=br.readLine();
        switch(userType){
            case 1:

                System.out.println("Validating Student credentials");
                StudentDaoImplementation studentDaoImplementation=new StudentDaoImplementation();
                Student student=studentDaoImplementation.validateCredentials(userId,password);

                if(student!=null && student.isApproved()){
                    System.out.println("Hey Student. Welcome to the portal");
                    CrsStudentMenu crsStudentMenu=new CrsStudentMenu();
                    crsStudentMenu.studentMenu(student);
                }
                else{
                    System.out.println("Invalid User ID or student is not approved");
                    return;
                }
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
                System.out.println("Validating Admin credentials");
                AdminDaoImplementation adminDaoImplementation=new AdminDaoImplementation();
                boolean x= adminDaoImplementation.validateCredentials(userId,password);
                if(x==true){
                    System.out.println("Hey Admin. Welcome to the portal");
                    AdminMenu adminMenu=new AdminMenu();
                    adminMenu.adminMenu();
                }
                else{
                    System.out.println("Invalid User ID");
                    return;
                }
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
}