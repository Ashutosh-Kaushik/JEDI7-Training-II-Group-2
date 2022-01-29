package com.flipkart.bean;

public class Student extends User{

    private int studentId;
    private int semester;
    private String grade;
    private boolean feeStatus;

    public Student(String userId, String userName, String emailId, String password, String contactNo) {
        super(userId, userName, emailId, password, contactNo);
    }

    public Student() {
        super();
    }


    @Override
    public String getUserId() { return getUserId();}

    public void setUserId(String userId) {
        this.setUserId(userId);
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
}
