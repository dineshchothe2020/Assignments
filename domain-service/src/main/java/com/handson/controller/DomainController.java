package com.handson.controller;

import com.handson.domainservice.DomainService;
import com.handson.pojo.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DomainController {

    @Autowired
    private DomainService domainService;

    //public java.util.Logger logger = new Logger(DomainService.class);

    @PostMapping(value = "/domain/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDetails addEmployee(@RequestBody EmployeeDetails employee) {
        System.out.println("-------Domain Service---------");
        return domainService.addEmployee(employee);
    }

    @GetMapping(value = "/domain/allEmployees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDetails> getAllEmployees() {
        List<EmployeeDetails> allEmployeesDetails = domainService.getAllEmployeesDetails();
        return allEmployeesDetails;
    }

    @PutMapping("/domain/updateEmployee")
    public EmployeeDetails updateEmployee(@RequestBody EmployeeDetails employeeFullDetails) {
        return domainService.updateEmployee(employeeFullDetails);
    }

    @GetMapping("/domain/employee/{empId}")
    public EmployeeDetails getEmployeeById(@PathVariable String empId) {
        return domainService.getEmployeeByEmpId(empId);
    }
}
