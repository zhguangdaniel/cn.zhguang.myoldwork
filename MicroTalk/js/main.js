// JavaScript Document
function goWeb()
    {
        if(document.getElementById("fLinks").value!='#')
        {
            location.href=document.getElementById("fLinks").value;
        }
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
function clearSearchText(){
	if(document.getElementById("searchKeyword").value=='Search...')
    {
        document.getElementById("searchKeyword").value='';
    }
}
function doSearch(actionPage){
	if(document.getElementById("searchText").value=='Search...'||document.getElementById("searchText").value=='')
	{
        return false;
	}
	document.forms.form_search.encoding="application/x-www-form-urlencoded";//"multipart/form-data";
	document.forms.form_search.action=actionPage;
	document.forms.form_search.submit();
}
function showMsgBlock(showID){
	if(showID == 'hotMsg'){
		document.getElementById('hotMsgA').style.backgroundImage="url(/images/nav5.png)";
		document.getElementById('newMsgA').style.backgroundImage="url(/images/nav4.png)";
		document.getElementById('hotMsg').style.display = "block";
		document.getElementById('newMsg').style.display = "none";
	}else	if(showID == 'newMsg'){
		document.getElementById('newMsgA').style.backgroundImage="url(/images/nav5.png)";
		document.getElementById('hotMsgA').style.backgroundImage="url(/images/nav4.png)";
		document.getElementById('hotMsg').style.display = "none";
		document.getElementById('newMsg').style.display = "block";
	}
		   //document.getElementById('editUserInfo').style.display != "block"){
		//document.getElementById('showUserInfo').style.display = "none";
		////document.getElementById('editPassword').style.display = "none";
		//document.getElementById('editUserInfo').style.display = "block";
}

function time(){
    //获得显示时间的div
   tFrame = document.getElementById('showTime');
   var now=new Date()
    //替换timeFrame内容 
   tFrame.innerHTML = "MicroTalk欢迎你，现在是"+now.getFullYear()
    +"年"+(now.getMonth()+1)+"月"+now.getDate()
    +"日 "+now.getHours()+":"+now.getMinutes()
    +":"+now.getSeconds();
    //等待一秒钟后调用time方法，由于settimeout在time方法内，所以可以无限调用
   setTimeout(time,1000);
}
