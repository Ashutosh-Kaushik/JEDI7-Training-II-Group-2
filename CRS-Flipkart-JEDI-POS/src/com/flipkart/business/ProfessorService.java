package com.flipkart.business;

import com.flipkart.bean.Professor;
import com.flipkart.dao.ProfessorOperations;

public class ProfessorService implements ProfessorServiceInterface {
    public Professor validateCredentials(int userId,String password){
        ProfessorOperations profOp=new ProfessorOperations();
        return profOp.validateCredentialsWithDB(userId,password);
    }
}
