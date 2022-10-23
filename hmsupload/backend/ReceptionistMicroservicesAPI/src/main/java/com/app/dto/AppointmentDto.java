package com.app.dto;
import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
	private Long appointmentId;
	private LocalDateTime dateTime;
	private Long empId;
	private Long patientId;

}
