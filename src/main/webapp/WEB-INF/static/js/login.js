// 登录校验
function doLogin() {
    var username = $("#username").val();
    var password = $("#password").val();

    // 表单校验
    if (username == "" || username == null) {
        toastr.error("请输入用户名");
        return false;
    }else if (password =="" || password == null) {
        toastr.error("请输入密码");
        return false;
    }else{
        toLogin();
    }

}

function validateloginForm()
{
    var isvalided = true;
    //校验表单数据
    $("#orderForm").find(":input").each(function () {
        var validateValue = $(this).attr("validate-info");
        if (validateValue && (validateValue == "发件人手机号" || validateValue == "收件人手机号")) {
            if (!(/^[1]+[3-8]+\d{9}$/ig).test($(this).val())) {
                toastr.clear();
                toastr.error("请输入正确的" + validateValue);
                isvalided = false;
                return false;
            }
        }
        if (validateValue && (validateValue == "发件人省市区" || validateValue == "收件人省市区")) {
            if ($(this).val().split("/", 3).length != 3) {
                toastr.clear();
                toastr.error("请选择完整" + validateValue);
                isvalided = false;
                return false;

            }
        }
        if (validateValue != null && $(this).val().length <= 0) {
            toastr.clear();
            toastr.error(validateValue + "必填");
            isvalided = false;
            return false;
        }
    });
    return isvalided;
}


function toLogin() {
    var jsonObj = $("#loginForm").serialize();
    $.ajax({
        type :"post",
        url:path+"/userLoginRegister/genaralUserLogin",
        data : jsonObj,
        dataType: "json",
        async: true,
        success : function(data) {
            var toUrl = path + "/index/userIndex";
            if (data.code == "0000") {
                toastr.success(data.msg);
                window.location.href = toUrl;
            }else{
                toastr.error(data.msg);
                return false;
            }
        }
    });
}


function validateadminForm()
{
    var isvalided = true;
    //校验表单数据
    $("#adminLoginForm").find(":input").each(function () {
        var validateValue = $(this).attr("validate-info");
        if (validateValue && (validateValue == "发件人手机号" || validateValue == "收件人手机号")) {
            if (!(/^[1]+[3-8]+\d{9}$/ig).test($(this).val())) {
                toastr.clear();
                toastr.error("请输入正确的" + validateValue);
                isvalided = false;
                return false;
            }
        }
        if (validateValue && (validateValue == "发件人省市区" || validateValue == "收件人省市区")) {
            if ($(this).val().split("/", 3).length != 3) {
                toastr.clear();
                toastr.error("请选择完整" + validateValue);
                isvalided = false;
                return false;

            }
        }
        if (validateValue != null && $(this).val().length <= 0) {
            toastr.clear();
            toastr.error(validateValue + "必填");
            isvalided = false;
            return false;
        }
    });
    return isvalided;
}


 function doAdminLogin() {
    if(validateadminForm()) {
        var jsonObj = $("#adminLoginForm").serialize();
        $.ajax({
            type: "post",
            url: path + "/userLoginRegister/adminLogin",
            data: jsonObj,
            dataType: "json",
            async: true,
            cache: true,
            success: function (data) {
                var toUrl = path + "/index/adminIndex";
                if (data.code == "0000") {
                    toastr.success(data.msg);
                    window.location.href = toUrl;
                } else {
                    toastr.error("用户名或密码错误！！");
                    return false;
                }
            }

        });
    }else{
        return false;
    }

 }



