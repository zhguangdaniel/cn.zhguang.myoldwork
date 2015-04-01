<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网工－管理员注册</title>
<link href="/css/manage.css" rel="stylesheet" type="text/css" />
<link href="/css/manageContent.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/register.js"></script>
</head>
<body>
<%
	String errMsg = null;
	String oldEmail= null;
	String oldName=null;
	String oldPasswordQuestion=null;
	String oldPasswordAnswer=null;
	String oldRegUserInfo=null;
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
		oldName = (String) session.getAttribute("name");
	} catch (Exception e) {
	}
	if (oldName == null) {
		oldName = "";
	}
	try {
		oldPasswordQuestion = (String) session.getAttribute("passwordQuestion");
	} catch (Exception e) {
	}
	if (oldPasswordQuestion == null) {
		oldPasswordQuestion = "";
	}
	try {
		oldPasswordAnswer = (String) session.getAttribute("passwordAnswer");
	} catch (Exception e) {
	}
	if (oldPasswordAnswer == null) {
		oldPasswordAnswer = "";
	}
	try {
		oldRegUserInfo = (String) session.getAttribute("regUserInfo");
	} catch (Exception e) {
	}
	if (oldRegUserInfo == null) {
		oldRegUserInfo = "";
	}
%>
<!--主体容器container-->
<div id="container">
  <!--头部-->
  <div id="header"> </div>
  <!--主区，包括登录区-->
  <div id="mainContent" style="border:solid 1px #069; width:998px;">
    <div id="regFrame">
      <div id="regTopTipsFrame"> 欢迎注册，请填写以下内容，打*的是必填项： </div>
      <div id="regTable">
        <form id="form_reg" action="/jsp/manage/users/doRegist.jsp" method="post">
          <table width="100%" align="center" cellpadding="0" cellspacing="0" border="0">
            <tr>
              <td width="20%" height="35px"id="regItemName" align="right">电子邮件：</td>
              <td width="2%"></td>
              <td width="23%" align="left"><input type="text" name="email" id="email" style="width:150px;" onfocus="onRegFocus(this.id,'email_tips')" onblur="onRegBlur(id,'email_tips')" />
                *</td>
              <td width="55%" align="left"><span id="email_tips"></span></td>
            </tr>
            <tr>
              <td width="20%" height="35px"id="regItemName" align="right">用户名：</td>
              <td width="2%"></td>
              <td width="23%" align="left"><input type="text" name="name" id="name" style="width:150px;" onfocus="onRegFocus(this.id,'name_tips')" onblur="onRegBlur(id,'name_tips')" />
                *</td>
              <td width="55%" align="left"><span id="name_tips"></span></td>
            </tr>
            <tr>
              <td width="20%" height="35px"id="regItemName" align="right">密码：</td>
              <td width="2%"></td>
              <td width="23%" align="left"><input type="password" name="password" id="password" style="width:150px;" onfocus="onRegFocus(this.id,'password_tips')" onblur="onRegBlur(id,'password_tips')" />
                *</td>
              <td width="55%" align="left"><span id="password_tips"></span></td>
            </tr>
            <tr>
              <td width="20%" height="35px"id="regItemName" align="right">确认密码：</td>
              <td width="2%"></td>
              <td width="23%" align="left"><input type="password" name="password2" id="password2" style="width:150px;" onfocus="onRegFocus(this.id,'password2_tips')" onblur="onRegBlur(id,'password2_tips')" />
                *</td>
              <td width="55%" align="left"><span id="password2_tips"></span></td>
            </tr>
            <tr>
              <td width="20%" height="35px"id="regItemName" align="right">密码提示问题：</td>
              <td width="2%"></td>
              <td width="23%" align="left"><input type="text" name="passwordQuestion" id="passwordQuestion" style="width:150px;" onfocus="onRegFocus(this.id,'passwordQuestion_tips')" onblur="onRegBlur(id,'passwordQuestion_tips')" /></td>
              <td width="55%" align="left"><span id="passwordQuestion_tips"></span></td>
            </tr>
            <tr>
              <td width="20%" height="35px"id="regItemName" align="right">提示问题回答：</td>
              <td width="2%"></td>
              <td width="23%" align="left"><input type="text" name="passwordAnswer" id="passwordAnswer" style="width:150px;"  onfocus="onRegFocus(this.id,'passwordAnswer_tips')" onblur="onRegBlur(id,'passwordAnswer_tips')"/></td>
              <td width="55%" align="left"><span id="passwordAnswer_tips"></span></td>
            </tr>
            <tr>
              <td width="20%" height="35px" id="regItemName" align="right" valign="top">身份确认：</td>
              <td width="2%"></td>
              <td align="left"><textarea id="regUserInfo" name="regUserInfo" style="width:100%; color:#000; height:50px; font-family: Arial, '宋体'; font-size:13px;" onfocus="onRegFocus(this.id,'regUserInfo_tips')" onblur="onRegBlur(id,'regUserInfo_tips')"></textarea></td>
              <td width="55%" align="left" style="padding-left:20px;"><span id="regUserInfo_tips"></span></td>
            </tr>
            <tr>
              <td width="20%" height="35px"id="regItemName" align="right">验证码：</td>
              <td width="2%"></td>
              <td width="23%" align="left"><div style="height:auto; width:auto; text-align:left; float:left;">
                  <input type="text" name="vcode" id="vcode" style="width:70px;" onfocus="onRegFocus(this.id,'vcode_tips')" onblur="onRegBlur(id,'vcode_tips')" />
                  *&nbsp;&nbsp;&nbsp;</div>
                <img id="vcodeImg" src="/jsp/vcode/image.jsp" onclick="javascript:reloadVCode();" style="border:none; width:60px; height:20px;"/></td>
              <td width="55%" align="left"><a href="javascript:reloadVCode();" style="font-family: Arial, '宋体';font-size:12px;color:#006699;">看不清楚？换张图片！</a>
                <div><span id="vcode_tips"></span></div></td>
            </tr>
            <tr>
              <td width="20%" height="20px">&nbsp;</td>
              <td height="20px"id="regItemName" align="left" colspan="3"><span class="regErrMsg" id="regErrInfo"></span></td>
            </tr>
            <tr>
              <td width="20%" height="35px">&nbsp;</td>
              <td width="2%" height="35px">&nbsp;</td>
              <td height="35px"align="left" colspan="2"><input type="submit" id="blackText" value="提交" onclick="return checkRegist()" />
                <input type="reset" id="blackText" value="重置"/>&nbsp;&nbsp;<a href="/jsp/manage/" class="normalLink" target="_self">返回后台首页</a></td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  </div>
  <!--//mainContent-->
  <div id="bottom">
    <jsp:include page="/jsp/manage/include/bottom.jsp" flush="true"></jsp:include>
  </div>
</div>
<script language="javascript">
<!--
document.getElementById("regErrInfo").innerHTML=<%=("\""+errMsg+"\"")%>;
document.getElementById("email").value=<%=("\""+oldEmail+"\"")%>;
document.getElementById("name").value=<%=("\""+oldName+"\"")%>;
document.getElementById("passwordQuestion").value=<%=("\""+oldPasswordQuestion+"\"")%>;
document.getElementById("passwordAnswer").value=<%=("\""+oldPasswordAnswer+"\"")%>;
document.getElementById("regUserInfo").value=<%=("\""+oldRegUserInfo+"\"")%>;
//-->
</script>

<%
session.setAttribute("errMsg",new String(""));
%>
</body>
</html>