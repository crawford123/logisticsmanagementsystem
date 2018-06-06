$(function() {
    passvalue();
    changeState();
    getTraces();

});


function  passvalue() {

    var  logisticcode= $("#logisticcode").text();
    var  paytype= $("#paytype").text();
    var  state=$("#state").text();
    var  orderstate=$("#orderstate").text();
    var  reservestate=$("#reservestate").text();
    var  goodsname=$("#goodsname").text();
    if(logisticcode.length<=0){
        $("#logisticcode").text("暂无货运单号");
    }
    switch (goodsname) {
        case "0":
            $("#goodsname").text("服饰");
            break;
        case "1":
            $("#goodsname").text("食品");
            break;
        case "2":
            $("#goodsname").text("数码用品");
            break;
        case "3":
            $("#goodsname").text("生活用品");
            break;
        case "4":
            $("#goodsname").text("文件");
            break;
        case "5":
            $("#goodsname").text("其它");
            break;
        default:
            break;
    }
    switch (reservestate) {
        case "0":
            $("#reservestate").text("预约中");
            break;
        case "1":
            $("#reservestate").text("预约失败");
            break;
        case "2":
            $("#reservestate").text("预约成功");
            break;
        case "3":
            $("#reservestate").text("取消预约");
            break;
        default:
            break;
    }
    switch (paytype) {
        case "0":
            $("#paytype").text("在线支付");
            $("#payResult").text("在线支付成功");
            break;
        case "1":
            $("#paytype").text("现金支付");
            $("#payResult").text("使用现金支付");
            break;
        default:
            break;
    }
    switch (paytype) {
        case "0":
            $("#paytype").text("在线支付");
            $("#payResult").text("在线支付成功");
            break;
        case "1":
            $("#paytype").text("现金支付");
            $("#payResult").text("使用现金支付");
            break;
        default:
            break;
    }
    switch (state) {
        case "0":
            $("#state").text("未揽件");
            break;
        case "1":
            $("#state").text("已揽件");
            break;
        case "2":
            $("#state").text("在途中");
            break;
        case "3":
            $("#state").text("已签收");
            break;
        case "4":
            $("#state").text("问题件");
            break;
        default:
            break;
    }

}
function  changeState() {
    var state = $("#state").text();
    switch (state) {
        case "未揽件":
            $("#submitReady").addClass("ready");
            $("#payDone").addClass("done");
            $("#payReady").addClass("ready");
            break;
        case "已揽件":
            $("#submitReady").addClass("ready");
            $("#payDone").addClass("done");
            $("#payReady").addClass("ready");
            $("#acceptDone").addClass("done");
            $("#acceptReady").addClass("ready");
            break;
        case "在途中":
            $("#submitReady").addClass("ready");
            $("#payDone").addClass("done");
            $("#payReady").addClass("ready");
            $("#acceptDone").addClass("done");
            $("#acceptReady").addClass("ready");
            $("#roadDone").addClass("done");
            $("#roadReady").addClass("ready");
            break;
        case "已签收":
            $("#submitReady").addClass("ready");
            $("#payDone").addClass("done");
            $("#payReady").addClass("ready");
            $("#acceptDone").addClass("done");
            $("#acceptReady").addClass("ready");
            $("#roadDone").addClass("done");
            $("#roadReady").addClass("ready");
            $("#receiveDone").addClass("done");
            $("#receiveReady").addClass("ready");
            break;
        case "问题件":
            break;
        default:
            break;
    }
}

function  getTraces() {
    var id= $("#orderid").val();
    $.ajax({
        type: "post",
        url : path+"/orderReservation/getTracesByOrderId",
        data :{id:id},
        success : function(data) { // data 保存提交后返回的数据，一般为 json 数据
            if(data.code=="0000") {
                doAfterGetTraces(data);
            }
        },
    });

}

function doAfterGetTraces(data) {
    var traceList = data.allTracesReservation;
    var htmlStr = "";
    if (traceList.length> 0){
        console.log("traceList的长度为：" + traceList.length);
        for (var i = 0; i < traceList.length; i++) {
            var traces = traceList[i];
            htmlStr += "<li class='afterdate first'><i class='node-icon'></i>" +
                "<span class='date'>" + traces.accepttime + "&nbsp;&nbsp;</span>" +
                "<span class='txt'>" + traces.acceptstation + "</span>" +
               /* "<span class='txt'>" + traces.remark + "</span>" +*/
                "</li><br/>";
        }
        $("#trackList").empty();
        $("#trackList").append(htmlStr);
    }else{
        $("#trackList").append("暂无任何订单轨迹信息！！");

    }
}


