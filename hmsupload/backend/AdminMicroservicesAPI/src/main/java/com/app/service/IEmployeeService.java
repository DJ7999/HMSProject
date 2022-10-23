package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.EmployeeDTO;
import com.app.entities.Employee;

public interface IEmployeeService {

	
	List<Employee> getAllEmployees();
	
	Employee addEmployee(EmployeeDTO emp);
	Employee updateEmployeeDetails(EmployeeDTO emp);
	Employee findEmployeeByName(String name);
	Employee findEmployeeById(Long id);
	
}
