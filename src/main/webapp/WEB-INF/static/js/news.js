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
    var pageNum= $("#pageNum").val();
    var pageSize=$("#pageSize").val();
    $.ajax({
        type: "post",// 提交方式 get/post
        url : path+"/news/getAllNewsByType",
        data : {type:"2",pageNum:pageNum,pageSize:pageSize},
        success : function(data) { // data 保存提交后返回的数据，一般为 json 数据
            if(data.code=="0000") {
                getOrders(data);
            }
        },
    });
}

function getOrders(data) {
    var orderList = data.pageNews.list;
    var htmlStr = "";
    for (var i = 0; i < orderList.length; i++) {
        var newsid = orderList[i].newsid;
        var trElement = "<li><a href='"+path+"/news/toNewsDetail?newsid=" + newsid + "'>" +
            "<img  width='140' height='120' src='../img/"
            +orderList[i].photo
            +"'><div class='title'>"
            + orderList[i].title
            + "</div><p class='article'>"
            + orderList[i].content
            + "</p><p class='date'><span>申通快递</span>/<span>"
            + orderList[i].publishtime
            + "</span></p></a></li>"
        htmlStr += trElement;
    }

    $("#newsList").empty();
    $("#newsList").append(htmlStr);

    $("#detailLinkDiv").show();
    var pageMsg = data.pageNews;
    if(pageMsg){
        laypage({
            cont : $('#pageDiv'), // 容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div
            pages : pageMsg.pages,// 总页数
            curr : pageMsg.pageNum,// 当前页
            skip : true, // 是否开启跳页，
            skipBtnName:skipBtnName,
            skipMsg:skipMsg,
            showPageMsg : true,// 开启页面信息
            total : pageMsg.total,// 总条目数
            pageMsg : pageMsgStr,// 页面信息内容展示，必须用中英文符号按照顺序写
            pageMsgFontSize : 13,
            btnType : "button",
            first : 1,
            last : pageMsg.pages,
            prev : '<', // 若不显示，设置false即可
            next : '>', // 若不显示，设置false即可
            jump : function(obj, first) { // 触发分页后的回调
                if (first)
                    return;
                $("[name='pageNum']").val(obj.curr);
                queryFirst();
            }
        });
    }

}
