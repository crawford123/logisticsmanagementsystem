var staffClassIdList = new Array();
$(function() {
    staffClassIdList = new Array();
    queryFirst();
    queryOrderList();
    toDetails();
});



// 查询列表
function queryOrderList() {
    var callBackforsearch = function(data) {
        doAfterGetList(data);
    }
    ajaxSubmit("query", "form", false,callBackforsearch);
}


function ajaxSubmit(submitBtnId,formId,resetForm,callBack){
    var btnElement = $("#"+submitBtnId);
    var formElement = $("#"+formId);
    formElement.prop("action", path+"/news/getAllNews");
    btnElement.click(function() {
        /*  var $disabled = $("disabled");
          if(!verifyInput(formElement)){
              $disabled.prop("disabled",true);
              return false;
          }*/
        formElement.on("submit", function() {
            formElement.ajaxSubmit({
                type : formElement.prop("method"),// 提交方式 get/post
                url : formElement.prop("action"),
                data : formElement.serialize(),
                success : function(data) { // data 保存提交后返回的数据，一般为 json 数据
                    if (data.code == "0000") {
                        //tipsMsg(data.msg);
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
    var formElement = $("#form");
    $.ajax({
        type : formElement.prop("method"),// 提交方式 get/post
        url : formElement.prop("action"),
        data : formElement.serialize(),
        success : function(data) { // data 保存提交后返回的数据，一般为 json 数据
            doAfterGetList(data);
        },
    });
}


function doAfterGetList(data) {
    $("#detailLinkDiv").hide();
    var tbodyElement = $("#limitListTable tbody");
    tbodyElement.html("");
    var orderList = "";
    var object = data.pageNews;
    if (object) {
        orderList = object.list;
        if(!orderList){
            orderList = "";
        }
    }
    var dataGird = ""
    //列表构造
    for (var i = 0; i < orderList.length; i++) {
        var type = "";
        switch (orderList[i].type) {
            case "0":
                type = "公司动态";
                break;
            case "1":
                type = "公司公告";
                break;
            case "2":
                type = "行业新闻";
                break;
            default:
                break;

        }
        var id = orderList[i].orderid;
        var trElement = "<tr><td><input  class='childrenCheckBox' type='checkbox' value='"
            + orderList[i].newsid
            + "'/></td>"
            + "<td>"
            + orderList[i].newsid
            + "</td>"
            + "<td>"
            + orderList[i].title
            + "</td>"
            + "<td><img  width='50%' height='50%' src='../img/"
            + orderList[i].photo
            + "'/></td>"
            + "<td>"
            + type
            + "</td>"
            + "<td>"
            + orderList[i].publishtime
            + "</td></tr>";
        dataGird += trElement;
    }
    tbodyElement.html(dataGird);

    var dbCallBack = function(val, isAdd) {
        doListByCheckBox(orderList, val, isAdd);
    }
    //点击tr
    tbodyElement.find("tr").each(function(){
        var $trElement =$(this);
        var $tdElement = $trElement.children("td:not(:first)");
        $tdElement.click(function(){
            var $checkBox = $trElement.find("input[type='checkbox']");
            var isCheck = $checkBox.prop("checked");
            $checkBox.prop("checked",!isCheck);
            isCheck = $checkBox.prop("checked");
            if(isCheck){
                var k = tbodyElement.find("input[type='checkbox']").index($checkBox);
                getLimitInfoDataForm(orderList[k]);
            }
            doListByCheckBox(staffClassIdList, $checkBox.val(), isCheck);
        });
    });
    //点击checkBox
    checkBoxClick();
    //点击后把所有信息填充到单项form中，方便后续显示用
    var checkboxInPage = tbodyElement.find("input[type='checkbox']");
    checkboxInPage.click(function() {
        if ($(this).prop("checked")) {
            var k = checkboxInPage.index($(this));
            getLimitInfoDataForm(orderList[k]);
        }
    });
    //分页组件调用
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
//把信息填充到单项form中，方便后续显示用
function getLimitInfoDataForm(limitInfo) {
    var limitInfoElement = "";
    $.each(limitInfo, function(k, v) {
        if (v) {
            var inputElement = "<input name='" + k + "' value='" + v
                + "' type='hidden' />";
            limitInfoElement += inputElement;
        }

    });
    $("#singleLimitFrom").html(limitInfoElement);
}
// 弹窗显示内容
function toDetails() {
    var aElement = $("a[class='toDetail']");
    aElement.click(function() {
        var hasChecked = false;
        var thisElement = $(this);
        var k = aElement.index(thisElement);
        console.log("k的值为："+k);
        var checkList = new Array();
        $("#limitListTable input[type='checkbox']").each(function() {
            var checkId = $(this).prop("id");
            if("parentCheckbox"==checkId){
                return;
            }
            hasChecked = $(this).prop("checked");
            if(hasChecked){
                checkList.push($(this));
            }
        });

        if (k == 1 || k == 2) {
            if(checkList.length==0){
                //选择0条数据
                tipsMsg(checkBoxNone);
                return false;
            }
            if(checkList.length>1){
                //选择0条数据
                tipsMsg(checkBoxOnlyOne);
                return false;
            }

        }
        var url = $("#singleLimitFrom").prop("action");
        url = url.split("?")[0];
        //根据不同的选择来构造跳转方向 0为删除，1，2，3均为弹出信息

        if (k == 0) {
            $("#singleLimitFrom").prop("action", url + "?detailType=" + k);
            var submitForm = function() {
                $(".staffIdFromCheckBox").remove();
                for(var i=0;i<staffClassIdList.length;i++){
                    $("#form").append($('<input type="hidden" value="'+staffClassIdList[i]+'" name="newsid" class="staffIdFromCheckBox"/>'));
                }
                $.ajax({
                    type:"post",
                    url:path+"/news/deleteNewsById",
                    data:$(".staffIdFromCheckBox").serialize(),
                    success:function(data){
                        if("0000"!=data.code){
                            tipsMsg(data.msg);
                            return false;
                        }
                        $(".staffIdFromCheckBox").remove();
                        window.location.reload();
                    }
                });
            };
            if(staffClassIdList.length < 1){
                tipsMsg(checkBoxNone);
                return false;
            }
            confirmMsg(tipsMsgMsg, null, confirmBtn, cancelBtn, submitForm);
            return false;
        } else if(k==1){
            $("#singleLimitFrom").prop("action", url + "?detailType=" + k);
            $("#form").append($('<input type="hidden" value="' + staffClassIdList[0] + '" name="newsid" class="staffIdFromCheckBox"/>'));
            $.ajax({
                type:"post",
                url:path+"/news/getNewsByTypeAndId",
                data:$(".staffIdFromCheckBox").serialize(),
                success:function(data){
                    if (data.code == "0000") {
                        ajax(thisElement,data,k);
                        $(".staffIdFromCheckBox").remove();
                    }
                }
            });
        }else if(k==2){
            $("#singleLimitFrom").prop("action", url + "?detailType=" + k);
            $("#form").append($('<input type="hidden" value="' + staffClassIdList[0] + '" name="newsid" class="staffIdFromCheckBox"/>'));
            $.ajax({
                type:"post",
                url:path+"/news/getNewsByTypeAndId",
                data:$(".staffIdFromCheckBox").serialize(),
                success:function(data){
                    if (data.code == "0000") {
                        ajax(thisElement,data,k);
                        $(".staffIdFromCheckBox").remove();
                    }
                }
            });
        }else if(k == 3){
            $("#singleLimitFrom").prop("action", url + "?detailType=" + k);
            $.ajax({
                url:$("#singleLimitFrom").prop("action"),
                method:$("#singleLimitFrom").prop("method"),
                data:$("#singleLimitFrom").serialize(),
                success:function(data){
                    $("#windowId").html(data);
                },complete:function(){
                    openWindow(thisElement.text(),confirmBtn,cancelBtn,k,null);
                }
            });
        }

    });
};

function ajax(thisElement,data,k) {
        //弹窗
        $.ajax({
            url: $("#singleLimitFrom").prop("action"),
            method: $("#singleLimitFrom").prop("method"),
            data: $("#singleLimitFrom").serialize(),
            success: function (data) {
                $("#windowId").html(data);
            }, complete: function () {
                openWindow(thisElement.text(), confirmBtn, cancelBtn, k, data);
            }
        });

}



// 处理checkBox
function checkBoxClick() {
    var parentCheckBox = $("#parentCheckbox");
    var childrenCheckBox = $(".childrenCheckBox");

    // step1,当前页全选、取消全选
    parentCheckBox.click(function() {
        var isAllChecked = $(this).prop("checked");
        $("#limitListTable tbody tr td input[type='checkbox']").prop('checked',isAllChecked);
        staffClassIdList = new Array();
        if(isAllChecked){
            childrenCheckBox.each(function(){
                staffClassIdList.push($(this).val());
            });
        }
    });

    // step2,当前页面全选后单独取消选择一个
    childrenCheckBox.click(function() {
        doListByCheckBox(staffClassIdList, $(this).val(), $(this).prop("checked"));
    });
}
// 根据选择的内容来操作idList
function doListByCheckBox(list, val, isAdd) {
    var listIndex = $.inArray(val, list);
    if (isAdd) {
        if (listIndex < 0) {
            list.push(val);
        }
    } else {
        list.splice(listIndex, 1)
    }

    $("#parentCheckbox").prop('checked',
        list.length == $(".childrenCheckBox").length);

}

function openWindow(title,btn1,btn2,type,datas) {
    var windowUrl="";
        if(type==1){
            switch (datas.news.type) {
                case "0":
                    $("#type").find("option[text='公司动态']").attr("selected", true);
                    break;
                case "1":
                    $("#type").find("option[text='公司公告']").attr("selected", true);
                    break;
                case "2":
                    $("#type").find("option[text='行业新闻']").attr("selected", true);
                    break;
            }
            $("#windowId").find("input").prop("disabled",true);
            $("#newsid").val(datas.news.newsid);
            $("#titles").val(datas.news.title);
            $("#publishtimes").val(datas.news.publishtime);
            $("#photo").attr("src",path+"/img/"+datas.news.photo);
            $("#content").val(datas.news.content);
            $("#content").prop("disabled",true);
            $("#types").prop("disabled",true);
            $("#changePhoto").hide();
        }else if(type==2){
            switch (datas.news.type) {
                case "0":
                    $("#type").find("option[text='公司动态']").attr("selected", true);
                    break;
                case "1":
                    $("#type").find("option[text='公司公告']").attr("selected", true);
                    break;
                case "2":
                    $("#type").find("option[text='行业新闻']").attr("selected", true);
                    break;
            }
            $("#newsid").prop("readonly",true);
            $("#newsid").val(datas.news.newsid);
            $("#titles").val(datas.news.title);
            $("#types").val(datas.news.type);
            $("#publishtimes").val(datas.news.publishtime);
            $("#photo").attr("src",path+"/img/"+datas.news.photo);
            $("#content").val(datas.news.content);
            windowUrl=path+"news/updateNews";
    }
    if(type==3){
        $("#titles").val(null);
        $("#types").val(null);
        $("#photo").hide();
        $("#publishtimes").val(CurentTime());
        $("#content").val(null);
        $("#tdId").hide();
        windowUrl=path+"news/addNews";
    }

    layer.open({
        title:title,
        type: 1,
        area: ['800px', '500px'], //宽高
        btnAlign: 'c',
        btn: [btn1,btn2],
        yes: function(index, layero){
            var jsonObj = new FormData($('#newsForm')[0]);
            $.ajax({
                dataType: "json",
                type:"post",
                url:windowUrl,
                data:jsonObj,
                enctype: "multipart/form-data",
                contentType: false,
                processData: false,
                success:function(data){
                    tipsMsg(data.msg);
                    if("0000"!=data.code){
                        return false;
                    }
                    layer.close(index);
                    location.reload();
                },complete:function(){

                }
            });

        },
        btn2: function(index, layero){
            layer.close(index);
            return false;
        },
        content: $("#windowId")
    });
}



function CurentTime()
{
    var now = new Date();

    var year = now.getFullYear();       //年
    var month = now.getMonth() + 1;     //月
    var day = now.getDate();            //日

    var hh = now.getHours();            //时
    var mm = now.getMinutes();          //分

    var clock = year + "-";

    if(month < 10)
        clock += "0";

    clock += month + "-";

    if(day < 10)
        clock += "0";

    clock += day + " ";

    if(hh < 10)
        clock += "0";

    clock += hh + ":";
    if (mm < 10) clock += '0';
    clock += mm;
    return(clock);
}

