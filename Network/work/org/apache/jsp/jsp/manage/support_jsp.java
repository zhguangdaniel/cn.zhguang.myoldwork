package org.apache.jsp.jsp.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class support_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--[if lte IE 6]>\r\n");
      out.write("<link href=\"/css/contentButtonIE6.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<title>网工后台管理－技术支持</title>\r\n");
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

      out.write("\r\n");
      out.write("<!--全部区域-->\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("  <!--头部-->\r\n");
      out.write("  <div id=\"header\">\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/header.jsp", out, true);
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("  <!--主区，包括菜单区（垂直导航条）和工作区-->\r\n");
      out.write("  <div id=\"mainContent\">\r\n");
      out.write("    <div id=\"leftMenu\">\r\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/leftMenu.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"rightMain\">\r\n");
      out.write("          <div id=\"websiteInfo\">\r\n");
      out.write("        <table align=\"center\" cellpadding=\"2\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td colspan=\"2\" height=\"30px\" id=\"bar\" style=\"text-align:center;\">技术支持</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"center\" width=\"20%\" height=\"30px\" valign=\"middle\" style=\"border:solid 1px #AAA; border-left-width:0;\">网站名称</td>\r\n");
      out.write("            <td align=\"left\" width=\"80%\" valign=\"middle\" style=\"border:solid  #AAA; border-width:1px 0 1px;\">中山大学网络工程专业本科教学网站</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"center\" width=\"20%\" height=\"30px\" valign=\"middle\" style=\"border:solid 0 #AAA; border-bottom-width:1px;border-right-width:1px;\">开发周期</td>\r\n");
      out.write("            <td align=\"left\" width=\"80%\" valign=\"middle\" style=\"border:solid  #AAA; border-width:0 0 1px;\">2009年8月－2009年9月</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"center\" width=\"20%\" height=\"30px\" valign=\"middle\" style=\"border:solid 0 #AAA; border-bottom-width:1px;border-right-width:1px;\">开发者</td>\r\n");
      out.write("            <td align=\"left\" width=\"80%\" valign=\"middle\" style=\"border:solid  #AAA; border-width:0 0 1px;\">中山大学 张广  (zhguang_sysu@163.com)</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"center\" width=\"20%\" height=\"30px\" valign=\"middle\" style=\"border:solid 0 #AAA; border-bottom-width:1px;border-right-width:1px;\">主要编程语言</td>\r\n");
      out.write("            <td align=\"left\" width=\"80%\" valign=\"middle\" style=\"border:solid  #AAA; border-width:0 0 1px;\">JSP</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"center\" width=\"20%\" height=\"30px\" valign=\"middle\" style=\"border:solid 0 #AAA; border-bottom-width:1px;border-right-width:1px;\">运行环境</td>\r\n");
      out.write("            <td align=\"left\" width=\"80%\" valign=\"middle\" style=\"border:solid  #AAA; border-width:0 0 1px;\">JDK 1.6 以上 + Apache Tomcat 6.0</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"center\" width=\"20%\" height=\"30px\" valign=\"middle\" style=\"border:solid 0 #AAA; border-bottom-width:1px;border-right-width:1px;\">数据库</td>\r\n");
      out.write("            <td align=\"left\" width=\"80%\" valign=\"middle\" style=\"border:solid  #AAA; border-width:0 0 1px;\">Microsoft SQL Server 2005</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"center\" width=\"20%\" height=\"30px\" valign=\"middle\" style=\"border:solid 0 #AAA; border-bottom-width:1px;border-right-width:1px;\">维护</td>\r\n");
      out.write("            <td align=\"left\" width=\"80%\" valign=\"middle\" style=\"border:solid  #AAA; border-width:0 0 1px;\">中山大学 张广 (zhguang_sysu@163.com)</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"center\" width=\"20%\" height=\"40px\" valign=\"middle\" style=\"border:solid 0 #AAA;border-right-width:1px; border-bottom-width:1px;\">管理员列表</td>\r\n");
      out.write("            <td align=\"left\" width=\"80%\" valign=\"middle\" style=\"border:solid 0 #AAA; border-width:0 0 1px;\"><ul>\r\n");
      out.write("                <li>张永民老师</li>\r\n");
      out.write("                <li>张广</li>\r\n");
      out.write("              </ul></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"center\" width=\"20%\" valign=\"middle\" style=\"border:solid 0 #AAA;border-right-width:1px;\">网站通告</td>\r\n");
      out.write("            <td align=\"left\" width=\"80%\" valign=\"middle\" style=\"border:solid 0 #AAA;padding-left:20px;padding-right:20px;\"><span style=\"color:#808080;\"> 各位使用本后台的管理员请<span style=\"color:#F00;\">注意：</span><br/>\r\n");
      out.write("              <br/>如遇到技术问题，可以在前台留言板发布留言，或者直接Email：zhguang_sysu@163.com </span></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("      <div id=\"bottom\">\r\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/bottom.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
	
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
