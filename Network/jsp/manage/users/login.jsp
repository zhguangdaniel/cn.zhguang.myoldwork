<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,database.*" errorPage="/jsp/error/error.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/manage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/managerLogin.js"></script>
<%
	String loginMsg = null;
	try {
		loginMsg = (String) session.getAttribute("loginMsg");
	} catch (Exception e) {
	}
	if (loginMsg == null) {
		loginMsg = "";
	}
%>
<div id="loginFrame">
    <form id="form_login" action="/jsp/manage/users/doLogin.jsp" method="post">
        <table width="100%" align="center" cellpadding="0" cellspacing="0" border="0">
            <tr>
                <td colspan="2" height="30px" id="bar" style="text-align:center;">管理员登录</td>
            </tr>
            <tr>
                <td colspan="2" height="20px" style="border:solid #CCC; border-width:0 1px 0;">&nbsp;</td>
            </tr>
            <tr>
                <td width="50px" height="30px" align="center" id="blackText" style=" border-left:solid 1px #CCC;">邮箱</td>
                <td width="250px" align="left" height="30px"style=" border-right:solid 1px #CCC;"><input type="text" name="email" id="email" style="width:230px" /></td>
            </tr>
            <tr>
                <td width="50px" height="30px" align="center" id="blackText" style=" border-left:solid 1px #CCC;">密码:</td>
                <td width="250px" height="30px" align="left"  style=" border-right:solid 1px #CCC;"><input type="password" name="password" id="password" style="width:230px"/></td>
            </tr>
            <tr>
                <td colspan="2" height="16px" align="center" style="border:solid #CCC; border-width:0 1px 0;"><div class="loginMsgFrame" id="loginInfo"></div></td>
            </tr>
            <tr>
                <td colspan="2" align="center" height="30px" style="border:solid #CCC; border-width:0 1px 0;"><input type="submit" id="blackText" value="登录" onClick="return checkLogin()">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" name="reset" id="blackText" value="重置" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center" height="30px" style="border:solid #CCC; border-width:0 1px 1px;"><a href="/jsp/manage/users/register.jsp" target="_self" class="normalLink">管理员注册</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/" target="_self" class="normalLink">返回前台首页</a></td>
            </tr>
        </table>
    </form>
</div>
<script language="javascript">
<!--
	document.getElementById("loginInfo").innerHTML="<font color='#FF0000' size='-1' face='Arial, 宋体'>"+<%=("\""+loginMsg+"\"")%>+"</font>";
	document.getElementById("password").focus();
//-->
</script>
<%	
loginMsg = "";
session.setAttribute("loginMsg",new String(""));
%>
