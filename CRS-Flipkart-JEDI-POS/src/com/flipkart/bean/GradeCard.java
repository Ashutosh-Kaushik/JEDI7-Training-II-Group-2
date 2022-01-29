package com.flipkart.bean;

import java.util.HashMap;

public class GradeCard {
    private int userId;
    private HashMap<String, String> grades;

    public GradeCard(int userId, HashMap<String, String> grades) {
        this.userId = userId;
        this.grades = grades;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public HashMap<String, String> getGrades() {
        return grades;
    }

    public void setGrades(HashMap<String, String> grades) {
        this.grades = grades;
    }
}
