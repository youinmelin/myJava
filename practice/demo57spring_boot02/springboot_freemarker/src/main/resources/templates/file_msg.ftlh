<!DOCTYPE html>
<html>
<head>
     <meta charset="utf‐8">
     <title>file system</title>
</head>
<body>
<h2>file system</h2>

 ${welcome}<br>
<table>
    <tr>
        <td>index</td>
        <td>message</td>
        <td>filename</td>
        <td>filesize</td>
        <td>datetime</td>
    </tr>
    <#list fileMsg as fm>
    <tr>
        <td>${fm_index}</td>
        <td>${fm.message}</td>
        <td>${fm.filename}</td>
        <td><#if (fm.filesize < 1)> <1 <#else> ${fm.filesize}</#if></td>
        <td>${fm.datetime?date}</td>
    </tr>

    </#list>

</table>
</body>
</html>