package com.app.entities;

import java.sql.Date;
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

import org.springframework.beans.factory.annotation.Value;

@Entity
public class Admit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="admit_id")
	private Long admitId;
	
	@Column(name="release_date")
	private LocalDateTime releaseDate;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="testsadmit",
				joinColumns=@JoinColumn(name="admit_id"),
				inverseJoinColumns = @JoinColumn(name="test_id"))
	private Set<Test> tests=new HashSet<>();
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="medicinesadmit",
				joinColumns=@JoinColumn(name="admit_id"),
				inverseJoinColumns = @JoinColumn(name="medicine_id"))
	private Set<Medicine> medicines=new HashSet<>();
	@Column(name="prescription",length=5000)
	private String prescription;		
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "room_id",nullable=false)
	private Room roomId;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "emp_id",nullable=false)
	private Employee empId;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "appointment_id",nullable=false)
	private Appointment appointmentId;
	//status can be Active discharged
	@Column(name="status",nullable=false,length=10)
	
	private String Status="Active";
	public Admit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admit(LocalDateTime releaseDate, Set<Test> tests, Set<Medicine> medicines, String prescription, Room roomId,
			Employee empId, Appointment appointmentId, String status) {
		super();
		this.releaseDate = releaseDate;
		this.tests = tests;
		this.medicines = medicines;
		this.prescription = prescription;
		this.roomId = roomId;
		this.empId = empId;
		this.appointmentId = appointmentId;
		Status = status;
	}
	@Override
	public String toString() {
		return "Admit [admitId=" + admitId + ", releaseDate=" + releaseDate + ", tests=" + tests + ", medicines="
				+ medicines + ", prescription=" + prescription + ", roomId=" + roomId + ", empId=" + empId
				+ ", appointmentId=" + appointmentId + ", Status=" + Status + "]";
	}
	public Long getAdmitId() {
		return admitId;
	}
	public void setAdmitId(Long admitId) {
		this.admitId = admitId;
	}
	public LocalDateTime getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDateTime releaseDate) {
		this.releaseDate = releaseDate;
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
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public Room getRoomId() {
		return roomId;
	}
	public void setRoomId(Room roomId) {
		this.roomId = roomId;
	}
	public Employee getEmpId() {
		return empId;
	}
	public void setEmpId(Employee empId) {
		this.empId = empId;
	}
	public Appointment getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Appointment appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
}
