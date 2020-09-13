<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/25
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width*0.8, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SHOW MESSAGE</title>
    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">


    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="/js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<h2>SHOW MESSAGE LIST</h2>
<a href="../../index.jsp">home page</a><br>

<c:if test="${empty cookie.username.value}">
    <%response.sendRedirect("/user/findAll"); %>
    no unmae<br>
</c:if>
<c:if test="${not empty cookie.username.value}">
    username
    <%
    Cookie[] cookies = request.getCookies();
    for (Cookie c :
            cookies) {
        out.write(c.getName()+":");
        out.write(c.getValue()+"<br>");
    }
%>:${cookie.username.value}<br>
</c:if>


<table class="table table-condensed" class="table table-hover">
    <thead >
    <tr class="info">
        <td>username</td>
        <td>message</td>
        <td>files</td>
        <td>filesize</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${fileMsgList}" var="msg">
        <tr >
            <td>${msg.uId}</td>
            <td>${msg.message}</td>
            <td>
                <c:if test="${msg.filenameFull==''}">
                    无附件
                </c:if>
                <c:if test="${msg.filenameFull!=''}">
                    <a href="/upload/DownloadFile?filename=${msg.filenameFull}" >${msg.filenameFull}</a>
                </c:if>
            </td>
            <td>
                <c:if test="${msg.filenameFull==''}">
                    -
                </c:if>
                <c:if test="${msg.filenameFull!=''}">
                    <c:if test="${msg.filesize>0}">
                        ${msg.filesize}M
                    </c:if>
                    <c:if test="${msg.filesize==0}">
                        <1M
                    </c:if>
                </c:if>
            </td>
        </tr>
</c:forEach>
    </tbody>
</table>

</body>
</html>
