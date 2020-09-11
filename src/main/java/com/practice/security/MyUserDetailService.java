package com.practice.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.entity.Employee;
import com.practice.repo.EmployeeRepo;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	EmployeeRepo employeeRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Employee employee = employeeRepo.findByEmail(email);
		
		if(employee==null) {
			throw new UsernameNotFoundException("user not found ");
		}
		
		return new MyEmployeeDetails(employee);
	}

	
	
}
