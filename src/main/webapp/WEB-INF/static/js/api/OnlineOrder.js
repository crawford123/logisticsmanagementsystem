
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
function ClearNoNum(obj) {
    obj.value = obj.value.replace(/[^\d.]/g, "");
    obj.value = obj.value.replace(/^\./g, "");
    obj.value = obj.value.replace(/\.{2,}/g, ".");
    obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
}
function knexts() {
    var paytype=$("input[name='paytype']:checked").val();
    if (validateForm()) {
    var knext = function() {
        var jsonObj = new FormData($('#orderForm')[0]);
        // var jsonObj = $("#orderForm").serialize();
            $.ajax({
                type: "post",
                url: path + "/order/sendExpress",
                data: jsonObj,
                async: true,
                enctype: "multipart/form-data",
                contentType: false,
                processData: false,
                dataType: "json",
                success: function (data) {
                    var url = path + "/order/toSuccess";
                    if (data.code == "0000") {
                        window.location.href = url;
                        toastr.success(data.msg);
                    } else {
                        toastr.error(data.msg);
                        return false;
                    }
                }
            });
        };
        if(paytype=="0") {
            confirmMsg("亲，运费总共" + $('#cost').val() + "元，请现在支付哦~", null, "确认支付", "取消", knext);
        }else if(paytype=="1"){
            confirmMsg("亲，快递员即将上门，请记得使用现金支付哦~", null, "确认支付", "取消", knext);
        }
    }
}


function validateForm()
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

$("#seeRecord").click(function () {
    window.location.href = path+"/order/toOrderRecord";
});
$("#lookRecord").click(function () {
    window.location.href = path+"/order/toOrderRecord";
});
