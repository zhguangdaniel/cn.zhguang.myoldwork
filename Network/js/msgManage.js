function reloadVCode(){
	var newSrc = "/jsp/vcode/image.jsp?id="+Math.random();
	document.getElementById('vcodeImg').src=newSrc;
}
function checkVCode(){
var vc = document.getElementById("vcode").value
	if(vc==""){
		document.getElementById("errMsg").innerHTML="请填写验证码!";
		return false;
	}
	if (vc.length != 4) {
		document.getElementById("errMsg").innerHTML="验证码长度错误!";
		return false;
	}
	return true;
}
function checkContentLength(){
	var fd = document.getElementById("msgContent").value;
	if (fd.length == 0) {
		document.getElementById("errMsg").innerHTML="留言不能为空!";
		return false;
	}
	if (fd.length > 299) {
		document.getElementById("errMsg").innerHTML="留言不能超过300个字符!";
		return false;
	}
	return true;
}
function checkCreatorName(){
	var fd = document.getElementById("creator").value;
	if (fd.length > 49) {
		document.getElementById("errMsg").innerHTML="您的名字不能超过50个字符!";
		return false;
	}
	return true;
}
function checkReplyLength(replyID){
	var fn = document.getElementById(id).value;
	if (fn.length > 299 || fn.length == 0) {
		alert("回复不能为空，且不能超过300字！");
		return false;
	}
	return true;
}
function clearMsgInfo(){
		document.getElementById("errMsg").innerHTML="";
}
function checkPublishMsg(){
	if(checkCreatorName()&&checkContentLength()&&checkVCode()){
		return true;
	}else{
		return false;
	}
}