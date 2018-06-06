<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 4/18/2018
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("path", path);
%>
<head>
    <title>修改密码</title>
    <link rel="stylesheet" href="${path}/css/common/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/bootstrap_fontawesome_layer.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/custom.css" type="text/css"/>
    <link href="${path}/css/common/sumoselect.min.css" rel="stylesheet" type="text/css" />
    <link href="${path}/css/api/toastr.min.css" type="text/css" rel="stylesheet" />

    <script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
    <script  src="${path}/js/verifyForm.js"></script>
    <script  src="${path}/js/common/common.js"></script>
    <script  src="${path}/js/common/jquery_layer.js"></script>
    <script src="${path}/js/api/toastr.min.js"></script>
    <script  src="${path}/js/update.js"></script>
    <script type="text/javascript">
        var path ='${path}';
    </script>
</head>
<body>
<jsp:include page="../home/head.jsp"/>
<div class="container">

    <div class="col-lg-8 col-lg-offset-2">
        <div class="page-header">

            <h2>修改密码</h2>
        </div>
        <hr class="headers-region"/>
        <div class="container">
            <form id="updatePassword"  class="form-horizontal">
                <div class="form-group">
                    <input type="hidden" class="form-control"  name="userid"  id="userid" value="${generaluser.userid}" />
                    <input type="hidden" class="form-control"  name="username"  id="username" value="${generaluser.username}" />
                    <input type="password" class="form-control"   name="oldPassword" id="oldPassword"   placeholder="请输入旧密码"  />

        </div>

                <br>

                <div class="form-group">
                    <input type="password" class="form-control" id="password" name="password" placeholder="新密码" />

                </div>
                <div class="form-group">

                    <label class="label1" style="font-size: medium"></label>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="确认密码" />

                </div>

                <div class="form-group">
                    <input type="button" class="btn btn-primary" value="修改密码" id="btn_update" onclick="return doUpdatePassword()"/>

                </div>

            </form>
        </div>

    </div>


</div>

</body>
</html>
