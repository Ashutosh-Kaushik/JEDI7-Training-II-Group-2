package com.flipkart.business;

import com.flipkart.bean.Professor;

public interface ProfessorServiceInterface {
    public Professor validateCredentials(String userId,String password);
}
