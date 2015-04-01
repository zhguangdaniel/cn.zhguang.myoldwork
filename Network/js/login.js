// JavaScript Document for user login(/include/login.jsp)
function checkLogin(){
	if(document.forms.form_login.email.value==""){
		document.getElementById("errInfo").innerHTML="用户邮箱不能为空!";
		document.forms.form_login.email.focus();
		return false;
	}
	if(document.forms.form_login.password.value==""){
		document.getElementById("errInfo").innerHTML="密码不能为空!";
		document.forms.form_login.password.focus();	
		return false;	
	}
}