<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/main.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="/js/login.js"></script>
<div class="bar">用户</div>
<div class="userInfoContent">
  <%
	boolean isLog = false;
	String errMsg = null;
	String oldEmail = null;
	String oldPassword = null;
	String userName = null;
	String userIconPath = "";
	String attentionMeNum = "";
	try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
	try {
		errMsg = (String) session.getAttribute("errMsg");
	} catch (Exception e) {
	}
	if (errMsg == null) {
		errMsg = "";
	}
	try {
		oldEmail = (String) session.getAttribute("email");
	} catch (Exception e) {
	}
	if (oldEmail == null) {
		oldEmail = "";
	}
	try {
		userName = (String) session.getAttribute("userName");
	} catch (Exception e) {
	}
	if (userName == null) {
		userName = "";
	}
	try {
		userIconPath = (String) session.getAttribute("userIconPath");
	} catch (Exception e) {
	}
	try {
		attentionMeNum = (String)session.getAttribute("attentionMeNum");
	} catch (Exception e) {
	}
	if(errMsg.equals("用户不存在！")){
		oldEmail ="";
	}
	oldPassword = "";
if (isLog) {
%>
  <table align="center" width="100%" cellpadding="0" cellspacing="0" border="0">
    <tr>
      <td width="40%" align="right" valign="middle"><img class="borderImg" src="<%=userIconPath%>" width="50px" height="50px" /></td>
      <td id="blackText" style=" padding-left:20px"><span class="nameInUserInfo"><%=userName%></span>
      <br />
      欢迎回来！</td>
    </tr>
    <tr>
      <td id="blackText" style="padding-left:30px;" colspan="2" height="45px">有&nbsp;<span class="bigNum"><%=attentionMeNum %></span>&nbsp;人关注您</td>
    </tr>
  </table>
  <%
	}//if
	else {
%>
  <form id="form_login" method="post" action="/jsp/user/doLogin.jsp">
    <table align="center" width="100%" cellpadding="0" cellspacing="0" border="0">
      <tr>
        <td colspan="2" height="20px" valign="top" id="blackText">您尚未登录：</td>
      </tr>
      <tr>
        <td colspan="2" align="center"><a href="/register" class="regBtn"></a></td>
      </tr>
      <tr>
        <td width="30%" height="30px" align="center" id="blackText">邮箱</td>
        <td width="70%" align="left" height="30px"><input type="text" name="email" id="email" style="width:120px" /></td>
      </tr>
      <tr>
        <td width="30%" height="30px" align="center" id="blackText">密码</td>
        <td width="70%" height="30px" align="left"><input type="password" name="password" id="password" style="width:120px" /></td>
      </tr>
      <tr>
        <td colspan="2" height="20px"><div class="loginErrMsgFrame" id="errInfo"></div></td>
      </tr>
      <tr>
        <td colspan="2" align="center" valign="top">
        <input type="submit" onclick="return checkLogin()" class="loginBtn" value="" style="border:0" />
        </td>
      </tr>
    </table>
  </form>
  <%
}//else
%>
  <script language="javascript">
<!--
document.getElementById("errInfo").innerHTML=<%=("\""+errMsg+"\"")%>;
document.getElementById("email").innerText =<%=("\""+oldEmail+"\"")%>;
document.getElementById("password").innerText =<%=("\""+oldPassword+"\"")%>;
//-->
</script>
  <%
if(errMsg.equals("用户不存在！")){
%>
  <script language="javascript">
<!--
document.getElementById("email").focus();
//-->
</script>
  <%	
}
else if(errMsg.equals("密码错误！")){
%>
  <script language="javascript">
<!--
document.getElementById("password").focus();
//-->
</script>
  <%	
}
errMsg = "";
session.setAttribute("errMsg",new String(""));
%>
</div>
