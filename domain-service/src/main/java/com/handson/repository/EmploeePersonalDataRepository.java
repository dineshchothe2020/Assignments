package com.handson.repository;

import com.handson.entity.EmployeePeosonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmploeePersonalDataRepository extends JpaRepository<EmployeePeosonalDetails, Integer> {
    public EmployeePeosonalDetails findByEmpId(Integer empId);
}
