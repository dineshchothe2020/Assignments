package com.handson.repository;

import com.handson.entity.EmployeeProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDataRepository extends JpaRepository<EmployeeProjectDetails, Integer> {

}
