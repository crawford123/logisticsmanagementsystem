<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 3/15/2018
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${path}/css/common/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/bootstrap_fontawesome_layer.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/custom.css" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="${path}/css/st/global.css" />
    <link rel="stylesheet" type="text/css" href="${path}/css/st/common.css" />
   <%-- <link rel="stylesheet" href="${path}/css/sf/main.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/layui/layui.css" type="text/css"/>--%>
    <link href="${path}/css/api/toastr.min.css" type="text/css" rel="stylesheet" />

    <script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
    <script  src="${path}/js/common/common.js"></script>
    <script  src="${path}/js/common/jquery_layer.js"></script>
    <script  src="${path}/js/common/bootstrap_king.js"></script>
    <script  src="${path}/js/common/jsrsasign-all-min.js"></script>
    <script  src="${path}/js/layui/layui.js"></script>
    <script src="${path}/js/common/jquery_layer.js"></script>
    <script  src="${path}/js/common/common.js"></script>
    <script src="${path}/js/api/toastr.min.js"></script>
    <script  src="${path}/js/voicemail.js"></script>
    <title>联系商家</title>
    <script type="text/javascript">
        var path = '${path}';
        window.onload = function(){
            window.setInterval(function(){
                $("#voicemaildate").val(CurentTime());
            }, 1000);
        }

    </script>
</head>
<body>
<jsp:include page="../home/head.jsp"/>

<div class="container">

    <div class="col-lg-8 col-lg-offset-2">
        <div class="page-header">

            <h2 style="font-size: xx-large">投诉与反馈<font style="font-size: medium">（客服电话：021-069365216）</font></h2>
        </div>
        <br>

        <hr class="headers-region"/>
        <div class="container">
            <form id="voicemailForm" enctype="multipart/form-data"  class="form-horizontal">
               <%-- <div class="form-group">
                    <div class="layui-upload">
                        <button type="button" class="layui-btn" id="test1">上传图片</button>
                        <div class="layui-upload-list">
                            <img class="layui-upload-img" id="demo1">
                            <p id="demoText"></p>
                        </div>
                    </div>
                </div>--%>

                   <div class="form-group">
                       <input type="file" class="btn-file" id="file" validate-info="物品图片"  name="file"/>

                   </div>

                <div class="form-group">
                    <textarea class="form-control" placeholder="请输入您的投诉或反馈信息" id="content" name="content" rows="8"></textarea>
                </div>
                <input type="hidden" id="userid" name="userid"  value="${generaluser.userid}"/>
                <input type="hidden"  id="voicemaildate" name="voicemaildate"/>
                   <input type="hidden"  id="state" name="state" value="0"/>
                <br>
                <div class="form-group">
                    <input type="button" value="留言" class="btn btn-primary" id="btn_voicemail" onclick="return doVoicemail()"/>

                </div>

            </form>
        </div>

    </div>


</div>

<jsp:include page="../home/foot.jsp"/>

</body>
</html>
