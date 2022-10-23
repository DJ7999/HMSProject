package com.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DoctorDto;
import com.app.dto.PatientDto;
import com.app.entities.Patient;
import com.app.service.IPatientService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/hms/receptionist")
public class PatientController {

	@Autowired
	IPatientService patientService;

	// http://localhost:8082/hms/receptionist/getAllPatients
	@GetMapping("/getAllPatients")
	public ResponseEntity<List<Patient>> findAllPatient() {
		List<Patient> listOfPatient=patientService.findAllPatient();
		return new ResponseEntity<List<Patient>>(listOfPatient,HttpStatus.OK);
	}

	// http://localhost:8082/hms/receptionist/AddNewPatient
	@PostMapping("/addNewPatient")
	public ResponseEntity<?> addNewPatient(@Valid @RequestBody Patient patient) {
		String patientAddStatus=patientService.addNewPatient(patient);		
		return new ResponseEntity<>(patientAddStatus,HttpStatus.CREATED);
	}

	// http://localhost:8082/hms/receptionist/updatePatientDetails
	@PutMapping("/updatePatientDetails")
	public ResponseEntity<?> updatePatientDetails(@Valid @RequestBody PatientDto patient) {
		String patientUpdateStatus=patientService.updatePatientDetails(patient);
		return new ResponseEntity<>(patientUpdateStatus,HttpStatus.CREATED);
	}

	// http://localhost:8082/hms/receptionist/findPatientByEmpNameAndMobile?name=Rajesh&mobile=9810505221
	@GetMapping("/findPatientByEmpNameAndMobile")
	public ResponseEntity<?> searchPatient(@RequestParam String name,  @RequestParam String mobile) {
		Optional<Patient> patient = patientService.searchPatientByNameAndMobile(name, mobile);
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}
	
	@GetMapping("/getAllDoctorName")
	public ResponseEntity<?> getAllDoctorName(){
		List<DoctorDto> drNames=patientService.getAllDoctorNames();
		return new ResponseEntity<List<DoctorDto>>(drNames,HttpStatus.OK);
		
	}
}

