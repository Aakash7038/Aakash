package com.aakash.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aakash.dao.DoctorDao;
import com.aakash.model.Doctor;

@Controller
public class DoctorController {

	@Autowired
	DoctorDao doctorDao;

	@RequestMapping(value = "/createDoctor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createDoctor(@RequestParam String name, @RequestParam String specification,
			@RequestParam String availableDate, @RequestParam String availableDateStart,
			@RequestParam String availableDateEnd) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		Date date = formatter.parse(availableDate);

		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date startTime = dateFormat.parse(availableDateStart);
		Date endTime = dateFormat.parse(availableDateEnd);

		Doctor doctor = new Doctor();
		doctor.setName(name);
		doctor.setSpecification(specification);
		doctor.setAvailableDate(date);
		doctor.setAvailableDateStart(startTime);
		doctor.setAvailableDateEnd(endTime);
		doctorDao.createDoctor(doctor);
		return "doctor";
	}
}
