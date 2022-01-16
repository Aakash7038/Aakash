<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment Booking</title>
<style type="text/css">
	label {
		display: inline-block;
		width: 200px;
		margin: 5px;
		text-align: left;
	}
	input,select {
		width: 200px;	
	}
	button {
		padding: 10px;
		margin: 10px;
	}
</style>
</head>
<body>
	<h3><a href="doctorView">Create Doctor</a></h3>
	
	<div align="center">
		<h2>Update Appointment</h2>
		<form action="createAppointment" method="post">
			<label>Patient name:</label>
			<input name="patientName" type="text" required="required" value="${appointment.patientName}"/><br/>
			
			<label>Email Id:</label>
			<input name="emailId" type="email" required="required" value="${appointment.emailId}"/><br/>

			<label>Mobile Number:</label>
			<input name="mobileNo" type="tel" pattern="^\d{3}-\d{3}-\d{4}$" required="required"
			placeholder="111-111-1111" value="${appointment.mobileNo}"/><br/>

			<label>Date of Birth:</label>
			<input name="dateOfBirth" type="date" required="required" value="${appointment.dateOfBirth}"/><br/>

			<label>Doctor Name:</label>
			<select name="doctor" required="required">
				<option value="${appointment.doctor.dId}">${appointment.doctor.name}</option>
	 			<c:forEach items="${doctor_list}" var="list">
	 				<option value="${list.dId}">${list.name}</option>
	 			</c:forEach>
		 	</select><br/>
		 	
			<label>Appointment Date:</label>
			<input name="appointmentDate" type="date" required="required" value="${appointment.appointmentDate}"/><br/>
			
			<label>Appointment Time:</label>
			<input name="appointmentTime" type="time" required="required" value="${appointment.appointmentTime}"/><br/>
			
			<input type="hidden" value="${appointment.id}" id="hid" name="hid"/>
			
			<input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>