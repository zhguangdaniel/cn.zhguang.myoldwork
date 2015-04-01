package org.apache.jsp.jsp.info;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import info.*;
import java.lang.Integer;

public final class infoList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>网工－通知信息</title>\r\n");
      out.write("<link href=\"/css/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"/css/info.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      info.InfoBean infoBean = null;
      synchronized (_jspx_page_context) {
        infoBean = (info.InfoBean) _jspx_page_context.getAttribute("infoBean", PageContext.PAGE_SCOPE);
        if (infoBean == null){
          infoBean = new info.InfoBean();
          _jspx_page_context.setAttribute("infoBean", infoBean, PageContext.PAGE_SCOPE);
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

int curPage = Integer.parseInt(request.getParameter("page"));
pageCtrl=infoBean.getPage(curPage,20);

      out.write("\r\n");
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
      out.write("      <div class=\"breadcrumbs\"> <a href=\"/\">首页</a> &nbsp;&gt;&nbsp;通知信息 </div>\r\n");
      out.write("      <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n");
      out.write("        ");

        while(pageCtrl.resultList.size()!=0){
        	Info i = (Info)pageCtrl.resultList.remove(0);
			String title = i.getTitle();
			String time = i.getCreateTime().substring(0,16);
        
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td width=\"10%\" height=\"30px\" align=\"right\"><img src=\"/images/sectionArrow.gif\" width=\"12\" height=\"12\" /></td>\r\n");
      out.write("          <td width=\"60%\" height=\"30px\" align=\"left\"><a href=\"/jsp/info/info.jsp?id=");
      out.print(i.getId());
      out.write("\" target=\"_blank\" class=\"text\">");
      out.print(title);
      out.write("</a></td>\r\n");
      out.write("          <td width=\"20%\" align=\"left\"><span class=\"dateText\">[");
      out.print(time);
      out.write("]</span></td>\r\n");
      out.write("          <td width=\"10%\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td height=\"10px\" colspan=\"4\"></td>\r\n");
      out.write("        </tr>\r\n");
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
