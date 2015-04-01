<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,user.*,database.*" errorPage="/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/manage.css" rel="stylesheet" type="text/css" />
<link href="/css/manageContent.css" rel="stylesheet" type="text/css" />
<jsp:useBean id="userBean" class="user.UserBean" scope="page" />
<jsp:useBean id="msgBean" class="message.MsgBean" scope="page"/>
<script type="text/javascript" src="/js/manage.js"></script>
<script type="text/javascript" src="/js/register.js"></script>
<title>网工教学网站－后台管理</title>
</head>
<body>
<!--全部区域-->
<div id="container">
  <%
	boolean isLog = false;
	try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
if (!isLog) {
%>
  <!--头部-->
  <div id="header"> </div>
  <!--主区，包括登录区-->
  <div id="mainContent" style="border:solid 1px #069; width:998px;">
    <jsp:include page="/jsp/manage/users/login.jsp" flush="true"></jsp:include>
  </div>
  <%
	}//if
	else {
		String errMsg = null;
		try {
			errMsg = (String) session.getAttribute("errMsg");
		} catch (Exception e) {
		}
		if (errMsg == null) {
			errMsg = "";
		}
%>
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
      <%
      		String auth = (String) session.getAttribute("userAuthority");
      		String email = (String)session.getAttribute("userEmail");
			User u = userBean.getUser(email);
			String affiche="";
        	String creator=null;
        	String createTime = null;
			Connection con = new DBConnection().getConnection();
			Statement stat = con.createStatement();
			ResultSet rSet = stat.executeQuery("select * from manageAffiche where id=1");
			if (rSet.next()) {
				creator= rSet.getString("creator");
				affiche=rSet.getString("affiche");
				createTime=rSet.getString("createTime");
			}
			rSet.close();
			stat.close();
			con.close();
		%>
      <div class="defaultPageFrame">
        <div class="defaultPageTitle"> 公告:<%if(User.checkHaveAuthority(auth,User.publishAffiche)){ %>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:showHide('addAfficheFrame');" class="normalLink" style="font-weight:lighter">发布公告</a>&nbsp;&nbsp;<a href="/jsp/manage/affiche/clearAffiche.jsp" class="normalLink" style="font-weight:lighter" onclick=" return onClear()">清空公告</a> <%} %></div>
        <div class="defaultPageContent">
          <%if(affiche==null||affiche.equals("")){
        	out.print("无内容...");
       		}else{
      		 	out.print(affiche);%>
          <br />
          <br />
          <font color="#999999">发布者：<%=creator %>&nbsp;&nbsp;于：<%=createTime.substring(0,16) %></font>
          <%}%>
        </div>
        <div class="publishAfficheFrame" id="addAfficheFrame">
          <form name="form_addAffiche" method="post" action="/jsp/manage/affiche/addAffiche.jsp">
            <table border="0" cellpadding="0" cellspacing="5">
              <tr>
                <td width="80px" valign="top"align="right">公告内容：</td>
                <td  width="480px"><textarea name="affiche" id="affiche" style="width:480px;height:120px; font-family: Arial, '宋体'; font-size:13px;"></textarea></td>
                <td></td>
              </tr>
              <tr>
                <td></td>
                <td><input name="addAffiche" type="submit" value="保存" onclick="return checkReplyLength('affiche')" />
                  <input type="reset" name="reset" value="重置" /></td>
                <td></td>
              </tr>
            </table>
          </form>
        </div>
      </div>
      <div class="defaultPageFrame">
        <div class="defaultPageTitle"> 个人信息:&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:showEditUserInfo();" class="normalLink" style="font-weight:lighter">修改个人资料</a>&nbsp;&nbsp;<a href="javascript:showEditPwd();" class="normalLink" style="font-weight:lighter">修改密码</a></div>
        <div class="defaultPageContent" id="showUserInfo" style="display:block;">
          <table width="100%" align="center" cellpadding="0" cellspacing="0" border="0">
            <tr>
              <td height="30px;" width="20%" align="right">用户名称：</td>
              <td align="left" style="padding-left:10px;"><%
         		out.print(u.getName()+"  (");
       			 switch(u.getRole()){
       			 case 0:
       			 	out.print("<font color='#505050'>超级管理员</font>");
       			 	break;
       			 case 1:
       			 	out.print("<font color='#FF0000'>待审核用户</font>");
       			 	break;
       			 case 2:
       			 	out.print("<font color='#505050'>管理员</font>");
      			  	break;
        		default:
        			out.print("<font color='#FF0000'>错误的身份</font>");
       			 }
				 out.print(")");
        %></td>
            </tr>
            <tr>
              <td height="30px;" align="right">Eamil：</td>
              <td align="left" style="padding-left:10px;"><%=u.getEmail() %></td>
            </tr>
            <tr>
              <td height="30px;" align="right">注册时间：</td>
              <td align="left" style="padding-left:10px;"><%=u.getRegTime().substring(0,16) %></td>
            </tr>
            <tr>
              <td height="30px;" align="right">登录次数：</td>
              <td align="left" style="padding-left:10px;"><%=u.getLogCount() %></td>
            </tr>
            <tr>
              <td height="30px;" align="right">上次登录时间：</td>
              <td align="left" style="padding-left:10px;"><%=u.getLastLogTime().substring(0,16)%></td>
            </tr>
            <tr>
              <td height="30px;" align="right">身份信息：</td>
              <td align="left" style="padding-left:10px;"><%=u.getRegUserInfo()%></td>
            </tr>
          </table>
        </div>
        <div class="defaultPageContent" id="editUserInfo"  style="display:none;">
          <form id="form_editUserInfo" action="/jsp/manage/users/saveAuthority.jsp?saveType=3&email=<%=u.getEmail() %>" method="post">
            <table width="100%" align="center" cellpadding="0" cellspacing="0" border="0">
              <tr>
                <td width="20%" height="35px"id="regItemName" align="right">Email：</td>
                <td width="2%"></td>
                <td width="23%" align="left"><%=u.getEmail() %></td>
                <td width="55%" align="left"></td>
              </tr>
              <tr>
                <td width="20%" height="35px"id="regItemName" align="right">用户名：</td>
                <td width="2%"></td>
                <td width="23%" align="left"><input type="text" name="name" id="name" style="width:150px;" value="<%=u.getName() %>" onfocus="onEditFocus(this.id,'name_tips')" onblur="onEditBlur(id,'name_tips')" /></td>
                <td width="55%" align="left"><span id="name_tips"></span></td>
              </tr>
              <tr>
                <td width="20%" height="35px"id="regItemName" align="right">密码提示问题：</td>
                <td width="2%"></td>
                <td width="23%" align="left"><input type="text" name="passwordQuestion" id="passwordQuestion" style="width:150px;" value="<%=u.getPasswordQuestion() %>" onfocus="onEditFocus(this.id,'passwordQuestion_tips')" onblur="onEditBlur(id,'passwordQuestion_tips')" /></td>
                <td width="55%" align="left"><span id="passwordQuestion_tips"></span></td>
              </tr>
              <tr>
                <td width="20%" height="35px"id="regItemName" align="right">提示问题回答：</td>
                <td width="2%"></td>
                <td width="23%" align="left"><input type="text" name="passwordAnswer" id="passwordAnswer" style="width:150px;" value="<%=u.getPasswordAnswer() %>"  onfocus="onEditFocus(this.id,'passwordAnswer_tips')" onblur="onEditBlur(id,'passwordAnswer_tips')"/></td>
                <td width="55%" align="left"><span id="passwordAnswer_tips"></span></td>
              </tr>
              <tr>
                <td width="20%" height="35px" id="regItemName" align="right" valign="top">身份信息：</td>
                <td width="2%"></td>
                <td align="left"><textarea id="regUserInfo" name="regUserInfo" style="width:100%; color:#000; height:50px; font-family: Arial, '宋体'; font-size:13px;" onfocus="onEditFocus(this.id,'regUserInfo_tips')" onblur="onEditBlur(id,'regUserInfo_tips')"><%=u.getRegUserInfo() %></textarea></td>
                <td width="55%" align="left" style="padding-left:20px;"><span id="regUserInfo_tips"></span></td>
              </tr>
              <tr>
                <td width="20%" height="20px">&nbsp;</td>
                <td height="20px" id="regItemName" align="left" colspan="3"><span class="regErrMsg" id="editErrInfo"></span></td>
              </tr>
              <tr>
                <td width="20%" height="35px">&nbsp;</td>
                <td width="2%" height="35px">&nbsp;</td>
                <td height="35px"align="left" colspan="2"><input type="submit" id="blackText" value="提交" onclick="return checkEditUser()" />
                  <input type="reset" id="blackText" value="重置"></td>
              </tr>
            </table>
          </form>
        </div>
        <div class="defaultPageContent" id="editPassword" style="display:none;">
          <form id="form_editPassword" action="/jsp/manage/users/saveAuthority.jsp?saveType=4&email=<%=u.getEmail() %>" method="post">
            <table width="100%" align="center" cellpadding="0" cellspacing="0" border="0">
              <tr>
                <td width="20%" height="35px"id="regItemName" align="right">输入旧密码：</td>
                <td width="2%"></td>
                <td width="23%" align="left"><input type="password" name="oldPwd" id="oldPwd" style="width:150px;" onfocus="onEditPwdFocus(this.id,'oldPwd_tips')" onblur="onEditPwdBlur(id,'oldPwd_tips')" /></td>
                <td width="55%" align="left"><span id="oldPwd_tips"></span></td>
              </tr>
              <tr>
                <td width="20%" height="35px"id="regItemName" align="right">输入新密码：</td>
                <td width="2%"></td>
                <td width="23%" align="left"><input type="password" name="password" id="password" style="width:150px;" onfocus="onEditPwdFocus(this.id,'password_tips')" onblur="onEditPwdBlur(id,'password_tips')" /></td>
                <td width="55%" align="left"><span id="password_tips"></span></td>
              </tr>
              <tr>
                <td width="20%" height="35px"id="regItemName" align="right">确认新密码：</td>
                <td width="2%"></td>
                <td width="23%" align="left"><input type="password" name="password2" id="password2" style="width:150px;" onfocus="onEditPwdFocus(this.id,'password2_tips')" onblur="onEditPwdBlur(id,'password2_tips')" /></td>
                <td width="55%" align="left"><span id="password2_tips"></span></td>
              </tr>
              <tr>
                <td width="20%" height="20px">&nbsp;</td>
                <td height="20px" id="regItemName" align="left" colspan="3"><span class="regErrMsg" id="editPwdInfo"></span></td>
              </tr>
              <tr>
                <td width="20%" height="35px">&nbsp;</td>
                <td width="2%" height="35px">&nbsp;</td>
                <td height="35px"align="left" colspan="2"><input type="submit" id="blackText" value="提交" onclick="return checkEditPwd()" />
                  <input type="reset" id="blackText" value="重置"></td>
              </tr>
            </table>
          </form>
        </div>
      </div>
      <div class="defaultPageFrame">
        <div class="defaultPageTitle"> 网站动态:</div>
        <div class="defaultPageContent"> 
        <%
		int noReplyMsgsCount =msgBean.getMsgsCountWithNoReply();
		if(noReplyMsgsCount==0||!User.checkHaveAuthority(auth,User.replyMsg)){
        	out.print("无动态...");
       		}else{
      		%>
        有<a href="/jsp/manage/msgManage/msg.jsp?page=1" target="_self" class="normalLink"><%= noReplyMsgsCount%>条留言</a>没有回复 
        <%}%>
        </div>
      </div>
    </div>
  </div>
  <script language="javascript">
<!--
var errInfo = "<%=errMsg%>";
if(errInfo!="")
	alert(errInfo);
//-->
</script>
  <%
session.setAttribute("errMsg",new String(""));
}//else
%>
  <div id="bottom">
    <jsp:include page="/jsp/manage/include/bottom.jsp" flush="true"></jsp:include>
  </div>
</div>
</body>
</html>