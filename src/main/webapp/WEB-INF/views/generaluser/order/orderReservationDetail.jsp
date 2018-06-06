<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 4/14/2018
  Time: 12:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("path", path);
%>

<html xmlns="http://www.w3.org/1999/xhtml" class="root61"><head>
    <script async="" src="https://joycenter.jd.com/msgCenter/init.action?callback=jQuery4657922&amp;_=1523634850724"></script>
    <title>订单详情页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <meta name="format-detection" content="telephone=no">
    <style type="text/css" abt="234"></style><script type="text/javascript">
    window.pageConfig={
        compatible:true
    };
</script>
    <link rel="stylesheet" type="text/css" href="${path}/css/st/global.css" />
    <link rel="stylesheet" type="text/css" href="${path}/css/st/common.css" />
    <link rel="stylesheet" href="${path}/css/orderdetail/base.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/orderdetail/global.css" type="text/css"/>
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
    <script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="//misc.360buyimg.com/jdf/??lib/jquery-1.6.4.js,1.0.0/unit/base/5.0.0/base.js"></script>

    <script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
    <script  src="${path}/js/orderReservationDetail.js"></script>
    <script>
        var path = '${path}';
    </script>
</head>
<body myjd="_MYJD_ordercenter" style="">

<jsp:include page="../home/head.jsp"/>
<!--shortcut start-->
<div id="o-header-2013">
    <div id="header-2013" style="display:none;"></div></div>

<!-- main -->
<div id="container">
    <div class="w">
        <div class="main">
            <!--变量-->
            <span id="pay-button-order" style="display:none"></span>            <div class="m order-state order-state01 order-state02">
            <div class="mc state-cont">
                <!-- 工具条 -->
                <div class="state-lcol">
                    <input type="hidden" value="${orderreservations.id}" name="id" id="orderid"/>
                    <div class="state-top">订单号：${orderreservations.ordercode}</div>
                    <h3 class="state-txt ftx-02" id="state">${orderreservations.state}</h3>
                    <br>
                    <h3>预约状态：<span id="reservestate">${orderreservations.reservestate}</span></h3>
                    <h3>预约日期：${orderreservations.fetchdate}</h3>
                    <h3>开始时间：${orderreservations.fetchstarttime}</h3>
                    <h3>结束时间：${orderreservations.fetchendtime}</h3>


                    <span class="remain-time" style="display: none"><b></b></span>
                    <div class="state-btns">
                        <a id="pay-button-71393499341" class="btn-1 " style="display:none" href="#none">付款</a>
                    </div>
                    <div class="state-bottom">
                        <a class="btn-del hide" href="#none" clstag="click|keycount|orderinfo|xqquxiaodingdan">
                            <b></b>
                            取消订单
                        </a>
                    </div>
                </div>

                <!-- 进度条 -->
                <div class="state-rcol">
                    <!--进度条 -->

                    <div id="process-04" class="order-process">
                        <div class="node" id="submitReady"><i class="node-icon icon-start"></i><ul><li class="txt1">&nbsp;</li><li class="txt2">提交订单</li><li id="track_time_0" class="txt3">${orderreservations.date}</li></ul></div>
                        <div class="proce" id="payDone"><ul><li class="txt1"></li></ul></div>
                        <div class="node" id="payReady"><i class="node-icon icon-pay"></i><ul><li class="txt1">&nbsp;</li><li class="txt2"><div id="payResult">付款成功</div></li><li id="track_time_4" class="txt3"></li></ul></div>
                        <div class="proce" id="acceptDone"><ul><li class="txt1">&nbsp;</li></ul></div>
                        <div class="node" id="acceptReady"><i class="node-icon icon-store"></i><ul><li class="txt1">&nbsp;</li><li class="txt2">已揽件</li><li id="track_time_1" class="txt3"></li></ul></div>
                        <div class="proce" id="roadDone"><ul><li class="txt1">&nbsp;</li></ul></div>
                        <div class="node" id="roadReady"><i class="node-icon icon-express"></i><ul><li class="txt1">&nbsp;</li><li class="txt2">在途中</li><li id="track_time_5" class="txt3"></li></ul></div>
                        <div class="proce" id="receiveDone"><ul><li class="txt1">&nbsp;</li></ul></div>
                        <div class="node" id="receiveReady"><i class="node-icon icon-finish"></i><ul><li class="txt1">&nbsp;</li><li class="txt2">已签收</li><li id="track_time_6" class="txt3"></li></ul></div>
                    </div>

                </div>




            </div>
            <div class="mb"></div>
        </div>
            <!-- 订单跟踪及安装跟踪 -->
            <input type="hidden" value="2018-01-17 10:16:19" id="datesubmit-71393499341">
            <!--  /widget/order-track/order-track.tpl -->
            <div class="order-track order-track-02 m">
                <div class="mt">
                    <div class="track-tab">
                        <ul>
                            <li class="tab-item curr" style="display:none;">
                                订单跟踪
                            </li>
                            <li class="tab-item" style="display:none;">安装跟踪</li>
                        </ul>
                    </div>
                </div>
                <!-- 订单跟踪 -->
                <div class="mc">
                    <div class="track-cont J-delivery-track">
                        <div class="track-lcol">
                            <div class="p-item">
                                <div class="p-img">
                                    <img src="${path}/img/${orderreservations.goodsphoto}" width="100%" height="100%">
                                </div>
                                <div class="p-info">
                                    <ul>

                                        <li>
                                            快递公司：${orderreservations.shippername}
                                        </li>
                                     <%--   <li>订单状态：<span id="orderstate">${orderreservations.orderstate}</span></li>--%>
                                        <li>货运单号：<span id="logisticcode">${orderreservations.logisticcode}</span></li></ul>
                                </div>
                            </div>
                            <div class="ac" style="display:none">
                                <a href="#none" class="btn-9 hide">查看地图</a>
                            </div>
                        </div>
                        <div class="track-rcol">
                            <div class="track-list track-list-date">
                                <ul class="track-list" id="trackList">

                                    <%--  <li class="afterdate first"><i class="node-icon"></i>
                                          <span class="date">
                                          </span>
                                          <span class="txt">暂无任何订单轨迹信息！！</span>
                                      </li>--%>

                                </ul>
                            </div>
                        </div>
                        <div class="track-rup" style="">
                            <a class="track-man" href="#none" style="display: none">
                                <img src="#none" class="track-man-icon">
                                <span>配送员</span>
                            </a>
                        </div>
                        <div class="clr"></div>

                        <div class="gis-box" style="display:none">
                            <b class="gis-arr"></b>
                        </div>

                    </div>
                    <!-- 安装跟踪 -->
                    <div class="track-cont J-install-track" style="display:none">
                        <div class="track-lcol">
                            <div class="install-list" id="install-scrollbar">

                            </div>
                        </div>
                        <div class="track-rcol">
                            <div class="track-list track-list-date">
                                <ul>

                                </ul>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
            <div class="m order-info-mod">
                <div class="order-info mc">
                    <div class="ui-switchable-body">
                        <div class="ui-switchable-panel-main">
                            <div class="ui-switchable-panel">
                                <!-- 收货人信息 -->
                                <div class="dl">
                                    <div class="dt">

                                        <h4>发货人信息
                                        </h4>

                                    </div>
                                    <div class="dd">
                                        <div class="item">

                            <span class="label">
						发货人：
					</span>
                                            <div class="info-rcol">
                                                ${orderreservations.sendername}

                                            </div>
                                        </div>
                                        <div class="item">
					<span class="label">
                        省/市/区：
					</span>
                                            <div class="info-rcol">
                                                ${orderreservations.senderlocation}
                                            </div>
                                        </div>

                                        <div class="item">
                    <span class="label">
                       详细地址：
                    </span>
                                            <div class="info-rcol">
                    	<span class="info-rcol">
                            ${orderreservations.senderaddress}
                        </span>
                                            </div>
                                        </div>


                                        <div class="item">
					<span class="label">
						手机号码：
					</span>
                                            <div class="info-rcol" >
                                                ${orderreservations.senderphone}
                                            </div>
                                        </div>


                                    </div>
                                </div>                    <!-- 配送信息 -->
                                <div class="dl">
                                    <div class="dt">
                                        <h4>收获人信息</h4>
                                    </div>
                                    <div class="dd">

                                        <div class="item">
                <span class="label">
                   收货人：
                </span>
                                            <div class="info-rcol">
                                                ${orderreservations.receivername}
                                            </div>
                                        </div>


                                        <div class="item">
                    <span class="label">
                       省/市/区：
                    </span>
                                            <div class="info-rcol">
                    	<span class="info-rcol">
                            ${orderreservations.receiverlocation}
                        </span>
                                            </div>
                                        </div>
                                        <div class="item">
                    <span class="label">
                       详细地址：
                    </span>
                                            <div class="info-rcol">
                    	<span class="info-rcol">
                            ${orderreservations.receiveraddress}
                        </span>
                                            </div>
                                        </div>

                                        <div class="item">
                    <span class="label">
                       手机号码：
                    </span>
                                            <div class="info-rcol">
                    	<span class="info-rcol">
                            ${orderreservations.receiverphone}
                        </span>
                                            </div>
                                        </div>




                                    </div>
                                </div>                    <!-- 付款信息 -->
                                <!-- 非0费用-->
                                <div class="dl">
                                    <div class="dt">
                                        <h4>付款信息</h4>
                                    </div>
                                    <div class="dd">
                                        <div class="item">
					<span class="label">
						付款方式：
					</span>
                                            <div class="info-rcol" id="paytype">${orderreservations.paytype}</div>

                                        </div>

                                        <div class="item">
					<span class="label">
						付款时间：
					</span>
                                            <div class="info-rcol">
                                                ${orderreservations.date}
                                            </div>
                                        </div>
                                        <div class="item">
    						<span class="label">
    							运费
    						</span>
                                            <div class="info-rcol">
    							<span class="f-price">
                                    ${orderreservations.cost}
                                </span>
                                            </div>
                                        </div>

                                        <div class="item">
    						<span class="label">
    							订单备注
    						</span>
                                            <div class="info-rcol">
    							<span class="f-price">
                                    ${orderreservations.remark}
                                </span>
                                            </div>
                                        </div>

                                    </div>


                                </div>
                                <div class="dl">
                                    <div class="dt">
                                        <h4>物品信息</h4>
                                    </div>
                                    <div class="dd">
                                        <div class="item">
					<span class="label">
                        物品名称
					</span>
                                            <div class="info-rcol" id="goodsname">${orderreservations.goodsname}</div>

                                        </div>

                                        <div class="item">
					<span class="label">
                         物品数量
					</span>
                                            <div class="info-rcol">
                                                ${orderreservations.goodsquantity}个
                                            </div>
                                        </div>
                                        <div class="item">
    						<span class="label">
    							 物品重量
    						</span>
                                            <div class="info-rcol">
    							<span class="f-price">
                                    ${orderreservations.goodsweight}kg
                                </span>
                                            </div>
                                        </div>

                                        <div class="item">
    						<span class="label">
    							 物品描述
    						</span>
                                            <div class="info-rcol">
    							<span class="f-price">
                                    ${orderreservations.goodsdesc}
                                </span>
                                            </div>
                                        </div>


                                    </div>

                                </div>


                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <!--/ /widget/order-goods/order-goods.tpl -->                        <!--常见问题-->
            <!--  /widget/ui-slidebar/ui-slidebar.tpl -->
            <div class="ui-slidebar" clstag="click|keycount|orderinfo|xqchangjianwenti">
                <div class="dl">

                    <div class="dd">
                        <ul>
                            <li class="">
                                <div class="service-txt"><a href="#none" class="problem"></a><b></b></div>
                                <div class="service-cont problem-cont">
                                    <div class="problem-top">
                                        <h5>常见问题</h5>
                                        <a href="#none" class="close">x</a>
                                    </div>
                                    <div class="problem-list">
                                        <a href="//help.jd.com/user/issue/102-250.html">1、我的包裹几天可以收到？</a>
                                        <a href="//help.jd.com/user/issue/103-983.html">2、我的地址都支持什么配送服务？</a>
                                        <a href="//help.jd.com/user/issue/108-385.html">3、订单签收异常了怎么办？</a>
                                        <a href="//help.jd.com/user/issue/75-244.html">4、下单后可以修改订单吗？</a>
                                        <a href="//help.jd.com/user/issue/100-1014.html">5、自提点位置如何查询？</a>
                                        <a href="//help.jd.com/user/index.html" class="more">更多问题&nbsp;&gt;</a>

                                    </div>
                                </div>
                            </li>

                            <li>
                                <div class="service-txt" id="wx-qrcode"><a href="#none" class="service"></a><b></b></div>
                                <div class="service-cont">
                                    <h4>微信扫描随时随地查订单</h4>
                                    <img src="//misc.360buyimg.com/user/myjd-2015/css/i/loading.gif" alt="">

                                </div>
                            </li>
                            <li>
                                <a href="//surveys.jd.com/index.php?r=survey/index/sid/682448/lang/zh-Hans" class="feedback"></a>
                            </li>
                            <li>
                                <a href="#none" class="backtop"></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!--/ /widget/ui-slidebar/ui-slidebar.tpl -->        </div>
    </div>
</div>
<!-- /main -->


<jsp:include page="../home/foot.jsp"/>

<!--footer end-->

<script type="text/javascript" src="//static.360buyimg.com/im/js/im_icon.js" charset="gb2312"></script>



</body>


</html>
