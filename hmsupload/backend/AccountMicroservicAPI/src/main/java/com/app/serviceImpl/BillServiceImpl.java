package com.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Bill;
import com.app.repository.BillRepository;
import com.app.service.IBillService;

@Service
@Transactional
public class BillServiceImpl implements IBillService {

	@Autowired
	BillRepository BillRepo;	

	@Override
	public String UpdatePaymentStatus(Long billId) {
		Optional<Bill> billStatusTobeModify = BillRepo.findById(billId);
		if(billStatusTobeModify.isPresent()) {
			if(billStatusTobeModify.get().getPayementStatus().equals("unpaid"))
			{
				billStatusTobeModify.get().setPayementStatus("paid");
				BillRepo.save(billStatusTobeModify.get());
			}
			return "PaymentStatus updated sucessfully";
		}	
		return "PaymentStatus is not valid check Id";
	}
	

	@Override
	public List<Bill> findAllBillsDeatils() {
		
		return BillRepo.findAll();
	}
}
