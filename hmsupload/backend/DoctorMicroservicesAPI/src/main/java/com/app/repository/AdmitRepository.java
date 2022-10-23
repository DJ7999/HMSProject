package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Admit;
import com.app.entities.Department;
import com.app.entities.Employee;

@Repository
public interface AdmitRepository extends JpaRepository<Admit, Long> {

	List<Admit> findByEmpId(Optional<Employee> e1);

}
