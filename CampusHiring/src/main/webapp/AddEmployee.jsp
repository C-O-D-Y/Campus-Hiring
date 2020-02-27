<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees Details</title>

</head>
<body>
	<h3>${message}</h3>
	<div>
		<h4>Add The Employee</h4>
		<form action="addAnEmployee">
			Employee Id:<br> <input type="number" name="eid"
				required="required"><br> Employee name:<br> <input
				type="text" name="ename" required="required"><br>
			Employee skill:<br> <input type="text" name="tech"
				required="required"><br> Employee salary:<br> <input
				type="number" name="emp_salary" required="required"><br>
			Employee gender:<br> <input type="radio" name="emp_gender"
				value="male"> Male<br> <input type="radio"
				name="emp_gender" value="female"> Female<br> <input
				type="radio" name="emp_gender" value="other"> Other<br>
			<input type="submit">
		</form>
	</div>
</body>
</html>