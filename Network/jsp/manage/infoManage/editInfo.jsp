<%@ page contentType="text/html; charset=utf-8" language="java" import="info.*,user.*" errorPage="/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/manage.css" rel="stylesheet" type="text/css" />
<link href="/css/manageContent.css" rel="stylesheet" type="text/css" />
<!--[if lte IE 6]>
<link href="/css/contentButtonIE6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<jsp:useBean id="infoBean" class="info.InfoBean" scope="page"/>
<script type="text/javascript" src="/js/checkInfo.js"></script>
<!-- TinyMCE -->
<script type="text/javascript" src="/js/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript">
	// skin (silver)
	tinyMCE.init({
		// General options
		mode : "exact",
		elements : "infoContent",
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
<title>网工后台管理－修改通知</title>
</head>
<body>
<%
	boolean isLog = false;
	int id = Integer.parseInt(request.getParameter("id"));
	String creater = infoBean.getInfoCreater(id);
		try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
	if (!isLog) {
		session.setAttribute("isLog",new String("0"));
		session.setAttribute("loginMsg", new String("您还未登录，请先登录！"));
		response.sendRedirect("/jsp/manage/");
	}else if(!User.checkHaveAuthority(((String)session.getAttribute("userAuthority")),User.editInfo)&&!((String)session.getAttribute("userName")).equals(creater)){
		out.println("<center>你没有打开该页面的权限...</center>");
	} else{
		String errMsg = null;
		try {
			errMsg = (String) session.getAttribute("errMsg");
		} catch (Exception e) {
		}
		if (errMsg == null) {
			errMsg = "";
		}

		boolean isUpload = false;
		try {
			isUpload = ((String) session.getAttribute("isUpload")).equals("1");//获得用户是否已经登录的消息
		} catch (Exception e) {
		}
		String title ="";
		String infoContent ="";
		String publisher = "";
		Info info = infoBean.getInfo(id);
		String parentURL = request.getParameter("parent");
		if (isUpload) {//是上传文件
			try {
				title = (String) session.getAttribute("title");
			} catch (Exception e) {
			}
			if (title == null) {
				title = "";
			}
			try {
				infoContent = (String) session.getAttribute("infoContent");
			} catch (Exception e) {
			}
			if (infoContent == null) {
				infoContent = "";
			}
			try {
				publisher = (String) session.getAttribute("publisher");
			} catch (Exception e) {
			}
			if (publisher == null) {
				publisher = "";
			}
		}else{
			title = info.getTitle();
			infoContent = info.getContent();
			publisher = info.getCreater();
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
            <div id="contentHeader">&nbsp;&nbsp;<a href="/jsp/manage/" class="normalLink">后台管理</a> &nbsp;&gt;&nbsp;<a href="/jsp/manage/infoManage/info.jsp?page=1" class="normalLink">通知管理</a> &nbsp;&gt;&nbsp;修改通知&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="/images/Return.png" width="12" height="12" /><a
                href="<%=parentURL%>" target="_self" class="normalLink" style="color:#069" >返回</a></div>
            <form name="form_article" method="post" style="margin:0 auto;margin-left:10px; margin-right:10px; text-align:left;">
                <div id="titleFrame">标题：
                    <input id="infoTitle" name="infoTitle" type="text" style="width:480px; height:16px;" value="<%=title%>"/>
                </div>
                <div class="modifyArticleFrame">发布者：<%=info.getCreater()%>&nbsp;&nbsp;&nbsp;发布于：<%=info.getCreateTime().substring(0, 16)%></div>
                <textarea id="infoContent" name="infoContent" style="width: 100%; height:310px;"><%=infoContent%></textarea>
                <div id="articleBottom"> 插入 本地图片/文件链接：
                    <input type="file" name="articleFile" id="articleFile" size="20" />
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="button" name="saveFile" value="上传" onclick="return checkFileUpload('/jsp/manage/infoManage/saveInfoFile.jsp?isModify=1&id=<%=id %>&parent=<%=parentURL%>')" />
                </div>
                <div id="articleBottom">
                    <input type="button" name="modify" value="确认修改" onclick="return checkArticle('/jsp/manage/infoManage/saveInfo.jsp?isModify=1&id=<%=id %>&parent=<%=parentURL%>')" />
                    <input type="reset" name="reset" value="重置" />
                    <span class="errMsgFrame" style="margin-left:20px;" id="errMsg"></span> </div>
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
	session.setAttribute("isUpload", new String("0"));
	}
%>
</body>
</html>
