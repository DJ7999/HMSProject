package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AppointmentDTO;
import com.app.entities.Appointment;
import com.app.entities.Employee;
import com.app.entities.Medicine;
import com.app.entities.Test;
import com.app.repository.AppointmentRepository;
import com.app.repository.EmployeeRepository;
import com.app.repository.MedicineRepository;
import com.app.repository.TestRepository;


@Service
@Transactional
public class AppointmentServiceImpl implements IAppointmentService{

	@Autowired
	AppointmentRepository appointmentRepo;
	@Autowired
	EmployeeRepository employeeRepo;
	@Autowired
	MedicineRepository medicineRepo;
	@Autowired
	TestRepository testRepo;
//public Optional<Employee> validateUser(String empName, String password) {
//		
//		return employeeRepository.findByEmpNameAndPassword(empName, password);
//	}
	public List<Appointment> findAppointments(){
		return appointmentRepo.findAll();
	}
	@Override
	public List<Appointment> findAppointmentsEmployee(Long empId) {
		// TODO Auto-generated method stub
		Optional<Employee> e1=employeeRepo.findById(empId);
		return appointmentRepo.findByEmpId(e1);
	}
	@Override
	public void updateAppointment(AppointmentDTO appointmentDto) {
		Optional<Appointment> a1=appointmentRepo.findById(appointmentDto.getId());
		for(int i:appointmentDto.getMedicineIds()) {
			Optional<Medicine> m=medicineRepo.findById((long) i);
			a1.get().getMedicines().add(m.get());
		}
		for(int i:appointmentDto.getTestIds()) {
			Optional<Test> m=testRepo.findById((long) i);
			a1.get().getTests().add(m.get());
		}
		a1.get().setPrescription(appointmentDto.getPrescription());
		appointmentRepo.save(a1.get());
		
		
	}
	@Override
	public Appointment findAppointmentById(Long appointId) {
		Optional<Appointment> a1=appointmentRepo.findById(appointId);
		return a1.get();
	}
	@Override
	public void changeStatus(Appointment a) {
		appointmentRepo.save(a);
		
	}
	
}