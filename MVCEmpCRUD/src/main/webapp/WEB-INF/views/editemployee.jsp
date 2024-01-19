<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body align="center">
<form action="/MVCEmpCRUD/employee/updateemployee" method="post">
	Enter Employee Id: <input type="text" name="eid" id="eid" value="${e.eid}"readonly/><br/><br/>
	Enter Employee Name: <input type="text" name="ename" id="ename" value="${e.ename}"/><br/><br/>
	Enter Salary: <input type="text" name="sal" id="sal" value="${e.sal}"/><br/><br/>
	Enter Department: <input type="text" name="dept" id="dept" value="${e.dept}"/><br/><br/>
	<button type="submit" name="btn">Submit</button>
</form>

</body>
</html>