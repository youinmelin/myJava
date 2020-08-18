<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/21
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body><br>
<a href="response.jsp">response data</a>
<br>
Use commons-upload component:<br>
<form action="user/testUpload1" id="upload" method="post" enctype="multipart/form-data">
    file upload<input type="file" name="upload">
    <input type="submit" value="submit">
</form>

    Use SpringMVC upload:<br>
    <form action="user/testUpload2" id="uploadMVC" method="post" enctype="multipart/form-data">
        file upload<input type="file" name="upload">
        <input type="submit" value="submit">

</form>

</body>

</html>
