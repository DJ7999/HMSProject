package com.app.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Patient;

@Repository
public interface PatientRepository  extends JpaRepository<Patient, Long>{
	
	// search patient by name and mobile no
	public Optional<Patient> findByNameAndMobileNo(String name, String mobileNo);
	
	//find existing patient entry by birthDate	
	public  Patient findByBirthDateAndMobileNo(Date birthDate,String mobileNo);
	
}