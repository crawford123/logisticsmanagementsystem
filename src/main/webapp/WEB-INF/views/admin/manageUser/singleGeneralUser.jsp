<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@include file="../../../static/common/taglib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" class="no-js">
<head>
    <title></title>

    <%@include file="../../../static/common/meta.jsp"%>

    <link href="${path}/css/common/bootstrap_fontawesome_layer.css" rel="stylesheet" type="text/css" />
    <link href="${path}/css/common/custom.css" rel="stylesheet" type="text/css" />
    <link href="${path}/css/common/sumoselect.min.css" rel="stylesheet" type="text/css" />
    <style type="">
        .SumoSelect {
            width: 100% !important;
        }
        .resetMpinStyle {
            width: auto !important;
            float:left;
        }
    </style>
    <script type="text/javascript">
        var path = "${path}";
        var staffInfo = '${staffInfo}';
        var staffObj = null;
        if(staffInfo){
            staffObj=JSON.parse(staffInfo);
        }
    </script>
</head>
<body class="container">
<div class="content">
    <div class="widget">
        <!-- 页面头部 -->
        <div class="widget-header">
            <input type="hidden" value="<%=request.getParameter("detailType")%>" id="detailType" />
            <h3>个人用户信息</h3>
        </div>
        <!-- 页面主体-->··
        <div class="widget-content">
            <form action="${path}/user/modifyGeneralUser" method="post"
                  id="singleStaffFrom"  enctype="multipart/form-data">
                <table class="table table-bordered table-striped" style="overflow:hidden">
                    <tr>
                        <td class="col-sm-2">用户id
                        </td>
                        <td class="col-sm-4">
                        <input type="text" class="form-control unEditable" name="userid" id="userid" value="${generaluser.userid}" /></td>
                        <td class="col-sm-2">用户名</td>
                        <td class="col-sm-4"><input type="text" class="form-control unEditable" name="username" id="username"  value="${generaluser.username}" maxlength="50"/></td>
                    </tr>
                    <tr>
                        <td class="col-sm-2">用户密码</td>
                        <td class="col-sm-4"><input type="password" class="form-control unEditable" name="password" id="password" value="${generaluser.password}" maxlength="50"/></td>
                        <td>性别</td>
                        <td>
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
                        </td>
                    </tr>
                    <tr>
                        <td>年龄</td>
                        <td><input type="text" class="form-control unEditable" name="age" id="age"  value="${generaluser.age}"/></td>
                        <td>手机号码</td>
                        <td><input type="text" class="form-control unEditable" name="phone" id="phone"  value="${generaluser.phone}"/></td>
                    </tr>
                    <tr>
                        <td>上传头像</td>
                        <td>
                            <img src="${path}/img/${generaluser.photo}" width="100%" height="100%"  onerror="this.src='${path}/img/profile.png;this.onerror=null'"/>
                            <input type="file" class="icon-file" name="file" id="file"/></td>
                        <input type="hidden" value="0" id="logintype" name="logintype"/></td>
                        <td>电子邮箱</td>
                        <td><input type="text" class="form-control unEditable" name="email" id="email" value="${generaluser.email}" /></td>
                    </tr>
                    <tr>
                        <td>身份证号码</td>
                        <td><input type="text" class="form-control unEditable" name="idnumber" id="idnumber" value="${generaluser.idnumber}"/></td>
                    </tr>
                </table>
                <button class="bb-button-query" style="float: right" id="btnId" type="button"></button>
            </form>



        </div>
    </div>
</div>

<!-- Javascript -->
<script src="${path}/js/common/jquery_layer.js"></script>
<script src="${path}/js/common/bootstrap_king.js"></script>
<script src="${path}/js/common/jsrsasign-all-min.js"></script>
<script src="${path}/js/singleGeneralUser.js"></script>
<script src="${path}/js/common/common.js"></script>
<script src="${path}/js/common/laypage.js"></script>
<script src="${path}/js/common/jquery.form.js"></script>
<script src="${path}/js/common/jquery.sumoselect.min.js"></script>
<script type="text/javascript">
    var inputPlaceholder = "Please Enter";
    var btnNameObj = {
        title1 : "返回",
        title2 : "修改",
        title3 : "新增"
    };
    var titleObj = {
        title1 : "查看个人信息",
        title2 : "编辑个人信息",
        title3 : "新增个人信息"
    };
    var captionFormat = "The number of available function menus has been selected";
    var captionFormatAllSelected = "No. of all available function menus have been selected";
    var canNotEmpty = "Can not be empty";
    var sameRePwd  = 'New mPin and confirm mPin inconsistent';
    var newPinTips = 'New mPin';
    var reNewPinTips = 'Please re-enter your new mPin';
    var resetMPinBtnName ='Reset';
    var confirmBtnName = 'Confirm';
    var cancelBtnName = 'Cancel';
    var staffMPinName = 'Staff mPin';
    var reStaffMPinName = 'Re-enter Staff mPin';
</script>
</body>
</html>
