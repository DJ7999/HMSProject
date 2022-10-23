package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Department;
import com.app.entities.Patient;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department, Long>{

}
