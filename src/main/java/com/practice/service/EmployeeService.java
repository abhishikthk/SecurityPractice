package com.practice.service;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.Employee;
import com.practice.entity.Phone;

import com.practice.model.EmployeeModel;
import com.practice.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	public EmployeeModel getEmployeeByID(long id) {
		Employee emp = employeeRepo.findById(id).orElse(new Employee());
		EmployeeModel em = new EmployeeModel();
		
		em.setId(emp.getId());
		em.setEmail(emp.getEmail());
		em.setAddress(emp.getAddress().getAddress());
		List<String> phone = new ArrayList<>();
		List<Phone> ph = emp.getPhone();
		for(Phone p:ph) {
			phone.add(p.getPhone());
		}
		em.setPhone(phone);	
//		List<String> role = new ArrayList<>();		
//		List<Role> roles = emp.getRoles();
//		for(Role r:roles) {
//			role.add(r.getRole());
//		}
//		em.setRoles(role);		
		em.setRole(emp.getRole().getRole());	
		return em;
		
	}
	

}
