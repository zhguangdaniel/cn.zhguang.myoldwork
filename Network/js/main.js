// JavaScript Document主页控制
function goWeb()
    {
        if(document.getElementById("fLinks").value!='#')
        {
            location.href=document.getElementById("fLinks").value;
        }
    }
function checkSearch()
	{
		if(document.getElementById("searchText").value=='Search...'||document.getElementById("searchText").value=='')
        {
            return false;
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