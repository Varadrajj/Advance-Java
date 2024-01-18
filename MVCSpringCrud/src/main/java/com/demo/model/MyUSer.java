package com.demo.model;

import org.springframework.stereotype.Component;

//@Component
public class MyUSer {
	private String username;
	private String password;
	public MyUSer() {
		super();
	}
	public MyUSer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "MyUSer [username=" + username + ", password=" + password + "]";
	}
	
}
