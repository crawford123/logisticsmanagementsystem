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
    formElement.prop("action", path+"/orderReservation/getSelectiveManageOrderReservations");
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
    var object = data.pageReservations;
    if (object) {
        orderList = object.list;
        if(!orderList){
            orderList = "";
        }
    }
    var dataGird ="";
    var orderState = "";
    var reserveState="";
    var goodsname="";
    //列表构造
    for (var i = 0; i < orderList.length; i++) {
        switch(orderList[i].reservestate){
            case "0":
                reserveState = "预约中";
                break;
            case "1":
                reserveState = "预约失败";
                break;
            case "2":
                reserveState = "预约成功";
                break;
            case "3":
                reserveState = "取消预约";
                break;
            default:
                break;

        }

        switch (orderList[i].state) {
            case "0":
                orderState = "未揽件";
                break;
            case "1":
                orderState = "已揽件";
                break;
            case "2":
                orderState = "在途中";
                break;
            case "3":
                orderState = "已签收";
                break;
            case "4":
                orderState = "问题件";
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
        var trElement = "<tr><td><input  class='childrenCheckBox' type='checkbox' value='"
            + orderList[i].id
            + "' /></td>"
            + "<td>"
            + orderList[i].date+ "<br>" + orderList[i].ordercode
            + "</td>"
            + "<td>"
            + orderList[i].logisticcode
            + "</td>"
            + "<td>"
            + orderList[i].sendername+"<br>" + orderList[i].senderphone
            + "</td>"
            + "<td>"
            + orderList[i].receivername+"<br>" + orderList[i].receiverphone
            + "</td>"
            + "<td>"
            + goodsname
            + "</td>"
            + "<td>"
            + orderList[i].fetchdate
            + "</td>"
            + "<td>"
            + orderList[i].fetchstarttime
            + "</td>"
            + "<td>"
            + orderList[i].fetchendtime
            + "</td>"
            + "<td>"
            + reserveState
            + "</td>"
            + "<td>"
            + orderState
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
    var pageMsg = data.pageReservations;
    if(pageMsg){
        laypage({
            cont : $('#pageDiv'), // 容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div
            pages : pageMsg.pageReservations,// 总页数
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
    $("#updateOrderFrom").html(updateOrderFrom);
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
        var urls = $("#updateOrderFrom").prop("action");
        url = url.split("?")[0];
        //根据不同的选择来构造跳转方向 0为删除，1，2，3均为弹出信息

        if (k == 0) {
            $("#singleLimitFrom").prop("action", url + "?detailType=" + k);
            var submitForm = function() {
                $(".staffIdFromCheckBox").remove();
                for(var i=0;i<staffClassIdList.length;i++){
                    $("#form").append($('<input type="hidden" value="'+staffClassIdList[i]+'" name="id" class="staffIdFromCheckBox"/>'));
                }
                $.ajax({
                    type:"post",
                    dataType: "json",
                    url:path+"/orderReservation/deleteOrderReservationById",
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
            $("#form").append($('<input type="hidden" value="' + staffClassIdList[0] + '" name="id" class="staffIdFromCheckBox"/>'));
            console.log("id的值为："+staffClassIdList[0]);
            $.ajax({
                type:"post",
                dataType: "json",
                url:path+"/orderReservation/getOrderReservationbyId",
                data:$(".staffIdFromCheckBox").serialize(),
                success:function(data){
                    if (data.code == "0000") {
                        ajax(thisElement,data,k);
                        $(".staffIdFromCheckBox").remove();
                        //$(".kdn-details").show();
                    }
                }
            });
        }else if(k==2){
            $("#updateOrderFrom").prop("action", urls + "?detailType=" + k);
            $("#form").append($('<input type="hidden" value="' + staffClassIdList[0] + '" name="id" class="staffIdFromCheckBox"/>'));
            console.log("id的值为："+staffClassIdList[0]);
            $.ajax({
                type:"post",
                dataType: "json",
                async: false,
                url:path+"/orderReservation/getOrderReservationbyId",
                data:$(".staffIdFromCheckBox").serialize(),
                success:function(data){
                    if (data.code == "0000") {
                        ajax(thisElement,data,k);
                        $(".staffIdFromCheckBox").remove();
                    }
                }
            });
        }

    });
};

function ajax(thisElement,data,k) {
    if (k == 1) {
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
    }else if(k == 2){
        $.ajax({
            url: $("#updateOrderFrom").prop("action"),
            method: $("#updateOrderFrom").prop("method"),
            data: $("#updateOrderFrom").serialize(),
            success: function (data) {
                $("#windowIds").html(data);
            }, complete: function () {
                openWindows(thisElement.text(), confirmBtn, cancelBtn, k, data);
            }
        });

    }

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
    var orderState = "";
    var reservestate = "";
    if(datas!=null) {
        switch (datas.orderReservation.state) {
            case "0":
                orderState = "未揽件";
                break;
            case "1":
                orderState = "已揽件";
                break;
            case "2":
                orderState = "在途中";
                break;
            case "3":
                orderState = "已签收";
                break;
            case "4":
                orderState = "问题件";
                break;
            default:
                break;
        }
        switch (datas.orderReservation.reservestate) {
            case "0":
                reservestate = "预约中";
                break;
            case "1":
                reservestate = "预约失败";
                break;
            case "2":
                reservestate = "预约成功";
                break;
            case "3":
                reservestate = "取消预约";
                break;
            default:
                break;
        }
        console.log("orderState的值："+orderState);
        console.log("reservestate："+reservestate);
          $("#windowId").find("input").prop("disabled", true);
            $("#states").val(orderState);
            $("#reservestates").val(reservestate);
            $("#logisticcode").val(datas.orderReservation.logisticcode);
            $("#ordercodes").val(datas.orderReservation.ordercode);
            $("#date").val(datas.orderReservation.date);
            $("#sendername").val(datas.orderReservation.sendername);
            $("#receivername").val(datas.orderReservation.receivername);
            $("#senderphone").val(datas.orderReservation.senderphone);
            $("#receiverphone").val(datas.orderReservation.receiverphone);
            $("#senderaddress").val(datas.orderReservation.senderaddress);
            $("#receiveraddress").val(datas.orderReservation.receiveraddress);
            $("#goodsweight").val(datas.orderReservation.goodsweight + "kg");
            $("#goodsdesc").val(datas.orderReservation.goodsdesc);
            $("#goodsquantity").val(datas.orderReservation.goodsquantity + "个");
            $("#shippername").val(datas.orderReservation.shippername);
            $("#logisticcode").val(datas.orderReservation.logisticcode);
            $("#cost").val(datas.orderReservation.cost + "元");
            $("#senderlocation").val(datas.orderReservation.senderlocation);
            $("#receiverlocation").val(datas.orderReservation.receiverlocation);
            $("#goodsname").val(datas.orderReservation.goodsname);
            $("#remark").val(datas.orderReservation.remark);
            $("#photo").prop("src",path+"img/"+datas.orderReservation.goodsphoto);
        }

    layer.open({
        title:title,
        type: 1,
        area: ['95%', '85%'], //宽高
        btnAlign: 'c',
        btn: [btn1,btn2],
        yes: function(index, layero){
            layer.close(index);
            return false;

        },
        btn2: function(index, layero){
            layer.close(index);
            return false;
        },
        content: $("#windowId")
    });
}


function openWindows(title,btn1,btn2,type,datas) {
    var windowUrl = path + '/orderReservation/updateOrderReservationById';
    if(datas!=null) {
        switch (datas.orderReservation.state) {
            case "0":
                $("#orderState").find("option[text='未揽件']").attr("selected", true);
                break;
            case "1":
                $("#orderState").find("option[text='已揽件']").attr("selected", true);
                break;
            case "2":
                $("#orderState").find("option[text='在途中']").attr("selected", true);
                break;
            case "3":
                $("#orderState").find("option[text='已签收']").attr("selected", true);
                break;
            case "4":
                $("#orderState").find("option[text='问题件']").attr("selected", true);
                break;
            default:
                break;
        }
        switch (datas.orderReservation.reservestate) {
            case "0":
                $("#reserveState").find("option[text='预约中']").attr("selected", true);
                break;
            case "1":
                $("#reserveState").find("option[text='预约失败']").attr("selected", true);
                break;
            case "2":
                $("#reserveState").find("option[text='预约成功']").attr("selected", true);
                break;
            default:
                break;
        }
        $("#id").val(datas.orderReservation.id);
        //$("#logistic").val(datas.orderReservation.logisticcode);
    }
    layer.open({
        title:title,
        type: 1,
        area: ['auto', 'auto'], //宽高
        btnAlign: 'c',
        btn: [btn1,btn2],
        yes: function(index, layero){
            var reservestate=$("#reserveState").val();
            var orderstate=$("#orderState").val();
            var id=$("#id").val();
            var logistic=$("#logistic").val();
            //进行更改
            $.ajax({
                dataType: "json",
                type:"post",
                url:windowUrl,
                data:{state:orderstate,id:id,reservestate:reservestate},
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
        },
        content: $("#windowIds")
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

