<!DOCTYPE html>
<html>
<head>
 <meta charset="utf‐8">
 <title>Hello World!</title>
</head>
<body>
遍历数据模型中的map<br>
<table>
    <tr>
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>name</td>
        <td>birthday</td>
    </tr>
        <tr>
            <#--遍历map方法1.1：mapname.keyname-->
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.name}</td>
            <#--<td>${user.birthday}</td>-->
        </tr>
    <tr>
    <#--遍历map方法1.2：mapname["keyname"]-->
        <td>${user["id"]}</td>
        <td>${user["username"]}</td>
        <td>${user["password"]}</td>
        <td>${user["name"]}</td>
    </tr>
    <tr>
    <#--遍历map方法2：-->
        <#list user?keys as k>
            <td>${k}</td>
        </#list>
    </tr>
</table>

</body>
</html>