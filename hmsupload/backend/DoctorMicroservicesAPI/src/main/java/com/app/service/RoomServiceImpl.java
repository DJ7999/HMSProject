package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Medicine;
import com.app.entities.Room;
import com.app.repository.MedicineRepository;
import com.app.repository.RoomRepository;
@Service
@Transactional
public class RoomServiceImpl implements IRoomService {
	@Autowired
	RoomRepository roomRepo;
	
	@Override
	public List<Room> getAllRoom() {
		// TODO Auto-generated method stub
		return roomRepo.findAll();
	}

	

	


}
