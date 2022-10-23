package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AdmitDTO;
import com.app.entities.Admit;
import com.app.entities.Appointment;
import com.app.entities.Employee;
import com.app.entities.Medicine;
import com.app.entities.Patient;
import com.app.entities.Room;
import com.app.entities.Test;
import com.app.repository.AdmitRepository;
import com.app.repository.AppointmentRepository;
import com.app.repository.EmployeeRepository;
import com.app.repository.MedicineRepository;
import com.app.repository.PatientRepository;
import com.app.repository.RoomRepository;
import com.app.repository.TestRepository;

@Service
@Transactional
public class AdmitServiceImpl implements IAdmitService {
	@Autowired
	AppointmentRepository appointmentRepo;
	@Autowired
	PatientRepository patientRepo;
	@Autowired
	EmployeeRepository employeeRepo;
	@Autowired
	MedicineRepository medicineRepo;
	@Autowired
	TestRepository testRepo;
	@Autowired
	RoomRepository roomRepo;
	@Autowired
	AdmitRepository admitRepo;
	@Override
	public Admit admitnewPatient(AdmitDTO admitPatient) {
		
		Optional<Appointment> a=appointmentRepo.findById(admitPatient.getAppointmentId());
		Optional<Employee> e=employeeRepo.findById(admitPatient.getEmpId());
		Optional<Room> r=roomRepo.findById(admitPatient.getRoomId());
		Admit admit=new Admit();
		admit.setAppointmentId(a.get());
		admit.setEmpId(e.get());
		admit.setRoomId(r.get());
		admitRepo.save(admit);
		return admit;
		
	}
	@Override
	public void updateAdmit(AdmitDTO admitDto) {
		Optional<Admit> a1=admitRepo.findById(admitDto.getAdmitId());
		a1.get().setPrescription(admitDto.getPrescription());
		for(Long i:admitDto.getTests()) {
			Optional<Test> t=testRepo.findById(i);
			a1.get().getTests().add(t.get());
		}
		for(Long i:admitDto.getMedicines()) {
			Optional<Medicine> t=medicineRepo.findById(i);
			a1.get().getMedicines().add(t.get());
		}
		admitRepo.save(a1.get());
		
	}
	@Override
	public List<Admit> findAdmitmentsEmployee(Long empId) {
		Optional<Employee> e1=employeeRepo.findById(empId);
		return admitRepo.findByEmpId(e1);
	
	}
	@Override
	public Admit findByAdmitId(Long admitId) {
		Optional<Admit> a1=admitRepo.findById(admitId);
		return a1.get();
	}
	@Override
	public void changeStatus(Admit a) {
		a.setStatus("discharged");
		admitRepo.save(a);
		
	}
}
