// JavaScript Document
function checkText(id){
	var fn = document.getElementById(id).value;
	if (fn.length > 50 || fn.length == 0) {
		alert("链接的名称不能为空，且不能超过50个字符!");
		return false;
	}
	return true;
}
function checkLink(id){
	var fn = document.getElementById(id).value;
	if (fn.length > 250 || fn.length == 0) {
		alert("链接地址不能为空，且不能超过250个字符!");
		return false;
	}
	return true;
}
function check(textID,linkID){
	if(checkText(textID)&&checkLink(linkID)){
		return true;
	}else{
		return false;
	}
}