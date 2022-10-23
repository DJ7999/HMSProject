package com.app.dto.temp;


import javax.validation.constraints.NotBlank;


public class AuthRequest {
	@NotBlank(message = "Email can't be blank or null")
	private String email;
	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return "AuthRequest [email=" + email + ", password=" + password + "]";
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
	@NotBlank(message = "password can't be blank or null")
	private String password;
}
