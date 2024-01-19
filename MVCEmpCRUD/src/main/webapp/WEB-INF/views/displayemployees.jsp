<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body align="center">
<h1><i>Employees Details</i></h1><hr/>
<table border="2" align="center">
	<tr>
		<th>Employee Id</th>
		<th>Employee Name</th>
		<th>Salary</th>
		<th>Department</th>
		<th>Action</th>
	</tr>
	<c:forEach var="e" items="${elist}">
	<tr>
		<td>${e.eid}</td>
		<td>${e.ename}</td>
		<td>${e.sal}</td>
		<td>${e.dept}</td>
		<td>
		<a href="edit/${e.eid}">Edit</a>
		/
		<a href="delete/${e.eid}">Delete</a>
		</td>
	</tr>
	</c:forEach>
</table><br/>
<a href="addnewemployee">Add New Employee</a>

</body>
</html>