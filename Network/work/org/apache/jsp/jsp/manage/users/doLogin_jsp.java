package org.apache.jsp.jsp.manage.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import database.*;
import user.*;

public final class doLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>执行用户登录</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	request.setCharacterEncoding("utf-8");
	//从界面获得参数
	String email = request.getParameter("email");
	String password = request.getParameter("password");

	//从User数据库表中查得需要的信息（系统会自动连接默认数据库）
	try {
		Connection con = new DBConnection().getConnection();
		Statement stat = con.createStatement();
		ResultSet rSet = stat.executeQuery("select * from users where email='"+email+"'");
		if (rSet.next()) {
			User u = new User();
			u.setEmail(rSet.getString("email"));
			u.setName(rSet.getString("name"));
			u.setPassword(rSet.getString("password"));
			u.setRole(rSet.getInt("role"));
			u.setAuthority(rSet.getString("authority"));
			if (u.getPassword().equals(password)) {
				String currentTime = new Timestamp(new java.util.Date().getTime()).toString();
				stat.execute("update users set lastLogTime='"+currentTime+"', logCount=logCount+1 where email = '"+email+"'");		
				//下面关闭数据库连接
				if (rSet != null) {
					rSet.close();
					rSet = null;
				}
				if (stat != null) {
					stat.close();
					stat = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
				//保存信息到session对象
				session.setAttribute("isLog", new String("1"));
				session.setAttribute("userName",u.getName());
				session.setAttribute("userEmail",u.getEmail());
				session.setAttribute("userRole",""+u.getRole());
				session.setAttribute("userAuthority",u.getAuthority());
				session.setAttribute("loginMsg", new String(""));
				response.sendRedirect("/jsp/manage/");
			} else {
				if (rSet != null) {
					rSet.close();
					rSet = null;
				}
				if (stat != null) {
					stat.close();
					stat = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
				session.setAttribute("loginMsg", new String("密码错误！"));
				session.setAttribute("isLog", new String("0"));
				response.sendRedirect("/jsp/manage/");
			}
		}else{
			if (rSet != null) {
				rSet.close();
				rSet = null;
			}
			if (stat != null) {
				stat.close();
				stat = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
			session.setAttribute("loginMsg", new String("该邮箱尚未注册！"));
			session.setAttribute("isLog", new String("0"));
			response.sendRedirect("/jsp/manage/");
		}
	} catch (SQLException e) {
		if (e.getErrorCode() == 0) {
			session.setAttribute("loginMsg", new String("登录失败：连接数据库失败！"));
			session.setAttribute("isLog", new String("0"));
			response.sendRedirect("/jsp/manage/");
		}
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
