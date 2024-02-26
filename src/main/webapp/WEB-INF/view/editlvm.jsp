<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.virtusa.lms.entity.LeaveMaster"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>ELMS :: EditEmployee</title>
        <link href="resources/css/styles.css" rel="stylesheet" />
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Edit Leave</h3></div>
                                    <div class="card-body">
                                    <% 
                                    	LeaveMaster lvm=(LeaveMaster)request.getAttribute("lvm");
                                    %>
                                        <form action="updatelvm" method="post">
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="lvmid" required="required" name="lvmId" placeholder="Full Name" type="number" readonly="readonly" value="<%=lvm.getLvmId()%>" />
                                                        <label for="lvmid">Leave Id</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="lvmAbbr" required="required" name="lvmAbbr" type="text" placeholder="mobnum" value="<%=lvm.getLvmAbbr() %>" />
                                                <label for="lvmAbbr">Leave Abbrivation</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                       <input class="form-control" id="lvmName" type="text" required="required" name="lvmName" placeholder="leave name" value="<%=lvm.getLvmName()%>" />
                                               		 <label for="lvmName">Leave Name</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="lvmAbbr" required="required" name="maxBalance" type="number"  min="0.01" step="0.01" placeholder="maxBalance" value="<%=lvm.getMaxBalance() %>" />
                                               			 <label for="lvmAbbr">Maximum Balance</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid">
                                                    <input type="submit" value="Update">
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
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; LMS 2022 Developed By Sanjay. All Rights Reserved</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
    </body>
</html>
