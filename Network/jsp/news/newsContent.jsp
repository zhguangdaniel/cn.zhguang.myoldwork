<%@ page contentType="text/html; charset=utf-8" language="java" import="news.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/news.css" type="text/css" rel="stylesheet" />
<link href="/css/main.css" type="text/css" rel="stylesheet" />
<jsp:useBean id="newsBean" class="news.NewsBean" scope="page" />
<div class="breadcrumbs"><a href="/">首页</a> &nbsp;&gt;&nbsp;<a href="/jsp/news/newsList.jsp?page=1">新闻中心</a> &nbsp;&gt;&nbsp;新闻</div>
<%
			SingleNews news = newsBean.getNews(Integer.parseInt(request
			.getParameter("id")));
%>
<div class="news">
  <table width="100%" cellpadding="0" cellspacing="0"
	border="0">
    <tr>
      <td align="center" height="30px" valign="middle" class="title"><%=news.getTitle()%></td>
    </tr>
    <tr>
      <td align="center" height="20px" valign="bottom" class="newsInfo"><%
		if (!news.getCreater().equals("") && !(news.getCreater() == null)) {
		%>
        发布者：<%=news.getCreater()%>&nbsp;&nbsp;&nbsp;
        <%
		}
		%>
        发布于：<%=news.getCreateTime().substring(0, 16)%></td>
    </tr>
    <tr>
      <td height="5px" width="100%" valign="top"></td>
    </tr>
    <tr>
      <td align="left" width="100%" valign="top"><span><%=news.getContent()%></span></td>
    </tr>
    <tr>
      <td height="20px" width="100%" valign="top"></td>
    </tr>
    <%
	if (news.getModifyTime() != null) {
	%>
    <tr>
      <td align="left" height="20px" width="100%" valign="middle"><span
			class="bottomTips">本文于&nbsp;<%=news.getModifyTime().substring(0, 16)%>&nbsp;被
        <%
		if ((news.getModifyUser()!=null) && !news.getModifyUser().equals("")) {
		%>
        &nbsp;<%=news.getModifyUser()%>&nbsp;
        <%}%>
        修改</span></td>
    </tr>
    <%
	}
	%>
  </table>
</div>
