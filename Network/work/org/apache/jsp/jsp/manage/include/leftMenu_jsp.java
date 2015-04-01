package org.apache.jsp.jsp.manage.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import user.*;
import database.*;
import java.lang.Integer;

public final class leftMenu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"/css/manageLeftMenu.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<!--[if lte IE 6]>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#menu ul li a{\r\n");
      out.write("\theight:23px;\r\n");
      out.write("\tline-height:23px;\r\n");
      out.write("\tpadding-top:8px;\r\n");
      out.write("}\r\n");
      out.write("#menu ul li a:hover {\r\n");
      out.write("\theight:23px;\r\n");
      out.write("\tline-height:23px;\r\n");
      out.write("\tpadding-top:8px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<![endif]-->\r\n");

String role = (String) session.getAttribute("userRole");

      out.write("\r\n");
      out.write("<div id=\"menu\">\r\n");
      out.write("  <ul>\r\n");
      out.write("    <li><a href=\"/jsp/manage/\"><img src=\"/images/ReturnHome.png\" width=\"14\" height=\"14\" border=\"0\" />&nbsp;后台首页</a></li>\r\n");
      out.write("    ");
if(role.equals("0")){
      out.write("<li><a href=\"/jsp/manage/users/usersManage.jsp\"><img src=\"/images/users.png\" width=\"14\" height=\"14\" border=\"0\" />&nbsp;用户管理</a></li>");
} 
      out.write("\r\n");
      out.write("    <li><a href=\"/jsp/manage/newsManage/news.jsp?page=1\"><img src=\"/images/newsManage.png\" width=\"14\" height=\"14\" border=\"0\" />&nbsp;新闻管理</a></li>\r\n");
      out.write("    <li><a href=\"/jsp/manage/infoManage/info.jsp?page=1\"><img src=\"/images/notice.png\" width=\"14\" height=\"16\" border=\"0\" />&nbsp;通知管理</a></li>\r\n");
      out.write("    <li><a href=\"/jsp/manage/filesManage/files.jsp?page=1\"><img src=\"/images/fileManage.png\" width=\"16\" height=\"15\" border=\"0\" />&nbsp;文件管理</a></li>\r\n");
      out.write("    <li><a href=\"/jsp/manage/linksManage/links.jsp\"><img src=\"/images/linksManage.png\" width=\"15\" height=\"15\" border=\"0\" />&nbsp;相关链接</a></li>\r\n");
      out.write("    <li><a href=\"/jsp/manage/msgManage/msg.jsp?page=1\"><img src=\"/images/message.png\" width=\"15\" height=\"15\" border=\"0\" />&nbsp;留言管理</a></li>\r\n");
      out.write("    <li><a href=\"/jsp/manage/networkActivityManage/activity.jsp\"><img src=\"/images/activityManage.png\" width=\"14\" height=\"14\" border=\"0\" />&nbsp;创新活动</a></li>\r\n");
      out.write("  </ul>\r\n");
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
