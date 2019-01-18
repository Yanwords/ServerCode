<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>login</title>
<link rel="stylesheet" type="text/css" href="/myServer/css/logincss/normalize.css" />
<link rel="stylesheet" type="text/css" href="/myServer/css/logincss/demo.css" />
<!--component-->
<link rel="stylesheet" type="text/css" href="/myServer/css/logincss/component.css" />
<!--[if IE]>
<script src="/myServer/js/loginjs/html5.js"></script>
<![endif]-->
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>欢迎</h3>
						<form action="/myServer/user/login.do" method="post" id="loginForm">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="username" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账号">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>

								<input name="permission" value="1" type="radio">总经理
								<input name="permission" value="2" type="radio">地区主管
								<input name="permission" value="3" type="radio" checked="checked">普通销售
								<input name="permission" value="4" type="radio">咨询顾问
								<div class="mb2"><a class="act-but submit" onclick="document.getElementById('loginForm').submit()" style="color: #FFFFFF">登录</a></div>
						</form>
						<div class="mb2"><a class="act-but submit" href="/myServer/register.jsp" style="color: #FFFFFF">注册</a></div>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="/myServer/js/loginjs/TweenLite.min.js"></script>
		<script src="/myServer/js/loginjs/EasePack.min.js"></script>
		<script src="/myServer/js/loginjs/rAF.js"></script>
		<script src="/myServer/js/loginjs/demo-1.js"></script>
		<div style="text-align:center;">
<p>test<a href="http://www.mycodes.net/" target="_blank">test</a></p>
</div>
	</body>
</html>