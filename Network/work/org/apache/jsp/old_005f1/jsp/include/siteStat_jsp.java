package org.apache.jsp.old_005f1.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import database.*;
import java.util.Date;

public final class siteStat_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			"jsp/error/error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"/old_1/css/style.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");

	boolean isUpdateStat = false;
	int totalCount = 0;
	int todayCount = 0;
	try {
		isUpdateStat = ((String) session.getAttribute("isUpdateStat"))
		.equals("1");//用户是否已经更新网站统计信息
	} catch (Exception e) {
	}
	if (isUpdateStat == false) {
		//未更新
		Connection con = new DBConnection().getConnection();
		Statement stat = con.createStatement();
		ResultSet rSet = stat.executeQuery("select * from siteStat");
		if (rSet.next()) {
			totalCount = rSet.getInt("totalCount")+1;
			
			String today = new Timestamp(new java.util.Date().getTime()).toString();

			if(today.substring(0,10).equals(rSet.getString("date").substring(0,10))){
				todayCount = rSet.getInt("todayCount")+1;			
				stat.execute("update siteStat set totalCount =" + totalCount
					+ ",todayCount =" + todayCount+"");
			}else{
				todayCount = 1;
				stat.execute("update siteStat set totalCount =" + totalCount
						+ ",todayCount =1,date=\'" + today+ "\'");
			}
			
		}
		session.setAttribute("totalCount",String.valueOf(totalCount));
		session.setAttribute("todayCount",String.valueOf(todayCount));
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
		session.setAttribute("isUpdateStat",new String("1"));

	} else {
		totalCount = Integer.parseInt(session.getAttribute("totalCount").toString());
		todayCount = Integer.parseInt(session.getAttribute("todayCount").toString());
	}

      out.write("\r\n");
      out.write("<table width=\"200\" height=\"60\" align=\"center\" cellpadding=\"0\"\r\n");
      out.write("\tcellspacing=\"0\" border=\"0\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td id=\"blackText\" height=\"30px\" align=\"center\">您是本站第&nbsp;");
      out.print(totalCount);
      out.write("&nbsp;位访问者</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td id=\"blackText\" height=\"30px\" align=\"center\">今日有&nbsp;");
      out.print(todayCount);
      out.write("&nbsp;人访问了本站</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
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
