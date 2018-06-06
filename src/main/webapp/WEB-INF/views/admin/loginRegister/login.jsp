<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 3/12/2018
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("path", path);
%>


<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${path}/css/common/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/bootstrap_fontawesome_layer.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/custom.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/api/conmon.css">
    <link rel="stylesheet" href="${path}/css/api/postExpress.css">
    <title>管理员登录</title>
    <link rel="stylesheet" href="${path}/css/api/city-picker.css">
    <link href="${path}/css/api/dialog.css" rel="stylesheet" />
    <link href="${path}/css/api/toastr.min.css" type="text/css" rel="stylesheet" />
</head>

<body>
<jsp:include page="../../generaluser/home/head.jsp"/>
<div class="container">
    <div class="page-header">

        <p style="font-size: x-large;font-style: italic;font-weight: bold">物流信息管理系统</p>
    </div>

    <div class="col-lg-8 col-lg-offset-2">

        <hr class="headers-region"/>
        <div class="container">
            <form id="adminLoginForm"  class="form-horizontal">
                <div class="form-group">

                    <input type="text" class="form-control" id="username"  validate-info="用户名" name="username" placeholder="用户名" />

                </div>
                <br>
                <div class="form-group">


                    <input type="password" class="form-control" id="password" validate-info="密码" name="password" placeholder="密码" />

                </div>


                <br>
                <div class="form-group">
                    <input type="button" value="登录" class="btn btn-primary" id="btn_login" onclick="return doAdminLogin()"/>

                </div>

            </form>
        </div>

    </div>


</div>


<script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
<script src="${path}/js/api/jquery.min.js"></script>
<script src="${path}/js/api/city-picker.js"></script>
<script src="${path}/js/api/index.js"></script>
<script src="${path}/js/api/dialog-plus.js"></script>
<script src="${path}/js/api/dialog.js"></script>
<script src="${path}/js/api/toastr.min.js"></script>
<script src="${path}/js/api/webchat.js"></script>
<script src="${path}/js/api/baiduwebsite.js"></script>
<script src="${path}/js/api/OnlineOrder.js"></script>
<script  src="${path}/js/login.js"></script>
<script>
    var path = '${path}';
</script>
</body>
</html>
