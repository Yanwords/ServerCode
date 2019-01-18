<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/myServer/user/login.do" method="post">
	用户名<br/>
	<input type="text" name="username" /><br/>
	密码<br/>
	<input type="password" name="password"/><br/>
	总经理
	<input type="radio" name="permission" value="1"/>
	地区主管
	<input type="radio" name="permission" value="2"/>
	普通销售
	<input type="radio" checked="checked" name="permission" value="3"/>
	网络咨询顾问
	<input type="radio" name="permission" value="4"/><br/>
	<input type="submit" value="登陆"/>
	<input type="reset" value="清空"/>
</form>
<a href="/myServer/register2.jsp">去注册</a>
<a href="/myServer/update.jsp">更新</a>
<a href="/myServer/delete.jsp">删除</a>
</body>
</html>