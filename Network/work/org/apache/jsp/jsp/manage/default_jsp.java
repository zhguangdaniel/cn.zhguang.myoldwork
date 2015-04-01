package org.apache.jsp.jsp.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import user.*;
import database.*;

public final class default_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      user.UserBean userBean = null;
      synchronized (_jspx_page_context) {
        userBean = (user.UserBean) _jspx_page_context.getAttribute("userBean", PageContext.PAGE_SCOPE);
        if (userBean == null){
          userBean = new user.UserBean();
          _jspx_page_context.setAttribute("userBean", userBean, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      message.MsgBean msgBean = null;
      synchronized (_jspx_page_context) {
        msgBean = (message.MsgBean) _jspx_page_context.getAttribute("msgBean", PageContext.PAGE_SCOPE);
        if (msgBean == null){
          msgBean = new message.MsgBean();
          _jspx_page_context.setAttribute("msgBean", msgBean, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/manage.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/register.js\"></script>\r\n");
      out.write("<title>网工教学网站－后台管理</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!--全部区域-->\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("  ");

	boolean isLog = false;
	try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
if (!isLog) {

      out.write("\r\n");
      out.write("  <!--头部-->\r\n");
      out.write("  <div id=\"header\"> </div>\r\n");
      out.write("  <!--主区，包括登录区-->\r\n");
      out.write("  <div id=\"mainContent\" style=\"border:solid 1px #069; width:998px;\">\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/users/login.jsp", out, true);
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("  ");

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

      out.write("\r\n");
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
      out.write("      ");

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
		
      out.write("\r\n");
      out.write("      <div class=\"defaultPageFrame\">\r\n");
      out.write("        <div class=\"defaultPageTitle\"> 公告:");
if(User.checkHaveAuthority(auth,User.publishAffiche)){ 
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:showHide('addAfficheFrame');\" class=\"normalLink\" style=\"font-weight:lighter\">发布公告</a>&nbsp;&nbsp;<a href=\"/jsp/manage/affiche/clearAffiche.jsp\" class=\"normalLink\" style=\"font-weight:lighter\" onclick=\" return onClear()\">清空公告</a> ");
} 
      out.write("</div>\r\n");
      out.write("        <div class=\"defaultPageContent\">\r\n");
      out.write("          ");
if(affiche==null||affiche.equals("")){
        	out.print("无内容...");
       		}else{
      		 	out.print(affiche);
      out.write("\r\n");
      out.write("          <br />\r\n");
      out.write("          <br />\r\n");
      out.write("          <font color=\"#999999\">发布者：");
      out.print(creator );
      out.write("&nbsp;&nbsp;于：");
      out.print(createTime.substring(0,16) );
      out.write("</font>\r\n");
      out.write("          ");
}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"publishAfficheFrame\" id=\"addAfficheFrame\">\r\n");
      out.write("          <form name=\"form_addAffiche\" method=\"post\" action=\"/jsp/manage/affiche/addAffiche.jsp\">\r\n");
      out.write("            <table border=\"0\" cellpadding=\"0\" cellspacing=\"5\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"80px\" valign=\"top\"align=\"right\">公告内容：</td>\r\n");
      out.write("                <td  width=\"480px\"><textarea name=\"affiche\" id=\"affiche\" style=\"width:480px;height:120px; font-family: Arial, '宋体'; font-size:13px;\"></textarea></td>\r\n");
      out.write("                <td></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td></td>\r\n");
      out.write("                <td><input name=\"addAffiche\" type=\"submit\" value=\"保存\" onclick=\"return checkReplyLength('affiche')\" />\r\n");
      out.write("                  <input type=\"reset\" name=\"reset\" value=\"重置\" /></td>\r\n");
      out.write("                <td></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("          </form>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"defaultPageFrame\">\r\n");
      out.write("        <div class=\"defaultPageTitle\"> 个人信息:&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:showEditUserInfo();\" class=\"normalLink\" style=\"font-weight:lighter\">修改个人资料</a>&nbsp;&nbsp;<a href=\"javascript:showEditPwd();\" class=\"normalLink\" style=\"font-weight:lighter\">修改密码</a></div>\r\n");
      out.write("        <div class=\"defaultPageContent\" id=\"showUserInfo\" style=\"display:block;\">\r\n");
      out.write("          <table width=\"100%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td height=\"30px;\" width=\"20%\" align=\"right\">用户名称：</td>\r\n");
      out.write("              <td align=\"left\" style=\"padding-left:10px;\">");

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
        
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td height=\"30px;\" align=\"right\">Eamil：</td>\r\n");
      out.write("              <td align=\"left\" style=\"padding-left:10px;\">");
      out.print(u.getEmail() );
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td height=\"30px;\" align=\"right\">注册时间：</td>\r\n");
      out.write("              <td align=\"left\" style=\"padding-left:10px;\">");
      out.print(u.getRegTime().substring(0,16) );
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td height=\"30px;\" align=\"right\">登录次数：</td>\r\n");
      out.write("              <td align=\"left\" style=\"padding-left:10px;\">");
      out.print(u.getLogCount() );
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td height=\"30px;\" align=\"right\">上次登录时间：</td>\r\n");
      out.write("              <td align=\"left\" style=\"padding-left:10px;\">");
      out.print(u.getLastLogTime().substring(0,16));
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td height=\"30px;\" align=\"right\">身份信息：</td>\r\n");
      out.write("              <td align=\"left\" style=\"padding-left:10px;\">");
      out.print(u.getRegUserInfo());
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"defaultPageContent\" id=\"editUserInfo\"  style=\"display:none;\">\r\n");
      out.write("          <form id=\"form_editUserInfo\" action=\"/jsp/manage/users/saveAuthority.jsp?saveType=3&email=");
      out.print(u.getEmail() );
      out.write("\" method=\"post\">\r\n");
      out.write("            <table width=\"100%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">Email：</td>\r\n");
      out.write("                <td width=\"2%\"></td>\r\n");
      out.write("                <td width=\"23%\" align=\"left\">");
      out.print(u.getEmail() );
      out.write("</td>\r\n");
      out.write("                <td width=\"55%\" align=\"left\"></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">用户名：</td>\r\n");
      out.write("                <td width=\"2%\"></td>\r\n");
      out.write("                <td width=\"23%\" align=\"left\"><input type=\"text\" name=\"name\" id=\"name\" style=\"width:150px;\" value=\"");
      out.print(u.getName() );
      out.write("\" onfocus=\"onEditFocus(this.id,'name_tips')\" onblur=\"onEditBlur(id,'name_tips')\" /></td>\r\n");
      out.write("                <td width=\"55%\" align=\"left\"><span id=\"name_tips\"></span></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">密码提示问题：</td>\r\n");
      out.write("                <td width=\"2%\"></td>\r\n");
      out.write("                <td width=\"23%\" align=\"left\"><input type=\"text\" name=\"passwordQuestion\" id=\"passwordQuestion\" style=\"width:150px;\" value=\"");
      out.print(u.getPasswordQuestion() );
      out.write("\" onfocus=\"onEditFocus(this.id,'passwordQuestion_tips')\" onblur=\"onEditBlur(id,'passwordQuestion_tips')\" /></td>\r\n");
      out.write("                <td width=\"55%\" align=\"left\"><span id=\"passwordQuestion_tips\"></span></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">提示问题回答：</td>\r\n");
      out.write("                <td width=\"2%\"></td>\r\n");
      out.write("                <td width=\"23%\" align=\"left\"><input type=\"text\" name=\"passwordAnswer\" id=\"passwordAnswer\" style=\"width:150px;\" value=\"");
      out.print(u.getPasswordAnswer() );
      out.write("\"  onfocus=\"onEditFocus(this.id,'passwordAnswer_tips')\" onblur=\"onEditBlur(id,'passwordAnswer_tips')\"/></td>\r\n");
      out.write("                <td width=\"55%\" align=\"left\"><span id=\"passwordAnswer_tips\"></span></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"20%\" height=\"35px\" id=\"regItemName\" align=\"right\" valign=\"top\">身份信息：</td>\r\n");
      out.write("                <td width=\"2%\"></td>\r\n");
      out.write("                <td align=\"left\"><textarea id=\"regUserInfo\" name=\"regUserInfo\" style=\"width:100%; color:#000; height:50px; font-family: Arial, '宋体'; font-size:13px;\" onfocus=\"onEditFocus(this.id,'regUserInfo_tips')\" onblur=\"onEditBlur(id,'regUserInfo_tips')\">");
      out.print(u.getRegUserInfo() );
      out.write("</textarea></td>\r\n");
      out.write("                <td width=\"55%\" align=\"left\" style=\"padding-left:20px;\"><span id=\"regUserInfo_tips\"></span></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"20%\" height=\"20px\">&nbsp;</td>\r\n");
      out.write("                <td height=\"20px\" id=\"regItemName\" align=\"left\" colspan=\"3\"><span class=\"regErrMsg\" id=\"editErrInfo\"></span></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"20%\" height=\"35px\">&nbsp;</td>\r\n");
      out.write("                <td width=\"2%\" height=\"35px\">&nbsp;</td>\r\n");
      out.write("                <td height=\"35px\"align=\"left\" colspan=\"2\"><input type=\"submit\" id=\"blackText\" value=\"提交\" onclick=\"return checkEditUser()\" />\r\n");
      out.write("                  <input type=\"reset\" id=\"blackText\" value=\"重置\"></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("          </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"defaultPageContent\" id=\"editPassword\" style=\"display:none;\">\r\n");
      out.write("          <form id=\"form_editPassword\" action=\"/jsp/manage/users/saveAuthority.jsp?saveType=4&email=");
      out.print(u.getEmail() );
      out.write("\" method=\"post\">\r\n");
      out.write("            <table width=\"100%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">输入旧密码：</td>\r\n");
      out.write("                <td width=\"2%\"></td>\r\n");
      out.write("                <td width=\"23%\" align=\"left\"><input type=\"password\" name=\"oldPwd\" id=\"oldPwd\" style=\"width:150px;\" onfocus=\"onEditPwdFocus(this.id,'oldPwd_tips')\" onblur=\"onEditPwdBlur(id,'oldPwd_tips')\" /></td>\r\n");
      out.write("                <td width=\"55%\" align=\"left\"><span id=\"oldPwd_tips\"></span></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">输入新密码：</td>\r\n");
      out.write("                <td width=\"2%\"></td>\r\n");
      out.write("                <td width=\"23%\" align=\"left\"><input type=\"password\" name=\"password\" id=\"password\" style=\"width:150px;\" onfocus=\"onEditPwdFocus(this.id,'password_tips')\" onblur=\"onEditPwdBlur(id,'password_tips')\" /></td>\r\n");
      out.write("                <td width=\"55%\" align=\"left\"><span id=\"password_tips\"></span></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">确认新密码：</td>\r\n");
      out.write("                <td width=\"2%\"></td>\r\n");
      out.write("                <td width=\"23%\" align=\"left\"><input type=\"password\" name=\"password2\" id=\"password2\" style=\"width:150px;\" onfocus=\"onEditPwdFocus(this.id,'password2_tips')\" onblur=\"onEditPwdBlur(id,'password2_tips')\" /></td>\r\n");
      out.write("                <td width=\"55%\" align=\"left\"><span id=\"password2_tips\"></span></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"20%\" height=\"20px\">&nbsp;</td>\r\n");
      out.write("                <td height=\"20px\" id=\"regItemName\" align=\"left\" colspan=\"3\"><span class=\"regErrMsg\" id=\"editPwdInfo\"></span></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"20%\" height=\"35px\">&nbsp;</td>\r\n");
      out.write("                <td width=\"2%\" height=\"35px\">&nbsp;</td>\r\n");
      out.write("                <td height=\"35px\"align=\"left\" colspan=\"2\"><input type=\"submit\" id=\"blackText\" value=\"提交\" onclick=\"return checkEditPwd()\" />\r\n");
      out.write("                  <input type=\"reset\" id=\"blackText\" value=\"重置\"></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("          </form>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"defaultPageFrame\">\r\n");
      out.write("        <div class=\"defaultPageTitle\"> 网站动态:</div>\r\n");
      out.write("        <div class=\"defaultPageContent\"> \r\n");
      out.write("        ");

		int noReplyMsgsCount =msgBean.getMsgsCountWithNoReply();
		if(noReplyMsgsCount==0||!User.checkHaveAuthority(auth,User.replyMsg)){
        	out.print("无动态...");
       		}else{
      		
      out.write("\r\n");
      out.write("        有<a href=\"/jsp/manage/msgManage/msg.jsp?page=1\" target=\"_self\" class=\"normalLink\">");
      out.print( noReplyMsgsCount);
      out.write("条留言</a>没有回复 \r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <script language=\"javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("var errInfo = \"");
      out.print(errMsg);
      out.write("\";\r\n");
      out.write("if(errInfo!=\"\")\r\n");
      out.write("\talert(errInfo);\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("  ");

session.setAttribute("errMsg",new String(""));
}//else

      out.write("\r\n");
      out.write("  <div id=\"bottom\">\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/bottom.jsp", out, true);
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
