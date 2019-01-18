<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
<title>jQuery背景切换注册登录模板</title>
<link rel="stylesheet" href="/myServer/css/registercss/style.css" />
</head>
<body>

<div class="register-container">
	<h1>ShareLink</h1>
	
	<div class="connect">
		<p>Link the world. Share to world.</p>
	</div>
	
	<form action="/myServer/user/register.do" method="post" id="registerForm">
		<div>
			<input class="inputClass" type="text" name="id" class="username" placeholder="编号" autocomplete="off"/>
		</div>
		<div>
			<input class="inputClass" type="text" name="username" class="username" placeholder="您的用户名" autocomplete="off"/>
		</div>
		<div>
			<input class="inputClass" type="password" name="password" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input class="inputClass" type="text" name="age" class="phone_number" placeholder="年龄" autocomplete="off" id="number"/>
		</div>
	    <input type="radio" name="permission" value="1"/>总经理
        <input type="radio" name="permission" value="2"/>地区主管
        <input type="radio" checked="checked" name="permission" value="3"/>普通销售
        <input type="radio" name="permission" value="4"/><br/>咨询顾问
		<div>
		
		</div>
		<button id="submit"  onclick="document.getElementById('registerForm')"/>注 册</button>
	</form>
	<a href="/myServer/login.jsp">
		<button type="button" class="register-tis">已经有账号？</button>
	</a>

</div>


<script src="/myServer/js/registerjs/jquery.min.js"></script>
<script src="/myServer/js/registerjs/common.js"></script>
<!--背景图片自动更换-->
<script src="/myServer/js/registerjs/supersized.3.2.7.min.js"></script>
<script src="/myServer/js/registerjs/supersized-init.js"></script>
<!--表单验证-->



<!--  
<script src="/myServer/js/registerjs/jquery.validate.min.js?var1.14.0"></script>
-->
</body>
</html>
<!--
本代码由js代码收集并编辑整理;
尊重他人劳动成果;
转载请保留js代码链接 - www.jsdaima.com
-->