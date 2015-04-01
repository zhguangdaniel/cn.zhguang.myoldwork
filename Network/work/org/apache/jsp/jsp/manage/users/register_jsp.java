package org.apache.jsp.jsp.manage.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>网工－管理员注册</title>\r\n");
      out.write("<link href=\"/css/manage.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"/css/manageContent.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/register.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

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

      out.write("\r\n");
      out.write("<!--主体容器container-->\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("  <!--头部-->\r\n");
      out.write("  <div id=\"header\"> </div>\r\n");
      out.write("  <!--主区，包括登录区-->\r\n");
      out.write("  <div id=\"mainContent\" style=\"border:solid 1px #069; width:998px;\">\r\n");
      out.write("    <div id=\"regFrame\">\r\n");
      out.write("      <div id=\"regTopTipsFrame\"> 欢迎注册，请填写以下内容，打*的是必填项： </div>\r\n");
      out.write("      <div id=\"regTable\">\r\n");
      out.write("        <form id=\"form_reg\" action=\"/jsp/manage/users/doRegist.jsp\" method=\"post\">\r\n");
      out.write("          <table width=\"100%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">电子邮件：</td>\r\n");
      out.write("              <td width=\"2%\"></td>\r\n");
      out.write("              <td width=\"23%\" align=\"left\"><input type=\"text\" name=\"email\" id=\"email\" style=\"width:150px;\" onfocus=\"onRegFocus(this.id,'email_tips')\" onblur=\"onRegBlur(id,'email_tips')\" />\r\n");
      out.write("                *</td>\r\n");
      out.write("              <td width=\"55%\" align=\"left\"><span id=\"email_tips\"></span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">用户名：</td>\r\n");
      out.write("              <td width=\"2%\"></td>\r\n");
      out.write("              <td width=\"23%\" align=\"left\"><input type=\"text\" name=\"name\" id=\"name\" style=\"width:150px;\" onfocus=\"onRegFocus(this.id,'name_tips')\" onblur=\"onRegBlur(id,'name_tips')\" />\r\n");
      out.write("                *</td>\r\n");
      out.write("              <td width=\"55%\" align=\"left\"><span id=\"name_tips\"></span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">密码：</td>\r\n");
      out.write("              <td width=\"2%\"></td>\r\n");
      out.write("              <td width=\"23%\" align=\"left\"><input type=\"password\" name=\"password\" id=\"password\" style=\"width:150px;\" onfocus=\"onRegFocus(this.id,'password_tips')\" onblur=\"onRegBlur(id,'password_tips')\" />\r\n");
      out.write("                *</td>\r\n");
      out.write("              <td width=\"55%\" align=\"left\"><span id=\"password_tips\"></span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">确认密码：</td>\r\n");
      out.write("              <td width=\"2%\"></td>\r\n");
      out.write("              <td width=\"23%\" align=\"left\"><input type=\"password\" name=\"password2\" id=\"password2\" style=\"width:150px;\" onfocus=\"onRegFocus(this.id,'password2_tips')\" onblur=\"onRegBlur(id,'password2_tips')\" />\r\n");
      out.write("                *</td>\r\n");
      out.write("              <td width=\"55%\" align=\"left\"><span id=\"password2_tips\"></span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">密码提示问题：</td>\r\n");
      out.write("              <td width=\"2%\"></td>\r\n");
      out.write("              <td width=\"23%\" align=\"left\"><input type=\"text\" name=\"passwordQuestion\" id=\"passwordQuestion\" style=\"width:150px;\" onfocus=\"onRegFocus(this.id,'passwordQuestion_tips')\" onblur=\"onRegBlur(id,'passwordQuestion_tips')\" /></td>\r\n");
      out.write("              <td width=\"55%\" align=\"left\"><span id=\"passwordQuestion_tips\"></span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">提示问题回答：</td>\r\n");
      out.write("              <td width=\"2%\"></td>\r\n");
      out.write("              <td width=\"23%\" align=\"left\"><input type=\"text\" name=\"passwordAnswer\" id=\"passwordAnswer\" style=\"width:150px;\"  onfocus=\"onRegFocus(this.id,'passwordAnswer_tips')\" onblur=\"onRegBlur(id,'passwordAnswer_tips')\"/></td>\r\n");
      out.write("              <td width=\"55%\" align=\"left\"><span id=\"passwordAnswer_tips\"></span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\" id=\"regItemName\" align=\"right\" valign=\"top\">身份确认：</td>\r\n");
      out.write("              <td width=\"2%\"></td>\r\n");
      out.write("              <td align=\"left\"><textarea id=\"regUserInfo\" name=\"regUserInfo\" style=\"width:100%; color:#000; height:50px; font-family: Arial, '宋体'; font-size:13px;\" onfocus=\"onRegFocus(this.id,'regUserInfo_tips')\" onblur=\"onRegBlur(id,'regUserInfo_tips')\"></textarea></td>\r\n");
      out.write("              <td width=\"55%\" align=\"left\" style=\"padding-left:20px;\"><span id=\"regUserInfo_tips\"></span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\"id=\"regItemName\" align=\"right\">验证码：</td>\r\n");
      out.write("              <td width=\"2%\"></td>\r\n");
      out.write("              <td width=\"23%\" align=\"left\"><div style=\"height:auto; width:auto; text-align:left; float:left;\">\r\n");
      out.write("                  <input type=\"text\" name=\"vcode\" id=\"vcode\" style=\"width:70px;\" onfocus=\"onRegFocus(this.id,'vcode_tips')\" onblur=\"onRegBlur(id,'vcode_tips')\" />\r\n");
      out.write("                  *&nbsp;&nbsp;&nbsp;</div>\r\n");
      out.write("                <img id=\"vcodeImg\" src=\"/jsp/vcode/image.jsp\" onclick=\"javascript:reloadVCode();\" style=\"border:none; width:60px; height:20px;\"/></td>\r\n");
      out.write("              <td width=\"55%\" align=\"left\"><a href=\"javascript:reloadVCode();\" style=\"font-family: Arial, '宋体';font-size:12px;color:#006699;\">看不清楚？换张图片！</a>\r\n");
      out.write("                <div><span id=\"vcode_tips\"></span></div></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"20px\">&nbsp;</td>\r\n");
      out.write("              <td height=\"20px\"id=\"regItemName\" align=\"left\" colspan=\"3\"><span class=\"regErrMsg\" id=\"regErrInfo\"></span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\">&nbsp;</td>\r\n");
      out.write("              <td width=\"2%\" height=\"35px\">&nbsp;</td>\r\n");
      out.write("              <td height=\"35px\"align=\"left\" colspan=\"2\"><input type=\"submit\" id=\"blackText\" value=\"提交\" onclick=\"return checkRegist()\" />\r\n");
      out.write("                <input type=\"reset\" id=\"blackText\" value=\"重置\"/>&nbsp;&nbsp;<a href=\"/jsp/manage/\" class=\"normalLink\" target=\"_self\">返回后台首页</a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("        </form>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <!--//mainContent-->\r\n");
      out.write("  <div id=\"bottom\">\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/bottom.jsp", out, true);
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("document.getElementById(\"regErrInfo\").innerHTML=");
      out.print(("\""+errMsg+"\""));
      out.write(";\r\n");
      out.write("document.getElementById(\"email\").value=");
      out.print(("\""+oldEmail+"\""));
      out.write(";\r\n");
      out.write("document.getElementById(\"name\").value=");
      out.print(("\""+oldName+"\""));
      out.write(";\r\n");
      out.write("document.getElementById(\"passwordQuestion\").value=");
      out.print(("\""+oldPasswordQuestion+"\""));
      out.write(";\r\n");
      out.write("document.getElementById(\"passwordAnswer\").value=");
      out.print(("\""+oldPasswordAnswer+"\""));
      out.write(";\r\n");
      out.write("document.getElementById(\"regUserInfo\").value=");
      out.print(("\""+oldRegUserInfo+"\""));
      out.write(";\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");

session.setAttribute("errMsg",new String(""));

      out.write("\r\n");
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
