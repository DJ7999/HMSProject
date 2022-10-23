package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Employee;
import com.app.entities.Patient;
import com.app.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	
	
}
