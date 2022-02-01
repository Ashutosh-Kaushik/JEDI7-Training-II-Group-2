package com.flipkart.utils;

import com.flipkart.bean.Professor;

import java.sql.SQLException;

public interface ProfessorUtilsInterface {
    public Professor validateCredentialsWithDB(String userId,String password) throws ClassNotFoundException, SQLException;
}
