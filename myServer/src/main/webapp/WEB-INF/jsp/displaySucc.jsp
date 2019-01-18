<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>userName</td>
        <td>password</td>
        <td>age</td>
        <td>p_name</td>
    </tr>
    <c:forEach items="${list}" var="user" varStatus="st">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.password}</td>
            <td>${user.age}</td>
            <td>${user.permission.pName}</td>
        </tr>
    </c:forEach>
</table>
<div>
<a href="/myServer/register2.jsp">去注册</a>
<a href="/myServer/update.jsp">更新</a>
<a href="/myServer/delete.jsp">删除</a>
</div>
</body>
</html>