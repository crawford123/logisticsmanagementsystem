<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@include file="../../../static/common/taglib.jsp"%>

<header>
    <!--[if lt IE 9]>
    <script src="${path}/js/html5shiv.js"></script>
    <![endif]-->

    <link rel="stylesheet" type="text/css" href="${path}/css/head/header.css">

    <!--add class "transparent" for the  transparent version-->
    <nav id="wix-menu" class="wix-menu davinci-enabled no-sidebar-state-change-occurred" lang="en" data-layout="center" style="visibility: visible;"><div class="wm-mobile-sidebar-wrapper"><div class="wm-mobile-page-overlay"></div><div class="wm-mobile-sidebar"><div class="wm-mobile-sidebar-content">
        <div id="wm-mobile-close-sidebar" class="header-and-footer-svg-font-icons-close"></div></div></div></div><div class="wm-container"><a class="wm-mobile-optimized-menu-handle"><div class="wm-icon"></div></a><div class="wm-logo-wrapper"><a href="${path}/index/userIndex"><img src="${path}/img/icon/express5.png" width="100%" height="100%"></a></div><div class="wm-links-wrapper"><div class="wm-links-container"><ul class="web">
        <li class="is-hidden davinci-hide menuItem" id="wm-verticals-drop-down"></li>
        <li class="is-hidden davinci-hide menuItem" id="wm-verticals-names">
            {"BUSINESS":"Business","MUSIC":"Music","PHOTOGRAPHY":"Photography","ONLINE_STORE":"Online Store","DESIGNER":"Designer","RESTAURANTS":"Restaurants &amp; Food","ACCOMMODATION":"Accommodation","EVENTS":"Events","PORTFOLIO_AND_CV":"Portfolio &amp; CV","BEAUTY_AND_WELLNESS":"Beauty &amp; Wellness","BLOG":"Blog","OTHER":"Other"}
        </li>
        <li class="menuItem"><a id="wm-my-account-link" href="https://www.wix.com/my-account" class="davinci-hide">My Sites</a></li>
        <li class="davinci-hide menuItem"><a class="wm-create-link" href="https://www.wix.com/website/templates">Templates</a></li>

        <li class="davinci-show menuItem"><a class="wm-features-link" href="${path}/index/userIndex"><span>首页</span></a></li>
        <%-- <li class="davinci-show menuItem"><a class="wm-explore-link" href="https://www.wix.com/explore/websites">我的订单</a></li>--%>
        <li class="wm-dropdown menuItem">
            <a class="wm-explore-link"  href="${path}/order/toSendExpress" >
                物流
                <span class="sub-menu-arrow"><svg width="10" height="5.7" viewBox="0 0 10 5.7"><polygon fill="none" points="5 5.7 0 0.7 0.7 0 5 4.4 9.3 0 10 0.7 "></polygon></svg></span>
            </a>
            <ul class="wm-submenu">
                <li>
                    <a  href="${path}/order/toSendExpress">
                        <span>当日寄件</span>
                    </a>
                </li>
                <li>
                    <a  href="${path}/orderReservation/toOrderReservation">
                        <span>免费预约上门取件</span>
                    </a>
                </li>
                <li>
                    <a  href="${path}/order/toQueryOrder">
                        <span>运单追踪</span>
                    </a>
                </li>

            </ul>
        </li>
        <li class="wm-dropdown menuItem">
            <a class="wm-explore-link"  href="${path}/order/toOrderRecord" >
                我的订单
                <span class="sub-menu-arrow"><svg width="10" height="5.7" viewBox="0 0 10 5.7"><polygon fill="none" points="5 5.7 0 0.7 0.7 0 5 4.4 9.3 0 10 0.7 "></polygon></svg></span>
            </a>
            <ul class="wm-submenu">
                <li>
                    <a  href="${path}/order/toOrderRecord">
                        <span>当日寄件订单记录</span>
                    </a>
                </li>
                <li>
                    <a  href="${path}/orderReservation/toOrderReservationRecord">
                        <span>订单预约记录</span>
                    </a>
                </li>
            </ul>
        </li>




        <li class="wm-dropdown menuItem">
            <a class="wm-explore-link"  href="${path}/voicemail/toVoicemail" >
                投诉与反馈
                <span class="sub-menu-arrow"><svg width="10" height="5.7" viewBox="0 0 10 5.7"><polygon fill="none" points="5 5.7 0 0.7 0.7 0 5 4.4 9.3 0 10 0.7 "></polygon></svg></span>
            </a>
            <ul class="wm-submenu">
                <li>
                    <a  href="${path}/voicemail/toVoicemail">
                        <span>进行投诉与反馈</span>
                    </a>
                </li>
                <li>
                    <a  href="${path}/voicemail/toVoicemailRecord">
                        <span>我的投诉与反馈记录</span>
                    </a>
                </li>
            </ul>
        </li>


        <li class="wm-dropdown menuItem">
            <a class="wm-explore-link"  href="${path}/news/toNewsDetail" >
                新闻资讯
                <span class="sub-menu-arrow"><svg width="10" height="5.7" viewBox="0 0 10 5.7"><polygon fill="none" points="5 5.7 0 0.7 0.7 0 5 4.4 9.3 0 10 0.7 "></polygon></svg></span>
            </a>
            <ul class="wm-submenu">
                <li>
                    <a  href="${path}/news/toNews">
                        <span>公司动态</span>
                    </a>
                </li>
                <li>
                <a  href="${path}/news/toAnnouncement">
                    <span>公司公告</span>
                </a>
            </li>
                <li>
                    <a  href="${path}/news/toNews">
                        <span>公司新闻</span>
                    </a>
                </li>
            </ul>
        </li>


        <li class="wm-dropdown menuItem">
            <a class="wm-explore-link"  href="${path}/index/toAboutUs" >
                关于我们
                <span class="sub-menu-arrow"><svg width="10" height="5.7" viewBox="0 0 10 5.7"><polygon fill="none" points="5 5.7 0 0.7 0.7 0 5 4.4 9.3 0 10 0.7 "></polygon></svg></span>
            </a>
            <ul class="wm-submenu">
                <li>
                    <a  href="${path}/index/toAboutUs">
                        <span>公司信息</span>
                    </a>
                </li>
                <li>
                    <a  href="${path}/userLoginRegister/toAdminLogin ">
                        <span>系统后台登录</span>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    </div>
    </div>
        <div class="wm-language-and-user-wrapper">
            <div class="wm-language-drop-down-wrapper" style="display: none;">
            <span class="globeIcon">
                <svg width="18" height="18" viewBox="0 0 18 18">
                    <path fill="none" d="M10.8 0.2C10.3 0.1 9.9 0 9.5 0 9.3 0 9.2 0 9 0l0 0C8.4 0 7.9 0.1 7.4 0.2 3.2 0.9 0 4.6 0 9c0 4.4 3.2 8.1 7.4 8.8C7.9 17.9 8.4 18 9 18l0 0c0.2 0 0.3 0 0.5 0 0.4 0 0.9-0.1 1.3-0.2C14.9 17 18 13.4 18 9 18 4.6 14.9 1 10.8 0.2zM16.4 6h-3.6c-0.6-2-1.7-3.9-2.8-5C12.8 1.4 15.4 3.5 16.4 6zM12 9c0 0.7-0.1 1.3-0.2 2H6.3C6.1 10.3 6 9.7 6 9c0-0.7 0.1-1.3 0.3-2h5.5C11.9 7.7 12 8.3 12 9zM9 16.5c-1-1.1-1.8-2.7-2.5-4.5h5C11.1 13.8 10 15.4 9 16.5zM6.5 6C7.2 4.2 8 2.6 9 1.5c1 1.1 2.1 2.7 2.6 4.5H6.5zM8 1c-1.1 1.3-2.1 3.1-2.7 5H1.6C2.7 3.4 5.1 1.4 8 1zM1.3 7H5.1C5 7.7 4.9 8.3 4.9 9c0 0.7 0.1 1.3 0.2 2H1.3c-0.2-0.6-0.3-1.3-0.3-2C1 8.3 1.1 7.6 1.3 7zM1.6 12h3.7c0.5 1.9 1.6 3.7 2.7 5C5.1 16.6 2.7 14.6 1.6 12zM10 17c1.2-1.1 2.2-2.9 2.8-5h3.6C15.4 14.5 12.7 16.8 10 17zM16.7 11h-3.7c0.1-0.7 0.2-1.3 0.2-2 0-0.7 0-1.3-0.1-2h3.7c0.1 0.6 0.2 1.3 0.2 2C17 9.7 16.9 10.4 16.7 11z">
                    </path>
                </svg>
            </span>
            </div>
            <c:choose>
                <c:when test="${generaluser == null}">
            <div class="wm-user-state-wrapper">
                <a id="wm-signin-link" href="${path}/userLoginRegister/toGenaralUserRegister" class="signin" style="display: inline;">
                    <span class="wix-component-text">注册</span></a>
                <a id="wm-signin-link" href="${path}/userLoginRegister/toUserLogin" class="signin" style="display: inline;">
                    <span class="wix-component-text">登录</span></a>
</c:when>
                <c:otherwise>
                        <div class="wm-logged-in" style="display: block;">
                            <div class="wm-settings-wrapper"><div class="wm-drop-down-settings-component">
                                <a class="wm-user-details-wrapper">
                                    <div class="wm-user-details">
                                       <%-- <div class="wm-user-image-wrapper">
                                            <div class="wm-user-fallback-image">&nbsp;
                                               </div>
                                        </div>--%>
                                           <div class="user-name-actions">
                                               <div class="user-name-wrapper">
                                                   <div class="user-name">
                                                       Hi, ${generaluser.username}
                                                       <img src="${path}/img/${generaluser.photo}" style="border-radius:50%;width:36px;height:36px" onerror="this.src='${path}/img/profile.png;this.onerror=null'">

                                                       <span class="sub-menu-arrow">
                                                    </span>
                                                   </div>
                                               </div>
                                           </div>
                                        <span class="sub-menu-arrow">
                                            <svg xmlns="http://www.w3.org/2000/svg" version="1.1" x="0" y="0" width="10" height="5.7" viewBox="0 0 10 5.7" enable-background="new 0 0 9.992 5.695" xml:space="preserve"><polygon fill="none" points="5 5.7 0 0.7 0.7 0 5 4.4 9.3 0 10 0.7 "></polygon></svg>
                                        </span></div></a><ul id="wm-settings-drop-down">
                                <li><a target="_self" href="${path}/updateInformation/toUpdateAccount">修改个人资料</a></li>
                                <li><a target="_self" href="${path}/updateInformation/toUpdatePassword">修改密码</a></li>
                                <li><a target="_self" href="${path}/userLoginRegister/genaralUserLogout">退出登录</a></li>
                            </ul>
                            </div>
                            </div>
                        </div>
            </div>
        </div>
                </c:otherwise>
            </c:choose>
</header>


