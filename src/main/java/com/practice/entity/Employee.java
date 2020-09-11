package com.practice.entity;

import java.util.*;

import javax.persistence.*;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	private String password;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
    @OneToMany
    @JoinTable(name = "employee_phone", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "phone_id"))
	private List<Phone> phone = new ArrayList<>();

    
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable( name = "employee_roles", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private List<Role> roles;

    @OneToOne
	@JoinColumn(name = "role_id")
    private Role role;
    
	public Employee() {
		super();
	}

	public Employee(Long id, String email, String password, Address address, List<Phone> phone, Role role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone = phone;
		//this.roles = roles;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


    
    
    
	
}
