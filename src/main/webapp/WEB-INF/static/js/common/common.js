var tipsIcon = 0;
var successIcon = 1;
var errorIcon = 2;
var questionIcon = 3;
var lockIcon = 4;
var unsatisfyIcon = 5;
var satisfyIcon = 6;
$(function() {
    formatMoney();
    cssForDisabledAndRO();
// deleteBankCardOption();
    setTokenId();
    verifyCnic();
    verifyMobileNo();
    verifyMPin();
    verifyCharacter();
    verifyOTPInput();
    verifyTransAmount();
    verifyMobileAccount();
    verifySimOC();
    verifyEmail();
});
function setTokenId(){
    var $form =  $("form").eq(0);
    var $input = $('<input type= "hidden" name= "tokenId" />');
    if(typeof(agentTransTokenId)!="undefined" && agentTransTokenId!=""){
        $input.val(agentTransTokenId);
        $form.append($input);
    }
}

function delAttribute(element,attributeName){
    $(element).prop(attributeName,"");
    $(element).removeAttr(attributeName);
}

// 询问提示弹出框
function confirmMsg(msg, title, btn1Name, btn2Name, ifCommit,ifCancel) {
    var btn1 = btn1Name;
    btn1 = isNull(btn1) ? 'Confirm' : btn1;
    var btn2 = btn2Name;
    btn2 = isNull(btn2) ? 'Cancel' : btn2;

    title = isNull(title) ? 'Info' : title;


    layer.confirm(msg, {
        time : 0,
        btn : [ btn1, btn2 ],
        icon : questionIcon,
        title : title,
        shade : 0.3,
        success : function(layero, index) {
        },
        btn2:function(){
            if (typeof (ifCancel) == "function")
                ifCancel();
            else
                return;
        },
        yes : function(index) {
            layer.close(index);
            if (typeof (ifCommit) == "function")
                ifCommit();
            else
                return;
        },
        cancel:function(){
            if (typeof (ifCancel) == "function")
                ifCancel();
            else
                return;
        }
    });
}
// 信息提示弹出框
function tipsMsg(msg, iconNum, cancelCallback) {
    var iconImg = iconNum ? tipsIcon : iconNum;

    layer.msg(msg, {
        time : 0,
        closeBtn : true,
        icon : iconImg,
        shade : 0.3,
        success : function(layero, index) {
        },
        cancel : function(index, layero) {
            if (typeof (cancelCallback) == "function") {
                cancelCallback();
            }
            layer.close(index);
        },
        end : function() {
        }
    });
}
function tipsMsgWithOutClose(msg, iconNum, cancelCallback) {
    var iconImg = iconNum ? tipsIcon : iconNum;

    var index = layer.msg(msg, {
        time : 5000,
        icon : iconImg,
        shade : 0.3,
        success : function(layero, index) {
        },
        end : function() {
            if (typeof (cancelCallback) == "function") {
                cancelCallback();
            }
            // layer.closeAll();
        }
    });
}
// 输入框错误信息提示弹出框
function inputTips(msg, id) {
    layer.tips(msg, id, {
        tips : [ 2, '#e24715' ],
        time : 3000
    });
}

/**
 * 验证输入框是否为空 并出提示
 * 限制：1，被验证的输入框必须是text类型
 *      2，被验证的输入框必须被外层元素包裹 ，比如位于form内
 *      3，需要用这个方法的js，必须在其对应的 jsp 页面其全局变量，变量名为canNotEmpty
 * 关于canNotEmpty：用于提示语的多语言，“xxx不为空”
 * return true:非空
 *        false:有空
 */
function verifyInput(formElement) {
    var isNotEmpty = false;
    var inputNumber = $(formElement).find("input[type='text']").length;
    $(formElement).find("input[type='text']").each(function() {
        var thisElementInput = $(this);
        var inputValue = thisElementInput.val();

        //排除不需要验证的
        if(thisElementInput.prop("title")=="no-verify"){
            inputNumber--;
            return;
        }

        //隐藏的不需要验证
        if(thisElementInput.is(":hidden")){
            inputNumber--;
            return;
        }

        // 排除复选插件的input
        if(thisElementInput.prop("class").indexOf("search-txt")>=0){
            inputNumber--;
            return;
        }

        //排除disabled
        if(thisElementInput.prop("disabled")){
            inputNumber--;
            return;
        }

        isNotEmpty = ($.trim(inputValue) == "");
        //非空判断
        var m = canNotEmpty;
        if(typeof(canNotEmpty)=="defined" || canNotEmpty=="" || canNotEmpty==null){
            m = " "+$.trim("不能为空!");
        }else{
            canNotEmpty = " "+$.trim(canNotEmpty);
            m = canNotEmpty;
        }
        isNotEmpty = verifyInputMsg(isNotEmpty,thisElementInput,m);
        if(!isNotEmpty){
            return false;
        }
        //手机号定值长度为11位
        var isMobile = thisElementInput.hasClass("mobilePattern-verify");
        //判断固话
        var mobileName = thisElementInput.prop("name");
        var mobileMaxLength = 11;
        var message = ' is not collect,because the min-length is 11 digit';
        if(mobileName.toLowerCase().indexOf("landline")>=0){
            mobileMaxLength = 10;
            message = ' is not collect,because the min-length is 10~11 digit';
        }
        var lengthCondition = isMobile && !isMinLength(inputValue,mobileMaxLength);
        isNotEmpty = verifyInputMsg(lengthCondition,thisElementInput,message);
        if(!isNotEmpty){
            return false;
        }
        //cnic号定值长度为15位
        var isCnic = thisElementInput.hasClass("cnicPattern-verify");
        message = ' is not collect,because the min-length is 13 digit';
        lengthCondition = isCnic && !isMinLength(inputValue,13);
        isNotEmpty = verifyInputMsg(lengthCondition,thisElementInput,message);
        if(!isNotEmpty){
            return false;
        }
        //otp定值长度为6位
        var isOTP = thisElementInput.hasClass("otp-verify");
        message = ' is not collect,because the min-length is 6 digit';
        lengthCondition = isOTP && !isMinLength(inputValue,6);
        isNotEmpty = verifyInputMsg(lengthCondition,thisElementInput,message);
        if(!isNotEmpty){
            return false;
        }
        //mobileAccount定值长度为6位
        var isMobileAccount = thisElementInput.hasClass("mobileAccountPattern-verify");
        message = ' is not collect,because the min-length is 11 digit';
        lengthCondition = isMobileAccount && !isMinLength(inputValue,11);
        isNotEmpty = verifyInputMsg(lengthCondition,thisElementInput,message);
        if(!isNotEmpty){
            return false;
        }
        //mPin定值长度为6位
        var isMPin = thisElementInput.hasClass("mPin-verify");
        message = ' is not collect,because the min-length is 6 digit';
        lengthCondition = isMPin && !isMinLength(inputValue,6);
        isNotEmpty = verifyInputMsg(lengthCondition,thisElementInput,message);
        if(!isNotEmpty){
            return false;
        }
        //贴膜卡卡号定值长度为16位
        var isSimOC = thisElementInput.hasClass("simocNo-verify");
        message = ' is not collect,because the min-length is 16 digit';
        lengthCondition = isSimOC && !isMinLength(inputValue,16);
        isNotEmpty = verifyInputMsg(lengthCondition,thisElementInput,message);
        if(!isNotEmpty){
            return false;
        }

        //电子邮箱格式
        var isEmail = thisElementInput.hasClass("emailPattern-verify");
        message = ' is not collect:E-mail format is incorrect';
        var reg = /^[a-zA-Z0-9_-]+[\\.a-zA-Z0-9_-]*@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        lengthCondition = isEmail&&!reg.test(inputValue);
        isNotEmpty = verifyInputMsg(lengthCondition,thisElementInput,message);
        if(!isNotEmpty){
            return false;
        }
        isNotEmpty = true;
    });

    if(isNotEmpty){
        $(":disabled").prop("disabled",false);
    }

    if(inputNumber==0){
        return true;
    }

    return isNotEmpty;
}



function verifySelect(formElement) {
    var isNotEmpty = false;
    var selectNumber = $(formElement).find("select").length;
    $(formElement).find("select").each(function() {
        var thisElementSelect = $(this);
        var selectValue = thisElementSelect.val();

        //排除不需要验证的
        if(thisElementSelect.prop("title")=="no-verify"){
            selectNumber--;
            return;
        }

        //隐藏的不需要验证
        if(thisElementSelect.is(":hidden")){
            selectNumber--;
            return;
        }


        //排除disabled
        if(thisElementSelect.prop("disabled")){
            selectNumber--;
            return;
        }

        isNotEmpty = ($.trim(selectValue) == "");
        //非空判断
        var m = canNotEmpty;
        if(typeof(canNotEmpty)=="defined" || canNotEmpty=="" || canNotEmpty==null){
            m = " can not empty!"
        }
        isNotEmpty = verifyInputMsg(isNotEmpty,thisElementSelect,m);
        if(!isNotEmpty){
            return false;
        }
        isNotEmpty = true;
    });

    if(isNotEmpty){
        $(":disabled").prop("disabled",false);
    }

    if(selectNumber==0){
        return true;
    }

    return isNotEmpty;
}



function verifyInputMsg(condition,inputElement,message){
    var elementId = inputElement.prop("id");
    var hasId = (typeof(elementId)!="undefinded" && null!=elementId && ""!=elementId);
    var inputTypeName = inputElement.parent().prev().text();
    var msg = $.trim(inputTypeName) +" "+$.trim(message);
    var flag = false;
    if(condition){
        var inputId = "emptyInputId";
        if (!hasId) {
            inputElement.prop("id", inputId);
        }else{
            inputId = elementId;
        }
        msg = msg+"";
        if(msg.indexOf("*")>=0){
            msg = msg.replace("*","&nbsp;");
        }
        inputTips(msg, "#" + inputId);
        if (!hasId) {
            inputElement.prop("id", "");
        }
        inputElement.focus();
        flag = false;
    }else{
        if (!hasId) {
            inputElement.prop("id", "");
        }
        flag = true;
    }
    return flag;
}
function isMinLength(v,l){
    return v.length - l >=0;
}
// 字符串判断是否为空
function isNull(str) {
    return (typeof (str) == 'undefined' || null == str || '' == str.trim());
}
function isNotNull(str) {
    return !isNull(str);
}
// 限制只能输入数字
function onlyNumberInput(element) {
    $(element).unbind('keyup').bind('keyup',function(event) {
        obj = $(element)[0];
        obj.value = obj.value.replace(/[^\d.]/g, ""); //清除“数字”和“.”以外的字符
        obj.value = obj.value.replace(/\.{2,}/g, "."); //只保留第一个. 清除多余的
        obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
        obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3'); //只能输入两个小数
        if(obj.value.indexOf(".") < 0 && obj.value != "") { //以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额
            obj.value = parseFloat(obj.value);
        }
    });
}
// 限制只能输入数字
function onlyNumberInput2(element) {
    $(element).unbind('keyup').bind('keyup',function(event) {
        obj = $(element)[0];
        obj.value = obj.value.replace(/[^\d]/g, ""); //清除“数字”以外的字符
        obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3'); //只能输入两个小数
    });
}

//限制只能输入字母
function onlyCharacterInput(element) {
    $(element).unbind('keypress').bind('keypress', function(event) {
        var event = event || window.event;
        var getValue = $(this).val();
        // 控制只能输入的值
        if (event.which &&
            (event.which < 65 || (event.which > 90 && event.which < 97) || event.which > 122)
            && event.which != 8 && event.which != 46 &&  event.which != 32) {
            event.preventDefault();
            return;
        }
    });
    $(element).blur(function() {
        var result = "";
        var val = $(this).val();
        var chars = val.split("");
        for (var i=0; i<chars.length; i++) {
            var char = chars[i];
            var tmp = parseFloat(char);
            if (isNaN(tmp)) {
                result += char+"";
            }
        }
        $(this).val(result);
    });
}

function formatMoney() {
    $('input.money-verify').unbind("blur").bind("blur",
        function() {
            var $input =  $(this);
            var s = $input.val();
            if(s=="")return false;
            var v = getMoneyStr($input);
            var maxLength = $input.prop("maxlength");
            maxLength = parseInt(maxLength);
            delAttribute($input,"maxlength");
            $input.val(v);

            var name=$input.prop("name");
            var maxStr = maxLength<=0?"":"maxlength="+maxLength;
            var $hidden = "<input type='hidden' value='"+s+"' name='"+name+"' "+maxStr+"/>";
            $input.prop("name","");
            $input.after($hidden);
        });
    $('input.money-verify').unbind("focus").bind("focus",function() {
        var $input =  $(this);
        var $hidden = $input.nextAll(":hidden");
        if($hidden.length==0)return false;
        var name=$hidden.prop("name");

        var maxLength = $hidden.prop("maxlength");
        maxLength = parseInt(maxLength);
        var maxStr = maxLength<=0?"":"maxlength="+maxLength;
        if(maxStr!="")
            $input.prop("maxlength",maxLength);

        $input.prop("name",name);
        $input.val($hidden.val());
        $hidden.remove();
    });
    onlyNumberInput($('input.money-verify'));
}

function getMoneyStr($input){
    var s = $input.val();
    if($.trim(s) == "") {
        return s;
    }
    //构造显示值begin
    s = parseFloat(s);
    if(s == 0)return "0.00";
    s = s + "";
    if(s.indexOf(".") < 0)s = s + ".00";
    //整数和小数分开进行处理
    var i = s.split(".")[0];
    var d = s.split(".")[1];
    if(d.length<2)d = d+"0";
    if(i.length<=3)return i+"."+d;
    var iLength = i.length;
    var splitNum1 = parseInt(i.length % 3);
    var splitNum = parseInt(i.length / 3);
    if(splitNum1 == 0) splitNum -= 1;
    var arr = new Array();
    for(var k = 0; k < splitNum; k++) {
        var temp = i.substr(i.length - 3, i.length - 1);
        i = i.substring(0, i.length - 3);
        arr.push(temp);
        if(i.length <= 3)arr.push(i);
    }
    var valInShow = "";
    for(var k = arr.length - 1; k >= 0; k--) {
        var h = arr[k];
        if(h.length < 3) valInShow = valInShow + "" + h;
        else valInShow = valInShow + "," + h;
    }
    if(valInShow.indexOf(",") == 0)valInShow = valInShow.substring(1, valInShow.length);
    valInShow = valInShow + "." + d;
    return valInShow;
}

function cssForDisabledAndRO() {
    $("input[disabled]").css("background", "#EEEEEE");
    $("input[readonly]").css("background", "#EEEEEE");
}

function trClick(trElements,dbCallBack) {
    trElements.find("td").each(function(){
        var tdElement =  $(this);
        var checkBoxChildren = tdElement.find("[type='checkbox']");
        if(checkBoxChildren.length==0){
            tdElement.unbind("click").bind("click",function() {
                var trElement = tdElement.parent();
                var isCheck = trElement.find("td input[type='checkbox']").prop("checked");
                trElement.find("td input[type='checkbox']").prop("checked", !isCheck);
                if(typeof(dbCallBack)=="function"){
                    dbCallBack(trElement.find("td input[type='checkbox']").val(),trElement.find("td input[type='checkbox']").prop("checked"));
                }
            });
        }
    });
}


function decimal(num,v){
    var vv = Math.pow(10,v);
    return Math.round(num*vv)/vv;
}



function getTargetElementWidth(element){
    var inputWidth =$(element).width();
    var borderLeftWidth = parseInt($(element).css("border-left-width"));　// 左边框长度
    // 8
    // (Number型，可用于计算)
    var borderRightWidth = parseInt($(element).css("border-right-width"));　// 右边框长度
    // 8（Number型，可用于计算）

    var paddingRightWidth = parseInt($(element).css('padding-right'));
    var paddingLeftWidth =parseInt($(element).css('padding-left'));


    var theWidth = inputWidth+borderLeftWidth+borderRightWidth+paddingRightWidth+paddingLeftWidth;
    return theWidth;
}


/**
 * 校验密码
 * 1、长度不小于6位
 * 2、必须以字母开头
 * 3、必须包含特殊字符
 * 4、必须包含数字
 * @param true 密码校验通过
 *        false 密码校验不通过
 * @return
 */
function validPwd(s){
    if(typeof(s)=="undefined"||s==null||$.trim(s)==""){
        return false;
    }
    if(s.length < 6){
        return false;
    }
    if(s.match("^[a-zA-z](.*)") && s.match("(.*)[-`=\\\\\\[\\];',./~!@#$%^&*()_+|{}:\"<>?]+(.*)") && s.match("(.*)\\d+(.*)")){
        return true;
    }
    return false;
}


function deleteBankCardOption(){
    $("select").children("option").each(function(){
        var optionsValue = $(this).html();
        if(optionsValue.toLowerCase().indexOf("bank")>=0){
            $(this).remove();
        }else if(optionsValue.toLowerCase().indexOf("银行卡")>=0){
            $(this).remove();
        }
    });
}

// 表单提交-ajax方式
function ajaxSubmit(submitBtnId,formId,resetForm,callBack){
    var btnElement = $("#"+submitBtnId);
    var formElement = $("#"+formId);
    btnElement.click(function() {
        formElement.on("submit", function() {
            formElement.ajaxSubmit({
                type : formElement.prop("method"),// 提交方式 get/post
                url : formElement.prop("action"),
                data : formElement.serialize(),
                success : function(data) { // data 保存提交后返回的数据，一般为 json 数据
                    callBack(data);
                },
                complete : function() {
                    if(resetForm){
                        formElement.resetForm(); // 提交后重置表单
                    }
                }
            });
            return false;
        });
    });
}

// 生物识别
function doBioInAgent(bioParamElementClass,doBioCallBack,cancelBioCallBack){
    var $cnicNoElement=$("."+bioParamElementClass);
    var imgUrl = path+"/assets/img/fingerIndex1.png";
    var $image = $("<img src='"+imgUrl+"' width='400px' height='208px' />");
    var $pDIV = $($cnicNoElement.parents("div")[$cnicNoElement.parents("div").length-1]);

    var $imageDiv = $('<div id="bioImageDiv" style="display:none"></div>');
    $imageDiv.html($image);

    $pDIV.after($imageDiv);

    var getInfo = function(index) {
        //判断是否为disabled
        var k=new Array();
        $cnicNoElement.each(function(i){
            var $thisElement = $(this);
            var isDiasbled = $thisElement.prop("disabled");
            if(isDiasbled){
                k.push(i);
                $thisElement.prop("disabled",false);
            }
        });
        if(!verifyInput($cnicNoElement.parent().parent())){
            //还原disabled
            $cnicNoElement.each(function(i){
                var $thisElement = $(this);
                for(var x=0;x<k.length;x++){
                    var  y = k[x];
                    if(y==i){
                        $thisElement.prop("disabled",true);
                    }
                }
            });
            return false;
        }
        $.ajax({
            url : path + "/agentCommon/getInfoByBio",
            data : $cnicNoElement.serialize(),
            success : function(data) {
                //还原disabled
                $cnicNoElement.each(function(i){
                    var $thisElement = $(this);
                    for(var x=0;x<k.length;x++){
                        var  y = k[x];
                        if(y==i){
                            $thisElement.prop("disabled",true);
                        }
                    }

                });
                if ("0000" != data.code) {
                    $("#bioImageDiv").hide();
                    layer.open({
                        title:"Fingerprint Scan",
                        type: 1,
                        area: ['auto', 'auto'], //宽高
                        btnAlign: 'c',
                        btn: ["Do BIO","Cancel"],
                        yes: function(index, layero){
                            // layer.close(index);
                            getInfo(index);
                        },
                        btn2: function(index, layero){
                            if (typeof (cancelBioCallBack) == "function")
                                cancelBioCallBack();
                            layer.close(index);
                        },
                        content: $("#bioImageDiv")
                    });
                    return false;
                }

                if(typeof(doBioCallBack)=="function"){
                    if((doBioCallBack+"").indexOf("data")>=0){
                        doBioCallBack(data);
                    }else{
                        doBioCallBack();
                    }
                }

                layer.close(index);
            }
        });
    }

    layer.open({
        title:"Fingerprint Scan",
        type: 1,
        area: ['auto', 'auto'], //宽高
        btnAlign: 'c',
        btn: ["Do BIO","Cancel"],
        yes: function(index, layero){
            getInfo(index);
        },
        btn2: function(index, layero){
            if (typeof (cancelBioCallBack) == "function")
                cancelBioCallBack();
            layer.close(index);
        },
        content: $("#bioImageDiv")
    });
}
// 序列化变对象
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
// 发送短信验证码
function sendOTPForAgentClient(){
    $("#sendSmsVerCode").click(function(){
        $("#mobileNo").prop("disabled",false);
        $.ajax({
            url:path+"/SmsSender/sendOTP",
            data:$("#mobileNo").serialize(),
            success:function(){
                $("#mobileNo").prop("disabled",true);
            },complete:function(){
                setBtnTimeout($("#sendSmsVerCode"));
            }
        });
    });
}
function sendOTPForAgentClient2(){
    $("#sendSmsVerCode").click(function(){
        $("[name='mobileNo']").prop("disabled",false);
        $.ajax({
            url:path+"/SmsSender/sendOTP",
            data:$("[name='mobileNo']").serialize(),
            success:function(){
                $("[name='mobileNo']").prop("disabled",true);
            },complete:function(){
                setBtnTimeout($("#sendSmsVerCode"));
            }
        });
    });
}
//验证otp
function verifyOTP(){
    var isCorrectOtp = true;
    /* $.ajax({
         url:path+"/SmsSender/verifyOTP",
         data:$(".verifyOTPParam").prop("disabled",false).serialize(),
         async: false,
         success:function(data){
             return isCorrectOtp;
             isCorrectOtp = "0000"==data.code;
             if(!isCorrectOtp){
                 if(typeof(data)!="object" && data.indexOf("error")){
                     tipsMsgWithOutClose("Worng OTP!");
                 }else{
                     tipsMsgWithOutClose(data.msg);
                 }
             }
             return isCorrectOtp;//isCorrectOtp;
         }
     });*/
    return isCorrectOtp;//isCorrectOtp;
}

// checkBox单选
function checkBoxSingleChecked(checkBoxName,clickfunction) {
    var checkboxElements = $("input[type='checkbox'][name='"+checkBoxName+"']");
    checkboxElements.click(function() {
        var thisBox = $(this);
        var hasCheck = thisBox.prop("checked");

        //本来就是true的就直接退出，不执行下面方法
        if(!hasCheck){
            return false;
        }
        var k = checkboxElements.index(thisBox);
        checkboxElements.each(function(i) {
            if (i != k) {
                checkboxElements.eq(i).prop("checked", !hasCheck);
            }
        });
        if(typeof(clickfunction)=="function"){
            if(hasCheck){
                clickfunction();
            }
        }
    });
}

function encrypt(target) {
    var encryptText = "";
    var resultArr = new Array();
    $.ajax({
        url    : path + "/cryptographic-service",
        method : 'GET',
        async  : false,
        cache  : false,
        success:function(publicKey){
            // 错误判断
            // var crypto = new JSEncrypt();//旧的
            // crypto.setPublicKey(publicKey);//旧的
            var crypto = new RSAKey;
            crypto.readPKCS8PubKeyHex(publicKey);
            if($.isArray(target)){
                for(var i=0;i<target.length;i++){
                    resultArr.push(crypto.encrypt(target[i]));
                }
            }else{
                encryptText = crypto.encrypt(target);
            }
        }
    });

    if($.isArray(target)){
        return resultArr;
    }else{
        return encryptText;
    }
}

function signature(target) {
    var signData = "";
    $.ajax({
        url    : path + "/signature-service",
        method : 'GET',
        async: false,
        cache: false,
        success:function(privateKey){
            // 错误判断
            var crypto = new RSAKey;
            crypto.readPKCS8PrvKeyHex(privateKey);
            signData = crypto.sign(target, 'sha256');
        }
    });
    return signData;
}

/**
 * 必填项
 * @returns
 */
function mustBeNotNull(){
    $("input[type='text']:not(:disabled)").each(function(){
        var thisElementInput = $(this);
        //排除不需要验证的
        if(thisElementInput.prop("title")=="no-verify"){
            return;
        }
        var inputName = thisElementInput.parent().prev().html();

        if(inputName.indexOf("*")>=0){
            return;
        }
        var notNullFlag = "<span style='color:red;font-size: 20px;vertical-align: middle;line-height: 30px;'>*</span>";
        inputName =inputName+ notNullFlag;
        thisElementInput.parent().prev().html(inputName);
    });
}
/**
 * 验证手机号
 * @returns
 */
function verifyMobileNo(){
    var verifyNames = ['mobileNo', 'mobileNo2', 'mobile', 'senderMobileNo', 'receiverMobileNo',
        'kinMobileNo', 'bizLandlineNo', 'landlineNo', 'landlineNo2', 'reContanctPersonTel','staffMobile'];
    for (var i = 0; i < verifyNames.length; i++) {
        var $target = $("[name='"+verifyNames[i]+"']");
        if ($target.length>0) {
            $target.addClass("mobilePattern-verify");
        }
    }
    $(".mobilePattern-verify").each(function(){
        $(this).prop("maxlength","11");
        onlyNumberInput2($(this));
    });
}


/**
 * 校验核心号
 * @returns
 */
function verifyCoreAccount(){
    var verifyNames = ['coreAcctNo'];
    for (var i = 0; i < verifyNames.length; i++) {
        var $target = $("[name='"+verifyNames[i]+"']");
        if ($target.length>0) {
            $target.addClass("coreAcctNo-verify");
        }
    }
    $(".coreAcctNo-verify").each(function(){
        onlyNumberInput($(this));
    });
}

/**
 * 验证电子账户
 * @returns
 */
function verifyMobileAccount(){
    var verifyNames = ['mobileAccount'];
    for (var i = 0; i < verifyNames.length; i++) {
        var $target = $("[name='"+verifyNames[i]+"']");
        if ($target.length>0) {
            $target.addClass("mobileAccountPattern-verify");
        }
    }
    $(".mobileAccountPattern-verify").each(function(){
        $(this).prop("maxlength","11");
        onlyNumberInput($(this));
    });
}

/**
 * 验证cnic号格式
 * @returns
 */
function verifyCnic(){
    var verifyNames = ['cnicNo', 'cnic', 'senderCnicNo', 'receiverCnicNo', 'identifyNo'];
    for (var i = 0; i < verifyNames.length; i++) {
        var $target = $("[name='"+verifyNames[i]+"']");
        if ($target.length>0) {
            $target.addClass("cnicPattern-verify");
        }
    }
    $(".cnicPattern-verify").each(function(){
        $(this).prop("maxlength","13");
        onlyNumberInput($(this));
    });
}
/**
 * 验证email格式
 * @returns
 */
function verifyEmail(){
    var verifyNames = ['email'];
    for (var i = 0; i < verifyNames.length; i++) {
        var $target = $("[name='"+verifyNames[i]+"']");
        if ($target.length>0) {
            $target.addClass("emailPattern-verify");
        }
    }
}

/**
 * 验证纯字母输入格式
 * @returns
 */
function verifyCharacter(){
    $(".character-verify").each(function(){
        //$(this).prop("maxlength","13");
        onlyCharacterInput($(this));
    });
}

//限制只能输入字母
function onlyCharacterInput(element) {
    $(element).unbind('keypress').bind('keypress', function(event) {
        var event = event || window.event;
        var getValue = $(this).val();
        // 控制只能输入的值
        if (event.which &&
            (event.which < 65 || (event.which > 90 && event.which < 97) || event.which > 122)
            && event.which != 8 && event.which != 46 &&  event.which != 32) {
            event.preventDefault();
            return;
        }
    });
    $(element).blur(function() {
        var result = "";
        var val = $(this).val();
        var chars = val.split("");
        for (var i=0; i<chars.length; i++) {
            var char = chars[i];
            var tmp = parseFloat(char);
            if (isNaN(tmp)) {
                result += char+"";
            }
        }
        $(this).val(result);
    });
}

/**
 * 验证mPin格式
 * @returns
 */
function verifyMPin(){
    var verifyNames = ['mPin', 'staffMPin', 'reStaffMPin','newStaffMpin','reNewStaffMpin','oldMpin','reMPin','staffPassword','reStaffPassword'];
    for (var i = 0; i < verifyNames.length; i++) {
        var $target = $("[name='"+verifyNames[i]+"']");
        if ($target) {
            $target.addClass("mPin-verify");
            $target.after('<input type="password" style="display:none;"/>');
        }
    }
    $(".mPin-verify").each(function(){
        var n = $(this).prop("name");
        var index = $.inArray(n, verifyNames);
        if(index>=0)
            $(this).prop("maxlength","6");
        onlyNumberInput2($(this));
    });

    $(".mPin-verify").prop("type","text").focus(function(){
        $(this).prop("type","password");
    });
}
/**
 * 验证交易金额
 * @returns
 */
function verifyTransAmount(){
    var verifyNames = ['amount','amountList'];
    for (var i = 0; i < verifyNames.length; i++) {
        var $target = $("[name='"+verifyNames[i]+"']");
        if ($target) {
            $target.addClass("money-verify");
        }
    }
    $(".money-verify").each(function(){
        var n = $(this).prop("name");
        var index = $.inArray(n, verifyNames);
        if(index>=0)
            $(this).prop("maxlength","12");
    });
    formatMoney();
}

function verifyOTPInput(){
    var verifyNames = ['otp'];
    for (var i = 0; i < verifyNames.length; i++) {
        var $target = $("[name='"+verifyNames[i]+"']");
        if ($target) {
            $target.addClass("otp-verify");
        }
    }
    $(".otp-verify").each(function(){
        var n = $(this).prop("name");
        var index = $.inArray(n, verifyNames);
        if(index>=0)
            $(this).prop("maxlength","6");
        onlyNumberInput2($(this));
    });
}

function verifySimOC(){
    var verifyNames = ['simocNo','cardNum'];
    for (var i = 0; i < verifyNames.length; i++) {
        var $target = $("[name='"+verifyNames[i]+"']");
        if ($target) {
            $target.addClass("simocNo-verify");
        }
    }
    $(".simocNo-verify").each(function(){
        var n = $(this).prop("name");
        var index = $.inArray(n, verifyNames);
        if(index>=0)
            $(this).prop("maxlength","16");
        onlyNumberInput($(this));
    });
}

function sameNamesElement(formElement){
    var dataObj = formElement.serializeObject();
    $.each(dataObj,function(k,v){
        var arr = new Array();
        var valueElement = $("[name='"+k+"']");
        if(valueElement.length>1){
            valueElement.prop("disabled", true);
            valueElement.eq(valueElement.length-1).prop("disabled", false);
            var paramVal  = valueElement.eq(valueElement.length-1).val();
            if(paramVal==null||paramVal==""){
                valueElement.each(function(i){
                    var thisElement = valueElement(i);
                    if(thisElement.val()){
                        paramVal = thisElement.val();
                    }
                });
                valueElement.eq(valueElement.length-1).val(paramVal);
            }
        }
    });
}

// 上传
function uploadFile($fileInput,$fileNameArea) {
    var divStyle={
        "width":"auto",
        "float":"left",
        "background":"#A9A9A9",
        "color":"white",
        "height":"30px",
        "line-height":"30px",
        "margin":"5px",
        "padding-left":"5px"
    };
    $fileInput.on("change", function() {
        var fileNumber =  $(".fileNameDisplay").length;
        if(fileNumber == 10){
            tipsMsgWithOutClose("No more than 10 attachments can be uploaded");
            return false;
        }
        var $form = $("#uploadForm");
        var formData = new FormData($form[0]);

        var fileSize = getFileSize($fileInput);
        if(fileSize>1){
            tipsMsgWithOutClose("File's max size is: 1M !");
            return false;
        }
        $.ajax({
            url : $form.prop("action"),
            data : formData,
            type: "POST",
            dataType: "JSON",
            async : true,
            cache : false,
            contentType : false,
            processData : false,
            beforeSend:function(){
                var $uploadFlag  = $fileNameArea.find("#uploadFlag");
                if(typeof($uploadFlag)=='undefined'|| $uploadFlag==null || $uploadFlag.length==0){
                    $uploadFlag = $("<input id='uploadFlag' type='hidden' />");
                    $fileNameArea.append($uploadFlag);
                }
                $uploadFlag.val('1');
            },
            success : function(data) {
                if(data.code != "0000"){
                    tipsMsgWithOutClose(data.msg);
                    return false;
                }
                var fileList = data.fileList;
                for(var i=0;i < fileList.length;i++){
                    var f = fileList[i];
                    var sourceName = f.sourceName;
                    var pk1 = f.pk1;
                    if(!sourceName || !pk1){
                        continue;
                    }
                    var $fileNameDiv = $("<div class='fileNameDisplay'>"+f.sourceName+"</div>");
                    var $imgElement = $("<img src='"+imgCleanSrc+"' style='cursor:pointer'/>");
                    var $filePkDiv = $('<input type="hidden" value="'+f.pk1+'" name="filePK" />');
                    $fileNameDiv.append($imgElement).append($filePkDiv);
                    $fileNameDiv.css(divStyle);
                    $fileNameArea.append($fileNameDiv);
                    $fileNameArea.show();
                    $imgElement.unbind("click").bind("click",function(){
                        $fileNameDiv.remove();
                        var n = $(".fileNameDisplay").length;
                        if(n==0){
                            $fileNameArea.hide();
                        }
                    });
                    var $uploadFlag  = $fileNameArea.find("#uploadFlag");
                    $uploadFlag.val('0');
                }
            },complete:function(){
                var $uploadFlag  = $fileNameArea.find("#uploadFlag");
                $uploadFlag.val('0');
            }
        });
    });
}

//计算手续费
function calFeeForAgent($submitBtn,$calFeeBtn,$form,$amountInput,$transferType,calFunction,calFailFunction){
    $submitBtn.prop("disabled",true);
    $calFeeBtn.click(function(){
        if($transferType){
            var transTypeValue = $transferType.val();
            if(transTypeValue==null || transTypeValue==""){
                inputTips(canNotEmpty,"#"+$transferType.prop("id"));
                return false;
            }
        }
        var $diasbled = $(":disabled");
        if(!verifyInput($form)){
            return false;
        }
        $diasbled.prop("disabled",false);
        $.ajax({
            url:path+"/agentCommon/calFee",
            data:$form.serialize(),
            success:function(data){
                $diasbled.prop("disabled",true);
                if("0000"!=data.code){
                    tipsMsgWithOutClose(data.msg);
                    if(typeof(calFailFunction)=="function"){
                        calFailFunction();
                    }
                    $submitBtn.prop("disabled",true);
                    return false;
                }
                var fee = data.fee;
                var fed = data.fed;
                $("[name='fee']").val(fee);
                $("[name='fed']").val(fed);
                var f = parseFloat(fee)+parseFloat(fed);
                $("#fee").val(f);

                var inputName = $amountInput.prop("name");
                var amount = 0;
                if(!inputName){
                    amount = $amountInput.next().val();
                }else{
                    amount = $amountInput.val();
                }
                var ta = parseFloat(f)+parseFloat(amount);
                $("#totalAmount").val(ta);
                $submitBtn.prop("disabled",false);
                $amountInput.prop("disabled",true);
                $calFeeBtn.prop("disabled",true);
                $form.find("input").prop("disabled",true);
                $form.find("select").prop("disabled",true);
                $("[name='mPin']").prop("disabled",false);
                if(typeof(calFunction)=="function"){
                    calFunction();
                }
            },complete:function(){
                $calFeeBtn.prop("disabled",true);
                $diasbled.prop("disabled",true);
                $submitBtn.prop("disabled",false);
                $("[name='mPin']").prop("disabled",false);



            }
        });
    });
}

// 翻译长度限制的报错
function translateLengthMsg(msg,$dataForm){
    var newMsg = "";
    $dataForm.find("input").each(function(){
        var $thisInput = $(this);
        var inputName = $thisInput.prop("name");
        if(!inputName)return;
        if(msg.indexOf(inputName)<0)return;
        var inputTypeName = $thisInput.parent().prev().text();
        newMsg = msg.replace(inputName,inputTypeName);
        return false;
    });
    return newMsg;
}

function toSuccessPage($dataForm,successUrl,paramObj){
    var $successForm = $("<form action='"+successUrl+"' method='post'></form>");
    $dataForm.after($successForm);
    $.each(paramObj,function(k,v){
        $successForm.append("<input type='hidden' value='"+v+"' name='"+k+"' />");
    });
    $successForm.submit();
}

function getFileSize(fileElement) {
    try {
        var fileSize = 0;
        if ($.support.msie) { //for IE
            var objFSO = new ActiveXObject("Scripting.FileSystemObject");
            var filePath = $(fileElement)[0].value;
            var objFile = objFSO.getFile(filePath);
            var fileSize = objFile.size; //size in kb
            fileSize = fileSize / 1048576; //size in mb 
        } else { //for FF, Safari, Opeara and Others
            fileSize = $(fileElement)[0].files[0].size //size in kb
            fileSize = fileSize / 1048576; //size in mb 
        }
        return fileSize;
    } catch(e) {
        alert(e);
    }
}

/**
 * 前端时间显示处理
 * 1，只处理格式为yyyyMMdd的时间字符串
 * 2，如果有时间显示，则格式为hhmmss，与yyyyMMdd用一个空格隔开
 *   如：20170915 104811
 * @param {} dateVal
 * @returns 返回dd-MM-yyyy hh:mm:ss的格式字符串
 */
function dateDeal(dateVal){
    var date = dateVal.split(" ");
    var dateUtil = new Date();
    var dateShow = dateUtil.parseDateStr(date[0],"yyyyMMdd").Format("dd-MM-yyyy");
    var timeStr =  date[1];
    if(typeof(timeStr)!="undefined" && timeStr!=null && timeStr!=""){
        var hh = timeStr.substring(0,2);
        var mm = timeStr.substring(2,4);
        var ss = timeStr.substring(4,6);
        return dateShow+" "+hh+":"+mm+":"+ss;
    }
    return dateShow;
}

function mPinCanNotEmpty(){
    //mPin框不能为空
    var m = canNotEmpty;
    if(typeof(canNotEmpty)=="defined" || canNotEmpty=="" || canNotEmpty==null){
        m = " can not empty!"
    }
    var $mPin = $("input[name='mPin']:visible");
    var mPin = $mPin.val();
    if(mPin==""){
        verifyInputMsg(true,$mPin,m);
        return false;
    }
    return true;
}

/**
 * 加载富文本框
 * 与后台交互的数据一般使用name属性。如果没有特别的逻辑，直接通过name就能获取到
 * 富文本框的值
 * @param {} element 加载富文本的div
 * @returns {}
 */
function textEditor(element){
    var toolbar = [
        // [groupName, [list of button]]
        ['style', ['bold', 'italic', 'underline']],
        ['font', ['strikethrough', 'superscript', 'subscript']],
        ['fontsize', ['fontsize']],
        ['color', ['color']],
        ['para', ['ul', 'ol', 'paragraph']],
        ['height', ['height']],
        ['insert',['link']],
        ['layout',['fullscreen']]
    ];
    var options = {
        height: 300,
        minHeight: 300,
        maxHeight: null,
        focus: false ,
        toolbar:toolbar,
        callbacks:{
            onBlur: function() {
                var textVal = $(element).summernote('code');
                var contentName = $(element).prop("name");
                $(element).prop("name","");
                $(element).removeAttr("name")
                $(element).html("<input name='"+contentName+"' type='hidden' value='"+textVal+"' />");
            },
            onFocus:function(){
                $(element).next().children().eq(2).children().eq(2).find("p").css("text-align","left");
            }
        }
    };
    $(element).summernote(options);
    var $toolBarBtnArr = $(element).next().find("button");
    $toolBarBtnArr.addClass("toolBarBtn");
}

/**
 * 获取富文本框的值
 * @param {} element
 * @returns {}
 */
function getTextEditorVal(element){
    return $(element).summernote('code');
}


//设置按钮等待状态
var waitSec = 120;
function setBtnTimeout(element){
    var $btn = $(element);
    var btnName = $(element).html();
    if(btnName.indexOf("(")>=0){
        btnName = btnName.split("(")[0];
    }
    $btn.prop("disabled",waitSec!=0);
    if(waitSec!=0){
        setTimeout(function() {setBtnTimeout(element);},1000);
        $btn.html(btnName+"("+waitSec+"s)");
        waitSec --;
    }else{
        $btn.html(btnName);
        waitSec = 120;
    }
}

//加载多选框
function initMultiSelect(selectElement,isfloat) {
    var selectSumo = $(selectElement)[0].sumo;
    if(selectSumo){
        selectSumo.unload();
        $(selectElement).removeClass("SumoUnder");
        delAttribute($(selectElement),"tabindex");
        delAttribute($(selectElement),"style");
        $(selectElement).find("option").show();
        $(selectElement).show();
    }
    var floatWidth = 999999;
    if(typeof(isfloat)=="undefined"||isfloat==null||isfloat==""){
        floatWidth = 0;
    }else{
        if(isfloat){
            floatWidth = 999999
        }else{
            floatWidth = 0;
        }
    }
    $(selectElement).SumoSelect({
        placeholder : "Please Select",
        captionFormat : "You have selected {0} items",
        captionFormatAllSelected : "You have selected all items,the total items is {0}",
        csvDispCount : 3,// 当多选项大于等于3的时候，显示captionFormat的内容、
        floatWidth : floatWidth,// 最小的设备宽度，如果小于这个宽度，下拉列表框将渲染为浮动弹出的效果
        forceCustomRendering : false,// 是否开启拉动条功能
        selectAll : true,// 是否需要全选按钮，selectAll全选的名称由locale属性修改
        search : false,// 是否需要搜索功能
        prefix : "",// 选择框显示内容的前缀，如显示"aa 你已选择xxx",其中的"aa"为prefix
        locale : [ 'OK', 'Cancel', 'All' ],// 依次为修改按钮名称
        showTitle : true,
        closeCallBack : function() {
            $(selectElement).css("z-index", "-1");
        },
        openCallBack : function() {
            $(selectElement).css("z-index", "-1");
        },
        initCallBack:function(){
            $(selectElement).css("z-index", "-1");
        }
    });
    //$(selectElement).find("option").hide();
    //$(selectElement).hide();
}