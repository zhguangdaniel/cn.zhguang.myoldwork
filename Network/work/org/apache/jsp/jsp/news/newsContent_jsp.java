package org.apache.jsp.jsp.news;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import news.*;

public final class newsContent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link href=\"/css/news.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"/css/main.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      news.NewsBean newsBean = null;
      synchronized (_jspx_page_context) {
        newsBean = (news.NewsBean) _jspx_page_context.getAttribute("newsBean", PageContext.PAGE_SCOPE);
        if (newsBean == null){
          newsBean = new news.NewsBean();
          _jspx_page_context.setAttribute("newsBean", newsBean, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<div class=\"breadcrumbs\"><a href=\"/\">首页</a> &nbsp;&gt;&nbsp;<a href=\"/jsp/news/newsList.jsp?page=1\">新闻中心</a> &nbsp;&gt;&nbsp;新闻</div>\r\n");

			SingleNews news = newsBean.getNews(Integer.parseInt(request
			.getParameter("id")));

      out.write("\r\n");
      out.write("<div class=\"news\">\r\n");
      out.write("  <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"\r\n");
      out.write("\tborder=\"0\">\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td align=\"center\" height=\"30px\" valign=\"middle\" class=\"title\">");
      out.print(news.getTitle());
      out.write("</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td align=\"center\" height=\"20px\" valign=\"bottom\" class=\"newsInfo\">");

		if (!news.getCreater().equals("") && !(news.getCreater() == null)) {
		
      out.write("\r\n");
      out.write("        发布者：");
      out.print(news.getCreater());
      out.write("&nbsp;&nbsp;&nbsp;\r\n");
      out.write("        ");

		}
		
      out.write("\r\n");
      out.write("        发布于：");
      out.print(news.getCreateTime().substring(0, 16));
      out.write("</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td height=\"5px\" width=\"100%\" valign=\"top\"></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td align=\"left\" width=\"100%\" valign=\"top\"><span>");
      out.print(news.getContent());
      out.write("</span></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td height=\"20px\" width=\"100%\" valign=\"top\"></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    ");

	if (news.getModifyTime() != null) {
	
      out.write("\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td align=\"left\" height=\"20px\" width=\"100%\" valign=\"middle\"><span\r\n");
      out.write("\t\t\tclass=\"bottomTips\">本文于&nbsp;");
      out.print(news.getModifyTime().substring(0, 16));
      out.write("&nbsp;被\r\n");
      out.write("        ");

		if ((news.getModifyUser()!=null) && !news.getModifyUser().equals("")) {
		
      out.write("\r\n");
      out.write("        &nbsp;");
      out.print(news.getModifyUser());
      out.write("&nbsp;\r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("        修改</span></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    ");

	}
	
      out.write("\r\n");
      out.write("  </table>\r\n");
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
