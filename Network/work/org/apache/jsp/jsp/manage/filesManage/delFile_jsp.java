package org.apache.jsp.jsp.manage.filesManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.File;
import database.*;
import files.*;
import user.*;

public final class delFile_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	boolean isLog = false;
	int id = Integer.parseInt(request.getParameter("id"));
	SingleFile file = filesBean.getFile(id);
	try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
	if (!isLog) {
		session.setAttribute("isLog", new String("0"));
		session.setAttribute("loginMsg", new String("您还未登录，请先登录！"));
		response.sendRedirect("/jsp/manage/");
	}else if(!User.checkHaveAuthority(((String)session.getAttribute("userAuthority")),User.delFile)&&!((String)session.getAttribute("userName")).equals(file.getCreator())){
		out.println("<center>你没有打开该页面的权限...</center>");
	} else {
		out.println("<center>正在删除...</center>");

		String parentURL = request.getParameter("parent");

		try {
			String storeName =file.getStoreName();
			Connection con = new DBConnection().getConnection();
			Statement stat = con.createStatement();
			stat.execute("delete from files where id=" + id);
			if (stat != null) {
				stat.close();
				stat = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
			
			File f = new File(request.getRealPath("")+"\\files\\" + storeName);
			if(f.exists())//如果已经不存在了，什么都不做
			 f.delete();
			response.sendRedirect(parentURL);
		} catch (SQLException e) {
			if (e.getErrorCode() == 0) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<script language=\"javascript\">\r\n");
      out.write("\t\t\t\t\t<!--\r\n");
      out.write("\t\t\t\t\talert(\"删除失败：连接数据库失败！\"+");
      out.print(("\""+e.getMessage()+"\""));
      out.write(");\r\n");
      out.write("\t\t\t\t\t//-->\r\n");
      out.write("\t\t\t\t</script>\r\n");
      out.write("\t\t\t");

			} else {
				
      out.write("\r\n");
      out.write("\t\t\t\t<script language=\"javascript\">\r\n");
      out.write("\t\t\t\t\t<!--\r\n");
      out.write("\t\t\t\t\talert(\"删除失败：\"+");
      out.print(("\""+e.getMessage()+"\""));
      out.write(");\r\n");
      out.write("\t\t\t\t\t//-->\r\n");
      out.write("\t\t\t\t</script>\r\n");
      out.write("\t\t\t");

			}
		}catch(Exception e){
			
      out.write("\r\n");
      out.write("\t\t\t<script language=\"javascript\">\r\n");
      out.write("\t\t\t\t<!--\r\n");
      out.write("\t\t\t\talert(\"删除失败：\"+");
      out.print(("\""+e.getMessage()+"\""));
      out.write(");\r\n");
      out.write("\t\t\t\t//-->\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t");

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
