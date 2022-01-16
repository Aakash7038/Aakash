package com.aakash.dao;

import java.util.List;

import com.aakash.model.Doctor;

public interface DoctorDao {

	void createDoctor(Doctor doctor);

	List<Doctor> getAllDoctors();

	List<Doctor> getDoctorsAvailability(long doctor, String aptDate, String startTime);
}
