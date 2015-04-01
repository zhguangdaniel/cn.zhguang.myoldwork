package org.apache.jsp.jsp.manage.newsManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import news.*;
import user.*;

public final class showNews_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link href=\"/css/manageContent.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<!--[if lte IE 6]>\r\n");
      out.write("<link href=\"/css/contentButtonIE6.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<![endif]-->\r\n");
      news.NewsBean newsBean = null;
      synchronized (_jspx_page_context) {
        newsBean = (news.NewsBean) _jspx_page_context.getAttribute("newsBean", PageContext.PAGE_SCOPE);
        if (newsBean == null){
          newsBean = new news.NewsBean();
          _jspx_page_context.setAttribute("newsBean", newsBean, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/manage.js\"></script>\r\n");
      out.write("<title>网工后台管理－新闻内容</title>\r\n");
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
		String auth = (String) session.getAttribute("userAuthority");
		SingleNews news = newsBean.getNews(Integer.parseInt(request.getParameter("id")));
		String parentURL = request.getParameter("parent");
		String currentURL = "http://"+request.getServerName()+":"+request.getServerPort()+request.getRequestURI()+"?"+request.getQueryString();
		String curUser = (String) session.getAttribute("userName");

      out.write("\r\n");
      out.write("<!--全部区域-->\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("    <!--头部-->\r\n");
      out.write("    <div id=\"header\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/header.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--主区，包括菜单区（垂直导航条）和工作区-->\r\n");
      out.write("    <div id=\"mainContent\">\r\n");
      out.write("        <div id=\"leftMenu\">\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/leftMenu.jsp", out, true);
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"rightMain\">\r\n");
      out.write("            <div id=\"contentHeader\"><div style=\"float:left;\">&nbsp;&nbsp;<a href=\"/jsp/manage/\" class=\"normalLink\">后台管理</a> &nbsp;&gt;&nbsp;<a href=\"/jsp/manage/newsManage/news.jsp?page=1\" class=\"normalLink\">新闻管理</a> &nbsp;&gt;&nbsp;新闻内容&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"/images/download.png\" width=\"12\" height=\"9\" />");
if(User.checkHaveAuthority(auth,User.editNews)||curUser.equals(news.getCreater())){ 
      out.write("&nbsp;&nbsp;<img src=\"/images/Edit.png\" width=\"12\" height=\"12\" /><a\r\n");
      out.write("                href=\"/jsp/manage/newsManage/editNews.jsp?id=");
      out.print(news.getId());
      out.write("&parent=");
      out.print(currentURL);
      out.write("\" target=\"_self\" class=\"normalLink\" style=\"color:#069\" >修改</a>");
};if(User.checkHaveAuthority(auth,User.delNews)||curUser.equals(news.getCreater())){ 
      out.write("&nbsp;&nbsp;&nbsp;<img src=\"/images/Delete.png\" width=\"12\" height=\"12\" /><a\r\n");
      out.write("                href=\"/jsp/manage/newsManage/delNews.jsp?id=");
      out.print(news.getId());
      out.write("&parent=");
      out.print(parentURL);
      out.write("\" target=\"_self\" class=\"normalLink\" style=\"color:#069\" onclick=\"return onDelete()\" >删除</a>");
} 
      out.write("</div>\r\n");
      out.write("                ");
if(User.checkHaveAuthority(auth,User.publishNews)){ 
      out.write("\r\n");
      out.write("                <div id=\"tempContentHeader\">\r\n");
      out.write("                    <div id=\"contentButton\">\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li><a href=\"/jsp/manage/newsManage/publishNews.jsp\" target=\"_self\"><img src=\"/images/New.png\" width=\"16\" height=\"16\" />&nbsp;&nbsp;发布新闻</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
} 
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"contentFrame\">\r\n");
      out.write("                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td align=\"center\" height=\"30px\" valign=\"middle\"  id=\"title\">");
      out.print(news.getTitle());
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td align=\"center\" height=\"20px\" valign=\"bottom\" id=\"articleInfo\">");
if(!(news.getCreater()==null)&& !news.getCreater().equals("")){
      out.write("\r\n");
      out.write("                            发布者：");
      out.print(news.getCreater());
      out.write("&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("                            发布于：");
      out.print(news.getCreateTime().substring(0,16));
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td height=\"5px\" width=\"100%\" valign=\"top\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td align=\"left\" width=\"100%\" valign=\"top\"><span>");
      out.print(news.getContent());
      out.write("</span></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("        ");

	if (news.getModifyTime() != null) {
	
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td align=\"left\" height=\"20px\" width=\"100%\" valign=\"middle\"><span\r\n");
      out.write("\t\t\tid=\"bottomTips\">本文于&nbsp;");
      out.print(news.getModifyTime().substring(0, 16));
      out.write("&nbsp;被");

		if ((news.getModifyUser()!=null) && !news.getModifyUser().equals("")) {
		
      out.write("\r\n");
      out.write("                &nbsp;");
      out.print(news.getModifyUser());
      out.write("&nbsp;\r\n");
      out.write("        ");
}
      out.write("修改</span></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");

	}
	
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"bottom\">\r\n");
      out.write("        ");
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
