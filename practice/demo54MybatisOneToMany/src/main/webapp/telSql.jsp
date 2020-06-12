<%@ page import="redis.clients.jedis.Jedis" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <!-- <meta charset="utf-8"> -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>telephone number</title>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script>
      $(function() {
        $("#name").blur(checkName);
      });

      function checkName() {
          var name = $(this).val();
          // resopnse data: {"nameExsit":true,"msg":"user existed"}
          $.post("findNameServlet",{name:name},function(data) {
              // judge nameExist
              var span = $("#nameExist");
              if(name.length < 2 || name.length > 10) {
                  span.css("color","red");
                  span.html("too short or too long.");
                  return false;
              }else if(data.nameExist){
                  span.css("color","red");
                  span.html(data.msg);
                  return false;
              }else if (!data.nameExist){
                  span.css("color","green");
                  span.html(data.msg);
                  return true;
              }
          },"json");

      }

    </script>

   </head>

  <body>
    <h1 class="text-center">PHONE BOOK</h1>
    
  </table>
  <form action="" method="POST" class="form-inline" >
  Name:<input type="text" name="name" id="name">
  <span id="nameExist"></span>
  Tel:<input type="text" name="tel" id="tel">
  Group:<input type="text" name="group" id="group" value="default">
  <input id="submit" type="submit" value="save">
  </form>
<br>
    <table class="table table-hover">
    <tr  class="success">
      <!-- <th>ID</th> -->
      <th>ID</th>
      <th>NAME</th>
      <th>TEL</th>
      <th>GROUP</th>
      <th>DEL</th>
    </tr>
    
 <%
    response.setContentType("text/html;charset=utf-8");
    response.setHeader("content-Type","text/html;charset=utf-8");
    request.setCharacterEncoding("UTF-8");
    String getName = request.getParameter("name") ;
    String getTel = request.getParameter("tel") ;
    String getGroup = request.getParameter("group") ;
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql:///test?user=root&password=aaaaaa&useUnicode=true&setCharacterEncoding=utf-8");
    Statement stmt = conn.createStatement();

 if (getName == "" || getTel == "" || getName == null || getTel == null ) {
   out.write("empty");
 }else {

   out.write("<br>");
  
  String sql = "insert into usertable values(null,'"+getName+"',0,'"+getGroup+"','"+getTel+"')";
  System.out.println(sql);
  
  
  int ret = stmt.executeUpdate(sql);
  System.out.println("changed line:" + ret);
      
  //stmt.close();
  //conn.close();
 }
   String sqlSel = "select * from usertable";
  ResultSet sets = stmt.executeQuery(sqlSel);
  System.out.println("returned line:" + sets.toString());
  int i = 1;
 while(sets.next()) {
    out.write("<tr>");
     out.write("<th>"+ i++ +"</th>");
     out.write("<th>"+ sets.getString("name") +"</th>");
     out.write("<th>"+ sets.getString("tel") +"</th>");
     out.write("<th>"+ sets.getString("ingroup") +"</th>");
     out.write("<th>"+ sets.getString("tel") +"</th>");
     out.write("<tr>");
 }
 
 %> 
</table>

    

  </body>
</html>