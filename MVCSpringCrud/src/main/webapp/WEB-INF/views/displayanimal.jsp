<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">*********JURASSIC PARK**********</h1>
	<table border="2" align="center">
		<tr>
			<td>Animal ID :</td>
			<td>Animal Name :</td>
			<td>Animal Age :</td>
			<td>Action :</td>
		</tr>
		<c:forEach var="a" items="${alist}">
			<tr>
				<td>${a.id}</td>
				<td>${a.name}</td>
				<td>${a.age}</td>
				<td><a href="edit/${a.id}">EDIT</a> 
				/
				<a href="delete/${a.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="addnewanimal">Add New Animal</a>
</body>
</html>