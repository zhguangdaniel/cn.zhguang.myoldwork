package org.apache.jsp.jsp.manage.newsManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import database.*;
import files.*;
import com.jspsmart.upload.*;

public final class saveNewsFile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
		//String title = EncodeTrans.trans(su.getRequest().getParameter("newsTitle"));
		//String htmlText = EncodeTrans.trans(su.getRequest().getParameter("newsContent"));
		String title = su.getRequest().getParameter("newsTitle");
		String htmlText = su.getRequest().getParameter("newsContent");
		String addText = "";//要添加的内容
		session.setAttribute("title", title);
		session.setAttribute("newsContent", htmlText);
		File file = su.getFiles().getFile(0);
		
		if(file.getSize()>2097152)
			throw new Exception("文件大小不能超过2MB");
		
		String ext = file.getFileExt().toLowerCase();
		String storeName = NameGenerater.generate(file.getFileName(),ext);

		
		//String currentURL = "http://"+request.getServerName()+":"+request.getServerPort();
		if (ext.equals("jpg") || ext.equals("gif")
		|| ext.equals("bmp")
		|| ext.equals("png")
		|| ext.equals("jpeg")
		|| ext.equals("tif")) {
			file.saveAs("/files/upload_for_article/images/"+ storeName, File.SAVEAS_VIRTUAL);
			addText = "<img src='/files/upload_for_article/images/"+storeName+"' border='0' alt='' /><br />";
		} else {
			file.saveAs("/files/upload_for_article/files/"+ file.getFileName(), File.SAVEAS_VIRTUAL);
			addText = "<a href='/files/upload_for_article/files/"+file.getFileName()+"' target='_blank'>"+file.getFileName()+"</a><br />";
		}
		htmlText += addText;
		session.setAttribute("errMsg", new String("上传成功！"));

		session.setAttribute("newsContent", htmlText);
		
	} catch (Exception e) {
		session.setAttribute("errMsg","上传失败，" + e.getMessage());
	}
	
	int isModify = Integer.parseInt(request.getParameter("isModify"));//判断是不是修改文章
	if(isModify==0){
		response.sendRedirect("/jsp/manage/newsManage/publishNews.jsp");
	}else{
		session.setAttribute("isUpload", new String("1"));//当前是否是上传文件
		String parentURL = request.getParameter("parent");
		int id = Integer.parseInt(request.getParameter("id"));
		response.sendRedirect("/jsp/manage/newsManage/editNews.jsp?id="+id+"&parent="+parentURL);
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
