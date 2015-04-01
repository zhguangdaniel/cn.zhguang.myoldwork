package org.apache.jsp.jsp.message;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import message.*;
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

		out.println("<center>正在保存留言...</center>");
		request.setCharacterEncoding("utf-8");

		int isReply = Integer.parseInt(request.getParameter("isReply"));//判断是不是回复留言,1为回复，0不是回复
		if(isReply==0){
			String creator = request.getParameter("creator");
			if(creator ==""||creator == null)
				creator ="匿名";
			String msgContent = request.getParameter("msgContent");
			session.setAttribute("creator", creator);
			session.setAttribute("msgContent", msgContent);
			String vcode = (String) session.getAttribute("vcode");
			String input = request.getParameter("vcode");
			if (!input.equals(vcode)) {
				session.setAttribute("errMsg", new String("验证码错误！"));
				response.sendRedirect("/jsp/message/message.jsp?page=1#publishMsg");
			} else {
				try{
					Message msg = new Message();
					msg.setCreator(creator);
					msg.setMessage(msgContent);
					msg.setType(isReply);
					msgBean.addMsg(msg);
					session.setAttribute("creator", "");
					session.setAttribute("msgContent", "");
					response.sendRedirect("/jsp/message/message.jsp?page=1");
				}catch(Exception e){
					session.setAttribute("errMsg", new String("提交失败：存在以下错误！"+e.getMessage()));
					response.sendRedirect("/jsp/message/message.jsp?page=1#publishMsg");
				}
			}
		}else{
			int id = Integer.parseInt(request.getParameter("id"));
			String curPage = request.getParameter("curPage");
			String creator = (String) session.getAttribute("userName");
			String replyContent = request.getParameter("msg"+id);
			try{
				Message msg = new Message();
				msg.setCreator(creator);
				msg.setMessage(replyContent);
				msg.setType(isReply);
				msg.setReplyID(id);
				msgBean.addMsg(msg);
				response.sendRedirect("/jsp/manage/msgManage/msg.jsp?page="+curPage);
			}catch(SQLException e){
				if (e.getErrorCode() == 0) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<script language=\"javascript\">\r\n");
      out.write("\t\t\t\t\t\t<!--\r\n");
      out.write("\t\t\t\t\t\talert(\"操作失败：连接数据库失败！\"+");
      out.print(("\""+e.getMessage()+"\""));
      out.write(");\r\n");
      out.write("\t\t\t\t\t\t//-->\r\n");
      out.write("\t\t\t\t\t</script>\r\n");
      out.write("\t\t\t\t\t");

				} else {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<script language=\"javascript\">\r\n");
      out.write("\t\t\t\t\t\t<!--\r\n");
      out.write("\t\t\t\t\t\talert(\"操作失败：\"+");
      out.print(("\""+e.getMessage()+"\""));
      out.write(");\r\n");
      out.write("\t\t\t\t\t\t//-->\r\n");
      out.write("\t\t\t\t\t</script>\r\n");
      out.write("\t\t\t\t\t");

				}
			}
		}

      out.write('\r');
      out.write('\n');
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
