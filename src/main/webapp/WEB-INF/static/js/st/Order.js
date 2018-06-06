var flag = false;

//日期选择插件绑定
$(function () {
    //日期选择
    $( "#fetchdate" ).on( "click", function ( e )
    {
        document.getElementById( "fetchstarttime" ).value = null;
        document.getElementById( "fetchendtime" ).value = null;
        e.stopPropagation();
        $( this ).lqdatetimepicker( {
            css: 'datetime-day',
            dateType: 'D',
            selectback: function ()
            {
            }
        } );
    } );
    //开始时间
    $( "#fetchstarttime" ).on("click", function ( e )
    {

            var _SenderTime = document.getElementById( "fetchstarttime" ).value;
            var s = parseInt(( new Date ).getFullYear() + "" + ( ( new Date ).getMonth() + 1 ) + "" + ( new Date ).getDate() )//年月日,数值转int
            if ( parseInt( $( "#fetchdate" ).val().replace( '-', '' ).replace( '-', '' ) ) == s )
            {
                e.stopPropagation();
                $( this ).lqdatetimepicker( {
                    css: 'datetime-hour'
                }, "" );
            } else if ( parseInt( $( "#fetchdate" ).val().replace( '-', '' ).replace( '-', '' ) ) > s )
            {
                e.stopPropagation();
                $( this ).lqdatetimepicker2( {
                    css: 'datetime-hour'
                }, "" );
            } else
            {
                /*toastr.error( '抱歉您选择的时间已经成为过去!');
                return false;*/
            }

    } );
    //结束时间
    $( "#fetchendtime" ).on("click", function ( e )
    {
            var time = $( "#fetchstarttime" ).val();
            var times = time.split( ':' );
            var a = new Date( 2017, 4, 19, parseInt( times[0] ), parseInt( times[1] ) );
            var _SenderTime = addMinutes( 90, a ).getHours() + ":" + addMinutes( 90, a ).getMinutes();
            var s = parseInt(( new Date ).getFullYear() + "" + ( ( new Date ).getMonth() + 1 ) + "" + ( new Date ).getDate() )
            if ( parseInt( $( "#fetchdate" ).val().replace( '-', '' ).replace( '-', '' ) ) == s )
            {
                e.stopPropagation();
                $( this ).lqdatetimepicker( {
                    css: 'datetime-hour'
                }, _SenderTime );
            }
            else if ( parseInt( $( "#fetchdate" ).val().replace( '-', '' ).replace( '-', '' ) ) > s )
            {
                e.stopPropagation();
                $( this ).lqdatetimepicker2( {
                    css: 'datetime-hour'
                }, _SenderTime );
            } else
            {
                /*toastr.error( '抱歉您选择的时间已经成为过去!');
                return false;*/
            }

    });
} );

// 添加分钟
function addMinutes( dayNumber, date )
{
    date = date ? date : new Date();
    var ms = dayNumber * ( 1000 * 60 )
    var newDate = new Date( date.getTime() + ms );
    return newDate;
}
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

function validateForm()
{
    var isvalided = true;
    //校验表单数据
    $("#form").find(":input").each(function () {
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


//提交前校验
function submitForm()
{
    var Articleweight = $( "#goodsweight" ).val()
    //判断选择的日期是否大于今天的日期
    var _date = new Date();
    var dateNow = _date.toLocaleDateString();
    dateNow = dateNow.replace( '/', '' );
    dateNow = parseInt( dateNow.replace( '/', '' ) )//日期选择结果为yyyy/MM/dd 的形式,所以替换2次/
    var FetchTime = parseInt( $( "#fetchdate" ).val().replace( '-', '' ).replace( '-', '' ) );//
    if ( FetchTime < dateNow )
    {
       /* toastr.error( "抱歉,您选择的日期已成为过去!" )
        return false;*/
    }
    if ( Articleweight > 50 || Articleweight < 0 )
    {
        toastr.error( "重量不得大于50kg或小于0kg" );
        return false;
    }
    //开始检测上取件开始和结束时间是否合理
    var Fetchstartdate = parseInt( $( "#fetchstarttime" ).val().replace( ':', '' ) );
    var Fetchenddate = parseInt( $( "#fetchendtime" ).val().replace( ':', '' ) );
    if ( Fetchstartdate > Fetchenddate || Fetchstartdate == Fetchenddate )
    {
        toastr.error( "抱歉开始时间不能早等于结束时间" )
        return false;
    }

    ajaxPostOrderCreate()
}

//Ajax请求验证
function ajaxPostOrderCreate() {
    var paytype=$("input[name='paytype']:checked").val();
    if (validateForm()) {
        var knext = function() {
            var jsonObj = new FormData($('#form')[0]);
            //请求
            $.ajax({
                url: path + "/orderReservation/reserveOrder",
                type: "POST",
                data: jsonObj,
                async: true,
                enctype: "multipart/form-data",
                contentType: false,
                processData: false,
                dataType: "json",
                success: function (data) {
                    var url = path + "/orderReservation/toSuccess";
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
