<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/myServer/user/register.do" method="post">
	编号<input type="text" name="id"/></br>
	用户名<input type="text" name="username" /></br>
	密码<input type="password" name="password"/></br>
	年龄<input type="text" name="age" /></br>
            总经理
	<input type="radio" name="permission" value="1"/>
	地区主管
	<input type="radio" name="permission" value="2"/>
	普通销售
	<input type="radio" checked="checked" name="permission" value="3"/>
	网络咨询顾问
	<input type="radio" name="permission" value="4"/><br/>
<!--  	<select name="pid">
		<option value="1">总经理</option>
		<option value="2">地区主管</option>
		<option value="3">销售</option>
		<option value="4">网络咨询</option>
	</select></br>  -->
	<input type="submit" value="注册"/></br>
	<input type="reset" value="清空"/>
</form>
</body>
</html>