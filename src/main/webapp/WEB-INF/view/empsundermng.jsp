<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="com.virtusa.lms.entity.Employee"%>
<%@page import="com.virtusa.lms.entity.User"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>ELMS :: ViewEmployees</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="resources/css/styles.css" rel="stylesheet" />
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	></script>
</head>
<body>
	<main>
		<%@include file="managerpage.jsp"%>
		<div class="card mb-4">
			<div class="card-header">
				<em class="fas fa-table me-1"></em> Employee Details
			</div>
		</div>
		<div class="card-body">
			<table id="datatablesSimple">
			 <caption></caption>
				<thead>
					<tr>
						<th id="slno">SL No</th>
						<th id="empname">Employee Name</th>
						<th id="empMail">Employee Email</th>
						<th id="empMob">Employee Mobile</th>
						<th id="empDob">Employee DOB</th>
						<th id="empDoj">Employee DOJ</th>
						<th id="roleName">Role</th>
						<th id="mngName">Manager Name</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th id="slno">SL No</th>
						<th id="empname">Employee Name</th>
						<th id="empMail">Employee Email</th>
						<th id="empMob">Employee Mobile</th>
						<th id="empDob">Employee DOB</th>
						<th id="empDoj">Employee DOJ</th>
						<th id="roleName">Role</th>
						<th id="mngName">Manager Name</th>
					</tr>
				</tfoot>
				<tbody>
					<%
					int slno = 0;
					SimpleDateFormat simple = new SimpleDateFormat("dd-MMM-yyy");
					List<Employee> employees = (List<Employee>) request.getAttribute("empList");
					
					for (Employee emp : employees) {
						if ((emp.getUser().getRole().getRoleId() == 3 || emp.getUser().getRole().getRoleId() == 2) && emp.getManagerId()==user.getEmployee().getEmpId()) {
							slno++;
							Employee mng=employees.stream().filter(id -> id.getEmpId() == emp.getManagerId()).findAny().orElse(null);
							Date dob = emp.getEmpDob();
							Date doj = emp.getEmpDoj();
							String newDob = simple.format(dob);
							String newDoj = simple.format(doj);
					%>
					<tr>
						<td><%=slno%></td>
						<td><%=emp.getEmpName()%></td>
						<td><%=emp.getEmpMail()%></td>
						<td><%=emp.getEmpMob()%></td>
						<td><%=newDob%></td>
						<td><%=newDoj%></td>
						<td><%=emp.getUser().getRole().getRoleName()%></td>
						<td><%=mng.getEmpName()%></td>
					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>
		</div>
	</main>
	<footer class="py-4 bg-light mt-auto">
		<div class="container-fluid px-4">
			<div class="d-flex align-items-center justify-content-between small">
				<div class="text-muted">Copyright &copy; LMS 2022 Developed By
					Sanjay. All Rights Reserved</div>
				<div>
					<a href="#">Privacy Policy</a> &middot; <a href="#">Terms &amp;
						Conditions</a>
				</div>
			</div>
		</div>

	</footer>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		></script>
	<script src="resources/js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		></script>
	<script src="resources/js/chart-area-demo.js"></script>
	<script src="resources/js/chart-bar-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		></script>
	<script src="resources/js/datatables-simple-demo.js"></script>
</body>
</html>