<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@include file="../../../static/common/taglib.jsp"%>

<div class="footer">
    <div class="footer_cont clearfix">
        <div class="left_group fl">
            <h2>客服热线</h2>
            <h1>021-069365216</h1>
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
    <div class="footer_bt_cont" style="text-align:center;">
        <a href="http://sh.cyberpolice.cn/infoCategoryListAction.do?act=initjpg" target="_blank"><img src="${path}/img/st/footer_pic_01.jpg" width="118" height="50"></a> &nbsp;&nbsp; <a href="http://www.sgs.gov.cn/lz/licenseLink.do?method=licenceView&amp;entyId=2012022915383099" target="_blank"><img src="${path}/img/st/footer_pic_02.jpg" width="47" height="50"></a> &nbsp;&nbsp; <a href="http://www.zx110.org/" target="_blank"><img src="${path}/img/st/footer_pic_03.jpg" width="113" height="50"></a> &nbsp;&nbsp;
        <a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31011802001016" style="display:inline-block;text-decoration:none;height:20px;line-height:20px;"><img src="http://www.beian.gov.cn/file/ghs.png" style="float:left;"><p style="float:left;height:20px;line-height:20px;margin: 0px 0px 0px 5px; color:#939393;">沪公网安备 31011802001016号</p></a>
    </div>
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

