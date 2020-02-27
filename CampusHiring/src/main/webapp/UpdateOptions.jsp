<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Update Employee</title>
<style>
.box {
	color: #fff;
	padding: 20px;
	display: none;
	margin-top: 20px;
}

.id {
	background: #000000;
}

.name {
	background: #000000;
}

.tech {
	background: #000000;
}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(document).ready(function() {
		$('input[type="radio"]').click(function() {
			var inputValue = $(this).attr("value");
			var targetBox = $("." + inputValue);
			$(".box").not(targetBox).hide();
			$(targetBox).show();
		});
	});
</script>
</head>
<body>

	<span>Select The updating Option</span>
	<div>
		<label><input type="radio" name="colorRadio" value="red">
			Employee Id</label> <label><input type="radio" name="colorRadio"
			value="green"> Employee Name</label> <label><input
			type="radio" name="colorRadio" value="blue"> Employee Tech</label>
	</div>
	<div class="red id box">
		<form action="updateEmployee">
			<div id="empId">
				Employee Id <input type="number" id="empid" name="eid" />
			</div>
			<input type="submit" />

		</form>
	</div>
	<div class="green name box">

		<form action="updateEmployeeByName">
			<div id="employeeName">
				Employee Name <input type="text" id="empName" name="ename" />
			</div>
			<input type="submit" />

		</form>

	</div>
	<div class="blue tech box">


		<form action="updateEmployeeByTech">
			<div id="employeeTech">
				Employee Tech <input type="text" id="empTech" name="tech" />
			</div>

			<input type="submit" />
		</form>

	</div>
</body>
</html>