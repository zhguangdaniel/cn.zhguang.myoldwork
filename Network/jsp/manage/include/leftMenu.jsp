<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,user.*,database.*,java.lang.Integer" errorPage="/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/manageLeftMenu.css" rel="stylesheet" type="text/css" />
<!--[if lte IE 6]>
<style type="text/css">
#menu ul li a{
	height:23px;
	line-height:23px;
	padding-top:8px;
}
#menu ul li a:hover {
	height:23px;
	line-height:23px;
	padding-top:8px;
}
</style>
<![endif]-->
<%
String role = (String) session.getAttribute("userRole");
%>
<div id="menu">
  <ul>
    <li><a href="/jsp/manage/"><img src="/images/ReturnHome.png" width="14" height="14" border="0" />&nbsp;后台首页</a></li>
    <%if(role.equals("0")){%><li><a href="/jsp/manage/users/usersManage.jsp"><img src="/images/users.png" width="14" height="14" border="0" />&nbsp;用户管理</a></li><%} %>
    <li><a href="/jsp/manage/newsManage/news.jsp?page=1"><img src="/images/newsManage.png" width="14" height="14" border="0" />&nbsp;新闻管理</a></li>
    <li><a href="/jsp/manage/infoManage/info.jsp?page=1"><img src="/images/notice.png" width="14" height="16" border="0" />&nbsp;通知管理</a></li>
    <li><a href="/jsp/manage/filesManage/files.jsp?page=1"><img src="/images/fileManage.png" width="16" height="15" border="0" />&nbsp;文件管理</a></li>
    <li><a href="/jsp/manage/linksManage/links.jsp"><img src="/images/linksManage.png" width="15" height="15" border="0" />&nbsp;相关链接</a></li>
    <li><a href="/jsp/manage/msgManage/msg.jsp?page=1"><img src="/images/message.png" width="15" height="15" border="0" />&nbsp;留言管理</a></li>
    <li><a href="/jsp/manage/networkActivityManage/activity.jsp"><img src="/images/activityManage.png" width="14" height="14" border="0" />&nbsp;创新活动</a></li>
  </ul>
</div>
