<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>ELMS :: AddLeave</title>
<link href="resources/css/styles.css" rel="stylesheet" />
<link href="resources/css/mystyles.css" rel="stylesheet" />

</head>
<body class="bg-primary">
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-5">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">Add Leave</h3>
								</div>
								<div class="card-body">
									<p class="success">${message}</p>
									<form action="saveleave" method="post">
										<div class="form-floating mb-3">
											<input class="form-control" id="leavename" name="lvmName"
												type="text" placeholder="Leave Name" required="required" /> <label
												for="leavename">Leave Name</label>

										</div>
										<div class="form-floating mb-3">
											<input class="form-control" id="leaveabbr" name="lvmAbbr"
												type="text" placeholder="Leave Abbr" required="required" /> <label
												for="leaveabbr">Leave Abbrivation</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" id="maxVal" name="maxBalance"
												type="text" placeholder="Maximum Balance"  min="0.01" step="0.01" required="required" /> <label
												for="maxVal">Maximum Balance</label>
										</div>
										<div class="card-footer text-center py-3">
											<input type="submit" class="btn btn-primary" value="Add">
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
