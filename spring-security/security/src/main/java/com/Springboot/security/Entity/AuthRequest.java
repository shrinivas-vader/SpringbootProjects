package com.Springboot.security.Entity;

import jakarta.annotation.sql.DataSourceDefinition;

public class AuthRequest {
	
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}
	
	public void setusername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
