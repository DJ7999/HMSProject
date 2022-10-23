package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
	

}
