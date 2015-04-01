package org.apache.jsp.jsp.user;

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
      out.write("<title>注册称为MicroTalk的一员！</title>\r\n");
      out.write("<link href=\"/css/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/register.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	String errMsg = null;
	String oldEmail= null;
	String oldName=null;
	String oldSelfDesc=null;
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
		oldName = (String) session.getAttribute("userName");
	} catch (Exception e) {
	}
	if (oldName == null) {
		oldName = "";
	}
	try {
		oldSelfDesc = (String) session.getAttribute("oldSelfDesc");
	} catch (Exception e) {
	}
	if (oldSelfDesc == null) {
		oldSelfDesc = "";
	}

      out.write("\r\n");
      out.write("<!--头部header-->\r\n");
      out.write("<div class=\"header\">\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/header.jsp", out, true);
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!--//header-->\r\n");
      out.write("<!--主体容器container-->\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("  <!--内容区content，包括菜单和主内容-->\r\n");
      out.write("  <div class=\"content\" style=\"background-color:#FFF\">\r\n");
      out.write("    <div class=\"regFrame\">\r\n");
      out.write("      <div class=\"regTopTipsFrame\"> 欢迎注册，请填写以下内容，打*的是必填项： </div>\r\n");
      out.write("      <div class=\"regTable\">\r\n");
      out.write("        <form id=\"form_reg\" action=\"/jsp/user/doRegist.jsp\" method=\"post\"  enctype=\"multipart/form-data\" target=\"_self\">\r\n");
      out.write("          <table width=\"100%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\" class=\"regItemName\" align=\"right\">电子邮件：</td>\r\n");
      out.write("              <td width=\"2%\"></td>\r\n");
      out.write("              <td width=\"23%\" align=\"left\"><input type=\"text\" name=\"email\" id=\"email\" style=\"width:150px;\" onfocus=\"onRegFocus(this.id,'email_tips')\" onblur=\"onRegBlur(id,'email_tips')\" />\r\n");
      out.write("                *</td>\r\n");
      out.write("              <td width=\"55%\" align=\"left\"><span id=\"email_tips\"></span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\" class=\"regItemName\" align=\"right\">用户名：</td>\r\n");
      out.write("              <td width=\"2%\"></td>\r\n");
      out.write("              <td width=\"23%\" align=\"left\"><input type=\"text\" name=\"name\" id=\"name\" style=\"width:150px;\" onfocus=\"onRegFocus(this.id,'name_tips')\" onblur=\"onRegBlur(id,'name_tips')\" />\r\n");
      out.write("                *</td>\r\n");
      out.write("              <td width=\"55%\" align=\"left\"><span id=\"name_tips\"></span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\" class=\"regItemName\" align=\"right\">密码：</td>\r\n");
      out.write("              <td width=\"2%\"></td>\r\n");
      out.write("              <td width=\"23%\" align=\"left\"><input type=\"password\" name=\"password\" id=\"password\" style=\"width:150px;\" onfocus=\"onRegFocus(this.id,'password_tips')\" onblur=\"onRegBlur(id,'password_tips')\" />\r\n");
      out.write("                *</td>\r\n");
      out.write("              <td width=\"55%\" align=\"left\"><span id=\"password_tips\"></span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\" class=\"regItemName\" align=\"right\">确认密码：</td>\r\n");
      out.write("              <td width=\"2%\"></td>\r\n");
      out.write("              <td width=\"23%\" align=\"left\"><input type=\"password\" name=\"password2\" id=\"password2\" style=\"width:150px;\" onfocus=\"onRegFocus(this.id,'password2_tips')\" onblur=\"onRegBlur(id,'password2_tips')\" />\r\n");
      out.write("                *</td>\r\n");
      out.write("              <td width=\"55%\" align=\"left\"><span id=\"password2_tips\"></span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\"  class=\"regItemName\" align=\"right\" valign=\"top\">自我描述：</td>\r\n");
      out.write("              <td width=\"2%\"></td>\r\n");
      out.write("              <td align=\"left\"><textarea id=\"regUserInfo\" name=\"regUserInfo\" style=\"width:100%; color:#000; height:50px; font-family: Arial, '宋体'; font-size:13px;\" onfocus=\"onRegFocus(this.id,'regUserInfo_tips')\" onblur=\"onRegBlur(id,'regUserInfo_tips')\"></textarea></td>\r\n");
      out.write("              <td width=\"55%\" align=\"left\" style=\"padding-left:20px;\"><span id=\"regUserInfo_tips\"></span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\" class=\"regItemName\" align=\"right\">上传头像：</td>\r\n");
      out.write("              <td width=\"2%\"></td>\r\n");
      out.write("              <td width=\"23%\" align=\"left\"><input type=\"file\" name=\"userIcon\" id=\"userIcon\" size=\"15\" onchange=\"return checkFileUpload()\" />\r\n");
      out.write("                </td>\r\n");
      out.write("              <td width=\"55%\" align=\"left\"  style=\"padding-left:20px;\"><span id=\"userIcon_tips\"></span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\" class=\"regItemName\" align=\"right\">验证码：</td>\r\n");
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
      out.write("              <td height=\"20px\" class=\"regItemName\" align=\"left\" colspan=\"3\"><span class=\"regErrMsg\" id=\"regErrInfo\"></span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"20%\" height=\"35px\">&nbsp;</td>\r\n");
      out.write("              <td width=\"2%\" height=\"35px\">&nbsp;</td>\r\n");
      out.write("              <td height=\"35px\"align=\"left\" colspan=\"2\"><input type=\"submit\" id=\"blackText\" value=\"提交\" onclick=\"return checkRegist()\" />\r\n");
      out.write("                <input type=\"reset\" id=\"blackText\" value=\"重置\"/></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("        </form>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <!--content-->\r\n");
      out.write("</div>\r\n");
      out.write("<!--container-->\r\n");
      out.write("<!--底部bottom-->\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/footer.jsp", out, true);
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!--//bottom-->\r\n");
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
      out.write("document.getElementById(\"regUserInfo\").value=");
      out.print(("\""+oldSelfDesc+"\""));
      out.write(";\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");

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
