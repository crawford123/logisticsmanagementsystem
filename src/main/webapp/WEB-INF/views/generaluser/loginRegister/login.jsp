<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 3/12/2018
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=utf-8"%>

<!DOCTYPE html>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("path", path);
%>
<head>
    <title>登录界面</title>
    <link rel="stylesheet" href="${path}/css/common/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/bootstrap_fontawesome_layer.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/custom.css" type="text/css"/>
    <link href="${path}/css/api/toastr.min.css" type="text/css" rel="stylesheet" />

    <script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
    <script  src="${path}/js/login.js"></script>
    <script  src="${path}/js/common/common.js"></script>
    <script  src="${path}/js/common/jquery_layer.js"></script>
    <script src="${path}/js/api/toastr.min.js"></script>
    <script type="text/javascript">
        var path = '${path}';
    </script>
</head>

<body>

<jsp:include page="../home/head.jsp"/>
   <div class="container">

                 <div class="col-lg-8 col-lg-offset-2">
                     <div class="page-header">

                         <h2>个人用户登录</h2>
                     </div>
                     <hr class="headers-region"/>
                     <div class="container">
                     <form id="loginForm"  class="form-horizontal" >
                         <div class="form-group">

                                   <input type="text" class="form-control" id="username" name="username" placeholder="用户名" />

                         </div>
                         <br>
                         <div class="form-group">


                             <input type="password" class="form-control" id="password" name="password" placeholder="密码" />

                         </div>


                         <br>
                         <div class="form-group">
                             <input type="button" value="登录" class="btn btn-primary" onclick="return doLogin()"  id="btn_login"/>

                         </div>

                     </form>
                     </div>

                 </div>


   </div>



</body>
</html>
