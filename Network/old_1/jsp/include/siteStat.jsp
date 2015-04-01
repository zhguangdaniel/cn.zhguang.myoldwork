<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*,database.*" errorPage="jsp/error/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.Date"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/old_1/css/style.css" type="text/css" rel="stylesheet" />
<%
	boolean isUpdateStat = false;
	int totalCount = 0;
	int todayCount = 0;
	try {
		isUpdateStat = ((String) session.getAttribute("isUpdateStat"))
		.equals("1");//用户是否已经更新网站统计信息
	} catch (Exception e) {
	}
	if (isUpdateStat == false) {
		//未更新
		Connection con = new DBConnection().getConnection();
		Statement stat = con.createStatement();
		ResultSet rSet = stat.executeQuery("select * from siteStat");
		if (rSet.next()) {
			totalCount = rSet.getInt("totalCount")+1;
			
			String today = new Timestamp(new java.util.Date().getTime()).toString();

			if(today.substring(0,10).equals(rSet.getString("date").substring(0,10))){
				todayCount = rSet.getInt("todayCount")+1;			
				stat.execute("update siteStat set totalCount =" + totalCount
					+ ",todayCount =" + todayCount+"");
			}else{
				todayCount = 1;
				stat.execute("update siteStat set totalCount =" + totalCount
						+ ",todayCount =1,date=\'" + today+ "\'");
			}
			
		}
		session.setAttribute("totalCount",String.valueOf(totalCount));
		session.setAttribute("todayCount",String.valueOf(todayCount));
		if (rSet != null) {
			rSet.close();
			rSet = null;
		}
		if (stat != null) {
			stat.close();
			stat = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}
		session.setAttribute("isUpdateStat",new String("1"));

	} else {
		totalCount = Integer.parseInt(session.getAttribute("totalCount").toString());
		todayCount = Integer.parseInt(session.getAttribute("todayCount").toString());
	}
%>
<table width="200" height="60" align="center" cellpadding="0"
	cellspacing="0" border="0">
	<tr>
		<td id="blackText" height="30px" align="center">您是本站第&nbsp;<%=totalCount%>&nbsp;位访问者</td>
	</tr>
	<tr>
		<td id="blackText" height="30px" align="center">今日有&nbsp;<%=todayCount%>&nbsp;人访问了本站</td>
	</tr>
</table>
