<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 4/15/2018
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("path", path);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>快递查询</title>
    <link href="${path}/css/search/out-num.css" rel="stylesheet" />
    <link rel="stylesheet" href="${path}/css/orderdetail/base.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/orderdetail/global.css" type="text/css"/>
    <link href="${path}/css/search/out-common.css" rel="stylesheet" />
    <link href="${path}/css/api/toastr.min.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${path}/css/st/global.css" />
    <link rel="stylesheet" type="text/css" href="${path}/css/st/common.css" />
</head>
<body>
<jsp:include page="../home/head.jsp"/>

<!--搜索框 start-->
<div class="kdn-search clearfix">
    <%--<div class="express-icon">
        <span  id="autosy" data-code="auto" name="ShipperCode">智能识别</span>
        <img class="icon-content" src="${path}/img/search/pull-down.png" alt="快递公司logo" />
        <div class="search-tip">切换快递公司</div>
    </div>--%>
      <input type="hidden" id="test" value="<%=request.getParameter("logisticcode")%>" />
    <input  class="search-input search-area"  type="text"  name="logisticcode" id="logisticcode" placeholder="请输入运单号,例如2165132113216" />
    <input  class="search-input search-btn" style="float: right" type="button"  id="beginsearch" onclick="return searchOrder()">
</div>
<!--搜索框 end-->
<!--单号提示信息 start-->
<ul class="input-tips hide" id="inputTips" >
    <li class="tips_bottom otline">物流信息由 快递鸟 提供</li>
</ul>
<!--单号提示信息 end-->
<!--companys start-->
<div class="express-companys hide">
    <div class="com-list">
        <div id="suggestList" class="suggest hidden"></div>
        <ul class="common">
            <li >
                <span class="li-title" >常用</span>
                <a data-code="auto">智能识别</a>
                <a class="SF" data-code="auto">顺丰</a>
                <a class="expItem" data-code="EMS">EMS</a>
            </li>
        </ul>

        <div class="search-bg"></div>

        <div class="box"></div>
    </div>
</div>
<!--companys end-->
<!--搜索成功 start-->
<div class="query-outline hide" id="searchSuccess" >
  <div class="up-title">
        <ul>
            <li class="title-item expressTitle" ></li>
            <li class="title-item expressTel"><img src="${path}/img/search/phone.png" alt=""></li>
            <li class="title-item">
             <%--   <img src="${path}/img/search/internet.png" alt="">--%>
                <a  target="_blank" class="expressWebSite">超速物流官网</a>
            </li>
        </ul>
    </div>
    <div class="store-content">
        <div class="sc-show">
            <ul class="track-list" id="ultrack">
                <%--<li class="afterdate first">
                <i class="node-icon"></i><span class="date">2015-03-09 18:39:00</span>
                <span class="txt">离开北京市 发往呼和浩特市（经转）</span>
                <span class="txt"></span></li>
                <br>
                <li class="afterdate first">
                <i class="node-icon"></i>
                <span class="date">2015-03-08 01:15:00</span>
                <span class="txt">离开广州市 发往北京市（经转)</span>
                <span class="txt"></span></li>--%>
            </ul>
        <%--  <ul id="ultrack">


            </ul>--%>
        </div>
        <div class="tips_bottom2">物流信息由 <a class="col-common" href="http://kdniao.com/" target="_blank">快递鸟</a> 提供</div>
    </div>
</div>
<!--搜索成功 end-->
<!--搜索失败start-->
<div class="query-outline hide " id="searchFail">
    <div class="up-title">
        <ul>
            <li class="title-item expressTitle" >超速物流</li>
            <li class="title-item expressTel"><img src="${path}/img/search/phone.png" alt="">电话：021-069365216</li>
            <li class="title-item">
               <%-- <img src="${path}/img/search/internet.png" alt="">--%>
                <a href="" target="_blank" class="expressWebSite">超速物流官网</a>
            </li>
        </ul>
    </div>
    <div class="store-content">
        <span class="f24 error-title">抱歉,此单号暂无轨迹</span>
        <ul class="clearfix error-box">
            <li class="show-error error-icon1">
                运单号正确请稍后重试，可能是网络问题。 <br>或点击右上角快递公司官网地址进行查询。
            </li>
            <li class="show-error error-icon2">可能是运单号错误，<br> 请重新输入</li>
        </ul>
        <div class="tips_bottom2">物流信息由 <a class="col-common" href="http://kdniao.com/" target="_blank">快递鸟</a> 提供</div>
    </div>
</div>
<!--搜索失败end-->
<jsp:include page="../home/foot.jsp"/>
<script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
<script src="${path}/js/search/jquery.min.js"></script>
<script src="${path}/js/search/webchat.js"></script>
<script src="${path}/js/search/baiduwebsite.js"></script>
<script src="${path}/js/search/SearchTrack.js"></script>
<script src="${path}/js/api/toastr.min.js"></script>
<script type="text/javascript">
    var path = '${path}';
    var test=$("#test").val().trim();
    if($("#logisticcode").val()==null){
        $("#logisticcode").val("");
    }

    if(test.length>0){
        $("#logisticcode").val(test);
    }
</script>
</body>


</html>
