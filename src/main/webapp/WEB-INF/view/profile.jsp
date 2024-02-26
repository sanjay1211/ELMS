<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.virtusa.lms.entity.Employee"%>
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
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">My Profile</h3></div>
                                    <div class="card-body">
                                    <% 
                                    	Employee emp=(Employee)request.getAttribute("emp");
                                    %>
                                        <form action="updateProfile" method="post">
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="empid" required="required" placeholder="Full Name" name="empId" type="number" readonly="readonly" value="<%=emp.getEmpId() %>"/>
                                                        <label for="empid">Employee Id</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="username" required="required" name="username" type="text" placeholder="username" readonly="readonly" value="<%=emp.getUser().getUsername()%>" />
                                                <label for="username">User Name</label>
                                                        
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="empname" name="empName" required="required" placeholder="Full Name" type="text" value="<%=emp.getEmpName() %>" />
                                                        <label for="empname">Full Name</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="inputmob" required="required" name="empMob" type="text" placeholder="mobnum" value="<%=emp.getEmpMob() %>" />
                                                <label for="inputmob">Mobile Num</label>
                                                        
                                                    </div>
                                                </div>
                                            </div>
                                             <div class="form-floating mb-3">
                                                <input class="form-control" id="empmail" type="email" name="empMail" required="required" placeholder="Email" value="<%=emp.getEmpMail()%>" />
                                                <label for="empmail">Employee Mail</label>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="empdob" required="required" name="empDob" type="date" value="<%=emp.getEmpDob()%>" />
                                                        <label for="empdob">DOB</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="empdoj" type="date" required="required" name="empDoj" value="<%=emp.getEmpDoj()%>" />
                                                        <label for="empdoj">DOJ</label>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            <div class="row mb-3">
                                            <div class="col-md-6">
                                                <div class="form-floating mb-3 mb-md-0">
                                                <% if(emp.getGender().equals("M")){ %>
                                                        <input type="radio" name="gender" value="M"
                                                            checked="checked">Male
                                                            <br> <input type="radio" name="gender" value="F"
                                                            >Female
                                                            <%}else{%>
                                                            <input type="radio" name="gender" value="M"
                                                            >Male
                                                            <br> <input type="radio" name="gender" value="F" checked="checked"
                                                            >Female
                                                            <%} %>
                                                        </div>
                                                    </div>
                                                     <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                     <% if(emp.getUser().getRole().getRoleId()==1){ %>
                                                        <input type="radio" name="roleName" checked="checked" value="ADMIN"
                                                            >Admin
                                                           <%}else if(emp.getUser().getRole().getRoleId()==2){%>
                                                             <input type="radio" name="roleName" value="MANAGER" checked="checked"
                                                           >Manager
                                                           <%} else{%>
                                                           <input type="radio" name="roleName" value="EMPLOYEE" checked="checked"
                                                           >Employee
                                                             <%} %>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid">
                                                    <input type="submit" value="Update Profile">
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

