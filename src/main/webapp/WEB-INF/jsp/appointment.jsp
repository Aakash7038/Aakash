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
		<h2>Add Appointment</h2>
		<form action="createAppointment" method="post">
			<label>Patient name:</label>
			<input name="patientName" type="text" required="required"/><br/>
			
			<label>Email Id:</label>
			<input name="emailId" type="email" required="required"/><br/>

			<label>Mobile Number:</label>
			<input name="mobileNo" type="tel" pattern="^\d{3}-\d{3}-\d{4}$" required="required"
			placeholder="111-111-1111"/><br/>

			<label>Date of Birth:</label>
			<input name="dateOfBirth" type="date" required="required"/><br/>

			<label>Doctor Name:</label>
			<select name="doctor" required="required">
	 			<c:forEach items="${doctor_list}" var="list">
	 				<option value="${list.dId}">${list.name}</option>
	 			</c:forEach>
		 	</select><br/>
		 	
			<label>Appointment Date:</label>
			<input name="appointmentDate" type="date" required="required"/><br/>
			
			<label>Appointment Time:</label>
			<input name="appointmentTime" type="time" required="required"/><br/>
			
			<input type="hidden" value="0" id="hid" name="hid"/>
			
			<input type="submit" value="Submit">
		</form>
	
		<br/>
		<br/>	
		<div align="center">
		<table border="1">
			<tr>
				<th>Patient Name</th>
				<th>Email</th>
				<th>Mobile No</th>
				<th>Date Of Birth</th>
				<th>Doctor's Name</th>
				<th>Appointment Date</th>
				<th>Appointment Time</th>
				<th style="width: 15%;">Action</th>
			</tr>
			<c:forEach items="${appointment_list}" var="list" varStatus="counter">
				<tr>
					<td>${list.patientName}</td>
					<td>${list.emailId}</td>
					<td>${list.mobileNo}</td>
					<td>${list.dateOfBirth}</td>
					<td>${list.doctor.name}</td>
					<td>${list.appointmentDate}</td>
					<td>${list.appointmentTime}</td>
					<td><button type="button" onclick="window.location = 'updateAppointment?id=${list.id}'"> Update</button>
				</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>
</body>
</html>