package org.apache.jsp.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import database.*;
import java.util.Calendar;
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
      			"/jsp/error/error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"/css/main.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");

	boolean isUpdateStat = false;
	int totalCount = 0;
	int todayCount = 0;
	int weekCount = 0;
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
			Date d = new Date();
			String today = new Timestamp(d.getTime()).toString();
			
			if(today.substring(0,10).equals(rSet.getString("date").substring(0,10))){
				todayCount = rSet.getInt("todayCount")+1;			
			}else{
				todayCount = 1;
			}
			
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			if(c.get(Calendar.DAY_OF_WEEK)==1){//每周日更新数据
				weekCount = todayCount;
			}else{
				weekCount += rSet.getInt("weekCount")+1;	
			}
			
			stat.execute("update siteStat set totalCount =" + totalCount
					+ ",todayCount =" + todayCount+",weekCount =" + weekCount+",date=\'" + today+ "\'");
			
		}
		session.setAttribute("totalCount",String.valueOf(totalCount));
		session.setAttribute("todayCount",String.valueOf(todayCount));
		session.setAttribute("weekCount",String.valueOf(weekCount));
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
		weekCount = Integer.parseInt(session.getAttribute("weekCount").toString());
	}

      out.write("\r\n");
      out.write("<span>访问统计： 日 ");
      out.print(todayCount);
      out.write(" / 周 ");
      out.print(weekCount );
      out.write(" / 共 ");
      out.print(totalCount);
      out.write("</span>\r\n");
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
