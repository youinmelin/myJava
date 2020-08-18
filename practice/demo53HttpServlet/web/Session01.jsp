<%@ page import="java.util.Date" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20-5-28
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notice Last View Date</title>
</head>
<body>
    <%
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            out.write(c.getValue());
            out.write("<br>");
        }
//        if (!Objects.equals(lastTime, "no")) {
        if (cookies.length == 0) {
            out.write("This is the first view.");
        }else {
            String lastTime = cookies[0].getValue();
            out.write("lastTime:" + lastTime);
        }
        Date date = new Date();
        Cookie newC = new Cookie("lastTime", date.toString());

        out.write("current time: " + date.toString());
    %>
</body>
</html>
