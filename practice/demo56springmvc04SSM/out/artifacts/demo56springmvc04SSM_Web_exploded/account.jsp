<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/26
  Time: 6:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>SSM project</h1>
<a href="/account/findAll">findAllAccount</a><br>

save account:<br>
<form action="/account/saveAccount" method="post">
    name:<input type="text" name="name"><br>
    money:<input type="text" name="money"><br>
    <input type="submit" value="submit">
</form>
</body>
</html>
