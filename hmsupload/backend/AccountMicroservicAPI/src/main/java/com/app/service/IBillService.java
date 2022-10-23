package com.app.service;

import java.util.List;

import com.app.entities.Bill;

public interface IBillService {

	public String UpdatePaymentStatus(Long billId);

	public List<Bill> findAllBillsDeatils();
	
}
