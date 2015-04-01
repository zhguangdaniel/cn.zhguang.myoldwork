package org.apache.jsp.old_005f1.jsp.course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class courseFrame_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"/old_1/css/style.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"/old_1/css/courseFrame.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<table width=\"200px\" height=\"291px\" align=\"center\"  cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("    <tr class=\"bar\">\r\n");
      out.write("        <td align=\"left\" colspan=\"3\" style=\"padding-left:10px;\">课程学习</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td  height=\"251px\" align=\"left\" valign=\"top\"><div class=\"coursesList\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li>&nbsp;<a href=\"#\" class=\"text\">数学分析</a></li>\r\n");
      out.write("                    <li>&nbsp;<a href=\"#\" class=\"text\">高等代数</a></li>\r\n");
      out.write("                    <li>&nbsp;<a href=\"#\" class=\"text\">数理逻辑</a></li>\r\n");
      out.write("                    <li>&nbsp;<a href=\"#\" class=\"text\">代数结构</a></li>\r\n");
      out.write("                    <li>&nbsp;<a href=\"#\" class=\"text\">程序设计I</a></li>\r\n");
      out.write("                    <li>&nbsp;<a href=\"#\" class=\"text\">数据结构与算法</a></li>\r\n");
      out.write("                    <li>&nbsp;<a href=\"#\" class=\"text\">数字电路与逻辑设计</a></li>\r\n");
      out.write("                    <li>&nbsp;<a href=\"#\" class=\"text\">计算机组成原理</a></li>\r\n");
      out.write("                    <li>&nbsp;<a href=\"#\" class=\"text\">操作系统</a></li>\r\n");
      out.write("                    <li>&nbsp;<a href=\"#\" class=\"text\">计算机网络</a></li>\r\n");
      out.write("                    <li>&nbsp;<a href=\"#\" class=\"text\">编译原理</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"middle\" colspan=\"3\"><a href=\"/old_1/jsp/course/courses.jsp\" class=\"more\">>>more&nbsp;&nbsp;</a></td>\r\n");
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
