package com.hackhurricane.aashaconnect;

public class Users {
    private String name;
    private String email;
    private String mobile;

    private String bloodGroup;
    private int AashaID;


    public Users(String name, String email, String mobile,int AashaID) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.AashaID = AashaID;
    }

    public Users(String name, String email, String mobile, String bloodGroup, int AashaID) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.bloodGroup = bloodGroup;
        this.AashaID = AashaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getAashaID() {
        return AashaID;
    }

    public void setAashaID(int AashaID) {
        this.AashaID = AashaID;
    }
}

