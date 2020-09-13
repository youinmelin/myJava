<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/23
  Time: 19:43
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

    <link rel="shortcut icon" href="/img/U.ico">
    <script>
        // judge msg and file are empty
        function checkMsg() {
            var msg = $("#msg").val();
            if (msg=="" || msg==null) {
//                alert("msg is empty")
                return false;
            }
            return true;
        }

        function checkFile() {
            var fileValue = $("#file").val();
            if (fileValue=="" || fileValue==null) {
//                alert("file is empty")
                return false;
            }
            return true;
        }

        $(function () {
            $("#msgForm").submit(function() {
                if(checkMsg()||checkFile()) {
                    return true;
                }else {
//                    alert("留言和文件至少填写一项")
                    $("#emptyTips").html("留言和文件至少填写一项").css("color","red");
                    return false;
                }
            })
        });
    </script>
</head>
<body>
<nav class="navbar navbar-inverse" >
<%--<nav class="navbar navbar-default">--%>
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" >导航</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/user/findAll">你好：<b>${cookie.username.value}</b></a></li>
                <li><a href="http://mail.bjsw.tax.cn/" target="_blank">Coremail邮件系统</a></li>
                <li><a href="http://132.12.87.141:18000/" target="_blank">增值税发票2.0</a></li>
                <li><a href="http://132.12.87.138:8307/dzdzgateway/dzdzn/" target="_blank">电子底账系统</a></li>
                <li><a href="http://szrs.bjsw.tax.cn/webapp/loginindex.do" target="_blank">数字人事</a></li>
                <%--<li><a href="http://68.92.144.17/upload/findAllFileMsgWithUser" onclick="window.external.addFavorite(this.href,this.title);return false;",title="内网优盘",rel="sidebar">收藏本页</a></li>--%>
                <li><a href="http://portal.yw.bjsw.tax/portal/" target="_blank">运维平台</a></li>
                <li><a href="http://68.16.210.233:7001/wsbst/console/index_new.jsp" target="_blank">内网办税平台</a></li>
                <li><a href="http://68.92.16.16/" target="_blank">昌平税务内网</a></li>
                <li><a href="" target="_blank"></a></li>
                <li><a href="javascript:void(0)" onclick="location.reload()">刷新</a></li>
                <li><a href="javascript:alert('按住ctrl+D加入收藏')">收藏本页</a></li>
                <%--<li class="dropdown">--%>
                    <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>--%>
                    <%--<ul class="dropdown-menu">--%>
                        <%--<li><a href="#">Action</a></li>--%>
                        <%--<li><a href="#">Another action</a></li>--%>
                        <%--<li><a href="#">Something else here</a></li>--%>
                        <%--<li role="separator" class="divider"></li>--%>
                        <%--<li><a href="#">Separated link</a></li>--%>
                        <%--<li role="separator" class="divider"></li>--%>
                        <%--<li><a href="#">One more separated link</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
            </ul>
        </div>
    </div>
</nav>
<h1 align="center"><b>内网优盘</b></h1>
<%
    int numPerPage = 10;
%>
<%--numPerPage: <%= numPerPage %>--%>

<c:if test="${empty cookie.uid.value}">
    <%
        // if do not login(cookie uid is empty), then jump to login page
        System.out.println("cookie is empty. redirect to /user/findAll");
        response.sendRedirect("/user/findAll");
    %>
</c:if>
</div>
<span align="left">
    <div  align="center" >
    <table  class="table table-condensed table-hover" style="width: 55%" align="center" >
        <form id="msgForm" action="/upload/uploadFileMsg"  method="post" enctype="multipart/form-data" class="form-inline">
            <input type="hidden" name="uId" value="${cookie.uid.value}"  >
            <input type="hidden" name="username" value="${cookie.username.value}"  >
        <%--<tr style="width: 40%" > 你好：<a href="/user/findAll">${cookie.username.value}</a>--%>
                    <%--uid:${cookie.uid.value} userAuthority:${cookie.authority.value}--%>
        <%--</tr>--%>
    <tr>
    <td nowrap="nowrap">
    <label for="msg">留言信息：</label><br>
    </td>
    <td colspan="9">
            <textarea name="msg" id="msg" aria-multiline="true" rows="3" cols="100"
                      placeholder="请输入留言信息，如果留言信息为空，留言默认为附件的文件名。留言和文件名至少填写一项。"></textarea>
        </td>
    </tr>

    <tr>
        <td>
            <label for="file">上传文件：</label>
        </td>
        <td>
            <input type="file" id="file" name="upload">
        </td>
    <%--</tr>--%>
    <%--<tr >--%>
        <td></td>
        <td align="left">
            <input type="submit" class="btn btn-default" id="submit" value="发送"><span id="emptyTips" ></span>
        </td>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <%--</tr>--%>
        </form>
    </table>
</form>

    </div>

</span>

<table id="table" class="table table-condensed table-hover" style="width: 90%" align="center" >
    <thead >
    <tr class="info" style="align-text: center">
        <td nowrap="nowrap">
        <b>发信人</b></td> <td align="center"><b>留言</b></td> <td><b>文件名</b></td> <td nowrap="nowrap"><b>文件大小</b></td> <td><b>发送时间</b></td> <td></td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${fileMsgList}" var="msg">
        <tr >
                    <%--username--%>
            <td nowrap="nowrap"> ${msg.user.username}</td>
                    <%--massage--%>
            <td>${msg.message}</td>
                    <%--filename--%>
            <td style="width: 300px">
                <c:if test="${msg.filenameFull==''}">
                    无附件
                </c:if>
                <c:if test="${msg.filenameFull!=''}">
                    <img src="/img/file_icon.png">
                    <a href="/upload/DownloadFile?filename=${msg.filenameFull}" >${msg.filenameFull}</a>
                </c:if>
            </td>
                    <%--filesize--%>
            <td nowrap="nowrap">
                <c:if test="${msg.filenameFull==''}">
                    -
                </c:if>
                <c:if test="${msg.filenameFull!=''}">
                    <c:if test="${msg.filesize>0}">
                        ${msg.filesize}M
                    </c:if>
                    <c:if test="${msg.filesize==0}">
                        <1M
                    </c:if>
                </c:if>
            </td>
                    <%--date--%>
            <td nowrap="nowrap">
                ${msg.datetimeStr}
            </td>
                    <%--autiority--%>
            <td>
                <c:if test="${cookie.uid.value==msg.user.uid || cookie.authority.value =='del'}">
                    <%--<a href="/upload/delFileByMsgId?msgId=${msg.msgId}">del</a>--%>
                    <a href="/upload/delFileByMsgId?msgId=${msg.msgId}">
                    <img src="/img/delete.png" title="删除" alt="删除" ></a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6">

            <nav>
                <%--big buttons--%>
                <%--<ul class="pagination">--%>
                <%--small buttons--%>
                <ul class="pagination pagination-sm">
                    <li>
                        <%--previous page button--%>
                        <c:if test="${(currentPage-1) < 1}">
                            <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                        </c:if>
                        <c:if test="${(currentPage-1) >= 1}">
                        <a href="/upload/findAllFileMsgWithUser?currentPage=${currentPage-1}&numPerPage=<%= numPerPage %>" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span> </a>
                        </c:if>
                    </li>
                    <%--middle pages button--%>
                    <c:forEach begin="1" end="${countPages}" varStatus="i">

                        <li <c:if test="${currentPage == i.count}">class="active"</c:if>>
                            <a href="/upload/findAllFileMsgWithUser?currentPage=${i.count}&numPerPage=<%= numPerPage %>">${i.count}</a></li>
                    </c:forEach>
                    <li>
                        <%--next page button--%>
                        <c:if test="${(currentPage+1) <= countPages}">
                        <a href="/upload/findAllFileMsgWithUser?currentPage=${currentPage+1}&numPerPage=<%= numPerPage %>" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span> </a>
                        </c:if>
                            <c:if test="${(currentPage+1) > countPages}">
                                    <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a></li>
                            </c:if>
                    </li>
                </ul>
            </nav>

            共${count}条记录，每页显示<%= numPerPage %>条，当前第${currentPage}页，共${countPages}页
            <%--<c:forEach begin="1" end="${countPages}" varStatus="i">--%>
                <%--<li><a href="/upload/findAllFileMsgWithUser?currentPage=${i.count}&numPerPage=5">${i.count}</a></li>--%>
            <%--</c:forEach>--%>
        </td>
    </tr>
    </tbody>
</table>

<div>
</div>
</body>
</html>
