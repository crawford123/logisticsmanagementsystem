"object"!=typeof JSON&&(JSON={}),function(){"use strict";function f(a){return 10>a?"0"+a:a}function quote(a){return escapable.lastIndex=0,escapable.test(a)?'"'+a.replace(escapable,function(a){var b=meta[a];return"string"==typeof b?b:"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)})+'"':'"'+a+'"'}function str(a,b){var c,d,e,f,h,g=gap,i=b[a];switch(i&&"object"==typeof i&&"function"==typeof i.toJSON&&(i=i.toJSON(a)),"function"==typeof rep&&(i=rep.call(b,a,i)),typeof i){case"string":return quote(i);case"number":return isFinite(i)?String(i):"null";case"boolean":case"null":return String(i);case"object":if(!i)return"null";if(gap+=indent,h=[],"[object Array]"===Object.prototype.toString.apply(i)){for(f=i.length,c=0;f>c;c+=1)h[c]=str(c,i)||"null";return e=0===h.length?"[]":gap?"[\n"+gap+h.join(",\n"+gap)+"\n"+g+"]":"["+h.join(",")+"]",gap=g,e}if(rep&&"object"==typeof rep)for(f=rep.length,c=0;f>c;c+=1)"string"==typeof rep[c]&&(d=rep[c],e=str(d,i),e&&h.push(quote(d)+(gap?": ":":")+e));else for(d in i)Object.prototype.hasOwnProperty.call(i,d)&&(e=str(d,i),e&&h.push(quote(d)+(gap?": ":":")+e));return e=0===h.length?"{}":gap?"{\n"+gap+h.join(",\n"+gap)+"\n"+g+"}":"{"+h.join(",")+"}",gap=g,e}}"function"!=typeof Date.prototype.toJSON&&(Date.prototype.toJSON=function(){return isFinite(this.valueOf())?this.getUTCFullYear()+"-"+f(this.getUTCMonth()+1)+"-"+f(this.getUTCDate())+"T"+f(this.getUTCHours())+":"+f(this.getUTCMinutes())+":"+f(this.getUTCSeconds())+"Z":null},String.prototype.toJSON=Number.prototype.toJSON=Boolean.prototype.toJSON=function(){return this.valueOf()});var cx,escapable,gap,indent,meta,rep;"function"!=typeof JSON.stringify&&(escapable=/[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,meta={"\b":"\\b"," ":"\\t","\n":"\\n","\f":"\\f","\r":"\\r",'"':'\\"',"\\":"\\\\"},JSON.stringify=function(a,b,c){var d;if(gap="",indent="","number"==typeof c)for(d=0;c>d;d+=1)indent+=" ";else"string"==typeof c&&(indent=c);if(rep=b,b&&"function"!=typeof b&&("object"!=typeof b||"number"!=typeof b.length))throw new Error("JSON.stringify");return str("",{"":a})}),"function"!=typeof JSON.parse&&(cx=/[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,JSON.parse=function(text,reviver){function walk(a,b){var c,d,e=a[b];if(e&&"object"==typeof e)for(c in e)Object.prototype.hasOwnProperty.call(e,c)&&(d=walk(e,c),void 0!==d?e[c]=d:delete e[c]);return reviver.call(a,b,e)}var j;if(text=String(text),cx.lastIndex=0,cx.test(text)&&(text=text.replace(cx,function(a){return"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)})),/^[\],:{}\s]*$/.test(text.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g,"@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g,"]").replace(/(?:^|:|,)(?:\s*\[)+/g,"")))return j=eval("("+text+")"),"function"==typeof reviver?walk({"":j},""):j;throw new SyntaxError("JSON.parse")})}();
$(document).ready(function(){
    /*$('.wd-enter').bind({
     mouseover:function(){
     $(this).find('ul').show();
     },
     mouseout:function(){
     $(this).find('ul').hide();
     }
     });

     */
    $('.input-box input, .textarea-box textarea, ._textarea textarea').each(function(){
        var $this=$(this),$this_p=$this.parent();
        if(this.value!=''){
            $this_p.addClass('hid-tip');
        }
        else{
            $this_p.removeClass('hid-tip');
        }
    });

    $(document).on('focus','.input-box input, .textarea-box textarea,._textarea textarea',function(){
        var $this=$(this),$this_p=$this.parent();
        $this_p.addClass('bor_').removeClass('red').removeClass('ui-erro');
        $this_p.addClass('hid-tip');
        if(this.value !=""){
            $this.prev('i.del').show();
        }
    });

    $(document).on('blur','.input-box input, .textarea-box textarea,._textarea textarea',function(){
        var $this=$(this),$this_p=$this.parent();
        $this_p.removeClass('bor_');
        if(this.value ==""){
            $this_p.removeClass('hid-tip');
            $this.prev('i.del').hide();
        }
        else{
            $this_p.addClass('hid-tip');
        }
    });
    $(document).on('click','.input-box',function(){
        $(this).find('input[type="text"]').focus();
    });
    $(document).on('click','.textarea-box,._textarea',function(){
        $(this).find('textarea').focus();
    });
    $('.point').click(function(){
        $(this).prev().focus();
    });
    inputColShow($('.ui-input-box input'));

});


//内容输入字符提示
function check_textarea_new(which,num,numBox){
    var maxChars = num;
    if(which.value.length > maxChars){
        which.value = which.value.substring(0,maxChars);
        return false;
    }else{
        $('.'+numBox).text(which.value.length);
        return true;
    }
}
//内容字符提示
function check_textarea(which,num,numBox){
    var maxChars = num;
    if(which.value.length > maxChars){
        which.value = which.value.substring(0,maxChars);
        return false;
    }else{
        var curr = maxChars - which.value.length;
        console.log(curr);
        $('.'+numBox).text(curr);
        return true;
    }
}

/*输入框焦点事件绑定*/
$(function(){
    var $input_box=$('.ui-input-box,.ui-textarea-box');
    if($input_box.length>0){
        $input_box.live('click',function(){
            $(this).find('input:first,textarea').focus();
        });
        var $ui_input=$('.ui-input-box input, .ui-textarea-box textarea');
        $ui_input.live({
            focus:function(){
                $(this).parent().addClass('ui-focus-bor').removeClass('ui-erro');
            },
            blur:function(){
                var $this=$(this),$thisP=$this.parent();
                var check_null=$this.attr('is_null');
                $thisP.removeClass('ui-focus-bor');
                if( check_null=="ok" ){
                    if(this.value==''){
                        $thisP.addClass('ui-erro');
                    }else{
                        $thisP.removeClass('ui-erro');
                    }
                }
            },
            keyup:function(){
                inputColShow($(this));
            }
        });
    }
});


/*
 * 弹出层显示——方法：
 * PopUp(triggerId,conditional)
 * 参数：
 * type=0：自动隐藏式弹出
 * type=1：点击关闭式
 * conditional：判断条件
 * $triggerId：触发id
 * $effectId：反应触发效果id
 * effectW：效果层宽度
 * effectH：效果层高度
 */
function PopUp(triggerId,conditional,type){
    var $triggerId=$('#'+triggerId),$effectId=$('#'+triggerId+'_effect');
    var effectW,effectH;
    if(conditional){
        effectW=$effectId.width();
        effectH=$effectId.height();
        $effectId.css({
            marginLeft:-(effectW/2),
            marginTop:-(effectH/2+10)
        }).fadeIn(200);
        MaskLayer('ui-mask',1);  //遮罩层显示
        $('.ui-mask').on('click',function(){
            $effectId.fadeOut();
            MaskLayer('ui-mask',0)
        });
        //自动隐藏
        if(type==0){
            var closeAuto=setTimeout(function(){
                PopUp(triggerId,!conditional,type)
            },1500);
        }
    }else{
        $effectId.fadeOut(200);
        MaskLayer('ui-mask',0);  //遮罩层隐藏
    }
}
/*********************弹出框显示隐藏*********************/
/*
 * 遮罩层显示隐藏
 * 参数type=1 显示
 * 参数type=0 隐藏
 * 绑定了点击事件，隐藏弹出层
 */
function MaskLayer(layer,type){
    var $layer=$('.'+layer);
    type == 1 ? $layer.show() : $layer.hide();
    $layer.on('click',function(){
        $('.layer-mbox').children().fadeOut();
        MaskLayer(layer,0)
    });
}


/*
 * 提交验证，非空验证，部分正则验证
 * type = 0  //手机验证
 * type = 1 //电话验证
 * type = 2 //数字验证
 * type = 3 //网址验证
 * type = 4 //邮箱验证
 * type = 5 //密码验证
 * type = 6 //qq验证
 * count：允许输入字符数
 * erro_text：错误提示信息
 */
function InputVCheck(inputId,type,count){
    var $inputId = $('#'+inputId), $inputP = $inputId.parent(), $erroBox = $('#'+inputId+'_erro'); //元素选择
    var inputV = $inputId.val(), reg = '', erro_text = '', isNull = '', inputVLen = '', type_text;     //输入框的值
    var placeV = $inputId.attr('placeholder')||'';
    inputV = (placeV!=''&& inputV==placeV)?'':inputV;
    var inputV = inputV.replace(/\s+/g,"");   //去除空格
    switch (type){
        case -1:
            type_text='指定内容';
            erro_text='* 请按规则输入';
            break;
        case 0:
            /// reg=/^[0-9]{11}$/;
            reg = /^1(3|4|5|6|7|8|9)\d{9}$/;
            type_text='手机号码';
            erro_text='* 手机号码格式不正确';
            break;
        case 1:
            reg=/^(\d{3}-)(\d{8})$|^(\d{3})(\d{8})$|^(\d{4}-)(\d{7})$|^(\d{4}-)(\d{8})$|^(\d{4})(\d{8})$/;
            type_text='电话号码';
            erro_text='* 电话格式不正确；例：021-12345678';
            break;
        case 2:
            reg=/^(([0-9]{1,2}(\.[0-9]{1,2})?)|(100))$/;
            type_text='数字';
            erro_text='* 请输入小于100的数字，最多两位小数；例：11.11';
            break;
        case 3:
            reg=/((((^https?)|(^ftp)):\/\/)?([\-\w]+\.)+\w{2,3}(\/[%\-\w]+(\.\w{2,})?)*(([\w\-\.\?\\\/+@&#;`~=%!]*)(\.\w{2,})?)*\/?)/i;
            type_text='网址';
            erro_text='* 网址格式不正确；例：http://www.lizi.com';
            break;
        case 4:
            reg=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
            type_text='邮箱';
            erro_text='* 邮箱格式不正确；例：abc@163.com';
            break;
        case 5:
            reg=/^[A-Za-z0-9]+$/;
            type_text='密码';
            erro_text='* 必须由6-16位英文或数字组成';
            break;
        case 6:
            reg=/^[1-9]*[1-9][0-9]*$/;
            type_text='腾讯QQ';
            erro_text='* QQ格式不正确';
            break;
        default:
            break;
    }
    if(inputV == ''){  //为空
        isNull=$inputId.attr('isnull');
        if(isNull=='no'){   //不允许为空
            $inputP.addClass('ui-erro');
            erro_text='* 请输入'+type_text;
            $erroBox.text(erro_text).show();
            return false;
        }else{           //允许为空
            $erroBox.text('').hide();
            return true;
        }
    }else{
        /*最大输入限制*/
        inputVLen = inputV.length;
        if(inputVLen > count){
            inputV = inputV.substring(0,count);
            $inputId.val(inputV);
        }
        var objExp=new RegExp(reg); //正则对象
        if(objExp.test(inputV)){
            $erroBox.html('').hide();
            if(type==5){  //密码验证
                if(LimitChar(inputV,6,16)){
                    var pasinfo=matchSame('password');
                    if(pasinfo=='same'){
                        return true;
                    }else{
                        $('#password_re_erro').html(pasinfo).show();
                        return false;
                    }

                }else{
                    $inputP.addClass('ui-erro');
                    $erroBox.text(erro_text).show();
                    return false;
                }
            }else{
                return true;
            }

        }else{
            $inputP.addClass('ui-erro');
            $erroBox.html(erro_text).show();
            return false;
        }
    }
}

/*
 * 通用验证
 * Fname:from的name及id号
 * formInputL：表单内输入框数目
 * formErro：验证返回状态 true/false
 * formErroNum：错误条数
 * inputId：当前输入框id
 * typeArry：类型数组
 */
function FormCheck(Fname,arry){
    var typeArry=arry.split('|');
    var $formInput=$('#'+Fname+' .ui-input-box');
    var formInputL=$formInput.length,formErro,formErroNum=0,inputId,type;
    for(var i=0;i<formInputL;i++){
        inputId = $formInput.eq(i).find('input').attr('id') || $formInput.eq(i).find('textarea').attr('id') || $formInput.eq(i).find('input:password').attr('id');
        type=parseInt(typeArry[i]);  //必须是数字型
        formErro=InputVCheck(inputId,type,100).toString();
        if(formErro=='false'){
            formErroNum=formErroNum+1;
        }
    }
    if(formErroNum>0){
        // alert('不能提交，错误条数：'+formErroNum);
        return false;
    }else{
        //   alert('可以提交');
        return true;
    }
}
//tip提示效果
function showTipBox(a_obj,c,i_html){
    var $a_obj=a_obj,
        dataid = $a_obj.attr('data-id'),
        $b_obj = $('#'+dataid+'_effect');
    if(c){
        var $b_sign_obj=$b_obj.find('.effect-sign'),
            a_obj_w=$a_obj.width(),
            a_obj_h=$a_obj.height(),
            a_obj_l=$a_obj.offset().left,
            a_obj_t=$a_obj.offset().top;
        if(i_html){$b_obj.find('.mc').html(i_html);}
        $b_sign_obj.css({'left':a_obj_w/2});
        $b_obj.css({'left':a_obj_l,'top':a_obj_t+a_obj_h+10}).addClass('hover-box-show');

    }else{
        $b_obj.removeClass('hover-box-show');
    }
}
function HoverShow(triggerId, conditional, pos_type) {
    var $triggerId = $("#" + triggerId),
        $effectId = $("#" + triggerId + "_effect"),
        $sign = $("#" + triggerId + "_effect_sign"),
        $triggerP = $triggerId.parent();
    var triggerW, triggerH, triggerL, triggerT, effectL, effectT, signL, mouseL, mouseT, effectW, effectH, triggerPL, screenW = $(document.body).width(),
        minusL,
        left;
    if (conditional) {
        $effectId.show();
        triggerL = $triggerId.offset().left;
        triggerT = $triggerId.offset().top;
        triggerW = $triggerId.width();
        triggerH = $triggerId.height();
        effectW = $effectId.width();
        effectH = $effectId.height();
        if (pos_type == 1) {
            triggerPL = $triggerP.offset().left;
            $effectId.css({
                left: (triggerL - triggerPL)
            })
        } else {
            if (pos_type == 2) {
                minusL = (triggerL + effectW) - ((screenW - 980) / 2 + 980);
                if (minusL > 0) {
                    left = triggerL - minusL
                } else {
                    left = triggerL
                }
                $effectId.css({
                    left: left,
                    top: (triggerT + triggerH + 10)
                })
            }
        }
        effectL = $effectId.offset().left;
        effectT = $effectId.offset().top;
        signL = triggerL - effectL + (triggerW / 2);
        $sign.css({
            left: signL
        });
        $(document).on("mousemove",
            function(event) {
                triggerT = $triggerId.offset().top;
                triggerL = $triggerId.offset().left;
                effectL = $effectId.offset().left;
                effectT = $effectId.offset().top;
                effectW = $effectId.width();
                effectH = $effectId.height();
                mouseL = event.pageX;
                mouseT = event.pageY;
                if (mouseT < triggerT || mouseL < effectL || mouseL > (effectL + effectW) || mouseT > (effectT + effectH) || (mouseL < triggerL && mouseT < effectT) || (mouseL > (triggerL + triggerW) && mouseT < effectT)) {
                    $effectId.hide()
                }
            })
    } else {
        $effectId.hide()
    }
}


//下拉框
var uiDrop={
    init: function(obj,boxAttribute,callback,condition){
        var self=this;
        var boxObj=$('#'+boxAttribute.id);
        var boxCotentObj=boxObj.find('.ui-drop-content');
        var callHtml=callback?callback():boxObj.html();
        var $obj=$(obj);
        var sign=boxAttribute.sign||false;
        var signHtml=sign?'<div class="direction-sign"><i class="sign-out-line"><i class="sign-in-line"></i></i></div>':'';
        if(boxObj.length===0){ //元素不存在
            $('body').append('<div style="display:none" class="ui-drop '+boxAttribute.id+'-class" id="'+boxAttribute.id+'">'+signHtml+'<div class="ui-drop-content">'+callHtml+'</div></div>');
            boxObj=$('#'+boxAttribute.id);
            boxCotentObj=boxObj.find('.ui-drop-content');
        }
        if(condition){
            boxObj.show();
            boxCotentObj.html(callHtml);
            self.posReset(obj,boxAttribute);
        }else{
            boxObj.hide();
        }
        self.bind(boxAttribute,obj);
    },
    AttrDefault: function(obj){
        obj=$(obj);
        var l=obj.offset().left;
        var t=obj.offset().top;
        var w=obj.width();
        var h=obj.height();
        return {left:l,top:t,width:w,height:h};
    },
    bind: function(boxAttribute,inputObj){
        var self=this;
        var id=boxAttribute.id;
        var $boxObj=$('#'+id);
        var $li=$boxObj.find('li');
        var $inputObj=$(inputObj);
        var dataBind=$inputObj.data('bind')||0;
        if(dataBind==0){
            $('body').bind('click',function(event){
                $boxObj.hide();
            });
            $boxObj.bind('click',function(event){
                window.event?window.event.cancelBubble=true:event.stopPropagation();
            });
            $inputObj.data('bind',1);
        }
        if($li.length==0){return false;}
        $li.not('loading-img').bind('click',function(event){ //阻止冒泡
            window.event?window.event.cancelBubble=true:event.stopPropagation();
            var $this=$(this),dataId=$this.attr('data-id')||'',$inputObj=$(inputObj);
            var name=$this.text();
            var eleTarget=$inputObj.prop("tagName").toLocaleLowerCase()||'';
            var dataInfo=eval("("+decodeURIComponent($this.data('info'))+")")||'';
            eleTarget=='input'?$inputObj.val(name):'';
            if(dataInfo){ //存在data数据
                for(var i in dataInfo){
                    var $cObj=$('#'+dataInfo[i].id);
                    var cTag=$cObj.prop("tagName").toLocaleLowerCase()||'';
                    var cVal=dataInfo[i].val;
                    cTag=='input'?$cObj.val(cVal).parent().removeClass('ui-erro'):$cObj.text(cVal);
                }
            }
            inputColShow($('.ui-input-box input'));
            $boxObj.hide(); //关闭下拉框
            boxAttribute.clickFun?boxAttribute.clickFun({id:dataId,name:name}):false;
        }).bind('mouseover',function(){
            $li.removeClass('hover-cur');
            $(this).addClass('hover-cur');
        }).bind('mouseout',function(){
            $(this).removeClass('hover-cur');
        });
        var scrollMove= -26,a_index= 0,a_index_last=$li.length-1;
        $inputObj.bind('keyup',function(e){
            var key= e.which;
            if(key==38){ //向上
                if(a_index<=0){
                    a_index=0;
                }else{
                    a_index--;
                    scrollMove -= 26;
                }
            }else if(key==40){ //向下
                if(a_index===a_index_last){
                    a_index=a_index_last;
                }else{
                    a_index++;
                    scrollMove += 26;
                }

            }else if(key==13 && !$boxObj.is(':hidden')){
                $('#'+id+' li').eq(a_index).click();
            }else{
                scrollMove= -26,a_index= 0;
            }
            $li.removeClass('hover-cur');
            $li.eq(a_index).addClass('hover-cur');
        });
    },
    posReset: function(obj,boxAttribute){
        //位置重置
        var self=this;
        var boxObj=$('#'+boxAttribute.id);
        var re_w=boxAttribute.width||0;
        var re_h=boxAttribute.height||0;
        var re_l=boxAttribute.left||0;
        var re_t=boxAttribute.top||0;
        var defaultInfo=self.AttrDefault(obj);
        var w=re_w?re_w:defaultInfo.width;
        var h=defaultInfo.height;
        var l=re_l?defaultInfo.left+re_l:defaultInfo.left;
        var t=re_t?defaultInfo.top+defaultInfo.height+re_t:defaultInfo.top+defaultInfo.height;
        var boxPos=boxAttribute.pos||'';
        var scrollTop,bodyH,boxH,boxW;
        re_h?boxObj.find('.ui-drop-content').css({maxHeight:re_h,'*height':re_h}):'';
        boxObj.css({width:w,top:t,left:l});
        boxW=boxObj.width();
        if(boxPos=='c'){
            boxObj.css({left:l-(boxW-defaultInfo.width)/2});
        }else if(boxPos=='r'){
            boxObj.css({left:l-(boxW-defaultInfo.width)});
            boxObj.find('.direction-sign').css({left:(boxW-defaultInfo.width/2-20)});
        }
        scrollTop=document.documentElement&&document.documentElement.scrollTop?document.documentElement.scrollTop:document.body.scrollTop;
        bodyH=document.documentElement.clientHeight;
        boxH=boxObj.height();
        if((bodyH-(t-scrollTop))<boxH){ //重置顶部位置
            boxObj.addClass('ui-drop-top').css({top:(defaultInfo.top-re_t-boxH+2)});
        }else{
            boxObj.removeClass('ui-drop-top');
        }


    }
};

//底部弹出框
var uiPop={
    init: function(obj,condition,direction){ //初始化
        var self=this,maskResult,popHtml='',buttonHtml='',titleHtml='',width='';
        var callback=(typeof arguments[3]==="function")?arguments[3]:arguments[4]||false,maskHas=(typeof arguments[3]==='boolean')?arguments[3]:arguments[4]||true;
        var toolbar=typeof arguments[arguments.length-1]==="object"?arguments[arguments.length-1]:'';
        maskResult=maskHas?self._mask('ui_mask',condition):false; //是否打开遮罩层
        $obj=typeof(obj)==='string'?$('#'+obj):obj; //obj
        if($obj.length<=0)  //初始化弹窗-弹窗追加
        {
            if(toolbar){
                titleHtml=toolbar.title?'<a class="ui-pop-close" id="'+obj+'Close">X</a><div id="'+obj+'Title" class="ui-pop-title">'+toolbar.title+'</div>':'';
                buttonHtml=toolbar.button?self._createButton(toolbar.button,obj,direction):'';
                width=toolbar.width;
            }else{
                width='auto';
                buttonHtml=titleHtml='';
            }
            popHtml=$('<div class="ui-pop-common ui-pop-'+direction+'-'+obj+'" id="'+obj+'">'+titleHtml+'<div class="ui-pop-content"></div>'+buttonHtml+'</div>');
            popHtml.css({width:width});
            $('body').append(popHtml);
            $obj=typeof(obj)==='string'?$('#'+obj):obj; //obj
        }
        $obj.attr('class','ui-pop-common ui-pop-'+direction+'-'+obj);
        self._popShow($obj,condition,direction,callback);   //弹窗执行
        //绑定点击关闭
        $('#ui_mask,#'+obj+'Close').on('click',function(e){
            e.preventDefault();
            self._popShow($obj,false,direction,callback);   //弹窗执行
            self._mask('ui_mask',false);
        });
    },
    _createButton: function(button,obj,direction){
        var buttonHtml='',btn='';
        for(var i=0;i<button.length;i++){
            btn=button[i]!=='取消'?'<input type="button" id="button'+(i+1)+'" value="'+button[i]+'" />':'<input onclick="uiPop.init(\''+obj+'\',false,\''+direction+'\')" type="button" id="button'+(i+1)+'" value="'+button[i]+'" />';
            buttonHtml=buttonHtml+btn;
        }
        return '<div class="ui-button-min">'+buttonHtml+'</div>';
    },
    /**
     * maskObj 遮罩元素
     * maskControl 遮罩动作控制 （显示/隐藏）
     **/
    _mask: function(maskObj,maskControl){ //遮罩层
        var self=this;
        var $mask=$('#'+maskObj),maskHtml="<div data-show='0' class='ui-mask' id='"+maskObj+"'></div>",mask_len=$mask.length;
        if(maskControl){
            mask_len>0?$mask.show():$('body').append(maskHtml).find('#'+maskObj).show();
            return true;
        }else{
            mask_len>0?$mask.hide():'';
            return false;
        }
    },
    /**
     * _popShow() 弹窗操作
     * popObj 弹窗元素
     * popShow 弹窗动作控制（显示/隐藏）
     * popType 弹窗出现方式 （top/right/bottom/left/center）
     * callback 回调函数
     **/
    _popShow: function(popObj,popControl,popType,callback){
        var self=this,backInfo,size,objContent;
        backInfo=typeof (callback)==="function"?callback():false; //调用回调函数，返回元素内容
        if(backInfo){
            objContent=popObj.find('.ui-pop-content').length>0?popObj.find('.ui-pop-content'):popObj;
            objContent.html(backInfo);
        }
        size=self._popSize(popObj);
        self._popPostion(popObj,popControl,popType,size);
    },
    /**
     * _popSize() 弹窗尺寸获取
     * popObj 弹窗元素
     **/
    _popSize: function(popObj){
        var self=this,size=arguments[1]?arguments[1]:false;
        var pop_w=size.width || popObj.width() || '',pop_h=size.height || popObj.height() || '';
        return {width:pop_w,height:pop_h};
    },
    /**
     * _popPostion() 弹窗位置调整
     * popObj 弹窗元素
     * popType  弹窗出现方式 （top/right/bottom/left/center）
     * popSize  弹窗尺寸
     **/
    _popPostion: function(popObj,popControl,popType,popSize){
        var w=popSize.width,h=popSize.height,show=0;
        switch (popType)
        {
            case "top":
                popObj.css({left:0});
                if(popControl){
                    popObj.css({top:-h});
                    popObj.show().stop().animate({top:0},100);
                }else{
                    popObj.animate({top:-h},100,function(){$(this).hide()});
                }
                break;
            case "right":
                popObj.css({top:'50%',marginTop:-h/2});
                if(popControl){
                    popObj.css({right:-w});
                    popObj.show().stop().animate({right:0},100);
                }else{
                    popObj.animate({right:-w},100,function(){$(this).hide()});
                }
                break;
            case "bottom":
                popObj.css({left:0});
                if(popControl){
                    popObj.css({bottom:-h});
                    popObj.show().stop().animate({bottom:0},100);
                }else{
                    popObj.animate({bottom:-h},100,function(){$(this).hide()});
                }
                break;
            case "left":
                popObj.css({top:'50%',marginTop:-h/2});
                if(popControl){
                    popObj.css({left:-w});
                    popObj.show().stop().animate({left:0},100);
                }else{
                    popObj.animate({left:-w},100,function(){$(this).hide()});
                }
                break;
            case "center":
                popObj.css({left:'50%',top:'50%',marginTop:-h/2,marginLeft:-w/2});
                if(popControl){
                    popObj.stop().show();
                }else{
                    popObj.stop().hide();
                }
                break;
        }
    },
    _tip: function(tip,type){
        var $pop_tip=$('#pop_tip'),pop_tip_w,pop_tip_h,win_h;
        tip=tip.replace('：','');
        var className=type==1?'tip-success':'tip-erro';
        if($pop_tip.length===0){
            $('body').append('<div data-sclick="0" class="pop-tip" id="pop_tip"><div class="tip-info '+className+'">'+tip+'</div></div>');
        }
        $pop_tip=$('#pop_tip');
        $pop_tip.find('.tip-info').attr('class','tip-info '+className).text(tip);
        pop_tip_w=$pop_tip.width();
        pop_tip_h=$pop_tip.height();
        $pop_tip.css({
            position:'fixed',
            marginLeft:-(pop_tip_w/2),
            left:'50%',
            marginTop:-(pop_tip_h/2+60)
        });
        //win_h=document.documentElement.clientHeight; //可视区域高度
        //if(obj){
        //    var obj_offset=$(obj).offset();
        //    var obj_top=obj_offset.top;
        //    var obj_left=obj_offset.left;
        //    $erro_tip.css({
        //        position:'absolute',
        //        marginLeft:0,
        //        left:obj_left,
        //        top:obj_top-erro_tip_h
        //    });
        //}else{
        //    $erro_tip.css({
        //        position:'fixed',
        //        marginLeft:-(erro_tip_w/2),
        //        left:'50%',
        //        marginTop:-(erro_tip_h/2+60)
        //        //top:(win_h/2-erro_tip_h*2-document.body.scrollTop)
        //    });
        //}

        // 控制重复点击
        if($pop_tip.data('sclick') == 1) { return false;}
        $pop_tip.data('sclick',1).show();
        setTimeout(function(){
            $pop_tip.hide().data('sclick', 0);
        },1500);
        return $('#pop_tip');
    }
};
function inputColShow(obj){
    obj.each(function(){
        var $this=$(this);
        var val=$this.val();
        var placeV=$this.attr('placeholder')||'';
        if(val!=='' && placeV !==val){
            $this.parent('.ui-input-box').addClass('ui-input-col');
        }else{
            $this.parent('.ui-input-box').removeClass('ui-input-col');
        }
    });
}

/**
 * cookie
 **/
var uiCookie={
    init: function(name,value,time){
        var self=this;
        self._set(name,value,time);
    },
    _set: function(name,value,time){ //设置cookie
        var self=this;
        var strsec = self._getsec(time);
        var exp = new Date();
        var valArray=self._get(name);
        var checkResult=self.repeatCheck(value,valArray);
        if(!checkResult){
            valArray.push(value);
        }
        exp.setTime(exp.getTime() + strsec*1);
        document.cookie = name + "="+ self._dataDeal(valArray) + ";expires=" + exp.toUTCString();
    },
    _get: function(name){ //读取cookie
        var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
        if(arr=document.cookie.match(reg)){
            return eval( "(" + decodeURIComponent(arr[2]) + ")" );
        }else{return [];}
    },
    repeatCheck: function(str,array){
        var self=this;
        str=self._dataDeal(str);
        array=self._dataDeal(array);
        return array.indexOf(str)>0?true:false;
    },
    _del: function(name,key,time){  //删除cookie
        var self=this;
        var exp = new Date();
        var times=self._getsec(time);
        var valArray=self._get(name);
        valArray.splice(key,1); //数组操作删除
        (key=='all'||valArray.length==0)?exp.setTime(exp.getTime() - 1):exp.setTime(exp.getTime()  + times);
        var expires = "expires="+exp.toUTCString();
        document.cookie = name+ "="+ self._dataDeal(valArray) + "; " + expires; //重置cookie
    },
    _dataDeal: function(data){
        var dataOK=JSON.stringify(data).replace(/\s+/g,'');
        return encodeURIComponent(dataOK);
    },
    _getsec: function(str){  //日期读取
        var str1=str.substring(1,str.length)* 1,str2=str.substring(0,1);
        if (str2=="s")
        {
            return str1*1000;
        }
        else if (str2=="h")
        {
            return str1*60*60*1000;
        }
        else if (str2=="d")
        {
            return str1*24*60*60*1000;
        }
    }
}