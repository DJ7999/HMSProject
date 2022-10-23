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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="admit")
@NoArgsConstructor
public class Admit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="admit_id")
	private Long admitId;
	
	@Column(name="release_date")
	private LocalDateTime releaseDate;

	@ManyToMany
	@JoinTable(name="testsadmit",
				joinColumns=@JoinColumn(name="admit_id"),
				inverseJoinColumns = @JoinColumn(name="test_id"))
	private Set<Test> tests=new HashSet<>();
	
	
	@ManyToMany
	@JoinTable(name="medicinesadmit",
				joinColumns=@JoinColumn(name="admit_id"),
				inverseJoinColumns = @JoinColumn(name="medicine_id"))
	private Set<Medicine> medicines=new HashSet<>();
	
	@Column(name="prescription",length=5000)
	private String prescription;		
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "room_id",nullable=false)
	private Room room;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "emp_id",nullable=false)
	private Employee employee;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "appointment_id",nullable=false)
	private Appointment appointment;
	
	//status can be Active discharged
	@Column(name="status",nullable=false,length=10)	
	private String Status="Active";
	
	public Admit(LocalDateTime releaseDate, Set<Test> tests, Set<Medicine> medicines, String prescription, Room room,
			Employee employee, Appointment appointment, String status) {
		super();
		this.releaseDate = releaseDate;
		this.tests = tests;
		this.medicines = medicines;
		this.prescription = prescription;
		this.room = room;
		this.employee = employee;
		this.appointment = appointment;
		Status = status;
	}
	@Override
	public String toString() {
		return "Admit [admitId=" + admitId + ", releaseDate=" + releaseDate + ", tests=" + tests + ", medicines="
				+ medicines + ", prescription=" + prescription + ", room=" + room + ", employee=" + employee
				+ ", appointment=" + appointment + ", Status=" + Status + "]";
	}	
}
