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
    <title>注册界面</title>
    <link rel="stylesheet" href="${path}/css/common/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/bootstrap_fontawesome_layer.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/custom.css" type="text/css"/>
    <link href="${path}/css/api/toastr.min.css" type="text/css" rel="stylesheet" />

    <script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
    <script src="${path}/js/api/toastr.min.js"></script>
    <script  src="${path}/js/verifyForm.js"></script>
    <script  src="${path}/js/register.js"></script>
    <script type="text/javascript">
        var path = '${path}';
    </script>
</head>

<body>
<jsp:include page="../home/head.jsp"/>
<div class="container">

    <div class="col-lg-8 col-lg-offset-2">
        <div class="page-header">

            <h2>个人用户注册</h2>
        </div>
        <hr class="headers-region"/>
        <div class="container">
            <form id="registerForm"  class="form-horizontal" enctype="multipart/form-data">
                <div class="form-group">

                    <input type="text" class="form-control" id="username" name="username" placeholder="用户名" />

                </div>
                <br>
                <div class="form-group">

                    <input type="password" class="form-control" id="password" name="password" placeholder="密码" />

                </div>
                <br>
                <div class="form-group">

                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="确认密码" />

                </div>
                <br>
                <div class="form-group">

                    <input type="text" class="form-control" id="age" name="age" placeholder="年龄"  onkeyup="ClearNoNum(this);"/>

                </div>
                <br>
                <div class="form-group">
                    <label class="label1" style="font-size: medium">性别</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <label class="label1"  style="font-size: medium">男</label> <input type="radio"  checked="checked" name="sex"  id="male "value="男"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <label class="label1" style="font-size: medium">女</label> <input type="radio" name="sex"  id="female" value="女"/>
                    </div>

                <br>

                <div class="form-group">

               上传头像：<input type="file" class="icon-file" id="file" name="file"  />

                </div>

                <div class="form-group">

                    <input type="text" class="form-control" id="phone" name="phone" maxlength="11" placeholder="手机号码" onkeyup="ClearNoNum(this);" />

                </div>
                <br>
                <div class="form-group">

                    <input type="text" class="form-control" id="email" name="email" placeholder="电子邮箱" />

                </div>
                <br>
                <div class="form-group">

                    <input type="text" class="form-control" id="idnumber" name="idnumber" maxlength="18" placeholder="身份证号码" onkeyup="ClearNoNum(this);" />
                    <input type="hidden"  id="logintype" name="logintype" value="0" />
                </div>
                <br>
                <div class="form-group">
                    <input  class="btn btn-primary" id="btn_register" type="button" value="注册" onclick="return doRegister()"/>

                </div>
                <br>

            </form>
        </div>

    </div>


</div>



</body>
</html>
