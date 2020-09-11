package com.practice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
	Employee findByEmail(String email);
	
}
