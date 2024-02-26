<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html lang="">
<head>
<title>ELMS :: Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="resources/css/mystyles.css" rel="stylesheet" />
<link href="resources/css/bootstrap.min.css" rel='stylesheet'
	type='text/css' />
<link href="resources/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="resources/css/morris.css" type="text/css" />
<link href="resources/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/jquery-ui.css">
<link
	href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400'
	rel='stylesheet' type='text/css' />
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<div class="main-wthree">
		<div class="container">
			<div class="sin-w3-agile">
				<h2>Leave Management System</h2>
				<div>
					<p class="failures">${error}</p>
				</div>
				<form action="home" method="post">
					<div class="username">
						<span class="username">User Name:</span> <input type="text"
							id="email" name="username" class="name" placeholder=""
							required="required">
						<div class="clearfix"></div>
					</div>
					<div class="password-agileits">
						<span class="username">Password:</span> <input type="password"
							id="password" name="password" class="password" placeholder=""
							required="required">
						<div class="clearfix"></div>
					</div>
					<div class="rem-for-agile">
						<input type="checkbox" name="remember" class="remember">Remember
						me<br> <a href="#">Forgot Password</a><br>
					</div>
					<div class="login-w3">
						<input type="submit" class="login" value="Sign In">
					</div>
					<div class="clearfix"></div>
				</form>
				<div class="back">
					<a href="register">Register</a>
				</div>
				<div class="footer">
					<p>Copyright &copy; LMS 2022 Developed by Sanjay . All Rights
						Reserved</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
