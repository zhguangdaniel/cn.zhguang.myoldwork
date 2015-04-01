package org.apache.jsp.jsp.manage.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class bottom_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link href=\"/css/manage.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<table width=\"100%\" height=\"48px\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td id=\"blueText\" height=\"16px\" align=\"center\"><a href=\"/\" target=\"_blank\" class=\"normalLink\">前台首页</a> | <a href=\"http://www.sysu.edu.cn\" target=\"_blank\" class=\"normalLink\">中山大学</a> | <a href=\"/jsp/manage/support.jsp\" target=\"_self\" class=\"normalLink\">技术支持</a> | <a href=\"/jsp/manage/versionHistory.jsp\" target=\"_self\" class=\"normalLink\">版本历史</a>  | <a href=\"/jsp/manage/help.jsp\" target=\"_self\" class=\"normalLink\">帮助</a> \r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td id=\"blueText\" height=\"16px\" align=\"center\">Copyright&nbsp;&#169;&nbsp;中山大学网络工程专业&nbsp;&#169;&nbsp;版权所有&nbsp;&nbsp;&nbsp;&nbsp;Version 1.3</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("</table>\r\n");
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
