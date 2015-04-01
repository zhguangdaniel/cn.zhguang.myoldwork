package org.apache.jsp.jsp.manage.affiche;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import database.*;

public final class addAffiche_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
	
	request.setCharacterEncoding("utf-8");
	String affiche = request.getParameter("affiche");
	String createTime = new Timestamp(new java.util.Date().getTime()).toString();
	String creator = (String)session.getAttribute("userName");
	try {
		Connection con = new DBConnection().getConnection();
		Statement stat = con.createStatement();
		stat.execute("update manageAffiche set creator=\'" + creator
				+ "\',createTime=\'" + createTime
				+ "\',affiche=\'" + affiche
				+ "\'");
		if (stat != null) {
			stat.close();
			stat = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}
		response.sendRedirect("/jsp/manage/");
	} catch (SQLException e) {
		
      out.write("\r\n");
      out.write("\t\t<script language=\"javascript\">\r\n");
      out.write("\t\t\t<!--\r\n");
      out.write("\t\t\talert(\"操作失败：数据库操作失败！\"+");
      out.print(("\""+e.getMessage()+"\""));
      out.write(");\r\n");
      out.write("\t\t\t//-->\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t");

	}

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
