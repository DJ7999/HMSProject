package com.app.service;

import java.util.List;

import com.app.entities.Appointment;

public interface IPatientService {
	public List<Appointment> patientsHistory(Long patientId);
}
