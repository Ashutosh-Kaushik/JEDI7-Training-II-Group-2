package com.flipkart2.bean;

public class Student extends User{

    private int userId;
    private int semester;
    private String grade;
    private boolean feeStatus;
    private boolean isApproved;

    public Student(int userId, String userName, String emailId, String password, String contactNo, int userId1, int semester, String grade, boolean feeStatus,boolean isApproved) {
        super(userId, userName, emailId, password, contactNo);
        this.userId = userId1;
        this.semester = semester;
        this.grade = grade;
        this.feeStatus = feeStatus;
        this.isApproved = isApproved;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean isFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(boolean feeStatus) {
        this.feeStatus = feeStatus;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
}
