package com.aakash.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aakash.dao.DoctorDao;
import com.aakash.model.Doctor;
import com.aakash.service.DoctorService;

@Component
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	DoctorService doctorService;

	@Override
	public void createDoctor(Doctor doctor) {
		doctorService.createDoctor(doctor);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorService.getAllDoctors();
	}

	@Override
	public List<Doctor> getDoctorsAvailability(long doctor, String aptDate, String startTime) {
		return doctorService.getDoctorsAvailability(doctor, aptDate, startTime);
	}
}
