package com.flipkart.bean;

public class Student extends User{

    private String userId;
    private int semester;
    private String grade;
    private boolean feeStatus;
    private boolean isApproved;

    public Student(String userId, String userName, String emailId, String password, String contactNo, String userId1, int semester, String grade, boolean feeStatus,boolean isApproved) {
        super(userId, userName, emailId, password, contactNo);
        this.userId = userId1;
        this.semester = semester;
        this.grade = grade;
        this.feeStatus = feeStatus;
        this.isApproved = isApproved;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public void setUserId(String userId) {
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
