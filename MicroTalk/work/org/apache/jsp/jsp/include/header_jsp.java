package org.apache.jsp.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link href=\"/css/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");

	boolean isLog = false;
	try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}

      out.write("\r\n");
      out.write("<div class=\"headerTop\">\r\n");
      out.write("  <div class=\"headerTopContent\"> <span id=\"showTime\" class=\"clockFrame\"></span>\r\n");
      out.write("    ");
 if (!isLog) {
      out.write("\r\n");
      out.write("    <span><a href=\"/\" target=\"_self\">登录</a></span> <span\r\n");
      out.write("\tclass=\"headerTopShortLine\">|</span> <span><a href=\"/register\" target=\"_blank\">注册</a></span>\r\n");
      out.write("    ");
}else{ 
      out.write("\r\n");
      out.write("    <span><a href=\"/logout\" target=\"_self\">退出</a></span>\r\n");
      out.write("    ");
} 
      out.write("\r\n");
      out.write("    <span\r\n");
      out.write("\tclass=\"headerTopShortLine\">|</span> <span><a href=\"/\">搜索</a></span></div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"banner\">\r\n");
      out.write("  <div class=\"bannerContent\"><span><img\r\n");
      out.write("\tsrc=\"/images/enjoybyself.png\" /><a href=\"/\">随便看看</a></span> <span><img\r\n");
      out.write("\tsrc=\"/images/recommand.png\" /><a href=\"/\">推荐给朋友</a></span></div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"headerNav\" class=\"nav\">\r\n");
      out.write("  <ul>\r\n");
      out.write("    <li><a href=\"/\" target=\"_self\">&nbsp;首页</a></li>\r\n");
      out.write("    <li><a href=\"/\" target=\"_blank\">&nbsp;话题动态</a></li>\r\n");
      out.write("    <li><a href=\"/\" target=\"_blank\">&nbsp;人气榜</a></li>\r\n");
      out.write("    ");
 if (isLog) {
      out.write("\r\n");
      out.write("    <li><a href=\"/myIndex\" target=\"_blank\">&nbsp;我的首页</a></li>\r\n");
      out.write("    ");
}
      out.write("\r\n");
      out.write("    <li><a href=\"/\" target=\"_blank\">&nbsp;部落</a></li>\r\n");
      out.write("  </ul>\r\n");
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
