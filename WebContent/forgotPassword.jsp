<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
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

	<!-- Modernizr JS -->
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
						<li ><a href="signUp.jsp"><h4>signUp</h4></a></li>&nbsp;&nbsp;
						<li ><a href="signIn.jsp"><h4>signIn</h4></a></li>&nbsp;&nbsp;
						<li class="active"><a href="forgotPassword.jsp"><h4>forgotPassword</h4></a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					

					<!-- Start Sign In Form -->
					<form action="MartUserServlet" id="loginForm3" class="fh5co-form animate-box" data-animate-effect="fadeInLeft">
						<h2>Forgot Password</h2>
						<input type="hidden" id="hidden1" name="actionName" value="getCode">
						<input type="hidden" id="hidden2" name="actionName" value="sendMessage">
						<div class="form-group">
							<label for="num-phone" class="sr-only">Num-phone</label>
							<input type="text" class="form-control" id="phone" name="uphone" placeholder="Num-phone(手机)" autocomplete="off">  
						</div>
						<div class="form-group">
							<label for="message" class="sr-only">Message</label>
							<input type="text" class="form-control" id="message" name="umessage" placeholder="Message(短信验证)" autocomplete="off">
						</div>
						<div class="form-group">
							<p><a href="signIn.jsp">Sign In</a>&nbsp; or &nbsp;<a href="signUp.jsp">Sign Up</a></p>
						</div>
						<div class="form-group">
							<input type="button" id="but1" value="get code" class="btn btn-primary"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="but2" onclick="open" value="Message sends" class="btn btn-primary">
						</div>
						<div class="form-group">
							<span style="font-size:16px;color:red" id="msg" ></span>
						</div>
						
						
					</form>
					<!-- END Sign In Form -->


				</div>
			</div>
			<div class="row" style="padding-top: 60px; clear: both;">
				<div class="col-md-12 text-center"><p><small>&copy; Want to learn programming? Welcome to shsxt! <a href="https://www.shsxt.com/" target="_blank" title="上海尚学堂">SHSXT</a></small></p></div>
			</div>
		</div>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		    <div class="modal-dialog" role="document">
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">×</span></button>
		          <h4 class="modal-title" id="myModalLabel">请修改用户密码</h4>
		        </div>
		        <div class="modal-body"> 
		          <div class="form-group">
		            <input type="hidden" name="typeId"> 
		            <input type="password" name="upwd1" class="form-control" id="upwd1" placeholder="请输入你的新密码">         	
		          </div>
		          <div class="form-group">
		            <input type="hidden" name="typeId"> 
		            <input type="password" name="upwd2" class="form-control" id="upwd2" placeholder="请再次输入你的密码">         	
		          </div>      
		        </div>
		        <div class="modal-footer">
		        	<span style="font-size: 16px;color:red" id="msg2"></span>
		          <button type="button" id="btn_submit1" class="btn btn-default" data-dismiss="modal">
		          <span class="glyphicon glyphicon-remove"></span>关闭修改</button>
		          <button type="button" id="btn_submit" class="btn btn-primary">
		          <span class="glyphicon glyphicon-floppy-disk"></span>提交修改</button>
		        </div>
		      </div>
		    </div>
		  </div>
		<!-- 模态框（Modal）结束 -->
		

	<!-- jQuery -->
	<script src="OneStatic/statics/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="OneStatic/statics/js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="OneStatic/statics/js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="OneStatic/statics/js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="OneStatic/statics/js/main.js"></script>
	<script src="OneStatic/statics/js/utils.js"></script>
	<script src="OneStatic/statics/js/signIn.js"></script>
	
	</body>
	<script src="MyStatic/js/MartQiu.js"></script>
</html>
