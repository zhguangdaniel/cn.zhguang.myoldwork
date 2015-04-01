package org.apache.jsp.jsp.files;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import files.*;
import java.sql.*;
import java.util.ArrayList;

public final class files_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>网工－文件下载</title>\r\n");
      out.write("<link href=\"/css/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"/css/file.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      files.FilesBean filesBean = null;
      synchronized (_jspx_page_context) {
        filesBean = (files.FilesBean) _jspx_page_context.getAttribute("filesBean", PageContext.PAGE_SCOPE);
        if (filesBean == null){
          filesBean = new files.FilesBean();
          _jspx_page_context.setAttribute("filesBean", filesBean, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      page.PageBean pageCtrl = null;
      synchronized (_jspx_page_context) {
        pageCtrl = (page.PageBean) _jspx_page_context.getAttribute("pageCtrl", PageContext.PAGE_SCOPE);
        if (pageCtrl == null){
          pageCtrl = new page.PageBean();
          _jspx_page_context.setAttribute("pageCtrl", pageCtrl, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!--头部header-->\r\n");
      out.write("<div class=\"header\">\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/header.jsp", out, true);
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!--//header-->\r\n");
      out.write("<!--主体容器container-->\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("  <!--内容区content，包括菜单和主内容-->\r\n");
      out.write("  <div class=\"content\">\r\n");
      out.write("    <!--左边内容框leftContentFrame-->\r\n");
      out.write("    <div class=\"leftContentFrame\">\r\n");
      out.write("      <!--左边菜单框leftMenuFrame-->\r\n");
      out.write("      <div class=\"leftMenuFrame\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/leftMenu.jsp", out, true);
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      <!--//leftMenuFrame-->\r\n");
      out.write("      <div class=\"imgLinksFrame\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/imgLinks.jsp", out, true);
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"customLinksFrame\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/customLinks.jsp", out, true);
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--右边内容框rightContentFrame-->\r\n");
      out.write("    <div class=\"rightContentFrame\">\r\n");
      out.write("      <div class=\"breadcrumbs\"> <a href=\"/\">首页</a> &nbsp;&gt;&nbsp;文件下载 </div>\r\n");
      out.write("      ");

	int curPage = Integer.parseInt(request.getParameter("page"));
	pageCtrl = filesBean.getPage(curPage, 8);
	String currentURL = "http://"+request.getServerName()+":"+request.getServerPort()+request.getRequestURI()+"?"+request.getQueryString();

      out.write("\r\n");
      out.write("      <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td width=\"30px\" height=\"10px\"></td>\r\n");
      out.write("          <td align=\"right\"></td>\r\n");
      out.write("          <td width=\"90px\" align=\"right\"></td>\r\n");
      out.write("          <td width=\"15px\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");

			while (pageCtrl.resultList.size() != 0) {
			SingleFile f = (SingleFile) pageCtrl.resultList.remove(0);
			String name = f.getName();
			int id = f.getId();
			String description = f.getDescription();
			if(description==null)description="";
			String aDescription = description;
			String aName = name;
			if (name.length() > 36) {
				aName = name.substring(0, 35) + "...";
			}
			if (description.length() > 90) {
				aDescription = description.substring(0, 89) + "...";
			}
	
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td height=\"30px\" align=\"right\"><img src=\"/images/sectionArrow.gif\" width=\"12\" height=\"12\" /></td>\r\n");
      out.write("          <td height=\"30px\" align=\"left\" style=\"border-bottom: dashed 1px #AAA;\"><span class=\"fileName\" title=");
      out.print(name.replaceAll(" ",""));
      out.write('>');
      out.print(aName);
      out.write("&nbsp;&nbsp;&nbsp;</span><a\r\n");
      out.write("                href=\"/jsp/files/download.jsp?id=");
      out.print(id );
      out.write("\" target=\"_blank\" class=\"blueText\" >点击下载</a></td>\r\n");
      out.write("          <td align=\"right\" style=\"border-bottom:dashed 1px #AAA;\"><span class=\"dateText\">[");
      out.print(f.getUploadtime().substring(0, 10));
      out.write("]</span></td>\r\n");
      out.write("          <td></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td height=\"40px\"></td>\r\n");
      out.write("          <td height=\"40px\" align=\"right\" valign=\"top\"><div style=\"font-family:Arial, '宋体'; font-size:12px; color: #999; line-height:20px; float:left; text-align:right; width:16%;\">相关描述：&nbsp;&nbsp;</div>\r\n");
      out.write("            <div class=\"fileDescription\" style=\"float:right; width:83%;\" title=\"");
      out.print(description);
      out.write('"');
      out.write('>');
      out.print(aDescription);
      out.write("</div></td>\r\n");
      out.write("          <td></td>\r\n");
      out.write("          <td></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");

	}
	
      out.write("\r\n");
      out.write("      </table>\r\n");
      out.write("      <div class=\"pageCtrlFrame\">\r\n");
      out.write("        ");

out.print(pageCtrl.printCtrl());

      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--//rightContentFrame-->\r\n");
      out.write("  </div>\r\n");
      out.write("  <!--content-->\r\n");
      out.write("</div>\r\n");
      out.write("<!--container-->\r\n");
      out.write("<!--底部bottom-->\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/footer.jsp", out, true);
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!--//bottom-->\r\n");
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
