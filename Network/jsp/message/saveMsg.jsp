<%@ page contentType="text/html; charset=utf-8" language="java"
	import="message.*,java.sql.*,database.*" errorPage="jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:useBean id="msgBean" class="message.MsgBean" scope="page" />
<%
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
					%>
					<script language="javascript">
						<!--
						alert("操作失败：连接数据库失败！"+<%=("\""+e.getMessage()+"\"")%>);
						//-->
					</script>
					<%
				} else {
					%>
					<script language="javascript">
						<!--
						alert("操作失败："+<%=("\""+e.getMessage()+"\"")%>);
						//-->
					</script>
					<%
				}
			}
		}
%>
