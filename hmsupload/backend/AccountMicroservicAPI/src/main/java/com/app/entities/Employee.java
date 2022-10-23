package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long empId;

	@Column(name = "emp_name",nullable = false,length = 30)
	private String empName;

	@Column(name = "birth_date",nullable = false)
	private LocalDateTime birthDate;

	@Column(name = "address",nullable = false,length=100)
	private String address;

	@Column(name = "mobile_no",nullable = false)
	@Size(max=10,min=10,message="enter 10 digit mobile number")
	@Pattern(regexp = "^[0-9]{10}$",message = "enter 10 digit mobile number") 
	private String mobileNo;

	@Column(name = "password",nullable = false,length=500)
	private String password;

	@Transient
	private String confirmPassword;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dept_id",nullable = false)
	private Department deptId;

	@Column(name = "status",nullable = false,length=30)
	@Value("Active")
	private String empStatus;

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", birthDate=" + birthDate + ", address=" + address
				+ ", mobileNo=" + mobileNo + ", deptId=" + deptId + ", empStatus=" + empStatus + "]";
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, LocalDateTime birthDate, String address,
			@Size(max = 10, min = 10, message = "enter 10 digit mobile number") @Pattern(regexp = "^[0-9]{10}$", message = "enter 10 digit mobile number") String mobileNo,
			String password, String confirmPassword, Department deptId, String empStatus) {
		super();
		this.empName = empName;
		this.birthDate = birthDate;
		this.address = address;
		this.mobileNo = mobileNo;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.deptId = deptId;
		this.empStatus = empStatus;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Department getDeptId() {
		return deptId;
	}

	public void setDeptId(Department deptId) {
		this.deptId = deptId;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public boolean equatePassword() {
		return getPassword().equals(getConfirmPassword());
	}
}
