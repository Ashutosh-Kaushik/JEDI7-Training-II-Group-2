package com.flipkart.bean;

public class Admin extends User{
    private String userId;
    private String instituteName;

    public Admin(String userId, String userName, String emailId, String password, String contactNo, String userId1, String instituteName) {
        super(userId, userName, emailId, password, contactNo);
        this.userId = userId1;
        this.instituteName = instituteName;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }
}
