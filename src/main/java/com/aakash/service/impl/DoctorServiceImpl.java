package com.aakash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aakash.model.Doctor;
import com.aakash.repository.DoctorRepository;
import com.aakash.service.DoctorService;

@Component
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public void createDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public List<Doctor> getDoctorsAvailability(long doctor, String aptDate, String startTime) {
		return doctorRepository.getDoctorsAvailability(doctor, aptDate, startTime);
	}

}
