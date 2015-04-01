<%@ page contentType="text/html; charset=utf-8" language="java"
	import="news.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/old_1/css/news.css" type="text/css" rel="stylesheet" />
<link href="/old_1/css/style.css" type="text/css" rel="stylesheet" />
<jsp:useBean id="newsBean" class="news.NewsBean" scope="page" />
<div id="breadcrumbs"><a href="/old_1/index.jsp" class="normalLink">首页</a> &nbsp;&gt;&nbsp;<a href="/old_1/jsp/news/newsList.jsp?page=1"
	class="normalLink">新闻列表</a> &nbsp;&gt;&nbsp;新闻</div>
<%
			SingleNews news = newsBean.getNews(Integer.parseInt(request
			.getParameter("id")));
%>
<div id="news">
    <table width="100%" cellpadding="0" cellspacing="0"
	border="0">
        <tr>
            <td align="center" height="30px" valign="middle" id="title"><%=news.getTitle()%></td>
        </tr>
        <tr>
            <td align="center" height="20px" valign="bottom" id="newsInfo"><%
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
			id="bottomTips">本文于&nbsp;<%=news.getModifyTime().substring(0, 16)%>&nbsp;被<%
		if ((news.getModifyUser()!=null) && !news.getModifyUser().equals("")) {
		%>
                &nbsp;<%=news.getModifyUser()%>&nbsp;
        <%}%>修改</span></td>
        </tr>
        <%
	}
	%>
    </table>
</div>
