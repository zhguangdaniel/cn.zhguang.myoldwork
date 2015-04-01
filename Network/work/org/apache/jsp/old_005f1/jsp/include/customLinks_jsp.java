package org.apache.jsp.old_005f1.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import customLinks.*;
import java.sql.*;
import java.util.ArrayList;

public final class customLinks_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			"jsp/error/error.jsp", true, 8192, true);
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
      customLinks.LinksBean links = null;
      synchronized (_jspx_page_context) {
        links = (customLinks.LinksBean) _jspx_page_context.getAttribute("links", PageContext.PAGE_SCOPE);
        if (links == null){
          links = new customLinks.LinksBean();
          _jspx_page_context.setAttribute("links", links, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');

ArrayList<Link> linksList = links.getTopCountLinks(15);

      out.write("\r\n");
      out.write("<table width=\"200\" height=\"200\" align=\"center\"  cellpadding=\"0\"\r\n");
      out.write("\tcellspacing=\"0\" border=\"0\">\r\n");
      out.write("    <tr class=\"bar\">\r\n");
      out.write("        <td align=\"left\" style=\"padding-left:10px;\">相关链接</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td height=\"180px\" align=\"left\" valign=\"top\">\r\n");
      out.write("        <marquee direction=\"up\" scrollamount=\"1\" scrolldelay=\"50\" onmouseover=\"this.stop()\" onmouseout=\"this.start()\" width=\"100%\" height=\"100%\">\r\n");
      out.write("        ");

        while(linksList.size()!=0){
        	Link l = linksList.remove(0);
			String lText = l.getText();
			String aText = lText;
			if(lText.length()>15){
				aText=lText.substring(0,14)+"...";
			}
        
      out.write("\r\n");
      out.write("        <a href=\"");
      out.print(l.getLink());
      out.write("\" target=\"_blank\" class=\"text\" style=\"line-height:20px;\" title=");
      out.print(lText );
      out.write(">&nbsp;&middot;");
      out.print(aText);
      out.write("</a><br />\r\n");
      out.write("\t\t");
}
      out.write(" \r\n");
      out.write("        </marquee>\r\n");
      out.write("        </td>\r\n");
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
