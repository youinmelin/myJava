<%@ page import="java.sql.*" %>
<%@ page import="com.tel.delTel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no;">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>tel</title>

    <!-- Bootstrap -->
    <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="/js/jquery-1.11.0.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="bootstrap/bootstrap.min.js"></script>
      <script>
          function checkName() {
              let name = $("#name").val();
              let reName = /^.{2,20}$/;
              var flag = reName.test(name);
              if (!flag){
                  $("#name").css("border", "1px solid red");
                  $("#wrongName").html("");
                  $("#name").after("<span id='wrongName'>wrong name</span>");

                  // $.ajax({
                  //     url:"addUserServlet",
                  //     type:"POST",
                  //     data:{"name":name},
                  //     success:function (data) {
                  //           alert(data);
                  //     }
                  // })
                  return false;
              }else {
                  $("#name").css("border", "");
                  $("#wrongName").html("");
              }
          }

          function checkTel() {
              let tel = $("#tel").val();
              let reTel =/^\d{4,20}$/;
              let flag = reTel.test(tel);
              if (!flag) {
                  $("#tel").css("border", "1px solid red");
                  $("#wrongTel").html("");
                  $("#tel").after("<span id='wrongTel'> wrong phone number</span>");
                  return false;
              }else {
                  $("#tel").css("border", "");
                  $("#wrongTel").html("");
              }
          }

          $(function ()  {
              $("#saveForm").submit(function () {
                  if (checkName() && checkTel()) {
                      // $.post("addUserServlet", $(this).serialize(), function(data){
                      //
                      // });
                  }else {
                      return false;
                  }
              });

              $("#name").blur(checkName);

              $("#tel").blur(function(){
                  return checkTel();
              });
          });


      </script>

  </head>
  <body>
  <%
      request.setCharacterEncoding("utf-8");
      Connection conn = null;
      Statement stat = null;
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          conn = DriverManager.getConnection("jdbc:mysql:///test?serverTimezone=UTC","root","aaaaaa");
          stat = conn.createStatement();

      } catch (SQLException e) {
          e.printStackTrace();
      }

      String getName = request.getParameter("name");
      String getTel = request.getParameter("tel");
      String getGroup = request.getParameter("group");
      String isDel = request.getParameter("isDel");
      if (isDel != null) {
          out.write("deleted.");
      }
      if (getName == null || getName== "" || getTel== null || getTel=="") {
          out.write("empty");
      }else {
          out.write(getName);
          out.write(getTel);
          String insertSql = "insert into usertable values( null, '"+ getName +"','"+ getTel +"','"+ getGroup +"')";
          int ret = stat.executeUpdate(insertSql);
          if (ret == 1) {
              out.write("succeed!");
          }else{
              out.write("failed!");
          }
      }


  %>
    <h1>你好，世界！</h1>
    <form action="" method="post" id="saveForm">
        <div class="form-group">
          Name
          <input name="name" type="text" id="name" >
        </div>
        <div class="form-group">
          Tel Number
          <input name="tel" type="text"  id="tel">
        </div>
        <div class="form-group">
            Group
            <input name="group" type="text"   value="default">
        </div>
        <button id="btn" type="submit" class="btn btn-default">Submit</button>
      </form>

  <table class="table table-hover">
      <tr>
          <td>ID</td>
          <td>NAME</td>
          <td>TEL</td>
          <td>GROUP</td>
          <td>DEL</td>
      </tr>
      <%
        String sql = "select * from usertable";
          ResultSet res = stat.executeQuery(sql);
          int i = 1;
          while (res.next()) {
              int id = res.getInt("id");
              String name = res.getString("name");
              String tel = res.getString("tel");
              String ingroup = res.getString("ingroup");
              out.write("<tr>");
              out.write("<td>"+ i + "</td>");
              out.write("<td>"+ name + "</td>");
              out.write("<td>"+ tel + "</td>");
              out.write("<td>"+ ingroup + "</td>");
              out.write("<td> <a href='/delTel?id=" + id + "'>del</a> </td>");
              out.write("</tr>");
              i++;
          }

          stat.close();
          conn.close();

      %>
  </table>
  </body>
</html>