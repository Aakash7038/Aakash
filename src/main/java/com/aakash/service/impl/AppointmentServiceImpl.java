package com.aakash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aakash.model.Appointment;
import com.aakash.repository.AppointmentRepository;
import com.aakash.service.AppointmentService;

@Component
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public void createAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment getAppointmentById(long id) {
		return appointmentRepository.findById(id).orElseThrow(null);
	}

}
