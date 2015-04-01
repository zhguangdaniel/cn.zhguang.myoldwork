package org.apache.jsp.old_005f1.jsp.files;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import files.*;
import java.sql.*;
import java.util.ArrayList;

public final class filesFrame_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      files.FilesBean files = null;
      synchronized (_jspx_page_context) {
        files = (files.FilesBean) _jspx_page_context.getAttribute("files", PageContext.PAGE_SCOPE);
        if (files == null){
          files = new files.FilesBean();
          _jspx_page_context.setAttribute("files", files, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");

ArrayList<SingleFile> filesList = files.getTopCountFiles(7);


      out.write("\r\n");
      out.write("<table width=\"569\" height=\"207\" align=\"center\"  cellpadding=\"0\"\r\n");
      out.write("\tcellspacing=\"0\" border=\"0\">\r\n");
      out.write("    <tr class=\"bar\">\r\n");
      out.write("        <td align=\"left\" style=\"padding-left:10px;\">最新文件下载</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td height=\"167px\" align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\"cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("        ");

        while(filesList.size()!=0){
        	SingleFile f = filesList.remove(0);
			String name = f.getName();
			String aName = name;
			if(name.length()>35){
				aName=name.substring(0,34)+"...";
			}
        
      out.write("\r\n");
      out.write("        \t<tr>\r\n");
      out.write("                <td width=\"86%\" height=\"24px\" align=\"left\"><img src=\"/old_1/images/news.png\" width=\"12\" height=\"12\" />\r\n");
      out.write("                <span id=\"blackText\" title=");
      out.print(name.replaceAll(" ",""));
      out.write('>');
      out.print(aName);
      out.write("&nbsp;&nbsp;&nbsp;</span><a href=\"/old_1/jsp/files/download.jsp?name=");
      out.print(aName);
      out.write("&amp;id=");
      out.print(f.getId() );
      out.write("\" target=\"_blank\" class=\"normalLink\" >下载</a></td>\r\n");
      out.write("                <td width=\"14%\"><span id=\"newsDate\">[");
      out.print(f.getUploadtime().substring(0,10));
      out.write("]</span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        ");
 
        }
        
      out.write("\r\n");
      out.write("            </table></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    <td align=\"right\" valign=\"middle\"><a href=\"/old_1/jsp/files/files.jsp?page=1\" class=\"more\">>>more&nbsp;&nbsp;</a></td>\r\n");
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
