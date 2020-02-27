<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Employee</title>

<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>

	<div>

		<h4>Deleted Employee is</h4>

		<table style="width: 100%">
			<tr>
				<th>Employee Id</th>
				<th>Employee name</th>
				<th>Employee skill:</th>
				<th>Employee salary</th>
				<th>Employee gender:</th>

			</tr>

			<c:forEach var="employee" items="${employee}">

				<tr>
					<td>${employee.eid}</td>
					<td>${employee.ename}</td>
					<td>${employee.tech}</td>
					<td>${employee.emp_salary}</td>
					<td>${employee.emp_gender}</td>
				</tr>

			</c:forEach>

		</table>

		<%-- 		Employee Id:<br> ${employee.eid} <br> Employee name:<br> --%>
		<%-- 		${employee.ename}<br> Employee skill:<br> ${employee.tech}<br> --%>
		<%-- 		Employee salary:<br> ${employee.emp_salary}<br> Employee --%>
		<%-- 		gender:<br>${employee.emp_gender} --%>

	</div>

	<div>
		<h3>Employees after deleting</h3>
		<br>

		<table style="width: 100%">
			<tr>
				<th>Employee Id</th>
				<th>Employee name</th>
				<th>Employee skill:</th>
				<th>Employee salary</th>
				<th>Employee gender:</th>

			</tr>

			<c:forEach var="employeeList" items="${employeeList}">

				<tr>
					<td>${employeeList.eid}</td>
					<td>${employeeList.ename}</td>
					<td>${employeeList.tech}</td>
					<td>${employeeList.emp_salary}</td>
					<td>${employeeList.emp_gender}</td>
				</tr>

			</c:forEach>

		</table>

	</div>
</body>
</html>