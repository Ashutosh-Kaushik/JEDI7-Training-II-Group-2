package com.flipkart.service;

import com.flipkart.dao.UpdatePasswordDao;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePassword implements UpdatePasswordInterface{
    @Override
    public void updatePassword() throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter UserId");
        String userId=sc.next();
        System.out.println("Enter Old Password");
        String oldPassword=sc.next();
        System.out.println("Enter New Password");
        String newPassword=sc.next();
        UpdatePasswordDao updatePasswordDao=new UpdatePasswordDao();
        updatePasswordDao.updatePassword(userId,oldPassword,newPassword);
    }
}
