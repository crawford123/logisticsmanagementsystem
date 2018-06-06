var staffClassIdList = new Array();
$(function() {
    staffClassIdList = new Array();
    queryFirst();

});

function queryFirst() {
    var newsid=$("#newsid").val();
    $.ajax({
        type: "post",// 提交方式 get/post
        url : path+"/news/getNewsByTypeAndId",
        data : {newsid:newsid},
        success : function(data) { // data 保存提交后返回的数据，一般为 json 数据
            if(data.code!="0000") {
                return false;
            }
        },
    });
}





