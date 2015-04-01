<%@ page contentType="text/html; charset=utf-8" language="java" import="news.*,user.*" errorPage="/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/manage.css" rel="stylesheet" type="text/css" />
<link href="/css/manageContent.css" rel="stylesheet" type="text/css" />
<!--[if lte IE 6]>
<link href="/css/contentButtonIE6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<jsp:useBean id="newsBean" class="news.NewsBean" scope="page"/>
<script type="text/javascript" src="/js/manage.js"></script>
<title>网工后台管理－新闻内容</title>
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
	}else{
		String auth = (String) session.getAttribute("userAuthority");
		SingleNews news = newsBean.getNews(Integer.parseInt(request.getParameter("id")));
		String parentURL = request.getParameter("parent");
		String currentURL = "http://"+request.getServerName()+":"+request.getServerPort()+request.getRequestURI()+"?"+request.getQueryString();
		String curUser = (String) session.getAttribute("userName");
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
        <div id="rightMain">
            <div id="contentHeader"><div style="float:left;">&nbsp;&nbsp;<a href="/jsp/manage/" class="normalLink">后台管理</a> &nbsp;&gt;&nbsp;<a href="/jsp/manage/newsManage/news.jsp?page=1" class="normalLink">新闻管理</a> &nbsp;&gt;&nbsp;新闻内容&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="/images/download.png" width="12" height="9" /><%if(User.checkHaveAuthority(auth,User.editNews)||curUser.equals(news.getCreater())){ %>&nbsp;&nbsp;<img src="/images/Edit.png" width="12" height="12" /><a
                href="/jsp/manage/newsManage/editNews.jsp?id=<%=news.getId()%>&parent=<%=currentURL%>" target="_self" class="normalLink" style="color:#069" >修改</a><%};if(User.checkHaveAuthority(auth,User.delNews)||curUser.equals(news.getCreater())){ %>&nbsp;&nbsp;&nbsp;<img src="/images/Delete.png" width="12" height="12" /><a
                href="/jsp/manage/newsManage/delNews.jsp?id=<%=news.getId()%>&parent=<%=parentURL%>" target="_self" class="normalLink" style="color:#069" onclick="return onDelete()" >删除</a><%} %></div>
                <%if(User.checkHaveAuthority(auth,User.publishNews)){ %>
                <div id="tempContentHeader">
                    <div id="contentButton">
                        <ul>
                            <li><a href="/jsp/manage/newsManage/publishNews.jsp" target="_self"><img src="/images/New.png" width="16" height="16" />&nbsp;&nbsp;发布新闻</a></li>
                        </ul>
                    </div>
                </div>
                <%} %>
            </div>
            <div id="contentFrame">
                <table width="100%" cellpadding="0" cellspacing="0" border="0">
                    <tr>
                        <td align="center" height="30px" valign="middle"  id="title"><%=news.getTitle()%></td>
                    </tr>
                    <tr>
                        <td align="center" height="20px" valign="bottom" id="articleInfo"><%if(!(news.getCreater()==null)&& !news.getCreater().equals("")){%>
                            发布者：<%=news.getCreater()%>&nbsp;&nbsp;&nbsp;
                            <%}%>
                            发布于：<%=news.getCreateTime().substring(0,16)%></td>
                    </tr>
                    <tr>
                        <td height="5px" width="100%" valign="top"></td>
                    </tr>
                    <tr>
                        <td align="left" width="100%" valign="top"><span><%=news.getContent()%></span></td>
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
        </div>
    </div>
    <div id="bottom">
        <jsp:include page="/jsp/manage/include/bottom.jsp" flush="true"></jsp:include>
    </div>
</div>
<%	
	}
%>
</body>
</html>
