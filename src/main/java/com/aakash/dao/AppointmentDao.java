package com.aakash.dao;

import java.util.List;

import com.aakash.model.Appointment;

public interface AppointmentDao {

	void createAppointment(Appointment appointment);

	List<Appointment> getAllAppointments();

	Appointment getAppointmentById(long id);

}
