package com.practice.controller;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.practice.model.EmployeeModel;
import com.practice.security.AuthenticationRequest;
import com.practice.security.AuthenticationResponse;
import com.practice.security.JwtUtil;
import com.practice.security.MyUserDetailService;
import com.practice.service.EmployeeService;




@RestController
public class EmployeeController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetailService userDetailsService;
	
	@Autowired
	JwtUtil jwtTokenUtil;
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

//		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		return ResponseEntity.ok(jwt);
	}

	
	@GetMapping("/")
	public String home() {
		return "Welcome";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/employee/{id}")
	public EmployeeModel getEmployeeByID(@PathVariable long id) {
		return employeeService.getEmployeeByID(id);
	}

}
