package com.practice.entity;

import javax.persistence.*;

@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String phone;

	@ManyToOne
	private Employee employee;

	public Phone() {
		super();
	}

	public Phone(Long id, String phone, Employee employee) {
		super();
		this.id = id;
		this.phone = phone;
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
