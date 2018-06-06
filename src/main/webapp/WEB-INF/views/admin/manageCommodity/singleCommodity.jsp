<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@include file="../../../static/common/taglib.jsp"%>

<table class="table table-bordered table-striped" style="overflow:hidden">
    <tr>
        <td class="col-sm-2">物品编号
        </td>
        <td class="col-sm-4">
            <input type="text" class="form-control unEditable" name="commodityid" id="commodityid" /></td>
        <td class="col-sm-2">用户名
        </td>
        <td class="col-sm-4">
            <input type="text" class="form-control unEditable" name="usernames" id="usernames" /></td>
    </tr>
    <tr>
        <td class="col-sm-2">物品名称
        </td>
        <td class="col-sm-4">
            <input type="text" class="form-control unEditable" name="goodsnames" id="goodsnames" /></td>
        <td class="col-sm-2">物品描述</td>
        <td class="col-sm-4"><input type="text" class="form-control unEditable" name="goodsdesc" id="goodsdesc"/></td>
    </tr>
    <tr>
        <td class="col-sm-2">物品数量</td>
        <td class="col-sm-4"><input  class="form-control unEditable" name="goodsquantity" id="goodsquantity" /></td>
        <td class="col-sm-2">物品重量</td>
        <td class="col-sm-4"><input type="text" class="form-control unEditable" name="goodsweight" id="goodsweight"  /></td>
    </tr>
    <tr>
        <td class="col-sm-2">运费</td>
        <td class="col-sm-4"><input type="text" class="form-control unEditable" name="cost" id="cost" /></td>
        <td class="col-sm-2">订单编号</td>
        <td class="col-sm-4"><input type="text" class="form-control unEditable" name="ordercodes" id="ordercodes" /></td>
    </tr>
    <tr>
        <td class="col-sm-2">运单号</td>
        <td class="col-sm-4"><input type="text" class="form-control unEditable" name="logisticcodes" id="logisticcodes" /></td>

    </tr>
   <%-- <tr>
        <td class="col-sm-2">
            物品图片
        </td>
        <td class="col-sm-6">

        </td>
    </tr>--%>
</table>
&nbsp;&nbsp;&nbsp;物品图片<br>
<img  id="photo" name="photo" width="100%" height="100%"/>