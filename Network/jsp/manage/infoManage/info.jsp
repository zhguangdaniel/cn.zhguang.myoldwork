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
<jsp:useBean id="pageCtrl" class="page.PageBean" scope="page"/>
<script type="text/javascript" src="/js/manage.js"></script>
<title>网工后台管理－通知管理</title>
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
            <div id="contentHeader"><div style="float:left;">&nbsp;&nbsp;所有通知：</div>
            <%if(User.checkHaveAuthority(auth,User.publishInfo)){ %>
                <div id="tempContentHeader">
                    <div id="contentButton">
                        <ul>
                            <li><a href="/jsp/manage/infoManage/publishInfo.jsp" target="_self"><img src="/images/New.png" width="16" height="16" />&nbsp;&nbsp;发布通知</a></li>
                        </ul>
                    </div>
                </div>
                <%} %>
            </div>
            <%
	int curPage = Integer.parseInt(request.getParameter("page"));
	pageCtrl = infoBean.getPageWithContent(curPage, 8);
	String currentURL = "http://"+request.getServerName()+":"+request.getServerPort()+request.getRequestURI()+"?"+request.getQueryString();
%>
            <table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
                <tr>
                    <td width="20px"></td>
                    <td width="80px" align="left"></td>
                    <td align="right"></td>
                    <td width="100px" align="right"></td>
                    <td width="20px"></td>
                </tr>
                <%
			while (pageCtrl.resultList.size() != 0) {
	        	Info n = (Info)pageCtrl.resultList.remove(0);
				String title = n.getTitle();
				String aTitle = title;
				String contentSummary = n.getContent();
			if(title.length()>39){
				aTitle=title.substring(0,38)+"...";
			}
	%>
                <tr>
                    <td height="30px"></td>
                    <td height="30px" align="left" colspan="2" style="border-bottom: dashed 1px #AAA;"><img src="/images/news.png" width="12" height="12" /><a href="/jsp/manage/infoManage/showInfo.jsp?id=<%=n.getId()%>&parent=<%=currentURL%>" class="itemName" title="<%=title%>"><%=aTitle%></a><%if(User.checkHaveAuthority(auth,User.editInfo)||curUser.equals(n.getCreater())){ %>&nbsp;&nbsp;&nbsp;<img src="/images/Edit.png" width="12" height="12" /><a
                href="/jsp/manage/infoManage/editInfo.jsp?id=<%=n.getId()%>&parent=<%=currentURL%>" target="_self" class="normalLink" >修改</a><%};if(User.checkHaveAuthority(auth,User.delInfo)||curUser.equals(n.getCreater())){ %>&nbsp;&nbsp;&nbsp;<img src="/images/Delete.png" width="12" height="12" /><a
                href="/jsp/manage/infoManage/delInfo.jsp?id=<%=n.getId()%>&parent=<%=currentURL%>" target="_self" class="normalLink" onclick="return onDelete()" >删除</a><%} %></td>
                    <td align="left" style="border-bottom:dashed 1px #AAA;"><span id="date">[<%=n.getCreateTime().substring(0, 10)%>]</span></td>
                    <td></td>
                </tr>
                <tr>
                   <td height="40px"></td>
                    <td height="40px" align="right" valign="top" colspan="2" >
                    <div style="font-family:Arial, '宋体'; font-size:12px; color: #999; line-height:20px; float:left; text-align:right; width:15%;">摘要：&nbsp;&nbsp;</div>
                    <div id="summary" style="float:right; width:82%; margin-right:10px;"><%=contentSummary%></div></td>
                    <td></td>
                    <td></td>
                </tr>
                <%
	}
	%>
                <tr>
                    <td height="10px" colspan="5"></td>
                </tr>
            </table>
            <div id="pageCtrlFrame" style="margin-bottom:10px;">
                <%
out.print(pageCtrl.printCtrl());
%>
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
