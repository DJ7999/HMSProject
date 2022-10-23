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

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="appointment")
public class Appointment {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private Long appointmentId;
	
	@Column(name="date_time",nullable=false)
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
	private Patient patientId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "emp_id",nullable=false)
	private Employee empId;
	//state can be active admit discharge
	@Column(name="status",length=100)
	private String status="active";

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(LocalDateTime dateTime, String prescription, Set<Test> tests,
			Set<Medicine> medicines, Patient patientId, Employee empId, String status) {
		super();
		this.dateTime = dateTime;
		this.prescription = prescription;
		
		this.tests = tests;
		this.medicines = medicines;
		this.patientId = patientId;
		this.empId = empId;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", dateTime=" + dateTime + ", prescription="
				+ prescription + ", cost=" + cost + ", tests=" + tests + ", medicines=" + medicines + ", patientId="
				+ patientId + ", empId=" + empId + ", status=" + status + "]";
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public double getCost() {
		return cost;
	}

	public Set<Test> getTests() {
		return tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}

	public Set<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(Set<Medicine> medicines) {
		this.medicines = medicines;
	}

	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}

	public Employee getEmpId() {
		return empId;
	}

	public void setEmpId(Employee empId) {
		this.empId = empId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
}
