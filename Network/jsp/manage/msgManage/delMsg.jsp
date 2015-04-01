<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*,user.*" errorPage="/jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:useBean id="msgBean" class="message.MsgBean" scope="page"/>
<%
	boolean isLog = false;
	request.setCharacterEncoding("utf-8");
	int id = Integer.parseInt(request.getParameter("id"));
	try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
	if (!isLog) {
		session.setAttribute("isLog", new String("0"));
		session.setAttribute("loginMsg", new String("您还未登录，请先登录！"));
		response.sendRedirect("/jsp/manage/");
	}else if(!User.checkHaveAuthority(((String)session.getAttribute("userAuthority")),User.delMsg)&&!((String)session.getAttribute("userName")).equals(msgBean.getMsgCreater(id))){
		out.println("<center>你没有打开该页面的权限...</center>");
	} else {
		out.println("<center>正在删除链接...</center>");


		int curPage = Integer.parseInt(request.getParameter("curPage"));
		int type = Integer.parseInt(request.getParameter("type"));
		try {
			msgBean.delMsg(id,type);
			response.sendRedirect("/jsp/manage/msgManage/msg.jsp?page="+curPage);
		} catch (SQLException e) {
			if (e.getErrorCode() == 0) {
				%>
				<script language="javascript">
					<!--
					alert("删除失败：连接数据库失败！"+<%=("\""+e.getMessage()+"\"")%>);
					//-->
				</script>
				<%
			} else {
				%>
				<script language="javascript">
					<!--
					alert("删除失败："+<%=("\""+e.getMessage()+"\"")%>);
					//-->
				</script>
				<%
			}
		}
	}
%>
