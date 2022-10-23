package com.app.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patient_id")
	private Long patientId;
	
	@Column(name="name",nullable = false,length = 30)
	@NotNull
	private String name;
	
	@Column(name="birth_date",nullable = false)
	@NotNull
	//@Pattern(regexp = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$")
	private Date birthDate;
		
	@Column(name="address",nullable = false,length=100)
	@NotNull
	private String address;
		
	@Column(name="mobile_no",nullable = false)
	@Size(max=10,min=10,message="enter 10 digit mobile number")
	@Pattern(regexp = "^[0-9]{10}$",message = "enter 10 digit mobile number") 
	@NotNull
	private String mobileNo;
		
	@Column(name="password",nullable = false,length=500)
	@NotNull
	private String password;
	
	@Transient	
	private String confirmPassword;

}
