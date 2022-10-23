package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Patient;
import com.app.service.IDepartmentService;


@CrossOrigin
@RestController
@RequestMapping("/hms/receptionist")
public class DepartmentController {
	
	@Autowired
	IDepartmentService patientService;
	
	//http://localhost:8081/hms/admin/getAllDepartments
	@GetMapping("/getAllDepartments")
	public List<Patient> findAllDepartments() {
		return null;		
	}	
	
	//http://localhost:8081/hms/admin/AddNewDepartment
	@PostMapping("/AddNewDepartment")
	public String addNewDepartment() {
		return null;
	}
	
	//http://localhost:8081/hms/admin/updateDepartmentDetails	
	@PutMapping("/updateDepartmentDetails")
	public String updateDepartmentDetails() {
		return null;
	}
	
	//http://localhost:8081/hms/admin/findDepartmentByDeptName
	@GetMapping("/findDepartmentByDeptName")
	public Patient searchDepartment() {
		return null;
	}
	
}

