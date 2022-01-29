package com.flipkart2.bean;

public class Professor extends User{
    private String areaOfExpertise;
    private int yearsOfExperience;
    public Professor(){

    }

    public Professor(int userId, String userName, String emailId, String password, String contactNo, String areaOfExpertise, int yearsOfExperience) {
        super(userId, userName, emailId, password, contactNo);
        this.areaOfExpertise = areaOfExpertise;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getAreaOfExpertise() {
        return areaOfExpertise;
    }

    public void setAreaOfExpertise(String areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
