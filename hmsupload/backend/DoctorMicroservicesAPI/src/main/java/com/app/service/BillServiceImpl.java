package com.app.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.DischargeDTO;
import com.app.entities.Admit;
import com.app.entities.Appointment;
import com.app.entities.Bill;
import com.app.entities.Medicine;
import com.app.entities.Room;
import com.app.entities.Test;
import com.app.repository.AdmitRepository;
import com.app.repository.AppointmentRepository;
import com.app.repository.BillRepository;
@Service
@Transactional
public class BillServiceImpl implements IBillService {

	@Autowired
	BillRepository billRepo;
	@Autowired
	AdmitRepository admitRepo;
	@Autowired
	AppointmentRepository appointmentRepo;
	@Override
	public void createBill(DischargeDTO dischargeDTO) {
		// TODO Auto-generated method stub
		Bill bill=new Bill();
		double cost=0;
		
		Optional<Appointment> appointment=appointmentRepo.findById(dischargeDTO.getAppointId());
		
		bill.setAppointmentId(appointment.get());
		bill.setPayementStatus("unpaid");
		Appointment a=appointment.get();
		cost+=a.getCost();
		Set<Medicine> appointmentmeds=a.getMedicines();
		Set<Test> appointmentTests=a.getTests();
		for(Medicine i:appointmentmeds) {
			cost+=i.getCost();
		}
		for(Test i:appointmentTests) {
			cost+=i.getCost();
		}
		if(dischargeDTO.getAdmitId()!=null) {
			Optional<Admit> admit=admitRepo.findById(dischargeDTO.getAdmitId());
			admit.get().setReleaseDate(LocalDateTime.now());
			admitRepo.save(admit.get());
			bill.setAdmintId(admit.get());
			Admit adm=admit.get();
			Set<Medicine> admitmeds=adm.getMedicines();
			Set<Test> admitTests=adm.getTests();
			for(Medicine i:admitmeds) {
				cost+=i.getCost();
			}
			for(Test i:admitTests) {
				cost+=i.getCost();
			}
			Room r=adm.getRoomId();
			LocalDateTime firstDate=a.getDateTime();
			LocalDateTime secondDate=adm.getReleaseDate();
			System.out.println(firstDate);
			System.out.println(secondDate);
			long days = ChronoUnit.DAYS.between(firstDate, secondDate);
			
			cost+=(r.getCostPerday()*(days));
		}
		bill.setCost(cost);
		billRepo.save(bill);
		
		
		
	}

}
