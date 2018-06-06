<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@include file="../../../static/common/taglib.jsp"%>
<table class="table table-bordered table-striped" style="overflow:hidden">

    <tr>
        <td class="col-sm-2">
            登录状态
        </td>
        <td class="col-sm-4">
            <input id="adminid" name="adminid" type="hidden"/>
            <select class="form-control input-sm" id="logintypes" name="logintype">
                <option value="0">正常使用</option>
                <option value="1">暂停使用</option>
                <option value="2">销户</option>
            </select>
        </td>
    </tr>


</table>