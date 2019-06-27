<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<!--[if lt IE 7]>      <html class="no-OneStatic/statics/js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-OneStatic/statics/js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-OneStatic/statics/js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-OneStatic/statics/js"> <!--<![endif]-->

	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Minimal and Clean Sign up / Login and Forgot Form by FreeHTML5.co</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	

  

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
	
	<link rel="stylesheet" href="OneStatic/statics/css/bootstrap.min.css">
	<link rel="stylesheet" href="OneStatic/statics/css/animate.css">
	<link rel="stylesheet" href="OneStatic/statics/css/style.css">

	<!-- Modernizr js -->
	<script src="OneStatic/statics/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="OneStatic/statics/js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body class="style-2">

		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<ul class="menu">
						<li class="active"><a href="signUp.jsp"><h4>signUp</h4></a></li>&nbsp;&nbsp;
						<li ><a href="signIn.jsp"><h4>signIn</h4></a></li>&nbsp;&nbsp;
						<li ><a href="forgotPassword.jsp"><h4>forgotPassword</h4></a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					

					<!-- Start Sign In Form -->
					<form action="MartUserServlet" class="fh5co-form animate-box" data-animate-effect="fadeInLeft" id="loginform">
						<h2>Sign Up</h2>
						
						<div class="form-group">
							<label for="name" class="sr-only">Name</label>
							<input type="text" class="form-control" name="uname" id="name" placeholder="Name(用户名)" autocomplete="off" ${resuletInfo.result.userName }>
						</div>
						<div class="form-group">
							<label for="email" class="sr-only">Email</label>
							<input type="email" class="form-control" name="email" id="email" placeholder="Email(邮箱)" autocomplete="off" ${resuletInfo.result.userMail }>
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">Password</label>
							<input type="password" class="form-control" name="upwd" id="password" placeholder="Password(密码)" autocomplete="off" value="${resuletInfo.result.userPwd }">
						</div>
						<div class="form-group">
							<label for="re-password" class="sr-only">Re-type Password</label>
							<input type="password" class="form-control" id="re-password" placeholder="Re-type Password(确认密码)" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="num-phone" class="sr-only">Num-phone</label>
							<input type="text" class="form-control" id="phone" name="uphone" placeholder="Num-phone(手机)" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="remember"><input type="checkbox" id="remember"> Remember Me</label>
						</div>
						<div class="form-group">
							<p>Already registered? <a href="signIn.jsp">Sign In</a></p>
						</div>
						<div class="form-group">
							<input id="but" type="button" value="Sign Up" class="btn btn-primary"><span style="font-size: 16px;color:red" id="msg"></span>
						</div>
							<input type="hidden" name="actionName" value="userSignUp"/>	
						
					</form>
					<!-- END Sign In Form -->


				</div>
			</div>
			<div class="row" style="padding-top: 60px; clear: both;">
				<div class="col-md-12 text-center"><p><small>&copy; Want to learn programming? Welcome to shsxt! <a href="https://www.shsxt.com/" target="_blank" title="上海尚学堂">SHSXT</a></small></p></div>
			</div>
		</div>
	
	<!-- jQuery -->
	<script src="OneStatic/statics/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="OneStatic/statics/js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="OneStatic/statics/js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="OneStatic/statics/js/jquery.waypoints.min.js"></script>
	<!-- Main OneStatic/statics/js -->
	<script src="OneStatic/statics/js/main.js"></script>
	<script src="OneStatic/statics/js/utils.js"></script>
	<!-- <script src="OneStatic/statics/js/signIn.js"></script> -->
	
	
	</body>
	<script src="MyStatic/js/MartQiu.js"></script>
</html>