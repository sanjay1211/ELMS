<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.virtusa.lms.entity.LeaveBalance"%>
<%@page import="com.virtusa.lms.entity.User"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>ELMS :: ApplyLeave</title>
<link href="resources/css/styles.css" rel="stylesheet" />
<link href="resources/css/mystyles.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
.mul-select {
	width: 100%;
}
</style>
</head>
<body class="bg-primary">
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-7">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">Apply Leave</h3>
								</div>
								<div class="card-body">
									<p class="failures">${error}</p>
									<form action="applylve" method="post">
										<div class="row mb-3">
											<div class="col-md-6">
												<div class="form-floating mb-3 mb-md-0">
													<input class="form-control" id="frmdate"
														required="required" placeholder="from date"
														name="fromDate" type="date" /> <label for="frmdate">From
														Date</label>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-floating">
													<input class="form-control" id="todate" required="required"
														name="toDate" type="date" placeholder="to date" /> <label
														for="todate">To Date</label>

												</div>
											</div>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" id="reason" type="text"
												name="reason" required="required" placeholder="reason" /> <label
												for="reason">Reason</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="hidden" name="status"
												value="pending" />
										</div>
										<%
											User user = (User) session.getAttribute("user");
											session.getMaxInactiveInterval();
										%>
										<div class="form-floating mb-3">
											<input class="form-control" type="hidden" name="empId"
												value="<%=user.getEmployee().getEmpId()%>" />
										</div>
										<label style="color: white;" for="mng">Leave Type</label>
										<div>
											<label for="lvmtype">Leave Type</label> <select
												class="mul-select" id="lvmtype" name="lvmName"
												required="required">
												<%
												int slno = 0;
												List<LeaveBalance> leaveBalances = (List<LeaveBalance>) request.getAttribute("lvbList");
												for (LeaveBalance lvb : leaveBalances) {
													if (lvb.getEmp().getEmpId() == user.getEmployee().getEmpId()) {
														slno++;
												%>
												<option><%=lvb.getLeaveMaster().getLvmName()%></option>

												<%
												}
												}
												%>
											</select>
										</div>
										<div class="mt-4 mb-0">
											<div class="d-grid">
												<input type="submit" value="Apply">
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
		<div id="layoutAuthentication_footer">
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; LMS 2022 Developed
							By Sanjay. All Rights Reserved</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
</body>
</html>

