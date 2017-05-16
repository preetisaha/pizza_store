package com.pizza.domain;

public class UserLoginDomain {

	private int user_id;
	private String name;
	private String lastname;
	private String address;
	private String email;
	private String password;
	
	public UserLoginDomain(int user_id, String name, String lastname, String address, String email, String password) {
		this.name = name;
		this.lastname = lastname;
		this.address = address;
		this.email = email;
		this.password = password;
		this.user_id = user_id;

	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastname;
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
	public int getUser_id() {
		return user_id;
	}	
}
