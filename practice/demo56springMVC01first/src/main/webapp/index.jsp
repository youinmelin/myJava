<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/20
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>入门程序</h3>
    <a href="user/hello">link</a>
    <hr>
    <a href="user/testRM?username=user" >@RequestMapping</a><br>
    <a href="anno.jsp">annotations</a>


    <h3>parameter bind</h3>
    <form action="param/saveAccount" method="post">
        <p>散装数据</p>
        username:<input type="text" name="username"/><br>
        password:<input type="text" name="password"/><br>
        money:<input type="text" name="money"/><br>
        <p>数据封装到JavaBean中</p>
        name:<input type="text" name="user.name"/><br>
        age:<input type="text" name="user.age"/><br>
        <p>数据封装到List中</p>
        name:<input type="text" name="usersList[0].name"/><br>
        age:<input type="text" name="usersList[0].age"/><br>
        <p>数据封装到Map中</p>
        name:<input type="text" name="usersMap['one'].name"/><br>
        age:<input type="text" name="usersMap['one'].age"/><br>
        <input type="submit" value="submit"/>
    </form>

    <br>自定义类型转换器<br>
    <form action="/param/saveUser" method="post">
        name:<input type="text" name="name"/><br>
        age:<input type="text" name="age"/><br>
        birthday:<input type="text" name="date"/><br>
        <input type="submit" value="submit"/>

    </form>
</body>
</html>
