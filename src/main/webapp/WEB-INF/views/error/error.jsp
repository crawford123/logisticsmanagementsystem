<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie ie9" lang="en" class="no-js"> <![endif]-->
<!--[if !(IE)]><!--><html lang="en" class="no-js"> <!--<![endif]-->
<head>
    <title>error</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="description" content="KingAdmin - Bootstrap Admin Dashboard Theme">
    <meta name="author" content="The Develovers">

    <!-- CSS -->
    <link rel="stylesheet" href="${path}/css/common/bootstrap_fontawesome_layer.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/custom.css" type="text/css"/>

    <!-- CSS for demo style switcher. you can remove this -->
    <!--link href="demo-style-switcher/assets/css/style-switcher.css" rel="stylesheet" type="text/css"-->


</head>
<body class="container">
<div class="content">
    <div class="dd-error">
        <div class="dd-error-img">
            <img src="${path}/img/error.png" />
        </div>
        <div class="dd-error-font">
            <label style="font-size: 1.7em">出错啦！</label>
            <label>正在努力为您找回页面</label>
        </div>
    </div>
</div><!-- /main -->

<!-- Javascript -->
<script  src="${path}/js/jquery_layer.js"></script>
<script  src="${path}/js/bootstrap_king.js"></script>

</body>
</html>
