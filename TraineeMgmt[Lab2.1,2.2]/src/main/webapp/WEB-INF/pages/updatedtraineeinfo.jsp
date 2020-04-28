<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Modify Operation</h3>
	<form method="get" action="processmodify">
 		<label>Trainee Id</label>
		<div>
			<input type="number" id="id" name="traineeId"><br>
		</div>
		<label>Trainee Name</label>
		<div>
			<input type="text" id="nameid" name="traineename"><br>
		</div>
		<label>Trainee Location</label>
		<div>
			<input type="text" id="locationid" name="traineelocation"><br>
		</div>
		<label>TraineeDomain</label>
		<div>
			<input type="text" id="domainid" name="traineedomain"><br>
		</div>
			<input type="submit" value="Update">
	</form>

</body>
</html>