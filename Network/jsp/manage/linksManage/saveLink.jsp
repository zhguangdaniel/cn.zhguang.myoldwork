<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*,database.*" errorPage="/jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:useBean id="links" class="customLinks.LinksBean" scope="page"/>
<%
	boolean isLog = false;
	try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
	if (!isLog) {
		session.setAttribute("isLog", new String("0"));
		session.setAttribute("loginMsg", new String("您还未登录，请先登录！"));
		response.sendRedirect("/jsp/manage/");
	} else {
		out.println("<center>正在保存链接...</center>");
		request.setCharacterEncoding("utf-8");
		int isModify = Integer.parseInt(request.getParameter("isModify"));//判断是不是修改链接
		if(isModify==0){//不是修改
			String lText = request.getParameter("lText0");
			String lLink = request.getParameter("lLink0");
	
			try {
				Connection con = new DBConnection().getConnection();
				String reg = "insert into customLinks values(?,?,?,?)";
				String createTime = new Timestamp(new java.util.Date().getTime()).toString();
				PreparedStatement pstmt = con.prepareStatement(reg);

				pstmt.setString(1, createTime);//createTime
				pstmt.setString(2, lText);//linkText
				pstmt.setString(3, lLink);//link
				pstmt.setString(4, (String)session.getAttribute("userName"));//creator;
				pstmt.executeUpdate();

				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
				response.sendRedirect("/jsp/manage/linksManage/links.jsp");
			} catch (SQLException e) {
					%>
					<script language="javascript">
						<!--
						alert("操作失败：数据库操作失败！"+<%=("\""+e.getMessage()+"\"")%>);
						//-->
					</script>
					<%
			}
		}else{
			int id = Integer.parseInt(request.getParameter("id"));
			String lText = request.getParameter("text"+id);
			String lLink = request.getParameter("link"+id);
			
			try {
				Connection con = new DBConnection().getConnection();
				Statement stat = con.createStatement();
				
				stat.execute("update customLinks set text=\'" + lText
						+ "\',link=\'" + lLink
						+ "\' where id="+id);
				
				if (stat != null) {
					stat.close();
					stat = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
				response.sendRedirect("/jsp/manage/linksManage/links.jsp");
			} catch (SQLException e) {
				%>
				<script language="javascript">
					<!--
					alert("操作失败：数据库操作失败！"+<%=("\""+e.getMessage()+"\"")%>);
					//-->
				</script>
				<%
			}
		}
	}
%>
