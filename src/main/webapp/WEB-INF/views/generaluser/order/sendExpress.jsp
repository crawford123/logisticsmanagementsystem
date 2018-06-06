<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 4/14/2018
  Time: 8:56 PM
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
    <title>当日寄件</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${path}/css/api/conmon.css">
    <link rel="stylesheet" href="${path}/css/api/postExpress.css">
    <link rel="stylesheet" href="${path}/css/common/bootstrap.css" type="text/css"/>
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
    <link rel="stylesheet" href="${path}/css/api/city-picker.css">
    <link href="${path}/css/api/dialog.css" rel="stylesheet" />
    <link href="${path}/css/api/toastr.min.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="${path}/css/common/bootstrap_fontawesome_layer.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/custom.css" type="text/css"/>
    <link href="${path}/css/api/toastr.min.css" type="text/css" rel="stylesheet" />
</head>
<body >
<jsp:include page="../home/head.jsp"/>
<div class="kdn-content" >
    <div class="pe-title" >
        <ul>
            <li class="pe-title-item pe-active" style="border-right:none; "><a>寄快递</a></li>
            <li class="pe-title-item"><a id="seeRecord">订单记录</a></li>
        </ul>
    </div>
    <!--寄快递 start-->
    <form id="orderForm" enctype="multipart/form-data">
        <div class="pe-content postExpress1">
            <div class="pe-up"></div>
            <div class="clearfix p-detail">
                <div class="pe-d-left ">
                    <ul>
                        <li class="b d-title" >寄件人信息</li>
                        <li class="pe-item">
                            <input class="pe-input" type="hidden"  name="userid" id="userid" value="${generaluser.userid}">
                            <input class="pe-input" type="hidden"  name="state" id="state" value="0">
                            <input class="pe-input" type="hidden"  name="shippername" id="shippername" value="超速物流">
                            <input type="hidden"   name="date" id="date">
                            <input type="hidden"   name="orderstate" id="orderstate" value="0">
                            <input class="btn5" type="text" validate-info="发件人姓名" name="sendername" placeholder="请输入真实姓名" maxlength="20" ></li>
                        <li class="pe-item">
                            <input class="btn5" type="text" validate-info="发件人手机号" name="senderphone"  placeholder="请输入手机号" maxlength="11" ></li>
                        <li class="pe-item p-re">
                            <input class="btn5 clearfix"  readonly type="text" validate-info="发件人省市区" name="senderlocation" value="" data-toggle="city-picker">
                        </li>
                        <li class="pe-item ">
                            <input class="btn5" type="text" validate-info="发件人详细地址" name="senderaddress" placeholder="请输入详细地址" maxlength="30" >
                        </li>
                    </ul>
                    <div style="border: 1px dashed #e5e5e5;height: 1px;margin-top:20px ;margin-bottom: 20px "></div>
                    <ul>
                        <li class="b d-title" >收件人信息</li>
                        <li class="pe-item">
                            <input class="btn5" type="text" validate-info="收件人姓名" name="receivername" placeholder="请输入真实姓名" id="txtExpName" maxlength="20"></li>
                        <li class="pe-item">
                            <input class="btn5" type="text" validate-info="收件人手机号" name="receiverphone" placeholder="请输入手机号" id="txtExpPhone" maxlength="11"></li>
                        <li class="pe-item p-re">
                            <input s class="btn5 clearfix"    readonly type="text" validate-info="收件人省市区" name="receiverlocation" value="" data-toggle="city-picker">
                        </li>
                        <li class="pe-item ">
                            <input class="btn5" type="text" validate-info="收件人详细地址" name="receiveraddress" placeholder="请输入详细地址" maxlength="30">
                        </li>
                    </ul>
                </div>
                <div class="pe-d-right ">
                    <ul>
                        <li class="b d-title" >物品信息</li>
                        <li class="pe-d-r-item" >物品类型：&nbsp;&nbsp;&nbsp;
                            <input name="goodsname"  type="radio" checked value="0">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            服饰&nbsp;
                            <input   name="goodsname"  type="radio" value="1" >&nbsp;&nbsp;&nbsp;
                            食品&nbsp;
                            <input   name="goodsname"  type="radio" value="2" >&nbsp;&nbsp;&nbsp;
                            数码用品&nbsp;
                            <br>
                            <input   name="goodsname"  type="radio" value="3" >&nbsp;&nbsp;&nbsp;
                            生活用品&nbsp;
                            <input   name="goodsname"  type="radio" value="4" >&nbsp;&nbsp;&nbsp;
                            文件&nbsp;
                            <input   name="goodsname"  type="radio" value="5" >&nbsp;&nbsp;&nbsp;
                            其它&nbsp;
                        </li>
                        <br>
                        <li class="pe-d-r-item" >物品描述
                        <div class="form-group">
                            <textarea class="form-control" placeholder="请描述你的物品~" id="goodsdesc"  validate-info="物品描述信息"  name="goodsdesc" rows="3"></textarea>
                        </div>
                        <li class="pe-d-r-item" >数<span style="visibility:hidden">空格</span>量： &nbsp;&nbsp;&nbsp;
                            <input class="pe-input" type="text"  name="goodsquantity" id="goodsquantity" validate-info="物品数量" maxlength="3" onkeyup="ClearNoNum(this);">个&nbsp;&nbsp;&nbsp;
                        </li>
                        <li class="pe-d-r-item" >总重量： &nbsp;&nbsp;&nbsp;
                            <input class="pe-input" type="text" maxlength="4" name="goodsweight"  id="goodsweight" validate-info="物品重量" onkeyup="ClearNoNum(this);">kg&nbsp;&nbsp;&nbsp;
                        </li>
                        <li class="pe-d-r-item" >物品图片： &nbsp;&nbsp;&nbsp;<br/>
                            <input type="file" class="btn-file" id="file" validate-info="物品图片"  name="file"/>
                        </li>
                    </ul>
                     <ul>
                         <li class="b d-title" >其余信息</li>
                         <li class="pe-d-r-item" >备<span style="visibility:hidden">空格</span>注： &nbsp;&nbsp;&nbsp;
                             <input class="pe-input" type="text"  name="remark">&nbsp;&nbsp;&nbsp;
                         </li>
                         <li class="pe-d-r-item" >支付方式：&nbsp;&nbsp;&nbsp;
                             在线支付
                             <input name="paytype" id="paytype" type="radio" checked value="0">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                             现金支付
                             <input   name="paytype"  id="paytypes" type="radio" value="1" >&nbsp;&nbsp;&nbsp;
                         </li>

                         <li class="pe-d-r-item">运<span style="visibility:hidden">空格</span>费： &nbsp;&nbsp;&nbsp;
                             <input class="pe-input" type="text" maxlength="4" name="cost" id="cost" readonly  validate-info="运费" onkeyup="ClearNoNum(this);">元&nbsp;&nbsp;&nbsp;
                         </li>
                     </ul>

                </div>
            </div>
            <div class="pe-content-d-btn clearfix">
                <input id="knext" type="button" class="btn1 pe-c-btn" value="下一步" onclick="knexts()"/>
            </div>
        </div>
    </form>
    <!--寄快递 end-->

    <!--寄快递点击下一页进入选择页面 start-->
    <div  class="pe-content postExpress2" style="display: none">
        <table>
            <thead>
            <tr>
                <th class="table-th table-item1">快递公司</th>
                <th class="table-th table-item2">预计到达时间</th>
                <th class="table-th table-item3">预计价格</th>
                <th class="table-th table-item4">其他</th>
                <th class="table-th table-item5">选择您发的物流公司</th>
            </tr>
            </thead>
            <tbody id="autoselectexp">
            </tbody>

        </table>
    </div>
    <!--寄快递点击下一页进入选择页面 end-->
    <!--订单成功与否提示框 start-->
    <!--成功-->
    <div class="pe-content tip-su" style="display:none">
        <div class="pe-tips tips-success">
            <h3>订单提交成功！</h3>
            <ul>
                <li class="pe-tips-item">快递员已接收到您的订单，预计在2小时之内联系您并上门揽件。<br>
                    您也可以通过 <a class="g3" href="javascript:;">订单记录查询快递网点/快递员联系方式</a>，主动联系他们沟通</li>
                <li class="mt30">
                    <a class="table-btn btn-default2 active" id="lookRecord">查看订单记录</a>
                    <a class="table-btn btn-default2 active" id="sendorder">继续发件</a>
                </li>
            </ul>
        </div>
    </div>
    <!--订单成功与否提示框 end-->
    <jsp:include page="../home/foot.jsp"/>
</div>
<!--登录框 end-->
<script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
<script src="${path}/js/api/city-picker.js"></script>
<script src="${path}/js/api/toastr.min.js"></script>
<script src="${path}/js/common/jquery_layer.js"></script>
<script  src="${path}/js/common/common.js"></script>
<script src="${path}/js/api/OnlineOrder.js"></script>

<script>
    var path = '${path}';
    $("#goodsweight").blur(function(){
        var goodsweight=$("#goodsweight").val();
        if(goodsweight<1){
            $("#cost").val(6);
        }else{
            var cost=6+(goodsweight-1)*3;
            $("#cost").val(cost);
        }
    });
    window.onload = function(){
        window.setInterval(function(){
            document.getElementById("date").value=CurentTime();
        }, 1000);
    }
</script>
</body>
</html>