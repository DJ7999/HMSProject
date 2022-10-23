package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AppointmentDto;
import com.app.entities.Appointment;
import com.app.service.IAppointmentService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/hms/receptionist")
public class AppointmentController {
	
	@Autowired
	IAppointmentService appointmentService;

	
	//http://localhost:8082/hms/receptionist/getAllAppointment
	@GetMapping("/getAllAppointment")
	public ResponseEntity<List<Appointment>>  getAllAppointmentDetails(){
		List<Appointment> listOfAppointment=appointmentService.getAllAppointmentDetails();	
		return new ResponseEntity<List<Appointment>>(listOfAppointment,HttpStatus.OK);
	}
	
	
	//http://localhost:8082/hms/receptionist/AddNewAppointment
	@PostMapping("/AddNewAppointment")
	public ResponseEntity<?> addNewAppointment(@Valid @RequestBody AppointmentDto appointmentDto){
		String addAppointmentStatus = appointmentService.addNewAppointment(appointmentDto);
		return new ResponseEntity<>(addAppointmentStatus,HttpStatus.CREATED);
	}
	
	//http://localhost:8082/hms/receptionist/updateAppointmnet
	@PutMapping("/updateAppointmnet")
	public ResponseEntity<?> updateAppointmnetDetails(@Valid @RequestBody AppointmentDto appointmentDto){
		String updateAppointmentStatus = appointmentService.updateAppointmetDetails(appointmentDto);	
		return new ResponseEntity<>(updateAppointmentStatus,HttpStatus.CREATED);
	}
	
	//http://localhost:8082/hms/receptionist/cancelAppointmnet
	@DeleteMapping("/cancelAppointmnet")
	public ResponseEntity<?> cancelAppointmnet(@RequestParam Long appointmentId){
		String deleteAppointmentStatus= appointmentService.deleteAppointment(appointmentId);	
		return new ResponseEntity<>(deleteAppointmentStatus,HttpStatus.CREATED);
	}
}
