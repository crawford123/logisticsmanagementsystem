function doUpdateAccount() {
    var username = $("#username").val();
    var age = $("#age").val();
    var sex=$("input[name='sex']:checked").val();
    var phone = $("#phone").val();
    var email = $("#email").val();
    var idnumber = $("#idnumber").val();

    // 表单校验
    if (username == "" || username == null) {
        toastr.error("请输入用户名");
        return false;
    }else if (age =="" || age == null) {
        toastr.error("请输入年龄");
        return false;
    }else if (phone =="" || phone == null) {
        toastr.error("请输入手机号码");
        return false;
    }else if (email =="" || email == null) {
        toastr.error("请输入电子邮件");
        return false;
    }else if (idnumber =="" || idnumber == null) {
        toastr.error("请输入身份证号码");
        return false;
    }else if (sex =="" || sex == null) {
        toastr.error("请选择性别");
        return false;
    }else{
        toUpdateAccount();
    }
}
function toUpdateAccount() {
    var jsonObj = new FormData($('#updateAccountForm')[0]);
    $.ajax({
        type :"post",
        url:path+"/updateInformation/updateAccount",
        data : jsonObj,
        dataType: "json",
        async: true,
        enctype: "multipart/form-data",
        contentType: false,
        processData: false,
        success : function(data) {
            if (data.code == "0000") {
                toastr.success(data.msg);
                window.location.reload();
            }else{
                toastr.error(data.msg);
                return false;
            }

            }
    });
}


function doUpdatePassword() {
    var password = $("#password").val();
    var confirmPassword = $("#confirmPassword").val();
    // 表单校验
    if (password == "" || password == null) {
        toastr.error("请输入新密码");
        return false;
    }else if (verifyPassword("#password")) {
        toastr.error("至少达到6位，至少包括1个大写字母，1个小写字母，1个数字，1个特殊字符");
        return false;
    }else if (confirmPassword =="" || confirmPassword == null) {
        toastr.error("请输入确认密码");
        return false;
    }else if (confirmPassword!=password) {
        toastr.error("新密码和确认密码不一致");
        return false;
    }else {
        toUpdatePassword();
    }
}

function toUpdatePassword() {
    var jsonObj = $("#updatePassword").serialize();
    $.ajax({
        type :"post",
        url:path+"/updateInformation/updatePassword",
        data : jsonObj,
        dataType: "json",
        async: true,
        success : function(data) {
            if (data.code == "0000") {
                toastr.success(data.msg);
            }else{
                    toastr.error(data.msg);
                    return false;
                }
        }
    });
}



function doAdminUpdatePassword() {
    var oldPassword = $("#oldPassword").val();
    var password = $("#password").val();
    var confirmPassword = $("#confirmPassword").val();
    // 表单校验
    if (oldPassword == "" || oldPassword == null) {
        toastr.error("请输入旧密码");
        return false;
    }else if (password == "" || password == null) {
        toastr.error("请输入新密码");
        return false;
    }else if (verifyPassword("#password")) {
        toastr.error("至少达到6位，至少包括1个大写字母，1个小写字母，1个数字，1个特殊字符");
        return false;
    }else if (confirmPassword =="" || confirmPassword == null) {
        toastr.error("请输入确认密码");
        return false;
    }else if (confirmPassword!=password) {
        toastr.error("新密码和确认密码不一致");
        return false;
    }else {
        toUpdateAdminPassword();
    }
}
function  toUpdateAdminPassword() {

    var jsonObj = $("#form").serialize();
    $.ajax({
        type :"post",
        url:path+"/updateInformation/updateAdminPassword",
        data : jsonObj,
        dataType: "json",
        async: true,
        success : function(data) {
            if (data.code == "0000") {
                toastr.success(data.msg);
            }else{
                toastr.error(data.msg);
                return false;
            }
        }
    });

}


function doUpdateAdminAccount() {
    var username = $("#username").val();
    var age = $("#age").val();
    var sex=$("input[name='sex']:checked").val();
    var phone = $("#phone").val();
    var email = $("#email").val();
    var idnumber = $("#idnumber").val();

    // 表单校验
    if (username == "" || username == null) {
        toastr.error("请输入用户名");
        return false;
    }else if (age =="" || age == null) {
        toastr.error("请输入年龄");
        return false;
    }else if (phone =="" || phone == null) {
        toastr.error("请输入手机号码");
        return false;
    }else if (email =="" || email == null) {
        toastr.error("请输入电子邮件");
        return false;
    }else if (idnumber =="" || idnumber == null) {
        toastr.error("请输入身份证号码");
        return false;
    }else if (sex =="" || sex == null) {
        toastr.error("请选择性别");
        return false;
    }else{
        toUpdateAdminAccount();
    }
}
function toUpdateAdminAccount() {
    var jsonObj = new FormData($('#form')[0]);
    $.ajax({
        type :"post",
        url:path+"/updateInformation/updateAdminInfo",
        data : jsonObj,
        dataType: "json",
        enctype: "multipart/form-data",
        contentType: false,
        processData: false,
        success : function(data) {
            if (data.code == "0000") {
                toastr.success(data.msg);
                //window.location.href=path+"/updateInformation/toUpdateAdminInfo";
            }else{
                toastr.error(data.msg);
                return false;
            }
        },
        complete:function () {
            window.location.reload();
        }
    });
}

function  edit(){
    $('input').prop("disabled",false);
    return false;
}
