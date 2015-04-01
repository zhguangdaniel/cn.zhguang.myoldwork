package org.apache.jsp.jsp.manage.search;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import news.*;
import info.*;
import files.*;
import java.sql.*;
import java.util.ArrayList;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      info.InfoBean info = null;
      synchronized (_jspx_page_context) {
        info = (info.InfoBean) _jspx_page_context.getAttribute("info", PageContext.PAGE_SCOPE);
        if (info == null){
          info = new info.InfoBean();
          _jspx_page_context.setAttribute("info", info, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      files.FilesBean files = null;
      synchronized (_jspx_page_context) {
        files = (files.FilesBean) _jspx_page_context.getAttribute("files", PageContext.PAGE_SCOPE);
        if (files == null){
          files = new files.FilesBean();
          _jspx_page_context.setAttribute("files", files, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<!--[if lte IE 6]>\r\n");
      out.write("<link href=\"/css/contentButtonIE6.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<title>网工后台管理－搜索结果</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	boolean isLog = false;
	try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
	if (!isLog) {
		session.setAttribute("isLog", new String("0"));
		session.setAttribute("loginMsg", new String("您还未登录，请先登录！"));
		response.sendRedirect("/jsp/manage/");
	} else {

      out.write("\r\n");
      out.write("<!--全部区域-->\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("  <!--头部-->\r\n");
      out.write("  <div id=\"header\">\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/header.jsp", out, true);
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("  <!--主区，包括菜单区（垂直导航条）和工作区-->\r\n");
      out.write("  <div id=\"mainContent\">\r\n");
      out.write("    <div id=\"leftMenu\">\r\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/leftMenu.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"rightMain\">\r\n");
      out.write("      <div id=\"contentHeader\">\r\n");
      out.write("        <div style=\"float:left;\">&nbsp;&nbsp;搜索结果：</div>\r\n");
      out.write("      </div>\r\n");
      out.write("      ");

		request.setCharacterEncoding("utf-8");
		String keyword = request.getParameter("searchKeyword");
		String currentURL = "http://"+request.getServerName()+":"+request.getServerPort()+request.getRequestURI()+"?"+request.getQueryString();

      out.write("\r\n");
      out.write("      <div class=\"bar\" style=\"clear:both;\">新闻</div>\r\n");
      out.write("      <div class=\"titleItemsFrame\">\r\n");
      out.write("        <ul>\r\n");
      out.write("          ");

			ArrayList<SingleNews> newsList = news.searchNews(keyword);
			if (newsList.size() == 0) {
	
      out.write("\r\n");
      out.write("          <li><span>无记录</span></li>\r\n");
      out.write("          ");

			} else {
				while (newsList.size() != 0) {
					SingleNews aNews = newsList.remove(0);
					String title = aNews.getTitle();
					String time = aNews.getCreateTime().substring(0, 16);
	
      out.write("\r\n");
      out.write("          <li><a href=\"/jsp/manage/newsManage/showNews.jsp?id=");
      out.print(aNews.getId());
      out.write("&parent=");
      out.print(currentURL);
      out.write("\"\r\n");
      out.write("\t\ttarget=\"_blank\" style=\" width:75%; float:left;\">");
      out.print(title);
      out.write("</a><span\r\n");
      out.write("\t\tstyle=\" width:20%; float:right;\">");
      out.print(time);
      out.write("</span></li>\r\n");
      out.write("          ");

			}
			}
	
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"bar\" style=\" clear:both;\">通知</div>\r\n");
      out.write("      <div class=\"titleItemsFrame\">\r\n");
      out.write("        <ul>\r\n");
      out.write("          ");

			ArrayList<Info> infoList = info.searchInfo(keyword);
			if (infoList.size() == 0) {
	
      out.write("\r\n");
      out.write("          <li><span>无记录</span></li>\r\n");
      out.write("          ");

			} else {
				while (infoList.size() != 0) {
					Info i = infoList.remove(0);
					String title = i.getTitle();
					String time = i.getCreateTime().substring(0, 16);
	
      out.write("\r\n");
      out.write("          <li><a href=\"/jsp/manage/infoManage/showInfo.jsp?id=");
      out.print(i.getId());
      out.write("&parent=");
      out.print(currentURL);
      out.write("\" target=\"_blank\"\r\n");
      out.write("\t\tstyle=\" width:75%; float:left;\">");
      out.print(title);
      out.write("</a><span\r\n");
      out.write("\t\tstyle=\" width:20%; float:right;\">");
      out.print(time);
      out.write("</span></li>\r\n");
      out.write("          ");

			}
			}
	
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"bar\" style=\"clear:both;\">文件下载</div>\r\n");
      out.write("      <div class=\"titleItemsFrame\">\r\n");
      out.write("        <ul>\r\n");
      out.write("          ");

			ArrayList<SingleFile> filesList = files.searchFiles(keyword);
			if (filesList.size() == 0) {
	
      out.write("\r\n");
      out.write("          <li><span>无记录</span></li>\r\n");
      out.write("          ");

			} else {
				while (filesList.size() != 0) {
					SingleFile f = filesList.remove(0);
					String name = f.getName();
					String time = f.getUploadtime().substring(0, 16);
	
      out.write("\r\n");
      out.write("          <li><a href=\"/jsp/files/download.jsp?name=");
      out.print(name);
      out.write("&id=");
      out.print(f.getId() );
      out.write("&storeType=0\" target=\"_blank\" style=\" width:75%; float:left;\">");
      out.print(name);
      out.write("</a><span\r\n");
      out.write("\t\tstyle=\" width:20%; float:right;\">");
      out.print(time);
      out.write("</span></li>\r\n");
      out.write("          ");

			}
			}
	
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div id=\"bottom\">\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/bottom.jsp", out, true);
      out.write("\r\n");
      out.write("  </div>\r\n");
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
