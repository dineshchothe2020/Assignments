package com.handson.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class EmployeeProjectDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;

    private String role;
    private int experience;
    private String project;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="empId", referencedColumnName = "empId")
    private EmployeePeosonalDetails employeePeosonalDetails;

    public EmployeeProjectDetails() {
    }

    public Integer getId() {
        return id;
    }

    public EmployeePeosonalDetails getEmployeePeosonalDetails() {
        return employeePeosonalDetails;
    }

    public String getRole() {
        return role;
    }

    public int getExperience() {
        return experience;
    }

    public String getProject() {
        return project;
    }

    public EmployeeProjectDetails setId(Integer id) {
        this.id = id;
        return this;
    }

    public EmployeeProjectDetails setEmployeePeosonalDetails(EmployeePeosonalDetails employeePeosonalDetails) {
        this.employeePeosonalDetails = employeePeosonalDetails;
        return this;
    }

    public EmployeeProjectDetails setRole(String role) {
        this.role = role;
        return this;
    }

    public EmployeeProjectDetails setExperience(int experience) {
        this.experience = experience;
        return this;
    }

    public EmployeeProjectDetails setProject(String project) {
        this.project = project;
        return this;
    }
}
