package com.flipkart.bean;

public class Professor extends User{
    private String userId;
    private String areaOfExpertise;
    private int yearsOfExperience;

    public Professor(String userId, String userName, String emailId, String password, String contactNo, String userId1, String areaOfExpertise, int yearsOfExperience) {
        super(userId, userName, emailId, password, contactNo);
        this.userId = userId1;
        this.areaOfExpertise = areaOfExpertise;
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
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
