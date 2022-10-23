package com.app.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PatientDto {

	private Long patientId;	
	
	@Length(min = 1,max = 30)
	@NotNull
	private String name;
	
	@NonNull
	private Date birthDate;	
	
	@NotNull
	@Length(min = 1,max = 100)
	private String address;
	

	@Size(max=10,min=10,message="enter 10 digit mobile number")
	@Pattern(regexp = "^[0-9]{10}$",message = "enter 10 digit mobile number") 
	private String mobileNo;


	public PatientDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PatientDto(Long patientId, @Length(min = 1, max = 30) @NotNull String name, @NonNull Date birthDate,
			@NotNull @Length(min = 1, max = 100) String address,
			@Size(max = 10, min = 10, message = "enter 10 digit mobile number") @Pattern(regexp = "^[0-9]{10}$", message = "enter 10 digit mobile number") String mobileNo) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.birthDate = birthDate;
		this.address = address;
		this.mobileNo = mobileNo;
	}	
	
}
