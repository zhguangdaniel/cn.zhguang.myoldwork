// JavaScript Document for user regist(/user/register.jsp)

var errInfo="";
function reloadVCode(){
	var newSrc = "/jsp/vcode/image.jsp?id="+Math.random();
	document.getElementById('vcodeImg').src=newSrc;
}

function checkEmail(){
	var e = document.getElementById("email").value;	
	if(e ==""){
		errInfo="请填写电子邮件!";
		return false;
	}
	
	var re2 = /[ａ-ｚＡ-Ｚ０-９！＠＃￥％＾＆＊（）＿＋｛｝［］｜：＂＇；．，／？＜＞｀～　]/;
	if (re2.test(e)) {
		errInfo="邮箱地址不能用全角字符";
		return false;
	}else{
		var re = new RegExp("^[0-9a-zA-Z\_]+([\.]{1}[0-9a-zA-Z\_\-]+)*@([0-9a-zA-Z\_\-]+[\.]{1})+[0-9a-zA-Z\_\-]+$");
		if(!re.test(e)){
			errInfo="邮箱地址格式不正确";
			return false;
		}
	}
	return true;
}

function checkName(){
	/*name用户名为不超过2-24个字符的字符串，可以是中文，英文，数字，_，-*/
	var n = document.getElementById("name").value;
	if(n==""){
		errInfo="请填写用户名!";
		return false;
	}
	var re2 = /[ａ-ｚＡ-Ｚ０-９！＠＃￥％＾＆＊（）＿＋｛｝［］｜：＂＇；．，／？＜＞｀～　]/;
	if (re2.test(n)) {
		errInfo="用户名不能用全角字符";
		return false;
	}else{
		var re = new RegExp("^[a-zA-Z0-9\u4E00-\u9FA5\uF900-\uFA2D]+[a-zA-Z0-9 \u4E00-\u9FA5\uF900-\uFA2D\-\_]*$");
		if (re.test(n)) {
			if (n.length < 2 || n.length > 24) {			
				errInfo="用户名长度需要在2-24位之间，请重新输入";
				return false;
			}
		}else{
				errInfo="用户名只能是中文，英文，数字，_，- ,空格等字符,且不能以空格开头";
				return false;
		}
	}
	return true;
}
function checkOldPwd(){
	/*password密码只能是4-20位的ASCII码*/
	var p = document.getElementById("oldPwd").value;
	if(p==""){
		errInfo="旧密码不能为空!";
		return false;
	}
	if (p.length < 4 || p.length > 20) {
		errInfo="旧密码长度需要在4-20位之间，请重新输入";
		return false;
	}else{
        for (var i = 0; i < p.length; i++) {
        	var temp = p.charCodeAt(i);
        	if(temp<32 || temp>126) {
			errInfo= "旧密码只能是ASCII字符，请重新输入";
			return false;
			}
    	}
	}
	return true;
}
function checkPassword(){
	/*password密码只能是4-20位的ASCII码*/
	var p = document.getElementById("password").value;
	if(p==""){
		errInfo="密码不能为空!";
		return false;
	}
	if (p.length < 4 || p.length > 20) {
		errInfo="密码长度需要在4-20位之间，请重新输入";
		return false;
	}else{
        for (var i = 0; i < p.length; i++) {
        	var temp = p.charCodeAt(i);
        	if(temp<32 || temp>126) {
			errInfo= "密码只能是ASCII字符，请重新输入";
			return false;
			}
    	}
	}
	return true;
}

function checkPassword2(){
	/*password密码只能是4-20位的ASCII码*/
	var p2 = document.getElementById("password2").value;
	if(p2==""){
		errInfo="确认密码不能为空!";
		return false;
	}
	var p = document.getElementById("password").value;
	if (p2!=p) {
			errInfo= "两次输入的密码必须相同";
			return false;
	}
	return true;
}

function checkPasswordQuestion(){
	/*密码提示问题需要在2-30位之间，由用户任意输入*/
	var pq = document.getElementById("passwordQuestion").value;
	if(pq==""){
		return true;
	}
	if (pq.length < 2 || pq.length > 30) {
		errInfo="密码提示问题需要在2-30位之间，请重新输入";
		return false;
	}
	return true;
}
function checkPasswordAnswer(){
	/*密码提示问题需要在2-30位之间，由用户任意输入*/
	var pa = document.getElementById("passwordAnswer").value;
	
	if(pa==""){
		return true;
	} 
	if (pa.length < 2 || pa.length > 30) {
		errInfo="提示问题的回答需要在2-30位之间，请重新输入";
		return false;
	}
	return true;
}
function checkVCode(){
var vc = document.getElementById("vcode").value
	if(vc==""){
		errInfo="请填写验证码!";
		return false;
	}
	if (vc.length != 4) {
		errInfo="验证码长度错误!";
		return false;
	}
	return true;
}
function checkRegUserInfo(){
	/*身份确认信息需要在2-30位之间，由用户任意输入*/
	var ui = document.getElementById("regUserInfo").value;
	
	if(ui==""){
		return true;
	} 
	if (ui.length > 100) {
		errInfo="身份确认信息请不能100字，请重新输入";
		return false;
	}
	return true;
}
function checkRegist(){
	document.getElementById("regErrInfo").innerHTML="";
	if(checkEmail()&&checkName()&&checkPassword()&&checkPassword2()&&checkPasswordQuestion()&&checkPasswordAnswer()&&checkRegUserInfo()&&checkVCode()){
		return true;
	}else{
		document.getElementById("regErrInfo").innerHTML=errInfo;
	return false;
	}
}
//注册onFocus事件
function onRegFocus(id,tips_id){
	document.getElementById("regErrInfo").innerHTML="";
		var value = document.getElementById(id).value;
		var tipsInfo="";
			if(id == 'email'){
				//邮箱
 			tipsInfo="邮件地址是用户登录的唯一ID，请保证格式正确，并且不含全角字符";
			}else if(id == 'name'){
				//用户名
				tipsInfo="用户名由2-24位中文，英文，数字，_，- ,空格等字符组成,且不能以空格开头";
			}else if(id == 'password'){
				//密码
				tipsInfo="密码长度是4-20位之间的ASCII字符，且字母区分大小写";
			}else if(id == 'password2'){
				//重复密码
				tipsInfo="请确认密码";
			}else if(id == 'passwordQuestion'){
				//提示问题
				tipsInfo="密码提示问题需要在2-30位之间";
			}else if(id == 'passwordAnswer'){
				//问题答案
				tipsInfo="提示问题的回答需要在2-30位之间";
			}else if(id == 'regUserInfo'){
				//验证码
				tipsInfo="真实姓名、专业、学号、申请原因等，在管理员审核并赋予您权限时，这些资料将便于确认您的身份，不超过100字";
			}else if(id == 'vcode'){
				//验证码
				tipsInfo="请输入图片中的四位数字";
			}
			document.getElementById(tips_id).innerHTML="<font color='#999999' size='-1' face='Arial, 宋体'>"+tipsInfo+"</font>";

		
	}
//注册onblur事件
function onRegBlur(id,tips_id){
		document.getElementById("regErrInfo").innerHTML="";
		var value = document.getElementById(id).value;
		errInfo = "";
		if(value !=""){
		if(id == 'email'){
			//邮箱
				checkEmail();
		}else if(id == 'name'){
			//用户名
				checkName();
		}else if(id == 'password'){
			//密码
				checkPassword();			
		}else if(id == 'password2'){
			//重复密码
			checkPassword2();
		}else if(id == 'passwordQuestion'){
				//提示问题
				checkPasswordQuestion();	
		}else if(id == 'passwordAnswer'){
				//问题答案
				checkPasswordAnswer();	
		}else if(id == 'regUserInfo'){
			//身份确认
			checkRegUserInfo();
		}else if(id == 'vcode'){
			//验证码
			checkVCode();
		}
		}
		document.getElementById(tips_id).innerHTML="<font color='#FF0000' size='-1' face='Arial, 宋体'>"+errInfo+"</font>";	
	}
	
//编辑用户信息onFocus事件
function onEditFocus(id,tips_id){
	document.getElementById("editErrInfo").innerHTML="";
		var value = document.getElementById(id).value;
		var tipsInfo="";
			if(id == 'name'){
				//用户名
				tipsInfo="用户名由2-24位中文，英文，数字，_，- ,空格等字符组成,且不能以空格开头";
			}else if(id == 'passwordQuestion'){
				//提示问题
				tipsInfo="密码提示问题需要在2-30位之间";
			}else if(id == 'passwordAnswer'){
				//问题答案
				tipsInfo="提示问题的回答需要在2-30位之间";
			}else if(id == 'regUserInfo'){
				//验证码
				tipsInfo="真实姓名、专业、学号、申请原因等，在管理员审核并赋予您权限时，这些资料将便于确认您的身份，不超过100字";
			}
			document.getElementById(tips_id).innerHTML="<font color='#999999' size='-1' face='Arial, 宋体'>"+tipsInfo+"</font>";

		
	}
//编辑用户信息onblur事件
function onEditBlur(id,tips_id){
		document.getElementById("editErrInfo").innerHTML="";
		var value = document.getElementById(id).value;
		errInfo = "";
		if(value !=""){
			if(id == 'name'){
				//用户名
				checkName();
			}else if(id == 'passwordQuestion'){
				//提示问题
				checkPasswordQuestion();	
			}else if(id == 'passwordAnswer'){
				//问题答案
				checkPasswordAnswer();	
			}else if(id == 'regUserInfo'){
				//身份确认
				checkRegUserInfo();
			}
		}
		document.getElementById(tips_id).innerHTML="<font color='#FF0000' size='-1' face='Arial, 宋体'>"+errInfo+"</font>";	
	}
function checkEditUser(){
	document.getElementById("editErrInfo").innerHTML="";
	if(checkName()&&checkPasswordQuestion()&&checkPasswordAnswer()&&checkRegUserInfo()){
		return true;
	}else{
		document.getElementById("editErrInfo").innerHTML=errInfo;
		return false;
	}
}
function checkEditPwd(){
	document.getElementById("editPwdInfo").innerHTML="";
	if(checkOldPwd()&&checkPassword()&&checkPassword2()){
		return true;
	}else{
		document.getElementById("editPwdInfo").innerHTML=errInfo;
	return false;
	}
}
//修改密码onFocus事件
function onEditPwdFocus(id,tips_id){
	document.getElementById("editPwdInfo").innerHTML="";
		var value = document.getElementById(id).value;
		var tipsInfo="";
			if(id == 'oldPwd'){
				//用户名
				tipsInfo="旧密码长度是4-20位之间的ASCII字符，且字母区分大小写头";
			}else if(id == 'password'){
				//密码
				tipsInfo="新密码长度是4-20位之间的ASCII字符，且字母区分大小写";
			}else if(id == 'password2'){
				//重复密码
				tipsInfo="请确认密码";
			}
			document.getElementById(tips_id).innerHTML="<font color='#999999' size='-1' face='Arial, 宋体'>"+tipsInfo+"</font>";

		
	}
//修改密码onblur事件
function onEditPwdBlur(id,tips_id){
		document.getElementById("editPwdInfo").innerHTML="";
		var value = document.getElementById(id).value;
		errInfo = "";
		if(value !=""){
			if(id == 'oldPwd'){
				//用户名
				checkOldPwd();
			}else if(id == 'password'){
				//密码
				checkPassword();			
			}else if(id == 'password2'){
				//重复密码
				checkPassword2();
			}
		}
		document.getElementById(tips_id).innerHTML="<font color='#FF0000' size='-1' face='Arial, 宋体'>"+errInfo+"</font>";	
	}
//添加用户onFocus事件
function onAddFocus(id,tips_id){
	document.getElementById("addErrInfo").innerHTML="";
		var value = document.getElementById(id).value;
		var tipsInfo="";
			if(id == 'email'){
				//邮箱
 			tipsInfo="邮件地址是用户登录的唯一ID，请保证格式正确，并且不含全角字符";
			}else if(id == 'name'){
				//用户名
				tipsInfo="用户名由2-24位中文，英文，数字，_，- ,空格等字符组成,且不能以空格开头";
			}else if(id == 'password'){
				//密码
				tipsInfo="密码长度是4-20位之间的ASCII字符，且字母区分大小写";
			}else if(id == 'password2'){
				//重复密码
				tipsInfo="请确认密码";
			}
			document.getElementById(tips_id).innerHTML="<font color='#999999' size='-1' face='Arial, 宋体'>"+tipsInfo+"</font>";	
	}
	//添加用户onblur事件
function onAddBlur(id,tips_id){
	document.getElementById("addErrInfo").innerHTML="";
	var value = document.getElementById(id).value;
	errInfo = "";
	if(value !=""){
		if(id == 'email'){
			//邮箱
				checkEmail();
		}else if(id == 'name'){
			//用户名
				checkName();
		}else if(id == 'password'){
			//密码
				checkPassword();			
		}else if(id == 'password2'){
			//重复密码
			checkPassword2();
		}
	}
	document.getElementById(tips_id).innerHTML="<font color='#FF0000' size='-1' face='Arial, 宋体'>"+errInfo+"</font>";	
}

function checkAddUser(){
	document.getElementById("addErrInfo").innerHTML="";
	if(checkEmail()&&checkName()&&checkPassword()&&checkPassword2()){
		return true;
	}else{
		document.getElementById("addErrInfo").innerHTML=errInfo;
	return false;
	}
}
	