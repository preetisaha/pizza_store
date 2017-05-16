package com.pizza.dto;

public class DisplayUserDetails {

	private String name;
	private String email;
	private int userId;
	
	public DisplayUserDetails(String name, String email, int userId){
		this.name = name;
		this.email = email;
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getUserId() {
		return userId;
	}
	
}
