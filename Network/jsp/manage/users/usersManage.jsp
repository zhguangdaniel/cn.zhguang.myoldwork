<%@ page contentType="text/html; charset=utf-8" language="java"
	import="user.*,java.util.ArrayList" errorPage="/jsp/error/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/manage.css" rel="stylesheet" type="text/css" />
<link href="/css/manageContent.css" rel="stylesheet" type="text/css" />
<!--[if lte IE 6]>
<link href="/css/contentButtonIE6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<jsp:useBean id="userBean" class="user.UserBean" scope="page" />
<script type="text/javascript" src="/js/usersManage.js"></script>
<title>网工后台管理－用户管理</title>
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
	}else if(!((String)session.getAttribute("userRole")).equals("0")){
		out.println("<center>你没有打开该页面的权限...</center>");
	} else {
		String auth = (String) session.getAttribute("userAuthority");
		String myEmail = (String) session.getAttribute("userEmail");
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
        <div style="float:left;">&nbsp;&nbsp;所有用户：</div>
        <%if(User.checkHaveAuthority(auth,User.regNewUser)){ %>
        <div id="tempContentHeader">
          <div id="contentButton">
            <ul>
              <li><a href="/jsp/manage/users/addUser.jsp" target="_self"><img
		src="/images/addUser.png" width="16" height="16" />&nbsp;&nbsp;添加用户</a></li>
            </ul>
          </div>
        </div>
        <%} %>
      </div>
      <%
		ArrayList<User> usersList = userBean.getAllUsers();
		int count = 0;
		while (usersList.size() != 0) {
			User u = usersList.remove(0);
%>
      <div class="userItemTitle"><font color="#505050"><%=(++count)%>，</font><font style="color:<%out.print(myEmail.equals(u.getEmail())?"#0000FF":"#505050"); %>; font-weight:bold"><%=u.getName()%></font>&nbsp;&nbsp;<font style="color:#069; font-size:14px;">&lt;</font><a href="mailto:<%= u.getEmail()%>" class="emailText"><%=u.getEmail()%></a><font style="color:#069; font-size:14px;">&gt;</font>
      <%if((u.getRole() == 1&&User.checkHaveAuthority(auth,User.allowNewReg))||(u.getRole() != 1&&User.checkHaveAuthority(auth,User.editUserPower))){if(!myEmail.equals(u.getEmail())){%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="/images/authority.png" width="12" height="12" /><a href="/jsp/manage/users/editAuthority.jsp?email=<%=u.getEmail()%>&type=<%=u.getRole()%>" class="normalLink">
        <%out.print((u.getRole() == 1) ? "审核" : "修改权限");%>
        </a><%}}if(User.checkHaveAuthority(auth,User.delUser)){ %>&nbsp;&nbsp;<img src="/images/Delete.png" width="12" height="12" /><a href="/jsp/manage/users/delUser.jsp?email=<%=u.getEmail()%>"
	target="_self" class="normalLink" onclick="return onDelete()">删除用户</a><%} %></div>
      <div class="userItemInfo">用户身份：
        <%
			switch (u.getRole()) {
			case 0:
				out.print("<font color='#505050'>超级管理员</font>");
				out.print("，共登录：" + u.getLogCount() + "次，上次登录时间："+ u.getLastLogTime().substring(0, 16));
				break;
			case 1:
				out.print("<font color='#FF0000'>已注册的用户（待审核）</font>");
				out.print("注册时间："+ u.getLastLogTime().substring(0, 16));//对新注册的用户来说，regTime和lastLogTime一样
				break;
			case 2:
				out.print("<font color='#BBBBBB'>管理员</font>");
				out.print("，共登录：" + u.getLogCount() + "次，上次登录时间："+ u.getLastLogTime().substring(0, 16));
				break;
			default:
				out.print("<font color='#FF0000'>错误的身份</font>");
			}

   %>
      </div>
      <%}%>
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
