package org.apache.jsp.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class userInfoFrame_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			"", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"/css/main.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/login.js\"></script>\r\n");
      out.write("<div class=\"bar\">用户</div>\r\n");
      out.write("<div class=\"userInfoContent\">\r\n");
      out.write("  ");

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

      out.write("\r\n");
      out.write("  <table align=\"center\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td width=\"40%\" align=\"right\" valign=\"middle\"><img class=\"borderImg\" src=\"");
      out.print(userIconPath);
      out.write("\" width=\"50px\" height=\"50px\" /></td>\r\n");
      out.write("      <td id=\"blackText\" style=\" padding-left:20px\"><span class=\"nameInUserInfo\">");
      out.print(userName);
      out.write("</span>\r\n");
      out.write("      <br />\r\n");
      out.write("      欢迎回来！</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td id=\"blackText\" style=\"padding-left:30px;\" colspan=\"2\" height=\"45px\">有&nbsp;<span class=\"bigNum\">");
      out.print(attentionMeNum );
      out.write("</span>&nbsp;人关注您</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("  </table>\r\n");
      out.write("  ");

	}//if
	else {

      out.write("\r\n");
      out.write("  <form id=\"form_login\" method=\"post\" action=\"/jsp/user/doLogin.jsp\">\r\n");
      out.write("    <table align=\"center\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\" height=\"20px\" valign=\"top\" id=\"blackText\">您尚未登录：</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\" align=\"center\"><a href=\"/register\" class=\"regBtn\"></a></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"30%\" height=\"30px\" align=\"center\" id=\"blackText\">邮箱</td>\r\n");
      out.write("        <td width=\"70%\" align=\"left\" height=\"30px\"><input type=\"text\" name=\"email\" id=\"email\" style=\"width:120px\" /></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"30%\" height=\"30px\" align=\"center\" id=\"blackText\">密码</td>\r\n");
      out.write("        <td width=\"70%\" height=\"30px\" align=\"left\"><input type=\"password\" name=\"password\" id=\"password\" style=\"width:120px\" /></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\" height=\"20px\"><div class=\"loginErrMsgFrame\" id=\"errInfo\"></div></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\" align=\"center\" valign=\"top\">\r\n");
      out.write("        <input type=\"submit\" onclick=\"return checkLogin()\" class=\"loginBtn\" value=\"\" style=\"border:0\" />\r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("  </form>\r\n");
      out.write("  ");

}//else

      out.write("\r\n");
      out.write("  <script language=\"javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("document.getElementById(\"errInfo\").innerHTML=");
      out.print(("\""+errMsg+"\""));
      out.write(";\r\n");
      out.write("document.getElementById(\"email\").innerText =");
      out.print(("\""+oldEmail+"\""));
      out.write(";\r\n");
      out.write("document.getElementById(\"password\").innerText =");
      out.print(("\""+oldPassword+"\""));
      out.write(";\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("  ");

if(errMsg.equals("用户不存在！")){

      out.write("\r\n");
      out.write("  <script language=\"javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("document.getElementById(\"email\").focus();\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("  ");
	
}
else if(errMsg.equals("密码错误！")){

      out.write("\r\n");
      out.write("  <script language=\"javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("document.getElementById(\"password\").focus();\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("  ");
	
}
errMsg = "";
session.setAttribute("errMsg",new String(""));

      out.write("\r\n");
      out.write("</div>\r\n");
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
