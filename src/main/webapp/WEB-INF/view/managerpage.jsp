<%@page import="com.virtusa.lms.entity.User"%>
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
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
			aria-expanded="false"><em class="fas fa-user fa-fw"></em></a>
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
						</div> Leave Statuses
						<div class="sb-sidenav-collapse-arrow">
							<em class="fas fa-angle-down"></em>
						</div>
					</a>
					<div class="collapse" id="collapseLayouts"
						aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav" aria-label="nav">
							<a class="nav-link" href="leavestatus">My Leave Status</a>
						</nav>
					</div>
				</div>
			</div>
		</nav>
	</div>
<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">
				Welcome Manager
				<%=user.getEmployee().getEmpName()%></h1>
			<div class="row">
				<div class="col-xl-3 col-md-6">
					<div class="card bg-primary text-white mb-4">
						<div class="card-body">Employees</div>
						<div
							class="card-footer d-flex align-items-center justify-content-between">
							<a class="small text-white stretched-link" href="empsundermng">View
								Employees</a>
							<div class="small text-white">
								<em class="fas fa-angle-right"></em>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-md-6">
					<div class="card bg-warning text-white mb-4">
						<div class="card-body">Apply Leave</div>
						<div
							class="card-footer d-flex align-items-center justify-content-between">
							<a class="small text-white stretched-link" href="applylvm">Apply
								Leave</a>
							<div class="small text-white">
								<em class="fas fa-angle-right"></em>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-md-6">
					<div class="card bg-success text-white mb-4">
						<div class="card-body">My Leave Balances</div>
						<div
							class="card-footer d-flex align-items-center justify-content-between">
							<a class="small text-white stretched-link" href="mngleavebalance">View
								Leave Balances</a>
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
							<a class="small text-white stretched-link" href="lverequest">View
								Leave Requests</a>
							<div class="small text-white">
								<em class="fas fa-angle-right"></em>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
