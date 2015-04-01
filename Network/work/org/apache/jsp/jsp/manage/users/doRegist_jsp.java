package org.apache.jsp.jsp.manage.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import database.*;
import user.*;

public final class doRegist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      user.UserBean userBean = null;
      synchronized (_jspx_page_context) {
        userBean = (user.UserBean) _jspx_page_context.getAttribute("userBean", PageContext.PAGE_SCOPE);
        if (userBean == null){
          userBean = new user.UserBean();
          _jspx_page_context.setAttribute("userBean", userBean, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>执行用户注册</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");

	request.setCharacterEncoding("utf-8");
	User userInfo = new User();
	userInfo.setEmail(request.getParameter("email"));
	userInfo.setName(request.getParameter("name"));
	userInfo.setPassword(request.getParameter("password"));
	userInfo.setPasswordQuestion(request
			.getParameter("passwordQuestion"));
	userInfo.setPasswordAnswer(request.getParameter("passwordAnswer"));
	userInfo.setRegUserInfo(request.getParameter("regUserInfo"));
	try {
		session.setAttribute("email", userInfo.getEmail());
		session.setAttribute("name", userInfo.getName());
		session.setAttribute("passwordQuestion", userInfo
		.getPasswordQuestion());
		session.setAttribute("passwordAnswer", userInfo
		.getPasswordAnswer());
		session.setAttribute("regUserInfo", userInfo.getRegUserInfo());
		String vcode = (String) session.getAttribute("vcode");
		String input = request.getParameter("vcode");
		if (!input.equals(vcode)) {
			session.setAttribute("errMsg", new String("验证码错误！"));
			response.sendRedirect("/jsp/manage/users/register.jsp");
		} else {
			userInfo.setRole(1);
			userInfo.setAuthority("000000000000000000000000000000");
			userBean.regist(userInfo);

			session.setAttribute("loginMsg",
			new String("注册成功，等待管理员审核！"));
			response.sendRedirect("/jsp/manage/");
		}
	} catch (SQLException e) {
		if (e.getErrorCode() == 0) {
			session.setAttribute("errMsg", new String(
			"注册失败：连接数据库失败！可能数据库已关闭"));
		}else  if(e.getErrorCode() == 2627){
			session.setAttribute("errMsg", new String("您注册的Email已存在！请使用其它Email注册"));
		}else if(e.getErrorCode() == 2601){
			session.setAttribute("errMsg", new String("您注册的用户名已存在！请使用其它用户名注册"));
		}else {
			session.setAttribute("errMsg", new String("注册失败："+e.getErrorCode()+ e.getMessage()));
		}
		response.sendRedirect("/jsp/manage/users/register.jsp");
	} catch (Exception e) {
		session.setAttribute("errMsg", new String("注册失败："+ e.getMessage()));
		response.sendRedirect("/jsp/manage/users/register.jsp");
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
