/// <reference path="../libs/jquery-powerFloat-min.js" />
/// <reference path="../libs/jquery-powerFloat-min.js" />
//数字增加空格分割，均匀拆分
function DealString(parm,len){
    var parms=parm.split("");
    if (parms == null || parms=="")
    {
        return "";
    }
    var str="";
    for(var a=0;a<parms.length;a++)
    {
        if((a+1)%len==0)
        str+=parms[a]+"&nbsp;&nbsp;";
        else
        str+=parms[a];
    }
    return str;
}

//拆分手机号
function DealMobilePhone(parm,startLen,laterLen)
{
    var parms=parm.split("");
    if (parms == null || parms=="" || parms.length<=0)
    {
        return "";
    }
    var str="";
    for(var a=0;a<parms.length;a++)
    {
        if((a+1-startLen)==0)
        str+=parms[a]+"&nbsp;&nbsp;";
        else if((a+1-startLen)%laterLen==0)
        str+=parms[a]+"&nbsp;&nbsp;";
        else
        str+=parms[a];       
    }
    return str;
}

//获取URL中的request参数
function getUrlParam(name){   
     var reg = new RegExp("(^|&)"+   name   +"=([^&]*)(&|$)"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r!=null) 
    {return decodeURIComponent(r[2]);}
    else
    {return ""; }
    
}
//将日期转换成"yyyy-mm-dd"格式 第二个参数为返回类型传入'ym':yyyy-mm,'md':mm-dd,默认为'yyyy-mm-dd'
function ConvertDateFormat(strDate,sye){   
    if (strDate ==null || strDate=="" || strDate=="0"){
         return (""); 
    }
    else{      
        try{
            var ExDate = new Date(strDate.replace(/-/g, "/")); 
            var yyyy = ExDate.getFullYear();
            var mm = ExDate.getMonth() +1;mm = mm<10?"0"+mm:mm;            
            var dd = ExDate.getDate();dd = dd<10?"0"+dd:dd;   
            switch(sye){  
                case "ym":
                    return yyyy + "-" + mm;
                    break;
                case "md":
                    return mm + "-" + dd;
                    break;
                default: 
                    return yyyy + "-" + mm + "-" + dd ;
                    break;
            }
        }
        catch(e){
            return("")
        }      
    }
}
//验证空值，字数限制
function ValidatorNum(objName,num,tip,objTipID)
{
   var str= $("#"+objName).val(); 
   var ObjTip=$("#"+objTipID);
   
    if(str=="") 
    {
        ObjTip.html(tip+"不能为空！");
        ObjTip.removeClass("g-d-n");
        
        document.getElementById(objName).focus();
        return false;
    }else{
        if(str.length>num) {
           ObjTip.html(tip+"不能超过"+num+"个字");
           ObjTip.removeClass("g-d-n");
           
           document.getElementById(objName).focus();
           return false; 
           }else{
           ObjTip.addClass("g-d-n");
           return true; 
           }
     }
 }

 //验证空值
 function ValidatorStr(objName,tip, objTipID) {
     var str = $("#" + objName).val();
     var ObjTip = $("#" + objTipID); 
     if (str == "") {
         ObjTip.html(tip + "不能为空！");
         ObjTip.removeClass("g-d-n"); 
         document.getElementById(objName).focus();
         return false;
     }
     else {
         ObjTip.addClass("g-d-n");
         return true;
     }
 }

//验证字符长度
function ValidatorNumber(str, minNum, maxNum) { 
    str = $.trim(str);
    var len = Number(str.length);
    if (len < minNum || len > maxNum)
        return false;
    else
        return true;
}
//验证邮箱
function ValidatorEmail(objName,objTipID)
{
  var str= document.getElementById(objName).value; 
  var ObjTip=$("#"+objTipID);
  
  if(str=="") 
    {
        ObjTip.html("邮箱不能为空");
        ObjTip.removeClass("g-d-n");
        
        document.getElementById(objName).focus();
       return false;
    }else{
         var filter= /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
         if (!filter.test(str)) {
           ObjTip.html("邮箱格式不正确");
           ObjTip.removeClass("g-d-n");
           
           document.getElementById(objName).focus();
           return false; 
           }else{
           ObjTip.addClass("g-d-n");
           return true; 
           }
     }  
}
//验证是否网址
function VaildaLink(linkStr)
{
	var sTest=/^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
	if(""!=linkStr)
  	{	  	
	  	if(sTest.test(linkStr))
	  	{
	  		return true;
	  	}
		else
		{
			return false;
		}
  	}
}

//验证手机号
function ValidatorPhone(objName,tip,objTipID)
{ 
  var str= document.getElementById(objName).value; 
  var ObjTip=$("#"+objTipID);
  
  if(str=="") 
    {
        ObjTip.html("不能为空");
        ObjTip.removeClass("g-d-n");
        
        document.getElementById(objName).focus();
      return false;
    }else{
         var r= /^1[3458]\d{9}$/;
         if (!r.test(str)) {
           ObjTip.html("格式不正确");
           ObjTip.removeClass("g-d-n");

           document.getElementById(objName).focus();
           return false; 
           }else{
           ObjTip.addClass("g-d-n");
           return true; 
           }
     }  
}
//验证是否为数字型
function IsDecimal(str) {
    if (str == "" || str == null) {
        return true;
    }
    if (/^[+]?\d*\.{0,1}\d*$/.test(str)) {
        if (str.substr(str.length - 1, 1) == '.') {
            return false;
        }
        return true;
    }
    else {
        return false;
    }
}
//验证是否为金额格式，只精确两位小数。
function CheckIsMoney(str) {
    if (str == "" || str == null) {
        return true;
    }
    if (/^[+]?\d+\.{0,1}\d{0,2}$/.test(str)) {
        return true;
    }
    else {
        return false;
    }
}
function TimeCompare(a,b)
{
var arr=a.split("-");
var starttime=new Date(arr[0],arr[1],arr[2]);
var starttimes=starttime.getTime();

var arrs=b.split("-");
var lktime=new Date(arrs[0],arrs[1],arrs[2]);
var lktimes=lktime.getTime();

if(starttimes>lktimes)
{
return false;
}
else
return true;
}

//全选函数
//objSelf:全选chkBox的Name属性；objToSelect:待全勾选chkbox的Name属性；
function selectAll(objSelf, objToSelect) {
    chkboxAllOperation(objToSelect, objSelf.checked);
}

//全选或全不选
function chkboxAllOperation(obj, op) {
    var aCheckBoxs = document.getElementsByName(obj);
    for (var i = 0; i < aCheckBoxs.length; i++) {
        if (aCheckBoxs[i].disabled == false) aCheckBoxs[i].checked = op;
    }
}
//取checkbox 返回数组,数组从0开始
function getCheckBoxValueByName(name)
{
    var obj=document.getElementsByName(name);
    var aList=[];
    var j=0;
    for(var i=0;i<obj.length;i++)
    {
        if(obj[i].checked)
        {   
            j=j+1;
            aList[j-1]=obj[i].value;
        }
    }
    return aList;
}

/*表格间隔*/
function SetTableCss(id){
var odd="#"+id+">tr:odd";
var even="#"+id+">tr:even";
  $(odd).removeClass('odd').removeClass('even');
  $(even).removeClass('even').removeClass('odd');
  $(odd).addClass('odd');
  $(even).addClass('even');
  $("#"+id+">tr").mouseover(function () {
             $(this).addClass('over');
  }).mouseout(function () {
             $(this).removeClass('over');
             return false;
         });
}
function SetTableCss(){
var odd="table tr:odd";
var even="table tr:even";
  $(odd).removeClass('odd').removeClass('even');
  $(even).removeClass('even').removeClass('odd');
  $(odd).addClass('odd');
  $(even).addClass('even');
  $("table tr").mouseover(function () {
             $(this).addClass('over');
  }).mouseout(function () {
             $(this).removeClass('over');
             return false;
         });
         
}

//文本框只能输入数字.调用：<input id="input1" onkeyup="clearNoNum(this)" />
function clearNoNum(obj)
{
	//先把非数字的都替换掉，除了数字和.
	obj.value = obj.value.replace(/[^\d.]/g,"");
	//必须保证第一个为数字而不是.
	obj.value = obj.value.replace(/^\./g,"");
	//保证只有出现一个.而没有多个.
	obj.value = obj.value.replace(/\.{2,}/g,".");
	//保证.只出现一次，而不能出现两次以上
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
}

//同步左右box高度
function HighlySynchronous(boxid){
	var oBoxid=$("#"+boxid);
	//oBoxid.removeAttr("height");
	oBoxid.height("");
	var vContboxHeight=oBoxid.next(0).height();
	var vSideMenuboxHeight=oBoxid.height();
	if(vContboxHeight > vSideMenuboxHeight)
	{
		vSideMenuboxHeight=vContboxHeight+1;
		oBoxid.height(vSideMenuboxHeight);
	}
}
//页页加载之模态窗口
function LoadingShow(str){
    if(str)
    {
        $("#AjaxLoading > div:eq(0) > span").html(str);
    }
    var h = $(document).height();
	$("#overlay").css({"height": h });	
	$("#overlay").css({'display':'block','opacity':'0.8'});	
	$("#AjaxLoading").stop(true).animate({'margin-top':'300px','opacity':'1'},200);

}
function LoadingHide(str){
    if(str)
    {
        $("#AjaxLoading > div:eq(0) > span").html(str);
        setTimeout(function(){
		    $("#AjaxLoading").stop(true).animate({'margin-top':'250px','opacity':'0'},400);
		    $("#overlay").css({'display':'none','opacity':'0'});
    		
	    },800);
    }
    else
    {
        setTimeout(function(){
		    $("#AjaxLoading").stop(true).animate({'margin-top':'250px','opacity':'0'},200);
		    $("#overlay").css({'display':'none','opacity':'0'});
    		
	    },600);
    }
    
}

//页签
function ShowLabel(id){
    
    $("#"+id+" > p > span").each(function(index){
		    $(this).click(function(){
						       $(this).addClass("cur").siblings().removeClass("cur");
						       $("#"+id+" > div:eq("+index+")").removeClass("g-d-n").siblings(":not(p)").addClass("g-d-n");
						       $("#"+id+" > em:eq(0)").html(index);
				       })
		    })
}
//设置页签
function SetLabel(id,index)
{
     $("#"+id+" > p > span:eq("+index+")").addClass("cur").siblings().removeClass("cur");
     $("#"+id+" > div:eq("+index+")").removeClass("g-d-n").siblings(":not(p)").addClass("g-d-n");
     $("#"+id+" > em:eq(0)").html(index);
}

/*弹窗 使用方法：PopShow({title:"温馨提示",ele:"#HidDiv",width:620});弹窗关闭：window.popHide();  /  popHide();*/
function PopShow(obt) {
    var wp = $('<div id=\"g-popwin\"></div>'),
        ms = $('<div class=\"g-popwin-mask\"><iframe frameborder=\"0\" scrolling=\"no\"></iframe></div>').appendTo(wp),
		
        tb = $('<table class=\"g-popwin-box\"></table>').appendTo(wp),
        tr = $('<tr></tr>').appendTo(tb),
        td = $('<td></td>').appendTo(tr),

        bx = $('<div class=\"g-popwin\" style=\"margin:0 auto; width:700px;\"></div>').appendTo(td),

        ba = $('<div class=\"tit\"></div>').appendTo(bx),
        rb = $('<b class="g-f-r"></b>').appendTo(ba),
        hd = $('<a class="close g-f-r" title="点击关闭"></a>').appendTo(ba),
        st = $('<strong></strong>').appendTo(ba),

        cn = $('<div class=\"con\"></div>').appendTo(bx),
        ss;
    if (obt.ele) {
        ss = $(obt.ele).show().appendTo(cn)
    } else if (obt.html) {
        cn.append(obt.html)
    }
    wp.appendTo('body');
    if (obt.width) {
        bx.width(obt.width)
    }
    if (obt.height) {
        bx.height(obt.height)
    }
    if (obt.title) {
        st.text(obt.title)
    }
    else{ba.hide()}
    hd.add(obt.hide||'#swin_hide').click(function () {
        popHide();
    });
	
    window.popHide = function () {
        if (obt.ele) {
            ss.hide().appendTo('body')
        }
        wp.remove()
    };
}

//根据控件Id提取控件的value和name信息
function ReadSelectValue(id) {
    var names = [];
    var values = [];
    //select控件值转换成数组  
    $("#" + id + ">option").each(function() {
        names.push("{name:\"" + $(this).html() + "\"}")
        values.push("{name:" + $(this).val() + "}");
    });
    var selectName = "{cName:[" + names + "],cValue:[" + values + "]}";
    return selectName;
}

//表格效果
function ListXG(id,rowcss) {
        $("#"+ id +" tr td").mouseover(function() {
        $(this).parent().find("td").addClass(rowcss);
        //$(this).addClass(celcss);
    }).mouseout(function() {
        $(this).parent().find("td").removeClass(rowcss);
        //$(this).removeClass(celcss);
    });
}

//提示框方法基本通用，参数：id(绑定事件标签ID)，tipid(提示层ID)，spacingLeft(左边间距)，spacingTop(顶部间距)，kz(控制闭合：1开，0关，其它为开关轮换)
function ShowTipBox(id, tipid, spacingLeft, spacingTop, kz) {
    var x = 0;
    var y = 0;
    if (spacingLeft != "") x = spacingLeft;
    if (spacingTop != "") y = spacingTop;

    var tb = $("#" + id);
    var tipbox = $("#" + tipid);
    switch (kz) {
        case 1:
            {
                var boxy = tb.offset().top;
                var boxx = tb.offset().left;
                tipbox.css({ "top": (boxy + (y)) + "px", "left": (boxx + (x)) + "px" }).show(100);
                break;
            }
        case 0:
            {
                tipbox.hide();
                break;
            }
        default:
            {
                if (tipbox.css("display") == "none") {
                    var boxy = tb.offset().top;
                    var boxx = tb.offset().left;
                    tipbox.css({ "top": (boxy + (y)) + "px", "left": (boxx + (x)) + "px" }).show(100);
                }
                else {
                    tipbox.hide();
                }
            }

    }

}




//弹出框
function showDetails(show_div, bg_div) {
    //弹出隐藏层
    document.getElementById(show_div).style.display = 'block';
    document.getElementById(bg_div).style.display = 'block';
    var _windowHeight = $(window).height(),//获取当前窗口高度
    _windowWidth = $(window).width(),//获取当前窗口宽度
    _popupHeight = $("#" + show_div).height(),//获取弹出层高度
    _popupWeight = $("#" + show_div).width();//获取弹出层宽度
    _posiTop = (_windowHeight - _popupHeight) / 2;
    _posiLeft = (_windowWidth - _popupWeight) / 2;
    $("#" + show_div).css({ "left": _posiLeft + "px", "top": _posiTop + "px", "display": "block" });//设置position
}
//关闭弹出层
function CloseDiv(show_div, bg_div) {
    document.getElementById(show_div).style.display = 'none';
    document.getElementById(bg_div).style.display = 'none';
};



function showP(show_div, bg_div) {

    //弹出隐藏层
    document.getElementById(show_div).style.visibility = 'visible';
    document.getElementById(bg_div).style.display = 'block';
    var _windowHeight = $(window).height(),//获取当前窗口高度
        _windowWidth = $(window).width(),//获取当前窗口宽度
        _popupHeight = $("#" + show_div).height(),//获取弹出层高度
        _popupWeight = $("#" + show_div).width();//获取弹出层宽度
    _posiTop = (_windowHeight - _popupHeight) / 2;
    _posiLeft = (_windowWidth - _popupWeight) / 2;
    $("#" + show_div).css({ "left": _posiLeft + "px", "top": _posiTop + "px", "visibility": "visible" });//设置position
}
//关闭弹出层
function CloseP(show_div, bg_div) {
    document.getElementById(show_div).style.visibility = 'hidden';
    document.getElementById(bg_div).style.display = 'none';
};


//提示框
//要引入jquery-powerFloat-min.js
function TipMsg(objId, msg) {
    var oPosTri = $("#" + objId);
    if (!oPosTri)
        return;
    if (msg) {
        oPosTri.powerFloat({
            eventType: null,
            targetMode: "remind",
            target: msg,
            position: "4-7"
        }).focus();
    }
    oPosTri.bind("blur", function () {
        $.powerFloat.hide();
    });
}

function HideTipMsg() {
    $.powerFloat.hide();
}


//弹出框(弹出框id传值)
function OpenShowDetails(show_div, bg_div,hd_id, hd_DotId) {
    //弹出隐藏层
    document.getElementById(show_div).style.display = 'block';
    document.getElementById(bg_div).style.display = 'block';
    var _windowHeight = $(window).height(),//获取当前窗口高度
    _windowWidth = $(window).width(),//获取当前窗口宽度
    _popupHeight = $("#" + show_div).height(),//获取弹出层高度
    _popupWeight = $("#" + show_div).width();//获取弹出层宽度
    _posiTop = (_windowHeight - _popupHeight) / 2;
    _posiLeft = (_windowWidth - _popupWeight) / 2;
    $("#" + show_div).css({ "left": _posiLeft + "px", "top": _posiTop + "px", "display": "block" });//设置position

    $("#" + hd_id).val(hd_DotId);
}

if(window.$){
$.fn.SelDate = function (format, minDate, maxDate) {//YYYY-MM-DD hh:mm,YYYY-MM-DD
    if (!format)
        format = "YYYY-MM-DD";

    if (!minDate)
        minDate = "1950-01-01";

    if (!maxDate)
        maxDate = "2050-12-31";

    $(this).jeDate({
        //isinitVal:true,
        //festival:true,
        //ishmsVal:false,
        fixedCell: "refix",
        //isClear:false,
        //isok:false,
        //hmsSetVal: { hh: 0, mm: 0, ss: 0 },
        //isvalid:["3,4,8,10",true],
        initAddVal: { MM: "+3", DD: "+2" },
        minDate: minDate,
        maxDate: maxDate,
        format: format,
        //format:"hh:mm",
        zIndex: 3000,
        choosefun: function (elem, val, date) {
        },
        okfun: function (elem, val, date) {
        }
    });
}
}

//鼠标经过效果
var box = document.getElementsByClassName("onmouseClass");

if (box != null) {
    
    for (var i = 0; i < box.length; i++) {
        var obj = box[i];
        
        obj.onmouseover = function () {
            obj.style.backgroundColor = "#ff8b53";
        }

        obj.onmouseout = function () {
            obj.style.backgroundColor = "#ff7734";
           
        }
    }

  
    
}

var box2 = document.getElementsByClassName("onmouseClass2");
if (box2 != null) {
    for (var i = 0; i < box2.length; i++) {
        var obj2 = box2[i];
        obj2.onmouseover = function () {
            obj2.style.backgroundColor = "#2c4b74";
        }

        obj2.onmouseout = function () {
            obj2.style.backgroundColor = "#1c324f";
        }
    }

}

//比较d1是否大于d2
function CompareDate(d1, d2) {
    return ((new Date(d1.replace(/-/g, "\/"))) > (new Date(d2.replace(/-/g, "\/"))));
}

function getNowDate() {
    var date = new Date();
    var seperator1 = "-";    
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;

    return currentdate;
}

//定时提示
function tipTime(config) {

    "use strict";
    var time = config.time || 3000;
    var aClass = ""
    //config.class || "";
    var msg = config.msg || "";
    var id = config.id || "tipTime";
    var z = config.zIndex || 1300;
    var ico = config.ico || "";
    if ($('#' + id).length == 0) {
        var stc = '<div id="' + id + '" class="g-tipTime ' + aClass + ' g-tip-' + ico + '" style="z-index:' + z + ' ">' + msg + '</div>';
        $("body").append(stc);
        var t = $('#' + id);
    } else {
        var t = $('#' + id);
        t.text(msg).removeClass("g-tip-sigh g-tip-yes g-tip-").addClass(aClass + " g-tip-" + ico).show();
    }
    //t.css({marginLeft:-t.outerWidth()/2,marginTop:-t.outerHeight()/2});
    setTimeout(function () {
        t.hide();
    }, time);
}