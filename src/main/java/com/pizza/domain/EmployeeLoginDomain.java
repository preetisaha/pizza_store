package com.pizza.domain;

public class EmployeeLoginDomain {

	private int employee_id;
	private String name;
	private String last_name;
	private String address;
	private String email;
	private String password;
	
	public EmployeeLoginDomain(int employee_id, String name, String last_name, String address, String email, String password){
		this.employee_id = employee_id;
		this.name = name;
		this.last_name = last_name;
		this.address = address;
		this.email = email;
		this.password = password;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public String getName() {
		return name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
