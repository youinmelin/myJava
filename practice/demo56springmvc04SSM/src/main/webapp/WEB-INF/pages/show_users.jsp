<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/26
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1" >
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <%--<meta http-equiv="refresh" content="2;url=http://68.92.144.17/upload/findAllFileMsgWithUser">--%>
    <title>内网优盘</title>
    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="/js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="/js/bootstrap.min.js"></script>
    
    <script>
        (function () {
            $("#formUsername").submit(function () {
                if ($("input").val()==null) {
                    alert("input empty")
                    $("#emptyTips").html("no");
                    return false;
                }else {
                    alert("input not empty")
                    return true;
                }
            })
        })
    </script>
</head>
<body>
<div align="center">
    <br> <br> <br> <br> <br>
    <table >
        <tr>
            <td>
                <h2>请选择：</h2>
            </td>
        </tr>
        <tr>
            <td>
                <form id="formUsername" action="/user/setCookies" method="post" >
                    <c:forEach items="${users}" var="users">
                        <div class="checkbox">
                            <label>
                            <input type="radio" name="uid" value="${users.uid}"> ${users.username} <br>
                            </label>
                        </div>
                    </c:forEach>


                    <input type="submit" value="ok">
                    <span id="emptyTips"></span>
                </form>

            </td>
        </tr>
    </table>
</div>

</body>
</html>
