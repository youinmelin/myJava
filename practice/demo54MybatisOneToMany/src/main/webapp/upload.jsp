<%@ page import="redis.clients.jedis.Jedis" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
<%
    String UploadPath = "upload";
    int MemoryThreshold = 1024*1024*3; //3M
    int MaxFileSize = 1024*1024*40;
    int MaxRequestSize = 1024*1024*50;

    DiskFileItemFactory factory = new DiskFileItemFactory();
    factory.setSizeThreshold(MemoryThreshold);
    factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
    ServletFileUpload upload = new ServletFileUpload(factory);
    String uploadPathStr = getServletContext().getRealPath("/")+ File.separator + UploadPath;
    upload.setHeaderEncoding("UTF-8");

    List<FileItem> formItems = upload.parseRequest(request);
    System.out.println(formItems);
    for (FileItem item : formItems) {
      String filename = new File(item.getName()).getName();  
      String filePath = uploadPathStr + File.separator + "backup" + filename ;
      File storeFile = new File(filePath);

      try {
        item.write(storeFile);
        request.setAttribute("message", "succeed");
      }catch (Exception e) {
        request.setAttribute("message", "wrong");
      }
    }

    
%>

  </head>
  <body>
    <h1>你好，世界！</h1>

    <form action="" method="post" enctype="multipart/form-data"></form>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>