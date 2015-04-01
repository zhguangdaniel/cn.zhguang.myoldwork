package org.apache.jsp.jsp.manage.infoManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import info.*;
import user.*;

public final class editInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"/css/manage.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"/css/manageContent.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<!--[if lte IE 6]>\r\n");
      out.write("<link href=\"/css/contentButtonIE6.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<![endif]-->\r\n");
      info.InfoBean infoBean = null;
      synchronized (_jspx_page_context) {
        infoBean = (info.InfoBean) _jspx_page_context.getAttribute("infoBean", PageContext.PAGE_SCOPE);
        if (infoBean == null){
          infoBean = new info.InfoBean();
          _jspx_page_context.setAttribute("infoBean", infoBean, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/checkInfo.js\"></script>\r\n");
      out.write("<!-- TinyMCE -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/tiny_mce/tiny_mce.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t// skin (silver)\r\n");
      out.write("\ttinyMCE.init({\r\n");
      out.write("\t\t// General options\r\n");
      out.write("\t\tmode : \"exact\",\r\n");
      out.write("\t\telements : \"infoContent\",\r\n");
      out.write("\t\ttheme : \"advanced\",\r\n");
      out.write("\t\tskin : \"o2k7\",\r\n");
      out.write("\t\tlanguage :\"zh\",\r\n");
      out.write("\t\t//skin_variant : \"silver\",\r\n");
      out.write("\t\tplugins : \"safari,emotions,insertdatetime,noneditable,inlinepopups\",\r\n");
      out.write("\r\n");
      out.write("\t\t// Theme options\r\n");
      out.write("\t\ttheme_advanced_buttons1 : \"bold,italic,underline,|,justifyleft,justifycenter,justifyright,formatselect,fontselect,fontsizeselect,|,forecolor,backcolor,|,bullist,numlist,|,undo,redo,|,link,unlink,anchor,|,charmap,emotions,image,|,code\",\r\n");
      out.write("\t\ttheme_advanced_buttons2 : \"\",\r\n");
      out.write("\t\ttheme_advanced_buttons3 :\"\", \r\n");
      out.write("\t\ttheme_advanced_toolbar_location : \"top\",\r\n");
      out.write("\t\ttheme_advanced_toolbar_align : \"left\",\r\n");
      out.write("\t\ttheme_advanced_layout_manager : \"SimpleLayout\",\r\n");
      out.write("\t\ttheme_advanced_statusbar_location : \"none\",\r\n");
      out.write("\t\ttheme_advanced_resizing : true,\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t// Example content CSS (should be your site CSS)\r\n");
      out.write("\t\tcontent_css : \"css/content.css\",\r\n");
      out.write("\r\n");
      out.write("\t\t// Drop lists for link/image dialogs\r\n");
      out.write("\t\texternal_link_list_url : \"lists/link_list.js\",\r\n");
      out.write("\t\texternal_image_list_url : \"lists/image_list.js\"\r\n");
      out.write("\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("<!-- /TinyMCE -->\r\n");
      out.write("<title>网工后台管理－修改通知</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	boolean isLog = false;
	int id = Integer.parseInt(request.getParameter("id"));
	String creater = infoBean.getInfoCreater(id);
		try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
	if (!isLog) {
		session.setAttribute("isLog",new String("0"));
		session.setAttribute("loginMsg", new String("您还未登录，请先登录！"));
		response.sendRedirect("/jsp/manage/");
	}else if(!User.checkHaveAuthority(((String)session.getAttribute("userAuthority")),User.editInfo)&&!((String)session.getAttribute("userName")).equals(creater)){
		out.println("<center>你没有打开该页面的权限...</center>");
	} else{
		String errMsg = null;
		try {
			errMsg = (String) session.getAttribute("errMsg");
		} catch (Exception e) {
		}
		if (errMsg == null) {
			errMsg = "";
		}

		boolean isUpload = false;
		try {
			isUpload = ((String) session.getAttribute("isUpload")).equals("1");//获得用户是否已经登录的消息
		} catch (Exception e) {
		}
		String title ="";
		String infoContent ="";
		String publisher = "";
		Info info = infoBean.getInfo(id);
		String parentURL = request.getParameter("parent");
		if (isUpload) {//是上传文件
			try {
				title = (String) session.getAttribute("title");
			} catch (Exception e) {
			}
			if (title == null) {
				title = "";
			}
			try {
				infoContent = (String) session.getAttribute("infoContent");
			} catch (Exception e) {
			}
			if (infoContent == null) {
				infoContent = "";
			}
			try {
				publisher = (String) session.getAttribute("publisher");
			} catch (Exception e) {
			}
			if (publisher == null) {
				publisher = "";
			}
		}else{
			title = info.getTitle();
			infoContent = info.getContent();
			publisher = info.getCreater();
		}

      out.write("\r\n");
      out.write("<!--全部区域-->\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("    <!--头部-->\r\n");
      out.write("    <div id=\"header\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/header.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--主区，包括菜单区（垂直导航条）和工作区-->\r\n");
      out.write("    <div id=\"mainContent\">\r\n");
      out.write("        <div id=\"leftMenu\">\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/leftMenu.jsp", out, true);
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"rightMain\" style=\"overflow:auto;\">\r\n");
      out.write("            <div id=\"contentHeader\">&nbsp;&nbsp;<a href=\"/jsp/manage/\" class=\"normalLink\">后台管理</a> &nbsp;&gt;&nbsp;<a href=\"/jsp/manage/infoManage/info.jsp?page=1\" class=\"normalLink\">通知管理</a> &nbsp;&gt;&nbsp;修改通知&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"/images/Return.png\" width=\"12\" height=\"12\" /><a\r\n");
      out.write("                href=\"");
      out.print(parentURL);
      out.write("\" target=\"_self\" class=\"normalLink\" style=\"color:#069\" >返回</a></div>\r\n");
      out.write("            <form name=\"form_article\" method=\"post\" style=\"margin:0 auto;margin-left:10px; margin-right:10px; text-align:left;\">\r\n");
      out.write("                <div id=\"titleFrame\">标题：\r\n");
      out.write("                    <input id=\"infoTitle\" name=\"infoTitle\" type=\"text\" style=\"width:480px; height:16px;\" value=\"");
      out.print(title);
      out.write("\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modifyArticleFrame\">发布者：");
      out.print(info.getCreater());
      out.write("&nbsp;&nbsp;&nbsp;发布于：");
      out.print(info.getCreateTime().substring(0, 16));
      out.write("</div>\r\n");
      out.write("                <textarea id=\"infoContent\" name=\"infoContent\" style=\"width: 100%; height:310px;\">");
      out.print(infoContent);
      out.write("</textarea>\r\n");
      out.write("                <div id=\"articleBottom\"> 插入 本地图片/文件链接：\r\n");
      out.write("                    <input type=\"file\" name=\"articleFile\" id=\"articleFile\" size=\"20\" />\r\n");
      out.write("                    &nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                    <input type=\"button\" name=\"saveFile\" value=\"上传\" onclick=\"return checkFileUpload('/jsp/manage/infoManage/saveInfoFile.jsp?isModify=1&id=");
      out.print(id );
      out.write("&parent=");
      out.print(parentURL);
      out.write("')\" />\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"articleBottom\">\r\n");
      out.write("                    <input type=\"button\" name=\"modify\" value=\"确认修改\" onclick=\"return checkArticle('/jsp/manage/infoManage/saveInfo.jsp?isModify=1&id=");
      out.print(id );
      out.write("&parent=");
      out.print(parentURL);
      out.write("')\" />\r\n");
      out.write("                    <input type=\"reset\" name=\"reset\" value=\"重置\" />\r\n");
      out.write("                    <span class=\"errMsgFrame\" style=\"margin-left:20px;\" id=\"errMsg\"></span> </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"bottom\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/bottom.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("\tdocument.getElementById(\"errMsg\").innerHTML=\"<font color='#FF0000' size='-1' face='Arial, 宋体'>\"+");
      out.print(("\""+errMsg+"\""));
      out.write("+\"</font>\";\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
	
	errMsg = "";
	session.setAttribute("errMsg",new String(""));
	session.setAttribute("title", new String(""));
	session.setAttribute("newsContent",new String(""));
	session.setAttribute("publisher", new String(""));
	session.setAttribute("isUpload", new String("0"));
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