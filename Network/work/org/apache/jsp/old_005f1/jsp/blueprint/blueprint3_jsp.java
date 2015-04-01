package org.apache.jsp.old_005f1.jsp.blueprint;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class blueprint3_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>网工－核心知识模块与课程路线图</title>\r\n");
      out.write("<link href=\"/old_1/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"/old_1/css/blueprint.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!--主体容器container-->\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("    <!--主头部mainHeader-->\r\n");
      out.write("    <div id=\"mainHeader\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/old_1/jsp/include/mainHeader.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--//mainHeader-->\r\n");
      out.write("    <!--主信息区-->\r\n");
      out.write("    <div id=\"mainContent\">\r\n");
      out.write("        <div id=\"buleprintNav\">\r\n");
      out.write("            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td align=\"center\"><a href=\"/old_1/jsp/blueprint/blueprint1.jsp\" target=\"_self\" class=\" normalLink\">培养方案</a></td>\r\n");
      out.write("                    <td align=\"center\"><a href=\"/old_1/jsp/blueprint/blueprint2.htm\" target=\"_blank\" class=\" normalLink\">教学计划（07年版）</a></td>\r\n");
      out.write("                    <td align=\"center\"><a href=\"/old_1/jsp/blueprint/blueprint2.jsp\" target=\"_self\" class=\" normalLink\">教学计划（09年版）</a></td>\r\n");
      out.write("                    <td align=\"center\" id=\"blackText\">课程路线图</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id = \"blueprintFrame\">\r\n");
      out.write("        <h1>网络工程专业核心知识模块及课程路线图 </h1>\r\n");
      out.write("<p style=\"font-family: '楷体_GB2312'; font-size: 14px; text-align: center; color: #F60;\">（2009年4月）</p>\r\n");
      out.write("<h2>一、图例说明</h2>\r\n");
      out.write("<p>实线框是必修课程，虚线框是选修课程，带颜色框是课程群内的课程，无颜色框是相关的课程。带箭头的实线表示必需有的先修课程，带箭头的虚线表示一般有但非必需有的先修课程（只需要补充少量相关知识）。</p>\r\n");
      out.write("<h2>二、数理基础课程</h2>\r\n");
      out.write("<ol>\r\n");
      out.write("    <li>数学物理及相关课程</li>\r\n");
      out.write("    <img src=\"/old_1/images/blueprint/2.1.JPG\" width=\"490\" height=\"184\" />\r\n");
      out.write("    <p>&nbsp; </p>\r\n");
      out.write("    <li>离散结构及相关课程</li>\r\n");
      out.write("    <img src=\"/old_1/images/blueprint/2.2.JPG\" width=\"408\" height=\"181\" />\r\n");
      out.write("</ol>\r\n");
      out.write("<h2>三、硬件与网络课程</h2>\r\n");
      out.write("<ol>\r\n");
      out.write("    <li>电路与计算机组成相关课程</li>\r\n");
      out.write("    <img src=\"/old_1/images/blueprint/3.1.JPG\" width=\"581\" height=\"200\" />\r\n");
      out.write("    <p>&nbsp; </p>\r\n");
      out.write("    <li>网络与通信相关课程</li>\r\n");
      out.write("    <img src=\"/old_1/images/blueprint/3.2.JPG\" width=\"442\" height=\"410\" />\r\n");
      out.write("</ol>\r\n");
      out.write("<h2>四、软件课程</h2>\r\n");
      out.write("<ol>\r\n");
      out.write("    <li>程序设计语言与数据管理相关课程</li>\r\n");
      out.write("    <img src=\"/old_1/images/blueprint/4.1.JPG\" width=\"603\" height=\"276\" />\r\n");
      out.write("    <p>&nbsp; </p>\r\n");
      out.write("    <li>人工智能相关课程</li>\r\n");
      out.write("    <img src=\"/old_1/images/blueprint/4.2.JPG\" width=\"556\" height=\"236\" />\r\n");
      out.write("    <p>&nbsp; </p>\r\n");
      out.write("    <li>图形与图像类课程</li>\r\n");
      out.write("    <img src=\"/old_1/images/blueprint/4.3.JPG\" width=\"432\" height=\"211\" />\r\n");
      out.write("</ol>\r\n");
      out.write("<h2>五、实践课程 </h2>\r\n");
      out.write("<ol>\r\n");
      out.write("    <img src=\"/old_1/images/blueprint/5.JPG\" width=\"554\" height=\"263\" />\r\n");
      out.write("</ol>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--//mainContent-->\r\n");
      out.write("    <!--尾部bottom-->\r\n");
      out.write("    <div id=\"bottom\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/old_1/jsp/include/bottom.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--//bottom-->\r\n");
      out.write("</div>\r\n");
      out.write("<!--container-->\r\n");
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
