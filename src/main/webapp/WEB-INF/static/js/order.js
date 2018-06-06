
function searchOrder() {
    var orderid = $("#orderid").val();
    if (orderid == "" || orderid == null) {
        inputTips("请输入订单编号", "#orderid")
    } else {
        toSearchOrder();
    }
}
    var loginAjaxIndex;
    function toSearchOrder() {
        var jsonObj = $("#orderForm").serialize();
        $.ajax({
            type :"post",
            url:path+"/order/getOrder",
            data : jsonObj,
            dataType: "json",
            cache: false,
            async: true,
            beforeSend: function () {
                loginAjaxIndex=layer.msg('loading', {
                    icon: 16
                    ,shade: 0.01
                });
            },
            success : function(data) {
                 var toUrl = path + "/index/generalUserIndex";
                if (data.code == "0000") {
                    window.location.href = toUrl;
                    tipsMsg(data.msg);
                }else{
                    tipsMsg(data.msg);
                    window.location.href = toUrl;
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


