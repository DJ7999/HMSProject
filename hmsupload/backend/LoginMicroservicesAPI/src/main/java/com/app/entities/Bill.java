package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bill")
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bill_id")
	private Long billId;
	
	@Column(name="payement_Status")
	private String payementStatus="unpaid";
	
	@Column(name="cost")
	private Double cost;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "admit_id")
	private Admit admintId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "appointment_id",nullable=false)
	private Appointment appointmentId;
	

	public Bill() {
		super();		
	}	


	public Bill(Long billId, String payementStatus, Double cost, Admit admintId, Appointment appointmentId) {
		super();
		this.billId = billId;
		this.payementStatus = payementStatus;
		this.cost = cost;
		this.admintId = admintId;
		this.appointmentId = appointmentId;
	}


	public Long getBillId() {
		return billId;
	}


	public void setBillId(Long billId) {
		this.billId = billId;
	}


	public String getPayementStatus() {
		return payementStatus;
	}


	public void setPayementStatus(String payementStatus) {
		this.payementStatus = payementStatus;
	}


	public Double getCost() {
		return cost;
	}


	public void setCost(Double cost) {
		this.cost = cost;
	}


	public Admit getAdmintId() {
		return admintId;
	}


	public void setAdmintId(Admit admintId) {
		this.admintId = admintId;
	}


	public Appointment getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(Appointment appointmentId) {
		this.appointmentId = appointmentId;
	}


	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", payementStatus=" + payementStatus + ", cost=" + cost + "]";
	}
		
}
	
	
	
