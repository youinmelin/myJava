<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/21
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>annotations</title>
</head>
<body>

    <h3>annotations</h3>
    <a href="anno/testRequestParam?username=zheng">1.@RequestParam</a><br>

    2.@RequestBody<br>
    <form action="anno/testRequestBody" method="post">
        name:<input type="text" name="username"/><br>
        age:<input type="text" name="age"/><br>
        <input type="submit" value="submit"/>
    </form><br>
    <a href="anno/testPathVariable/10">3.@PathVariable</a><br>
    <a href="anno/testCookieValue">4.@CookieValue</a><br>

    5.@ModelAttribute<br>
    <form action="anno/testModelAttribute" method="post">
        name:<input type="text" name="name"/><br>
        age:<input type="text" name="age"/><br>
        <input type="submit" value="submit"/>
    </form><br>
    <a href="anno/testSetSessionAttributes">6.@SessionAttributes set session</a><br>
    <a href="anno/testGetSessionAttributes">6.@SessionAttributes get session</a><br>
    <a href="anno/testDelSessionAttributes">6.@SessionAttributes delete session</a><br>
</body>
</html>
