package org.apache.jsp.jsp.myIndex;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import msg.*;
import user.*;
import java.sql.*;
import java.util.ArrayList;

public final class publishMsg_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\" src=\"/js/msg.js\"></script>\r\n");
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
      out.write('\r');
      out.write('\n');
      out.write(' ');

	String errMsg = null;
	try {
		errMsg = (String) session.getAttribute("errMsg");
	} catch (Exception e) {
	}


      out.write("\r\n");
      out.write("<div style=\"height:65px; width:100%; background-image:url(/images/postbg.png)\"></div>\r\n");
      out.write("<div style=\"text-align:right; width:90%; margin:auto;\">\r\n");
      out.write("<form name=\"form_msg\" method=\"post\" target=\"_self\" action=\"/jsp/msg/saveMsg.jsp?isComment=0\">\r\n");
      out.write("  <textarea id=\"msgContent\" name=\"msgContent\" style=\" width:100%; height:120px; margin-bottom:10px; font-family: Arial, '宋体'; font-size:13px;\"></textarea>\r\n");
      out.write("  <br />\r\n");
      out.write("  <div class=\"loginErrMsgFrame\" id = \"msgErrInfo\"></div>\r\n");
      out.write("   <input type=\"submit\" onclick=\"return checkMsg()\" class=\"postBtn\" value=\"\"/>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("document.getElementById(\"msgErrInfo\").innerHTML=");
      out.print(("'"+errMsg+"'"));
      out.write(";\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");

errMsg = "";
session.setAttribute("errMsg",new String(""));

      out.write("\r\n");
      out.write("<div class=\"bar\" style=\" font-size:16px;border-bottom:solid 1px #999999\">我的消息</div>\r\n");
      out.write("<div class=\"msgFrameContent\"  style=\"display:block;\">\r\n");
      out.write("  <ul>\r\n");
      out.write("    ");

		ArrayList<Msg> newMsgList = msgCtrl.getTopNewMsgsOfUser(10,(Integer)session.getAttribute("userId"));
        while(newMsgList.size()!=0){
        	Msg aMsg = newMsgList.remove(0);
        	int id = (Integer)session.getAttribute("userId");
			String time =  aMsg.getCreateTime().substring(0,16);
			String content = aMsg.getMsgContent();
			String userIconPath = (String)session.getAttribute("userIconPath");
			String userName = (String)session.getAttribute("userName");
			
        
      out.write("\r\n");
      out.write("    <li>\r\n");
      out.write("      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td width=\"70px\" rowspan=\"2\" align=\"right\"><img class=\"borderImg\" src=\"");
      out.print(userIconPath);
      out.write("\" width=\"50px\" height=\"50px\" /></td>\r\n");
      out.write("          <td valign=\"top\" style=\"padding-left:10px;\" ><span><a class=\"userNameInMsgFrame\">");
      out.print(userName);
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
      out.write("</div>");
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
