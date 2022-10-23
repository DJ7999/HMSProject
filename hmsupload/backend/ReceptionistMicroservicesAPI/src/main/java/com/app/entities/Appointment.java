package com.app.entities;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="appointment")
@Getter
@Setter
@NoArgsConstructor
public class Appointment {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private Long appointmentId;
	
	@Column(name="date_time",nullable=false)
	@NotNull
	private LocalDateTime dateTime;
	
	@Column(name="prescription",length=500)	
	private String prescription;
	
	@Column(name="cost")	
	private double cost=500;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="testsappointments",
				joinColumns=@JoinColumn(name="appointment_id"),
				inverseJoinColumns = @JoinColumn(name="test_id"))
	private Set<Test> tests=new HashSet<>();
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="medicinesappointments",
				joinColumns=@JoinColumn(name="appointment_id"),
				inverseJoinColumns = @JoinColumn(name="medicine_id"))
	private Set<Medicine> medicines=new HashSet<>();
		

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id",nullable=false)
	private Patient patient;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "emp_id",nullable=false)
	private Employee employee;
	
	@Column(name="status",length=100)
	private String status="active";
	
	public Appointment(LocalDateTime dateTime, String prescription, Set<Test> tests,
			Set<Medicine> medicines, Patient patient, Employee employee, String status) {
		super();
		this.dateTime = dateTime;
		this.prescription = prescription;
		
		this.tests = tests;
		this.medicines = medicines;
		this.patient = patient;
		this.employee = employee;
		this.status = status;
	}
	

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", dateTime=" + dateTime + ", prescription="
				+ prescription + ", cost=" + cost + ", tests=" + tests + ", medicines=" + medicines + ", status=" + status + "]";
	}
}