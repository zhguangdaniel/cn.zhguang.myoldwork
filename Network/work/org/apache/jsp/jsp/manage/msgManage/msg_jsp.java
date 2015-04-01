package org.apache.jsp.jsp.manage.msgManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import message.*;
import java.sql.*;
import java.util.ArrayList;
import user.*;

public final class msg_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link href=\"/css/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<!--[if lte IE 6]>\r\n");
      out.write("<link href=\"/css/contentButtonIE6.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<![endif]-->\r\n");
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
      out.write("<script type=\"text/javascript\" src=\"/js/manage.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/msgManage.js\"></script>\r\n");
      out.write("<title>网工后台管理－留言管理</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	boolean isLog = false;
		try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
	if (!isLog) {
		session.setAttribute("isLog",new String("0"));
		session.setAttribute("loginMsg", new String("您还未登录，请先登录！"));
		response.sendRedirect("/jsp/manage/");
	}else{
		String auth = (String) session.getAttribute("userAuthority");
		String curUser = (String) session.getAttribute("userName");

      out.write("\r\n");
      out.write("<!--全部区域-->\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("  <!--头部-->\r\n");
      out.write("  <div id=\"header\">\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/header.jsp", out, true);
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("  <!--主区，包括菜单区（垂直导航条）和工作区-->\r\n");
      out.write("  <div id=\"mainContent\">\r\n");
      out.write("    <div id=\"leftMenu\">\r\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/leftMenu.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"rightMain\">\r\n");
      out.write("      <div id=\"contentHeader\">\r\n");
      out.write("        <div style=\"float:left;\">&nbsp;&nbsp;所有留言：</div>\r\n");
      out.write("      </div>\r\n");
      out.write("      ");

      int curPage = Integer.parseInt(request.getParameter("page"));
      pageCtrl=msgBean.getPage(curPage,10);
      int floor = (curPage-1)*10;//记录是多少楼
      int totalMsg = msgBean.getTotalMsgsCount();
	  while(pageCtrl.resultList.size()!=0){
        	Message msg = (Message)pageCtrl.resultList.remove(0);
			String msgContent = msg.getMessage();
			String time= msg.getCreateTime().substring(0,16);
			int id = msg.getId();
			String replyFrameID="replyFrame"+id;
			String msgID = "msg"+id;
			ArrayList<Message> replyList = msgBean.getReplyMsgs(id);
      
      out.write("\r\n");
      out.write("      <div class=\"msgFrame\">\r\n");
      out.write("        <div class=\"msgInfo\"> <font color=\"#505050\">");
      out.print((totalMsg - floor++));
      out.write("楼</font>");
if(replyList.size()==0){ 
      out.write("&nbsp;&nbsp;<font color=\"#FF0000\">(未回复)</font>");
} 
      out.write("&nbsp;&nbsp;<font color=\"#505050\">");
      out.print(msg.getCreator() );
      out.write("</font>&nbsp;&nbsp;<font color=\"#999999\">");
      out.print(time);
      out.write("</font>");
if(User.checkHaveAuthority(auth,User.replyMsg)){ 
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"/images/reply.png\" width=\"12\" height=\"12\" /><a href=\"javascript:showHide(");
      out.print(("\'"+replyFrameID+"\'"));
      out.write(");\" class=\"normalLink\" >回复</a>");
};if(User.checkHaveAuthority(auth,User.delMsg)){ 
      out.write("&nbsp;&nbsp;<img src=\"/images/Delete.png\" width=\"12\" height=\"12\" /><a href=\"/jsp/manage/msgManage/delMsg.jsp?curPage=");
      out.print(curPage);
      out.write("&id=");
      out.print(id);
      out.write("&type=");
      out.print(0);
      out.write("\" target=\"_self\" class=\"normalLink\" onclick=\"return onDelete()\">删除</a>");
} 
      out.write("</div>\r\n");
      out.write("        <div class=\"msgText\">");
      out.print(msgContent );
      out.write("</div>\r\n");
      out.write("        ");

      while(replyList.size()!=0){
      	Message r = replyList.remove(0);
    	  
      out.write("\r\n");
      out.write("        <div class=\"replyInfo\"><font color=\"#006699\" style=\"font-weight:bold;\">管理员 ");
      out.print(r.getCreator() );
      out.write(" 回复:</font>&nbsp;&nbsp;<font color=\"#999999\">");
      out.print(r.getCreateTime().substring(0,16));
      out.write("</font>");
if(User.checkHaveAuthority(auth,User.delMsgReply)||curUser.equals(r.getCreator())){ 
      out.write("&nbsp;&nbsp;<img src=\"/images/Delete.png\" width=\"12\" height=\"12\" /><a href=\"/jsp/manage/msgManage/delMsg.jsp?curPage=");
      out.print(curPage);
      out.write("&id=");
      out.print(r.getId());
      out.write("&type=");
      out.print(1);
      out.write("\" target=\"_self\" class=\"normalLink\" onclick=\"return onDelete()\">删除此回复</a>");
} 
      out.write("</div>\r\n");
      out.write("        <div class=\"replyText\">");
      out.print( r.getMessage());
      out.write("</div>\r\n");
      out.write("        ");
};if(User.checkHaveAuthority(auth,User.replyMsg)){ 
      out.write("\r\n");
      out.write("        <div class=\"replyFrame\" id=\"");
      out.print(replyFrameID);
      out.write("\">\r\n");
      out.write("          <form name=\"form_reply\" method=\"post\" action=\"/jsp/message/saveMsg.jsp?isReply=1&id=");
      out.print(id );
      out.write("&curPage=");
      out.print(curPage );
      out.write("\">\r\n");
      out.write("            <table border=\"0\" cellpadding=\"0\" cellspacing=\"5\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"80px\" height=\"10px\"></td>\r\n");
      out.write("                <td width=\"480px\"></td>\r\n");
      out.write("                <td></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td valign=\"top\"align=\"right\">回复内容：</td>\r\n");
      out.write("                <td ><textarea name=\"");
      out.print(msgID);
      out.write("\" id=\"");
      out.print(msgID);
      out.write("\" style=\"width:480px;height:120px; font-family: Arial, '宋体'; font-size:13px;\"></textarea></td>\r\n");
      out.write("                <td></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td></td>\r\n");
      out.write("                <td><input name=\"saveReply\" type=\"submit\" value=\"回复\" onclick=\"return checkReplyLength(");
      out.print("\'"+msgID+"\'");
      out.write(")\" />\r\n");
      out.write("                  <input type=\"reset\" name=\"reset\" value=\"重置\" /></td>\r\n");
      out.write("                <td></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("          </form>\r\n");
      out.write("        </div>\r\n");
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
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div id=\"bottom\">\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/bottom.jsp", out, true);
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
	
	}//else

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
