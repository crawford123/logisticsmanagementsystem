<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 4/14/2018
  Time: 1:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
 <head>
    <title>PC端-物流轨迹查询结果页面嵌入</title>
    <link rel="stylesheet" href="http://www.kdniao.com/OutDemo/KDNWidget/KDNWidget.css" />
</head>
<body>
<div id="demoID"></div>
<script src="http://www.kdniao.com/OutDemo/KDNWidget/KDNWidget.js"></script>
<script>
    window.onload = function () {
        KDNWidget.run({
            serviceType: "B",
            expCode:"ZTO",
            expNo:"453173031799",
            showType:"normal",
            container: "demoID"
        })
    }
</script>
</body>

</html>