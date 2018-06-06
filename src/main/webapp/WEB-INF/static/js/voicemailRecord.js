var staffClassIdList = new Array();
$(function() {
    staffClassIdList = new Array();
    queryFirst();
    queryOrderList();
});

// 查询列表
function queryOrderList() {
    var callBackforsearch = function(data) {
        getOrders(data);
        //window.location.href=path+"/order/toOrderRecord";
    }
    ajaxSubmit("query", "orderForm", false,callBackforsearch);
}


function ajaxSubmit(submitBtnId,formId,resetForm,callBack){
    var btnElement = $("#"+submitBtnId);
    var formElement = $("#"+formId);
    btnElement.click(function() {
        formElement.on("submit", function() {
            formElement.ajaxSubmit({
                type : formElement.prop("method"),// 提交方式 get/post
                url : formElement.prop("action"),
                data : formElement.serialize(),
                success : function(data) { // data 保存提交后返回的数据，一般为 json 数据
                    if (data.code == "0000") {
                        callBack(data);
                    }else{
                        tipsMsg(data.msg, errorIcon);
                    }
                },
                complete : function() {
                    if(resetForm){
                        formElement.resetForm(); // 提交后重置表单
                    }

                }
            });
            return false;
        });
    });
}




function queryFirst() {
    var formElement = $("#orderForm").serialize();
    $.ajax({
        type: $("#orderForm").prop("method"),// 提交方式 get/post
        url : $("#orderForm").prop("action"),
        data : formElement,
        success : function(data) { // data 保存提交后返回的数据，一般为 json 数据
            if(data.code=="0000") {
                getOrders(data);
            }
        },
    });
}

function getOrders(data) {
    var orderList=data.pageVoiceMails.list;
    var htmlStr = "";
    for (var i = 0; i <orderList.length; i++) {
        var orderState = "";
        switch (orderList[i].state) {
            case "0":
                orderState = "未回复";
                break;
            case "1":
                orderState = "已回复";
                break;
            default:
                break;
        }
        var id = orderList[i].vid;
        var trElement = "<tr class='tr-item'>"
            + "<td class='table-td'>"
            + orderList[i].voicemaildate
            + "</td>"
            + "<td class='table-td'><img  width='100%' height='auto' src='../img/"
            + orderList[i].photo
            +"'/></td>"
            + "<td class='table-td'>"
            + orderList[i].content
            + "</td>"
            + "<td class='table-td'>"
            + orderState
            + "</td>"
            + "<td class='table-td'>"
            + orderList[i].reply
            + "</td>"
            + "<td class='table-td'>"
            + orderList[i].replydate
            + "</td>"
            + "<td class='table-td choice-btn'>"
            + "<input class='bb-button-query' type='button' value='删除' onclick='checkDetail("+id+")'/>"
            + "</td></tr>";
        htmlStr += trElement;
    }

    $(".ordercontent").empty();
    $(".ordercontent").append(htmlStr);

    var pageMsg = data.pageVoiceMails;
    if (pageMsg) {
        laypage({
            cont: $('#pageDiv'), // 容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div
            pages: pageMsg.pages,// 总页数
            curr: pageMsg.pageNum,// 当前页
            skip: true, // 是否开启跳页，
            skipBtnName: skipBtnName,
            skipMsg: skipMsg,
            showPageMsg: true,// 开启页面信息
            total: pageMsg.total,// 总条目数
            pageMsg: pageMsgStr,// 页面信息内容展示，必须用中英文符号按照顺序写
            pageMsgFontSize: 13,
            btnType: "button",
            first: 1,
            last: pageMsg.pages,
            prev: '<', // 若不显示，设置false即可
            next: '>', // 若不显示，设置false即可
            jump: function (obj, first) { // 触发分页后的回调
                if (first)
                    return;
                $("[name='pageNum']").val(obj.curr);
                queryFirst();
            }
        });
    }

}

function  checkDetail(id) {
    console.log("id的值为："+id);
    var knext = function() {
        $.ajax({
            type: "post",
            url: path + "/voicemail/deleteSingleVoicemail",
            data: {vid: id},
            dataType: "json",
            success: function (data) {
                if (data.code == "0000") {
                    toastr.success(data.msg);
                    window.location.reload();
                } else {
                    toastr.error(data.msg);
                    return false;
                }
            }

        });
    };
    confirmMsg("确认删除吗？", null, "确认", "取消", knext);
}



