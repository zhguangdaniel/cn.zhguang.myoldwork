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
<title>网工后台管理－用户权限管理</title>
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
	}else if((request.getParameter("type")).equals("1")&&!User.checkHaveAuthority(((String)session.getAttribute("userAuthority")),User.allowNewReg)){
		out.println("<center>你没有审核用户的权限...</center>");
	}else if((request.getParameter("type")).equals("2")&&!User.checkHaveAuthority(((String)session.getAttribute("userAuthority")),User.editUserPower)){
		out.println("<center>你没有修改用户权限的权力...</center>");
	}else {
		String errMsg = null;
		try {
			errMsg = (String) session.getAttribute("errMsg");
		} catch (Exception e) {
		}
		if (errMsg == null) {
			errMsg = "";
		}
		String myAuth = (String) session.getAttribute("userAuthority");
		String email = request.getParameter("email");
		User u = userBean.getUser(email);
		String authority =u.getAuthority();

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
        <div style="float:left;">&nbsp;&nbsp;
          <%out.print((u.getRole()==1)?"审核用户：":"修改权限：");%>
           <%out.print((u.getRole()==0)?"":"(你只能为他人赋予你已经拥有的权限)");%>
        </div>
      </div>
      <form id="form_editAuthority" action="/jsp/manage/users/saveAuthority.jsp?saveType=<%out.print((u.getRole()==1)?"1":"2");%>&email=<%=email %>" method="post">
        <table width="100%" align="center" cellpadding="0" cellspacing="0" border="0" id="blackText">
          <tr>
            <td height="30px;" width="19%" align="right" style="padding-right:10px;">用户名称：</td>
            <td align="left"  colspan="3"><%
          out.print(u.getName()+"  (");
        switch(u.getRole()){
        case 0:
        	out.print("<font color='#505050'>超级管理员</font>");
        	break;
        case 1:
        	out.print("<font color='#FF0000'>待审核</font>");
        	break;
        case 2:
        	out.print("<font color='#BBBBBB'>管理员</font>");
        	break;
        	default:
        		out.print("<font color='#FF0000'>错误的身份</font>");
        } 
        %>
              )</td>
          </tr>
          <tr>
            <td height="30px;" align="right" style="padding-right:10px;">Eamil：</td>
            <td align="left" colspan="3"><%=u.getEmail() %></td>
          </tr>
          <%
        if(u.getRole()==1){
        %>
          <tr>
            <td height="30px;" align="right" style="padding-right:10px;">注册时间：</td>
            <td align="left" colspan="3"><%=u.getRegTime().substring(0,16) %></td>
          </tr>
          <tr>
            <td height="30px;" align="right" style="padding-right:10px;">身份确认信息：</td>
            <td align="left"  colspan="3"><%=u.getRegUserInfo()%></td>
          </tr>
          <tr>
            <td height="30px;"></td>
            <td align="left" colspan="3" style="color:#006699"><input type="checkbox" id="notPass" name="notPass" value="NP" onclick="checkNotPass()" />
              不批准该用户成为管理员&nbsp;&nbsp;&nbsp;<input type="checkbox" id="setSuperAdmin" name="setSuperAdmin" <%out.print(u.getRole()==0?"checked":"");%> value="SA" onclick="checkSuperAdmin('authorityInfo')" />设置该用户为超级管理员
              </td>
          </tr>
          <% 
        }else{
        %>
          <tr>
            <td height="30px;" align="right" style="padding-right:10px;">用户信息：</td>
            <td align="left" colspan="3">共登录：<%=u.getLogCount() %>次，上次登录时间：<%=u.getLastLogTime().substring(0,16)%></td>
          </tr>
          <tr>
            <td height="30px;"></td>
            <td align="left" colspan="3" style="color:#006699"><input type="checkbox" id="setSuperAdmin" name="setSuperAdmin" <%out.print(u.getRole()==0?"checked":"");%> value="SA"  onclick="checkSuperAdmin('authorityInfo')" />
              设置该用户为超级管理员 </td>
          </tr>
          <% }%>
          <tr>
            <td height="20px;" align="right"></td>
            <td colspan="3"><span id="authorityInfo"></span></td>
          </tr>
          <tr>
            <td height="30px;" align="center" rowspan="9"valign="middle" style="font-size:15px;border:solid 1px #CCC;"><%out.print((u.getRole()==1)?"审核权限":"修改权限");%></td>
            <td colspan="3" style="border:solid #CCC;  border-width:1px 1px 0 0; height:30px; line-height:30px; padding-left:10px;"><span id="errorText">注：</span><span id="blackText">所有管理员不需要权限即可修改或删除自己发布的内容，下面的“他人”是指“其他管理员发布的”</span></td>
          </tr>
          <tr>
            <td height="30px" align="left" width="27%" style="border:solid #CCC; border-width:1px 0 1px;"><input type="checkbox" <%out.print(User.checkHaveAuthority(myAuth,User.publishNews)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.publishNews)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.publishNews %>" />
              发布新闻</td>
            <td align="left" width="27%" style="border:solid #CCC;  border-width:1px 0 1px;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.editNews)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.editNews)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.editNews %>" />
              修改他人新闻</td>
            <td align="left" width="27%" style="border:solid #CCC; border-width:1px 1px 1px 0;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.delNews)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.delNews)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.delNews%>" />
              删除他人新闻</td>
          </tr>
          <tr>
            <td height="30px" align="left" width="27%" style="border:solid #CCC; border-width:0 0 1px;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.publishInfo)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.publishInfo)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.publishInfo %>" />
              发布通知</td>
            <td align="left" width="27%" style="border:solid #CCC;  border-width:0 0 1px;"><input type="checkbox" id="userAuthority"  <%out.print(User.checkHaveAuthority(myAuth,User.editInfo)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.editInfo)?"checked":""); %> name="userAuthority" value="<%=User.editInfo %>" />
              修改他人通知</td>
            <td align="left" width="27%" style="border:solid #CCC; border-width:0 1px 1px 0;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.delInfo)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.delInfo)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.delInfo%>" />
              删除他人通知</td>
          </tr>
          <tr>
            <td height="30px" align="left" width="27%" style="border:solid #CCC; border-width:0 0 1px;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.uploadFile)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.uploadFile)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.uploadFile %>" />
              上传文件</td>
            <td align="left" width="27%" colspan="2" style="border:solid #CCC;  border-width:0 1px 1px 0;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.delFile)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.delFile)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.delFile %>" />
              删除他人文件</td>
          </tr>
          <tr>
            <td height="30px" align="left" width="27%" style="border:solid #CCC; border-width:0 0 1px;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.addLink)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.addLink)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.addLink%>" />
              添加链接</td>
            <td align="left" width="27%" style="border:solid #CCC;  border-width:0 0 1px;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.editLink)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.editLink)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.editLink %>" />
              修改他人链接</td>
            <td align="left" width="27%" style="border:solid #CCC; border-width:0 1px 1px 0;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.delLink)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.delLink)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.delLink%>" />
              删除他人链接</td>
          </tr>
          <tr>
            <td height="30px" align="left" width="27%" style="border:solid #CCC; border-width:0 0 1px;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.replyMsg)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.replyMsg)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.replyMsg%>" />
              回复留言</td>
            <td align="left" width="27%" style="border:solid #CCC;  border-width:0 0 1px;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.delMsg)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.delMsg)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.delMsg%>" />
              删除留言</td>
            <td align="left" width="27%" style="border:solid #CCC; border-width:0 1px 1px 0;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.delMsgReply)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.delMsgReply)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.delMsgReply%>" />
              删除他人的留言回复</td>
          </tr>
          <tr>
            <td height="30px" align="left" width="27%" colspan="3" style="border:solid #CCC; border-width:0 1px 1px 0;"><input type="checkbox"  <%out.print(User.checkHaveAuthority(myAuth,User.publishAffiche)?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.publishAffiche)?"checked":""); %> id="userAuthority" name="userAuthority" value="<%=User.publishAffiche%>" />
              发布后台首页公告</td>
          </tr>
          <tr>
            <td height="30px" align="left" width="27%"><input type="checkbox" id="userAuthority" name="userAuthority" <%out.print(u.getRole()==0?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.regNewUser)?"checked":""); %> value="<%=User.regNewUser%>" />
              添加用户</td>
            <td align="left" width="27%" ><input type="checkbox" id="userAuthority" name="userAuthority" <%out.print(u.getRole()==0?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.delUser)?"checked":""); %> value="<%=User.delUser%>" />
              删除用户</td>
            <td align="left" width="27%" style="border-right:solid 1px #CCC;"><input type="checkbox" id="userAuthority" name="userAuthority"  <%out.print(u.getRole()==0?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.allowNewReg)?"checked":""); %> value="<%=User.allowNewReg%>" />
              审核用户并赋予权限</td>
          </tr>
          <tr>
            <td height="30px" align="left" width="27%" colspan="3" style="border:solid #CCC; border-width:0 1px 1px 0;"><input type="checkbox" id="userAuthority" name="userAuthority"  <%out.print(u.getRole()==0?"":"disabled"); %> <%out.print(User.checkHaveAuthority(authority,User.editUserPower)?"checked":""); %> value="<%=User.editUserPower%>" />
              修改用户权限</td>
          </tr>
          <tr>
            <td height="25px"></td>
            <td align="right" style="padding-right:10px;"><input type="submit" id="blackText" name="saveUserAu" value="<%out.print((u.getRole()==1)?"确认审核":"确认修改");%>" onclick="return checkAuthority(<%=u.getRole()%>)" /></td>
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
document.getElementById("authorityInfo").innerHTML=<%=("\""+errMsg+"\"")%>;
//-->
</script>
<%
session.setAttribute("errMsg",new String(""));
}
%>
</body>
</html>
