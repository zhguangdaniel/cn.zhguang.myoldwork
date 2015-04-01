package org.apache.jsp.jsp.manage.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import database.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"/css/manage.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/managerLogin.js\"></script>\r\n");

	String loginMsg = null;
	try {
		loginMsg = (String) session.getAttribute("loginMsg");
	} catch (Exception e) {
	}
	if (loginMsg == null) {
		loginMsg = "";
	}

      out.write("\r\n");
      out.write("<div id=\"loginFrame\">\r\n");
      out.write("    <form id=\"form_login\" action=\"/jsp/manage/users/doLogin.jsp\" method=\"post\">\r\n");
      out.write("        <table width=\"100%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td colspan=\"2\" height=\"30px\" id=\"bar\" style=\"text-align:center;\">管理员登录</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td colspan=\"2\" height=\"20px\" style=\"border:solid #CCC; border-width:0 1px 0;\">&nbsp;</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td width=\"50px\" height=\"30px\" align=\"center\" id=\"blackText\" style=\" border-left:solid 1px #CCC;\">邮箱</td>\r\n");
      out.write("                <td width=\"250px\" align=\"left\" height=\"30px\"style=\" border-right:solid 1px #CCC;\"><input type=\"text\" name=\"email\" id=\"email\" style=\"width:230px\" /></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td width=\"50px\" height=\"30px\" align=\"center\" id=\"blackText\" style=\" border-left:solid 1px #CCC;\">密码:</td>\r\n");
      out.write("                <td width=\"250px\" height=\"30px\" align=\"left\"  style=\" border-right:solid 1px #CCC;\"><input type=\"password\" name=\"password\" id=\"password\" style=\"width:230px\"/></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td colspan=\"2\" height=\"16px\" align=\"center\" style=\"border:solid #CCC; border-width:0 1px 0;\"><div class=\"loginMsgFrame\" id=\"loginInfo\"></div></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td colspan=\"2\" align=\"center\" height=\"30px\" style=\"border:solid #CCC; border-width:0 1px 0;\"><input type=\"submit\" id=\"blackText\" value=\"登录\" onClick=\"return checkLogin()\">&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"reset\" name=\"reset\" id=\"blackText\" value=\"重置\" /></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td colspan=\"2\" align=\"center\" height=\"30px\" style=\"border:solid #CCC; border-width:0 1px 1px;\"><a href=\"/jsp/manage/users/register.jsp\" target=\"_self\" class=\"normalLink\">管理员注册</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"/\" target=\"_self\" class=\"normalLink\">返回前台首页</a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("\tdocument.getElementById(\"loginInfo\").innerHTML=\"<font color='#FF0000' size='-1' face='Arial, 宋体'>\"+");
      out.print(("\""+loginMsg+"\""));
      out.write("+\"</font>\";\r\n");
      out.write("\tdocument.getElementById(\"password\").focus();\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
	
loginMsg = "";
session.setAttribute("loginMsg",new String(""));

      out.write('\r');
      out.write('\n');
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
