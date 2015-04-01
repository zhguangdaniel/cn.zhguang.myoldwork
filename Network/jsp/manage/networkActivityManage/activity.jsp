<%@ page contentType="text/html; charset=utf-8" language="java" import="customLinks.*,java.sql.*,java.util.ArrayList" errorPage="/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/manage.css" rel="stylesheet" type="text/css" />
<link href="/css/manageContent.css" rel="stylesheet" type="text/css" />
<!--[if lte IE 6]>
<link href="/css/contentButtonIE6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<jsp:useBean id="links" class="customLinks.LinksBean" scope="page"/>
<script type="text/javascript">
function onDelete() {
   return confirm("确定要删除吗？");
} 
</script>
<title>网工后台管理－创新活动管理</title>
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
		String currentURL = "http://"+request.getServerName()+":"+request.getServerPort()+request.getRequestURI()+"?"+request.getQueryString();
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
            <div id="contentHeader"><div style="float:left">&nbsp;&nbsp;创新活动管理：</div>
                <div id="tempContentHeader">
                    <div id="contentButton">
                        <ul>
                            <li><a href="" target="_self">&nbsp;&nbsp;</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
                <tr>
                    <td width="20px" height="20px"></td>
                    <td width="110px" align="left"></td>
                    <td align="right"></td>
                    <td width="90px" align="right"></td>
                    <td width="20px"></td>
                </tr>
                <tr>
                    <td colspan="5" align="center">暂时没有内容...</td>
                </tr>
                <tr>
                    <td height="10px" colspan="5"></td>
                </tr>
            </table>
        </div>
    </div>
    <div id="bottom">
        <jsp:include page="/jsp/manage/include/bottom.jsp" flush="true"></jsp:include>
    </div>
</div>
<%	
	}//else
%>
</body>
</html>
