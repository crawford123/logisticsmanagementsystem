<%--
  Created by IntelliJ IDEA.
  User: Fengli
  Date: 5/11/2018
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改管理员密码</title>
    <link rel="stylesheet" href="${path}/css/common/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/bootstrap_fontawesome_layer.css" type="text/css"/>
    <link rel="stylesheet" href="${path}/css/common/custom.css" type="text/css"/>
    <link href="${path}/css/api/toastr.min.css" type="text/css" rel="stylesheet" />
</head>
<body class="container">
<!-- main -->
<div class="content">
    <div class="widget">
        <div class="widget-header">
            <h3>管理员修改密码页面</h3>
        </div>
        <div class="widget">
            <div class="update-pwd-div" style="height: 300px;border: 0px solid #F1F1F1; width: 50%;margin: 0 auto;padding-top: 50px;">
                <form id="form">
                    <table class="table table-bordered">
                        <tr style="text-align: right;">
                            <td>旧密码</td>
                            <td>
                                <input type="hidden"  class="form-control" id="username"  name="username" value="${admin.username}"/>
                                <input type="hidden"  class="form-control" id="adminid"  name="adminid" value="${admin.adminid}"/>
                                <input type="password"  class="form-control" id="oldPassword"  name="oldPassword"/>
                            </td>

                        </tr>
                        <tr style="text-align: right;">
                            <td>密码</td>
                            <td><input type="password"  class="form-control" id="password"  name ="password"/></td>
                        </tr>
                        <tr style="text-align: right;">
                            <td>确认密码</td>
                            <td><input type="password"  class="form-control" id="confirmPassword" name="confirmPassword"/></td>
                        </tr>



                        <tr>
                            <td colspan="2">
                                <div class="row">
                                    <div class="col-lg-12" style="text-align: center;">
                                        <input  type="button" class="btn btn-primary" style="width: 120px;text-align: center;border-radius: 12px;" onclick="return doAdminUpdatePassword()"  id="update" value="修改"/>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>

    </div>
</div>

<script  src="${path}/js/common/jquery-3.3.1.min.js"></script>
<script src="${path}/js/api/toastr.min.js"></script>
<script  src="${path}/js/verifyForm.js"></script>
<script src="${path}/js/common/jquery_layer.js"></script>
<script  src="${path}/js/common/common.js"></script>
<script  src="${path}/js/update.js"></script>
<script type="text/javascript">
    var path = '${path}';
</script>
</body>
</html>
