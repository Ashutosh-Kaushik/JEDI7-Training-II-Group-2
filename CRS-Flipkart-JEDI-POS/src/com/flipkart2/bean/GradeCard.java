package com.flipkart2.bean;

public class GradeCard {
    private int userId;
    private int courseId;
    private String grade;

    public GradeCard(int userId, int courseId, String grade) {
        this.userId = userId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
