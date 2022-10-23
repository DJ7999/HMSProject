package com.app.dto.temp;


import javax.validation.constraints.NotBlank;


public class AuthRequest {
	
	@NotBlank(message = "name can't be blank or null")
	private String name;
	
	@NotBlank(message = "password can't be blank or null")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthRequest [name=" + name + ", password=" + password + "]";
	}	
}
