package org.apache.jsp.jsp.manage.newsManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import database.*;

public final class saveNews_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      news.NewsBean newsBean = null;
      synchronized (_jspx_page_context) {
        newsBean = (news.NewsBean) _jspx_page_context.getAttribute("newsBean", PageContext.PAGE_SCOPE);
        if (newsBean == null){
          newsBean = new news.NewsBean();
          _jspx_page_context.setAttribute("newsBean", newsBean, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');

		out.println("<center>正在保存新闻...</center>");
		request.setCharacterEncoding("utf-8");

		int isModify = Integer.parseInt(request.getParameter("isModify"));//判断是不是修改文章
		if(isModify==0){
			String newsTitle = request.getParameter("newsTitle");
			String newsContent = request.getParameter("newsContent");
			try {
				Connection con = new DBConnection().getConnection();
				String reg = "insert into news values(?,?,?,?,?,?)";
				String createTime = new Timestamp(new java.util.Date().getTime()).toString();
				PreparedStatement pstmt = con.prepareStatement(reg);
				pstmt.setString(1, newsTitle);//title
				pstmt.setString(2, (String)session.getAttribute("userName"));//creater
				pstmt.setString(3, createTime);//createTime
				pstmt.setString(4, null);//modifyTime
				pstmt.setString(5, null);//modifyUser
				pstmt.setString(6, newsContent);//content
				pstmt.executeUpdate();

				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
				response.sendRedirect("/jsp/manage/newsManage/news.jsp?page=1");
			} catch (SQLException e) {
				if (e.getErrorCode() == 0) {
					session.setAttribute("errMsg", new String("发布失败：数据库操作失败！"+e.getMessage()));
					response.sendRedirect("/jsp/manage/newsManage/publishNews.jsp");
				} else {
					session.setAttribute("errMsg", new String("发布失败：存在以下错误！"+e.getMessage()));
					response.sendRedirect("/jsp/manage/newsManage/publishNews.jsp");
				}
			}
		}else{
			String newsTitle = request.getParameter("newsTitle");
			String newsContent = request.getParameter("newsContent");
			String modifier = (String)session.getAttribute("userName");
			int id = Integer.parseInt(request.getParameter("id"));
			String parentURL = request.getParameter("parent");
			try {
				Connection con = new DBConnection().getConnection();
				Statement stat = con.createStatement();
				String modifyTime = new Timestamp(new java.util.Date().getTime()).toString();
				
				stat.execute("update news set title =\'"+ newsTitle 
						+ "\',modifyTime=\'" + modifyTime
						+ "\',modifyUser=\'" + modifier
						+ "\',newsContent=\'" + newsContent
						+ "\' where id="+id);
				
				if (stat != null) {
					stat.close();
					stat = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
				response.sendRedirect(parentURL);
			} catch (SQLException e) {
				if (e.getErrorCode() == 0) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<script language=\"javascript\">\r\n");
      out.write("\t\t\t\t\t<!--\r\n");
      out.write("\t\t\t\t\talert(\"操作失败：数据库操作失败！\"+");
      out.print(("\""+e.getMessage()+"\""));
      out.write(");\r\n");
      out.write("\t\t\t\t\t//-->\r\n");
      out.write("\t\t\t\t</script>\r\n");
      out.write("\t\t\t\t");

				} else {
					session.setAttribute("errMsg", e.getMessage());
					response.sendRedirect("/jsp/manage/newsManage/editNews.jsp?id="+id+"&parent="+parentURL);
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
