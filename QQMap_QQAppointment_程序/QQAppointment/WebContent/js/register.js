// JavaScript Document for user regist(/user/register.jsp)

var errInfo = "";

function reloadVCode(){
    $J('#vcodeImg').attr("src","/vcode?tamp=" + (new Date()).valueOf());
}

function checkUserName(){
    /* name用户名为不超过2-24个字符的字符串，可以是中文，英文，数字，_，- */
    var n = v("userName");
    if (n == "") {
        errInfo = "请填写用户名!";
        return false;
    }
    var re2 = /[ａ-ｚＡ-Ｚ０-９！＠＃￥％＾＆＊（）＿＋｛｝［］｜：＂＇；．，／？＜＞｀～　]/;
    if (re2.test(n)) {
        errInfo = "用户名不能用全角字符";
        return false;
    }
    else {
        var re = new RegExp("^[a-zA-Z0-9\u4E00-\u9FA5\uF900-\uFA2D]+[a-zA-Z0-9 \u4E00-\u9FA5\uF900-\uFA2D\-\_]*$");
        if (re.test(n)) {
            if (n.length < 2 || n.length > 20) {
                errInfo = "用户名长度需要在2-20位之间，请重新输入";
                return false;
            }
        }
        else {
            errInfo = "用户名只能是中文，英文，数字，_，- ,空格等字符,且不能以空格开头";
            return false;
        }
    }
    return true;
}

function checkNickName(){
    var n = v("nickName");
    if (n.length == 0) {
        return true;
    }
    var re = new RegExp("^[a-zA-Z0-9\u4E00-\u9FA5\uF900-\uFA2D]+[a-zA-Z0-9 \u4E00-\u9FA5\uF900-\uFA2D\-\_]*$");
    if (re.test(n)) {
        if (n.length < 1 || n.length > 20) {
            errInfo = "昵称长度需要在1-20位之间，请重新输入";
            return false;
        }
    }
    else {
        errInfo = "昵称只能是中文，英文，数字，_，- ,空格等字符,且不能以空格开头";
        return false;
    }
    return true;
}

function checkPassword(){
    /* password密码只能是4-20位的ASCII码 */
    var p = v("password");
    if (p == "") {
        errInfo = "密码不能为空!";
        return false;
    }
    if (p.length < 4 || p.length > 20) {
        errInfo = "密码长度需要在4-20位之间，请重新输入";
        return false;
    }
    else {
        for (var i = 0; i < p.length; i++) {
            var temp = p.charCodeAt(i);
            if (temp < 32 || temp > 126) {
                errInfo = "密码只能是ASCII字符，请重新输入";
                return false;
            }
        }
    }
    return true;
}

function checkPassword2(){
    /* password密码只能是4-20位的ASCII码 */
    var p2 = v("password2");
    if (p2 == "") {
        errInfo = "确认密码不能为空!";
        return false;
    }
    var p = v("password");
    if (p2 != p) {
        errInfo = "两次输入的密码必须相同";
        return false;
    }
    return true;
}

function checkUserKeyWords(){
    /*用户标签*/
    var ui = v("userKeyWords");
    
    if (ui == "") {
        return true;
    }
    if (ui.length > 250) {
        errInfo = "用户标签信息请不能超过255字";
        return false;
    }
    return true;
}

function checkVCode(){
    var vc = v("vcode");
    if (vc == "") {
        errInfo = "请填写验证码!";
        return false;
    }
    if (vc.length != 4) {
        errInfo = "验证码长度错误!";
        return false;
    }
    return true;
}

function checkRegist(){
    e("regErrInfo").innerHTML = "";
    if (checkUserName() && checkNickName() && checkPassword() && checkPassword2() && checkUserKeyWords() && checkVCode()) {
        return true;
    }
    else {
        e("regErrInfo").innerHTML = errInfo;
        return false;
    }
    
}

// 注册onFocus事件
function onRegFocus(id, tips_id){
    e("regErrInfo").innerHTML = "";
    var value = v(id);
    var tipsInfo = "";
    switch (id) {
        case 'userName':// 用户名     
            tipsInfo = "用户名是用户登录的唯一ID,推荐使用QQ号";
            break;
        case 'nickName': // 昵称          
            tipsInfo = "输入你的昵称";
            break;
        case 'password':// 密码           
            tipsInfo = "请输入密码";
            break;
        case 'password2':// 重复密码            
            tipsInfo = "请再次密码";
            break;
        case 'userKeyWords'://标签
            tipsInfo = "用户标签是用户对自我特征和爱好的关键词描述，以空格分隔，如'音乐 电影'";
            break;
        case 'vcode':// 验证码
            tipsInfo = "请输入图片中的四位数字";
            break;
        default:
            tipsInfo = "";
            break;
    }
    e(tips_id).innerHTML = "<font color='#999999' size='-1' face='Arial, 宋体'>" + tipsInfo + "</font>";
    
    
}

// 注册onblur事件
function onRegBlur(id, tips_id){
    e("regErrInfo").innerHTML = "";
    var value = v(id);
    errInfo = "";
    if (value != "") {
        switch (id) {
            case 'userName':// 用户名
                checkUserName();
                break;
            case 'nickName':// 邮箱
                checkNickName();
                break;
            case 'password':// 密码                
                checkPassword();
                break;
            case 'password2':// 重复密码               
                checkPassword2();
                break;
            case 'userKeyWords'://标签
                checkUserKeyWords();
                break;
            case 'vcode':// 验证码                
                checkVCode();
                break;
            default:
                break;
        }
    }
    e(tips_id).innerHTML = "<font color='#FF0000' size='-1' face='Arial, 宋体'>" + errInfo + "</font>";
}



function checkUploadUserIcon(){
    var file = v('userIcon');
    if (file == "") {
        return true;
    }
    var ext = file.substring(file.lastIndexOf('.') + 1, file.length).toLowerCase();
    if (ext == "jpg" || ext == "gif" || ext == "bmp" || ext == "png" || ext == "jpeg") {
    }
    else {
        alert("只允许上传 jpg,gif,bmp,png,jpeg 等图片文件");
        return false;
    }
    return ajaxUserIconUpload();
}
