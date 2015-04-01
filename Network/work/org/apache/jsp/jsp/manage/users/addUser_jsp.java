package org.apache.jsp.jsp.manage.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import user.*;

public final class addUser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"/jsp/error/error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"/css/manage.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"/css/manageContent.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<!--[if lte IE 6]>\r\n");
      out.write("<link href=\"/css/contentButtonIE6.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<![endif]-->\r\n");
      user.UserBean userBean = null;
      synchronized (_jspx_page_context) {
        userBean = (user.UserBean) _jspx_page_context.getAttribute("userBean", PageContext.PAGE_SCOPE);
        if (userBean == null){
          userBean = new user.UserBean();
          _jspx_page_context.setAttribute("userBean", userBean, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/usersManage.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/register.js\"></script>\r\n");
      out.write("<title>网工后台管理－添加用户</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

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

      out.write("\r\n");
      out.write("<!--全部区域-->\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("  <!--头部-->\r\n");
      out.write("  <div id=\"header\">\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/header.jsp", out, true);
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("  <!--主区，包括菜单区（垂直导航条）和工作区-->\r\n");
      out.write("  <div id=\"mainContent\">\r\n");
      out.write("    <div id=\"leftMenu\">\r\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/leftMenu.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"rightMain\">\r\n");
      out.write("      <div id=\"contentHeader\">\r\n");
      out.write("        <div style=\"float:left;\">&nbsp;&nbsp; 添加用户</div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div id=\"regTopTipsFrame\"> 请填写下面的内容并为该用户赋予权限： </div>\r\n");
      out.write("      <form id=\"form_editAuthority\" action=\"/jsp/manage/users/saveAuthority.jsp?saveType=0\" method=\"post\">\r\n");
      out.write("        <table width=\"100%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">电子邮件：</td>\r\n");
      out.write("            <td width=\"2%\"></td>\r\n");
      out.write("            <td width=\"23%\" align=\"left\"><input type=\"text\" name=\"email\" id=\"email\" style=\"width:150px;\" onfocus=\"onAddFocus(this.id,'email_tips')\" onblur=\"onAddBlur(id,'email_tips')\" /></td>\r\n");
      out.write("            <td width=\"55%\" align=\"left\"><span id=\"email_tips\"></span></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">用户名：</td>\r\n");
      out.write("            <td width=\"2%\"></td>\r\n");
      out.write("            <td width=\"23%\" align=\"left\"><input type=\"text\" name=\"name\" id=\"name\" style=\"width:150px;\" onfocus=\"onAddFocus(this.id,'name_tips')\" onblur=\"onAddBlur(id,'name_tips')\" /></td>\r\n");
      out.write("            <td width=\"55%\" align=\"left\"><span id=\"name_tips\"></span></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">密码：</td>\r\n");
      out.write("            <td width=\"2%\"></td>\r\n");
      out.write("            <td width=\"23%\" align=\"left\"><input type=\"password\" name=\"password\" id=\"password\" style=\"width:150px;\" onfocus=\"onAddFocus(this.id,'password_tips')\" onblur=\"onAddBlur(id,'password_tips')\" /></td>\r\n");
      out.write("            <td width=\"55%\" align=\"left\"><span id=\"password_tips\"></span></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">确认密码：</td>\r\n");
      out.write("            <td width=\"2%\"></td>\r\n");
      out.write("            <td width=\"23%\" align=\"left\"><input type=\"password\" name=\"password2\" id=\"password2\" style=\"width:150px;\" onfocus=\"onAddFocus(this.id,'password2_tips')\" onblur=\"onAddBlur(id,'password2_tips')\" /></td>\r\n");
      out.write("            <td width=\"55%\" align=\"left\"><span id=\"password2_tips\"></span></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"10px\" colspan=\"4\"></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <table width=\"100%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" id=\"blackText\">\r\n");
      out.write("         <tr>\r\n");
      out.write("            <td height=\"30px;\"></td>\r\n");
      out.write("            <td align=\"left\" colspan=\"3\" style=\"color:#006699\"><input type=\"checkbox\" id=\"setSuperAdmin\" name=\"setSuperAdmin\" value=\"SA\" onclick=\"checkSuperAdmin('addErrInfo')\" />\r\n");
      out.write("              设置该用户为超级管理员 </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px;\" align=\"center\" rowspan=\"9\"valign=\"middle\" style=\"font-size:15px;border:solid 1px #CCC;\">赋予权限</td>\r\n");
      out.write("            <td colspan=\"3\" style=\"border:solid #CCC;  border-width:1px 1px 0 0; height:30px; line-height:30px; padding-left:10px;\"><span id=\"errorText\">注：</span><span id=\"blackText\">所有管理员不需要权限即可修改或删除自己发布的内容，下面的“他人”是指“其他管理员发布的”</span></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px\" align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:1px 0 1px;\"><input type=\"checkbox\" ");
out.print(User.checkHaveAuthority(myAuth,User.publishNews)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(oldAu,User.publishNews)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.publishNews );
      out.write("\" />\r\n");
      out.write("              发布新闻</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border:solid #CCC;  border-width:1px 0 1px;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.editNews)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(oldAu,User.editNews)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.editNews );
      out.write("\" />\r\n");
      out.write("              修改他人新闻</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:1px 1px 1px 0;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.delNews)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(oldAu,User.delNews)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.delNews);
      out.write("\" />\r\n");
      out.write("              删除他人新闻</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px\" align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:0 0 1px;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.publishInfo)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(oldAu,User.publishInfo)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.publishInfo );
      out.write("\" />\r\n");
      out.write("              发布通知</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border:solid #CCC;  border-width:0 0 1px;\"><input type=\"checkbox\" id=\"userAuthority\"  ");
out.print(User.checkHaveAuthority(myAuth,User.editInfo)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(oldAu,User.editInfo)?"checked":""); 
      out.write(" name=\"userAuthority\" value=\"");
      out.print(User.editInfo );
      out.write("\" />\r\n");
      out.write("              修改他人通知</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:0 1px 1px 0;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.delInfo)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(oldAu,User.delInfo)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.delInfo);
      out.write("\" />\r\n");
      out.write("              删除他人通知</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px\" align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:0 0 1px;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.uploadFile)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(oldAu,User.uploadFile)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.uploadFile );
      out.write("\" />\r\n");
      out.write("              上传文件</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" colspan=\"2\" style=\"border:solid #CCC;  border-width:0 1px 1px 0;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.delFile)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(oldAu,User.delFile)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.delFile );
      out.write("\" />\r\n");
      out.write("              删除他人文件</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px\" align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:0 0 1px;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.addLink)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(oldAu,User.addLink)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.addLink);
      out.write("\" />\r\n");
      out.write("              添加链接</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border:solid #CCC;  border-width:0 0 1px;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.editLink)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(oldAu,User.editLink)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.editLink );
      out.write("\" />\r\n");
      out.write("              修改他人链接</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:0 1px 1px 0;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.delLink)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(oldAu,User.delLink)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.delLink);
      out.write("\" />\r\n");
      out.write("              删除他人链接</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px\" align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:0 0 1px;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.replyMsg)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(oldAu,User.replyMsg)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.replyMsg);
      out.write("\" />\r\n");
      out.write("              回复留言</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border:solid #CCC;  border-width:0 0 1px;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.delMsg)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(oldAu,User.delMsg)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.delMsg);
      out.write("\" />\r\n");
      out.write("              删除留言</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:0 1px 1px 0;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.delMsgReply)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(oldAu,User.delMsgReply)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.delMsgReply);
      out.write("\" />\r\n");
      out.write("              删除他人的留言回复</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px\" align=\"left\" width=\"27%\" colspan=\"3\" style=\"border:solid #CCC; border-width:0 1px 1px 0;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.publishAffiche)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(oldAu,User.publishAffiche)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.publishAffiche);
      out.write("\" />\r\n");
      out.write("              发布后台首页公告</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px\" align=\"left\" width=\"27%\"><input type=\"checkbox\" id=\"userAuthority\" name=\"userAuthority\"  disabled ");
out.print(User.checkHaveAuthority(oldAu,User.regNewUser)?"checked":""); 
      out.write(" value=\"");
      out.print(User.regNewUser);
      out.write("\" />\r\n");
      out.write("              添加用户</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" ><input type=\"checkbox\" id=\"userAuthority\" name=\"userAuthority\" disabled ");
out.print(User.checkHaveAuthority(oldAu,User.delUser)?"checked":""); 
      out.write(" value=\"");
      out.print(User.delUser);
      out.write("\" />\r\n");
      out.write("              删除用户</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border-right:solid 1px #CCC;\"><input type=\"checkbox\" id=\"userAuthority\" name=\"userAuthority\" disabled ");
out.print(User.checkHaveAuthority(oldAu,User.allowNewReg)?"checked":""); 
      out.write(" value=\"");
      out.print(User.allowNewReg);
      out.write("\" />\r\n");
      out.write("              审核用户并赋予权限</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px\" align=\"left\" width=\"27%\" colspan=\"3\" style=\"border:solid #CCC; border-width:0 1px 1px 0;\"><input type=\"checkbox\" id=\"userAuthority\" name=\"userAuthority\" disabled ");
out.print(User.checkHaveAuthority(oldAu,User.editUserPower)?"checked":""); 
      out.write(" value=\"");
      out.print(User.editUserPower);
      out.write("\" />\r\n");
      out.write("              修改用户权限</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"20%\" height=\"20px\">&nbsp;</td>\r\n");
      out.write("            <td height=\"20px\"id=\"regItemName\" align=\"left\" colspan=\"3\"><span class=\"regErrMsg\" id=\"addErrInfo\"></span></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"25px\"></td>\r\n");
      out.write("            <td align=\"right\" style=\"padding-right:10px;\"><a name=\"showErrInfo\" id=\"showErrInfo\"></a><input type=\"submit\" id=\"blackText\" name=\"saveUserAu\" value=\"添加\" onclick=\"return (checkAddUser()&&checkAddUserAuthority(0))\" /></td>\r\n");
      out.write("            <td align=\"left\" style=\"padding-left:10px;\"><input type=\"reset\" name=\"reset\" id=\"blackText\" value=\"重置\" /></td>\r\n");
      out.write("            <td></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div id=\"bottom\">\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/bottom.jsp", out, true);
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("document.getElementById(\"addErrInfo\").innerHTML=");
      out.print(("\""+errMsg+"\""));
      out.write(";\r\n");
      out.write("document.getElementById(\"email\").value=");
      out.print(("\""+oldEmail+"\""));
      out.write(";\r\n");
      out.write("document.getElementById(\"name\").value=");
      out.print(("\""+oldName+"\""));
      out.write(";\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");

session.setAttribute("errMsg",new String(""));
}

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
