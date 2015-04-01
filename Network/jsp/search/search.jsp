<%@ page contentType="text/html; charset=utf-8" language="java"
	import="news.*,info.*,files.*,java.sql.*,java.util.ArrayList"
	errorPage="/jsp/error/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网工－搜索结果</title>
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<jsp:useBean id="news" class="news.NewsBean" scope="page" />
<jsp:useBean id="info" class="info.InfoBean" scope="page" />
<jsp:useBean id="files" class="files.FilesBean" scope="page" />
</head>
<body>
<!--头部header-->
<div class="header">
  <jsp:include page="/jsp/include/header.jsp"
	flush="true"></jsp:include>
</div>
<!--//header-->
<!--主体容器container-->
<div class="container">
  <!--内容区content，包括菜单和主内容-->
  <div class="content">
    <!--左边内容框leftContentFrame-->
    <div class="leftContentFrame">
      <!--左边菜单框leftMenuFrame-->
      <div class="leftMenuFrame">
        <jsp:include
	page="/jsp/include/leftMenu.jsp" flush="true"></jsp:include>
      </div>
      <!--//leftMenuFrame-->
      <div class="imgLinksFrame">
        <jsp:include
	page="/jsp/include/imgLinks.jsp" flush="true"></jsp:include>
      </div>
      <div class="customLinksFrame">
        <jsp:include
	page="/jsp/include/customLinks.jsp" flush="true"></jsp:include>
      </div>
    </div>
    <!--右边内容框rightContentFrame-->
    <div class="rightContentFrame">
      <div class="breadcrumbs"><a href="/">首页</a> &nbsp;&gt;&nbsp;搜索结果</div>
      <%
	request.setCharacterEncoding("utf-8");
	String keyword = request.getParameter("searchKeyword");
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
          <li><a href="/jsp/news/news.jsp?id=<%=aNews.getId()%>"
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
          <li><a href="/jsp/info/info.jsp?id=<%=i.getId()%>" target="_blank"
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
          <li><a
		href="/jsp/files/download.jsp?name=<%=name%>&id=<%=f.getId() %>&storeType=0"
		target="_blank" style=" width:75%; float:left;"><%=name%></a><span
		style=" width:20%; float:right;"><%=time%></span></li>
          <%
		}
		}
	%>
        </ul>
      </div>
    </div>
    <!--//rightContentFrame-->
  </div>
  <!--content-->
</div>
<!--container-->
<!--底部bottom-->
<div class="footer">
  <jsp:include page="/jsp/include/footer.jsp"
	flush="true"></jsp:include>
</div>
<!--//bottom-->
</body>
</html>
