<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@include file="../../../static/common/taglib.jsp"%>

<table class="table table-bordered table-striped">
    <tr>

        <td class="col-sm-2">
            留言时间
        </td>
        <td class="col-sm-2">
            <input type="text" class="form-control" name="voicemaildate" id="voicemaildate"  />
        </td>
    </tr>

    <tr id="tdPhoto">
        <td class="col-sm-2">
            图片
        </td>
        <td class="col-sm-2">
          <img  width="100%" height="30%" id="photo" name="photo"/>
        </td>
    </tr>

    <tr>
        <td class="col-sm-2">
            留言内容
        </td>
        <td class="col-sm-4">
            <textarea class="form-control" id="content" name="content" rows="5"></textarea>
        </td>

    </tr>
    <tr id="trReplyDate">

        <td class="col-sm-2">
            回复时间
        </td>
        <td class="col-sm-2">
            <input type="text" class="form-control" name="replydate" id="replydate"/>
        </td>
    </tr>
    <tr>
        <td class="col-sm-2">
            回复内容
        </td>
        <td class="col-sm-4">
            <textarea class="form-control" id="reply" name="reply" rows="5"></textarea>
            <input type="hidden" class="form-control" name="vid" id="vid"/>
            <input type="hidden" class="form-control" name="state" id="state"/>
        </td>
        </td>

    </tr>


</table>
