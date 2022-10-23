package com.app.service;

import java.util.List;

import com.app.dto.AdmitDTO;
import com.app.entities.Admit;
import com.app.entities.Appointment;

public interface IAdmitService {

	Admit admitnewPatient(AdmitDTO admitPatient);

	void updateAdmit(AdmitDTO admitDto);

	List<Admit> findAdmitmentsEmployee(Long empId);

	Admit findByAdmitId(Long admitId);

	void changeStatus(Admit a);

}
