// JavaScript Document
function onDelete() {
   return confirm("确定要删除吗？");
}
function onClear() {
   return confirm("确定要清空吗？");
} 


function showHide(showID){
	if(showID != null){	
		if(document.getElementById(showID).style.display != "block"){		
			document.getElementById(showID).style.display = "block";
		}else{
			document.getElementById(showID).style.display = "none";
		}
	}
}
function showEditUserInfo(){
	if(document.getElementById('editUserInfo').style.display != "block"){
		document.getElementById('showUserInfo').style.display = "none";
		document.getElementById('editPassword').style.display = "none";
		document.getElementById('editUserInfo').style.display = "block";
	}else{
		document.getElementById('editPassword').style.display = "none";
		document.getElementById('editUserInfo').style.display = "none";
		document.getElementById('showUserInfo').style.display = "block";
	}
}
function showEditPwd(){
	if(document.getElementById('editPassword').style.display != "block"){
		document.getElementById('showUserInfo').style.display = "none";
		document.getElementById('editUserInfo').style.display = "none";
		document.getElementById('editPassword').style.display = "block";
	}else{
		document.getElementById('editPassword').style.display = "none";
		document.getElementById('editUserInfo').style.display = "none";
		document.getElementById('showUserInfo').style.display = "block";
	}
}
function checkAfficheLength(id){
	var fn = document.getElementById(id).value;
	if (fn.length > 499) {
		alert("首页公告不能超过300字！");
		return false;
	}
	return true;
}