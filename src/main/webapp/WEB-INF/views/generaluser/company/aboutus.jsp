<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 4/26/2018
  Time: 9:13 PM
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
    <title>关于我们页面</title>
    <script async="" src="https://www.googletagmanager.com/gtm.js?id=GTM-TRTH8KL"></script>
    <script src="//hm.baidu.com/hm.js?32464c62d48217432782c817b1ae58ce"></script>
    <link rel="stylesheet" href="${path}/css/st/base.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/sf/main.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/st/content.css" type="text/css"/>
  <%-- <link href="${path}/css/st/news.css" rel="stylesheet">--%>
    <link rel="stylesheet" type="text/css" href="${path}/css/st/global.css">
    <link rel="stylesheet" type="text/css" href="${path}/css/st/common.css">
    <script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
    <script  src="${path}/js/sf/jquery-1.11.3.js"></script>
</head>
<body>
<jsp:include page="../home/head.jsp"/>

<div id="container" class="about_us_list">
    <div id="about_us_banner"><div class="t_banner">
        <img src="${path}/img/logistics3.jpg" class="banner_img">
        <div class="banner_bg"><div class="banner_title"></div></div>
    </div>
    </div>
    <div class="brief-introduction">
        <div id="about_us_center">
            <div>
            <div class="brief-title"style="font-size:xx-large;font-style:italic">超速物流公司</div>
            <div class="content">
                <div class="the-left">
                    <p class="first">
                    </p><p class="first">2018年，超速物流公司诞生于广东珠海。自成立以来，超速物流公司始终专注于服务质量的提升，持续加强基础建设，积极研发和引进具有高科技含量的信息技术与设备以提升作业自动化水平，在国内外建立了庞大的信息采集，市场开发，物流配送，快件收派等速运业务机构及服务网络。</p>
                    <p class="first">&nbsp;</p>
                    <p class="first">在持续强化速运业务的基础上，超速物流公司坚持以客户需求为核心，积极拓展多元化业务，针对电商，食品，医药，汽配，电子等不同类型客户开发出一站式供应链解决方案，并提供支付，融资，理财，保价等综合性的金融服务。与此同时，依托强大的物流优势，我们成立超速物流公司优选，为客户提供品质生活服务，打造超速物流公司优质生活体验。</p>
                    <p class="first">&nbsp;</p>
                    <p class="first">多年来，超速物流公司持续创新，不断铸造高品质服务体验，为客户成功提供坚实有力的支持。</p><p></p>
                </div>
                <div class="the-right">
                    <div class="sub-title"> 进一步了解我们,有合作意向,请联系我们</div>
                    <div class="double-link">
                        <a href="http://ocs2-idp.sf-express.com/dt_chat/index.action?channelId=25&amp;clientType=1" target="_blank">
                            联系在线客服<span></span></a>
                        <a href="../cooperative_consultation/" class="last"> 合作咨询<span></span></a>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </div>
</div>
</div>


<div class="footer">
    <div class="footer_cont clearfix">
        <div class="left_group fl">
            <h2>客服热线</h2>
            <h1>95543</h1>
            <ul class="code_group">
                <li>
                    <img src="${path}/img/st/icon_wechat1.png" width="48" height="48">
                    <div class="mask_code">
                        <div class="tooltip-arrow"></div>
                        <img src="${path}/img/st/chat_code.jpg">
                    </div>
                </li>
                <li>
                    <img src="${path}/img/st/icon_qq1.png" width="48" height="48">
                    <div class="mask_code">
                        <div class="tooltip-arrow"></div>
                        <img src="${path}/img/st/qq_code.png">
                    </div>
                </li>
                <li>
                    <img src="${path}/img/st/icon_pay1.png" width="48" height="48">
                    <div class="mask_code">
                        <div class="tooltip-arrow"></div>
                        <img src="${path}/img/st/pay_code.png">
                    </div>
                </li>
                <li>
                    <img src="${path}/img/st/icon_sina1.png" width="48" height="48">
                    <div class="mask_code">
                        <div class="tooltip-arrow"></div>
                        <img src="${path}/img/st/sina_code.jpg">
                    </div>
                </li>
            </ul>
        </div>
        <div class="right_group fr">
            <ul>
                <li>
                    <h4 href="/About/Index">关于超速物流</h4>
                    <div class="ul_list">
                        <div class="li"><a href="${path}/index/toAboutUs">超速物流简介</a></div>
                        <div class="li"><a href="${path}/order/toSendExpress">当日寄件</a></div>
                        <div class="li"><a href="${path}/orderReservation/toOrderReservation">免费预约上门取件</a></div>
                        <div class="li"><a href="${path}/voicemail/toVoicemail">投诉与反馈</a></div>
                        <div class="li"><a href="${path}/order/toOrderRecord">当日寄件记录</a></div>
                        <div class="li"><a href="${path}/orderReservation/toOrderReservationRecord">订单预约记录</a></div>
                    </div>
                </li>
                <li>
                    <h4 href="/Service/Index">公司资讯</h4>
                    <div class="ul_list">
                        <div class="li"><a href="${path}/news/toNews">公司动态</a></div>
                        <div class="li"><a href="${path}/news/toAnnouncement">公司公告</a></div>
                        <div class="li"><a href="/news/toDynamic">公司新闻</a></div>
                    </div>
                </li>
                <li>
                    <h4>产品服务</h4>
                    <div class="ul_list">
                        <div class="li"><a>快递服务</a></div>
                        <div class="li"><a>冷链服务</a></div>
                        <div class="li"><a>仓配一体化</a></div>
                    </div>
                </li>
                <%-- <li>
                     <h4>投资者关系</h4>
                     <div class="ul_list">
                         <div class="li"><a href="/Relation/Index">公司公告</a></div>
                         <div class="li"><a href="/Relation/Run">公司治理</a></div>
                         <div class="li"><a href="/Relation/Financing">财务信息</a></div>
                         <div class="li"><a href="/Relation/HotLine">投资者联络</a></div>
                         <div class="li"><a href="/Relation/Stock">股票走势</a></div>
                         <div class="li"><a href="http://irm.cninfo.com.cn/ssessgs/S002468/index.html" target="_blank">投资者互动</a></div>
                     </div>
                 </li>--%>
            </ul>
        </div>
    </div>
</div>
<div class="footer_bt">
    <div class="footer_bt_cont">
        <div class="sto_icp">超速物流有限公司：上海市青浦区北青公路6598弄25号 意邦国际写字楼 &nbsp;&nbsp; 邮编：201706 &nbsp;&nbsp; <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31011802001016" style="color:#ffffff" target="_blank">沪ICP备13037807号-1</a> &nbsp;&nbsp; 版权所有：超速物流有限公司</div>
    </div>
    <%--<div class="footer_bt_cont" style="text-align:center;">
        <a href="http://sh.cyberpolice.cn/infoCategoryListAction.do?act=initjpg" target="_blank"><img src="${path}/img/st/footer_pic_01.jpg" width="118" height="50"></a> &nbsp;&nbsp; <a href="http://www.sgs.gov.cn/lz/licenseLink.do?method=licenceView&amp;entyId=2012022915383099" target="_blank"><img src="${path}/img/st/footer_pic_02.jpg" width="47" height="50"></a> &nbsp;&nbsp; <a href="http://www.zx110.org/" target="_blank"><img src="${path}/img/st/footer_pic_03.jpg" width="113" height="50"></a> &nbsp;&nbsp;
        <a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31011802001016" style="display:inline-block;text-decoration:none;height:20px;line-height:20px;"><img src="http://www.beian.gov.cn/file/ghs.png" style="float:left;"><p style="float:left;height:20px;line-height:20px;margin: 0px 0px 0px 5px; color:#939393;">沪公网安备 31011802001016号</p></a>
    </div>--%>
</div>
<div id="popupHe2" style="display:none">
    <div class="cpopup">
        <div class="title">请输入运单号</div>
        <p class="addTar">
            <textarea style="width:280px;height:80px;border-radius:5px;" class="Reamk" name="Reamk" id="Reamk" maxlength="100" placeholder="请输入运单号"></textarea>
        </p>
        <a class="addresColor btnOk" onclick="javascript: sure()">确定</a>
        <a class="addresColor btnCl" onclick="javascript: cancel()">取消</a>
    </div>
</div>

</body>
</html>
