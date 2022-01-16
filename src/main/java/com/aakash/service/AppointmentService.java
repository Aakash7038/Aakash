package com.aakash.service;

import java.util.List;

import com.aakash.model.Appointment;

public interface AppointmentService {

	void createAppointment(Appointment appointment);

	List<Appointment> getAllAppointments();

	Appointment getAppointmentById(long id);

}
