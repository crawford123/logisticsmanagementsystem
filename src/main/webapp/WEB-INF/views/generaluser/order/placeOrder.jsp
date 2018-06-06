
<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 3/12/2018
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=utf-8"%>

<!DOCTYPE html>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("path", path);
%>
<head>
    <title>下订单界面</title>
    <link rel="stylesheet" href="${path}/css/common/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/bootstrap_fontawesome_layer.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/custom.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/select.css" type="text/css"/>
    <script  src="${path}/js/placeorder.js"></script>
    <script  src="${path}/js/select.js"></script>
    <script  src="${path}/js/common/common.js"></script>
    <script  src="${path}/js/common/jquery_layer.js"></script>
    <script  src="${path}/js/common/bootstrap_king.js"></script>
    <script  src="${path}/js/common/jsrsasign-all-min.js"></script>
    <script type="text/javascript">
        var path = '${path}';
        window.onload = function(){
            window.setInterval(function(){
                document.getElementById("date").value=CurentTime();
            }, 1000);
        }
    </script>
</head>

<body>

<jsp:include page="../../../views/generaluser/home/head.jsp"/>

<div class="container">

    <div class="col-lg-8 col-lg-offset-2">
        <div class="page-header">

            <h2>下订单</h2>
        </div>
        <hr class="headers-region"/>
        <div class="container">
            <form id="placeOrderForm"  class="form-horizontal" enctype="multipart/form-data">


                <h3>物品描述</h3>
                <div class="form-group">

                    <input type="hidden" name="username" id="username" value="${generaluser.username}"/>
                    <input type="hidden" name="userid" id="userid" value="${generaluser.userid}"/>
                    <input type="hidden" name="date" id="date"/>
                    <input type="text" class="form-control" id="goodsname" name="goodsname" placeholder="要寄的物品名" />

                </div>
                <br>
                <div class="form-group">
                    <input type="file"  class="icon-file" id="file" name="file"/>
                    <br>
                    <%--<input type="submit" class="btn btn-primary" value="提交上传">--%>
                </div>
                <br>
                <div class="form-group">

                    <input type="text" class="form-control" id="description" name="description" placeholder="物品描述" />

                </div>
                <br>
                <div class="form-group">

                    <input type="text" class="form-control" id="amount" name="amount" placeholder="物品数量" />

                </div>
                <br>
                <div class="form-group">

                    <input type="text" class="form-control" id="totalweight" name="totalweight" placeholder="总重量" />

                </div>


                <br>
                <h3>发件人信息</h3>
                <div class="form-group">

                    <input type="text" class="form-control" id="sendername" name="sendername" placeholder="发件人姓名" />

                </div>
                <br>
                <div class="form-group">

                    <input type="text" class="form-control" id="senderphone" name="senderphone" placeholder="发件人手机号码" />

                </div>
                <br>
                <h3>收件人信息</h3>
                <div class="form-group">

                    <input type="text" class="form-control" id="recipientname" name="recipientname" placeholder="收件人姓名" />

                </div>
                <br>

                <div class="form-group">

                    <input type="text" class="form-control" id="recipientphone" name="recipientphone" placeholder="收件人手机号码" />

                </div>
                <br>
                <div class="form-group">

                    <input type="text" class="form-control" id="receivingaddress" name="receivingaddress" placeholder="收件人地址" />

                </div>
               <%-- <br>
                <div class="form-group">
                <select class="form-control input-sm"
                        name="companyname" id="companyname">
                    <option value="顺丰快递">
                             顺丰快递
                    </option>
                    <option value="圆通快递">
                        圆通快递
                    </option>
                    <option value="申通快递">
                        申通快递
                    </option>
                </select>
                </div>--%>

                <br>
                <div class="form-group">
                    <input type="text" class="form-control" id="shippingcost" name="shippingcost" placeholder="运费" />

                </div>
                <br>
             <%--   <div class="form-group">
                    <input type="text" class="form-control" id="paymentStatus" name="paymentStatus" placeholder="支付状态" />

                </div>--%>
             <%--   <div class="form-group">
                    <button type="text" class="btn btn-primary"  id="orderstatus"  name="orderstatus ">订单状态</button>

                </div>--%>
                <br>
                <div class="form-group">
                    <button type="text" class="btn btn-primary" id="btn_register" onclick="toPlaceOrder()">下订单</button>

                </div>

            </form>
        </div>

    </div>


</div>



</body>
</html>
