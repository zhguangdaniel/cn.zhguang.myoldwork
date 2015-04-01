package org.apache.jsp.old_005f1.jsp.info;

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
      out.write("<link href=\"/old_1/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"/old_1/css/info.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
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
      out.write("        <div id=\"breadcrumbs\"> <a href=\"/old_1/index.jsp\" class=\"normalLink\">首页</a> &gt;通知列表 </div>\r\n");
      out.write("        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n");
      out.write("            ");

        while(pageCtrl.resultList.size()!=0){
        	Info i = (Info)pageCtrl.resultList.remove(0);
			String title = i.getTitle();
			String aTitle = title;
			if(title.length()>31){
				aTitle=title.substring(0,30)+"...";
			}
        
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td width=\"15%\" height=\"30px\"></td>\r\n");
      out.write("                <td width=\"55%\" height=\"30px\" align=\"left\"><img src=\"/old_1/images/news.png\" width=\"12\" height=\"12\" /><a href=\"/old_1/jsp/info/info.jsp?id=");
      out.print(i.getId());
      out.write("\" target=\"_blank\" class=\"text\" title=");
      out.print(title);
      out.write('>');
      out.print(aTitle);
      out.write("</a></td>\r\n");
      out.write("                <td width=\"15%\" align=\"left\"><span id=\"newsDate\">[");
      out.print(i.getCreateTime().substring(0,10));
      out.write("]</span></td>\r\n");
      out.write("                <td width=\"15%\"></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("            <tr><td height=\"10px\" colspan=\"4\"></td></tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <div id=\"pageCtrlFrame\">\r\n");
      out.write("            ");
out.print(pageCtrl.printCtrl());
      out.write("\r\n");
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
