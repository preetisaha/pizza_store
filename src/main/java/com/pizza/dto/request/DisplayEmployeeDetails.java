package com.pizza.dto.request;

public class DisplayEmployeeDetails {

	private String name;
	private String email;
	private int employee_id;
	
	public DisplayEmployeeDetails(String name, String email, int employee_id){
		this.name = name;
		this.email = email;
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	
}
