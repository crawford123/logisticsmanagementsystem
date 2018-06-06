//获取URL中的request参数
function JsGetUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return decodeURIComponent(r[2]);
    }
    else {
        return "";
    }
}

//验证输入项，minstr, maxstr的值为0，不做长度验证
function ValiString(valid, tipstr, minstr, maxstr) {
    var ret = true;
    var valiVal = $.trim($("#" + valid).val());
    if (valiVal == "" || valiVal == "undefined") {
        mui.toast('请输入' + tipstr);
        ret = false;
    }
    if (ret) {
        if (minstr != "" && minstr != "undefined" && minstr != "0") {
            if (valiVal.length < minstr) {
                mui.toast(tipstr + "长度小于" + minstr);
                ret = false;
            }
        }
    }
    if (ret) {
        if (maxstr != "" && maxstr != "undefined" && maxstr != "0") {
            if (valiVal.length > maxstr) {
                mui.toast(tipstr + "长度大于" + maxstr);
                ret = false;
            }
        }
    }
    return ret;
}

//电话/手机验证
function ValiMobileTel(valid, tipstr) {
    var ret = true;
    var valiVal = $("#" + valid).val();
    if (valiVal == "" || valiVal == "undefined") {
        mui.toast('请输入' + tipstr);
        ret = false;
    }
    if (ret) {
        var fdStart = valiVal.indexOf("0");
        if (fdStart == 0) {
            var regx = /^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/;
            if (!regx.test(valiVal)) {
                mui.toast(tipstr + "格式有误");
                ret = false;
            }
        } else if (fdStart == -1) {
            var regx = /^1[34578]\d{9}$/;
            if (!regx.test(valiVal)) {
                mui.toast(tipstr + "格式有误");
                ret = false;
            }
        }
    }
    return ret;
}

//手机验证
function ValiMobile(valid, tipstr) {
    var ret = true;
    var valiVal = $("#" + valid).val();
    if (valiVal == "" || valiVal == "undefined") {
        mui.toast('请输入' + tipstr);
        ret = false;
    }
    if (ret) {
        var regx = /^1[34578]\d{9}$/;
        if (!regx.test(valiVal)) {
            mui.toast(tipstr + "格式有误");
            ret = false;
        }
    }
    return ret;
}

//电话验证
function ValiTel(valid, tipstr) {
    var ret = true;
    var valiVal = $("#" + valid).val();
    if (valiVal == "" || valiVal == "undefined") {
        mui.toast('请输入' + tipstr);
        ret = false;
    }
    if (ret) {
        var regx = /^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/;
        if (!regx.test(valiVal)) {
            mui.toast(tipstr + "格式有误");
            ret = false;
        }
    }
    return ret;
}
//去掉汉字  
function RemoveChinese(obj) {
    obj.value = obj.value.replace(/[\u4e00-\u9fa5]/g, "");
}
//只能输入数字和字符
function ClearNoNumChar(obj) {
    obj.value = obj.value.replace(/[^\w\.\/]/ig, "");
}

//过滤特殊字符
function ClearSpChar(obj) {
    obj.value = obj.value.replace(/[@#\$%\^&\*]+/g, "");
    obj.value = obj.value.replace(" ", "");
}

//删除空格
function ClearSpaceChar(obj) {
    obj.value = obj.value.replace(" ", "");
}
 
//文本框只能输入数字.调用：<input id="input1" onkeyup="clearNoNum(this)" />
function ClearNoNum(obj) {
    //先把非数字的都替换掉，除了数字和.
    obj.value = obj.value.replace(/[^\d.]/g, "");
    //必须保证第一个为数字而不是.
    obj.value = obj.value.replace(/^\./g, "");
    //保证只有出现一个.而没有多个.
    obj.value = obj.value.replace(/\.{2,}/g, ".");
    //保证.只出现一次，而不能出现两次以上
    obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
    obj.value = obj.value.replace(/^0+/,"");
}
//文本框只能输入数字.调用：<input id="input1" onkeyup="clearNoNum(this)" />
function ClearNoNum2(obj) {
    //先把非数字的都替换掉，除了数字和.
    obj.value = obj.value.replace(/[^\d.]/g, "");
    //必须保证第一个为数字而不是.
    obj.value = obj.value.replace(/^\./g, "");
    //保证只有出现一个.而没有多个.
    obj.value = obj.value.replace(/\.{2,}/g, ".");
    //保证.只出现一次，而不能出现两次以上
    obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
}
//文本框只能输入数字.调用：<input id="input1" onkeyup="clearNoNum(this)" />
function ClearNoNum3(obj) {
    //先把非数字的都替换掉，除了数字和.
    obj.value = obj.value.replace(/[^\d]/g, "");
    //必须保证第一个为数字而不是.
    obj.value = obj.value.replace(/^\./g, "");
    //保证只有出现一个.而没有多个.
    obj.value = obj.value.replace(/\.+/g, "");
}
//是否微信打开
function IsWeChat() {
    var ua = window.navigator.userAgent.toLowerCase();
    if (ua.match(/MicroMessenger/i) == 'micromessenger') {
        return true;
    }
    else {
        return false;
    }
}