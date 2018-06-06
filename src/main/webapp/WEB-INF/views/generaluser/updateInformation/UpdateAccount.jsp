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
    <title>修改个人资料</title>
    <link rel="stylesheet" href="${path}/css/common/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/bootstrap_fontawesome_layer.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/custom.css" type="text/css"/>
    <link href="${path}/css/common/sumoselect.min.css" rel="stylesheet" type="text/css" />
    <link href="${path}/css/api/toastr.min.css" type="text/css" rel="stylesheet" />

    <script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
    <script  src="${path}/js/update.js"></script>
    <script  src="${path}/js/common/common.js"></script>
    <script  src="${path}/js/common/jquery_layer.js"></script>
    <script src="${path}/js/api/toastr.min.js"></script>

    <script>
        var path = '${path}';
        function  edit() {
            $('input').prop("disabled",false);
            return false;
        }
    </script>

</head>

<body>
<jsp:include page="../home/head.jsp"/>
<div class="container">

    <div class="col-lg-8 col-lg-offset-2">
        <div class="page-header">

            <h2>修改个人资料</h2>
        </div>
        <hr class="headers-region"/>
        <div class="container">
            <form id="updateAccountForm" enctype="multipart/form-data" class="form-horizontal">
                <div class="form-group">
                    <input type="hidden"  id="userid" name="userid" value="${generaluser.userid}" />
                    <input type="text" class="form-control" id="username" name="username" value="${generaluser.username}"  placeholder="用户名" disabled="disabled" />

                </div>
                <br>
                <div class="form-group">

                    <input type="text" class="form-control" id="age" name="age" value="${generaluser.age}"  placeholder="年龄" disabled="disabled" />

                </div>
                <br>
                <div class="form-group">
                    <label class="label1" style="font-size: medium">性别</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp
                    <c:choose>
                        <c:when test="${generaluser.sex =='男'}">
                            <label class="label1"  style="font-size: medium">男</label> <input type="radio"  checked="checked" name="sex"  id="male" value="男" disabled="disabled"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label class="label1" style="font-size: medium">女</label> <input type="radio" name="sex"  id="female" value="女"  disabled="disabled"/>
                        </c:when>
                        <c:otherwise>
                            <label class="label1"  style="font-size: medium">男</label> <input type="radio"  name="sex"  id="male" value="男"  disabled="disabled"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label class="label1" style="font-size: medium">女</label> <input type="radio" name="sex"  checked="checked"  id="female" value="女"  disabled="disabled" />
                        </c:otherwise>
                    </c:choose>
                </div>

                <br>
                <div class="form-group">

                   <img src="${path}/img/${generaluser.photo}" width="30%" height="30%" onerror="this.src='${path}/img/profile.png;this.onerror=null'"/><br>
                  更换头像：<input type="file" class="icon-file" id="file" name="file" />
                <div class="form-group">

                    <input type="text" class="form-control" id="phone" name="phone" value="${generaluser.phone}" placeholder="手机号码" disabled="disabled"  />

                </div>
                <br>
                <div class="form-group">

                    <input type="text" class="form-control" id="email" name="email" value="${generaluser.email}" placeholder="电子邮箱"  disabled="disabled" />
                </div>
                <br>
                <div class="form-group">

                    <input type="text" class="form-control" id="idnumber" name="idnumber" value="${generaluser.idnumber}"placeholder="身份证号码" disabled="disabled" />

                </div>
                <br>
                <div class="form-group">
                  <input type="button" class="btn btn-primary" id="btn_edit" value="编辑" onclick="return edit()"/> &nbsp;&nbsp;&nbsp;
                    <input type="button" class="btn btn-primary" value="保存" id="btn_save" onclick="return doUpdateAccount()"/>

            </div>

            </form>
        </div>

    </div>


</div>



</body>
</html>
