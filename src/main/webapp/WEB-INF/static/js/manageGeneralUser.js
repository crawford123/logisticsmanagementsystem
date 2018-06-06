var staffIdList = new Array();
$(function() {
    staffIdList = new Array();
    queryFirst();
    queryList();
});


// 查询列表
function queryList() {
    var callBackforsearch = function(data) {
        doAfterGetList(data);
    }
    ajaxSubmit("query", "form", false,callBackforsearch);
}

function ajaxSubmit(submitBtnId,formId,resetForm,callBack){
    var btnElement = $("#"+submitBtnId);
    var formElement = $("#"+formId);
    formElement.prop("action", path+"/user/getAllGeneralUsers");
    btnElement.click(function() {
        var username = $("#username").val();
            formElement.on("submit", function () {
                formElement.ajaxSubmit({
                    type: formElement.prop("method"),// 提交方式 get/post
                    url: formElement.prop("action"),
                    data: formElement.serialize(),
                    success: function (data) { // data 保存提交后返回的数据，一般为 json 数据
                        if (data.code == "0000") {
                            //tipsMsg(data.msg);
                            callBack(data);
                        } else {
                            tipsMsg(data.msg, errorIcon);
                        }
                    },
                    complete: function () {
                        if (resetForm) {
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
            if(data.code=="0000") {
                 //tipsMsg(data.msg);
                doAfterGetList(data);
            }else{
                tipsMsg(data.msg);
            }

        },
    });
    toDetails();
}

// 跳转页面
function toDetails() {
    var aElement = $("a[class='toDetail']");
    aElement.click(function() {
        var hasChecked = false;
        var thisElement = $(this);
        var k = aElement.index(thisElement);
        var checkList = new Array();
        $("#staffListTable input[type='checkbox']").each(function() {
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
        var url = $("#singleStaffFrom").prop("action");
        url = url.split("?")[0];
        if (k == 0) {
            var submitForm = function() {
                for(var i=0;i<staffIdList.length;i++){
                    $("#form").append($('<input type="hidden" value="'+staffIdList[i]+'" name="userid" class="staffIdFromCheckBox"/>'));
                }
                $.ajax({
                    type:"post",
                    url:path+"/user/deleteGeneralUser",
                    data:$(".staffIdFromCheckBox").serialize(),
                    success:function(data){
                        $(".staffIdFromCheckBox").remove();
                        location.reload();
                    }
                });
            };
            if(staffIdList.length < 1){
                tipsMsg(checkBoxNone);
                return false;
            }
            confirmMsg(tipsMsgMsg, null, confirmBtn, cancelBtn, submitForm);
            return false;
        } else if(k==1){
                   $("#singleStaffFrom").prop("action", url + "?detailType=" + k);
                    if(staffIdList.length==1) {
                        $("#form").append($('<input type="hidden" value="' + staffIdList[0] + '" name="userid" class="staffIdFromCheckBox"/>'));
                        console.log("staffIdList[0]的值为：" + staffIdList[0]);
                    }
                $.ajax({
                    type:"post",
                    url:path+"/user/getGeneralUser",
                    data:$(".staffIdFromCheckBox").serialize(),
                    success:function(data){
                        if (data.code == "0000") {
                            $(".staffIdFromCheckBox").remove();
                        }
                    }
                });
            }else if(k==2){
            $("#singleStaffFrom").prop("action", url + "?detailType=" + k);
            if(staffIdList.length==1) {
                $("#form").append($('<input type="hidden" value="' + staffIdList[0] + '" name="userid" class="staffIdFromCheckBox"/>'));
                console.log("staffIdList[0]的值为："+staffIdList[0]);
            }
            $.ajax({
                type:"post",
                url:path+"/user/getGeneralUser",
                data:$(".staffIdFromCheckBox").serialize(),
                success:function(data){
                    if (data.code == "0000") {
                        $(".staffIdFromCheckBox").remove();
                    }
                }
            });
        }else{
            $("#singleStaffFrom").prop("action", url + "?detailType=" + k);
        }
        $("#singleStaffFrom").submit();
    });
};


function doAfterGetList(data) {
    $("#detailLinkDiv").hide();
    var tbodyElement = $("#staffListTable tbody");
    tbodyElement.html("");
    var staffList = "";
    var object = data.page;
    if (object) {
        staffList = object.list;
        if(!staffList){
            staffList = "";
        }
    }
    var dataGird = "";
    for (var i = 0; i < staffList.length; i++) {
        var staffInfo = staffList[i];
        var trElement = "<tr><td><input class='childrenCheckBox' type='checkbox' value='"
            + staffInfo.userid
            + "'/></td>"
            + "<td>"
            + staffInfo.userid
            + "</td>"
            + "<td>"
            + staffInfo.username
            + "</td>"
            + "<td>"
            + staffInfo.sex
            + "</td>"
            + "<td>"
            + staffInfo.phone
            + "</td>"
            + "<td>"
            + staffInfo.idnumber
            + "</td>"
            + "<td>"
            + staffInfo.email
            + "</td></tr>";
        dataGird += trElement;
    }
    tbodyElement.html(dataGird);

    var dbCallBack = function (val, isAdd) {
        doListByCheckBox(staffIdList, val, isAdd);
    }

    tbodyElement.find("tr").each(function () {
        var $trElement = $(this);
        var $tdElement = $trElement.children("td:not(:first)");
        $tdElement.click(function () {
            var $checkBox = $trElement.find("input[type='checkbox']");
            var isCheck = $checkBox.prop("checked");
            $checkBox.prop("checked", !isCheck);
            isCheck = $checkBox.prop("checked");
            if (isCheck) {
                var k = tbodyElement.find("input[type='checkbox']").index($checkBox);
                getStaffInfoDataForm(staffList[k]);
            }
            doListByCheckBox(staffIdList, $checkBox.val(), isCheck);
        });
    });
    checkBoxClick();

    var checkboxInPage = tbodyElement.find("input[type='checkbox']");
    checkboxInPage.click(function () {
        if ($(this).prop("checked")) {
            var k = checkboxInPage.index($(this));
            getStaffInfoDataForm(staffList[k]);
        }
    });
    $("#detailLinkDiv").show();
    var pageMsg = data.page;
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
            last: 1,// $("input[class='navigatePages']").val(),
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

// 处理checkBox
function checkBoxClick() {
    var parentCheckBox = $("#parentCheckbox");
    var childrenCheckBox = $(".childrenCheckBox");

    // step1,当前页全选、取消全选
    parentCheckBox.click(function() {
        var isAllChecked = $(this).prop("checked");
        $("#staffListTable tbody tr td input[type='checkbox']").prop('checked',isAllChecked);
        staffIdList = new Array();
        if(isAllChecked){
            childrenCheckBox.each(function(){
                staffIdList.push($(this).val());
            });
        }
    });

    // step2,当前页面全选后单独取消选择一个
    childrenCheckBox.click(function() {
        doListByCheckBox(staffIdList, $(this).val(), $(this).prop("checked"));
    });
}

function getStaffInfoDataForm(staffInfo) {
    var staffInfoElement = "";
    $.each(staffInfo, function(k, v) {
        if(k=="staffMenus"){
            return;
        }
        if (v) {
            var inputElement = "<input name='" + k + "' value='" + v
                + "' type='hidden' />";
            staffInfoElement += inputElement;
        }

    });
    $("#singleStaffFrom").html(staffInfoElement);
}