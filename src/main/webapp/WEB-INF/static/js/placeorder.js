// 注册校验
function doRegister() {
    var sendername = $("#sendername").val();
    var senderphone = $("#senderphone").val();
    var recipientname = $("#recipientname").val();
    var recipientPhone = $("#recipientPhone").val();
    var companyName = $("#companyName").val();
    var receivingAddress = $("#receivingAddress").val();
    var shippingcost = $("#shippingcost").val();

    // 表单校验
    if (username == "" || username == null) {
        inputTips("请输入用户名", "#username")
    }else if (password =="" || password == null) {
        inputTips("请输入密码", "#password")
    }else if (confrimPassword =="" || confrimPassword == null) {
        inputTips("请输入确认密码", "#confrimPassword")
    }else if (age =="" || age == null) {
        inputTips("请输入年龄", "#age")
    }else if (phone =="" || phone == null) {
        inputTips("请输入手机号码", "#phone")
    }else if (email =="" || email == null) {
        inputTips("请输入电子有限", "#email")
    }else if (idnumber =="" || idnumber == null) {
        inputTips("请输入身份证号码", "#idnumber")
    }else if (password!=confrimPassword) {
        inputTips("确认密码必须和密码一致", "#confrimPassword")
    }else{
        toRegister();
    }

}

var loginAjaxIndex;
function toPlaceOrder() {
   // var jsonObj = $("#placeOrderForm").serialize();
    var formData = new FormData($("#placeOrderForm")[0]);
    $.ajax({
        type :"POST",
        url:path+"/order/placeOrder",
        data : formData,
        dataType: "json",
        enctype:"multipart/form-data",
        contentType: false,
        processData: false,
        beforeSend: function () {
            loginAjaxIndex=layer.msg('loading', {
                icon: 16
                ,shade: 0.01
            });
        },
        success : function(data) {
            var toUrl = path + "/index/generalUserIndex";
            if (data.code == "0000") {
                tipsMsg(data.msg);
                sessionStorage.removeItem("pageLocalUrl");
                window.location.href = toUrl;
            }else{
                tipsMsg(data.msg);
                $(".bb-layer-left-shade").remove();
                $(".bb-layer-top-shade").remove();
                return false;
            }
        },
        complete:function(){
            layer.close(loginAjaxIndex);
        }

    });
}
