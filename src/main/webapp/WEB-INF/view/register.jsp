<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html lang="">
<head>
<title>ELMS :: Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script lang="javascript" type="text/javascript">
	function validate(input){
		if(input.value!=document.getElementById('password').value){
			input.setCustomValidity('Password did not match');
		}else{
			input.setCustomValidity('');
		}
	}
</script>
<!-- CSS -->
<link href="resources/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="resources/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="resources/css/morris.css" type="text/css" />
<link href="resources/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/jquery-ui.css">
<link href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css' />
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link rel="shortcut icon" href="resources/img/favicon.png">
<link href="resources/css/mystyles.css" rel="stylesheet" />
</head>
<body>
	<div class="main-wthree">
		<div class="container">
			<div class="sin-w3-agile">
				<h2>Leave Management System</h2>
				<h2>Sign Up</h2>
				<p class="failures">${message}</p>
				<form action="registerprocess" method="post">
					<div class="username">
						<span class="username">Full Name:</span> <input type="text"
							name="empName" class="name" placeholder="Full Name" required>
						<div class="clearfix"></div>
					</div>
					<div class="username">
						<span class="username">Email:</span> <input type="email"
							name="empMail" class="name" placeholder="E-mail" required>
						<div class="clearfix"></div>
					</div>
					<div class="username">
						<span class="username">Mobile Number:</span> <input type="text"
							name="empMob" class="name" placeholder="Mobile Number" required>
						<div class="clearfix"></div>
					</div>
					<div class="username">
						<span class="username">Date Of Birth:</span> <input type="date"
							name="empDob" class="name" placeholder="DOB" required>
						<div class="clearfix"></div>
					</div>
					
					<div class="username">
						<span class="username">Date Of Joining:</span> <input type="date"
							name="empDoj" class="name" placeholder="DOJ" required>
						<div class="clearfix"></div>
					</div>
					<div class="username">
						<span class="username">User Name:</span> <input type="text"
							name="username" class="name" placeholder="User Name" required >
						<div class="clearfix"></div>
					</div>
					<div class="password-agileits">
						<span class="username">Password:</span> <input id="password"
							type="password" name="password" class="password"
							placeholder="Password"  pattern=".{8,}" required title="password must contain 8 characters" >
						<div class="clearfix"></div>
					</div>
					<div class="password-agileits">
						<span class="username">Confirm Password:</span> <input
							id="confirmpassword" type="password" name="confirmpassword"
							class="password" placeholder="Confirm Password"
							oninput="validate(this)"  pattern=".{8,}" required >
						<div class="clearfix"></div>
					</div>
					<div class="username">
						<span class="username">Gender:</span>
						<div style="width: 71%; padding: 10px;">
							<label style="padding-left: 25px; padding-right: 10px;">
								<input type="radio" name="gender" value="M"
								checked="checked">Male
							</label> <label style="padding-left: 25px; padding-right: 10px;">
								<input type="radio" name="gender" value="F">Female
							</label> 
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="username">
						<span class="username">Role:</span>
						<div style="width: 71%; padding: 10px;">
							<label style="padding-left: 25px; padding-right: 10px;">
								<input type="radio" name="roleName" value="EMPLOYEE"
								checked="checked">EMPLOYEE
							</label> <label style="padding-left: 25px; padding-right: 10px;">
								<input type="radio" name="roleName" value="MANAGER">MANAGER
							</label> 
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="login-w3">
						<input type="submit" class="login" value="Sign Up">
					</div>
					<div class="clearfix"></div>
				</form>
				<div class="back">
					<a href="login">LOGIN</a>
				</div>
				<div class="footer">
					<p>Copyright &copy;LMS 2022 Developed by Sanjay. All Rights Reserved</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

