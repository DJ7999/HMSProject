package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EmployeeDTO;
import com.app.entities.Employee;
import com.app.service.IEmployeeService;

@RestController
@RequestMapping("/hms/login")
@CrossOrigin
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;

	
}
