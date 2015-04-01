<%@ page contentType="text/html; charset=utf-8" language="java"
	import="user.*,java.sql.*,java.util.ArrayList" errorPage=""%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/main.css" type="text/css" rel="stylesheet" />
<jsp:useBean id="userCtrl" class="user.UserCtrl" scope="page" />
<div class="bar">人气用户</div>
<div class="userInfoContent">
<ul>
	<%
		ArrayList<User> hotUserList = userCtrl.getMostAttentionUsers(12);
		User u = null;
		while (hotUserList.size() != 0) {
		%>
	<li>
		<%
			for (int i = 0; i < 3; i++) {
		%>
		<div>
		<%
			if (hotUserList.size() != 0){
						u = hotUserList.remove(0);
			}else break;
		%> <img class="borderImg" src="<%=u.getUserIconPath()%>" width="50px"
			height="50px" /> <br />
		<a class="userListName"><%=u.getUserName()%></a></div>
		<%
			}//for
		%>
	</li>
	<%
		}//while
	%>
    </ul>
</div>
