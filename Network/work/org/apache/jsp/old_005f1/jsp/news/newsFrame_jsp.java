package org.apache.jsp.old_005f1.jsp.news;

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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"/old_1/css/style.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      news.NewsBean news = null;
      synchronized (_jspx_page_context) {
        news = (news.NewsBean) _jspx_page_context.getAttribute("news", PageContext.PAGE_SCOPE);
        if (news == null){
          news = new news.NewsBean();
          _jspx_page_context.setAttribute("news", news, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");

ArrayList<SingleNews> newsList = news.getTopCountNews(8);


      out.write("\r\n");
      out.write("<table width=\"358\" height=\"213\" align=\"center\"  cellpadding=\"0\"\r\n");
      out.write("\tcellspacing=\"0\" border=\"0\">\r\n");
      out.write("    <tr class=\"bar\">\r\n");
      out.write("        <td align=\"left\" style=\"padding-left:10px;\">新闻中心</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td height=\"173px\" align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\"cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("        ");

        while(newsList.size()!=0){
        	SingleNews aNews = newsList.remove(0);
			String title = aNews.getTitle();
			String aTitle = title;
			if(title.length()>24){
				aTitle=title.substring(0,23)+"...";
			}
        
      out.write("\r\n");
      out.write("        \t<tr>\r\n");
      out.write("                <td width=\"87%\" height=\"22px\" align=\"left\"><img src=\"/old_1/images/news.png\" width=\"12\" height=\"12\" /><a href=\"/old_1/jsp/news/news.jsp?id=");
      out.print(aNews.getId());
      out.write("\" target=\"_blank\" class=\"text\" title=");
      out.print(title);
      out.write('>');
      out.print(aTitle);
      out.write("</a></td>\r\n");
      out.write("                <td width=\"83%\"><span id=\"newsDate\">[");
      out.print(aNews.getCreateTime().substring(5,10));
      out.write("]</span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        ");
 
        }
        
      out.write("\r\n");
      out.write("            </table></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    <td align=\"right\" valign=\"middle\"><a href=\"/old_1/jsp/news/newsList.jsp?page=1\" class=\"more\">>>more&nbsp;&nbsp;</a></td>\r\n");
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
