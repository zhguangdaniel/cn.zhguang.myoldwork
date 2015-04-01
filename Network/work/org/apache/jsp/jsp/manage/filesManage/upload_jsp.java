package org.apache.jsp.jsp.manage.filesManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import database.*;
import user.*;

public final class upload_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      files.FilesBean filesBean = null;
      synchronized (_jspx_page_context) {
        filesBean = (files.FilesBean) _jspx_page_context.getAttribute("filesBean", PageContext.PAGE_SCOPE);
        if (filesBean == null){
          filesBean = new files.FilesBean();
          _jspx_page_context.setAttribute("filesBean", filesBean, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/files.js\"></script>\r\n");
      out.write("<title>网工后台管理－文件上传</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	boolean isLog = false;
		try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
	if (!isLog) {
		session.setAttribute("isLog",new String("0"));
		session.setAttribute("loginMsg", new String("您还未登录，请先登录！"));
		response.sendRedirect("/jsp/manage/");
	}else if(!User.checkHaveAuthority(((String)session.getAttribute("userAuthority")),User.uploadFile)){
		out.println("<center>你没有打开该页面的权限...</center>");
	}else{
		String errMsg = null;
		try {
			errMsg = (String) session.getAttribute("errMsg");
		} catch (Exception e) {
		}
		if (errMsg == null) {
			errMsg = "";
		}
		String parentURL = request.getParameter("parent");

      out.write("\r\n");
      out.write("<!--全部区域-->\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("    <!--头部-->\r\n");
      out.write("    <div id=\"header\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/header.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--主区，包括菜单区（垂直导航条）和工作区-->\r\n");
      out.write("    <div id=\"mainContent\">\r\n");
      out.write("        <div id=\"leftMenu\">\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/leftMenu.jsp", out, true);
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"rightMain\">\r\n");
      out.write("        <div id=\"contentHeader\">&nbsp;&nbsp;<a href=\"/jsp/manage/\" class=\"normalLink\">后台管理</a> &nbsp;&gt;&nbsp;<a href=\"/jsp/manage/filesManage/files.jsp?page=1\" class=\"normalLink\">文件管理</a> &nbsp;&gt;&nbsp;上传文件&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"/images/Return.png\" width=\"12\" height=\"12\" /><a\r\n");
      out.write("                href=\"");
      out.print(parentURL);
      out.write("\" target=\"_self\" class=\"normalLink\" style=\"color:#069\" >返回</a></div>\r\n");
      out.write("            <div id=\"uploadFrame\">\r\n");
      out.write("                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td height=\"30px\" id=\"bar\" style=\"text-align:center;\">文件上传</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td height=\"10px\">&nbsp;</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td id=\"tdTitle\" height=\"20px\" valign=\"middle\" align=\"left\" style=\"padding-left:20px;font-family:Arial, '宋体'; font-size:14px;\"><img\r\n");
      out.write("\t\t\tsrc=\"/images/saveFile.png\" width=\"14\" height=\"14\" />&nbsp;请选择要上传的文件：</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td valign=\"top\" align=\"center\"><form id=\"formUpload\" method=\"post\" action=\"/jsp/manage/filesManage/saveFile.jsp\"\r\n");
      out.write("\t\t\tenctype=\"multipart/form-data\" target=\"_self\">\r\n");
      out.write("                                <input type=\"file\" name=\"fileUpload\" id=\"fileUpload\" size=\"41\" style=\" margin-top:3px; margin-bottom:5px;\" onchange=\"return setItemName()\" />\r\n");
      out.write("                                <br />\r\n");
      out.write("                                <div style=\" width:360px; height:25px; line-height:25px; font-family:Arial, '宋体'; font-size:14px; text-align:left; margin:0 auto;\">显示名称：<span style=\"color:#999; font-size:12px;\">（你可以自定义名称，也可以由系统指定）</span></div>\r\n");
      out.write("                                <input type=\"text\" name=\"fileName\" id=\"fileName\" style=\" width:360px; font-size:12px; font-family:Arial, '宋体'; margin-top:3px; margin-bottom:5px;\" title=\"该名称会显示在文件列表\"/>\r\n");
      out.write("                                <div style=\" width:360px; height:25px; line-height:25px; font-family:Arial, '宋体'; font-size:14px; text-align:left; margin:0 auto;\">文件描述：<span style=\"color:#999; font-size:12px;\">（建议填写，没有文件描述也可以留空）</span></div>\r\n");
      out.write("                                <textarea name=\"fileDescription\" id=\"fileDescription\" class=\"fileDescription\" cols=\"\" rows=\"\"></textarea>\r\n");
      out.write("                                <div class=\"errMsgFrame\" id=\"errMsg\"></div>\r\n");
      out.write("                                <input type=\"submit\" name=\"submit\" value=\"上传\" onclick=\"return checkFile()\" />\r\n");
      out.write("                                <input type=\"reset\" name=\"reset\" value=\"重置\" />\r\n");
      out.write("                            </form>\r\n");
      out.write("                            </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr><td>&nbsp;</td></tr>\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"bottom\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/bottom.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("\tdocument.getElementById(\"errMsg\").innerHTML=\"<font color='#FF0000' size='-1' face='Arial, 宋体'>\"+");
      out.print(("\""+errMsg+"\""));
      out.write("+\"</font>\";\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
	
	errMsg = "";
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
