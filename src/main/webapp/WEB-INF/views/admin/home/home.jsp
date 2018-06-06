<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 4/21/2018
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("path", path);
%>
<html>
<head>
    <title>物流管理系统主页</title>
</head>
<body>
<h2>欢迎来到超速物流管理系统！！！</h2>
<img src="${path}/img/logistics5.jpg" >

</body>
</html>
