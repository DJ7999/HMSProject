package com.app.serviceImpl;

import java.beans.Encoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.EmployeeDTO;
import com.app.entities.Department;
import com.app.entities.Employee;
import com.app.repository.DepartmentRepository;
import com.app.repository.EmployeeRepository;
import com.app.service.IEmployeeService;

@Service
@Transactional
public class EmployeeService implements IEmployeeService{

	@Autowired
	EmployeeRepository employeeRepo;

	@Autowired
	DepartmentRepository deptRepo;	

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepo.findAll();
	}

	@Override
	public Employee addEmployee(EmployeeDTO emp) throws ResourceNotFoundException{
		
		
		Employee emp1=new Employee();
		emp1.setAddress(emp.getAddress());
		
		emp1.setBirthDate(emp.getBirthDate());
		emp1.setEmpId(emp.getEmpId());
		emp1.setEmpName(emp.getEmpName());
		emp1.setMobileNo(emp.getMobileNo());
		emp1.setPassword(encoder.encode(emp.getPassword()));
		Optional<Department> d= deptRepo.findById(emp.getDeptId());
		emp1.setDeptId(d.get());
		emp1.setEmpStatus(emp.getEmpStatus());
		Employee existingEmp= employeeRepo.findByMobileNo(emp1.getMobileNo());
		if(existingEmp!=null) {
			throw new ResourceNotFoundException("User already exists");
		}else {
			employeeRepo.save(emp1);
			return emp1;
		}
			

		
	}

	@Override
	public Employee updateEmployeeDetails(EmployeeDTO detachedEmp) {
		
		Employee e=employeeRepo.findById(detachedEmp.getEmpId()).orElseThrow(()-> new ResourceNotFoundException("Invalid emp id!!!! Cant update details"));
		if(e!=null) {
			
			e.setAddress(detachedEmp.getAddress());
			
			e.setBirthDate(detachedEmp.getBirthDate());
			e.setEmpId(detachedEmp.getEmpId());
			e.setEmpName(detachedEmp.getEmpName());
			e.setMobileNo(detachedEmp.getMobileNo());
			e.setPassword(encoder.encode(detachedEmp.getPassword()));
			Optional<Department> d= deptRepo.findById(detachedEmp.getDeptId());
			e.setDeptId(d.get());
			e.setEmpStatus(detachedEmp.getEmpStatus());
		employeeRepo.save(e);
		}
		
		System.out.println(e);
		return e;
	}

	
	
	
	@Override
	public Employee findEmployeeByName(String name) throws ResourceNotFoundException
	{
//					.orElseThrow(()-> new ResourceNotFoundException("Invalid emp"));
	
			Employee e= employeeRepo.findByEmpName(name);
			
			
	if(e==null)
	{
		throw new ResourceNotFoundException("Employee not present");
	}
			System.out.println(e);
			return e; 
}
	


	@Override
	public Employee findEmployeeById(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Employee e= employeeRepo.findByEmpId(id);
		if(e==null) {
			throw new ResourceNotFoundException("Employee not found");
		}
		System.out.println(e);
		return e;
	}
}
