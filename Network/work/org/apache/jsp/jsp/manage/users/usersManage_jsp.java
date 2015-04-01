package org.apache.jsp.jsp.manage.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import user.*;
import java.util.ArrayList;

public final class usersManage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      user.UserBean userBean = null;
      synchronized (_jspx_page_context) {
        userBean = (user.UserBean) _jspx_page_context.getAttribute("userBean", PageContext.PAGE_SCOPE);
        if (userBean == null){
          userBean = new user.UserBean();
          _jspx_page_context.setAttribute("userBean", userBean, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/usersManage.js\"></script>\r\n");
      out.write("<title>网工后台管理－用户管理</title>\r\n");
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
	}else if(!((String)session.getAttribute("userRole")).equals("0")){
		out.println("<center>你没有打开该页面的权限...</center>");
	} else {
		String auth = (String) session.getAttribute("userAuthority");
		String myEmail = (String) session.getAttribute("userEmail");

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
      out.write("        <div style=\"float:left;\">&nbsp;&nbsp;所有用户：</div>\r\n");
      out.write("        ");
if(User.checkHaveAuthority(auth,User.regNewUser)){ 
      out.write("\r\n");
      out.write("        <div id=\"tempContentHeader\">\r\n");
      out.write("          <div id=\"contentButton\">\r\n");
      out.write("            <ul>\r\n");
      out.write("              <li><a href=\"/jsp/manage/users/addUser.jsp\" target=\"_self\"><img\r\n");
      out.write("\t\tsrc=\"/images/addUser.png\" width=\"16\" height=\"16\" />&nbsp;&nbsp;添加用户</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
} 
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      ");

		ArrayList<User> usersList = userBean.getAllUsers();
		int count = 0;
		while (usersList.size() != 0) {
			User u = usersList.remove(0);

      out.write("\r\n");
      out.write("      <div class=\"userItemTitle\"><font color=\"#505050\">");
      out.print((++count));
      out.write("，</font><font style=\"color:");
out.print(myEmail.equals(u.getEmail())?"#0000FF":"#505050"); 
      out.write("; font-weight:bold\">");
      out.print(u.getName());
      out.write("</font>&nbsp;&nbsp;<font style=\"color:#069; font-size:14px;\">&lt;</font><a href=\"mailto:");
      out.print( u.getEmail());
      out.write("\" class=\"emailText\">");
      out.print(u.getEmail());
      out.write("</a><font style=\"color:#069; font-size:14px;\">&gt;</font>\r\n");
      out.write("      ");
if((u.getRole() == 1&&User.checkHaveAuthority(auth,User.allowNewReg))||(u.getRole() != 1&&User.checkHaveAuthority(auth,User.editUserPower))){if(!myEmail.equals(u.getEmail())){
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"/images/authority.png\" width=\"12\" height=\"12\" /><a href=\"/jsp/manage/users/editAuthority.jsp?email=");
      out.print(u.getEmail());
      out.write("&type=");
      out.print(u.getRole());
      out.write("\" class=\"normalLink\">\r\n");
      out.write("        ");
out.print((u.getRole() == 1) ? "审核" : "修改权限");
      out.write("\r\n");
      out.write("        </a>");
}}if(User.checkHaveAuthority(auth,User.delUser)){ 
      out.write("&nbsp;&nbsp;<img src=\"/images/Delete.png\" width=\"12\" height=\"12\" /><a href=\"/jsp/manage/users/delUser.jsp?email=");
      out.print(u.getEmail());
      out.write("\"\r\n");
      out.write("\ttarget=\"_self\" class=\"normalLink\" onclick=\"return onDelete()\">删除用户</a>");
} 
      out.write("</div>\r\n");
      out.write("      <div class=\"userItemInfo\">用户身份：\r\n");
      out.write("        ");

			switch (u.getRole()) {
			case 0:
				out.print("<font color='#505050'>超级管理员</font>");
				out.print("，共登录：" + u.getLogCount() + "次，上次登录时间："+ u.getLastLogTime().substring(0, 16));
				break;
			case 1:
				out.print("<font color='#FF0000'>已注册的用户（待审核）</font>");
				out.print("注册时间："+ u.getLastLogTime().substring(0, 16));//对新注册的用户来说，regTime和lastLogTime一样
				break;
			case 2:
				out.print("<font color='#BBBBBB'>管理员</font>");
				out.print("，共登录：" + u.getLogCount() + "次，上次登录时间："+ u.getLastLogTime().substring(0, 16));
				break;
			default:
				out.print("<font color='#FF0000'>错误的身份</font>");
			}

   
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      ");
}
      out.write("\r\n");
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
