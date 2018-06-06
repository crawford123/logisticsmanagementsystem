<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 4/29/2018
  Time: 5:30 PM
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
    <title>免费预约上门取件</title>
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
    <link rel="stylesheet" href="${path}/css/api/toastr.min.css" type="text/css" />
    <link rel="stylesheet" href="${path}/css/st/StyleSheet1.css" type="text/css"/>




    <script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
    <script  src="${path}/js/st/city-picker.data.js"></script>
    <script  src="${path}/js/st/city-picker.js"></script>
    <script  src="${path}/js/st/common6db1.js"></script>
    <script  src="${path}/js/st/idangerous.swiper.min.js"></script>
    <script  src="${path}/js/st/jquery.cookie.js"></script>
    <script  src="${path}/js/st/jquery.min.js"></script>
    <script  src="${path}/js/st/jquery.page.js"></script>
    <script  src="${path}/js/st/jquery.tmpl.min.js"></script>
    <script  src="${path}/js/st/jquery-1.102.js"></script>
    <script  src="${path}/js/st/selectUi.js"></script>
    <script src="${path}/js/common/jquery_layer.js"></script>
    <script  src="${path}/js/common/common.js"></script>
    <script  src="${path}/js/st/Time.js"></script>
    <script src="${path}/js/api/toastr.min.js"></script>
    <script  src="${path}/js/st/Order.js"></script>
    <script>
        var path = '${path}';

        window.onload = function(){
            window.setInterval(function(){
                $("#date").val(CurentTime());
            }, 1000);
        }
    </script>
</head>
<body>

<jsp:include page="../home/head.jsp"/>
<div class="box">
    <div class="content">
        <div class="inside_banner_service">
        </div>
        <div class="inside_cont_box">
            <div class="cont_page clearfix">
                <div class="left_module fl">
                    <div class="left_nav_title mt40">寄件须知</div>
                    <ul class="left_careful">
                        <li class="no_send"><a href="">禁寄物品</a></li>
                        <li class="careful"><a href="">注意事项</a></li>
                    </ul>
                </div>
                <div class="group_module fr">
                    <form id="form" method="post" enctype="multipart/form-data">
                        <div class="search_order service_box">
                            <input type="hidden"  name="userid" id="userid" value="${generaluser.userid}">
                            <input class="pe-input" type="hidden"  name="state" id="state" value="0">
                            <input type="hidden"   name="date" id="date">
                            <input type="hidden"   name="reservestate" id="reservestate" value="0">
                            <input type="hidden" id="TakeCompanyCode" name="TakeCompanyCode" value="">
                            <div class="type_title">寄件人信息</div>
                            <div class="form_group">
                                <div class="inline_group">
                                    <label><span class="sto_red">*</span>寄件地址</label>
                                    <div class="area_box">
                                        <input id="senderlocation" name="senderlocation" class="w300 city-picker-input" validate-info="发件人省市区"  type="text" data-toggle="city-picker" placeholder="请选择省市区"  readonly>
                                    </div>
                                </div>
                                <div class="inline_group ml70">
                                    <label><span class="sto_red">*</span>详细地址</label>
                                    <input class="w300" type="text" id="senderaddress" name="senderaddress" validate-info="发件人详细地址" placeholder="请填写详细地址（例如XX路，XX号）"  maxlength="20">
                                </div>
                            </div>
                            <div class="form_group">
                                <div class="inline_group">
                                    <label><span class="sto_red">*</span>真实姓名</label>
                                    <input class="w300" type="text" placeholder="请输入寄件人真实姓名" id="sendername" name="sendername" validate-info="发件人真实姓名" value="" maxlength="15">
                                </div>
                                <div class="inline_group ml70">
                                    <label><span class="sto_red">*</span>手机号码</label>
                                    <input class="w300" type="text" placeholder="请输入发件人手机号" id="senderphone" name="senderphone" validate-info="发件人手机号"  value="" maxlength="11">
                                    <span class="sto_red" style="width:10px;" id="_Y_N_SenderPhone"></span>
                                </div>
                            </div>
                            <div class="search_order service_box">
                                <div class="type_title">收件人信息</div>
                                <div class="form_group">
                                    <div class="inline_group">
                                        <label><span class="sto_red">*</span>收件地址</label>
                                        <div class="area_box">
                                            <input id="receiverlocation" validate-info="收件人省市区" name="receiverlocation" class="w300 city-picker-input" type="text" data-toggle="city-picker" placeholder="请选择省市区"  >
                                        </div>
                                    </div>
                                    <div class="inline_group ml70">
                                        <label><span class="sto_red">*</span>详细地址</label>
                                        <input class="w300" type="text" placeholder="请填写详细地址（例如XX路，XX号）" id="receiveraddress" validate-info="收件人详细地址" name="receiveraddress"  maxlength="20">
                                    </div>
                                </div>
                                <div class="form_group">
                                    <div class="inline_group">
                                        <label><span class="sto_red">*</span>真实姓名</label>
                                        <input class="w300" type="text" placeholder="请输入收件人真实姓名" id="receivername" validate-info="收件人姓名" name="receivername"   maxlength="15">
                                    </div>
                                    <div class="inline_group ml70">
                                        <label><span class="sto_red">*</span>手机号码</label>
                                        <input class="w300" type="text" placeholder="请输入收件人手机号" id="receiverphone" validate-info="收件人手机号" name="receiverphone" maxlength="11">
                                        <span class="sto_red" style="width:auto" id="_Y_N_AcceptPhone"></span>
                                    </div>
                                </div>
                            </div>
                            <div class="search_order service_box">
                                <div class="type_title">物品信息</div>
                                <%--<div class="form_group">
                                    <input type="button" value="违禁品须知" class="btn btn-search" style="margin-left:450px" id="orderInstruction2">
                                </div>--%>
                                <br/>
                                <div class="form_group">
                                    <div class="inline_group">
                                        <label><span class="sto_red">&nbsp;</span>物品类型：</label>
                                        <div class="praise_type" style="display: inline-block">
                                            <label class="f-radio">
                                                <input class="icon-radio" value="0" name="goodsname" type="radio"/>
                                                <span>服饰</span>
                                            </label>
                                            <label class="f-radio" >
                                                <input class="icon-radio" value="1" name="goodsname" type="radio"></input>
                                                <span>食品</span>
                                            </label>
                                            <label class="f-radio" >
                                                <input class="icon-radio" value="2" name="goodsname" type="radio"></input>
                                                <input class="icon-radio" name="shippername" id="shippername" type="hidden" value="超速物流"></input>
                                                <span>数码用品</span>
                                            </label>
                                            <label class="f-radio" >
                                                <input class="icon-radio" value="3" name="goodsname" type="radio"></input>
                                                <span>生活用品</span>
                                            </label>
                                            <label class="f-radio">
                                                <input class="icon-radio" value="4" name="goodsname" type="radio"></input>
                                                <span>文件</span>
                                            </label>
                                            <label class="f-radio">
                                                <input class="icon-radio" value="5" name="goodsname" type="radio"></input>
                                                <span>其它</span>
                                            </label>
                                            <label class="f-radio checked">
                                                <span>物品描述信息：</span>
                                                <input style="width:260px" placeholder="请输入物品描述信息"   name="goodsdesc" id="goodsdesc"  validate-info="物品描述信息"   type="text" onblur="ItemType2( $( '#other' ).val() )">
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form_group">

                                    <div class="inline_group ml70" style="margin-left:0px">
                                        <label><span class="sto_red">&nbsp;</span>物品图片</label>
                                        <input type="file" class="btn-file" id="file" validate-info="物品图片" id="file"  name="file"/>                                    </div>
                                     <span class="sto_red" ></span>

                                    <div class="inline_group ml70" style="margin-left:56px;">
                                        <label><span class="sto_red">&nbsp;</span>数量</label>
                                        <input class="w300" type="text" placeholder="数量为整数" validate-info="物品数量" id="goodsquantity" name="goodsquantity"  onkeyup="ClearNoNum(this);" ><span>个</span>
                                    </div>
                                </div>
                                <div class="form_group">

                                    <div class="inline_group ml70" style="margin-left:0px">
                                        <label><span class="sto_red">&nbsp;</span>预估重量</label>
                                        <input class="w300 " type="text" placeholder="重量为整数，且不得大于50kg" validate-info="物品重量" id="goodsweight" width="150" name="goodsweight" onkeyup="ClearNoNum(this);" maxlength="5"><span>kg</span>
                                    </div>
                                    <span class="sto_red" style="width:10px" id="_Y_N_Articleweight"></span>

                                    <div class="inline_group ml70" style="margin-left:56px;">
                                        <label><span class="sto_red">&nbsp;</span>预估运费</label>
                                        <input class="w300" type="text" placeholder="预估运费" id="cost" name="cost" readonly><span>元</span>
                                    </div>
                                </div>

                                <div class="form_group">
                                    <div class="inline_group">
                                        <label><span class="sto_red">&nbsp;</span>支付方式</label>
                                        <div class="praise_type" style="display: inline-block">
                                            <label class="f-radio">
                                                <input class="icon-radio" value="0" name="paytype" type="radio" checked/>
                                                <span>在线支付</span>
                                            </label>
                                            <label class="f-radio">
                                                <input class="icon-radio" value="1" name="paytype" type="radio"/>
                                                <span>现金支付</span>
                                            </label>
                                        </div>
                                    </div>
                                </div>

                                <div class="form_group">

                                </div>
                            </div>
                            <div class="search_order service_box">
                                <div class="type_title">其他信息</div>
                                <div class="form_group">
                                    <div class="inline_group">
                                        <label><span class="sto_red">&nbsp;</span>取件时间</label>
                                        <input class="w200" type="text" placeholder="请选择快递员上门取件日期" id="fetchdate" name="fetchdate" validate-info="请选择快递员上门取件日期"  readonly value="">
                                        <span class="sto_red" style="width:auto">:</span>
                                    </div>
                                    <div class="inline_group">
                                        <input id="fetchstarttime" name="fetchstarttime" placeholder="选择开始时间" validate-info="请选择开始时间"  class="w160" readonly type="text">
                                        <span class="sto_red" style="width:auto">-</span>
                                    </div>
                                    <div class="inline_group">
                                        <input id="fetchendtime" name="fetchendtime" placeholder="选择结束时间" validate-info="选择结束时间" class="w160" readonly type="text">
                                        <span style="color:#ff0000">我们上门取件的时间一般为下午3-6点</span>
                                    </div>
                                </div>
                                <div class="form_group">
                                    <div class="inline_group">
                                        <label><span class="sto_red">&nbsp;</span>备注</label>
                                    </div>
                                    <div class="inline_group">
                                        <textarea style="width: 776px" placeholder="您可以在此备注您的需求,例如:请带文件袋,来前电话,需要胶带等需求!" id="remark" name="remark" maxlength="25"></textarea>
                                    </div>
                                </div>
                            </div>
                            <div style="margin-top:40px">
                                <input id="Submit1" type="button" class="btn btn_search" onclick="return submitForm()" value="提交订单">
                            </div>


                        </div>
                    </form>
                    <div class="layer-shade" style="display: none">
                        <div class="layer-box fadeIn" style="position: relative">
                            <div class="search_cont" style="display: block">
                                <div class="search_cont_top layer-top">
                                    <p class="layer-title">
                                        <span class="layer-back"><a href="javascript:void(0)"></a></span>
                                        周边可下单网点
                                        <span class="layer-close"><a href="javascript:void(0)"></a></span>
                                    </p>
                                </div>
                                <div class="search_cont_cont layer-center">
                                    <div class="net_count clearfix">
                                        <div class="count-data fl">共查询到&nbsp;<span style="font-size:14px;" id="organizeCount"></span>&nbsp;家分公司</div>
                                        <div class="net_a_courier fr">
                                            <ul>
                                                <li class="active">网点公司</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="net_list net_courier show">
                                        <div id="organizeList" class="net_list_tmp"></div>
                                        <div class="tcdPageCode" id="tcdPageCode"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>


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

        $("#goodsweight").blur(function(){
            var weight=$("#goodsweight").val();
            if(weight<1){
                $("#cost").val(6);
            }else{
                var cost=6+(weight-1)*3;
                $("#cost").val(cost);
            }
        });

    </script>


</div>

<jsp:include page="../home/foot.jsp"/>
</body>
</html>
