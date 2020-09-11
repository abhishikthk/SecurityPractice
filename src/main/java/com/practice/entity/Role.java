package com.practice.entity;

//import java.util.List;

import javax.persistence.*;



@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String role;
	
//	@ManyToMany(mappedBy = "roles")
//	List<Employee> employee;
	
	
	public Role() {
		super();
	}


	public Role(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
		//this.employee = employee;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


//	public List<Employee> getEmployee() {
//		return employee;
//	}
//
//
//	public void setEmployee(List<Employee> employee) {
//		this.employee = employee;
//	}
	
	
	
	
	
	
	

}
