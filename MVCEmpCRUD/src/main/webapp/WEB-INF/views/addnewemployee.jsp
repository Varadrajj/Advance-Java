<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Employee Details</title>
</head>
<body align="center">
<form action="insertemployee" method="post">
	Enter Employee Id: <input type="text" name="eid" id="eid"/><br/><br/>
	Enter Employee Name: <input type="text" name="ename" id="ename"/><br/><br/>
	Enter Salary: <input type="text" name="sal" id="sal"/><br/><br/>
	Enter Department: <input type="text" name="dept" id="dept"/><br/><br/>
	<button type="submit" name="btn">Submit</button>
</form>

</body>
</html>