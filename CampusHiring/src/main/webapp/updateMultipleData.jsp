<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body onload="showHideDiv()">
	<h1>Update data of the Employee</h1>
	<br>
	<h2>
		The value in the blank boxes will be <strong>applicable for
			all the data for the specific column</strong>
	</h2>
	<h5>Leave the boxes blank for not changing any data for specific
		column</h5>
	<br>
	<script type="text/javascript">
		function showHideDiv() {
			 var mydiv1= document.getElementById("updatebyName");
			 var mydiv2= document.getElementById("updatebyTech");
			if(${check}==1)
				{
				 mydiv1.style.visibility="hidden";
				 mydiv2.style.visibility="show";
				}
			else
				{
				 mydiv2.style.visibility="hidden";
				 mydiv1.style.visibility="show";
				}
		}
	</script>

	<div id="updatebyName">
		<form action="updateEmployeeDetailsByName">
			<table style="width: 50%">
				<tr>

					<th>Employee name</th>
					<th>Employee skill:</th>
					<th>Employee salary</th>
					<th>Employee Gender</th>
				</tr>

				<tr>

					<td><input type="text" name="ename" value=""></td>
					<td><input type="text" name="tech" value=""></td>
					<td><input type="number" name="emp_salary" value="0"></td>
					<td><input type="text" name="emp_gender" value=""></td>
				</tr>
				<c:forEach var="employee" items="${employee}">

					<tr>
						<td>${employee.ename}</td>
						<td>${employee.tech}</td>
						<td>${employee.emp_salary}</td>
						<td>${employee.emp_gender}</td>
					</tr>

				</c:forEach>
			</table>

			<input type="submit" />

		</form>
	</div>


	<div id="updatebyTech">
		<form action="updateEmployeeDetailsByTech">
			<table style="width: 50%">
				<tr>

					<th>Employee name</th>
					<th>Employee skill:</th>
					<th>Employee salary</th>
					<th>Employee Gender</th>
				</tr>

				<tr>

					<td><input type="text" name="ename" value=""></td>
					<td><input type="text" name="tech" value=""></td>
					<td><input type="number" name="emp_salary" value="0"></td>
					<td><input type="text" name="emp_gender" value=""></td>
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
			<input type="submit" />
		</form>
	</div>
</body>
</html>