var staffClassIdList = new Array();
$(function() {
    staffClassIdList = new Array();
    queryFirst();
    queryAdminList();
    toDetails();
});



// 查询列表
function queryAdminList() {
    var callBackforsearch = function(data) {
        doAfterGetList(data);
    }
    ajaxSubmit("query", "form", false,callBackforsearch);
}

function ajaxSubmit(submitBtnId,formId,resetForm,callBack){
    var btnElement = $("#"+submitBtnId);
    var formElement = $("#"+formId);
    formElement.prop("action", path+"/user/getAllAdmins");
    btnElement.click(function() {
       /* var $disabled = $("disabled");
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
    var limitList = "";
    var object = data.page;
    if (object) {
        limitList = object.list;
        if(!limitList){
            limitList = "";
        }
    }
    var dataGird = ""
    //列表构造
    for (var i = 0; i < limitList.length; i++) {
        var staffLimit = limitList[i];
        var trElement = "<tr><td><input  class='childrenCheckBox' type='checkbox' value='"
            + staffLimit.adminid
            + "' /></td>"
            + "<td>"
            + staffLimit.adminid
            + "</td>"
            + "<td>"
            + staffLimit.username
            + "</td>"
            + "<td>"
            + staffLimit.sex
            + "</td>"
            + "<td>"
            + staffLimit.phone
            + "</td>"
            + "<td>"
            + staffLimit.idnumber
            + "</td>"
            + "<td>"
            + staffLimit.email
            + "</td></tr>";
        dataGird += trElement;
    }
    tbodyElement.html(dataGird);

    var dbCallBack = function(val, isAdd) {
        doListByCheckBox(limitList, val, isAdd);
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
                getLimitInfoDataForm(limitList[k]);
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
            getLimitInfoDataForm(limitList[k]);
        }
    });
    //分页组件调用
    $("#detailLinkDiv").show();
    var pageMsg = data.page;
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

        }
        if(checkList.length>1){
            //选择0条数据
            tipsMsg(checkBoxOnlyOne);
            return false;
        }
        var url = $("#singleLimitFrom").prop("action");
        url = url.split("?")[0];
        //根据不同的选择来构造跳转方向 0为删除，1，2，3均为弹出信息

        if (k == 0) {
            $("#singleLimitFrom").prop("action", url + "?detailType=" + k);
            var submitForm = function() {
                $(".staffIdFromCheckBox").remove();
                for(var i=0;i<staffClassIdList.length;i++){
                    $("#form").append($('<input type="hidden" value="'+staffClassIdList[i]+'" name="adminid" class="staffIdFromCheckBox"/>'));
                }
                $.ajax({
                    type:"post",
                    url:path+"/user/deleteAdmin",
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
                $("#form").append($('<input type="hidden" value="' + staffClassIdList[0] + '" name="adminid" class="staffIdFromCheckBox"/>'));
                console.log("staffClassIdList[0]的值为：" + staffClassIdList[0]);
            $.ajax({
                type:"post",
                url:path+"/user/getAdmin",
                data:$(".staffIdFromCheckBox").serialize(),
                success:function(data){
                    if (data.code == "0000") {
                        console.log("adminid的值"+data.admin.adminid);
                        ajax(thisElement,data,k);
                        $(".staffIdFromCheckBox").remove();
                    }
                }
            });
        }else if(k==2){
            $("#singleLimitFrom").prop("action", url + "?detailType=" + k);
                $("#form").append($('<input type="hidden" value="' + staffClassIdList[0] + '" name="adminid" class="staffIdFromCheckBox"/>'));
                console.log("staffClassIdList[0]的值为："+staffClassIdList[0]);
            $.ajax({
                type:"post",
                url:path+"/user/getAdmin",
                data:$(".staffIdFromCheckBox").serialize(),
                success:function(data){
                    if (data.code == "0000") {
                        ajax(thisElement,data,k);
                        $(".staffIdFromCheckBox").remove();
                    }
                }
            });
        }else if(k==3){
            $("#singleLimitFrom").prop("action", url + "?detailType=" + k);
            var submitForm = function() {
                $(".staffIdFromCheckBox").remove();
                for(var i=0;i<staffClassIdList.length;i++){
                    $("#form").append($('<input type="hidden" value="'+staffClassIdList[i]+'" name="adminid" class="staffIdFromCheckBox"/>'));
                }
                $.ajax({
                    type:"post",
                    url:path+"/userLoginRegister/resetPassword",
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
            confirmMsg(tipsMsgMsgs, null, confirmBtn, cancelBtn, submitForm);
            return false;
        }
    });
};

function ajax(thisElement,data,k){
    //弹窗
    $.ajax({
        url:$("#singleLimitFrom").prop("action"),
        method : $("#singleLimitFrom").prop("method"),
        data:$("#singleLimitFrom").serialize(),
        success:function(data){
            $("#windowId").html(data);
        },complete:function(){
            openWindow(thisElement.text(),confirmBtn,cancelBtn,k,data);
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
    if (datas != null) {
        if(datas.admin.sex =="男"){
            $("#male").prop("checked",true);
        }else {
            $("#female").prop("checked",true);
        }
        $("#adminid").val(datas.admin.adminid);
        $("#usernames").val(datas.admin.username);
        $("#password").val(datas.admin.password);
        $("#photo").prop("src",path+"img/"+datas.admin.photo);
        $("#age").val(datas.admin.age);
        $("#phones").val(datas.admin.phone);
        $("#email").val(datas.admin.email);
        $("#idnumbers").val(datas.admin.idnumber);
        if(type==2) {
            $("#adminid").prop("disabled",true);
            var windowUrl = path + '/user/modifyAdmin';
        }else if(type==1){
            $("#windowId").find("input").prop("disabled",true);
        }
    }
    layer.open({
        title:title,
        type: 1,
        area: ['800px', 'auto'], //宽高
        btnAlign: 'c',
        btn: [btn1,btn2],
        yes: function(index, layero){
            if(type==1){
                layer.close(index);
                return false;
            }
            //非空判断
            var $disabled = $("disabled");
            if(!verifyInput($("#windowId"))){
                $disabled.prop("disabled",true);
                return false;
            }

            //进行更改
            $.ajax({
                type:"post",
                url:windowUrl,
                data:$("#windowId").find("input").serialize(),
                success:function(data){
                    tipsMsg(data.msg);
                    if("0000"!=data.code){
                        $disabled.prop("disabled",true);
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
        content: $("#windowId")
    });
}

