<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@include file="../../../static/common/taglib.jsp"%>
<table class="table table-bordered table-striped" style="overflow:hidden">

    <tr>
        <td class="col-sm-2">
           物流状态
        </td>
        <td class="col-sm-4">
            <select class="form-control input-sm" id="State" name="state">
                <option value="0">未揽件</option>
                <option value="1">已揽件</option>
                <option value="2">在途中</option>
                <option value="3">已签收</option>
                <option value="4">问题件</option>
            </select>
            <input  type="hidden" class="form-control unEditable" name="orderid" id="orderid" value="${orders.orderid}"/>
        </td>
       <%-- <td class="col-sm-2">运单号</td>
        <td class="col-sm-4">
            <input type="text" class="form-control unEditable" id="logistic" name="logistic" maxlength="15" value="${orders.logisticcode}"/></td>--%>
    </tr>


</table>