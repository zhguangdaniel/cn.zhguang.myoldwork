// JavaScript Document
function checkNewsTitle(){
	if(document.forms.formUpload.fileUpload.value==""){
		document.getElementById("errMsg").innerHTML="请先选择文件!";
		return false;
	}
	return true;
}
function checkNewsContent(){
	var fn = document.getElementById("fileName").value;
	if(fn==""){
		document.getElementById("errMsg").innerHTML="请输入文件名!";
		return false;
	}
	if (fn.length > 99) {
		document.getElementById("errMsg").innerHTML="文件名不能超过100个字符!";
		return false;
	}
	return true;
}
function checkName(){
	var fd = document.getElementById("fileDescription").value;
	if (fd.length > 249) {
		document.getElementById("errMsg").innerHTML="文件描述不能超过250个字符!";
		return false;
	}
	return true;
}
function checkNews(){
	if(checkNewsTitle()&&checkNewsContent()&&checkName()){
		return true;
	}else{
		return false;
	}
}