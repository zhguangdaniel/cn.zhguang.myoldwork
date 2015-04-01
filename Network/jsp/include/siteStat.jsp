<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*,database.*,java.util.Calendar,java.util.Date" errorPage="/jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/main.css" type="text/css" rel="stylesheet" />
<%
	boolean isUpdateStat = false;
	int totalCount = 0;
	int todayCount = 0;
	int weekCount = 0;
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
			Date d = new Date();
			String today = new Timestamp(d.getTime()).toString();
			
			if(today.substring(0,10).equals(rSet.getString("date").substring(0,10))){
				todayCount = rSet.getInt("todayCount")+1;			
			}else{
				todayCount = 1;
			}
			
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			if(c.get(Calendar.DAY_OF_WEEK)==1){//每周日更新数据
				weekCount = todayCount;
			}else{
				weekCount += rSet.getInt("weekCount")+1;	
			}
			
			stat.execute("update siteStat set totalCount =" + totalCount
					+ ",todayCount =" + todayCount+",weekCount =" + weekCount+",date=\'" + today+ "\'");
			
		}
		session.setAttribute("totalCount",String.valueOf(totalCount));
		session.setAttribute("todayCount",String.valueOf(todayCount));
		session.setAttribute("weekCount",String.valueOf(weekCount));
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
		weekCount = Integer.parseInt(session.getAttribute("weekCount").toString());
	}
%>
<span>访问统计： 日 <%=todayCount%> / 周 <%=weekCount %> / 共 <%=totalCount%></span>
