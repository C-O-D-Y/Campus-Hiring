<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta Http-Equiv="Cache-Control" Content="no-cache">
<meta Http-Equiv="Pragma" Content="no-cache">
<meta Http-Equiv="Expires" Content="0">
<title>EmployeeManagement-Login</title>
</head>
<script>
	
</script>
<body>
	<div>
		<h3>Login</h3>
		${SPRING_SECURITY_LAST_EXCEPTION.message}
		<form method="post">
			UserName:<br> <input type="text" name="username"
				required="required"><br> Password:<br> <input
				type="password" name="password" required="required"><br>
			<input name="submit" type="submit" value="submit"><br>
		</form>
	</div>

</body>
</html>



<!-- This the customized login page for spring security  
 so the name attribute values of the login page above should 
remain same as they written here -->