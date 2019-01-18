<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/myServer/user/updateCustomer.do" method="post">
	顾客名<input type="text" name="custname" /></br>
	销售id<input type="text" name="uid"/></br>
	跟进状态<input type="text" name="status" /></br>
	<input type="submit" value="更新"/></br>
	<input type="reset" value="清空"/>
</form>
</body>
</html>