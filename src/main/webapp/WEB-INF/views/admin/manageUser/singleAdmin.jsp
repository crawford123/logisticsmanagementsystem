<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@include file="../../../static/common/taglib.jsp"%>

<table class="table table-bordered table-striped">
    <tr>

    <tr>
        <td class="col-sm-2">
            管理员id
        </td>
        <td class="col-sm-2">
            <input type="text" class="form-control"  name="adminid" id="adminid" />
        </td>
        <td class="col-sm-2">
          用户名
        </td>
        <td class="col-sm-2">
            <input type="text" class="form-control" name="username" id="usernames"  />
        </td>
    </tr>
    <tr>
        <td class="col-sm-2">
            密码
        </td>
        <td class="col-sm-2">
            <input type="password" class="form-control" name="password" id="password"  />
        </td>
        <td class="col-sm-2">
            图片
        </td>
        <td class="col-sm-2">
           <%-- <input type="text" class="form-control" name="photo" id="photo"  />--%>
            <img width="100%" height="100%" id="photo" name="photo" onerror="this.src='${path}/img/profile.png;this.onerror=null'" />
        </td>
    </tr>
    <tr>
        <td class="col-sm-2">
            年龄
        </td>
        <td class="col-sm-2">
            <input type="password" class="form-control" name="age" id="age"  />
        </td>
        <td class="col-sm-2">
        性别
    </td>
        <td class="col-sm-2">
                    <label class="label1"  style="font-size: medium">男</label>
                    <input type="radio"   name="sex"  id="male" value="男"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <label class="label1" style="font-size: medium">女</label>
                    <input type="radio" name="sex" id="female" value="女"/>
        </td>
    </tr>
    <tr>
        <td class="col-sm-2">
            手机号码
        </td>
        <td class="col-sm-2">
            <input type="password" class="form-control" name="phone" id="phones"  />
        </td>
        <td class="col-sm-2">
            电子邮箱
        </td>
        <td class="col-sm-2">
            <input type="text" class="form-control" name="email" id="email"  />
        </td>
    </tr>

    <tr>
        <td class="col-sm-2">
            身份证号码
        </td>
        <td class="col-sm-2">
            <input type="password" class="form-control" name="idnumber" id="idnumbers"  />
        </td>
    </tr>
</table>
