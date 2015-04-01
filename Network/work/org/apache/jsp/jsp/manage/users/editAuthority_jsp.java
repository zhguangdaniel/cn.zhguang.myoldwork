package org.apache.jsp.jsp.manage.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import user.*;

public final class editAuthority_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>网工后台管理－用户权限管理</title>\r\n");
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
      out.write("        <div style=\"float:left;\">&nbsp;&nbsp;\r\n");
      out.write("          ");
out.print((u.getRole()==1)?"审核用户：":"修改权限：");
      out.write("\r\n");
      out.write("           ");
out.print((u.getRole()==0)?"":"(你只能为他人赋予你已经拥有的权限)");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <form id=\"form_editAuthority\" action=\"/jsp/manage/users/saveAuthority.jsp?saveType=");
out.print((u.getRole()==1)?"1":"2");
      out.write("&email=");
      out.print(email );
      out.write("\" method=\"post\">\r\n");
      out.write("        <table width=\"100%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" id=\"blackText\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px;\" width=\"19%\" align=\"right\" style=\"padding-right:10px;\">用户名称：</td>\r\n");
      out.write("            <td align=\"left\"  colspan=\"3\">");

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
        
      out.write("\r\n");
      out.write("              )</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px;\" align=\"right\" style=\"padding-right:10px;\">Eamil：</td>\r\n");
      out.write("            <td align=\"left\" colspan=\"3\">");
      out.print(u.getEmail() );
      out.write("</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          ");

        if(u.getRole()==1){
        
      out.write("\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px;\" align=\"right\" style=\"padding-right:10px;\">注册时间：</td>\r\n");
      out.write("            <td align=\"left\" colspan=\"3\">");
      out.print(u.getRegTime().substring(0,16) );
      out.write("</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px;\" align=\"right\" style=\"padding-right:10px;\">身份确认信息：</td>\r\n");
      out.write("            <td align=\"left\"  colspan=\"3\">");
      out.print(u.getRegUserInfo());
      out.write("</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px;\"></td>\r\n");
      out.write("            <td align=\"left\" colspan=\"3\" style=\"color:#006699\"><input type=\"checkbox\" id=\"notPass\" name=\"notPass\" value=\"NP\" onclick=\"checkNotPass()\" />\r\n");
      out.write("              不批准该用户成为管理员&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" id=\"setSuperAdmin\" name=\"setSuperAdmin\" ");
out.print(u.getRole()==0?"checked":"");
      out.write(" value=\"SA\" onclick=\"checkSuperAdmin('authorityInfo')\" />设置该用户为超级管理员\r\n");
      out.write("              </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          ");
 
        }else{
        
      out.write("\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px;\" align=\"right\" style=\"padding-right:10px;\">用户信息：</td>\r\n");
      out.write("            <td align=\"left\" colspan=\"3\">共登录：");
      out.print(u.getLogCount() );
      out.write("次，上次登录时间：");
      out.print(u.getLastLogTime().substring(0,16));
      out.write("</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px;\"></td>\r\n");
      out.write("            <td align=\"left\" colspan=\"3\" style=\"color:#006699\"><input type=\"checkbox\" id=\"setSuperAdmin\" name=\"setSuperAdmin\" ");
out.print(u.getRole()==0?"checked":"");
      out.write(" value=\"SA\"  onclick=\"checkSuperAdmin('authorityInfo')\" />\r\n");
      out.write("              设置该用户为超级管理员 </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          ");
 }
      out.write("\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"20px;\" align=\"right\"></td>\r\n");
      out.write("            <td colspan=\"3\"><span id=\"authorityInfo\"></span></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px;\" align=\"center\" rowspan=\"9\"valign=\"middle\" style=\"font-size:15px;border:solid 1px #CCC;\">");
out.print((u.getRole()==1)?"审核权限":"修改权限");
      out.write("</td>\r\n");
      out.write("            <td colspan=\"3\" style=\"border:solid #CCC;  border-width:1px 1px 0 0; height:30px; line-height:30px; padding-left:10px;\"><span id=\"errorText\">注：</span><span id=\"blackText\">所有管理员不需要权限即可修改或删除自己发布的内容，下面的“他人”是指“其他管理员发布的”</span></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px\" align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:1px 0 1px;\"><input type=\"checkbox\" ");
out.print(User.checkHaveAuthority(myAuth,User.publishNews)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.publishNews)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.publishNews );
      out.write("\" />\r\n");
      out.write("              发布新闻</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border:solid #CCC;  border-width:1px 0 1px;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.editNews)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.editNews)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.editNews );
      out.write("\" />\r\n");
      out.write("              修改他人新闻</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:1px 1px 1px 0;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.delNews)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.delNews)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.delNews);
      out.write("\" />\r\n");
      out.write("              删除他人新闻</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px\" align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:0 0 1px;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.publishInfo)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.publishInfo)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.publishInfo );
      out.write("\" />\r\n");
      out.write("              发布通知</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border:solid #CCC;  border-width:0 0 1px;\"><input type=\"checkbox\" id=\"userAuthority\"  ");
out.print(User.checkHaveAuthority(myAuth,User.editInfo)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.editInfo)?"checked":""); 
      out.write(" name=\"userAuthority\" value=\"");
      out.print(User.editInfo );
      out.write("\" />\r\n");
      out.write("              修改他人通知</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:0 1px 1px 0;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.delInfo)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.delInfo)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.delInfo);
      out.write("\" />\r\n");
      out.write("              删除他人通知</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px\" align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:0 0 1px;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.uploadFile)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.uploadFile)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.uploadFile );
      out.write("\" />\r\n");
      out.write("              上传文件</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" colspan=\"2\" style=\"border:solid #CCC;  border-width:0 1px 1px 0;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.delFile)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.delFile)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.delFile );
      out.write("\" />\r\n");
      out.write("              删除他人文件</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px\" align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:0 0 1px;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.addLink)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.addLink)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.addLink);
      out.write("\" />\r\n");
      out.write("              添加链接</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border:solid #CCC;  border-width:0 0 1px;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.editLink)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.editLink)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.editLink );
      out.write("\" />\r\n");
      out.write("              修改他人链接</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:0 1px 1px 0;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.delLink)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.delLink)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.delLink);
      out.write("\" />\r\n");
      out.write("              删除他人链接</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px\" align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:0 0 1px;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.replyMsg)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.replyMsg)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.replyMsg);
      out.write("\" />\r\n");
      out.write("              回复留言</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border:solid #CCC;  border-width:0 0 1px;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.delMsg)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.delMsg)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.delMsg);
      out.write("\" />\r\n");
      out.write("              删除留言</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border:solid #CCC; border-width:0 1px 1px 0;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.delMsgReply)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.delMsgReply)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.delMsgReply);
      out.write("\" />\r\n");
      out.write("              删除他人的留言回复</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px\" align=\"left\" width=\"27%\" colspan=\"3\" style=\"border:solid #CCC; border-width:0 1px 1px 0;\"><input type=\"checkbox\"  ");
out.print(User.checkHaveAuthority(myAuth,User.publishAffiche)?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.publishAffiche)?"checked":""); 
      out.write(" id=\"userAuthority\" name=\"userAuthority\" value=\"");
      out.print(User.publishAffiche);
      out.write("\" />\r\n");
      out.write("              发布后台首页公告</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px\" align=\"left\" width=\"27%\"><input type=\"checkbox\" id=\"userAuthority\" name=\"userAuthority\" ");
out.print(u.getRole()==0?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.regNewUser)?"checked":""); 
      out.write(" value=\"");
      out.print(User.regNewUser);
      out.write("\" />\r\n");
      out.write("              添加用户</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" ><input type=\"checkbox\" id=\"userAuthority\" name=\"userAuthority\" ");
out.print(u.getRole()==0?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.delUser)?"checked":""); 
      out.write(" value=\"");
      out.print(User.delUser);
      out.write("\" />\r\n");
      out.write("              删除用户</td>\r\n");
      out.write("            <td align=\"left\" width=\"27%\" style=\"border-right:solid 1px #CCC;\"><input type=\"checkbox\" id=\"userAuthority\" name=\"userAuthority\"  ");
out.print(u.getRole()==0?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.allowNewReg)?"checked":""); 
      out.write(" value=\"");
      out.print(User.allowNewReg);
      out.write("\" />\r\n");
      out.write("              审核用户并赋予权限</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"30px\" align=\"left\" width=\"27%\" colspan=\"3\" style=\"border:solid #CCC; border-width:0 1px 1px 0;\"><input type=\"checkbox\" id=\"userAuthority\" name=\"userAuthority\"  ");
out.print(u.getRole()==0?"":"disabled"); 
      out.write(' ');
out.print(User.checkHaveAuthority(authority,User.editUserPower)?"checked":""); 
      out.write(" value=\"");
      out.print(User.editUserPower);
      out.write("\" />\r\n");
      out.write("              修改用户权限</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td height=\"25px\"></td>\r\n");
      out.write("            <td align=\"right\" style=\"padding-right:10px;\"><input type=\"submit\" id=\"blackText\" name=\"saveUserAu\" value=\"");
out.print((u.getRole()==1)?"确认审核":"确认修改");
      out.write("\" onclick=\"return checkAuthority(");
      out.print(u.getRole());
      out.write(")\" /></td>\r\n");
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
      out.write("document.getElementById(\"authorityInfo\").innerHTML=");
      out.print(("\""+errMsg+"\""));
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
