<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 4/20/2018
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
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
    <link rel="stylesheet" href="${path}/css/api/conmon.css">
    <link rel="stylesheet" href="${path}/css/api/postExpress.css">
    <title>订单结果</title>
    <link rel="stylesheet" href="${path}/css/api/city-picker.css">
    <link href="${path}/css/api/dialog.css" rel="stylesheet" />
    <link href="${path}/css/api/toastr.min.css" type="text/css" rel="stylesheet" />
</head>

<body>
<jsp:include page="../home/head.jsp"/>

<!--寄快递点击下一页进入选择页面 end-->
<!--订单成功与否提示框 start-->
<!--成功-->
<div class="pe-content tip-su">
    <div class="pe-tips tips-success">
        <h3>订单提交成功！</h3>
        <ul>
            <li class="pe-tips-item">快递员已接收到您的订单，预计在2小时之内联系您并上门揽件。<br>
                您也可以通过 <a class="g3" href="javascript:;">订单记录查询快递网点/快递员联系方式</a>，主动联系他们沟通</li>
            <li class="mt30">
                <a class="table-btn btn-default2 active" id="lookRecord" href="${path}/order/toOrderRecord">查看订单记录</a>
                <a class="table-btn btn-default2 active"  id="sendorder" href="${path}/order/toSendExpress">继续发件</a>
            </li>
        </ul>
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
</body>
</html>
