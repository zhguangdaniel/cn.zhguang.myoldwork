package org.apache.jsp.jsp.manage.linksManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import database.*;

public final class saveLink_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      customLinks.LinksBean links = null;
      synchronized (_jspx_page_context) {
        links = (customLinks.LinksBean) _jspx_page_context.getAttribute("links", PageContext.PAGE_SCOPE);
        if (links == null){
          links = new customLinks.LinksBean();
          _jspx_page_context.setAttribute("links", links, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');

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
		out.println("<center>正在保存链接...</center>");
		request.setCharacterEncoding("utf-8");
		int isModify = Integer.parseInt(request.getParameter("isModify"));//判断是不是修改链接
		if(isModify==0){//不是修改
			String lText = request.getParameter("lText0");
			String lLink = request.getParameter("lLink0");
	
			try {
				Connection con = new DBConnection().getConnection();
				String reg = "insert into customLinks values(?,?,?,?)";
				String createTime = new Timestamp(new java.util.Date().getTime()).toString();
				PreparedStatement pstmt = con.prepareStatement(reg);

				pstmt.setString(1, createTime);//createTime
				pstmt.setString(2, lText);//linkText
				pstmt.setString(3, lLink);//link
				pstmt.setString(4, (String)session.getAttribute("userName"));//creator;
				pstmt.executeUpdate();

				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
				response.sendRedirect("/jsp/manage/linksManage/links.jsp");
			} catch (SQLException e) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<script language=\"javascript\">\r\n");
      out.write("\t\t\t\t\t\t<!--\r\n");
      out.write("\t\t\t\t\t\talert(\"操作失败：数据库操作失败！\"+");
      out.print(("\""+e.getMessage()+"\""));
      out.write(");\r\n");
      out.write("\t\t\t\t\t\t//-->\r\n");
      out.write("\t\t\t\t\t</script>\r\n");
      out.write("\t\t\t\t\t");

			}
		}else{
			int id = Integer.parseInt(request.getParameter("id"));
			String lText = request.getParameter("text"+id);
			String lLink = request.getParameter("link"+id);
			
			try {
				Connection con = new DBConnection().getConnection();
				Statement stat = con.createStatement();
				
				stat.execute("update customLinks set text=\'" + lText
						+ "\',link=\'" + lLink
						+ "\' where id="+id);
				
				if (stat != null) {
					stat.close();
					stat = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
				response.sendRedirect("/jsp/manage/linksManage/links.jsp");
			} catch (SQLException e) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<script language=\"javascript\">\r\n");
      out.write("\t\t\t\t\t<!--\r\n");
      out.write("\t\t\t\t\talert(\"操作失败：数据库操作失败！\"+");
      out.print(("\""+e.getMessage()+"\""));
      out.write(");\r\n");
      out.write("\t\t\t\t\t//-->\r\n");
      out.write("\t\t\t\t</script>\r\n");
      out.write("\t\t\t\t");

			}
		}
	}

      out.write('\r');
      out.write('\n');
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
