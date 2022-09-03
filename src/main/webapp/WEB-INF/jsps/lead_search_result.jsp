<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
 <%@ include file="menu.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Leads</title>
</head>
<body>
	<h2>Lead List |</h2>
	
	<table border="2">
		<tr>
		<th>FirstName</th>
		<th>LastName</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Delete</th>
		<th>Update</th>
		
		</tr>
	
	<c:forEach var = "lead" items="${leads}">
	
	<tr>
		<td>${lead.firstName}</td>
		<td>${lead.lastName}</td>
		<td>${lead.email}</td>
		<td>${lead.mobile}</td>
		<td><a href="delete?id=${lead.id}">Delete</a></td>
		<td><a href="update?id=${lead.id}">Update</a></td>
		</tr>
		
	</c:forEach>
	
	
	</table>

</body>
</html>