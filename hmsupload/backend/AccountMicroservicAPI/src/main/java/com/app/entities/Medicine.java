package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="medicine")
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicine_id")
	private Long medicineId;
	
	@Column(name = "cost",nullable=false)
	private double cost;
	
	@ManyToMany(mappedBy = "medicines")
	private Set<Appointment> Appointments=new HashSet<>();
	
	
	@Column(name = "medicine_name",nullable=false)
	private String medicineName;
		

	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Medicine(Long medicineId, double cost, String medicineName) {
		super();
		this.medicineId = medicineId;
		this.cost = cost;
		this.medicineName = medicineName;
	}


	public Long getMedicineId() {
		return medicineId;
	}


	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public String getMedicineName() {
		return medicineName;
	}


	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}


	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", cost=" + cost + ", medicineName=" + medicineName + "]";
	}
	
}
