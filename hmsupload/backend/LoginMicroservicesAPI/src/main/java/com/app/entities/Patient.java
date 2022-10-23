package com.app.entities;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patient_id")
	private Long patientId;
	
	@Column(name="name",nullable = false,length=30)
	private String name;
	
	@Column(name="birth_date",nullable = false)
	private LocalDateTime birthDate;
	
	
	@Column(name="address",nullable = false,length=100)
	private String address;
	
	@Column(name="mobile_no",nullable = false)
	@Size(max=10,min=10,message="enter 10 digit mobile number")
	@Pattern(regexp = "^[0-9]{10}$",message = "enter 10 digit mobile number") 
	private String mobileNo;
	
	@Column(name="password",nullable = false,length=30)
	private String password;	
	@Transient
	private String confirmPassword;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(String name, LocalDateTime birthDate, int age, String address,
			@Size(max = 10, min = 10, message = "enter 10 digit mobile number") @Pattern(regexp = "^[0-9]{10}$", message = "enter 10 digit mobile number") String mobileNo,
			String password, String confirmPassword) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		
		this.address = address;
		this.mobileNo = mobileNo;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", birthDate=" + birthDate + ", address=" + address + ", mobileNo=" + mobileNo + "]";
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	private String getPassword()
	{
		return this.password ;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	private String getConfirmPassword() {
		return this.confirmPassword = confirmPassword;
	}
	public boolean equatePassword() {
		return getPassword().equals(getConfirmPassword());
	}
}
