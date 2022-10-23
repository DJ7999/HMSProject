package com.app.dto;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.app.entities.Appointment;
import com.app.entities.Employee;
import com.app.entities.Medicine;
import com.app.entities.Room;
import com.app.entities.Test;

public class AdmitDTO {

	
	private Long admitId;
	
	private Date releaseDate;

	private Set<Long> tests=new HashSet<>();
	
	
	
	private Set<Long> medicines=new HashSet<>();
	
	private String prescription;		
	
	
	private Long roomId;	
	
	
	private Long empId;	
	
	
	private Long appointmentId;


	public Long getAdmitId() {
		return admitId;
	}


	public void setAdmitId(Long admitId) {
		this.admitId = admitId;
	}


	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	public Set<Long> getTests() {
		return tests;
	}


	public void setTests(Set<Long> tests) {
		this.tests = tests;
	}


	public Set<Long> getMedicines() {
		return medicines;
	}


	public void setMedicines(Set<Long> medicines) {
		this.medicines = medicines;
	}


	public String getPrescription() {
		return prescription;
	}


	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}


	public Long getRoomId() {
		return roomId;
	}


	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}


	public Long getEmpId() {
		return empId;
	}


	public void setEmpId(Long empId) {
		this.empId = empId;
	}


	public Long getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}


	@Override
	public String toString() {
		return "AdmitDTO [admitId=" + admitId + ", releaseDate=" + releaseDate + ", tests=" + tests + ", medicines="
				+ medicines + ", prescription=" + prescription + ", roomId=" + roomId + ", empId=" + empId
				+ ", appointmentId=" + appointmentId + "]";
	}
	
	
}
