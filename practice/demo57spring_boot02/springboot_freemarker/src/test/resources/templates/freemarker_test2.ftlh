<!DOCTYPE html>
<html>
<head>
 <meta charset="utf‐8">
 <title>Hello World!</title>
</head>
<body>
遍历数据模型中的list<br>
list长度：${users?size}
<table>
    <tr>
        <td>index</td>
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>name</td>
        <td>birthday</td>
    </tr>
    <#list users as user>
        <tr <#if user.id % 2 == 0>style="background: cornflowerblue"</#if>>
            <td>${user_index + 1}</td>
            <td >${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.name}</td>
            <td>${(user.birthday?date)!""}</td>
        </tr>
    </#list>
</table>

assign定义变量
<#assign text="{'bank':'ICBC', 'account':1234567890}"/>
<#assign text='{"res":"0","msg":"OK","userlist":[{"id":"3","name":"cc","sex":"女","age":"20"}]}'/>
<#assign data=text?eval/>
${data.msg}<br>
<#list data.userlist as user>
    <#list user?keys as k>
        ${k}: ${(user[k])}<br>
    </#list>

</#list>
<#--${data.bank} ${data.account?c}-->

<#--<#assign text>-->

<#--{"res":"0","msg":"OK","userlist":[{"id":"3","name":"cc","sex":"女","age":"20"}]}-->

<#--</#assign>-->
<#--text为服务器后台传递的json数据，在freemarker页面进行解析-->

<#--<#assign data=text?eval/>-->
<#--然后json数据就被解析成json格式了，可以按key进行取值-->

<#--<#list data.userlist as item>-->

<#--id:${item.id}, name:${item.name},sex:${item.sex}-->

<#--</#list>-->

</body>
</html>