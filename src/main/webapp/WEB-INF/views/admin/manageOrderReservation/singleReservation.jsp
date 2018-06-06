<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@include file="../../../static/common/taglib.jsp"%>


<table class="table table-bordered table-striped" style="overflow:hidden">
    <tr id="trDate">
        <td class="col-sm-2">日期</td>
        <input type="hidden" class="form-control unEditable" name="tracesid" id="tracesid" /></td>
        <td class="col-sm-4">
            <input type="text" class="form-control unEditable" name="accepttime" id="accepttime" />
        </td>
    </tr>


    <tr>
        <td class="col-sm-2">订单轨迹信息</td>
        <td class="col-sm-4">
            <textarea class="form-control" id="acceptstation" name="acceptstation" rows="4"></textarea>
        </td>
    </tr>
    <tr>
        <td class="col-sm-2">备注信息</td>
        <td class="col-sm-4"><input type="text" class="form-control unEditable" name="remark" id="remark"/></td>
    </tr>

</table>

