package com.aakash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aakash.dao.AppointmentDao;
import com.aakash.dao.DoctorDao;
import com.aakash.model.Appointment;

@Controller
public class ViewController {

	@Autowired
	DoctorDao doctorDao;

	@Autowired
	AppointmentDao appointmentDao;

	@RequestMapping(value = { "/", "/doctorView" }, method = RequestMethod.GET)
	public String home(Model model) {
		return "doctor";
	}

	@RequestMapping(value = "/patientView", method = RequestMethod.GET)
	public String appointment(Model model) {
		model.addAttribute("doctor_list", doctorDao.getAllDoctors());
		model.addAttribute("appointment_list", appointmentDao.getAllAppointments());
		return "appointment";
	}

	@RequestMapping(value = "/updateAppointment", method = RequestMethod.GET)
	public String updateAppointment(@RequestParam long id, Model model) {
		Appointment appointment = appointmentDao.getAppointmentById(id);
		model.addAttribute("doctor_list", doctorDao.getAllDoctors());
		model.addAttribute("appointment", appointment);
		return "updateApt";
	}
}
