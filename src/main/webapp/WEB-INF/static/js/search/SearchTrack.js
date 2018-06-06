
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
     function indexQuery() {
         if ($("#logisticcode").val().trim() > 0){
             $("#beginsearch").click(function(){
                 $.ajax({
                     async: false,
                     type: "post",
                     dataType: "json",
                     url: path + "/order/getSelectiveTraces",
                     data: {logisticcode: $("#logisticcode").val().trim()},
                     success: function (data) {
                         if (data.code == "0000") {
                             $(".expressTel").text("电话:400-4000000000008");
                             $(".expressWebSite").attr("href", path + "/index/userIndex");
                             if (data.allCompleteOrders && data.allCompleteOrders.length > 0) {
                                 var traceLists = data.allCompleteOrders;
                                 $(".express-icon>span").text(traceLists[0].logisticcode);
                             }
                             if (data.allCompleteOrders && data.allCompleteOrders.length > 0) {
                                 var myHtml = "";
                                 var lineSty = "";
                                 var traceList = data.allCompleteOrders;
                                 $(".expressTitle").text(traceList[0].shippername);
                                 for (var i = 0; i < traceList.length; i++) {
                                     var trace = traceList[i];
                                     if (i == 0) {
                                         lineSty = "item-sub-head";
                                     }
                                     else if (i == (traceList.length - 1)) {
                                         lineSty = "item-sub-footer";
                                     }
                                     else {
                                         lineSty = "";
                                     }
                                     /* myHtml += "<li class='item'>" +
                                                      "<span class='item-sub1'>" + trace.accepttime + "</span>" +
                                                      "<span class='item-sub2 " + lineSty +"'></span>" +
                                                      "<span class='item-sub3'>" + trace.acceptstation + "</span>" +
                                                      /!* "<span class='item-sub3'>" + trace.remark + "</span>" +*!/
                                                  "</li>";*/

                                     myHtml += "<li class='afterdate first'><i class='node-icon'></i>" +
                                         /*"<span class='item-sub2'>" + lineSty +"</span>" +*/
                                         "<span class='date'>" + trace.accepttime + "</span>&nbsp;&nbsp;&nbsp;" +
                                         "<span class='txt'>" + trace.acceptstation + "</span>&nbsp;&nbsp;&nbsp;" +
                                        /* "<span class='txt'>" + trace.remark + "</span>" +*/
                                         "</li><br><br>";
                                 }
                                 $("#ultrack").empty();
                                 $("#ultrack").append(myHtml);
                                 $("#searchSuccess").show();
                                 $("#searchFail").hide();
                                 $(".express-companys").hide();
                             } else {//没有查询成功
                                 $("#searchSuccess").hide();
                                 $("#searchFail").show();
                                 $(".express-companys").hide();
                             }
                         }
                     }
                 });

             });
     }

}
function searchOrder()
{
    if ($("#logisticcode").val().trim().length<=0) {
        toastr.error("运单号必填！！");
        return false;
    }
        $.ajax({
            type: "post",
            dataType: "json",
            url: path + "/order/getSelectiveTraces",
            data: {logisticcode: $("#logisticcode").val().trim()},
            success: function (data) {
                if (data.code == "0000") {
                    $(".expressTel").text("电话:400-4000000000008");
                    $(".expressWebSite").attr("href", path + "/index/userIndex");
                    if (data.allCompleteOrders && data.allCompleteOrders.length > 0) {
                        var traceLists = data.allCompleteOrders;
                        $(".express-icon>span").text(traceLists[0].logisticcode);
                    }
                    if (data.allCompleteOrders && data.allCompleteOrders.length > 0) {
                        var myHtml = "";
                        var lineSty = "";
                        var traceList = data.allCompleteOrders;
                        $(".expressTitle").text(traceList[0].shippername);
                        for (var i = 0; i < traceList.length; i++) {
                            var trace = traceList[i];
                            if (i == 0) {
                                lineSty = "item-sub-head";
                            }
                            else if (i == (traceList.length - 1)) {
                                lineSty = "item-sub-footer";
                            }
                            else {
                                lineSty = "";
                            }
                            /* myHtml += "<li class='item'>" +
                                             "<span class='item-sub1'>" + trace.accepttime + "</span>" +
                                             "<span class='item-sub2 " + lineSty +"'></span>" +
                                             "<span class='item-sub3'>" + trace.acceptstation + "</span>" +
                                             /!* "<span class='item-sub3'>" + trace.remark + "</span>" +*!/
                                         "</li>";*/

                            myHtml += "<li class='afterdate first'><i class='node-icon'></i>" +
                                /*"<span class='item-sub2'>" + lineSty +"</span>" +*/
                                "<span class='date'>" + trace.accepttime + "</span>&nbsp;&nbsp;&nbsp;" +
                                "<span class='txt'>" + trace.acceptstation + "</span>&nbsp;&nbsp;&nbsp;" +
                                /* "<span class='txt'>" + trace.remark + "</span>" +*/
                                "</li><br><br>";
                        }
                        $("#ultrack").empty();
                        $("#ultrack").append(myHtml);
                        $("#searchSuccess").show();
                        $("#searchFail").hide();
                        $(".express-companys").hide();
                    } else {//没有查询成功
                        $("#searchSuccess").hide();
                        $("#searchFail").show();
                        $(".express-companys").hide();
                    }
                }
            }
        });

}



  function  toQueryOrder() {
      var logisticcode=$("#logisticcode").val();
      if(logisticcode =="" || logisticcode == null){
          toastr.error("请输入运单号！！");
          return false;
      }
      window.location.href=path+"/order/toQueryOrder?logisticcode="+logisticcode;
  }


