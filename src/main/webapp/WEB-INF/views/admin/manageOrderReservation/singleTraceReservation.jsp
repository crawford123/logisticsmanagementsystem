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
    <style type="text/css">
        .SumoSelect {
            width: 100% !important;
        }
        .resetMpinStyle {
            width: auto !important;
            float:left;
        }
    </style>
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
        .toDetails {
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
            <h3></h3>
        </div>
        <!-- 页面主体-->
        <div class="widget-content">
            <form action="${path}/orderReservation/getTracesByOrderId" method="post"
                  id="form">
                <br/>
                <table class="table table-bordered table-striped" id="limitListTable">
                    <thead>
                    <tr>
                        <td><input type="checkbox" id="parentCheckbox" /></td>
                        <td>日期</td>
                        <td>订单轨迹信息</td>
                        <td>备注信息</td>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>

                <div style="float: right; cursor: default;" id="detailLinkDiv">
                    <a class="toDetail">删除</a>
                    <a class="toDetail">查看</a>
                    <a class="toDetail">修改</a>
                    <a class="toDetail">增加</a>
                    <a class="toDetail">返回</a>
                </div>

                <div id="dataDiv"></div>
                <div id="pageDiv"></div>
                <input type="hidden" value="<%=request.getParameter("id")%>" id="id" name="id"/>
                <input type="hidden" value="1" name="pageNum"  id="pageNum"/>
                <input type="hidden" value="5" name="pageSize"  id="pageSize"/>
            </form>
            <form action="${path}/orderReservation/toSingleReservation" method="post"
                  id="singleLimitFrom">
            </form>

            <!-- 弹窗用 -->
            <div id="windowId" style="display: none;">

                <jsp:include page="singleReservation.jsp"/>
            </div>
        </div>
    </div>
</div>
<!-- Javascript -->
<script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
<script src="${path}/js/common/jquery_layer.js"></script>
<script src="${path}/js/common/bootstrap_king.js"></script>
<script src="${path}/js/common/jsrsasign-all-min.js"></script>
<script src="${path}/js/singleGeneralUser.js"></script>
<script src="${path}/js/common/common.js"></script>
<script src="${path}/js/common/laypage.js"></script>
<script src="${path}/js/common/jquery.form.js"></script>
<script src="${path}/js/common/jquery.sumoselect.min.js"></script>
<script src="${path}/js/singleTraceReservation.js"></script>
<script type="text/javascript">
    var inputPlaceholder = "Please Enter";
    var btnNameObj = {
        title1 : "返回",
        title2 : "修改",
        title3 : "新增"
    };
    var titleObj = {
        title0:  "管理订单轨迹信息",
        title1 : "查看订单轨迹息",
        title2 : "编辑订单轨迹息",
        title3 : "新增订单轨迹息"
    };
    var path = "${path}";
    var checkBoxNone = 'Please select check box';
    var checkBoxOnlyOne = 'Make sure you only have one option selected';
    var confirmBtn = '确认';
    var cancelBtn = '取消';
    var tipsMsgMsg = '确定删除吗？';
    var skipBtnName = 'OK';
    var skipMsg = "Jump to page #";
    var pageMsgStr = 'Total No. of Record _,current page _ / _';
    var canNotEmpty = "不能为空";

</script>
</body>
</html>
