<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 3/14/2018
  Time: 11:06 PM
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
    <meta charset="UTF-8" />
    <title>Document</title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${path}/css/carousel.css" type="text/css"/>
    <script  src="${path}/js/carousel.js"></script>
</head>
<body>
<%--<div id="hero-wrapper">--%>
   <%-- <div class="carousel-wrapper">--%>
        <div id="hero-carousel" class="carousel">
            <ol class="carousel-indicators">
                <li data-target="#hero-carousel" data-slide-to="0" class="active"></li>
                <li data-target="#hero-carousel" data-slide-to="1"></li>
                <li data-target="#hero-carousel" data-slide-to="2"></li>
                <li data-target="#hero-carousel" data-slide-to="3"></li>
                <%--<li data-target="#hero-carousel" data-slide-to="4"></li>
                <li data-target="#hero-carousel" data-slide-to="5"></li>--%>
            </ol>
            <div class="carousel-inner">
                <div class="item active">
                    <img src="${path}/img/logistics1.png">
                </div>
                <div class="item">
                    <img src="${path}/img/logistics2.jpg">
                </div>
                <div class="item">
                    <img src=" ${path}/img/logistics3.png">
                </div>
                <div class="item">
                    <img src="${path}/img/logistics4.jpg">
                </div>
                <div class="item">
                    <img src=" ${path}/img/logistics5.jpg">
                </div>
                <div class="item">
                    <img src="${path}/img/logistics6.jpg">
                </div>
            </div>
            <a class="left carousel-control" href="#hero-carousel" data-slide="prev">
                <i class="fa fa-chevron-left left"></i>
            </a>
            <a class="right carousel-control" href="#hero-carousel" data-slide="next">
                <i class="fa fa-chevron-right right"></i>
            </a>
        </div>
  <%--  </div>--%>


</body>
</html>