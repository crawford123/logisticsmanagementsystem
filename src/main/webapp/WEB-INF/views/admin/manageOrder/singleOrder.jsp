<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@include file="../../../static/common/taglib.jsp"%>

<table class="table table-bordered table-striped" style="overflow:hidden">
    <tr>
        <td class="col-sm-2">运单号
        </td>
        <td class="col-sm-4">
            <input type="text" class="form-control unEditable" name="logisticcode" id="logisticcode" /></td>
    </tr>
    <tr>
        <td class="col-sm-2">订单编号
        </td>
        <td class="col-sm-4">
            <input type="text" class="form-control unEditable" name="ordercode" id="ordercodes" /></td>
        <td class="col-sm-2">下单时间</td>
        <td class="col-sm-4"><input type="text" class="form-control unEditable" name="date" id="date"/></td>
    </tr>
    <tr>
        <td class="col-sm-2">发件人姓名：</td>
        <td class="col-sm-4"><input  class="form-control unEditable" name="sendername" id="sendername" /></td>
        <td>发件人手机号</td>
        <td><input type="text" class="form-control unEditable" name="senderphone" id="senderphone"  /></td>
    </tr>
    <tr>
        <td>发件人所在位置</td>
        <td><input type="text" class="form-control unEditable" name="senderlocation" id="senderlocation" /></td>
        <td>发件人详细地址</td>
        <td><input type="text" class="form-control unEditable" name="senderaddress" id="senderaddress" /></td>
    </tr>
    <tr>

        <td>收件人姓名</td>
        <td><input type="text" class="form-control unEditable" name="receivername" id="receivername" /></td>
        <td>收件人手机号</td>
        <td><input type="text" class="form-control unEditable" name="receiverphone" id="receiverphone" /></td>
    </tr>
    <tr>

        <td>收件人所在位置</td>
        <td><input type="text" class="form-control unEditable" name="receiverlocation" id="receiverlocation"  /></td>
        <td>收件人详细地址</td>
        <td><input type="text" class="form-control unEditable" name="receiveraddress" id="receiveraddress"/></td>
    </tr>
    <tr>
        <td>物品名称</td>
        <td><input type="text" class="form-control unEditable" name="goodsname" id="goodsname"  /></td>
        <td>物品数量</td>
        <td><input type="text" class="form-control unEditable" name="goodsquantity" id="goodsquantity"/></td>
    </tr>
    <tr>
        <td>物品重量</td>
        <td><input type="text" class="form-control unEditable" name="goodsweight" id="goodsweight"  /></td>
        <td>物品描述信息</td>
        <td><input type="text" class="form-control unEditable" name="goodsdesc" id="goodsdesc" /></td>
    </tr>
    <tr>
        <td>支付方式</td>
        <td><input type="text" class="form-control unEditable" name="paytype" id="paytype"  /></td>
        <td>运费</td>
        <td><input type="text" class="form-control unEditable" name="cost" id="cost" /></td>
    </tr>
    <tr>
        <td>订单状态</td>
        <td><input type="text" class="form-control unEditable" name="orderstate" id="orderstates"  /></td>
        <td>物流状态</td>
        <td><input type="text" class="form-control unEditable" name="state" id="states"  /></td>
    </tr>

    <tr>
        <td>订单备注</td>
        <td><input type="text" class="form-control unEditable" name="remark" id="remark" /></td>

    </tr>
</table>
&nbsp;&nbsp;&nbsp;物品图片<br>
<img  id="photo" name="photo" width="100%" height="100%"/>