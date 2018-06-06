<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 5/13/2018
  Time: 11:25 AM
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
    <title>新闻详情页</title>
    <link href="${path}/css/st/idangerous.swiper.css" rel="stylesheet">
    <link href="${path}/css/st/city-picker.css" rel="stylesheet">
    <link href="${path}/css/st/pager.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="${path}/css/st/global.css">
    <link rel="stylesheet" type="text/css" href="${path}/css/st/common.css">
    <link href="${path}/css/st/layout.css" rel="stylesheet">
    <link href="${path}/css/st/news.css" rel="stylesheet">
    <link rel="stylesheet" href="${path}/css/st/layer.css?v=3.0.11110" id="layuicss-skinlayercss">
    <script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
    <script src="${path}/js/st/jquery.min.js"></script>
    <script src="${path}/js/st/city-picker.data.js"></script>
    <script src="${path}/js/st/city-picker.js"></script>
    <%-- <script src="${path}/js/st/jquery.page.js"></script>--%>
    <script src="${path}/js/st/jquery.cookie.js"></script>
    <script src="${path}/js/st/layer.js"></script>
    <script  src="${path}/js/common/common.js"></script>
    <script src="${path}/js/common/laypage.js"></script>
    <script src="${path}/js/newsDetail.js"></script>
    <script src="${path}/js/st/idangerous.swiper.min.js"></script>
    <script src="${path}/js/st/header.js"></script>
    <script type="text/javascript">
        var path = '${path}';
    </script>
</head>
<body style="">

<jsp:include page="../home/head.jsp"/>
<div class="box">
    <input type="hidden" id="newsid" value="<%=request.getParameter("newsid")%>" />
    <div class="content">
        <div class="inside_banner_news">
        </div>
        <div class="inside_cont_box">
            <div class="cont_page clearfix">
                <div class="left_module fl">
                    <div class="left_nav_title">新闻资讯</div>
                    <ul class="left_nav">
                        <li><a href="${path}/news/toDynamic">公司动态</a></li>
                        <li><a href="${path}/news/toAnnouncement" >公司公告</a></li>
                        <li><a href="${path}/news/toNews" >行业新闻</a></li>
                    </ul>
                </div>
                <div class="center_module fl">
                    <div class="news_detail">
                        <div class="news_detail_title">
                            <h3>${news.title}</h3>
                            <h5>来源：品牌宣传部 &nbsp; &nbsp;发布时间：${news.publishtime}</h5>
                        </div>
                        <div class="news_detail_cont">
                            <p style="text-align: center;"><span style="font-size: 14px;font-family: 微软雅黑,Microsoft YaHei; color: rgb(0, 0, 0);"><img src="${path}/img/${news.photo}"  width="550" height="366"></span></p>
                            <p><span style="font-size: 14px; font-family:微软雅黑,Microsoft YaHei; color: rgb(0, 0, 0);">&nbsp; &nbsp;${news.content}</span></p>
                        </div>
                        </div>
                    </div>

                    <div class="module_foot">
                        <a href="${path}/news/toDynamic" class="btn btn_search">返回</a>
                    </div>
                </div>
                <div class="right_module fr">
                    <img src="${path}/img/st/Advertisement03.png">
                    <img src="${path}/img/st/Advertisement02.png">
                    <img src="${path}/img/st/Advertisement01.png">
                </div>
            </div>
        </div>
    </div>


</div>


<jsp:include page="../home/foot.jsp"/>

<style>
    .title{padding-top:10px;padding-bottom:5px;line-height:20px;height:20px;font-size:16px;}
    .addTar textarea{border-radius:5px;}
    .cpopup a{width:50px;height:30px;line-height:30px;background-color:#ee6900;color:#ffffff;padding:5px 10px 5px 10px;border-radius:5px;}
</style>
<script>
    function Consultation() {
        layerIndex = layer.open({
            type: 1,
            area: ['350px', '160px'],
            skin: 'layui-layer-rim', //加上边框
            closeBtn: false,
            shade: 0.4,
            title: false,
            shadeClose: true,
            content: $("#popupHe2"),
            end: function () {
                $("#popupHe2").hide();
            }
        });
    }
    function sure() {
        var orderNo = $('#Reamk').val().trim().replace(/[\r\n]/g, "");
        if (orderNo == "") {
            layer.msg('请输入运单号');
            return false;
        }
        $.ajax({
            data: {
                orderNo: orderNo
            },
            url: "/Home/Consultation",
            type: "POST",
            dataType: "json",
            success: function (result) {
                if (result.Status) {
                    $("#Reamk").val("");

                    if (result.Data[0].ProcessState == "0" || result.Data[0].ProcessState == "1" || result.Data[0].ProcessState == "3") {
                        layerIndex2 = layer.alert('快件尚在处理，请耐心等待，预计处理时间2.5个工作时', {
                            //样式类名  自定义样式
                            closeBtn: 1
                            , area: ['510px', '160px']// 是否显示关闭按钮// 是否显示关闭按钮
                            //动画类型
                            , btn: ['确定'] //按钮
                            , icon: 6    // icon
                            , yes: function () {
                                layer.close(layerIndex2);
                                layer.close(layerIndex);
                            }
                        });
                    }
                    else if (result.Data[0].ProcessState == "2") {
                        layerIndex2 = layer.alert('处理已完结', {
                            //样式类名  自定义样式
                            closeBtn: 1
                            , area: ['510px', '160px']// 是否显示关闭按钮// 是否显示关闭按钮
                            , btn: ['确定'] //按钮
                            , icon: 6    // icon
                            , yes: function () {
                                layer.close(layerIndex2);
                                layer.close(layerIndex);
                            }
                        });
                    }
                    else {
                        layerIndex2 = layer.alert('未关联到此单号相关信息，请联系客服热线95543或官网在线客服查询', {
                            //样式类名  自定义样式
                            closeBtn: 1
                            , area: ['510px', '160px']// 是否显示关闭按钮// 是否显示关闭按钮
                            , btn: ['确定'] //按钮
                            , icon: 6    // icon
                            , yes: function () {
                                layer.close(layerIndex2);
                                layer.close(layerIndex);
                            }
                        });
                    }
                    //window.location.href = '/Track/Consultation?ProcessResult=' + result.Data[0].ProcessResult;
                } else {
                    if (result.StatusCode == "ParameterError") {
                        layerIndex2 = layer.alert('未关联到此单号相关信息，请联系客服热线95543或官网在线客服查询', {
                            //样式类名  自定义样式
                            closeBtn: 1
                            , area: ['510px', '160px']// 是否显示关闭按钮
                            , btn: ['确定'] //按钮
                            , icon: 6    // icon
                            , yes: function () {
                                layer.close(layerIndex2);
                                layer.close(layerIndex);
                            }
                        });
                        //layer.msg("");
                        //return false;
                    } else {
                        $("#Reamk").val("");
                        window.location.href = '/Service/AddWorkOrder?orderNo=' + orderNo;
                    }
                }
            },
        });   // end ajax
    }

    function cancel() {
        //   $('.popupHe2').css({ display: 'none' });
        //  document.getElementById("popupHe2").style.display = "none";
        layer.close(layerIndex);
        $("#popupHe2").hide();
        $("#Reamk").val("");

    }
</script>

</body>
</html>
