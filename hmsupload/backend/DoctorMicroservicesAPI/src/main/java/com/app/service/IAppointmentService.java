package com.app.service;

import java.util.List;

import com.app.dto.AppointmentDTO;
import com.app.entities.Admit;
import com.app.entities.Appointment;

public interface IAppointmentService {
	public List<Appointment> findAppointments();
	public List<Appointment> findAppointmentsEmployee(Long empId);
	public void updateAppointment(AppointmentDTO appointmentDto);
	public Appointment findAppointmentById(Long appointId);
	public void changeStatus(Appointment a);
	
}
