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
	<h3>Retreive Operation</h3>
	<form method="get">
		<table border="1">
			<tr>
				<td>Trainee Id</td>
				<td>Trainee Name</td>
				<td>Trainee Location</td>
				<td>Trainee Domain</td>
			</tr>
			<tr>
				<td><c:out value="${trainee.traineeId}"/></td>
				<td><c:out value="${trainee.traineeName}"/></td>
				<td><c:out value="${trainee.traineeLocation}"/></td>
				<td><c:out value="${trainee.traineeDomain }"/></td>
			</tr>
		</table>
	</form>
</body>
</html>