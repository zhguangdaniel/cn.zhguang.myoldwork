package org.apache.jsp.jsp.manage.networkActivityManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import customLinks.*;
import java.sql.*;
import java.util.ArrayList;

public final class activity_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      customLinks.LinksBean links = null;
      synchronized (_jspx_page_context) {
        links = (customLinks.LinksBean) _jspx_page_context.getAttribute("links", PageContext.PAGE_SCOPE);
        if (links == null){
          links = new customLinks.LinksBean();
          _jspx_page_context.setAttribute("links", links, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function onDelete() {\r\n");
      out.write("   return confirm(\"确定要删除吗？\");\r\n");
      out.write("} \r\n");
      out.write("</script>\r\n");
      out.write("<title>网工后台管理－创新活动管理</title>\r\n");
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
	}else{
		String currentURL = "http://"+request.getServerName()+":"+request.getServerPort()+request.getRequestURI()+"?"+request.getQueryString();

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
      out.write("            <div id=\"contentHeader\"><div style=\"float:left\">&nbsp;&nbsp;创新活动管理：</div>\r\n");
      out.write("                <div id=\"tempContentHeader\">\r\n");
      out.write("                    <div id=\"contentButton\">\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li><a href=\"\" target=\"_self\">&nbsp;&nbsp;</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"20px\" height=\"20px\"></td>\r\n");
      out.write("                    <td width=\"110px\" align=\"left\"></td>\r\n");
      out.write("                    <td align=\"right\"></td>\r\n");
      out.write("                    <td width=\"90px\" align=\"right\"></td>\r\n");
      out.write("                    <td width=\"20px\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td colspan=\"5\" align=\"center\">暂时没有内容...</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td height=\"10px\" colspan=\"5\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"bottom\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/bottom.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
	
	}//else

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
