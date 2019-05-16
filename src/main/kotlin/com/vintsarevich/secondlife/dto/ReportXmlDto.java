package com.vintsarevich.secondlife.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "reportXmlDto")
public class ReportXmlDto {
    private String doctorName;
    private String doctorEmail;
    private String labName;
    private String labEmail;
    private String birth;
    private String gender;
    private String firstName;
    private String secondName;
    private String address;
    private String disease;
    private String testRecommendation;
    private String therapy;

    public ReportXmlDto(String doctorName, String doctorEmail, String labName, String labEmail, String birth, String gender, String firstName, String secondName, String address, String disease, String testRecommendation, String therapy) {
        this.doctorName = doctorName;
        this.doctorEmail = doctorEmail;
        this.labName = labName;
        this.labEmail = labEmail;
        this.birth = birth;
        this.gender = gender;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.disease = disease;
        this.testRecommendation = testRecommendation;
        this.therapy = therapy;
    }

    public ReportXmlDto() {
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getLabEmail() {
        return labEmail;
    }

    public void setLabEmail(String labEmail) {
        this.labEmail = labEmail;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getTestRecommendation() {
        return testRecommendation;
    }

    public void setTestRecommendation(String testRecommendation) {
        this.testRecommendation = testRecommendation;
    }

    public String getTherapy() {
        return therapy;
    }

    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }
}
