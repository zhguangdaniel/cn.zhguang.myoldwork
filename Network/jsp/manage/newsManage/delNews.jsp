<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*,java.io.File,database.*,news.*,user.*" errorPage="/jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:useBean id="newsBean" class="news.NewsBean" scope="page" />
<%
	boolean isLog = false;
	int id = Integer.parseInt(request.getParameter("id"));
	String creater = newsBean.getNewsCreater(id);
	try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
	if (!isLog) {
		session.setAttribute("isLog", new String("0"));
		session.setAttribute("loginMsg", new String("您还未登录，请先登录！"));
		response.sendRedirect("/jsp/manage/");
	}else if(!User.checkHaveAuthority(((String)session.getAttribute("userAuthority")),User.delNews)&&!((String)session.getAttribute("userName")).equals(creater)){
		out.println("<center>你没有打开该页面的权限...</center>");
	} else {
		out.println("<center>正在删除...</center>");
		String parentURL = request.getParameter("parent");
		try {
		//下面要删除新闻中所含有的所有文件
		SingleNews news = newsBean.getNews(id);
		String content = news.getContent();
		int index = 0;
		int pathend = 0;
		int len = content.length();
		while(index < len){//删除图片
			index = content.indexOf("/files/upload_for_article/",index);
			if(index <0)break;//搜索完成，结束
			pathend = content.indexOf("\"",index);
			if(pathend<0)break;
			String path = content.substring(index,pathend );
			index = pathend;
			File f = new File(request.getRealPath("")+path);
			f.delete();
		}
	
		//下面从数据库中删除文章
			Connection con = new DBConnection().getConnection();
			Statement stat = con.createStatement();
			stat.execute("delete from news where id=" + id);
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
