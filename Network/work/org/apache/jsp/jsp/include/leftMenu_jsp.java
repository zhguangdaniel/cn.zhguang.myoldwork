package org.apache.jsp.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
      			"", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"/css/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/main.js\"></script>\r\n");
      out.write("<div class=\"leftMenu\">\r\n");
      out.write("  <dl>\r\n");
      out.write("    <dt><a href=\"/jsp/introduce.jsp\">专业概况</a></dt>\r\n");
      out.write("    <dt><a href=\"javascript:showHide('menuItem_TeachingPlan');\">教学方案</a>\r\n");
      out.write("    <dd id=\"menuItem_TeachingPlan\" class=\"leftMenuDD\" >\r\n");
      out.write("      <ul>\r\n");
      out.write("        <li><a href=\"/jsp/blueprint/blueprint1.jsp\" target=\"_self\">培养方案</a></li>\r\n");
      out.write("        <li><a href=\"/jsp/blueprint/blueprint2.htm\" target=\"_blank\">教学计划 (07)</a></li>\r\n");
      out.write("        <li><a href=\"/jsp/blueprint/blueprint2.jsp\" target=\"_self\">教学计划 (09)</a></li>\r\n");
      out.write("        <li><a href=\"/jsp/blueprint/blueprint3.jsp\" target=\"_self\">课程路线图</a></li>       \r\n");
      out.write("      </ul>\r\n");
      out.write("    </dd>\r\n");
      out.write("    </dt>\r\n");
      out.write("    <dt><a href=\"/jsp/courses.jsp\">课程学习</a></dt>\r\n");
      out.write("    <dt><a href=\"/jsp/news/newsList.jsp?page=1\">新闻中心</a></dt>\r\n");
      out.write("    <dt><a href=\"/jsp/info/infoList.jsp?page=1\">通知信息</a></dt>\r\n");
      out.write("    <dt><a href=\"/jsp/files/files.jsp?page=1\">文件下载</a></dt>\r\n");
      out.write("    <dt><a href=\"javascript:showHide('menuItem_Activity');\">创新活动</a>\r\n");
      out.write("    <dd id=\"menuItem_Activity\" class=\"leftMenuDD\">\r\n");
      out.write("      <ul>\r\n");
      out.write("        <li><a href=\"/jsp/networkActivity/networkActivity.jsp\" target=\"_self\">活动介绍</a></li>\r\n");
      out.write("        <li><a href=\"/jsp/networkActivity/networkActivity.jsp\" target=\"_self\">活动规则</a></li>\r\n");
      out.write("        <li><a href=\"/jsp/networkActivity/networkActivity.jsp\" target=\"_self\">活动内容</a></li>\r\n");
      out.write("        <li><a href=\"/jsp/networkActivity/networkActivity.jsp\" target=\"_self\">活动资料</a></li>\r\n");
      out.write("        <li><a href=\"/jsp/networkActivity/networkActivity.jsp\" target=\"_self\">表格下载</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </dd>\r\n");
      out.write("    </dt>\r\n");
      out.write("  </dl>\r\n");
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
