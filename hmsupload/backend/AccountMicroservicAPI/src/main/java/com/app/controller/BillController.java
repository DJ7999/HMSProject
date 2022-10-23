package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Bill;
import com.app.service.IBillService;
import com.app.serviceImpl.BillServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/hms/accountant")
public class BillController {

	@Autowired
	IBillService billService;

	// http://localhost:8084/hms/accountant/bill
	@GetMapping("/bill")
	public List<Bill> BillDetails() {
		List<Bill> bill = billService.findAllBillsDeatils();

		return bill;
	}

	// http://localhost:8084/hms/accountant/update
	@GetMapping("/update")
	public String UpdateDetails(@RequestParam Long billId) {
		return billService.UpdatePaymentStatus(billId);

	}
}
