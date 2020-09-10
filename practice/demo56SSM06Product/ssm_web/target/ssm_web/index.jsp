<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/4
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>home page</title>
</head>
<body>
<h1>welcome</h1>
<a href="${pageContext.request.contextPath}/product/findAll.do?pageNum=1&pageSize=5">show all products</a><br>
<a href="${pageContext.request.contextPath}/pages/main.jsp">pages/main</a><br>
<a href="${pageContext.request.contextPath}/product/save.do">save.do</a><br>
<a href="${pageContext.request.contextPath}/order/findDetail.do?oId=3">findDetail.do</a> <br>
<%--<jsp:forward page="pages/main.jsp"></jsp:forward>--%>

</body>
</html>
