package com.app.controller;

import java.util.List;
import java.util.Optional;

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

import com.app.dto.ApiResponse;
import com.app.dto.EmployeeDTO;
import com.app.entities.Employee;
import com.app.service.IEmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/hms/admin")
public class EmployeeController {
	
	@Autowired
	IEmployeeService employeeService;

	
	//http://localhost:8081/hms/admin/getAllEmployees
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployeeDetails(){
		 List<Employee> emp=employeeService.getAllEmployees();
		
		return emp;		
	}
	
	
	//http://localhost:8081/hms/admin/addNewEmployee
	@PostMapping("/addNewEmployee")
	public String addNewEmployee(@RequestBody EmployeeDTO emp){
//		try {
		
		employeeService.addEmployee(emp);
//			System.out.println("in add new emp " + emp.getEmpId());
//			return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(emp));
			return "received";
//			}catch(RuntimeException e){
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
//		}
			
	}
	
	//http://localhost:8081/hms/admin/updateEmployee
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody EmployeeDTO emp){
		
		System.out.println("in update emp method"+ emp.getEmpId());
		
		return employeeService.updateEmployeeDetails(emp);		
	}
	
	
	//http://localhost:8081/hms/admin/findEmployee
	
	@GetMapping("/findEmployee")
	public ResponseEntity<Employee> findEmployee(@RequestParam String name) {
		
		
		return ResponseEntity.ok(employeeService.findEmployeeByName(name)); 
		
	}
	
	
	//http://localhost:8081/hms/admin/findEmpById
	@GetMapping("/findEmpById")	
	public ResponseEntity<Employee> findEmpById(@RequestParam Long id){
		return ResponseEntity.ok(employeeService.findEmployeeById(id));
	}
	
}
