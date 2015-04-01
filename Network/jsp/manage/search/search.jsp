<%@ page contentType="text/html; charset=utf-8" language="java"
	import="news.*,info.*,files.*,java.sql.*,java.util.ArrayList"
	errorPage="/jsp/error/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/manage.css" rel="stylesheet" type="text/css" />
<link href="/css/manageContent.css" rel="stylesheet" type="text/css" />
<jsp:useBean id="news" class="news.NewsBean" scope="page" />
<jsp:useBean id="info" class="info.InfoBean" scope="page" />
<jsp:useBean id="files" class="files.FilesBean" scope="page" />
<!--[if lte IE 6]>
<link href="/css/contentButtonIE6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<title>网工后台管理－搜索结果</title>
</head>
<body>
<%
	boolean isLog = false;
	try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
	if (!isLog) {
		session.setAttribute("isLog", new String("0"));
		session.setAttribute("loginMsg", new String("您还未登录，请先登录！"));
		response.sendRedirect("/jsp/manage/");
	} else {
%>
<!--全部区域-->
<div id="container">
  <!--头部-->
  <div id="header">
    <jsp:include
	page="/jsp/manage/include/header.jsp" flush="true"></jsp:include>
  </div>
  <!--主区，包括菜单区（垂直导航条）和工作区-->
  <div id="mainContent">
    <div id="leftMenu">
      <jsp:include
	page="/jsp/manage/include/leftMenu.jsp" flush="true"></jsp:include>
    </div>
    <div id="rightMain">
      <div id="contentHeader">
        <div style="float:left;">&nbsp;&nbsp;搜索结果：</div>
      </div>
      <%
		request.setCharacterEncoding("utf-8");
		String keyword = request.getParameter("searchKeyword");
		String currentURL = "http://"+request.getServerName()+":"+request.getServerPort()+request.getRequestURI()+"?"+request.getQueryString();
%>
      <div class="bar" style="clear:both;">新闻</div>
      <div class="titleItemsFrame">
        <ul>
          <%
			ArrayList<SingleNews> newsList = news.searchNews(keyword);
			if (newsList.size() == 0) {
	%>
          <li><span>无记录</span></li>
          <%
			} else {
				while (newsList.size() != 0) {
					SingleNews aNews = newsList.remove(0);
					String title = aNews.getTitle();
					String time = aNews.getCreateTime().substring(0, 16);
	%>
          <li><a href="/jsp/manage/newsManage/showNews.jsp?id=<%=aNews.getId()%>&parent=<%=currentURL%>"
		target="_blank" style=" width:75%; float:left;"><%=title%></a><span
		style=" width:20%; float:right;"><%=time%></span></li>
          <%
			}
			}
	%>
        </ul>
      </div>
      <div class="bar" style=" clear:both;">通知</div>
      <div class="titleItemsFrame">
        <ul>
          <%
			ArrayList<Info> infoList = info.searchInfo(keyword);
			if (infoList.size() == 0) {
	%>
          <li><span>无记录</span></li>
          <%
			} else {
				while (infoList.size() != 0) {
					Info i = infoList.remove(0);
					String title = i.getTitle();
					String time = i.getCreateTime().substring(0, 16);
	%>
          <li><a href="/jsp/manage/infoManage/showInfo.jsp?id=<%=i.getId()%>&parent=<%=currentURL%>" target="_blank"
		style=" width:75%; float:left;"><%=title%></a><span
		style=" width:20%; float:right;"><%=time%></span></li>
          <%
			}
			}
	%>
        </ul>
      </div>
      <div class="bar" style="clear:both;">文件下载</div>
      <div class="titleItemsFrame">
        <ul>
          <%
			ArrayList<SingleFile> filesList = files.searchFiles(keyword);
			if (filesList.size() == 0) {
	%>
          <li><span>无记录</span></li>
          <%
			} else {
				while (filesList.size() != 0) {
					SingleFile f = filesList.remove(0);
					String name = f.getName();
					String time = f.getUploadtime().substring(0, 16);
	%>
          <li><a href="/jsp/files/download.jsp?name=<%=name%>&id=<%=f.getId() %>&storeType=0" target="_blank" style=" width:75%; float:left;"><%=name%></a><span
		style=" width:20%; float:right;"><%=time%></span></li>
          <%
			}
			}
	%>
        </ul>
      </div>
    </div>
  </div>
  <div id="bottom">
    <jsp:include
	page="/jsp/manage/include/bottom.jsp" flush="true"></jsp:include>
  </div>
</div>
<%
}
%>
</body>
</html>
