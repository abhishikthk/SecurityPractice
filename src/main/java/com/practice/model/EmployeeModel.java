package com.practice.model;

import java.util.List;

public class EmployeeModel {
	
	private Long id;
	private String email;
	private String address;
	private List<String> phone;
	private String role;
	
	
	public EmployeeModel() {
		super();
	}
	public EmployeeModel(Long id, String email, String address, List<String> phone,
			String role) {
		super();
		this.id = id;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.role = role;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getPhone() {
		return phone;
	}
	public void setPhone(List<String> phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
