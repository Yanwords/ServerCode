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
        <td>cName</td>
        <td>uName</td>
        <td>cStatus</td>
    </tr>
    <c:forEach items="${list}" var="customer" varStatus="st">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.customerName}</td>
            <td>${customer.userName}</td>
            <td>${customer.customerStatus}</td>
        </tr>
    </c:forEach>
    <div>
    <a href="/myServer/registerCust.jsp">去注册</a>
<a href="/myServer/updateCust.jsp">更新</a>
<a href="/myServer/deleteCust.jsp">删除</a>
    </div>
</table>
</body>
</html>