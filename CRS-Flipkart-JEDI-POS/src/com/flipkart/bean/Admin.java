package com.flipkart.bean;

public class Admin extends User{
    private int userId;
    private String instituteName;

    public Admin(int userId, String userName, String emailId, String password, String contactNo, int userId1, String instituteName) {
        super(userId, userName, emailId, password, contactNo);
        this.userId = userId1;
        this.instituteName = instituteName;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }
}
