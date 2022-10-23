package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AdmitDTO;
import com.app.dto.AppointmentDTO;
import com.app.dto.DischargeDTO;
import com.app.entities.Admit;
import com.app.entities.Appointment;
import com.app.entities.Medicine;
import com.app.entities.Room;
import com.app.entities.Test;
import com.app.service.IAdmitService;
import com.app.service.IAppointmentService;
import com.app.service.IBillService;
import com.app.service.IMedicineService;
import com.app.service.IPatientService;
import com.app.service.IRoomService;
import com.app.service.ITestService;

@CrossOrigin
@RestController
@RequestMapping("/hms/doctor")
public class AppointmentController {
	
	@Autowired
	IAppointmentService appointmentService;
	@Autowired
	IRoomService roomService;
	@Autowired
	IPatientService patientService;
	@Autowired
	IAdmitService admitService;
	@Autowired
	IBillService billService;
	@Autowired
	IMedicineService medService;
	@Autowired
	ITestService testService;

	
	//http://localhost:8083/hms/doctor/getAllAppointment
	@GetMapping("/getAllAppointment")
	public List<Appointment> findAllAppointment(){
		return appointmentService.findAppointments();
	}
	@GetMapping("/getMyAppointment")
	public List<Appointment> findMyAppointment(@RequestHeader(value="id")String id){
		Long empId=Long.parseLong(id);
		return appointmentService.findAppointmentsEmployee(empId);
	}
	//http://localhost:8083/hms/doctor/getMyAdmit
	@GetMapping("/getMyAdmit")
	public List<Admit> findMyAdmit(@RequestHeader(value="id")String id){
		Long empId=Long.parseLong(id);
		return admitService.findAdmitmentsEmployee(empId);
	}
	@GetMapping("/getMyAppointment/history")
	public List<Appointment> patientsHistory(@RequestHeader(value="id")String id){
		Long patientId=Long.parseLong(id);
		return patientService.patientsHistory(patientId);
	}
	@PutMapping("getMyAppointment/update")
	public String updateAppointment(@RequestBody AppointmentDTO appointmentDto) {
		System.out.println(appointmentDto);
		appointmentService.updateAppointment(appointmentDto);
		return "success";
		
	}
	@PutMapping("getMyAppointment/admit/update")
	public String updateAdmit(@RequestBody AdmitDTO admitDto) {
		System.out.println(admitDto);
		admitService.updateAdmit(admitDto);
		return "success";
		
	}
	@PostMapping("getMyAppointment/admit")
	public Admit admitPatient(@RequestBody AdmitDTO admitPatient) {
		System.out.println(admitPatient);
		return admitService.admitnewPatient(admitPatient);
		 
		
	}
	
	@PostMapping("getMyAppointment/admit/discharge")
	public String dischargeAdmit(@RequestBody DischargeDTO dischargeDTO) {

		Admit a=admitService.findByAdmitId(dischargeDTO.getAdmitId());
		admitService.changeStatus(a);
		billService.createBill(dischargeDTO);
		return "i am out";
	}
	@PostMapping("getMyAppointment/discharge")
	public String dischargeAppointment(@RequestBody DischargeDTO dischargeDTO) {
		System.out.println(dischargeDTO);
		
		Appointment a=appointmentService.findAppointmentById(dischargeDTO.getAppointId());
		a.setStatus("discharged");
		appointmentService.changeStatus(a);
		billService.createBill(dischargeDTO);
		return "i am out";
	}
	
	@GetMapping("/getAllMeds")
	public List<Medicine> findAllMeds(){
		return medService.findmedicines();
	}
	@GetMapping("/getAllRoom")
	public List<Room> findAllRooms(){
		return roomService.getAllRoom();
	}
	
	@GetMapping("/getAllTests")
	public List<Test> findAllTests(){
		return testService.getAlltest();
	}
}
