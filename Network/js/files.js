// JavaScript Document for user login(/include/login.jsp)
function checkFileUpload(){
	if(document.forms.formUpload.fileUpload.value==""){
		document.getElementById("errMsg").innerHTML="请先选择文件!";
		return false;
	}
	return true;
}
function checkFileName(){
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
function checkFileDescription(){
	var fd = document.getElementById("fileDescription").value;
	if (fd.length > 249) {
		document.getElementById("errMsg").innerHTML="文件描述不能超过250个字符!";
		return false;
	}
	return true;
}
function checkFile(){
	if(checkFileUpload()&&checkFileName()&&checkFileDescription()){
		return true;
	}else{
		return false;
	}
}
function setItemName(){
	var fileName = document.getElementById("fileUpload").value;
	var itemName = fileName.substring(fileName.lastIndexOf('\\')+1,fileName.lastIndexOf('.'));
	document.getElementById("fileName").value = itemName;
}

