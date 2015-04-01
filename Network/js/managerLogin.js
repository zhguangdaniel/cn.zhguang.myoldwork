// JavaScript Document for user login(/include/login.jsp)
var loginInfo="";

function checkPassword(){
	/*password密码只能是4-20位的ASCII码*/
	var p = document.getElementById("password").value;
	if(p==""){
		loginInfo="请输入管理员密码!";
		return false;
	}
	if (p.length < 4 || p.length > 20) {
		loginInfo="密码长度需要在4-20位之间，请重新输入";
		return false;
	}else{
        for (var i = 0; i < p.length; i++) {
        	var temp = p.charCodeAt(i);
        	if(temp<32 || temp>126) {
				loginInfo= "密码只能是ASCII字符，请重新输入";
				return false;
			}
    	}
	}
	return true;
}

function checkEmail(){
	var e = document.getElementById("email").value;	
	if(e ==""){
		loginInfo="请填写电子邮件!";
		return false;
	}
	
	var re2 = /[ａ-ｚＡ-Ｚ０-９！＠＃￥％＾＆＊（）＿＋｛｝［］｜：＂＇；．，／？＜＞｀～　]/;
	if (re2.test(e)) {
		loginInfo="邮箱地址不能用全角字符";
		return false;
	}else{
		var re = new RegExp("^[0-9a-zA-Z\_]+([\.]{1}[0-9a-zA-Z\_\-]+)*@([0-9a-zA-Z\_\-]+[\.]{1})+[0-9a-zA-Z\_\-]+$");
		if(!re.test(e)){
			loginInfo="邮箱地址格式不正确";
			return false;
		}
	}
	return true;
}

function checkLogin(){
	document.getElementById("loginInfo").innerHTML="";
	if(checkPassword()&&checkEmail()){
		return true;
	}else{
		document.getElementById("loginInfo").innerHTML="<font color='#FF0000' size='-1' face='Arial, 宋体'>"+loginInfo+"</font>";
		document.getElementById("password").focus();
	return false;
	}
}