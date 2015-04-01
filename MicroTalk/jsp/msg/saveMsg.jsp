<%@ page contentType="text/html; charset=utf-8" language="java"
	import="msg.*,java.sql.*,database.*" errorPage="jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:useBean id="msgCtrl" class="msg.MsgCtrl" scope="page" />
<%
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
%>