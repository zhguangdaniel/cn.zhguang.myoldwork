package org.apache.jsp.old_005f1.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mainHeader_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"/old_1/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"/old_1/css/menu.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<!--[if lte IE 6]>\r\n");
      out.write("<link href=\"/old_1/css/menuIE6.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<!--头部，含顶部菜单和Banner条-->\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("    <!--顶部菜单-->\r\n");
      out.write("    <div id=\"topMenu\">\r\n");
      out.write("        <table width=\"120\" border=\"0\" align=\"right\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td width=\"60px\" style=\"text-align:right;\"><a href=\"mailto:zhguang_sysu@163.com\" class=\"topMenu\">联系我们</a></td>\r\n");
      out.write("                <td width=\"60px\" style=\"text-align:right;\"><a href=\"/jsp/manage/\" class=\"topMenu\">后台管理</a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--//顶部菜单-->\r\n");
      out.write("    <!--Banner条-->\r\n");
      out.write("    <div id=\"banner\"> <img src=\"/old_1/images/banner.jpg\" width=\"780\" height=\"110\" /></div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--头部header-->\r\n");
      out.write("<!--导航条-->\r\n");
      out.write("<div id=\"nav\">\r\n");
      out.write("    <table width=\"780px\" border=\"0\"  height=\"30px\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("        <!-- cellpadding=\"7\" cellspacing=\"0\"-->\r\n");
      out.write("        <tr style=\"text-align: center;\">\r\n");
      out.write("            <td ><a href=\"/old_1/index.jsp\" class=\"nav\" target=\"_self\">首页</a></td>\r\n");
      out.write("            <td style=\"font-size:15px\">|</td>\r\n");
      out.write("            <td><a href=\"/old_1/jsp/introduce.jsp\" class=\"nav\" target=\"_self\">专业概况</a></td>\r\n");
      out.write("            <td style=\"font-size:15px\">|</td>\r\n");
      out.write("            <td ><a href=\"/old_1/jsp/blueprint/blueprint1.jsp\" class=\"nav\" target=\"_self\">教学方案</a></td>\r\n");
      out.write("            <td style=\"font-size:15px\">|</td>\r\n");
      out.write("            <td><div class=\"menu\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a class=\"hide\" href=\"#\">新闻通知</a>\r\n");
      out.write("                            <!--[if lte IE 6]>\r\n");
      out.write("                            <a href=\"#\">新闻通知\r\n");
      out.write("                            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\" float:right;\"><tr><td>\r\n");
      out.write("                            <![endif]-->\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><a href=\"/old_1/jsp/news/newsList.jsp?page=1\" target=\"_self\">新闻中心</a></li>\r\n");
      out.write("                                <li style=\"border-width:0 0 0;\"><a href=\"/old_1/jsp/info/infoList.jsp?page=1\" target=\"_self\">通知信息</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                            <!--[if lte IE 6]>\r\n");
      out.write("                            </td></tr></table>\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <![endif]-->\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div></td>\r\n");
      out.write("            <td style=\"font-size:15px\">|</td>\r\n");
      out.write("            <td><a href=\"/old_1/jsp/course/courses.jsp\" class=\"nav\" target=\"_self\">课程学习</a></td>\r\n");
      out.write("            <td style=\"font-size:15px\">|</td>\r\n");
      out.write("            <td><div class=\"menu\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"#\" class=\"hide\">创新活动</a>\r\n");
      out.write("                            <!--[if lte IE 6]>\r\n");
      out.write("                            <a href=\"#\">创新活动\r\n");
      out.write("                            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"float:right;\"><tr><td>\r\n");
      out.write("                            <![endif]-->\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><a href=\"/old_1/jsp/networkActivity/networkActivity.jsp\" target=\"_self\">活动介绍</a></li><li>\r\n");
      out.write("                                <a href=\"/old_1/jsp/networkActivity/networkActivity.jsp\" target=\"_self\">活动规则</a></li><li>\r\n");
      out.write("                                <a href=\"/old_1/jsp/networkActivity/networkActivity.jsp\" target=\"_self\">活动内容</a></li><li>\r\n");
      out.write("                                <a href=\"/old_1/jsp/networkActivity/networkActivity.jsp\" target=\"_self\">活动资料</a></li><li\r\n");
      out.write("                                 style=\"border-width:0 0 0;\"><a href=\"/old_1/jsp/networkActivity/networkActivity.jsp\" target=\"_self\">表格下载</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                            <!--[if lte IE 6]>\r\n");
      out.write("                            </td></tr></table>\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <![endif]-->\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div></td>\r\n");
      out.write("            <td style=\"font-size:15px\">|</td>\r\n");
      out.write("            <td><a href=\"/old_1/jsp/files/files.jsp?page=1\" class=\"nav\" target=\"_self\">文件下载</a></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("</div>\r\n");
      out.write("<!--//导航条nav-->\r\n");
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
