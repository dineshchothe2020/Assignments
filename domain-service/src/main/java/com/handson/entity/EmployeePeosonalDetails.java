package com.handson.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Component
@Entity
public class EmployeePeosonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer empId;

    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private LocalDate dateOfJoining;
    private String techStack;

    @OneToOne(mappedBy = "employeePeosonalDetails")
    private EmployeeProjectDetails employeeProjectDetails;

    public EmployeeProjectDetails getEmployeeProjectDetails() {
        return employeeProjectDetails;
    }

    public EmployeePeosonalDetails() {
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public String getTechStack() {
        return techStack;
    }

    public EmployeePeosonalDetails setEmpId(Integer empId) {
        this.empId = empId;
        return this;
    }

    public EmployeePeosonalDetails setName(String name) {
        this.name = name;
        return this;
    }

    public EmployeePeosonalDetails setEmail(String email) {
        this.email = email;
        return this;
    }

    public EmployeePeosonalDetails setAddress(String address) {
        this.address = address;
        return this;
    }

    public EmployeePeosonalDetails setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public EmployeePeosonalDetails setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
        return this;
    }

    public EmployeePeosonalDetails setTechStack(String techStack) {
        this.techStack = techStack;
        return this;
    }

    public EmployeePeosonalDetails setEmployeeProjectDetails(EmployeeProjectDetails employeeProjectDetails) {
        this.employeeProjectDetails = employeeProjectDetails;
        return this;
    }
}
