 package com.revature.domain;

public class Customer {
	
	int id;
	String username;
	String password;
	boolean admin;
	
	public Customer() {
		super();
	}
	
	public Customer(String userName, String password) {
		super();
		this.username = userName;
		this.password = password;
	}
	
	public Customer(int id, String username, String password, boolean admin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.admin = admin;
	}

	public void setPassword(String password) { //to change password
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password=" + password + ", admin=" + admin + "]";
	}	
}

