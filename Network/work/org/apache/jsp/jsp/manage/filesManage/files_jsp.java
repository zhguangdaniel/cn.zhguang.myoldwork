package org.apache.jsp.jsp.manage.filesManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import files.*;
import user.*;

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
      out.write("<script type=\"text/javascript\" src=\"/js/files.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/manage.js\"></script>\r\n");
      out.write("<title>网工后台管理－文件管理</title>\r\n");
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
		String curUser = (String) session.getAttribute("userName");
		String currentURL = "http://"+request.getServerName()+":"+request.getServerPort()+request.getRequestURI()+"?"+request.getQueryString();

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
      out.write("            <div id=\"contentHeader\"><div style=\"float:left\">&nbsp;&nbsp;所有文件：</div>\r\n");
      out.write("            ");
if(User.checkHaveAuthority(auth,User.uploadFile)){ 
      out.write("\r\n");
      out.write("                <div id=\"tempContentHeader\">\r\n");
      out.write("                    <div id=\"contentButton\">\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li><a href=\"/jsp/manage/filesManage/upload.jsp?&parent=");
      out.print(currentURL);
      out.write("\" target=\"_self\"><img src=\"/images/upload.png\" width=\"13\" height=\"14\" />&nbsp;&nbsp;上传文件</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
} 
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            ");

	int curPage = Integer.parseInt(request.getParameter("page"));
	pageCtrl = filesBean.getPage(curPage, 8);

      out.write("\r\n");
      out.write("            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"20px\"></td>\r\n");
      out.write("                    <td width=\"110px\" align=\"left\"></td>\r\n");
      out.write("                    <td align=\"right\"></td>\r\n");
      out.write("                    <td width=\"100px\" align=\"right\"></td>\r\n");
      out.write("                    <td width=\"20px\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

			while (pageCtrl.resultList.size() != 0) {
				SingleFile f = (SingleFile) pageCtrl.resultList.remove(0);
				String name = f.getName();
				int id = f.getId();
				String description = f.getDescription();
				String creator = f.getCreator();
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
      out.write("                <tr>\r\n");
      out.write("                    <td height=\"30px\"></td>\r\n");
      out.write("                    <td height=\"30px\" align=\"left\" colspan=\"2\" style=\"border-bottom: dashed 1px #AAA;\"><img src=\"/images/news.png\" width=\"14\" height=\"14\" /><span id=\"fileTitle\" title=");
      out.print(name.replaceAll(" ",""));
      out.write('>');
      out.print(aName);
      out.write("&nbsp;&nbsp;&nbsp;</span><img src=\"/images/saveFile.png\" width=\"14\" height=\"14\" /><a\r\n");
      out.write("                href=\"/jsp/files/download.jsp?id=");
      out.print(id );
      out.write("\" target=\"_blank\" class=\"normalLink\" >点击下载</a>");
if(User.checkHaveAuthority(auth,User.delFile)||curUser.equals(creator)){ 
      out.write(" &nbsp;&nbsp;&nbsp;<img src=\"/images/Delete.png\" width=\"12\" height=\"12\" /><a href=\"/jsp/manage/filesManage/delFile.jsp?id=");
      out.print(id);
      out.write("&parent=");
      out.print(currentURL);
      out.write("\" target=\"_self\" class=\"normalLink\" onclick=\"return onDelete()\" >删除</a>");
} 
      out.write("</td>\r\n");
      out.write("                    <td align=\"left\" style=\"border-bottom:dashed 1px #AAA;\"><span id=\"date\">[");
      out.print(f.getUploadtime().substring(0, 10));
      out.write("]</span></td>\r\n");
      out.write("                    <td></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td height=\"40px\"></td>\r\n");
      out.write("                    <td height=\"40px\" align=\"right\" valign=\"top\" colspan=\"2\" >\r\n");
      out.write("                    <div style=\"font-family:Arial, '宋体'; font-size:12px; color: #999; line-height:20px; float:left; text-align:right; width:17%;\">相关描述：&nbsp;&nbsp;</div>\r\n");
      out.write("                    <div id=\"summary\" style=\"float:right; width:80%; margin-right:10px;\" title=\"");
      out.print(description);
      out.write('"');
      out.write('>');
      out.print(aDescription);
      out.write("</div></td>\r\n");
      out.write("                    <td></td>\r\n");
      out.write("                    <td></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

			}//while
			
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td height=\"10px\" colspan=\"5\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("            <div id=\"pageCtrlFrame\" style=\" margin-bottom:10px;\">\r\n");
      out.write("                ");

			out.print(pageCtrl.printCtrl());
			
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"bottom\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/bottom.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
	
	}//else

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
