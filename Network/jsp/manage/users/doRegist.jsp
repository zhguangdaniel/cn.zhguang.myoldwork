<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*,database.*,user.*"%>
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
	User userInfo = new User();
	userInfo.setEmail(request.getParameter("email"));
	userInfo.setName(request.getParameter("name"));
	userInfo.setPassword(request.getParameter("password"));
	userInfo.setPasswordQuestion(request
			.getParameter("passwordQuestion"));
	userInfo.setPasswordAnswer(request.getParameter("passwordAnswer"));
	userInfo.setRegUserInfo(request.getParameter("regUserInfo"));
	try {
		session.setAttribute("email", userInfo.getEmail());
		session.setAttribute("name", userInfo.getName());
		session.setAttribute("passwordQuestion", userInfo
		.getPasswordQuestion());
		session.setAttribute("passwordAnswer", userInfo
		.getPasswordAnswer());
		session.setAttribute("regUserInfo", userInfo.getRegUserInfo());
		String vcode = (String) session.getAttribute("vcode");
		String input = request.getParameter("vcode");
		if (!input.equals(vcode)) {
			session.setAttribute("errMsg", new String("验证码错误！"));
			response.sendRedirect("/jsp/manage/users/register.jsp");
		} else {
			userInfo.setRole(1);
			userInfo.setAuthority("000000000000000000000000000000");
			userBean.regist(userInfo);

			session.setAttribute("loginMsg",
			new String("注册成功，等待管理员审核！"));
			response.sendRedirect("/jsp/manage/");
		}
	} catch (SQLException e) {
		if (e.getErrorCode() == 0) {
			session.setAttribute("errMsg", new String(
			"注册失败：连接数据库失败！可能数据库已关闭"));
		}else  if(e.getErrorCode() == 2627){
			session.setAttribute("errMsg", new String("您注册的Email已存在！请使用其它Email注册"));
		}else if(e.getErrorCode() == 2601){
			session.setAttribute("errMsg", new String("您注册的用户名已存在！请使用其它用户名注册"));
		}else {
			session.setAttribute("errMsg", new String("注册失败："+e.getErrorCode()+ e.getMessage()));
		}
		response.sendRedirect("/jsp/manage/users/register.jsp");
	} catch (Exception e) {
		session.setAttribute("errMsg", new String("注册失败："+ e.getMessage()));
		response.sendRedirect("/jsp/manage/users/register.jsp");
	}
%>
</body>
</html>
