<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@include file="../../../static/common/taglib.jsp"%>
<form id="newsForm" enctype="multipart/form-data">
<table class="table table-bordered table-striped">
    <tr id="tdId">
        <td class="col-sm-2">
            新闻编号
        </td>
        <td class="col-sm-2">
            <input type="text" class="form-control" name="newsid" id="newsid" />
        </td>
    </tr>
    <tr>
        <td class="col-sm-2">
            标题
        </td>
        <td class="col-sm-2">

            <input type="text" class="form-control" name="title" id="titles"  />
        </td>

        <td class="col-sm-2">
            新闻类型
        </td>
        <td class="col-sm-2">
            <select class="form-control input-sm" id="types" name="type">
                <option value="0">公司动态</option>
                <option value="1">公司公告</option>
                <option value="2">行业新闻</option>
            </select>
        </td>
    </tr>
    <tr id="time" style="display: none;">
        <td class="col-sm-2">
            发布时间
        </td>
        <td class="col-sm-2">
            <input type="text" class="form-control" name="publishtime" id="publishtimes"/>
        </td>
    </tr>
    <tr id="tdPhoto">
        <td class="col-sm-2">
            图片
        </td>
        <td class="col-sm-2">
            <img  width="100%" height="30%" id="photo"/>
          <div id="changePhoto"> 更换图片：<input type="file" class="icon-file" id="file" name="file" /></div>
        </td>
    </tr>

    <tr>
        <td class="col-sm-2">
            新闻内容
        </td>
        <td class="col-sm-4">
            <textarea class="form-control" id="content" name="content" rows="5"></textarea>
        </td>
    </tr>
</table>
</form>
