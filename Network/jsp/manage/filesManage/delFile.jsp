<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*,java.io.File,database.*,files.*,user.*"
	errorPage="/jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:useBean id="filesBean" class="files.FilesBean" scope="page" />
<%
	boolean isLog = false;
	int id = Integer.parseInt(request.getParameter("id"));
	SingleFile file = filesBean.getFile(id);
	try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
	if (!isLog) {
		session.setAttribute("isLog", new String("0"));
		session.setAttribute("loginMsg", new String("您还未登录，请先登录！"));
		response.sendRedirect("/jsp/manage/");
	}else if(!User.checkHaveAuthority(((String)session.getAttribute("userAuthority")),User.delFile)&&!((String)session.getAttribute("userName")).equals(file.getCreator())){
		out.println("<center>你没有打开该页面的权限...</center>");
	} else {
		out.println("<center>正在删除...</center>");

		String parentURL = request.getParameter("parent");

		try {
			String storeName =file.getStoreName();
			Connection con = new DBConnection().getConnection();
			Statement stat = con.createStatement();
			stat.execute("delete from files where id=" + id);
			if (stat != null) {
				stat.close();
				stat = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
			
			File f = new File(request.getRealPath("")+"\\files\\" + storeName);
			if(f.exists())//如果已经不存在了，什么都不做
			 f.delete();
			response.sendRedirect(parentURL);
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
		}catch(Exception e){
			%>
			<script language="javascript">
				<!--
				alert("删除失败："+<%=("\""+e.getMessage()+"\"")%>);
				//-->
			</script>
			<%
		}
	}
%>
