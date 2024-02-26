<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.virtusa.lms.entity.LeaveMaster"%>
<%@page import="com.virtusa.lms.entity.Employee"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ELMS :: AddLeaveBalance</title>
<link href="resources/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="resources/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="resources/css/morris.css" type="text/css" />
<link href="resources/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/jquery-ui.css">
<link href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css' />
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link rel="shortcut icon" href="resources/img/favicon.png">
<link href="resources/css/mystyles.css" rel="stylesheet" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
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
			<h1>Allocate Leave balance</h1>
		</div>
		<br> <br>
		<div class="row justify-content-center align-items-center h-100">
			<div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3"
				style="background-color: navy;">
				<div class="form-group">
					<p style="color: white;">${error}</p>
					<form action="savelvb" method="post">
						<div>
							<label style="color: white;" for="emp">Employee</label> <select
								required="required" class="mul-select" id="emp" multiple="true"
								name="names">
								<%
								List<Employee> employees = (List<Employee>) request.getAttribute("empyList");
								for (Employee emp : employees) {
									if (emp.getUser().getRole().getRoleId() == 3 || emp.getUser().getRole().getRoleId() == 2) {
								%>
									<option><%=emp.getEmpName()%></option>
								<%
								}
								}
								%>
							</select>
						</div>
						<div>
							<label style="color: white;" for="mng">Leave Type</label>
						</div>
						<div>
							<select class="mul-select" id="mng" name="lvm"
								required="required">
								<%
								List<LeaveMaster> leaveMasters = (List<LeaveMaster>) request.getAttribute("lvmList");
								for (LeaveMaster lvm : leaveMasters) {
									
								%>
								<option><%=lvm.getLvmName()%></option>
								<%
								}
								%>
							</select>
						</div>
						<div>
							<label style="color: white;" for="num">Balance per year</label>
						</div>
						<div>
							<input type="number" id="num" name="balance"  min="0.01" step="0.01" required="required">
						</div>
						<br> <input style="background-color: lime;" type="submit"
							value="Allocate">
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
		<br> <br> <br> <br>
		<div>
			<p style="text-align: center;">Copyright &copy;LMS 2022 Developed
				by Sanjay. All Rights Reserved</p>
		</div>
</body>
</html>