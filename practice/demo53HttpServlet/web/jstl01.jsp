<%@ page import="com.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show Users</title>
</head>
<body>
<%
    List<User> users = new ArrayList<>();
    users.add(new User("Nasa", "M", new Date(111,11,4)));
    users.add(new User("Lin", "M", new Date(80,0,2)));
    users.add(new User("Nancy", "F", new Date(82,5,26)));
    request.setAttribute("users", users);

%>
    <c:forEach items="${users}" var="user">
        ${user.name},${user.gender},${user.birth}<br>
    </c:forEach>
<table border="1" width="200" align="center">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>gender</th>
        <th>birthday</th>
    </tr>
        <c:forEach items="${users}" var="user" varStatus="s">
            <tr>
            <th>${s.index+1}</th>
            <th>${user.name}</th>
            <th>${user.gender}</th>
            <th>${user.birth}</th>
                </tr>
        </c:forEach>
</table>

</body>
</html>
