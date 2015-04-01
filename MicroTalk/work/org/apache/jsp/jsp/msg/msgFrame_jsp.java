package org.apache.jsp.jsp.msg;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import msg.*;
import user.*;
import java.sql.*;
import java.util.ArrayList;

public final class msgFrame_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link href=\"/css/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/main.js\"></script>\r\n");
      msg.MsgCtrl msgCtrl = null;
      synchronized (_jspx_page_context) {
        msgCtrl = (msg.MsgCtrl) _jspx_page_context.getAttribute("msgCtrl", PageContext.PAGE_SCOPE);
        if (msgCtrl == null){
          msgCtrl = new msg.MsgCtrl();
          _jspx_page_context.setAttribute("msgCtrl", msgCtrl, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      user.UserCtrl userCtrl = null;
      synchronized (_jspx_page_context) {
        userCtrl = (user.UserCtrl) _jspx_page_context.getAttribute("userCtrl", PageContext.PAGE_SCOPE);
        if (userCtrl == null){
          userCtrl = new user.UserCtrl();
          _jspx_page_context.setAttribute("userCtrl", userCtrl, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<div class=\"msgFrameTitle\">\r\n");
      out.write("  <ul>\r\n");
      out.write("    <li><a id=\"hotMsgA\" href=\"javascript:showMsgBlock('hotMsg');\" style=\"background-image:url(/images/nav5.png)\">热门消息</a></li>\r\n");
      out.write("    <li><a id=\"newMsgA\" href=\"javascript:showMsgBlock('newMsg');\">最新消息</a></li>\r\n");
      out.write("  </ul>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"msgFrameContent\" id=\"hotMsg\"  style=\"display:block;\">\r\n");
      out.write("  <ul>\r\n");
      out.write("    ");

		ArrayList<Msg> hotMsgList = msgCtrl.getTopHotMsgs(8);
        while(hotMsgList.size()!=0){
        	Msg aMsg = hotMsgList.remove(0);
			String time =  aMsg.getCreateTime().substring(0,16);
			String content = aMsg.getMsgContent();
			int userId = aMsg.getCreateUserId();
			User u = userCtrl.getUserBrief(userId);
			
        
      out.write("\r\n");
      out.write("    <li>\r\n");
      out.write("      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td width=\"70px\" rowspan=\"2\" align=\"right\"><img class=\"borderImg\" src=\"");
      out.print(u.getUserIconPath());
      out.write("\" width=\"50px\" height=\"50px\" /></td>\r\n");
      out.write("          <td valign=\"top\" style=\"padding-left:10px;\" ><span><a class=\"userNameInMsgFrame\">");
      out.print(u.getUserName());
      out.write("：</a>");
      out.print(content );
      out.write("</span></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td valign=\"bottom\" class=\"TimeFrameInMsgFrame\" >");
      out.print(time);
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("    </li>\r\n");
      out.write("    ");
}
      out.write("\r\n");
      out.write("  </ul>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"msgFrameContent\" id=\"newMsg\"  style=\"display:none;\">\r\n");
      out.write("  <ul>\r\n");
      out.write("    ");

		ArrayList<Msg> newMsgList = msgCtrl.getTopNewMsgs(8);
        while(newMsgList.size()!=0){
        	Msg aMsg = newMsgList.remove(0);
			String time =  aMsg.getCreateTime().substring(0,16);
			String content = aMsg.getMsgContent();
			int userId = aMsg.getCreateUserId();
			User u = userCtrl.getUserBrief(userId);
			
        
      out.write("\r\n");
      out.write("    <li>\r\n");
      out.write("      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td width=\"70px\" rowspan=\"2\" align=\"right\"><img class=\"borderImg\" src=\"");
      out.print(u.getUserIconPath());
      out.write("\" width=\"50px\" height=\"50px\" /></td>\r\n");
      out.write("          <td valign=\"top\" style=\"padding-left:10px;\" ><span><a class=\"userNameInMsgFrame\">");
      out.print(u.getUserName());
      out.write("：</a>");
      out.print(content );
      out.write("</span></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td valign=\"bottom\" class=\"TimeFrameInMsgFrame\" >");
      out.print(time);
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("    </li>\r\n");
      out.write("    ");
}
      out.write("\r\n");
      out.write("  </ul>\r\n");
      out.write("</div>\r\n");
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
