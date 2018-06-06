<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 5/11/2018
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("path", path);
%>
<head>
    <title>修改管理员信息</title>
    <link rel="stylesheet" href="${path}/css/common/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/bootstrap_fontawesome_layer.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/custom.css" type="text/css"/>
    <link href="${path}/css/api/toastr.min.css" type="text/css" rel="stylesheet" />

    <script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
    <script src="${path}/js/api/toastr.min.js"></script>
    <script  src="${path}/js/verifyForm.js"></script>
    <script src="${path}/js/common/jquery_layer.js"></script>
    <script  src="${path}/js/common/common.js"></script>
    <script  src="${path}/js/update.js"></script>
    <script type="text/javascript">
        var path = '${path}';
    </script>
</head>

<body class="container">
<!-- main -->
<div class="content">
    <div class="widget">
        <div class="widget-header">
            <h3>修改管理员信息页面</h3>
        </div>
        <div class="widget">
            <div class="update-pwd-div" style="height: 300px;border: 0px solid #F1F1F1; width: 50%;margin: 0 auto;padding-top: 50px;">
                <form id="form" enctype="multipart/form-data">
                    <table class="table table-bordered">
                        <tr style="text-align: right;">
                            <td>用户名</td>
                            <td><input type="text"  class="form-control" id="username"  value="${admin.username}" name="username" disabled="disabled" />
                                <input type="hidden"  class="form-control" id="adminid"  name="adminid" value="${admin.adminid}"/></td></td>
                        </tr>
                        <tr style="text-align: right;">
                            <td>密码</td>
                            <td><input type="password"  class="form-control" id="password" value="${admin.password}"   name ="password" maxlength="12" disabled="disabled"/></td>
                        </tr>

                        <tr style="text-align: right;">
                            <td>上传头像</td>
                            <td>
                                <img src="${path}/img/${admin.photo}" width="200px" height="200px" onerror="this.src='${path}/img/profile.png;this.onerror=null'" />
                                <p style="text-align: left">更换头像:</p>
                                <input type="file" name="file" id="file" disabled="disabled"   class="btn-file"/></td>
                        </tr>

                        <tr style="text-align: left;">
                            <td>性别</td>
                            <td>
        <c:choose>
          <c:when test="${admin.sex =='男'}">
                                <label class="label1"  style="font-size: medium">男</label>
                                <input type="radio" disabled="disabled"  checked="checked" name="sex"  id="male "value="男"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <label class="label1" style="font-size: medium">女</label>
                                <input type="radio" name="sex" disabled="disabled"   id="female" value="女"/>
          </c:when>
           <c:otherwise>
            <label class="label1"  style="font-size: medium">男</label>
               <input type="radio"  name="sex"  id="male" value="男" disabled="disabled"  disabled="disabled"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <label class="label1" style="font-size: medium">女</label> <input type="radio" name="sex" disabled="disabled"  checked="checked"  id="female" value="女"  disabled="disabled" />
        </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr style="text-align: right;">
                            <td>年龄</td>
                            <td><input type="text" value="${admin.age}" disabled="disabled"  class="form-control" id="age" name="age" /></td>
                        </tr>
                        <tr style="text-align: right;">
                            <td>手机号</td>
                            <td><input type="text" value="${admin.phone}" disabled="disabled"  class="form-control" id="phone" name="phone" /></td>
                        </tr>
                        <tr style="text-align: right;">
                            <td>电子邮箱</td>
                            <td><input type="text"  value="${admin.email}" disabled="disabled"  class="form-control" id="email" name="email" /></td>
                        </tr>
                        <tr style="text-align: right;">
                            <td>身份证号</td>
                            <td><input type="text" value="${admin.idnumber}"  disabled="disabled" class="form-control" name="idnumber"  id="idnumber"/></td>
                        </tr>

                        <tr>
                            <td colspan="2">
                                <div class="row">
                                    <div class="col-lg-12" style="text-align: center;">
                                        <input  type="button" class="btn btn-primary" style="width: 120px;text-align: center;border-radius: 12px;" onclick="return edit()"  id="btn_edit" value="编辑"/>&nbsp;&nbsp;&nbsp;
                                        <input  type="button" class="btn btn-primary" style="width: 120px;text-align: center;border-radius: 12px;" onclick="return doUpdateAdminAccount()"  id="save" value="保存"/>
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

</body>
</html>
