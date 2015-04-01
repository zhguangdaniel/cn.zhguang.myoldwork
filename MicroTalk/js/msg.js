// JavaScript Document
function checkMsg(){
	if(document.forms.form_msg.msgContent.value==""){
		alert("消息不能为空!");
		document.forms.form_msg.msgContent.focus();	
		return false;	
	}
	return true;
}