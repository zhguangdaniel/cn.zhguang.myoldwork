// JavaScript Document
function onDelete() {
   return confirm("确定要删除这个用户吗？");
} 
var oldAuNP=new Array();
function checkNotPass(){

	var checkBox = document.getElementsByName('userAuthority');
	var n = checkBox.length;

	if(document.getElementById('notPass').checked){
		document.getElementById('authorityInfo').innerHTML="<font color='#FF0000'>该用户审核不通过，将从数据库中删除，点击“确认审核”进行确定</font>";
		for(var i =0; i<n;i++){
			if(checkBox.item(i).disabled){
				oldAuNP[i] = true;
			}else{
				oldAuNP[i] = false;
			}
		}
		for(var i =0; i<n;i++){
			checkBox.item(i).disabled=true;
		}
	}else{
		document.getElementById('authorityInfo').innerHTML="";
		for(var i =0; i<n;i++){
			checkBox.item(i).disabled=oldAuNP[i];
		}
	}
}
function checkSuperAdmin(infoAreaID){
	var checkBox = document.getElementsByName('userAuthority');
	var n = checkBox.length;

	if(document.getElementById('setSuperAdmin').checked){
		document.getElementById(infoAreaID).innerHTML="<font color='#FF0000'>超级管理员有用户管理和权限管理的权力</font>";
		for(var i =15; i<n;i++){
			checkBox.item(i).disabled = false;
			checkBox.item(i).checked = true;
		}
	}else{
		document.getElementById(infoAreaID).innerHTML="<font color='#FF0000'>不勾选可以取消该用户超级管理员的身份</font>";
		for(var i =15; i<n;i++){
			checkBox.item(i).checked = false;
			checkBox.item(i).disabled=true;
			
		}
	}
}
function checkAuthority(type){
	if(type ==1){
		if(document.getElementById('notPass').checked){
			return confirm("该用户审核不通过，将从数据库中删除，确定吗？");
		}else{
			var checkBox = document.getElementsByName('userAuthority');
			var n = checkBox.length;
			for(var i =0; i<n;i++){
				if(checkBox.item(i).checked){
					return true;
				}
			}
			return confirm("您确定不为该用户赋予任何权限吗？");
		}
	}else{
		var checkBox = document.getElementsByName('userAuthority');
		var n = checkBox.length;
		for(var i =0; i<n;i++){
			if(checkBox.item(i).checked){
				return true;
			}
		}
		return confirm("您确定不为该用户赋予任何权限吗？");
	}
}
function checkAddUserAuthority(){
	var checkBox = document.getElementsByName('userAuthority');
	var n = checkBox.length;
	for(var i =0; i<n;i++){
		if(checkBox.item(i).checked){
			return true;
		}
	}
	return confirm("您确定不为该用户赋予任何权限吗？");
}