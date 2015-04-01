<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*,database.*" errorPage="/jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:useBean id="infoBean" class="info.InfoBean" scope="page" />
<%
out.println("<center>正在保存消息...</center>");
		request.setCharacterEncoding("utf-8");
		int isModify = Integer.parseInt(request.getParameter("isModify"));//判断是不是修改文章
		if(isModify==0){
			String infoTitle = request.getParameter("infoTitle");
			String infoContent = request.getParameter("infoContent");
	
			try {
				Connection con = new DBConnection().getConnection();
				String reg = "insert into info values(?,?,?,?,?,?)";
				String createTime = new Timestamp(new java.util.Date().getTime()).toString();
				PreparedStatement pstmt = con.prepareStatement(reg);
				pstmt.setString(1, infoTitle);//title
				pstmt.setString(2, (String)session.getAttribute("userName"));//creater
				pstmt.setString(3, createTime);//createTime
				pstmt.setString(4, null);//modifyTime
				pstmt.setString(5, null);//modifyUser
				pstmt.setString(6, infoContent);//content
				pstmt.executeUpdate();

				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
				response.sendRedirect("/jsp/manage/infoManage/info.jsp?page=1");
			} catch (SQLException e) {
				if (e.getErrorCode() == 0) {
					session.setAttribute("errMsg", new String("发布失败：数据库操作失败！"+e.getMessage()));
					response.sendRedirect("/jsp/manage/infoManage/publishInfo.jsp");
				} else {
					session.setAttribute("errMsg", e.getMessage());
					response.sendRedirect("/jsp/manage/infoManage/publishInfo.jsp");
				}
			}
		}else{
			String infoTitle = request.getParameter("infoTitle");
			String infoContent = request.getParameter("infoContent");
			String modifier = (String)session.getAttribute("userName");
			int id = Integer.parseInt(request.getParameter("id"));
			String parentURL = request.getParameter("parent");
			try {
				Connection con = new DBConnection().getConnection();
				Statement stat = con.createStatement();
				String modifyTime = new Timestamp(new java.util.Date().getTime()).toString();
				
				stat.execute("update info set title =\'"+ infoTitle 
						+ "\',modifyTime=\'" + modifyTime
						+ "\',modifyUser=\'" + modifier
						+ "\',infoContent=\'" + infoContent
						+ "\' where id="+id);
				
				if (stat != null) {
					stat.close();
					stat = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
				response.sendRedirect(parentURL);
			} catch (SQLException e) {
				if (e.getErrorCode() == 0) {
				%>
				<script language="javascript">
					<!--
					alert("操作失败：数据库操作失败！"+<%=("\""+e.getMessage()+"\"")%>);
					//-->
				</script>
				<%
				} else {
					session.setAttribute("errMsg", e.getMessage());
					response.sendRedirect("/jsp/manage/infoManage/editInfo.jsp?id="+id+"&parent="+parentURL);
				}
			}
		}
%>
