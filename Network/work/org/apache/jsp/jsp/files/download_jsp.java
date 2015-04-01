package org.apache.jsp.jsp.files;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import files.*;
import java.io.FileNotFoundException;

public final class download_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      files.FilesBean filesBean = null;
      synchronized (_jspx_page_context) {
        filesBean = (files.FilesBean) _jspx_page_context.getAttribute("filesBean", PageContext.PAGE_SCOPE);
        if (filesBean == null){
          filesBean = new files.FilesBean();
          _jspx_page_context.setAttribute("filesBean", filesBean, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("</head>\r\n");

	request.setCharacterEncoding("utf-8");
   // int downloadType = Integer.parseInt(request.getParameter("downType"));
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	//if(downloadType == 0){//上传的文件下载
		SingleFile f = filesBean.getFile(Integer.parseInt(request.getParameter("id")));
		String storeName = f.getStoreName();  
		String name = f.getName();
		String type = f.getType();
		try {
			su.initialize(pageContext);
			su.setContentDisposition(null);
			out.clear();
			out = pageContext.pushBody();
			su.downloadFile("/files/"+storeName,type,name+"."+type);
		} catch (Exception e) {
			out.println("<p><center>指定的文件 "+ basePath +"files/"+ storeName+"（"+name+"） 不存在，可能已被删除</center></p>");
		}
	//}
	//else{//文章中的文件下载
	//	String name= request.getParameter("name");
	//	String storeName= request.getParameter("storeName");
	//	String type= request.getParameter("type");
	//	try {
	//		su.initialize(pageContext);
	//		su.setContentDisposition(null);
	//		su.downloadFile("/files/upload_for_article/files/"+storeName,type,name+"."+type);
	//	} catch (Exception e) {
	//		out.println("<p><center>指定的文件 "+ basePath +"files/"+ storeName+"（"+EncodeTrans.trans(name)+"） 不存在，可能已被删除</center></p>");
	//	}
	//}

      out.write("\r\n");
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
