package com.app.dto;

import java.util.HashSet;
import java.util.Set;

import com.app.entities.Medicine;
import com.app.entities.Test;

public class AppointmentDTO {
	String prescription;
	Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	Set<Integer> testIds=new HashSet<>();
	Set<Integer> medicineIds=new HashSet<>();
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public Set<Integer> getTestIds() {
		return testIds;
	}
	public void setTestIds(Set<Integer> testIds) {
		this.testIds = testIds;
	}
	public Set<Integer> getMedicineIds() {
		return medicineIds;
	}
	public void setMedicineIds(Set<Integer> medicineIds) {
		this.medicineIds = medicineIds;
	}
	@Override
	public String toString() {
		return "AppointmentDTO [prescription="+id+"    " + prescription + ", testIds=" + testIds + ", medicineIds=" + medicineIds
				+ "]";
	}
	
}
