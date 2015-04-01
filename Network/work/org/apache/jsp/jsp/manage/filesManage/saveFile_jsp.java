package org.apache.jsp.jsp.manage.filesManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import database.*;
import files.*;
import com.jspsmart.upload.*;

public final class saveFile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      com.jspsmart.upload.SmartUpload su = null;
      synchronized (_jspx_page_context) {
        su = (com.jspsmart.upload.SmartUpload) _jspx_page_context.getAttribute("su", PageContext.PAGE_SCOPE);
        if (su == null){
          su = new com.jspsmart.upload.SmartUpload();
          _jspx_page_context.setAttribute("su", su, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>上传文件</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<center>正在上传...</center>\r\n");

	try {
		request.setCharacterEncoding("utf-8");
		su.initialize(pageContext);
		su.service(request, response);
		su.upload();
		File file = su.getFiles().getFile(0);
		String storeName = NameGenerater.generate(file.getFileName(), file
		.getFileExt());
		
		String description = su.getRequest().getParameter("fileDescription");
		String name = su.getRequest().getParameter("fileName");
		file.saveAs("/files/" + storeName, File.SAVEAS_VIRTUAL);

		// 下面写入数据库
		Connection con = new DBConnection().getConnection();
		String reg = "insert into files values(?,?,?,?,?,?,?)";
		String uploadTime = new Timestamp(new java.util.Date().getTime()).toString();
		PreparedStatement pstmt = con.prepareStatement(reg);
		pstmt.setString(1, name);
		pstmt.setString(2, file.getFileExt());//type
		pstmt.setInt(3, file.getSize());//size
		pstmt.setString(4, uploadTime);//uploadTime
		pstmt.setString(5, storeName);//storeName
		pstmt.setString(6, description);//description
		pstmt.setString(7, (String)session.getAttribute("userName"));//creator
		pstmt.executeUpdate();

		if (pstmt != null) {
			pstmt.close();
			pstmt = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}
		session.setAttribute("errMsg", new String(""));
		response.sendRedirect("/jsp/manage/filesManage/files.jsp?page=1");
	}catch (SQLException e) {
		session.setAttribute("errMsg", new String("上传失败，数据库错误：<br/>" + e.getMessage()));
		response.sendRedirect("/jsp/manage/filesManage/upload.jsp");
	} catch (Exception e) {
		session.setAttribute("errMsg", new String("上传失败，存在如下错误：<br/>" + e.getMessage()));
		response.sendRedirect("/jsp/manage/filesManage/upload.jsp");
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
