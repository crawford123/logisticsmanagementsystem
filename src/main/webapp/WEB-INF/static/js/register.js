// 注册校验
function doRegister() {
    var username = $("#username").val();
    var password = $("#password").val();
    var confrimPassword = $("#confirmPassword").val();
    var age = $("#age").val();
    var sex=$("input[name='sex']:checked").val();
    var phone = $("#phone").val();
    var email = $("#email").val();
    var idnumber = $("#idnumber").val();

    // 表单校验
    if (username == "" || username == null) {
        toastr.error("请输入用户名")
        return false;
    } else if (verifyUsername("#username")) {
        toastr.error("用户名4到16位，必须包含字母，数字，下划线或减号");
        return false;
    }else if (password =="" || password == null) {
        toastr.error("请输入密码");
        return false;
    } else if (verifyPassword("#password")) {
        toastr.error("至少达到6位，至少包括1个大写字母，1个小写字母，1个数字，1个特殊字符");
        return false;
    }else if (confrimPassword =="" || confrimPassword == null) {
        toastr.error("请输入确认密码");
        return false;
    }else if (password!=confrimPassword) {
        toastr.error("确认密码必须和密码一致");
        return false;
    } else if (age =="" || age == null) {
        toastr.error("请输入年龄");
        return false;
    }else if (phone =="" || phone == null) {
        toastr.error("请输入手机号码");
        return false;
    }else if (verifyPhone("#phone")) {
        toastr.error("手机号码格式不正确");
        return false;
    }else if (email =="" || email == null) {
        toastr.error("请输入电子邮箱");
    }else if (verifyEmail("#email")) {
        toastr.error("邮箱格式不正确");
        return false;
    }else if (idnumber =="" || idnumber == null) {
        toastr.error("请输入身份证号码");
        return false;
    } else if (verifyIdNumber("#idnumber")) {
        toastr.error("身份证号码格式不正确");
        return false;
    }else if (sex =="" || sex == null) {
        toastr.error("请选择性别");
        return false;
    }else{
        toRegister();
    }
}
function toRegister() {
    var jsonObj = new FormData($('#registerForm')[0]);
    $.ajax({
        type :"post",
        url:path+"/userLoginRegister/genaralUserRegister",
        data : jsonObj,
        dataType: "json",
        async: true,
        enctype: "multipart/form-data",
        contentType: false,
        processData: false,
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

function doAdminRegister() {
    var username = $("#username").val();
    var password = $("#password").val();
    var confrimPassword = $("#confirmPassword").val();
    var age = $("#age").val();
    var sex=$("input[name='sex']:checked").val();
    var phone = $("#phone").val();
    var email = $("#email").val();
    var idnumber = $("#idnumber").val();

    // 表单校验
    if (username == "" || username == null) {
        toastr.error("请输入用户名")
        return false;
    } else if (verifyUsername("#username")) {
        toastr.error("用户名4到16位，必须包含字母，数字，下划线或减号");
        return false;
    }else if (password =="" || password == null) {
        toastr.error("请输入密码");
        return false;
    } else if (verifyPassword("#password")) {
        toastr.error("至少达到6位，至少包括1个大写字母，1个小写字母，1个数字，1个特殊字符");
        return false;
    }else if (confrimPassword =="" || confrimPassword == null) {
        toastr.error("请输入确认密码");
        return false;
    }else if (password!=confrimPassword) {
        toastr.error("确认密码必须和密码一致");
        return false;
    } else if (age =="" || age == null) {
        toastr.error("请输入年龄");
        return false;
    }else if (phone =="" || phone == null) {
        toastr.error("请输入手机号码");
        return false;
    }else if (verifyPhone("#phone")) {
        toastr.error("手机号码格式不正确");
        return false;
    }/*else if (email =="" || email == null) {
        toastr.error("请输入电子邮箱");
    }else if (verifyEmail("#email")) {
        toastr.error("邮箱格式不正确");
        return false;
    }*/else if (idnumber =="" || idnumber == null) {
        toastr.error("请输入身份证号码");
        return false;
    } else if (verifyIdNumber("#idnumber")) {
        toastr.error("身份证号码格式不正确");
        return false;
    }else if (sex =="" || sex == null) {
        toastr.error("请选择性别");
        return false;
    }else{
        toAdminRegister();
    }
}


function  toAdminRegister() {

    var jsonObj = new FormData($('#form')[0]);
    $.ajax({
        type :"post",
        url:path+"/userLoginRegister/adminRegister",
        data : jsonObj,
        dataType: "json",
        async: true,
        enctype: "multipart/form-data",
        contentType: false,
        processData: false,
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