package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Appointment;
import com.app.entities.Patient;
import com.app.repository.AppointmentRepository;
import com.app.repository.PatientRepository;
@Service
@Transactional
public class PatientServiceImpl implements IPatientService {
	@Autowired
	PatientRepository patientRepo;
	@Autowired
	AppointmentRepository appointmentRepo;
	@Override
	public List<Appointment> patientsHistory(Long patientId) {
		Optional<Patient> p1=patientRepo.findByPatientId(patientId);
		return appointmentRepo.findByPatientId(p1);
	}

	

}
