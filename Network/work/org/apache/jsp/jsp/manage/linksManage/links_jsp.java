package org.apache.jsp.jsp.manage.linksManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import customLinks.*;
import java.sql.*;
import java.util.ArrayList;
import user.*;

public final class links_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      customLinks.LinksBean links = null;
      synchronized (_jspx_page_context) {
        links = (customLinks.LinksBean) _jspx_page_context.getAttribute("links", PageContext.PAGE_SCOPE);
        if (links == null){
          links = new customLinks.LinksBean();
          _jspx_page_context.setAttribute("links", links, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/manage.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/linksManage.js\"></script>\r\n");
      out.write("<title>网工后台管理－自定义链接管理</title>\r\n");
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
		ArrayList<Link> linksList = links.getAllLinks();

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
      out.write("        <div style=\"float:left;\">&nbsp;&nbsp;所有链接：（注意：在前台首页只会显示下面链接的前5条，5条之后的链接不会显示，请自行删除）</div>\r\n");
      out.write("        ");
if(User.checkHaveAuthority(auth,User.addLink)){ 
      out.write("\r\n");
      out.write("        <div id=\"tempContentHeader\">\r\n");
      out.write("          <div id=\"contentButton\">\r\n");
      out.write("            <ul>\r\n");
      out.write("              <li><a href=\"javascript:showHide('addLink');\" target=\"_self\"><img src=\"/images/linksManage.png\" width=\"15\" height=\"15\" />&nbsp;&nbsp;添加链接</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
} 
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td width=\"20px\"></td>\r\n");
      out.write("          <td width=\"110px\" align=\"left\"></td>\r\n");
      out.write("          <td align=\"right\"></td>\r\n");
      out.write("          <td width=\"90px\" align=\"right\"></td>\r\n");
      out.write("          <td width=\"20px\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td></td>\r\n");
      out.write("          <td colspan=\"3\"><div class=\"addLinkFrame\" id=\"addLink\">\r\n");
      out.write("              <form id=\"form_linksEdit\" action=\"/jsp/manage/linksManage/saveLink.jsp?isModify=0\" method=\"post\">\r\n");
      out.write("                <span style=\"color:#069; font-size:14px;\">添加新的自定义链接：</span><br />\r\n");
      out.write("                新链接名称：\r\n");
      out.write("                <input type=\"text\" name=\"lText0\" id=\"lText0\" style=\" width:480px; margin-bottom:5px; margin-top:10px;\"/>\r\n");
      out.write("                <br />\r\n");
      out.write("                新链接地址：\r\n");
      out.write("                <input type=\"text\" name=\"lLink0\" id=\"lLink0\" style=\" width:480px; margin-bottom:10px;\"/>\r\n");
      out.write("                <br />\r\n");
      out.write("                <input name=\"saveLink\" type=\"submit\" value=\"保存\" onclick=\"return check('lText0','lLink0')\" style=\"margin-left:230px;\" />\r\n");
      out.write("                <input type=\"reset\" name=\"reset\" value=\"重置\" />\r\n");
      out.write("              </form>\r\n");
      out.write("            </div></td>\r\n");
      out.write("          <td></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");

                int i=0;//用来记录当前显示的是第几条链接
	        while(linksList.size()!=0){
				Link l = linksList.remove(0);
				String text = l.getText();
				String aText = text;
				String link = l.getLink();
				String creator = l.getCreator();
				int id = l.getId();
				String linkEditID="linkEditFrame"+id;
				String textID = "text"+id;
				String linkID = "link"+id;
				if(text.length()>31){
					aText=text.substring(0,30)+"...";
				}
				i++;
			
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td height=\"30px\"></td>\r\n");
      out.write("          <td height=\"30px\" align=\"left\" colspan=\"2\" style=\"border-bottom: dashed 1px #AAA;\"><img src=\"/images/news.png\" width=\"14\" height=\"14\" /><span style=\"color:#1B25F3; font-family:Arial, '宋体'; font-size:12px;\">");
      out.print(i);
      out.write("，</span><a href=\"");
      out.print(link);
      out.write("\" target=\"_blank\" class=\"customLink\" title=");
      out.print(text);
      out.write('>');
      out.print(aText);
      out.write("&nbsp;&nbsp;&nbsp;</a>");
if(User.checkHaveAuthority(auth,User.editLink)||curUser.equals(creator)){ 
      out.write(" &nbsp;&nbsp;&nbsp;<img src=\"/images/Edit.png\" width=\"12\" height=\"12\" /><a href=\"javascript:showHide(");
      out.print(("\'"+linkEditID+"\'"));
      out.write(");\" class=\"normalLink\" >修改</a>");
};if(User.checkHaveAuthority(auth,User.delLink)||curUser.equals(creator)){ 
      out.write("&nbsp;&nbsp;&nbsp;<img src=\"/images/Delete.png\" width=\"12\" height=\"12\" /><a href=\"/jsp/manage/linksManage/delLink.jsp?id=");
      out.print(id);
      out.write("\" target=\"_self\" class=\"normalLink\" onclick=\"return onDelete()\" >删除</a>");
} 
      out.write("</td>\r\n");
      out.write("          <td align=\"right\" style=\"border-bottom:dashed 1px #AAA;\"><span id=\"date\">[");
      out.print(l.getCreateTime().substring(0, 10));
      out.write("]</span></td>\r\n");
      out.write("          <td></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td ></td>\r\n");
      out.write("          <td align=\"right\" valign=\"top\" style=\"font-family:Arial, '宋体'; font-size:12px; color: #999; line-height:20px;\">当前链接地址：&nbsp;&nbsp;</td>\r\n");
      out.write("          <td valign=\"top\" id=\"summary\" >");
      out.print(link);
      out.write("</td>\r\n");
      out.write("          <td></td>\r\n");
      out.write("          <td></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td></td>\r\n");
      out.write("          <td colspan=\"3\"><div class=\"linksEditFrame\" id=\"");
      out.print(linkEditID);
      out.write("\">\r\n");
      out.write("              <form id=\"form_linksEdit\" action=\"/jsp/manage/linksManage/saveLink.jsp?isModify=1&id=");
      out.print(id );
      out.write("\" method=\"post\">\r\n");
      out.write("                修改链接名称：&nbsp;&nbsp;\r\n");
      out.write("                <input type=\"text\" name=\"");
      out.print(textID);
      out.write("\" id=\"");
      out.print(textID);
      out.write("\" style=\" width:480px; margin-bottom:5px;\" value=\"");
      out.print(text);
      out.write("\"/>\r\n");
      out.write("                <br />\r\n");
      out.write("                修改链接地址：&nbsp;&nbsp;\r\n");
      out.write("                <input type=\"text\" name=\"");
      out.print(linkID);
      out.write("\" id=\"");
      out.print(linkID);
      out.write("\" style=\" width:480px; margin-right:10px;\" value=\"");
      out.print(link);
      out.write("\"/>\r\n");
      out.write("                <input name=\"saveLink\" type=\"submit\" value=\"保存\" onclick=\"return check(");
      out.print("\'"+textID+"\'");
      out.write(',');
      out.print(("\'"+linkID+"\'"));
      out.write(")\" />\r\n");
      out.write("                <input type=\"reset\" name=\"reset\" value=\"重置\" />\r\n");
      out.write("              </form>\r\n");
      out.write("            </div></td>\r\n");
      out.write("          <td></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");
} //while
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td height=\"10px\" colspan=\"5\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div id=\"bottom\">\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/bottom.jsp", out, true);
      out.write("\r\n");
      out.write("  </div>\r\n");
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
