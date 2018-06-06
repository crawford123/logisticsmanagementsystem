<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 3/12/2018
  Time: 10:57 AM
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
    <title>管理员界面首页</title>
    <link href="${path}/css/common/bootstrap_fontawesome_layer.css" rel="stylesheet" type="text/css" />
    <link href="${path}/css/common/custom.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
        var path = '${path}';
    </script>
    <style>
        .systemTitleDiv{
            color:#033379;
            font-size:12px !important;
        }
    </style>

</head>
<body class="dashboard">

<!-- WRAPPER -->
<div class="wrapper">

    <!-- TOP BAR -->
    <div class="top-bar">
        <div class="container">
            <!-- responsive menu bar icon -->
            <!-- end responsive menu bar icon -->
            <a class="logo" href="${path}/index/adminIndex">
                <div style="float:left;">
                    <img src="${path}/img/banana1.png" alt="KingAdmin - Admin Dashboard"/>
                    <div class="systemTitleDiv">超速物流管理系统</div>
                    <div class="systemTitleDiv" style="margin-top:-4px;">High Speed Logistics</div>
                </div>
                <div style="float:left;font-size:30px;color:white;margin-left:105px;padding-top:13px">
                    <div>超速物流管理系统</div>

                </div>
            </a>
          <%--  <h1 class="sr-only"><spring:message code="page.text.title"/></h1>--%>
            <div class="top-bar-right">
                <%--<a href="${path}/updateInformation/toUpdateAdminInfo">--%>
                <span class="btn btn-link">你好! ${admin.username}! </span>
                 <img src="${path}/img/${admin.photo}"  style="border-radius:50%;width:36px;height:36px"  onerror="this.src='${path}/img/profile.png;this.onerror=null'">
                <button type="button" class=<%-- </a>--%>"btn btn-link" onclick="logout()"><i class="fa fa-power-off"></i>退出登录</button>
            </div>
        </div><!-- /container -->
    </div><!-- /top -->


    <!-- BOTTOM: LEFT NAV AND RIGHT MAIN CONTENT -->
    <div class="bottom">
        <div class="container">
            <!-- left sidebar -->
            <div class="left-sidebar">
                <!-- main-nav -->
                <nav class="main-nav" style="position: relative; z-index: 2;">

                    <ul class="main-menu">
                       <%-- <li id="welcome" class="active">
                            <a href="javascript:void(0)" data-src="${path}/welcome/toWelcome"><i class="fa fa-dashboard fa-fw"></i>功能列表</a>
                        </li>--%>
                           <li id="welcome" class="active">
                               <a href="javascript:void(0)" class="js-sub-menu-toggle" data-src="${path}/index/toAdminHome">
                                   首页
                               </a>
                           </li>


                           <li>
                               <a href="javascript:void(0)" class="js-sub-menu-toggle">
                                   公共管理
                                   <i class="toggle-icon fa fa-angle-left"></i>
                               </a>
                               <ul class="sub-menu">
                                   <li><a href="javascript:void(0)" data-src="${path}/userLoginRegister/toAdminRegister">系统管理员注册</a></li>
                                   <li><a href="javascript:void(0)" data-src="${path}/updateInformation/toUpdateAdminPassword">修改管理员密码</a></li>
                                   <li><a href="javascript:void(0)" data-src="${path}/updateInformation/toUpdateAdminInfo">修改管理员资料</a></li>
                               </ul>
                           </li>

                        <li>
                            <a href="javascript:void(0)" class="js-sub-menu-toggle">
                               用户信息管理
                                <i class="toggle-icon fa fa-angle-left"></i>
                            </a>
                            <ul class="sub-menu">
                                <li><a href="javascript:void(0)" data-src="${path}/user/manageUser">个人用户信息管理</a></li>
                                <li><a href="javascript:void(0)" data-src="${path}/user/manageAdmin">管理员信息管理</a></li>
                            </ul>
                        </li>

                           <li>
                               <a href="javascript:void(0)" class="js-sub-menu-toggle">
                                   普通订单管理
                                   <i class="toggle-icon fa fa-angle-left"></i>
                               </a>
                               <ul class="sub-menu">
                                   <li><a href="javascript:void(0)" data-src="${path}/order/toManageOrder">普通订单基本信息管理</a></li>
                                   <li><a href="javascript:void(0)" data-src="${path}/order/toManageOrderTraces">普通订单轨迹信息管理</a></li>
                               </ul>
                           </li>

                           <li>
                               <a href="javascript:void(0)" class="js-sub-menu-toggle">
                                   预约订单管理
                                   <i class="toggle-icon fa fa-angle-left"></i>
                               </a>
                               <ul class="sub-menu">
                                   <li><a href="javascript:void(0)" data-src="${path}/orderReservation/toManageOrderReservation">预约订单基本信息管理</a></li>
                                   <li><a href="javascript:void(0)" data-src="${path}/orderReservation/toManageTraceReservation">预约订单轨迹信息管理</a></li>
                               </ul>
                           </li>
                           <li>
                               <a href="javascript:void(0)" class="js-sub-menu-toggle"    data-src="${path}/commodity/toMangeCommodity">
                                   货物信息管理
                               </a>
                           </li>
                           <li>
                               <a href="javascript:void(0)" class="js-sub-menu-toggle" data-src="${path}/voicemail/toManageVoicemail">
                                   留言信息管理
                               </a>
                           </li>
                           <li>
                               <a href="javascript:void(0)" class="js-sub-menu-toggle" data-src="${path}/news/toManageNews">
                                   公司新闻信息管理
                                   </i>
                               </a>
                           </li>

                           <li>
                               <a href="javascript:void(0)" class="js-sub-menu-toggle">
                                   权限管理
                                   <i class="toggle-icon fa fa-angle-left"></i>
                               </a>
                               <ul class="sub-menu">
                                   <li><a href="javascript:void(0)" data-src="${path}/user/toManageUserAuthority">个人用户权限管理</a></li>
                                   <li><a href="javascript:void(0)" data-src="${path}/user/toManageAdminAuthority">管理员权限管理</a></li>
                               </ul>
                           </li>
                          <%-- <li>
                               <a href="javascript:void(0)" class="js-sub-menu-toggle">
                                   系统参数设置
                                   <i class="toggle-icon fa fa-angle-left"></i>
                               </a>
                           </li>--%>
                    </ul>
                </nav>
            </div>
            <div class="content-wrapper" id="iframe_parent">
                <ul class="breadcrumb">
                  <%--  <li><a href="#">Home</a></li>--%>
                    <li class="active">Welcome</li>
                </ul>
                <iframe id="bb_iframe" src="${path}/index/toAdminHome">
                </iframe>
            </div>

        </div>
    </div>
</div><!-- /wrapper -->

<!-- Javascript -->
<script src="${path}/js/common/jquery_layer.js"></script>
<script src="${path}/js/common/bootstrap_king.js"></script>

<script src="${path}/js/common/common.js"></script>
<script type="text/javascript">

    $(document).ready(function (e) {
        var localUrl=sessionStorage.getItem("pageLocalUrl");
        if(localUrl!="" && localUrl!=null && localUrl!=undefined){
            var menu=$('.left-sidebar .main-nav .main-menu li a');
            var menu_ul="",menu_li="";
            for(var i=0;i<menu.length;i++){
                if(menu[i].dataset.src!=null && menu[i].dataset.src.indexOf(localUrl)>-1){
                    $(menu[i]).parent().parent().parent().addClass('active');
                    menu_ul=$(menu[i]).parent().parent().parent()[0].innerText;
                    menu_li=$(menu[i]).parent()[0].innerText;
                    $(menu[i]).parent().parent().css("display", "block")
                    break;
                }else if(localUrl.split("|").length>1 && menu[i].innerText.indexOf(localUrl.split("|")[1])>-1){
                    menu_ul=localUrl.split("|")[1];
                    menu_li=localUrl.split("|")[2];
                    localUrl=localUrl.split("|")[0];
                    $(menu[i]).parent().addClass('active');
                    $(menu[i]).parent().children('ul').css("display", "block")
                    break;
                }
            }
            $('#welcome').removeClass('active');
            $('.breadcrumb>li>a').text(menu_ul);
            $('.breadcrumb>.active').text(menu_li);
            $('iframe').attr('src',localUrl);
        }
    });

    $('.left-sidebar .main-nav .main-menu li a').click(function(e){
        if(e.target.parentNode.id==null || e.target.parentNode.id==''){
            $('#welcome').removeClass('active');
        };
        if (e.target.dataset && e.target.dataset.src){
            var dataSrc = e.target.dataset.src;
           // sessionStorage.setItem("menuStatus", status);

            var url = dataSrc.substring(dataSrc.lastIndexOf('/')+1);
            if(url =='toWelcome'){
                $('#welcome').addClass('active');
                $('.breadcrumb>li>a').text('Home');
                $('.breadcrumb>.active').text('Welcome');
                sessionStorage.removeItem("pageLocalUrl");
            }else {
                $(".sub-menu li").removeClass('active');
                $(e.target.parentNode).addClass('active');
                $('#welcome').removeClass('active');
                $('.breadcrumb>li>a').text(e.target.parentNode.parentNode.parentNode.children[0].text);
                $('.breadcrumb>.active').text(e.target.text);
                sessionStorage.setItem("pageLocalUrl",e.target.dataset.src);
            }
            $('#bb_iframe').remove();
            var html = '<iframe id="bb_iframe" src="' + e.target.dataset.src + '"></iframe>'
            $('#iframe_parent').append(html);
        }
    });

    function logout(){
        var toLogout = function(){
            window.top.location.href = path+"/userLoginRegister/adminLogout";
        };

        confirmMsg("确定退出该系统？", null, "确定", "取消", toLogout);

    }
</script>

</body>

</html>
