<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/myServer/user/registerCustomer.do" method="post">
	编号<input type="text" name="id"/></br>
	顾客名<input type="text" name="custname" /></br>
	销售id<input type="text" name="uid"/></br>
	状态<input type="text" name="status" /></br>
	<input type="submit" value="注册"/></br>
	<input type="reset" value="清空"/>
</form>
</body>
</html>