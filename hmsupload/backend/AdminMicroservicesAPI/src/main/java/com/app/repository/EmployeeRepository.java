package com.app.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.app.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
	@Query("select u from Employee u where u.empName=:name")

	Employee findByEmpName(@Param(value="name")  String name);
	
	public Employee findByMobileNo(String no);
	
	@Query("select e from Employee e join fetch e.deptId where e.empName=?1")
	Optional <Employee> findByName(String username);

	
	@Query("select u from Employee u where u.empId=:id")
	Employee findByEmpId(@Param(value="id")Long id);
}	
