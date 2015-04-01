<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*,database.*" errorPage="/jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%	
	request.setCharacterEncoding("utf-8");
	String affiche = request.getParameter("affiche");
	String createTime = new Timestamp(new java.util.Date().getTime()).toString();
	String creator = (String)session.getAttribute("userName");
	try {
		Connection con = new DBConnection().getConnection();
		Statement stat = con.createStatement();
		stat.execute("update manageAffiche set creator=\'" + creator
				+ "\',createTime=\'" + createTime
				+ "\',affiche=\'" + affiche
				+ "\'");
		if (stat != null) {
			stat.close();
			stat = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}
		response.sendRedirect("/jsp/manage/");
	} catch (SQLException e) {
		%>
		<script language="javascript">
			<!--
			alert("操作失败：数据库操作失败！"+<%=("\""+e.getMessage()+"\"")%>);
			//-->
		</script>
		<%
	}
%>