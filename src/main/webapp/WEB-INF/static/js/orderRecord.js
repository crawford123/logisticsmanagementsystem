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
           type: "post",// 提交方式 get/post
           url : path+"/order/getOrders",
           data : formElement,
           success : function(data) { // data 保存提交后返回的数据，一般为 json 数据
             if(data.code=="0000") {
                 getOrders(data);
             }
        },
    });
}

function getOrders(data) {
    var orderList=data.pageOrders.list;
    var htmlStr = "";
    for (var i = 0; i <orderList.length; i++) {
        var orderState = "";
        var state = "";
        var goodsname="";
        switch (orderList[i].state) {
            case "0":
                state = "未揽件";
                break;
            case "1":
                state = "已揽件";
                break;
            case "2":
                state = "在途中";
                break;
            case "3":
                state = "已签收";
                break;
            case "4":
                state = "问题件";
                break;
            default:
                break;
        }
        switch (orderList[i].orderstate) {
            case "0":
                orderState = "已下订单";
                break;
            case "1":
                orderState = "已取消";
                break;
            case "2":
                orderState = "进行中";
                break;
            case "3":
                orderState = "已完成";
                break;
            default:
                break;
        }
        switch (orderList[i].goodsname) {
            case "0":
                goodsname = "服饰";
                break;
            case "1":
                goodsname = "食品";
                break;
            case "2":
                goodsname = "数码用品";
                break;
            case "3":
                goodsname = "生活用品";
                break;
            case "4":
                goodsname = "文件";
                break;
            case "5":
                goodsname = "其它";
                break;
            default:
                break;
        }
        var id = orderList[i].orderid;
        var trElement = "<tr class='tr-item'>"
            + "<td class='table-td'>"
            + orderList[i].date+ "<br>" + orderList[i].ordercode
            + "</td>"
            + "<td class='table-td'>"
            + orderList[i].sendername+"<br>" + orderList[i].senderphone
            + "</td>"
            + "<td class='table-td'>"
            + orderList[i].receivername+"<br>" + orderList[i].receiverphone
            + "</td>"
            + "<td class='table-td'>"
            + goodsname
            + "</td>"
            + "<td class='table-td'>"
            + orderList[i].goodsdesc
            + "</td>"
            + "<td class='table-td'>"
            + orderState
            + "</td>"
            + "<td class='table-td'>"
            + state
            + "</td>"
            + "<td class='table-td choice-btn'>"
            + "<button class='bb-button-query' onclick='checkDetail("+id+")'>订单详情</button>"
            + "</td>"
            + "<td class='table-td choice-btn'>"
            + "<button class='bb-button-query' onclick='cancelOrder("+id+")'>取消订单</button>"
            + "</td>"
            + "<td class='table-td choice-btn'>"
            + "<button class='bb-button-query' onclick='deleteOrder("+id+")'>删除订单</button>"
            + "</td></tr>"

        htmlStr += trElement;
    }

    $(".ordercontent").empty();
    $(".ordercontent").append(htmlStr);

    var pageMsg = data.pageOrders;
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
    $.ajax({
        type: "post",
        url: path + "/order/getOrdersByOrderId",
        data: {orderid:id},
        dataType: "json",
        success: function (data) {
            var toUrl = path + "/order/toOrderDetail";
            if (data.code == "0000") {
                window.location.href = toUrl;
            } else {
                toastr.error(data.msg);
                return false;
            }
        }

    });
}
function  deleteOrder(id) {
        var knext = function () {
            $.ajax({
                type: "post",
                url: path + "/order/deleteOrderByState",
                data: {orderid: id},
                dataType: "json",
                success: function (data) {
                    if (data.code == "0000") {
                        window.location.reload();
                        toastr.success(data.msg);
                    } else {
                        toastr.error(data.msg);
                        return false;
                    }
                }

            });
        };
        confirmMsg("确认删除订单吗？", null, "确认", "取消", knext);
}

function  cancelOrder(id) {
    var knext = function () {
        $.ajax({
            type: "post",
            url: path + "/order/updataOrderState",
            data: {orderid: id},
            dataType: "json",
            success: function (data) {
                if (data.code == "0000") {
                    window.location.reload();
                    toastr.success(data.msg);
                }else {
                    toastr.error(data.msg);
                    return false;
                }
            }

        });
    };
    confirmMsg("确认取消订单吗？", null, "确认", "取消", knext);
}

