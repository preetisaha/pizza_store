package com.pizza.dto.request;

public class DisplayEmployeeDetails {

	private String name;
	private String email;
	private int employee_id;
	
	public DisplayEmployeeDetails(String name, String email, int userId){
		this.name = name;
		this.email = email;
		this.employee_id = userId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getUserId() {
		return employee_id;
	}
}
