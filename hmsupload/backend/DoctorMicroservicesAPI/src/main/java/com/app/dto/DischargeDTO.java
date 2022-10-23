package com.app.dto;

public class DischargeDTO {
	private Long appointId;
	private Long admitId;
	private String paymentStatus="unpaid";
	
	public Long getAppointId() {
		return appointId;
	}
	public void setAppointId(Long appointId) {
		this.appointId = appointId;
	}
	public Long getAdmitId() {
		return admitId;
	}
	public void setAdmitId(Long admitId) {
		this.admitId = admitId;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "DischargeDTO [appointId=" + appointId + ", admitId=" + admitId + ", paymentStatus=" + paymentStatus
				+ "]";
	}
	
	
	
	

}
