package com.app.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.DoctorDto;
import com.app.dto.PatientDto;
import com.app.entities.Employee;
import com.app.entities.Patient;
import com.app.repository.EmployeeRepository;
import com.app.repository.PatientRepository;
import com.app.service.IPatientService;

@Service
@Transactional
public class PatientService implements IPatientService {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	EmployeeRepository empRepo;

	public List<Patient> findAllPatient() {
		return patientRepository.findAll();
	}

	@Override
	public Optional<Patient> searchPatientByNameAndMobile(String name, String mobileNo) {

		Optional<Patient> searchedPatient = patientRepository.findByNameAndMobileNo(name, mobileNo);
		if (searchedPatient.isEmpty()) {
			throw new ResourceNotFoundException(
					"Patientis not found with name = " + name + " and MobileNo = " + mobileNo);
		}
		return searchedPatient;
	}

	@Override
	public String addNewPatient(Patient patient) {
		Patient existingPatient = patientRepository.findByBirthDateAndMobileNo(patient.getBirthDate(),
				patient.getMobileNo());

		if (existingPatient == null) {
			patient.setPassword(encoder.encode(patient.getPassword()));
			patientRepository.save(patient);
			return "New patient added sucessfully";
		} else
			return "You are already registerd";
	}

	@Override
	public String updatePatientDetails(PatientDto patient) {

		Optional<Patient> patientTobeModify = patientRepository.findById(patient.getPatientId());

		if (patientTobeModify.isPresent()) {
			patientTobeModify.get().setName(patient.getName());
			patientTobeModify.get().setMobileNo(patient.getMobileNo());
			patientTobeModify.get().setBirthDate(patient.getBirthDate());
			patientTobeModify.get().setAddress(patient.getAddress());
			patientRepository.save(patientTobeModify.get());
			return "Patient updated sucessfully";
		}
		return "Patient is not valid check Id";
	}

	@Override
	public List<DoctorDto> getAllDoctorNames() {

		List<Employee> doctorList = empRepo.findAll().stream().filter(e -> e.getDepartment().getDeptId() == 2)
				.collect(Collectors.toList());

		List<DoctorDto> DrDtoList = new ArrayList<DoctorDto>();

		for (Employee employee : doctorList) {
			DoctorDto DrDto = new DoctorDto();

			DrDto.setEmpId(employee.getEmpId());
			DrDto.setEmpName(employee.getEmpName());
			DrDto.setDepartmentId(employee.getDepartment().getDeptId());
			DrDtoList.add(DrDto);
		}
		return DrDtoList;

	}
}
