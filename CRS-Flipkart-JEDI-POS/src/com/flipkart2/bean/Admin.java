package com.flipkart2.bean;

public class Admin extends User{
    private String adminId;
    private String instituteName;

    public Admin(String userId, String userName, String emailId, String password, String contactNo, String adminId, String instituteName) {
        super(userId, userName, emailId, password, contactNo);
        this.adminId = adminId;
        this.instituteName = instituteName;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }
}
