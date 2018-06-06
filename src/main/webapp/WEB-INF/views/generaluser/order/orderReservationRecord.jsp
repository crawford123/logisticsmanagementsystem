<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 4/17/2018
  Time: 9:41 AM
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
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${path}/css/common/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/bootstrap_fontawesome_layer.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/custom.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/api/conmon.css">
    <link rel="stylesheet" href="${path}/css/api/postExpress.css">
    <link rel="stylesheet" href="${path}/css/api/jedate.css">
    <link rel="stylesheet" href="${path}/css/st/base.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/st/city-picker.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/st/common.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/st/content.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/st/global.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/st/idangerous.swiper.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/st/layer.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/st/layout.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/st/order_search.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/st/pager.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/st/service.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/st/StyleSheet1.css" type="text/css"/>

    <link href="${path}/css/api/toastr.min.css" type="text/css" rel="stylesheet" />

    <title>订单预约记录</title>
    <style type="text/css">
        .pageNationSty {
            height:65px;
            float:right;
            color: #666;
        }
        .pageNationSty li{
            list-style:none;
            float:left;
            margin:5px 0px;
            line-height:30px;
            text-align:center;
        }
        .pgbtn {
            width: 70px;
            height: 30px;
            margin: 0px 3px;
            color: #666;
        }
        .pgtxt {
            width: 25px;
            height: 30px;
            margin: 0px 3px;
            color: #666;
        }
        input {
            padding:0px;
        }

    </style>

</head>
<body>
<jsp:include page="../home/head.jsp"/>
<div class="kdn-content" >
   <%-- <div class="pe-title">
        <ul>
            <li class="pe-title-item "><a href="${path}/orderReservation/toOrderReservationRecord">免费预约上门取件</a> </li>
            <li class="pe-title-item pe-active" style="border-left:none; "><a href="javascript:void(0)">订单预约记录</a></li>
        </ul>
    </div>--%>
    <div  class="pe-content" >
        <form action="${path}/orderReservation/getSelectiveOrderReservations" method="post" id="orderForm">
            <div class="input-box" style="padding: 20px">
                <ul class="clearfix">
                    <li class="input-item">订单号：</li>
                    <li class="input-item"><input  class="title-input input-w170" type="text" name="ordercode" id="ordercode" onkeyup="RemoveChinese(this)" maxlength="35"></li>
                    <li class="input-item">运单号：</li>
                    <li class="input-item"><input  class="title-input input-w170" type="text" name="logisticcode" id="logisticcode" onkeyup="RemoveChinese(this)" maxlength="35"></li>
                    <li class="input-item">物流状态：</li>
                    <li class="input-item">
                        <select  class="title-input input-w120" name="state" id="state">
                            <option selected value="">全部</option>
                            <option value="0">未揽件</option>
                            <option value="1">已揽件</option>
                            <option value="2">在途中</option>
                            <option value="3">已签收</option>
                            <option value="4">问题件</option>
                        </select>
                    </li>
                    <li class="input-item">预约状态：</li>
                    <li class="input-item">
                        <select  class="title-input input-w120" name="reservestate" id="reservestate">
                            <option selected value="">全部</option>
                            <option value="0">预约中</option>
                            <option value="1">预约失败</option>
                            <option value="2">预约成功</option>
                            <option value="3">取消预约</option>
                        </select>
                    </li>

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

                </ul>
                <ul class="clearfix">
                    <li class="input-item">预约时间：</li>
                    <li class="input-item">
                        <input id="kdnBeginFetchDate"  class="title-input input-w120" type="text" name="startFetchDate"    placeholder="开始日期" readonly>
                    </li>
                    <li class="input-item">--</li>
                    <li class="input-item">
                        <input id="userid"   name="userid"  type="hidden" value="${generaluser.userid}">
                        <input id="kdnEndFetchDate" class="title-input input-w120 " type="text"  name="endFetchDate"   placeholder="结束时间" readonly>
                    </li>

                    <li class="input-item">

                        <input type="hidden" value="1" name="pageNum"  id="pageNum"/>
                        <input type="hidden" value="10" name="pageSize"  id="pageSize"/>
                       &nbsp;  &nbsp; &nbsp;<input <%--class="title-input input-w120"--%> class="bb-button-query" value="查询" type="submit" id="query"/>
                    </li>

                </ul>
            </div>
        </form>

        <table>
            <tr>
                <th class="table-th">下单时间/订单号</th>
                <th class="table-th">发件人信息</th>
                <th class="table-th">收件人信息</th>
                <th class="table-th">物品类型</th>
                <th class="table-th">预约日期</th>
                <th class="table-th">开始时间</th>
                <th class="table-th">结束时间</th>
                <th class="table-th">预约状态</th>
                <th class="table-th">物流状态</th>
                <th class="table-th">操作</th>
                <th class="table-th">操作</th>
                <th class="table-th">操作</th>
            </tr>
            <tbody class="ordercontent">


            </tbody>
        </table>
        <div>
            <ul id="Pagination" class="pageNationSty">
                <div id="dataDiv"></div>
            </ul>
        </div>
    </div>
</div>
<!--显示详细框 start-->
<div class="kdn-details" style="display: none">

    <div class="login-details"  data-modal="close">
        <div class="u-modal-box">
            <div class="u-modal-hd">
                订单详情
                <span class="u-modal-close j_modal-close" data-modal="close"></span>
            </div>
        </div>

        <table class="table-details " >
            <tr>
                <th class="table-td1 b f14 td-scale50" style="width: 50%">订单编号</th>
                <th  class="table-td1 b f14 td-scale50" style="width: 50%" ></th>
            </tr>
            <tr>
                <td class="table-td1">订单编号：<span id="d_OrderCode"></span></td>
                <td class="table-td1">下单时间：<span id="d_CreateTime"></span></td>
            </tr>
            <tr>
                <td class="table-td1"></td>
                <td class="table-td1"></td>
            </tr>
        </table>
        <table class="table-details " >
            <tr>
                <th class="table-td1 b f14 td-scale50" style="width: 50%">发件人信息</th>
                <th  class="table-td1 b f14 td-scale50" style="width: 50%" >收件人信息</th>
            </tr>
            <tr>
                <td class="table-td1">发件人：<span id="d_SenderName"></span></td>
                <td class="table-td1">收件人：<span id="d_Name"></span></td>
            </tr>
            <tr>
                <td class="table-td1">电话：<span id="d_SenderMobile"></span></td>
                <td class="table-td1">电话：<span id="d_Mobile"></span></td>
            </tr>
            <tr>
                <td class="table-td1">地址：<span id="d_SenderAddress"></span></td>
                <td class="table-td1">地址：<span id="d_Address"></span></td>
            </tr>
            <tr>
                <td class="table-td1"></td>
                <td class="table-td1"></td>
            </tr>
        </table>
        <table class="table-details " >
            <tr>
                <th class="table-td1 b f14 td-scale50" style="width: 50%">货物信息</th>
                <th  class="table-td1 b f14 td-scale50" style="width: 50%" ></th>
            </tr>
            <tr>
                <td class="table-td1">货物名称：<span id="d_GoodName"></span></td>
                <td class="table-td1">保价信息：<span id="d_InsureFee"></span></td>
            </tr>
            <tr>
                <td class="table-td1">货物数量：1</td>
                <td class="table-td1"></td>
            <tr>
                <td class="table-td1"></td>
                <td class="table-td1"></td>
            </tr>
        </table>
        <table class="table-details " style="border-bottom:none" >
            <tr>
                <th class="table-td1 b f14 td-scale50" style="width: 50%">物流信息</th>
                <th  class="table-td1 b f14 td-scale50" style="width: 50%" ></th>
            </tr>
            <tr>
                <td class="table-td1">物流公司：<span id="d_ExpressName"></span></td>
                <td class="table-td1">运单类型：在线下单</td>
            </tr>
            <tr>
                <td class="table-td1">物流状态：<span id="d_OrderState"></span></td>
                <td class="table-td1">运单号：<span id="d_ExpNo"></span></td>
            </tr>
            <tr>
                <td class="table-td1"></td>
                <td class="table-td1"></td>
            </tr>
        </table>
    </div>
</div>

<!--显示详细框 end-->

<script src="${path}/js/common/jquery-3.3.1.min.js"></script>
<script src="${path}/js/api/common.js"></script>
<script  src="${path}/js/common/common.js"></script>
<script src="${path}/js/common/jquery_layer.js"></script>
<script src="${path}/js/api/jquery-powerFloat-min.js"></script>
<script src="${path}/js/api/city-picker.js"></script>
<script src="${path}/js/api/jquery.pagination.js"></script>
<script src="${path}/js/api/webchat.js"></script>
<script src="${path}/js/api/baiduwebsite.js"></script>
<script src="${path}/js/common/jquery_layer.js"></script>
<script src="${path}/js/common/jquery.form.js"></script>
<script src="${path}/js/common/laypage.js"></script>
<script src="${path}/js/api/toastr.min.js"></script>
<script src="${path}/js/api/jquery.jedate.js"></script>
<script src="${path}/js/orderReservationRecord.js"></script>
<script>

    /* (function () {
         $.post("http://www.kdniao.com/handler/JSInvoke.ashx?action=validateLogin", { UserID: window.localStorage["UID"], Token: window.localStorage["Token"] }, function (data) {
             if (!data || data.ReturnCode != 200) {
                 window.location.href = "./OnlineOrder.aspx";
             }
         }, "json");
     })();*/
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

    $(function () {
        var searchExpCode="";
        var searchState="";
        if (searchExpCode.length>0) {
            $("#kdnExpCode").val(searchExpCode);
        }
        if (searchState.length>0) {
            $("#kdnState").val(searchState);
        }
        var pageIndex = 0;
        var pageSize = 5;
        $("#prepage").click(function () {
            var curIndex = parseInt($("#curindex").text());
            if (curIndex > 1) {
                var preIndex = curIndex - 1;
                changePage(preIndex);
                $("#curindex").text(preIndex);
            }
        });
        $("#nextpage").click(function () {
            var curIndex = parseInt($("#curindex").text());
            var totalpage = parseInt($("#totalpage").text());
            if (curIndex < totalpage) {
                var preIndex = curIndex + 1;
                changePage(preIndex);
                $("#curindex").text(preIndex);
            }
        });
        //请求数据
        function changePage(pageIndex) {
            console.log($("#searchForm").serialize());
            $.ajax({
                type: "POST",
                dataType: "json",
                url: 'http://www.kdniao.com/handler/JSInvoke.ashx?action=PCLoadRecordData&' + $("#searchForm").serialize(),
                data: "key="+window.localStorage["Token"]+"&userID=" + window.localStorage["UID"] + "&pageIndex=" + pageIndex + "&pageSize=" + pageSize ,
                success: function(data) {
                    if (data && data.ResultList) {
                        var htmlStr = "";
                        for(var i=0;i<data.ResultList.length;i++)
                        {
                            var orderState="";
                            switch (data.ResultList[i].OrderState)
                            {
                                case "0":
                                    orderState = "未揽件";
                                    break;
                                case "1":
                                    orderState = "已揽件";
                                    break;
                                case "2":
                                    orderState = "在途";
                                    break;
                                case "3":
                                    orderState = "已签收";
                                    break;
                                case "4":
                                    orderState = "问题件";
                                    break;
                                default:
                                    break;
                            }
                            htmlStr+="<tr class=\"tr-item\">"+
                                "<td class=\"table-td \">"+data.ResultList[i].CreateTime+"<br><span class=\"table-btn-c\" req-expno='"+data.ResultList[i].ExpNo+"'>"+data.ResultList[i].KDNOrderCode+"</span>"+
                                "</td>"+
                                "<td class=\"table-td  table-td-l\">"+data.ResultList[i].Name+"<br>"+data.ResultList[i].Mobile+"</td>"+
                                "<td class=\"table-td \">"+data.ResultList[i].ExpressName+"</td>"+
                                "<td class=\"table-td \"><span class=\"table-btn-c\" req-expno='"+data.ResultList[i].ExpNo+"'>"+data.ResultList[i].ExpNo+"</span> </td>"+
                                "<td class=\"table-td \">"+orderState+"</td>"+
                                "<td class=\"table-td choice-btn \"><a class=\" table-btn-c \" req-expno='"+data.ResultList[i].ExpNo+"' href=\"javascript:void(0);\">订单详情</a></td>"+
                                "</tr>";
                        }
                        $(".ordercontent").empty();
                        $(".ordercontent").append(htmlStr);
                    }

                }
            });
        }
        //显示详细信息 start
        $(".table-btn-c").click(function () {
            //加载详细信息`
            $.post("http://www.kdniao.com/handler/JSInvoke.ashx?action=PCLoadOrderDetail", { userID: window.localStorage["UID"], key:window.localStorage["Token"], ExpNo: $(this).attr("req-expno") }, function (data) {
                console.log(data);
                if (data) {
                    for (item in data) {
                        if (item === "SenderAddress") {
                            $("#d_SenderAddress").text(data.SenderProvinceName + data.SenderCityName + data.SenderExpAreaName + data.SenderAddress);
                            continue;
                        }
                        if (item === "Address") {
                            $("#d_Address").text(data.ProvinceName + data.CityName + data.ExpAreaName + data.Address);
                            continue;
                        }
                        if (item === "OrderState") {
                            var _state = "";
                            switch (data.OrderState) {
                                case "0":
                                    _state = "未揽件";
                                    break;
                                case "1":
                                    _state = "已揽件";
                                    break;
                                case "2":
                                    _state = "在途中";
                                    break;
                                case "3":
                                    _state = "已签收";
                                    break;
                                case "4":
                                    _state = "问题件";
                                    break;
                                default:
                                    _state = "暂无状态";
                                    break;
                            }
                            $("#d_OrderState").text(_state);
                            continue;
                        }
                        $("#d_" + item).text(data[item]);
                    }
                    $(".kdn-details").css({ "width": $(".pe-content").width(), "height": $(".pe-content").height() });

                    $(".kdn-details").show();
                    //$(".kdn-content").hide();
                }
            }, "json");

        })
        $(".u-modal-close").click(function () {
            $(".kdn-details").hide();
            $(".kdn-content").show();
        })

    });
</script>
<script>
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
    DateUse("#kdnBeginFetchDate", "#kdnEndFetchDate");

</script>
<jsp:include page="../home/foot.jsp"/>


</body>
</html>