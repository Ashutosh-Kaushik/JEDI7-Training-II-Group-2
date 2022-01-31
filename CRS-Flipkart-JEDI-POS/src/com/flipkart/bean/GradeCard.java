package com.flipkart.bean;

public class GradeCard {
    private String userId;
    private int courseId;
    private String grade;

    public GradeCard(String userId, int courseId, String grade) {
        this.userId = userId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}