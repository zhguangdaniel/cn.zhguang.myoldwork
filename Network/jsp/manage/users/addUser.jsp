<%@ page contentType="text/html; charset=utf-8" language="java"
	import="user.*" errorPage="/jsp/error/error.jsp"%>
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
<script type="text/javascript" src="/js/register.js"></script>
<title>网工后台管理－添加用户</title>
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
	}else if(!((String)session.getAttribute("userRole")).equals("0")||!User.checkHaveAuthority(((String)session.getAttribute("userAuthority")),User.regNewUser)){
		out.println("<center>你没有打开该页面的权限...</center>");
	}  else {
		String myAuth = (String) session.getAttribute("userAuthority");
		String oldAu=null;
		String errMsg = null;
		String oldEmail= null;
		String oldName=null;
		try {
			oldAu = (String) session.getAttribute("addUserAu");
		} catch (Exception e) {
			oldAu = "000000000000000000000000000000";
		}
		if (oldAu == null) {
			oldAu = "000000000000000000000000000000";
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
			oldName = (String) session.getAttribute("name");
		} catch (Exception e) {
		}
		if (oldName == null) {
			oldName = "";
		}
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
        <div style="float:left;">&nbsp;&nbsp; 添加用户</div>
      </div>
      <div id="regTopTipsFrame"> 请填写下面的内容并为该用户赋予权限： </div>
      <form id="form_editAuthority" action="/jsp/manage/users/saveAuthority.jsp?saveType=0" method="post">
        <table width="100%" align="center" cellpadding="0" cellspacing="0" border="0">
          <tr>
            <td width="20%" height="35px"id="regItemName" align="right">电子邮件：</td>
            <td width="2%"></td>
            <td width="23%" align="left"><input type="text" name="email" id="email" style="width:150px;" onfocus="onAddFocus(this.id,'email_tips')" onblur="onAddBlur(id,'email_tips')" /></td>
            <td width="55%" align="left"><span id="email_tips"></span></td>
          </tr>
          <tr>
            <td width="20%" height="35px"id="regItemName" align="right">用户名：</td>
            <td width="2%"></td>
            <td width="23%" align="left"><input type="text" name="name" id="name" style="width:150px;" onfocus="onAddFocus(this.id,'name_tips')" onblur="onAddBlur(id,'name_tips')" /></td>
            <td width="55%" align="left"><span id="name_tips"></span></td>
          </tr>
          <tr>
            <td width="20%" height="35px"id="regItemName" align="right">密码：</td>
            <td width="2%"></td>
            <td width="23%" align="left"><input type="password" name="password" id="password" style="width:150px;" onfocus="onAddFocus(this.id,'password_tips')" onblur="onAddBlur(id,'password_tips')" /></td>
            <td width="55%" align="left"><span id="password_tips"></span></td>
          </tr>
          <tr>
            <td width="20%" height="35px"id="regItemName" align="right">确认密码：</td>
            <td width="2%"></td>
            <td width="23%" align="left"><input type="password" name="password2" id="password2" style="width:150px;" onfocus="onAddFocus(this.id,'password2_tips')" onblur="onAddBlur(id,'password2_tips')" /></td>
            <td width="55%" align="left"><span id="password2_tips"></span></td>
          </tr>
          <tr>
            <td height="10px" colspan="4"></td>
          </tr>
        </table>
        <table width="100%" align="center" cellpadding="0" cellspacing="0" border="0" id="blackText">
         <tr>
            <td height="30px;"></td>
            <td align="left" colspan="3" style="color:#006699"><input type="checkbox" id="setSuperAdmin" name="setSuperAdmin" value="SA" onclick="checkSuperAdmin('addErrInfo')" />
              设置该用户为超级管理员 </td>
          </tr>
          <tr>
            <td height="30px;" align="center" rowspan="9"valign="middle" style="font-size:15px;border:solid 1px #CCC;">赋予权限</td>
            <td colspan="3" style="border:solid #CCC;  border-width:1px 1px 0 0; height:30px; line-height:30px; padding-left:10px;"><span id="errorText">注：</span><span id="blackText">所有管理员不需要权限即可修改或删除自己发布的内容，下面的“他人”是指“其他管理员发布的”</span></td>
          </tr>
          <tr>
            <td height="30px" align="left" width="27%" style="border:solid #CCC; border-width:1px 0 1px;"><input type="checkbox" <%out.print(User.checkHaveAuthority(myAuth,User.publishNews)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(oldAu,User.publishNews)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.publishNews %>" />
              发布新闻</td>
            <td align="left" width="27%" style="border:solid #CCC;  border-width:1px 0 1px;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.editNews)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(oldAu,User.editNews)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.editNews %>" />
              修改他人新闻</td>
            <td align="left" width="27%" style="border:solid #CCC; border-width:1px 1px 1px 0;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.delNews)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(oldAu,User.delNews)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.delNews%>" />
              删除他人新闻</td>
          </tr>
          <tr>
            <td height="30px" align="left" width="27%" style="border:solid #CCC; border-width:0 0 1px;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.publishInfo)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(oldAu,User.publishInfo)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.publishInfo %>" />
              发布通知</td>
            <td align="left" width="27%" style="border:solid #CCC;  border-width:0 0 1px;"><input type="checkbox" id="userAuthority"  <%out.print(User.checkHaveAuthority(myAuth,User.editInfo)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(oldAu,User.editInfo)?"checked":""); %> name="userAuthority" value="<%=User.editInfo %>" />
              修改他人通知</td>
            <td align="left" width="27%" style="border:solid #CCC; border-width:0 1px 1px 0;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.delInfo)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(oldAu,User.delInfo)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.delInfo%>" />
              删除他人通知</td>
          </tr>
          <tr>
            <td height="30px" align="left" width="27%" style="border:solid #CCC; border-width:0 0 1px;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.uploadFile)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(oldAu,User.uploadFile)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.uploadFile %>" />
              上传文件</td>
            <td align="left" width="27%" colspan="2" style="border:solid #CCC;  border-width:0 1px 1px 0;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.delFile)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(oldAu,User.delFile)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.delFile %>" />
              删除他人文件</td>
          </tr>
          <tr>
            <td height="30px" align="left" width="27%" style="border:solid #CCC; border-width:0 0 1px;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.addLink)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(oldAu,User.addLink)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.addLink%>" />
              添加链接</td>
            <td align="left" width="27%" style="border:solid #CCC;  border-width:0 0 1px;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.editLink)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(oldAu,User.editLink)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.editLink %>" />
              修改他人链接</td>
            <td align="left" width="27%" style="border:solid #CCC; border-width:0 1px 1px 0;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.delLink)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(oldAu,User.delLink)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.delLink%>" />
              删除他人链接</td>
          </tr>
          <tr>
            <td height="30px" align="left" width="27%" style="border:solid #CCC; border-width:0 0 1px;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.replyMsg)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(oldAu,User.replyMsg)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.replyMsg%>" />
              回复留言</td>
            <td align="left" width="27%" style="border:solid #CCC;  border-width:0 0 1px;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.delMsg)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(oldAu,User.delMsg)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.delMsg%>" />
              删除留言</td>
            <td align="left" width="27%" style="border:solid #CCC; border-width:0 1px 1px 0;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.delMsgReply)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(oldAu,User.delMsgReply)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.delMsgReply%>" />
              删除他人的留言回复</td>
          </tr>
          <tr>
            <td height="30px" align="left" width="27%" colspan="3" style="border:solid #CCC; border-width:0 1px 1px 0;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.publishAffiche)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(oldAu,User.publishAffiche)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.publishAffiche%>" />
              发布后台首页公告</td>
          </tr>
          <tr>
            <td height="30px" align="left" width="27%"><input type="checkbox" id="userAuthority" name="userAuthority"  disabled <%out.print(User.checkHaveAuthority(oldAu,User.regNewUser)?"checked":""); %> value="<%=User.regNewUser%>" />
              添加用户</td>
            <td align="left" width="27%" ><input type="checkbox" id="userAuthority" name="userAuthority" disabled <%out.print(User.checkHaveAuthority(oldAu,User.delUser)?"checked":""); %> value="<%=User.delUser%>" />
              删除用户</td>
            <td align="left" width="27%" style="border-right:solid 1px #CCC;"><input type="checkbox" id="userAuthority" name="userAuthority" disabled <%out.print(User.checkHaveAuthority(oldAu,User.allowNewReg)?"checked":""); %> value="<%=User.allowNewReg%>" />
              审核用户并赋予权限</td>
          </tr>
          <tr>
            <td height="30px" align="left" width="27%" colspan="3" style="border:solid #CCC; border-width:0 1px 1px 0;"><input type="checkbox" id="userAuthority" name="userAuthority" disabled <%out.print(User.checkHaveAuthority(oldAu,User.editUserPower)?"checked":""); %> value="<%=User.editUserPower%>" />
              修改用户权限</td>
          </tr>
          <tr>
            <td width="20%" height="20px">&nbsp;</td>
            <td height="20px"id="regItemName" align="left" colspan="3"><span class="regErrMsg" id="addErrInfo"></span></td>
          </tr>
          <tr>
            <td height="25px"></td>
            <td align="right" style="padding-right:10px;"><a name="showErrInfo" id="showErrInfo"></a><input type="submit" id="blackText" name="saveUserAu" value="添加" onclick="return (checkAddUser()&&checkAddUserAuthority(0))" /></td>
            <td align="left" style="padding-left:10px;"><input type="reset" name="reset" id="blackText" value="重置" /></td>
            <td></td>
          </tr>
        </table>
      </form>
    </div>
  </div>
  <div id="bottom">
    <jsp:include
	page="/jsp/manage/include/bottom.jsp" flush="true"></jsp:include>
  </div>
</div>
<script language="javascript">
<!--
document.getElementById("addErrInfo").innerHTML=<%=("\""+errMsg+"\"")%>;
document.getElementById("email").value=<%=("\""+oldEmail+"\"")%>;
document.getElementById("name").value=<%=("\""+oldName+"\"")%>;
//-->
</script>
<%
session.setAttribute("errMsg",new String(""));
}
%>
</body>
</html>
