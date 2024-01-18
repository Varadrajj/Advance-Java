<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/MVCSpringCrud/animal/updateanimal" method="post">
	Enter ID :<input type="text" name="id" value="${a.id}"/>
	Enter Name :<input type="text" name="name" value="${a.name}"/>
	Enter Age :<input type="text" name="age" value="${a.age}"/>
	<button type="submit" name="btn" id="btn">Update Product</button>
	</form>
</body>
</html>