package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.DoctorDto;
import com.app.dto.PatientDto;
import com.app.entities.Employee;
import com.app.entities.Patient;

public interface IPatientService {
	
	// find All patient details
	public List<Patient> findAllPatient();
	
	// search patient by name and mobile
	public Optional<Patient> searchPatientByNameAndMobile(String name, String mobileNo);
	
	//add new patient
	public String addNewPatient(Patient patient);
	
	//update patient details
	public String updatePatientDetails(PatientDto patient);

	public List<DoctorDto> getAllDoctorNames();

}
