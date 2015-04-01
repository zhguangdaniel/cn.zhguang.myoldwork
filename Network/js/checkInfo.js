// JavaScript Document
var errMsg="";

function checkTitle(){
	/*标题不超过100个字符*/
	var p = document.getElementById("infoTitle").value;
	if(p==""){
		errMsg="通知标题不能为空!";
		return false;
	}
	if (p.length > 100) {
		errMsg="通知标题不能超过100个字符";
		return false;
	}
	return true;
}
function checkContent(){
	var p = tinyMCE.activeEditor.getContent();
	if(p==""){
		errMsg="通知内容不能为空!";
		return false;
	}

	return true;
}

function checkArticle(actionPage){
	document.getElementById("errMsg").innerHTML="";
	if(checkTitle()&&checkContent()){
		document.forms.form_article.encoding="application/x-www-form-urlencoded";
		document.forms.form_article.action=actionPage;
		document.forms.form_article.submit();
	}else{
		document.getElementById("errMsg").innerHTML="<font color='#FF0000' size='-1' face='Arial, 宋体'>"+errMsg+"</font>";
	return false;
	}
}

function checkFileUpload(actionPage){
	var file = document.forms.form_article.articleFile.value;
	if(file==""){
		document.getElementById("errMsg").innerHTML="请先选择文件!";
		return false;
	}else {
		var ext= file.substring(file.lastIndexOf('.')+1,file.length).toLowerCase();
		if(ext=="jpg"||ext=="gif"||ext=="bmp"||ext=="png"||ext=="jpeg"||ext=="tif"||ext=="rar"||ext=="zip"||ext=="txt"||ext=="doc"||ext=="xls"||ext=="ppt"||ext=="docx"||ext=="xlsx"||ext=="pptx"||ext=="pdf"){
		document.forms.form_article.encoding="multipart/form-data";
		document.forms.form_article.action=actionPage;
		document.forms.form_article.submit();
		}else{
			var errMsg = "只允许上传 jpg,gif,bmp,png,jpeg,tif,rar,zip,txt,doc,xls,ppt,docx,xlsx,pptx,pdf 等类型的文件";
			document.getElementById("errMsg").innerHTML="<font color='#FF0000' size='-1' face='Arial, 宋体'>"+errMsg+"</font>";
		}
	}
}