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
<h1>Record of all Products</h1>
<table border="1">
    <tr>
      <th>Product Id</th>
      <th>Product Name</th> 
      <th>Product Price</th>
    </tr>
 <c:forEach items="${products}" var="product">
<tr >
    <td><c:out value="${product.productId}"/></td> 
    <td><c:out value="${product.productName}"/></td> 
    <td><c:out value="${product.productPrice}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>