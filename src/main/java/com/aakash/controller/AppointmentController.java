package com.aakash.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aakash.dao.AppointmentDao;
import com.aakash.dao.DoctorDao;
import com.aakash.model.Appointment;
import com.aakash.model.Doctor;

@Controller
public class AppointmentController {

	@Autowired
	DoctorDao doctorDao;
	
	@Autowired
	AppointmentDao appointmentDao;

	@RequestMapping(value = "/createAppointment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createAppointment(@RequestParam String patientName, @RequestParam String emailId,
			@RequestParam String mobileNo, @RequestParam String dateOfBirth, @RequestParam String appointmentDate,
			@RequestParam String appointmentTime, @RequestParam long doctor, @RequestParam long hid, Model model) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		Date dob = formatter.parse(dateOfBirth);
		Date aptDate = formatter.parse(appointmentDate);

		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date startTime = dateFormat.parse(appointmentTime);

		long mNumber = Long.parseLong(mobileNo.replace("-", ""));

		Appointment apt = new Appointment();
		
		if(hid >= 1) {
			apt.setId(hid);
		}

		apt.setPatientName(patientName);
		apt.setEmailId(emailId);
		apt.setMobileNo(mNumber);
		apt.setDateOfBirth(dob);
		apt.setAppointmentDate(aptDate);
		apt.setAppointmentTime(startTime);

		Doctor doc = new Doctor(doctor);
		apt.setDoctor(doc);


		List<Doctor> doctors = doctorDao.getDoctorsAvailability(doctor, appointmentDate, appointmentTime);
		System.out.println(doctors.size());

		if(!doctors.isEmpty()) {
			appointmentDao.createAppointment(apt);
			model.addAttribute("msg","Your appointment is booked.");
		} else {
			model.addAttribute("msg","Sorry Your Appointment is not booked. Doctor is not available.");
		}

		return "success";
	}

}
