package com.flipkart.bean;

public class Student extends User{

    private String studentId;
    private int semester;
    private String grade;
    private boolean feeStatus;

    public Student(String userId, String userName, String emailId, String password, String contactNo, String studentId, int semester, String grade, boolean feeStatus) {
        super(userId, userName, emailId, password, contactNo);
        this.studentId = studentId;
        this.semester = semester;
        this.grade = grade;
        this.feeStatus = feeStatus;
    }
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
