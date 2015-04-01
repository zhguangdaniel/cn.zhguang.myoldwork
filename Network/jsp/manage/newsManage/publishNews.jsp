<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,database.*,user.*" errorPage="/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/manage.css" rel="stylesheet" type="text/css" />
<link href="/css/manageContent.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/checkNews.js"></script>
<!-- TinyMCE -->
<script type="text/javascript" src="/js/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript">
	// skin (silver)
	tinyMCE.init({
		// General options
		mode : "exact",
		elements : "newsContent",
		theme : "advanced",
		skin : "o2k7",
		language :"zh",
		//skin_variant : "silver",
		plugins : "safari,emotions,insertdatetime,noneditable,inlinepopups",

		// Theme options
		theme_advanced_buttons1 : "bold,italic,underline,|,justifyleft,justifycenter,justifyright,formatselect,fontselect,fontsizeselect,|,forecolor,backcolor,|,bullist,numlist,|,undo,redo,|,link,unlink,anchor,|,charmap,emotions,image,|,code",
		theme_advanced_buttons2 : "",
		theme_advanced_buttons3 :"", 
		theme_advanced_toolbar_location : "top",
		theme_advanced_toolbar_align : "left",
		theme_advanced_layout_manager : "SimpleLayout",
		theme_advanced_statusbar_location : "none",
		theme_advanced_resizing : true,


		// Example content CSS (should be your site CSS)
		content_css : "css/content.css",

		// Drop lists for link/image dialogs
		external_link_list_url : "lists/link_list.js",
		external_image_list_url : "lists/image_list.js"
	});
	</script>
<!-- /TinyMCE -->
<title>网工后台管理－新闻发布</title>
</head>
<body>
<%
	boolean isLog = false;
		try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
	if (!isLog) {
		session.setAttribute("isLog",new String("0"));
		session.setAttribute("loginMsg", new String("您还未登录，请先登录！"));
		response.sendRedirect("/jsp/manage/");
	}else if(!User.checkHaveAuthority(((String)session.getAttribute("userAuthority")),User.publishNews)){
		out.println("<center>你没有打开该页面的权限...</center>");
	}else{
		String errMsg = null;
		try {
			errMsg = (String) session.getAttribute("errMsg");
		} catch (Exception e) {
		}
		if (errMsg == null) {
			errMsg = "";
		}
		String title ="";
		try {
			title = (String) session.getAttribute("title");
		} catch (Exception e) {
		}
		if (title == null) {
			title = "";
		}
		String newsContent ="";
		try {
			newsContent = (String) session.getAttribute("newsContent");
		} catch (Exception e) {
		}
		if (newsContent == null) {
			newsContent = "";
		}
		String publisher = "";
		try {
			publisher = (String) session.getAttribute("publisher");
		} catch (Exception e) {
		}
		if (publisher == null) {
			publisher = "";
		}
%>
<!--全部区域-->
<div id="container">
    <!--头部-->
    <div id="header">
        <jsp:include page="/jsp/manage/include/header.jsp" flush="true"></jsp:include>
    </div>
    <!--主区，包括菜单区（垂直导航条）和工作区-->
    <div id="mainContent">
        <div id="leftMenu">
            <jsp:include page="/jsp/manage/include/leftMenu.jsp" flush="true"></jsp:include>
        </div>
        <div id="rightMain" style="overflow:auto;">
            <div id="contentHeader">&nbsp;&nbsp;<a href="/jsp/manage/" class="normalLink">后台管理</a> &nbsp;&gt;&nbsp;<a href="/jsp/manage/newsManage/news.jsp?page=1" class="normalLink">新闻管理</a> &nbsp;&gt;&nbsp;新闻发布 
            </div>
            <form name="form_article" method="post" target="_self" style="margin:0 auto;margin-left:10px; margin-right:10px;">
            <div id="titleFrame">标题：
                <input id="newsTitle" name="newsTitle" type="text" value="<%=title%>" style="width:480px; height:16px;"/>
            </div>
            <textarea id="newsContent" name="newsContent" style="width: 100%; height:330px;">
            <%=newsContent%></textarea>
            <div id="articleBottom">
                插入 本地图片/文件链接：
                <input type="file" name="articleFile" id="articleFile" size="20" />
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="button" name="saveFile" value="上传" onclick="return checkFileUpload('/jsp/manage/newsManage/saveNewsFile.jsp?isModify=0')" /> 
        	</div>
        <div id="articleBottom">
            <input type="button" name="publish" value="发布" onclick="return checkArticle('/jsp/manage/newsManage/saveNews.jsp?isModify=0')" />
            <input type="reset" name="reset" value="重置" />
            <span class="errMsgFrame" style="margin-left:20px;" id="errMsg"></span> 
         </div>
        </form>
    	</div>
</div>
<div id="bottom">
    <jsp:include page="/jsp/manage/include/bottom.jsp" flush="true"></jsp:include>
</div>
</div>
<script language="javascript">
<!--
	document.getElementById("errMsg").innerHTML="<font color='#FF0000' size='-1' face='Arial, 宋体'>"+<%=("\""+errMsg+"\"")%>+"</font>";
//-->
</script>
<%	
	errMsg = "";
	session.setAttribute("errMsg",new String(""));
	session.setAttribute("title", new String(""));
	session.setAttribute("newsContent",new String(""));
	session.setAttribute("publisher", new String(""));
	}
%>
</body>
</html>
