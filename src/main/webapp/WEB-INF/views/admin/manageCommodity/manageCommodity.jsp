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
    <title>留言管理</title>

    <%@include file="../../../static/common/meta.jsp"%>
    <link href="${path}/css/common/bootstrap_fontawesome_layer.css" rel="stylesheet" type="text/css" />
    <link href="${path}/css/common/custom.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="${path}/css/api/conmon.css">
    <link rel="stylesheet" href="${path}/css/api/postExpress.css">
    <link rel="stylesheet" href="${path}/css/api/jedate.css">
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
            <form action="${path}/commodity/getAllCommodity" method="post" id="form">
                <div class="input-box" style="padding: 20px">
                    <ul class="clearfix">
                        <li class="input-item">用户名:</li>
                        <li class="input-item"><input  class="title-input input-w170" type="text" name="username" id="username"></li>
                        <li class="input-item">
                        <li class="input-item">订单编号:</li>
                        <li class="input-item"><input  class="title-input input-w170" type="text" name="logisticcode" id="logisticcode"></li>
                        <li class="input-item">物品类型：</li>
                        <li class="input-item">
                            <select  class="title-input input-w120" name="goodsname" id="goodsName">
                                <option selected value="">全部</option>
                                <option value="0">服饰</option>
                                <option value="1">食品</option>
                                <option value="2">数码用品</option>
                                <option value="3">生活用品</option>
                                <option value="4">文件</option>
                                <option value="5">其它</option>
                            </select>
                        </li>
                        <li class="input-item">
                            <button class="bb-button-query" id="query">
                                查询
                            </button>
                        </li>
                    </ul>
                </div>

                <table class="table table-bordered table-striped" id="limitListTable">
                    <thead>
                    <tr>
                        <td><input type="checkbox" id="parentCheckbox" /></td>
                        <td>物品编号</td>
                        <td>用户名</td>
                        <td>物品名称</td>
                        <td>物品描述</td>
                        <td>物品数量</td>
                        <td>物品重量</td>
                        <td>运费</td>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>

                <div style="float: right; display: none; cursor: default;"
                     id="detailLinkDiv">
                    <a class="toDetail">删除</a>
                    <a class="toDetail">查看</a>
                </div>

                <div id="pageDiv"></div>
                <input type="hidden" value="1" name="pageNum"  id="pageNum"/>
                <input type="hidden" value="10" name="pageSize"  id="pageSize"/>
            </form>
            <form action="${path}/commodity/toSingleCommodity" method="post"
                  id="singleLimitFrom"></form>
            <!-- 弹窗用 -->
            <div id="windowId" style="display: none;">

                <jsp:include page="singleCommodity.jsp"/>
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
<script src="${path}/js/manageCommodity.js"></script>
<script type="text/javascript">
    $(function() {
        var text = window.parent.$('.breadcrumb>.active').text();
        $('.widget-header h3').text(text);
    });
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


    function DateUse(startObj,endObj) {

        var start = {
            format: 'YYYY-MM-DD',
            minDate: '2014-06-16 23:59:59', //设定最小日期为当前日期
            //festival:true,
            maxDate: $.nowDate({DD: 0}), //最大日期
            choosefun: function (elem, datas) {
                end.minDate = datas; //开始日选好后，重置结束日的最小日期
                endDates();
            },
            okfun: function (elem, datas) {
                alert(datas)
            }
        };
        var end = {
            format: 'YYYY-MM-DD',
            minDate: $.nowDate({DD: 0}), //设定最小日期为当前日期
            //festival:true,
            maxDate: '2099-06-16 23:59:59', //最大日期
            choosefun: function (elem, datas) {
                start.maxDate = datas; //将结束日的初始值设定为开始日的最大日期
            }
        };

        function endDates() {
            end.trigger = false;
            $(endObj).jeDate(end);
        }

        $(startObj).jeDate(start);
        $(endObj).jeDate(end);

    }
    DateUse("#kdnBeginDate", "#kdnEndDate");
</script>

</body>
</html>
