package org.apache.jsp.jsp.news;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import news.*;
import java.sql.*;
import java.util.ArrayList;

public final class newsFrame_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link href=\"/css/main.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      news.NewsBean news = null;
      synchronized (_jspx_page_context) {
        news = (news.NewsBean) _jspx_page_context.getAttribute("news", PageContext.PAGE_SCOPE);
        if (news == null){
          news = new news.NewsBean();
          _jspx_page_context.setAttribute("news", news, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');

ArrayList<SingleNews> newsList = news.getTopCountNews(8);

      out.write("\r\n");
      out.write("<div style=\"width:240px;\">\r\n");
      out.write("  <div class=\"bar\">新闻</div>\r\n");
      out.write("  <div class=\"titleItemsFrame\">\r\n");
      out.write("    <ul>\r\n");
      out.write("      ");

        while(newsList.size()!=0){
        	SingleNews aNews = newsList.remove(0);
			String title = aNews.getTitle();
			String time = aNews.getCreateTime().substring(0,16);
        
      out.write("\r\n");
      out.write("      <li><a href=\"/jsp/news/news.jsp?id=");
      out.print(aNews.getId());
      out.write("\" target=\"_blank\">");
      out.print(title);
      out.write("</a><span>");
      out.print(time);
      out.write("</span></li>\r\n");
      out.write("      ");
 
        }
        
      out.write("\r\n");
      out.write("      <div style=\"text-align:right; padding-right:10px;\"><a href=\"/jsp/news/newsList.jsp?page=1\"><img src=\"/images/moreNews.jpg\" /></a></div>\r\n");
      out.write("    </ul>\r\n");
      out.write("  </div>\r\n");
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
