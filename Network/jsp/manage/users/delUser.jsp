<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*,java.io.File,database.*,news.*,user.*" errorPage="/jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:useBean id="userBean" class="user.UserBean" scope="page" />
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
	}else if(!((String)session.getAttribute("userRole")).equals("0")||!User.checkHaveAuthority(((String)session.getAttribute("userAuthority")),User.delUser)){
		out.println("<center>你没有打开该页面的权限...</center>");
	}  else {
		out.println("<center>正在删除...</center>");
		String email = request.getParameter("email");
		try {	
		//下面从数据库中删除用户
			Connection con = new DBConnection().getConnection();
			Statement stat = con.createStatement();
			stat.execute("delete from users where email='" + email+"'");
			if (stat != null) {
				stat.close();
				stat = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
			response.sendRedirect("/jsp/manage/users/usersManage.jsp");
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
