package com.hackhurricane.aashaconnect;

import java.util.Date;

public class classUpto15Years {

    private int UID;

    private String name;
    private String bloodGroup;
    private String motherName;
    private String fatherName;
    private String status;

    private String dateOfBirth;
    private Date dateOfReg;

    private String dateVaccine1;
    private String dateVaccine2;
    private String dateVaccine3;
    private String dateVaccine4;
    private String dateVaccine5;
    private String dateVaccine6;
    private String dateVaccine7;

    private String height;
    private String weight;

    public classUpto15Years(int UID, String name, String bloodGroup, String motherName, String fatherName, String dateOfBirth, String status, String dateVaccine1, String dateVaccine2, String dateVaccine3, String dateVaccine4, String dateVaccine5, String dateVaccine6, String dateVaccine7, String height, String weight) {
        this.UID = UID;
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        this.dateVaccine1 = dateVaccine1;
        this.dateVaccine2 = dateVaccine2;
        this.dateVaccine3 = dateVaccine3;
        this.dateVaccine4 = dateVaccine4;
        this.dateVaccine5 = dateVaccine5;
        this.dateVaccine6 = dateVaccine6;
        this.dateVaccine7 = dateVaccine7;
        this.height = height;
        this.weight = weight;
    }

    public classUpto15Years(int UID, String name, String date){
        this.name=name;
        this.dateOfBirth=date;
        this.UID=UID;
    }

    public classUpto15Years(int UID, String name, String date, String blood, String mother, String father){
        this.name=name;
        this.dateOfBirth=date;
        this.UID=UID;
        this.bloodGroup=blood;
        this.motherName=mother;
        this.fatherName=father;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
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

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getDateVaccine1() {
        return dateVaccine1;
    }

    public void setDateVaccine1(String dateVaccine1) {
        this.dateVaccine1 = dateVaccine1;
    }

    public String getDateVaccine2() {
        return dateVaccine2;
    }

    public void setDateVaccine2(String dateVaccine2) {
        this.dateVaccine2 = dateVaccine2;
    }

    public String getDateVaccine3() {
        return dateVaccine3;
    }

    public void setDateVaccine3(String dateVaccine3) {
        this.dateVaccine3 = dateVaccine3;
    }

    public String getDateVaccine4() {
        return dateVaccine4;
    }

    public void setDateVaccine4(String dateVaccine4) {
        this.dateVaccine4 = dateVaccine4;
    }

    public String getDateVaccine5() {
        return dateVaccine5;
    }

    public void setDateVaccine5(String dateVaccine5) {
        this.dateVaccine5 = dateVaccine5;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfReg() {
        return dateOfReg;
    }

    public void setDateOfReg(Date dateOfReg) {
        this.dateOfReg = dateOfReg;
    }

    public String getDateVaccine6() {
        return dateVaccine6;
    }

    public void setDateVaccine6(String dateVaccine6) {
        this.dateVaccine6 = dateVaccine6;
    }

    public String getDateVaccine7() {
        return dateVaccine7;
    }

    public void setDateVaccine7(String dateVaccine7) {
        this.dateVaccine7 = dateVaccine7;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
