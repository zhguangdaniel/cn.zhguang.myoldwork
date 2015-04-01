package org.apache.jsp.jsp.manage.infoManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import files.*;
import com.jspsmart.upload.*;

public final class saveInfoFile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
		su.initialize(pageContext);
		su.service(request, response);
		
		//su.setAllowedFilesList("jpg,gif,bmp,png,jpeg,tif,rar,zip,txt,doc,xls,ppt,docx,xlsx,pptx,pdf,,");//允许上传的文件类型，,,表示不含后缀名的文件
		//su.setMaxFileSize(2097152);//每个文件的最大size,2097152=2*1024*1024，以B（比特）为单位，这里最大限制为2M
		//su.setTotalMaxFileSize(2097152);
		su.upload();
		String title = su.getRequest().getParameter("infoTitle");
		String htmlText = su.getRequest().getParameter("infoContent");
		String addText = "";//要添加的内容
		session.setAttribute("title", title);
		session.setAttribute("infoContent", htmlText);
		
		File file = su.getFiles().getFile(0);
		if(file.getSize()>2097152)
			throw new Exception("文件大小不能超过2MB");
		
		String ext = file.getFileExt().toLowerCase();
		String storeName = NameGenerater.generate(file.getFileName(),ext);
		request.setCharacterEncoding("utf-8");
		
		//String currentURL = "http://"+request.getServerName()+":"+request.getServerPort();
		if (ext.equals("jpg") || ext.equals("gif")
		|| ext.equals("bmp")
		|| ext.equals("png")
		|| ext.equals("jpeg")
		|| ext.equals("tif")) {
			file.saveAs("/files/upload_for_article/images/"+ storeName, File.SAVEAS_VIRTUAL);
			addText = "<img src='/files/upload_for_article/images/"+storeName+"' border='0' alt='' /><br />";
			//<p><img src="" alt="" width="10" height="20" /></p>
		} else {
			file.saveAs("/files/upload_for_article/files/"+ file.getFileName(), File.SAVEAS_VIRTUAL);
			addText = "<a href='/files/upload_for_article/files/"+file.getFileName()+"' target='_blank'>"+file.getFileName()+"</a><br />";
		}
		htmlText += addText;
		//out.println(title);out.println(htmlText);out.println(publisher);
		session.setAttribute("errMsg", new String("上传成功！"));
		session.setAttribute("infoContent", htmlText);
	} catch (Exception e) {
		session.setAttribute("errMsg","上传失败，" + e.getMessage());
	}
	int isModify = Integer.parseInt(request.getParameter("isModify"));//判断是不是修改文章
	if(isModify==0){
		response.sendRedirect("/jsp/manage/infoManage/publishInfo.jsp");
	}else{
		session.setAttribute("isUpload", new String("1"));//当前是否是上传文件
		String parentURL = request.getParameter("parent");
		int id = Integer.parseInt(request.getParameter("id"));
		response.sendRedirect("/jsp/manage/infoManage/editInfo.jsp?id="+id+"&parent="+parentURL);
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
