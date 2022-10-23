package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	//login api
	public Optional<Employee> findByEmpNameAndPassword(String empName,String password);
	public Optional<Employee> findByEmpId(Long Id);
	@Query("select e from Employee e join fetch e.deptId where e.empName=?1")
	Optional <Employee> findByName(String username);

}
