function verifyPhone(element){
    var phone = $(element).val();
    var yidongreg = /^(134[012345678]\d{7}|1[34578][012356789]\d{8})$/;
    var dianxinreg = /^1[3578][01379]\d{8}$/;
    var liantongreg = /^1[34578][01256]\d{8}$/;
    if (yidongreg.test(phone) || dianxinreg.test(phone) || liantongreg.test(phone)) {

            return false;
    }
    return true;

}


function verifyEmail(element){
    var email = $(element).val();
    var emailreg = /^[A-Za-z\d]+@([A-Za-z\d]+\.)(com|com\.cn|qq\.com|cn|net|net\.cn)$/;
    if(emailreg.test(email)){

        return false;
    }
    return true;

}

function verifyUsername(element){
    var username = $(element).val();
    var uPattern = /^[a-zA-Z0-9_-]{4,16}$/;
    if(uPattern.test(username)){
        return false;
    }
    return true;

}

////用户名正则，4到16位（字母，数字，下划线，减号）
function verifyUsername(element){
    var username = $(element).val();
    var uPattern = /^[a-zA-Z0-9_-]{4,16}$/;
    if(uPattern.test(username)){
        return false;
    }
    return true;

}

//密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符
function verifyPassword(element){
    var password = $(element).val();
    var pPattern = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/;
    if(pPattern.test(password)){
        return false;
    }
    return true;
}

//身份证号（18位）正则
function  verifyIdNumber(element) {
    var idnumber = $(element).val();
    var cP = /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
    if(cP.test(idnumber)){
        return false;
    }
    return true;

}
function ClearNoNum(obj) {
    obj.value = obj.value.replace(/[^\d.]/g, "");
    obj.value = obj.value.replace(/^\./g, "");
    obj.value = obj.value.replace(/\.{2,}/g, ".");
    obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
}