package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Appointment;
import com.app.entities.Bill;
import com.app.entities.Employee;
import com.app.entities.Patient;


public interface BillRepository extends JpaRepository<Bill, Long> {
	
	
}
