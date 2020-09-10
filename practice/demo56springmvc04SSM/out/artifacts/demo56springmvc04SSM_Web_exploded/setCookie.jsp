<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/26
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SET NAME</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String uid = request.getParameter("uid");
    Cookie cookie = new Cookie("uid", uid);
    cookie.setMaxAge(3600*30);
    cookie.setPath("/");
    response.addCookie(cookie);
//    out.write("wellcom: " + username);
    response.sendRedirect("/upload/findAllFileMsgWithUser");
%>
<a href="index.jsp">index page</a>
</body>
</html>
