package com.aakash.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aakash.dao.AppointmentDao;
import com.aakash.model.Appointment;
import com.aakash.service.AppointmentService;

@Component
public class AppointmentDaoImpl implements AppointmentDao {

	@Autowired
	AppointmentService appointmentService;

	@Override
	public void createAppointment(Appointment appointment) {
		appointmentService.createAppointment(appointment);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		return appointmentService.getAllAppointments();
	}

	@Override
	public Appointment getAppointmentById(long id) {
		return appointmentService.getAppointmentById(id);
	}
}
