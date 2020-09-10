<%--
  Created by IntelliJ IDEA.
  User: pc16
  Date: 2020/7/10
  Time: 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${sysLogs}" var="syslog">
    ${syslog.logId}<br>
    ${syslog.visitTimeStr }<br>
    ${syslog.username }<br>
    ${syslog.ip }<br>
    ${syslog.url}<br>
    ${syslog.executionDuring}毫秒<br>
    ${syslog.method}<br>
</c:forEach>
    </body>
</html>
