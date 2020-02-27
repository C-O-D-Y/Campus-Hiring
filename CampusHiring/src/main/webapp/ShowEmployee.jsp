<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fetch Employee</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<div>
		<h4>Employee Details</h4>

		<table style="width: 100%">
			<tr>
				<th>Employee Id</th>
				<th>Employee name</th>
				<th>Employee skill:</th>
				<th>Employee salary</th>
				<th>Employee gender:</th>

			</tr>
			<tr>
				<td>${employee.eid}</td>
				<td>${employee.ename}</td>
				<td>${employee.tech}</td>
				<td>${employee.emp_salary}</td>
				<td>${employee.emp_gender}</td>
			</tr>

		</table>
		<%-- 		Employee Id:<br> ${employee.eid} <br> Employee name:<br> --%>
		<%-- 		${employee.ename}<br> Employee skill:<br> ${employee.tech}<br> --%>
		<%-- 		Employee salary:<br> ${employee.emp_salary}<br> Employee --%>
		<%-- 		gender:<br>${employee.emp_gender} --%>

	</div>
</html>