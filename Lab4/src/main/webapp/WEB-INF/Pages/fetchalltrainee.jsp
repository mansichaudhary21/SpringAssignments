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
<h1>Record of all Trainee</h1>
<table border="1">
    <tr>
      <th>Trainee Id</th>
      <th>Trainee Name</th> 
      <th>Trainee Domain </th>
      <th>Trainee Location</th>
    </tr>
 <c:forEach items="${fetch}" var="trainee">
<tr >
    <td><c:out value="${trainee.traineeId}"/></td> 
    <td><c:out value="${trainee.traineeName}"/></td> 
    <td><c:out value="${trainee.traineeDomain}"/></td>
    <td><c:out value="${trainee.traineeLocation}"/></td>
</tr>
</c:forEach>
 </table>

</body>
</html>