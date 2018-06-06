<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 4/15/2018
  Time: 8:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
    <title>PC端-物流轨迹查询框嵌入</title>
    <link rel="stylesheet" href="http://www.kdniao.com/OutDemo/KDNWidget/KDNWidget.css" />
</head>
<body>

<div id="demoID"></div>
<script  src="${path}/js/KDNWidget.js"></script>
<script>
    window.onload = function () {
        KDNWidget.run({
            "serviceType": "D",
            "container": "demoID",
        })
    }
</script>
</body>
</html>