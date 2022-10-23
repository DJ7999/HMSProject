package com.app.service;

import java.util.List;

import com.app.dto.AppointmentDto;
import com.app.entities.Appointment;

public interface IAppointmentService {
	
	public List<Appointment> getAllAppointmentDetails();

	public String addNewAppointment(AppointmentDto appointmentDto);

	public String updateAppointmetDetails(AppointmentDto appointmentDto);

	public String deleteAppointment(Long appointmentId);

}
