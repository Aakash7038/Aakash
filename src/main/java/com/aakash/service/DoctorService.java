package com.aakash.service;

import java.util.List;

import com.aakash.model.Doctor;

public interface DoctorService {

	void createDoctor(Doctor doctor);

	List<Doctor> getAllDoctors();

	List<Doctor> getDoctorsAvailability(long doctor, String aptDate, String startTime);
}
