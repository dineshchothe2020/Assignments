package com.handson.presentationservice.controller;

import com.handson.presentationservice.pojo.Employee;
import com.handson.presentationservice.pojo.EmployeeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PresentationServiceRestController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/addEmployee")
    public Employee addEmployees(@RequestBody Employee employee) {
        String postUri = "http://domain-service/domain/addEmployee";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Employee> request = new HttpEntity<>(employee, headers);
        ResponseEntity<Employee> response = restTemplate.exchange(postUri, HttpMethod.POST, request, Employee.class);
        return response.getBody();
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        String postUri = "http://domain-service/domain/allEmployees";
        EmployeeList employeeList = restTemplate.getForObject(postUri, EmployeeList.class);
        return employeeList.getEmployeeList();
    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employeeFullDetails) {
        String uri = "http://domain-service/domain/updateEmployee";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Employee> request = new HttpEntity<>(employeeFullDetails, headers);
        ResponseEntity<Employee> response = restTemplate.exchange(uri, HttpMethod.PUT, request, Employee.class);
        return response.getBody();
    }

    @GetMapping("/employee/{empId}")
    public Employee getEmployeeById(@PathVariable String empId) {
        String postUri = "http://domain-service/domain/employee/{empId}";
        return restTemplate.getForObject(postUri, Employee.class, empId);
    }
}
