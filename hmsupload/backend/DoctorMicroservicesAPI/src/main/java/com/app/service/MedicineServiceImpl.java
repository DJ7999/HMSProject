package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Medicine;
import com.app.repository.MedicineRepository;
@Service
@Transactional
public class MedicineServiceImpl implements IMedicineService {
	@Autowired
	MedicineRepository medsRepo;
	@Override
	public List<Medicine> findmedicines() {
		// TODO Auto-generated method stub
		return medsRepo.findAll();
	}

	

	


}
