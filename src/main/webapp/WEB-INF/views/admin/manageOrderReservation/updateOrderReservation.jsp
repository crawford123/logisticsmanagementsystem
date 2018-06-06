<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@include file="../../../static/common/taglib.jsp"%>
<table class="table table-bordered table-striped" style="overflow:hidden">

    <tr>
        <td class="col-sm-2">
            预约状态
        </td>
        <td class="col-sm-4">
            <select class="form-control input-sm" id="reserveState" name="reserveState">
                <option value="0">预约中</option>
                <option value="1">预约失败</option>
                <option value="2">预约成功</option>
                <option value="3">取消预约</option>
            </select>
        </td>
        <td class="col-sm-2">
            物流状态
        </td>
        <td class="col-sm-4">
            <select class="form-control input-sm" id="orderState" name="orderState">
                <option value="0">未揽件</option>
                <option value="1">已揽件</option>
                <option value="2">在途中</option>
                <option value="3">已签收</option>
                <option value="4">问题件</option>
            </select>
            <input  type="hidden" class="form-control unEditable" name="id" id="id" />
        </td>

    </tr>
    <%--<tr>

        <td class="col-sm-2">运单号</td>
        <td class="col-sm-4">
            <input type="text" class="form-control unEditable" id="logistic" name="logistic" maxlength="15"/></td>
    </tr>--%>


</table>