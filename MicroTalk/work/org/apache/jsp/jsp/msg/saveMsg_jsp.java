package org.apache.jsp.jsp.msg;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import msg.*;
import java.sql.*;
import database.*;

public final class saveMsg_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
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

		out.println("<center>正在保存消息...</center>");
		request.setCharacterEncoding("utf-8");

		int isComment = Integer.parseInt(request.getParameter("isComment"));//判断是不是回复,1为回复，0不是回复
		if(isComment==0){
			int userId = (Integer)session.getAttribute("userId");			
			String msgContent = request.getParameter("msgContent");
				try{
					Msg msg = new Msg();
					msg.setCreateUserId(userId);
					msg.setMsgContent(msgContent);
					msg.setComment(false);
					msgCtrl.addMsg(msg);
					session.setAttribute("errMsg", new String("发布消息成功！"));
					response.sendRedirect("/myIndex");
				}catch(Exception e){
					session.setAttribute("errMsg", new String("提交失败：存在以下错误！"+e.getMessage()));
					response.sendRedirect("/myIndex");
				}
			
		}else{
			//int id = Integer.parseInt(request.getParameter("id"));
			//String curPage = request.getParameter("curPage");
			//String creator =(String) session.getAttribute("userName");
		//	String replyContent = request.getParameter("msg"+id);
		//	try{
		//		Msg msg = new Msg();
		//		msg.setCreator(creator);
		//		msg.setMessage(replyContent);
		//		msg.setType(isReply);
		//		msg.setReplyID(id);
		//		msgCtrl.addMsg(msg);
		//		response.sendRedirect("/jsp/manage/msgManage/msg.jsp?page="+curPage);
		//	}catch(SQLException e){
		//		if (e.getErrorCode() == 0) {
		//		} else {
		//		}
		//	}
		}

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
