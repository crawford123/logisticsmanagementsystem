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
// 登录校验
function doVoicemail() {
    var content = $("#content").val();
    // 表单校验
   if (content =="" || content == null) {
       toastr.error("请输入你的评价内容！！")
       return false;
    }else{
       toVoicemail();
    }

}


function toVoicemail() {
    var jsonObj = new FormData($('#voicemailForm')[0]);
    $.ajax({
        type :"post",
        url:path+"/voicemail/voicemail",
        data : jsonObj,
        dataType: "json",
        enctype:"multipart/form-data",
        contentType: false,
        processData: false,
        success : function(data) {
            var url=path+"/voicemail/toVoicemailRecord";
            if (data.code == "0000") {
                toastr.success("留言成功！！");
                window.location.href=url;
            }else{
                toastr.error("留言失败！！");
                return false;
            }
        }
    });
}
/*
layui.use('upload', function(){
    var $ = layui.jquery,upload = layui.upload;

    //普通图片上传
    var uploadInst = upload.render({
        elem: '#test1'
        ,url: '/upload/'
        ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#demo1').attr('src', result); //图片链接（base64）
            });
        }
        ,done: function(res){
            //如果上传失败

       if(res.code > 0){
                return layer.msg('上传失败');
            }
            //上传成功
        }
        ,error: function(){
            //演示失败状态，并实现重传
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function(){
                uploadInst.upload();
            });
        }
    });

    //绑定原始文件域
    upload.render({
        elem: '#test20'
        ,url: '/upload/'
        ,done: function(res){
            console.log(res)
        }
    });
});*/
