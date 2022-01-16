<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	input {
		width: 200px;	
	}
	button {
		padding: 10px;
		margin: 10px;
	}
</style>
</head>
<body>
	<h3><a href="patientView">Create Appointment</a></h3>
	
	<div align="center">
		<h2>Doctor Registration</h2>
		<form action="createDoctor" method="post">
			<label>Full name:</label>
			<input name="name" type="text" required="required"/><br/>
			
			<label>Specification:</label>
			<input name="specification" type="text" required="required"/><br/>

			<label>Available Date:</label>
			<input name="availableDate" type="date" required="required"/><br/>
			
			<label>Availability Start Time:</label>
			<input name="availableDateStart" type="time" required="required"/><br/>
			
			<label>Availability End Time:</label>
			<input name="availableDateEnd" type="time" required="required"/><br/>
			
			<input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>