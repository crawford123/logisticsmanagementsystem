var staffClassIdList = new Array();
$(function() {
    staffClassIdList = new Array();
    queryFirst();
    // queryOrderList();
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
    $.ajax({
        type: "post",// 提交方式 get/post
        url : path+"/news/getAllNewsByDynamic",
        success : function(data) { // data 保存提交后返回的数据，一般为 json 数据
            if(data.code=="0000") {
                getOrders(data);
            }else{
                toastr.error(data.msg);
                return false;
            }
        },
    });
}

function getOrders(data) {
    var orderList =data.newsList;
    var htmlStr = "";
    for (var i = 0; i < orderList.length; i++) {
        var newsid = orderList[i].newsid;
        var trElement = "<li><a href='"+path+"/news/toNewsDetail?newsid=" + newsid + "'>" +
            "<img  style='width:306px;height:225.14px' src='../img/"
            +orderList[i].photo
            +"'><p class='news_detail_con'>"
            + orderList[i].title
            + "【<b style='color:#ed6900'>详情</b>】</p></a></li>";
        htmlStr += trElement;
    }
    $(".news_list").empty();
    $(".news_list").append(htmlStr);

    $("#detailLinkDiv").show();
}
