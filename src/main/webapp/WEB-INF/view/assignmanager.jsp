<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.virtusa.lms.entity.Employee"%>

<!DOCTYPE HTML>
<html lang="">
<head>
<title>ELMS :: AssignManager</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<style>
.mul-select {
	width: 100%;
}
</style>

</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container-fluid h-100 bg-light text-dark">
		<div class="row justify-content-center align-items-center">
			<h1>Assign Manager</h1>
		</div>
		<br> <br>
		<div class="row justify-content-center align-items-center h-100">
			<div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3"
				style="background-color: navy;">
				<div class="form-group">
				<p style="color: white;">${error}</p>
					<form action="updateasign" method="post">
						<label style="color: white;" for="emp">Employee</label> <select
							required="required" class="mul-select" id="emp" multiple="true"
							name="names">
							<%
							List<Employee> employees = (List<Employee>) request.getAttribute("emplist");
							for (Employee emp : employees) {
								if (emp.getUser().getRole().getRoleId() == 3 || emp.getUser().getRole().getRoleId() == 2) {
							%>
							<option><%=emp.getEmpName()%></option>

							<%
							}
							}
							%>
						</select>
						<div>
							<label style="color: white;" for="mng">Manager</label>
						</div>
						<div>
							<select class="mul-select" id="mng" name="manager"
								required="required">
								<%
								for (Employee emp : employees) {
									if (emp.getUser().getRole().getRoleId() == 2) {
								%>
								<option><%=emp.getEmpName()%></option>
								<%
								}
								}
								%>
							</select>
						</div>
						<br> <input style="background-color: lime;" type="submit"
							value="Assign">
					</form>
					<script>
						$(document).ready(function() {
							$(".mul-select").select2({
								placeholder : "Select Employees", //placeholder
								tags : true,
								tokenSeparators : [ '/', ',', ';', " " ]
							});
						})
					</script>
				</div>
			</div>
		</div>
		<br><br><br><br><br>
		<div>
			<p style="text-align: center;">Copyright &copy;LMS 2022 Developed
				by Sanjay. All Rights Reserved</p>
		</div>
</body>
</html>