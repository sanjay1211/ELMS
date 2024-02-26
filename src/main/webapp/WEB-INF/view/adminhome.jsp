<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.virtusa.lms.entity.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>ELMS :: AdminHome</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="resources/css/styles.css" rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark"
		aria-label="nav">
		<!-- Navbar Brand-->
		<h1 style="color: darkgray; font-size: 60px;">Virtusa</h1>
		
		<!-- Navbar Search-->
		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group">
				<input class="form-control" type="text" placeholder="Search for..."
					aria-label="Search for..." aria-describedby="btnNavbarSearch" />
				<button class="btn btn-primary" id="btnNavbarSearch" type="button">
					<em class="fas fa-search"></em>
				</button>
			</div>
		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><em
					class="fas fa-user fa-fw"></em></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">
					<%
					User user = (User) session.getAttribute("user");
					session.getMaxInactiveInterval();
					%>
					<li><a class="dropdown-item"
						href="myProfile?empId=<%=user.getEmployee().getEmpId()%>">Profile</a></li>
					<li><hr class="dropdown-divider" /></li>
					<li><a class="dropdown-item" href="login">Logout</a></li>
				</ul></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion" aria-label="nav">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading"></div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseLayouts" aria-expanded="false"
							aria-controls="collapseLayouts">
							<div class="sb-nav-link-icon">
								<em class="fas fa-columns"></em>
							</div> Manage Employees
							<div class="sb-sidenav-collapse-arrow">
								<em class="fas fa-angle-down"></em>
							</div>
						</a>
						<div class="collapse" id="collapseLayouts"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav" aria-label="nav">
								<a class="nav-link" href="addemployee">Add Employee</a> <a
									class="nav-link" href="assignmng">Assign Manager</a>
							</nav>
						</div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapsePages" aria-expanded="false"
							aria-controls="collapsePages">
							<div class="sb-nav-link-icon">
								<em class="fas fa-columns"></em>
							</div> Manage Leaves
							<div class="sb-sidenav-collapse-arrow">
								<em class="fas fa-angle-down"></em>
							</div>
						</a>

						<div class="collapse" id="collapsePages"
							aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav accordion"
								id="sidenavAccordionPages" aria-label="nav">
								<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
									data-bs-target="#pagesCollapseAuth" aria-expanded="false"
									aria-controls="pagesCollapseAuth"> <a class="nav-link"
									href="addleave">Add Leave</a> <a class="nav-link"
									href="addbalance">Allocate Leaves</a>
								</a>
							</nav>
						</div>
					</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">
						Welcome Admin
						<%=user.getEmployee().getEmpName()%></h1>
					<div class="row">
						<div class="col-xl-3 col-md-6">
							<div class="card bg-primary text-white mb-4">
								<div class="card-body">Employees</div>
								<div
									class="card-footer d-flex align-items-center justify-content-between">
									<a class="small text-white stretched-link" href="viewemployees">View
										Employees</a>
									<div class="small text-white">
										<em class="fas fa-angle-right"></em>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-md-6">
							<div class="card bg-warning text-white mb-4">
								<div class="card-body">Leaves</div>
								<div
									class="card-footer d-flex align-items-center justify-content-between">
									<a class="small text-white stretched-link" href="viewleaves">View
										Leaves</a>
									<div class="small text-white">
										<em class="fas fa-angle-right"></em>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-md-6">
							<div class="card bg-success text-white mb-4">
								<div class="card-body">Leave Balances</div>
								<div
									class="card-footer d-flex align-items-center justify-content-between">
									<a class="small text-white stretched-link"
										href="viewleavbalances">View Leave Balances</a>
									<div class="small text-white">
										<em class="fas fa-angle-right"></em>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-md-6">
							<div class="card bg-danger text-white mb-4">
								<div class="card-body">Leave Requests</div>
								<div
									class="card-footer d-flex align-items-center justify-content-between">
									<a class="small text-white stretched-link"
										href="adminlverequest">View Leave Requests</a>
									<div class="small text-white">
										<em class="fas fa-angle-right"></em>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</main>
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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="resources/js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="resources/js/chart-area-demo.js"></script>
	<script src="resources/js/chart-bar-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="resources/js/datatables-simple-demo.js"></script>
</body>
</html>
