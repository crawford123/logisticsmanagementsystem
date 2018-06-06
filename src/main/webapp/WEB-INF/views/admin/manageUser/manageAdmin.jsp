<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 4/4/2018
  Time: 12:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@include file="../../../static/common/taglib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" class="no-js">
<head>
    <title>管理管理员界面</title>

    <%@include file="../../../static/common/meta.jsp"%>
    <link href="${path}/css/common/bootstrap_fontawesome_layer.css" rel="stylesheet" type="text/css" />
    <link href="${path}/css/common/custom.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="${path}/css/api/conmon.css">
    <link rel="stylesheet" href="${path}/css/api/postExpress.css">
    <link rel="stylesheet" href="${path}/css/api/jedate.css">
</head>
    <style type="text/css">
        .toDetail {
            cursor: pointer;
            font-size: larger;
            font-weight: bold;
            color:#1b61ff;
            text-decoration:none;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
        }
    </style>
    <script type="text/javascript">
        var path = '${path}';
        var noLimitClass = '${noLimitClass}';
    </script>
    <base href="<%=basePath%>" />
</head>
<body class="container">
<div class="content">
    <div class="widget">
        <!-- 页面头部 -->
        <div class="widget-header">
            <h3></h3>
        </div>
        <!-- 页面主体-->
        <div class="widget-content">
            <form action="${path}/user/getAllAdmins" method="post" id="form">
                <br/>
                <div class="input-box" style="padding: 20px">
                    <ul class="clearfix">
                        <li class="input-item">用户名:</li>
                        <li class="input-item"><input  class="title-input input-w170" type="text" name="username" id="username"></li>
                        <li class="input-item">手机号:</li>
                        <li class="input-item"><input  class="title-input input-w170" type="text" name="phone" id="phone"></li>
                        <li class="input-item">
                        <li class="input-item">身份证号:</li>
                        <li class="input-item"><input  class="title-input input-w170" type="text" name="idnumber" id="idnumber"></li>
                        <li class="input-item">性别：</li>
                        <li class="input-item">
                            <select  class="title-input input-w120" name="sex" id="sex">
                                <option selected value="">全部</option>
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </li>
                        <li class="input-item">
                            <button class="bb-button-query" id="query">
                                查询
                            </button>
                        </li>
                    </ul>
                </div>
                <br/>

                <table class="table table-bordered table-striped" id="limitListTable">
                    <thead>
                    <tr>
                        <td><input type="checkbox" id="parentCheckbox"/></td>
                        <td>管理员id</td>
                        <td>用户名</td>
                        <td>性别</td>
                        <td>手机号码</td>
                        <td>身份证号码</td>
                        <td>电子邮箱</td>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>

                <div style="float: right; display: none; cursor: default;"
                     id="detailLinkDiv">
                    <a class="toDetail">删除</a>
                    <a class="toDetail">查看</a>
                    <a class="toDetail">修改</a>
                    <a class="toDetail">重置密码</a>
                </div>

                <div id="dataDiv"></div>
                <div id="pageDiv"></div>
                <input type="hidden" value="1" name="pageNum"  id="pageNum"/>
                <input type="hidden" value="10" name="pageSize"  id="pageSize"/>
            </form>
            <form action="${path}/user/toSingleAdmin" method="post"
                  id="singleLimitFrom"></form>
            <!-- 弹窗用 -->
            <div id="windowId" style="display: none;">

                <jsp:include page="singleAdmin.jsp"/>
            </div>
        </div>
    </div>
</div>

<!-- Javascript -->
<script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
<script  src="${path}/js/common/common.js"></script>
<script  src="${path}/js/common/jquery_layer.js"></script>
<script  src="${path}/js/common/bootstrap_king.js"></script>
<script  src="${path}/js/common/jsrsasign-all-min.js"></script>
<script src="${path}/js/api/jquery.jedate.js"></script>
<script src="${path}/js/common/jquery.form.js"></script>
<script src="${path}/js/common/laypage.js"></script>
<script src="${path}/js/manageAdmin.js"></script>
<script type="text/javascript">
    $(function() {
        var text = window.parent.$('.breadcrumb>.active').text();
        $('.widget-header h3').text(text);
        if(typeof(noLimitClass)!="undefined" && noLimitClass!=null && noLimitClass!=""){
            tipsMsgWithOutClose("Please add Staff Limit Class before adding employee!");
        }
    });
    var path = "${path}";
    var checkBoxNone = 'Please select check box';
    var checkBoxOnlyOne = 'Make sure you only have one option selected';
    var confirmBtn = '确认';
    var cancelBtn = '取消';
    var tipsMsgMsg = '确定删除吗？';
    var tipsMsgMsgs = '确定重置密码吗？';
    var skipBtnName = 'OK';
    var skipMsg = "Jump to page #";
    var pageMsgStr = 'Total No. of Record _,current page _ / _';
    var canNotEmpty = "不能为空";
</script>

</body>
</html>
