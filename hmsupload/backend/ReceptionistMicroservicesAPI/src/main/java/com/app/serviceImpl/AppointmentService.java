package com.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AppointmentDto;
import com.app.entities.Appointment;
import com.app.entities.Employee;
import com.app.entities.Patient;
import com.app.repository.AppointmentRepository;
import com.app.repository.EmployeeRepository;
import com.app.repository.PatientRepository;
import com.app.service.IAppointmentService;

@Service
@Transactional
public class AppointmentService implements IAppointmentService {

	@Autowired
	AppointmentRepository appointmentRepo;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	EmployeeRepository employeeRepository;


	public List<Appointment> getAllAppointmentDetails() {
		return appointmentRepo.findAll();
	}

	@Override
	public String addNewAppointment(AppointmentDto appointmentDto) {

		Appointment appointment = new Appointment();

		appointment.setDateTime(appointmentDto.getDateTime());

		Optional<Patient> patient = patientRepository.findById(appointmentDto.getPatientId());
		appointment.setPatient(patient.get());

		Optional<Employee> employee = employeeRepository.findById(appointmentDto.getEmpId());

		appointment.setEmployee(employee.get());

		// Appointment appointment=mapper.map(appointmentDto, Appointment.class);
		appointmentRepo.save(appointment);
		return "Appointment booked sucessfully";
	}

	@Override
	public String updateAppointmetDetails(AppointmentDto appointmentDto) {

		Optional<Appointment> appointmentTobeUpdated = appointmentRepo.findById(appointmentDto.getAppointmentId());

		if (appointmentTobeUpdated.isPresent()) {

			appointmentTobeUpdated.get().setDateTime(appointmentDto.getDateTime());

			Optional<Employee> employee = employeeRepository.findById(appointmentDto.getEmpId());

			appointmentTobeUpdated.get().setEmployee(employee.get());

			appointmentRepo.save(appointmentTobeUpdated.get());
		}
		return "Appointment updated sucessfully";
	}

	@Override
	public String deleteAppointment(Long appointmentId) {
		Optional<Appointment> appointment = appointmentRepo.findById(appointmentId);
		if(appointment.isPresent()) {
			appointmentRepo.delete(appointment.get());
			return "Your appointment is cancel";
		}
		
		return "Appointment is not booked";
	}

}
