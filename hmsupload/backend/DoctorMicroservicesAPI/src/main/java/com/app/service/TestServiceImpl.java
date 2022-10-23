package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Medicine;
import com.app.entities.Room;
import com.app.entities.Test;
import com.app.repository.MedicineRepository;
import com.app.repository.RoomRepository;
import com.app.repository.TestRepository;
@Service
@Transactional
public class TestServiceImpl implements ITestService {
	@Autowired
	TestRepository testRepo;
	
	

	@Override
	public List<Test> getAlltest() {
		// TODO Auto-generated method stub
		return testRepo.findAll();
	}

	

	


}
