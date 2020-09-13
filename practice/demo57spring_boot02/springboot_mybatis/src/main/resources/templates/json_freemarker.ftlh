<!DOCTYPE html>
<html>
<head>
     <meta charset="utf‐8">
     <title>Hello World!</title>
</head>
<body>
Hello ${name!''}!
<#assign user>
    {"name": "lin","age":30,"gender":"female"}
</#assign>
<#assign json=user?eval/>


name:${json["name"]}
age:${json["age"]}
gender:${json["gender"]}


</body>
</html>