package org.apache.jsp.jsp.manage.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"/css/manage.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/main.js\"></script>\r\n");
      out.write("<!--[if lte IE 6]>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#headerButton ul li a{\r\n");
      out.write("\theight:23px;\r\n");
      out.write("\tline-height:23px;\r\n");
      out.write("\tpadding-top:8px;\r\n");
      out.write("}\r\n");
      out.write("#headerButton ul li a:hover {\r\n");
      out.write("\theight:23px;\r\n");
      out.write("\tline-height:23px;\r\n");
      out.write("\tpadding-top:8px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<div id=\"headerButton\">\r\n");
      out.write("  <ul>\r\n");
      out.write("    <li style=\"width:180px;\">\r\n");
      out.write("      <form id=\"form_search\" action=\"/jsp/manage/search/search.jsp\" method=\"post\" style=\" text-align:left;width:180px; height:30px;margin:0px; padding:0px; float:right;\">\r\n");
      out.write("        <input type=\"text\" name=\"searchKeyword\" id=\"searchKeyword\" class=\"blackText\" style=\"width:120px;\" value=\"Search...\" onclick=\"clearSearchText()\" />\r\n");
      out.write("        <input type=\"submit\" class=\"blackText\" value=\"搜索\" onclick=\"return checkSearch()\" />\r\n");
      out.write("      </form>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li><a href=\"/\" target=\"_blank\"><img src=\"/images/ReturnHome.png\" width=\"14\" height=\"14\" border=\"0\" />&nbsp;前台首页</a></li>\r\n");
      out.write("    <li><a href=\"/jsp/manage/users/logout.jsp\" target=\"_self\"><img src=\"/images/logout.PNG\" width=\"14\" height=\"14\" border=\"0\" />&nbsp;退出系统</a></li>\r\n");
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
