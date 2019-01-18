<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/myServer/user/displayCustomer.do" method="post">
	用户id<br/>
	<input type="text" name="userId" /><br/>
	<input type="submit" value="登陆"/>
	<input type="reset" value="清空"/>
</form>
</body>
</html>