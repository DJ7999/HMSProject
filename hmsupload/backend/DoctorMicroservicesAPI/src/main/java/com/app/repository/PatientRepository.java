package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Employee;
import com.app.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	public Optional<Patient> findByPatientId(Long Id);
	
}
