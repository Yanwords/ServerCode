<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
请输入删除用户的编号<br/>
<form action="/myServer/user/delete.do" method="post">
编号<input type="text" name="id"/></br>
	<input type="submit" value="删除"/></br>
	<input type="reset" value="清空"/>
</form>

</body>
</html>