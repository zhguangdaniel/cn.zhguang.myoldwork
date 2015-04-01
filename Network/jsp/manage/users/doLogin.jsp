<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*,database.*,user.*" errorPage="/jsp/error/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>执行用户登录</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	//从界面获得参数
	String email = request.getParameter("email");
	String password = request.getParameter("password");

	//从User数据库表中查得需要的信息（系统会自动连接默认数据库）
	try {
		Connection con = new DBConnection().getConnection();
		Statement stat = con.createStatement();
		ResultSet rSet = stat.executeQuery("select * from users where email='"+email+"'");
		if (rSet.next()) {
			User u = new User();
			u.setEmail(rSet.getString("email"));
			u.setName(rSet.getString("name"));
			u.setPassword(rSet.getString("password"));
			u.setRole(rSet.getInt("role"));
			u.setAuthority(rSet.getString("authority"));
			if (u.getPassword().equals(password)) {
				String currentTime = new Timestamp(new java.util.Date().getTime()).toString();
				stat.execute("update users set lastLogTime='"+currentTime+"', logCount=logCount+1 where email = '"+email+"'");		
				//下面关闭数据库连接
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
				//保存信息到session对象
				session.setAttribute("isLog", new String("1"));
				session.setAttribute("userName",u.getName());
				session.setAttribute("userEmail",u.getEmail());
				session.setAttribute("userRole",""+u.getRole());
				session.setAttribute("userAuthority",u.getAuthority());
				session.setAttribute("loginMsg", new String(""));
				response.sendRedirect("/jsp/manage/");
			} else {
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
				session.setAttribute("loginMsg", new String("密码错误！"));
				session.setAttribute("isLog", new String("0"));
				response.sendRedirect("/jsp/manage/");
			}
		}else{
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
			session.setAttribute("loginMsg", new String("该邮箱尚未注册！"));
			session.setAttribute("isLog", new String("0"));
			response.sendRedirect("/jsp/manage/");
		}
	} catch (SQLException e) {
		if (e.getErrorCode() == 0) {
			session.setAttribute("loginMsg", new String("登录失败：连接数据库失败！"));
			session.setAttribute("isLog", new String("0"));
			response.sendRedirect("/jsp/manage/");
		}
	}
%>
</body>
</html>
