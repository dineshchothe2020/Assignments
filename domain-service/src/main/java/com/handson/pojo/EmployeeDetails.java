package com.handson.pojo;


import lombok.Generated;

import java.time.LocalDate;

public class EmployeeDetails {
    private Integer empId;
    private String name;
    private String address;
    private String phoneNumber;
    private LocalDate dateOfJoining;
    private String techStack;
    private String email;
    private String role;
    private String projectName;

    public EmployeeDetails() {
    }

    public EmployeeDetails(Integer empId, String name, String address, String phoneNumber, LocalDate dateOfJoining, String techStack, String email, String role, String projectName) {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfJoining = dateOfJoining;
        this.techStack = techStack;
        this.email = email;
        this.role = role;
        this.projectName = projectName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}

