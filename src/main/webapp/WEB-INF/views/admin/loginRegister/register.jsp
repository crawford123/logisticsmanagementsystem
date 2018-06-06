<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 5/11/2018
  Time: 10:23 PM
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
    <title>管理员注册</title>
    <link rel="stylesheet" href="${path}/css/common/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/bootstrap_fontawesome_layer.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/custom.css" type="text/css"/>
    <link href="${path}/css/api/toastr.min.css" type="text/css" rel="stylesheet" />

<body class="container">
<!-- main -->
<div class="content">
    <div class="widget">
        <div class="widget-header">
            <h3>管理员注册页面</h3>
        </div>
        <div class="widget">
            <div class="update-pwd-div" style="height: 300px;border: 0px solid #F1F1F1; width: 50%;margin: 0 auto;padding-top: 50px;">
                <form id="form" enctype="multipart/form-data">
                    <table class="table table-bordered">
                        <tr style="text-align: right;">
                            <td>用户名</td>
                            <td><input type="text"  class="form-control" id="username"  name="username"   maxlength="12"/></td>
                        </tr>
                        <tr style="text-align: right;">
                            <td>密码</td>
                            <td><input type="password"  class="form-control" id="password"  name ="password" maxlength="12"/></td>
                        </tr>
                        <tr style="text-align: right;">
                        <td>确认密码</td>
                        <td><input type="password"  class="form-control" id="confirmPassword" maxlength="12"/></td>
                    </tr>

                        <tr style="text-align: right;">
                            <td>上传头像</td>
                            <td><input type="file"  name="file" class="btn-file" id="file" /></td>
                        </tr>

                        <tr style="text-align: left;">
                            <td>性别</td>
                            <td> <label class="label1"  style="font-size: medium">男</label>
                                <input type="radio"   checked="checked" name="sex"  id="male "value="男"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <label class="label1" style="font-size: medium">女</label>
                                <input type="radio" name="sex"   id="female" value="女"/>
                            </td>
                        </tr>
                        <tr style="text-align: right;">
                            <td>年龄</td>
                            <td><input type="text"  class="form-control" id="age" name="age" /></td>
                        </tr>
                        <tr style="text-align: right;">
                            <td>手机号</td>
                            <td><input type="text"  class="form-control" id="phone" name="phone" /></td>
                        </tr>
                        <tr style="text-align: right;">
                            <td>电子邮箱</td>
                            <td><input type="text"  class="form-control" id="email" name="email" /></td>
                        </tr>
                        <tr style="text-align: right;">
                            <td>身份证号</td>
                            <td>
                                <input type="text"  class="form-control" name="idnumber"  id="idnumber"/>
                                <input type="hidden"  id="logintype" name="logintype" value="0" />
                            </td>
                        </tr>

                        <tr>
                            <td colspan="2">
                                <div class="row">
                                    <div class="col-lg-12" style="text-align: center;">
                                        <input  type="button" class="btn btn-primary" style="width: 120px;text-align: center;border-radius: 12px;" onclick="return doAdminRegister()"  id="register" value="注册"/>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>

    </div>
</div>

<script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
<script src="${path}/js/api/toastr.min.js"></script>
<script  src="${path}/js/verifyForm.js"></script>
<script src="${path}/js/common/jquery_layer.js"></script>
<script  src="${path}/js/common/common.js"></script>
<script  src="${path}/js/register.js"></script>
<script type="text/javascript">
    var path = '${path}';
</script>
</body>
</html>
