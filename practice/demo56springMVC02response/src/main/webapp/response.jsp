<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/21
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.12.2.js"></script>
</head>
<body>
    <h2>response data</h2>
    <a href="user/testString">testString</a><br>
    <a href="user/testModelAndView">testModelAndView</a><br>

    <input type="button" value="click" id="btn1">
    <script>
        $(function(){
            $("#btn1").click(function(){
                // alert("hello btn");
                // 发送ajax请求
                $.ajax({
                    // 编写json格式，设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe"}',
                    dataType:"json",
                    type:"post",
                    success:function(data){
                        // data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });

            });
        });
        // function ajaxFun() {
        //     $.post("user/testAjax",
        //         {"username":"lin","password":"123","age":20},
        //     function (data) {
        //         alert(data); }
        //         ,"json");
        // }
    </script>
</body>
</html>
