package com.handson.domainservice;

import com.handson.entity.EmployeePeosonalDetails;
import com.handson.entity.EmployeeProjectDetails;
import com.handson.pojo.EmployeeDetails;
import com.handson.repository.EmploeePersonalDataRepository;
import com.handson.repository.EmployeeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DomainService {
    @Autowired
    private EmployeeDataRepository employeeDataRepository;

    @Autowired
    private EmploeePersonalDataRepository employeePersonalDataRepository;

    public EmployeeDetails addEmployee(EmployeeDetails employeeDetails) {
        EmployeeProjectDetails empDetails = new EmployeeProjectDetails();
        EmployeePeosonalDetails details = new EmployeePeosonalDetails();
        details.setName(employeeDetails.getName());
        details.setAddress(employeeDetails.getAddress());
        details.setDateOfJoining(employeeDetails.getDateOfJoining());
        details.setPhoneNumber(employeeDetails.getPhoneNumber());
        details.setEmail(employeeDetails.getEmail());
        details.setTechStack(employeeDetails.getTechStack());

        empDetails.setEmployeePeosonalDetails(details);
       //Assign the project based on tech stack
        switch  (details.getTechStack()) {
          case  "Angular":  empDetails.setProject("AngularProject");
                          break;
          case  "M/S" : empDetails.setProject("MSProject");
                          break;
          case  "Android" : empDetails.setProject("Android Project");
                          break;
          case  "" :   empDetails.setProject("Project Details not available.");
        }
        //Assign the role as per experience
        int expYears = LocalDate.now().getYear() - employeeDetails.getDateOfJoining().getYear();
        if(expYears <= 5){
            empDetails.setRole("Developer");
        } else if(expYears <=10){
            empDetails.setRole("Tech Lead");
        }else {
            empDetails.setRole("Architect");
        }
        employeeDataRepository.save(empDetails);
        employeeDetails.setEmpId(empDetails.getId());
        return employeeDetails;
    }

    /**
     * Fetch all Employee details
     * @return
     */
    public List<EmployeeDetails> getAllEmployeesDetails() {
        List<EmployeeProjectDetails> all = employeeDataRepository.findAll();
        List<EmployeeDetails>  empDetailsList = new ArrayList<>();
        for (EmployeeProjectDetails empProjDetails: all) {
            EmployeeDetails employeeDetails = new EmployeeDetails();
            employeeDetails.setEmpId(empProjDetails.getId());
            employeeDetails.setProjectName(empProjDetails.getProject());
            //employeeDetails.setEempProjDetails.getExperience());
            employeeDetails.setRole(empProjDetails.getRole());
            employeeDetails.setAddress(empProjDetails.getEmployeePeosonalDetails().getAddress());
            employeeDetails.setEmail(empProjDetails.getEmployeePeosonalDetails().getEmail());
            employeeDetails.setName(empProjDetails.getEmployeePeosonalDetails().getName());
            employeeDetails.setPhoneNumber(empProjDetails.getEmployeePeosonalDetails().getPhoneNumber());
            empDetailsList.add(employeeDetails);
        }
        return empDetailsList;
    }

    public EmployeeDetails updateEmployee(EmployeeDetails employeeDetails) {
        EmployeePeosonalDetails empPersonalDetails = employeePersonalDataRepository.findByEmpId(employeeDetails.getEmpId());
        empPersonalDetails.setAddress(employeeDetails.getAddress());
        empPersonalDetails.setEmail(employeeDetails.getEmail());
        empPersonalDetails.setName(employeeDetails.getName());
        empPersonalDetails.setPhoneNumber(employeeDetails.getPhoneNumber());
        empPersonalDetails.setTechStack(employeeDetails.getTechStack());
        empPersonalDetails.setDateOfJoining(employeeDetails.getDateOfJoining());
        employeePersonalDataRepository.save(empPersonalDetails);
        return employeeDetails;
    }

    public EmployeeDetails getEmployeeByEmpId(String empId) {
        EmployeePeosonalDetails empPersonalDetails = employeePersonalDataRepository.findByEmpId(Integer.parseInt(empId));
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setEmpId(empPersonalDetails.getEmpId());
        employeeDetails.setProjectName(empPersonalDetails.getEmployeeProjectDetails().getProject());
        //employeeDetails.setEempProjDetails.getExperience());
        employeeDetails.setRole(empPersonalDetails.getEmployeeProjectDetails().getRole());
        employeeDetails.setAddress(empPersonalDetails.getAddress());
        employeeDetails.setEmail(empPersonalDetails.getEmail());
        employeeDetails.setName(empPersonalDetails.getName());
        employeeDetails.setPhoneNumber(empPersonalDetails.getPhoneNumber());
        return employeeDetails;
    }
}
