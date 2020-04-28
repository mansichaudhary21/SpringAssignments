<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Enter Trainee Details</h3>
<form method="get" action="processtrainee">
	<label>Trainee Id</label>
	<div>
		<input type="number" id="id" name="traineeid"><br>
	</div>
	<label>Trainee Name</label>
	<div>
		<input type="text" id="nameid" name="traineename"><br>
	</div>
	<label>Trainee Location</label>
	<div>
	<label>Chennai</label>
		<input type="radio" id="chennai" name="traineelocation"  value="chennai">
	<label>Banglore</label>
		<input type="radio" id="banglore" name="traineelocation"  value="banglore">
	<label>Mumbai</label>
		<input type="radio" id="mumbai" name="traineelocation"  value="mumbai">
	<label>Pune</label>
		<input type="radio" id="pune" name="traineelocation"  value="pune">
	</div>
	<label>TraineeDomain</label>
	<div>
		<select name="domain">
			<option>JEE</option>
			<option>.Net</option>
			<option>Mainframe</option>
		</select>
	</div>
	<br>
	<input type="submit" value="Add Employee">
</form>
</body>
</html>