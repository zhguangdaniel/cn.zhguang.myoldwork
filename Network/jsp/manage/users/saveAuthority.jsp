<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,database.*,user.*,java.lang.Integer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:useBean id="userBean" class="user.UserBean" scope="page" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>执行用户注册</title>
</head>

<body>
<%
	request.setCharacterEncoding("utf-8");
	//判断saveType是什么类型的保存，0为添加用户，1为审核用户，2为修改用户权限，3是修改用户资料，4是修改密码
	int saveType = Integer.parseInt(request.getParameter("saveType"));

	if(saveType ==0){//添加用户
		User u = new User();
		u.setEmail(request.getParameter("email"));
		u.setName(request.getParameter("name"));
		u.setPassword(request.getParameter("password"));
		String[] au = request.getParameterValues("userAuthority");
		String sA = request.getParameter("setSuperAdmin");
		if(au==null){
			u.setAuthority("000000000000000000000000000000");
		}else{
			char[] a = new char[30];
			for(int i=0;i<a.length;i++)
				a[i]='0';
			for(int i = 0; i< au.length; i++){
				a[Integer.parseInt(au[i])]='1';
			}
			u.setAuthority(new String(a));
		}
	 	if(sA!=null)u.setRole(0);
	 	else u.setRole(2);
	 	u.setPasswordQuestion("");
	 	u.setPasswordAnswer("");
	 	u.setRegUserInfo("");
		try {
			session.setAttribute("email", u.getEmail());
			session.setAttribute("name", u.getName());
			session.setAttribute("addUserAu",u.getAuthority());
			userBean.regist(u);
			session.setAttribute("errMsg",new String(""));
			response.sendRedirect("/jsp/manage/users/usersManage.jsp");
		} catch (SQLException e) {
			if (e.getErrorCode() == 0) {
				session.setAttribute("errMsg", new String(
				"添加用户失败：连接数据库失败！可能数据库已关闭"));
			}else if(e.getErrorCode() == 2627){
				session.setAttribute("errMsg", new String("添加用户失败：您注册的Email已存在！请使用其它Email注册"));
			}else if(e.getErrorCode() == 2601){
				session.setAttribute("errMsg", new String("添加用户失败：您注册的用户名已存在！请使用其它用户名注册"));
			}else {
				session.setAttribute("errMsg", new String("添加用户失败："+e.getErrorCode()+ e.getLocalizedMessage()));
			}
			response.sendRedirect("/jsp/manage/users/addUser.jsp#showErrInfo");
		} catch (Exception e) {
			session.setAttribute("errMsg", new String("添加用户失败："+ e.getMessage()));
			response.sendRedirect("/jsp/manage/users/addUser.jsp#showErrInfo");
		}
	}else if(saveType ==1){//审核用户
		String notPass = request.getParameter("notPass");
		String email = request.getParameter("email");
		try{
			if(notPass != null){//不批准用户
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
			}else{//批准用户
				User u = userBean.getUser(email);
				u.setRole(User.Administrator);
				String[] au = request.getParameterValues("userAuthority");
				if(au==null){
					u.setAuthority("000000000000000000000000000000");
				}else{
					char[] a = new char[30];
					for(int i=0;i<a.length;i++)
						a[i]='0';
					for(int i = 0; i< au.length; i++){
						a[Integer.parseInt(au[i])]='1';
					}
					u.setAuthority(new String(a));
				}
				String sA = request.getParameter("setSuperAdmin");
				if(sA!=null)u.setRole(0);
				else u.setRole(2);
				Connection con = new DBConnection().getConnection();
				Statement stat = con.createStatement();
					
				stat.execute("update users set role=" + u.getRole()
						+ ",authority=\'" + u.getAuthority()
						+ "\' where email='"+email+"'");
					
				if (stat != null) {
					stat.close();
					stat = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
				response.sendRedirect("/jsp/manage/users/usersManage.jsp");
			}
		} catch (SQLException e) {
			if (e.getErrorCode() == 0) {
				session.setAttribute("errMsg", new String(
				"审核失败：连接数据库失败！可能数据库已关闭"));
			}else {
				session.setAttribute("errMsg", new String("审核失败："+ e.getMessage()));
			}
			response.sendRedirect("/jsp/manage/users/editAuthority.jsp");
		} catch (Exception e) {
			session.setAttribute("errMsg", new String("审核失败："+ e.getMessage()));
			response.sendRedirect("/jsp/manage/users/editAuthority.jsp");
		}
	}else if(saveType ==2){//修改用户权限
		String email = request.getParameter("email");
		User u = userBean.getUser(email);
		u.setRole(User.Administrator);
		String[] au = request.getParameterValues("userAuthority");
		if(au==null){
			u.setAuthority("000000000000000000000000000000");
		}else{
			char[] a = new char[30];
			for(int i=0;i<a.length;i++)
				a[i]='0';
			for(int i = 0; i< au.length; i++){
				a[Integer.parseInt(au[i])]='1';
			}
			u.setAuthority(new String(a));
		}
		String sA = request.getParameter("setSuperAdmin");
		if(sA!=null)u.setRole(0);
		else u.setRole(2);
		try {
			Connection con = new DBConnection().getConnection();
			Statement stat = con.createStatement();
			
			stat.execute("update users set role=" + u.getRole()
					+ ",authority=\'" + u.getAuthority()
					+ "\' where email='"+email+"'");
			
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
				session.setAttribute("errMsg", new String(
				"操作失败：连接数据库失败！可能数据库已关闭"));
			}else {
				session.setAttribute("errMsg", new String("操作失败："+ e.getMessage()));
			}
			response.sendRedirect("/jsp/manage/users/editAuthority.jsp");
		} catch (Exception e) {
			session.setAttribute("errMsg", new String("操作失败："+ e.getMessage()));
			response.sendRedirect("/jsp/manage/users/editAuthority.jsp");
		}
	}else if(saveType ==3){//修改用户资料
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String pwdQuestion=request.getParameter("passwordQuestion");
		String pwdAnswer=request.getParameter("passwordAnswer");
		String regUserInfo=request.getParameter("regUserInfo");
		try {
			Connection con = new DBConnection().getConnection();
			Statement stat = con.createStatement();
			stat.execute("update users set name=\'" + name
					+ "\',passwordQuestion=\'" + pwdQuestion
					+ "\',passwordAnswer=\'" + pwdAnswer
					+ "\',regUserInfo=\'" + regUserInfo
					+ "\' where email='"+email+"'");
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
			session.setAttribute("errMsg", new String("操作失败：数据库操作失败！"+e.getMessage()));
			response.sendRedirect("/jsp/manage/");
		} catch (Exception e) {
			session.setAttribute("errMsg", new String("操作失败："+e.getMessage()));
			response.sendRedirect("/jsp/manage/");
		}
		
	}else if(saveType ==4){//修改密码
		String email = request.getParameter("email");
		String oldPwd = request.getParameter("oldPwd");
		String newPwd=request.getParameter("password");
		try {
			Connection con = new DBConnection().getConnection();
			Statement stat = con.createStatement();
			ResultSet rSet = stat.executeQuery("select password from users where email='"+email+"'");
			String userPwd =null;
			if (rSet.next()) {
				userPwd = rSet.getString("password");
			}
			if(oldPwd.equals(userPwd)){
				stat.execute("update users set password=\'" + newPwd+ "\' where email='"+email+"'");
				session.setAttribute("errMsg", new String("修改密码成功！"));
			}else{
				session.setAttribute("errMsg", new String("修改密码失败：旧密码错误！"));
			}
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
			response.sendRedirect("/jsp/manage/");

		} catch (SQLException e) {
			session.setAttribute("errMsg", new String("操作失败：数据库操作失败！"+e.getMessage()));
			response.sendRedirect("/jsp/manage/");
		} catch (Exception e) {
			session.setAttribute("errMsg", new String("操作失败："+e.getMessage()));
			response.sendRedirect("/jsp/manage/");
		}
	}
	
%>
</body>
</html>
