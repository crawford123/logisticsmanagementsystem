$(function() {
    showTitle();
    showGeneralUserDetail();
});

// 根据上个页面的选择来显示信息
function showTitle() {
    var detailType = $("#detailType").val();
    console.log("detailType的值为："+detailType);
    $("h3").html(eval("titleObj.title" + detailType));
}

function  reset(){
    $("#userid").prop("disabled",true);
    $("#userid").val(null);
    $("#username").val(null);
    $("#password").val(null);
    $("#age").val(null);
    $("#male").prop("disabled",false);
    $("#female").prop("disabled",false);
    $("#phone").val(null);
    $("#email").val(null);
    $("#idnumber").val(null);
}


// 根据返回的数据反显内容
function showGeneralUserDetail() {
    var detailType = $("#detailType").val();
    var $form = $("#singleStaffFrom");
    var url = $("#singleStaffFrom").prop("action");
    if (detailType == "0" || detailType == "3") {
        if (detailType == "3") {
            reset();
            $("#btnId").text(eval("btnNameObj.title" + detailType));
            $form.prop("action", path + "/user/addGeneralUser");
            $("#btnId").click(function() {
                var allDisabled = $(":disabled");
                var $form = $("#singleStaffFrom");
                if (!verifyInput($form)) {
                    allDisabled.prop("disabled", true);
                    return false;
                }
                var jsonObj = new FormData($('#singleStaffFrom')[0]);
            $.ajax({
                dataType: "json",
                async: true,
                enctype: "multipart/form-data",
                contentType: false,
                processData: false,
                url: $form.prop("action"),
                type: $form.prop("method"),
                data: jsonObj,
                success: function (data) {
                    if ("0000" != data.code) {
                        reset();
                        tipsMsg(data.msg);
                        return false;
                    }
                    tipsMsg(data.msg);
                    var toStaffList = path + "/user/manageUser";
                    window.location.href = toStaffList;
                }
            });
        });
        }
    } else {
        //查看
        if ("1" == detailType) {
            //按钮行为变成 “返回”
            $("#file").prop("disabled", true);
            $("#btnId").text(eval("btnNameObj.title" + detailType));
            $(".unEditable").prop("disabled", true).css("background", "#eee").unbind("click");
            $(".unEditable").prop("onclick", "");
            $("#btnId").prop("type", "button").click(function () {
                var toUrl = path + "/user/manageUser";
                window.location.href = toUrl;

            });
        }
        if ("2" == detailType){
            //按钮行为变成 “修改”
            $("#btnId").text(eval("btnNameObj.title" + detailType));
            $("#userid").prop("readonly", true);
            $("#female").prop("disabled", false);
            $("#male").prop("disabled", false);
            $("#btnId").click(function() {
                var allDisabled = $(":disabled");
                var $form = $("#singleStaffFrom");
                var jsonObj = new FormData($('#singleStaffFrom')[0]);
                if (!verifyInput($form)) {
                    allDisabled.prop("disabled", true);
                    return false;
                }
                $.ajax({
                    type :"post",
                    url: $form.prop("action"),
                    type: $form.prop("method"),
                    data: jsonObj,
                    enctype: "multipart/form-data",
                    contentType: false,
                    processData: false,
                    dataType: "json",
                    success: function (data) {
                        if ("0000" != data.code) {
                            tipsMsg(data.msg);
                            return false;
                        }
                        var toUrl = path + "/user/manageUser";
                        window.location.href = toUrl;
                    }

                });
            });

        }


        var isDisabled = detailType == "1" ? "disabled" : "";
        var isReadonly = detailType == "1" ? "readonly" : "";
        $.each(staffObj, function (k, v) {
            if (v == null || v == "null")
                v = false;
            if (!v)
                return;

            var $input = $("[name='" + k + "']");
            $input.val(v);
            $input.prop("disabled", isDisabled);
            $input.prop("readonly", isReadonly);
            if ($input.length < 0) {
                $input.hide();
                $("#singleStaffFrom").append("<input type='hidden' value='" + v + "' name='" + k + "' />");
            }

        });
    }


// 用于提交修改客户信息
    function ajaxSubmitForModify() {
        var detailType = $("#detailType").val();
        $('#btnId').click(function () {
            if ("2" != detailType && "3" != detailType) {
                return false;
            }
            //校验非空
            var allDisabled = $(":disabled");
            var $form = $("#singleStaffFrom");
            if (!verifyInput($form)) {
                allDisabled.prop("disabled", true);
                return false;
            }

            if ("3" == detailType) {
                //校验密码框是否非空
                var $staffPassword = $("[name='staffPassword']");
                var $reStaffPassword = $("[name='reStaffPassword']");
                var staffPassword = $staffPassword.val();
                var reStaffPassword = $reStaffPassword.val();
                if (!staffPassword) {
                    inputTips(newPinTips, "#staffPassword");
                    allDisabled.prop("disabled", true);
                    return false;
                }
                if (!reStaffPassword) {
                    inputTips(reNewPinTips, "#reStaffPassword");
                    allDisabled.prop("disabled", true);
                    return false;
                }
                //校验两次输入的 mPin是否一致
                if (staffPassword != $reStaffPassword.val()) {
                    tipsMsg(sameRePwd);
                    allDisabled.prop("disabled", true);
                    return false;
                }
                var maxLength = $staffPassword.prop("maxlength");
                if (maxLength) delAttribute($staffPassword, "maxlength");
                delAttribute($staffPassword, "maxlength");
                $staffPassword.val(encrypt(staffPassword));// 设置为加密数据
            }

            var staffClassId = $("[name='staffClassId']").val();
            if (typeof(staffClassId) == "undefined" || staffClassId == null || staffClassId == "") {
                tipsMsg("Please Select Staff Quota Type!");
                return false;
            }

            //提交form表单信息
            $.ajax({
                url: $form.prop("action"),
                type: $form.prop("method"),
                data: $form.serialize(),
                success: function (data) {
                    if ("0000" != data.code) {
                        allDisabled.prop("disabled", true);
                        if (maxLength > 0)
                            $staffPassword.prop("maxlength", maxLength);

                        $staffPassword.val(reStaffPassword);

                        tipsMsg(data.msg);
                        return false;
                    }
                    //修改
                    if ("2" == detailType) {
                        var staffInfoFromData = data.staffInfo;
                        var staffInfoElement = "";
                        $.each(staffInfoFromData, function (k, v) {
                            if (v) {
                                var inputElement = "<input name='" + k + "' value='" + v + "' type='hidden' />";
                                staffInfoElement += inputElement;
                            }
                        });
                        //新增完毕后跳转到员工查看页面
                        var toStaffList = function () {
                            location.href = path + "/user/manageUser";
                        }
                        tipsMsg(data.msg, null, toStaffList);

                        return false;
                    }
                    //新增
                    location.href = path + "/user/manageUser";
                }
            });
        });
    }
}

// 将不可改信息的input改为disabled
    function unEditable() {
        var detailType = $("#detailType").val();
        if ("3" != detailType) {
            $(".unEditable").prop("disabled", true).css("background", "#eee").unbind("click");
            $(".unEditable").prop("onclick", "");
        }

    }

