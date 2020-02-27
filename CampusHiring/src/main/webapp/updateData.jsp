<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body>
	<h1>Update data of the Employee</h1>

	<form action="updateEmployeeDetails">
		Employee name:<br> <input type="text" name="ename"
			value="${employee.ename}"><br> Employee skill:<br>
		<input type="text" name="tech" value="${employee.tech}"><br>
		Employee salary:<br> <input type="number" name="emp_salary"
			value="${employee.emp_salary}"><br> Employee gender:<br>
		"${employee.emp_gender}"<br> <input type="radio"
			name="emp_gender" value="male"> Male<br> <input
			type="radio" name="emp_gender" value="female"> Female<br>
		<input type="radio" name="emp_gender" value="other"> Other<br>
		<input type="submit">
	</form>

	<!-- 	<table style="width: 100%"> -->
	<!-- 		<tr> -->

	<!-- 			<th>Employee name</th> -->
	<!-- 			<th>Employee skill:</th> -->
	<!-- 			<th>Employee salary</th> -->
	<!-- 			<th>Employee gender:</th> -->

	<!-- 		</tr> -->

	<%-- 		<c:forEach var="employee" items="${employee}"> --%>

	<!-- 			<tr> -->
	<%-- 				<td><input type="text" name="ename" value="${employee.ename}"></td> --%>
	<%-- 				<td><input type="text" name="tech" value="${employee.tech}"></td> --%>
	<!-- 				<td><input type="number" name="emp_salary" -->
	<%-- 					value="${employee.emp_salary}"></td> --%>
	<!-- 				<td><input type="radio" name="emp_gender" value="male"> -->
	<!-- 					Male<br> <input type="radio" name="emp_gender" value="female"> -->
	<!-- 					Female<br> <input type="radio" name="emp_gender" value="other"> -->
	<!-- 					Other</td> -->
	<!-- 			</tr> -->

	<%-- 		</c:forEach> --%>

	<!-- 	</table> -->
</body>
</html>