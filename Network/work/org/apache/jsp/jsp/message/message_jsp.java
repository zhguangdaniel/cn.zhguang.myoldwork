package org.apache.jsp.jsp.message;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import message.*;
import java.sql.*;
import java.util.ArrayList;

public final class message_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>网工－留言版</title>\r\n");
      out.write("<link href=\"/css/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"/css/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/msgManage.js\"></script>\r\n");
      message.MsgBean msgBean = null;
      synchronized (_jspx_page_context) {
        msgBean = (message.MsgBean) _jspx_page_context.getAttribute("msgBean", PageContext.PAGE_SCOPE);
        if (msgBean == null){
          msgBean = new message.MsgBean();
          _jspx_page_context.setAttribute("msgBean", msgBean, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      page.PageBean pageCtrl = null;
      synchronized (_jspx_page_context) {
        pageCtrl = (page.PageBean) _jspx_page_context.getAttribute("pageCtrl", PageContext.PAGE_SCOPE);
        if (pageCtrl == null){
          pageCtrl = new page.PageBean();
          _jspx_page_context.setAttribute("pageCtrl", pageCtrl, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

String errMsg = null;
String oldCreator = null;
String oldMsgContent = null;
try {
	errMsg = (String) session.getAttribute("errMsg");
} catch (Exception e) {
}
if (errMsg == null) {
	errMsg = "";
}
try {
	oldCreator = (String) session.getAttribute("creator");
} catch (Exception e) {
}
if (oldCreator== null) {
	oldCreator = "";
}
try {
	oldMsgContent = (String) session.getAttribute("msgContent");
} catch (Exception e) {
}
if (oldMsgContent == null) {
	oldMsgContent = "";
}

      out.write("\r\n");
      out.write("<!--头部header-->\r\n");
      out.write("<div class=\"header\">\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/header.jsp", out, true);
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!--//header-->\r\n");
      out.write("<!--主体容器container-->\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("  <!--内容区content，包括菜单和主内容-->\r\n");
      out.write("  <div class=\"content\">\r\n");
      out.write("    <!--左边内容框leftContentFrame-->\r\n");
      out.write("    <div class=\"leftContentFrame\">\r\n");
      out.write("      <!--左边菜单框leftMenuFrame-->\r\n");
      out.write("      <div class=\"leftMenuFrame\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/leftMenu.jsp", out, true);
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      <!--//leftMenuFrame-->\r\n");
      out.write("      <div class=\"imgLinksFrame\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/imgLinks.jsp", out, true);
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"customLinksFrame\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/customLinks.jsp", out, true);
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--右边内容框rightContentFrame-->\r\n");
      out.write("    <div class=\"rightContentFrame\">\r\n");
      out.write("      <div class=\"breadcrumbs\"><a href=\"/\">首页</a> &nbsp;&gt;&nbsp;留言板&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"/images/message.png\" /><a href=\"#publishMsg\">发表留言</a></div>\r\n");
      out.write("      ");

      int curPage = Integer.parseInt(request.getParameter("page"));
      pageCtrl=msgBean.getPage(curPage,10);
      int floor = (curPage-1)*10;//记录是多少楼
      int totalMsg = msgBean.getTotalMsgsCount();
	  while(pageCtrl.resultList.size()!=0){
        	Message msg = (Message)pageCtrl.resultList.remove(0);
			String msgContent = msg.getMessage();
			String time= msg.getCreateTime().substring(0,16);
      
      out.write("\r\n");
      out.write("      <div class=\"msgFrame\">\r\n");
      out.write("        <div class=\"msgInfo\"> <font color=\"#505050\">");
      out.print((totalMsg - floor++));
      out.write("楼</font>&nbsp;&nbsp;<font color=\"#505050\">");
      out.print(msg.getCreator() );
      out.write("</font>&nbsp;&nbsp;<font color=\"#999999\">");
      out.print(time);
      out.write("</font></div>\r\n");
      out.write("        <div class=\"msgText\">");
      out.print(msgContent );
      out.write("</div>\r\n");
      out.write("        ");

      int id = msg.getId();
      ArrayList<Message> replyList = msgBean.getReplyMsgs(id);
      while(replyList.size()!=0){
      	Message r = replyList.remove(0);
    	  
      out.write("\r\n");
      out.write("        <div class=\"replyInfo\"><font color=\"#006699\" style=\"font-weight:bold;\">管理员 ");
      out.print(r.getCreator() );
      out.write(" 回复:</font>&nbsp;&nbsp;<font color=\"#999999\">");
      out.print(r.getCreateTime().substring(0,16));
      out.write("</font></div>\r\n");
      out.write("        <div class=\"replyText\">");
      out.print( r.getMessage());
      out.write("</div>\r\n");
      out.write("        ");
} 
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      ");
}
      out.write("\r\n");
      out.write("      <div class=\"pageCtrlFrame\">\r\n");
      out.write("        ");
out.print(pageCtrl.printCtrl());
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      <a name=\"publishMsg\" id=\"publishMsg\"></a>\r\n");
      out.write("      <div class=\"bar\">发表留言</div>\r\n");
      out.write("      <form name=\"form_message\" method=\"post\" target=\"_self\" action=\"/jsp/message/saveMsg.jsp?isReply=0\">\r\n");
      out.write("        <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\" class=\"editMsgFrame\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"13%\" align=\"right\">姓名：</td>\r\n");
      out.write("            <td colspan=\"2\"><input name=\"creator\" id=\"creator\" type=\"text\" style=\"width:120px; height:20px;\"/>\r\n");
      out.write("              留空则匿名发表</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td valign=\"top\"align=\"right\">内容：</td>\r\n");
      out.write("            <td colspan=\"2\"><textarea id=\"msgContent\" name=\"msgContent\" style=\"width: 90%; height:150px; font-family: Arial, '宋体'; font-size:13px;\"></textarea></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("           <tr>\r\n");
      out.write("            <td align=\"right\">验证码：</td>\r\n");
      out.write("            <td width=\"15%\"><input   type=\"text\" size=\"10\" id=\"vcode\" name=\"vcode\"/></td>\r\n");
      out.write("            <td valign=\"top\"><img id=\"vcodeImg\" src=\"/jsp/vcode/image.jsp\" onclick=\"javascript:reloadVCode();\" style=\"border:none; width:60px; height:20px; margin-top:3px;\"/> &nbsp;&nbsp;&nbsp;<a href=\"javascript:reloadVCode();\" style=\"font-family: Arial, '宋体';font-size:12px;color:#006699;\">看不清楚？换张图片！</a></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td></td>\r\n");
      out.write("            <td width=\"15%\"><input type=\"submit\" name=\"publish\" value=\"提交\" onclick=\"return checkPublishMsg()\" />\r\n");
      out.write("              <input type=\"reset\" name=\"reset\" value=\"重置\" onclick=\"clearMsgInfo()\" /></td>\r\n");
      out.write("            <td><span id = \"errMsg\" name = \"errMsg\" class=\"errMsgFrame\"></span></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--//rightContentFrame-->\r\n");
      out.write("  </div>\r\n");
      out.write("  <!--content-->\r\n");
      out.write("</div>\r\n");
      out.write("<!--container-->\r\n");
      out.write("<!--底部bottom-->\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/footer.jsp", out, true);
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!--//bottom-->\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("\tdocument.getElementById(\"errMsg\").innerHTML=\"<font color='#FF0000' size='-1' face='Arial, 宋体'>\"+");
      out.print(("\""+errMsg+"\""));
      out.write("+\"</font>\";\r\n");
      out.write("\tdocument.getElementById(\"creator\").value=");
      out.print(("\""+oldCreator +"\""));
      out.write(";\r\n");
      out.write("\tdocument.getElementById(\"msgContent\").value=");
      out.print(("\""+oldMsgContent+"\""));
      out.write(";\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
	
	errMsg = "";
	session.setAttribute("errMsg",new String(""));

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
