<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.virtusa.lms.entity.Leave"%>
<%@page import="com.virtusa.lms.entity.Employee"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>ELMS :: ViewLeaveRequest</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="resources/css/styles.css" rel="stylesheet" />
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
</head>
<body>
	<main>
		<%@include file="adminpage.jsp"%>
		<div class="card mb-4">
			<div class="card-header">
				<em class="fas fa-table me-1"></em>Leave Request Details
			</div>
		</div>
		<div class="card-body">
			<table id="datatablesSimple">
			<caption></caption>
				<thead>

					<tr>
						<th id="slno">SL No</th>
						<th id="empName">Applied By</th>
						<th id="leaveType">Leave Type</th>
						<th id="reason">Reason</th>
						<th id="fromdate">From Date</th>
						<th id="todate">To Date</th>
						<th id="noOfDays">No of Days</th>
						<th id="mngName">Assigned To</th>
						<th id="status">Status</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th id="slno">SL No</th>
						<th id="empName">Applied By</th>
						<th id="leaveType">Leave Type</th>
						<th id="reason">Reason</th>
						<th id="fromdate">From Date</th>
						<th id="todate">To Date</th>
						<th id="noOfDays">No of Days</th>
						<th id="mngName">Assigned To</th>
						<th id="status">Status</th>
					</tr>
				</tfoot>
				<tbody>
					<%
				int slno = 0;
				SimpleDateFormat simple = new SimpleDateFormat("dd-MMM-yyy");
				List<Leave> leaves = (List<Leave>)request.getAttribute("leaveLst");
				List<Employee> employees = (List<Employee>) request.getAttribute("empyList");
				for (Leave lve : leaves) {
						Employee mng=employees.stream().filter(id -> id.getEmpId()==lve.getEmployee().getManagerId()).findAny().orElse(null);
					
						slno++;
						Date frm = lve.getFromDate();
						Date to = lve.getToDate();
						String frmDate = simple.format(frm);
						String toDate = simple.format(to);
						
				%>
					<tr>
						<td><%=slno%></td>
						<td><%=lve.getEmployee().getEmpName()%></td>
						<td><%=lve.getLeaveMaster().getLvmName()%></td>
						<td><%=lve.getReason()%></td>
						<td><%=frmDate%></td>
						<td><%=toDate%></td>
						<td><%=lve.getNoOfDays()%></td>
						<% if(mng!=null){%>
						<td><%=mng.getEmpName()%></td>
						<%}else{ %>
						<td></td>
						<%} %>
						<td><%=lve.getStatus()%></td>
					</tr>
					<%
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
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
	<script src="resources/js/chart-area-demo.js"></script>
	<script src="resources/js/chart-bar-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"></script>
	<script src="resources/js/datatables-simple-demo.js"></script>
</body>
</html>