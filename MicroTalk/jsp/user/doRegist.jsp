<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,database.*,user.*,files.*,com.jspsmart.upload.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:useBean id="userBean" class="user.UserCtrl" scope="page" />
<jsp:useBean id="su" class="com.jspsmart.upload.SmartUpload" scope="page" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>执行用户注册</title>
</head>

<body>
<%
	try {
		//下面上传图片，并将路径存入userInfo中
		su.initialize(pageContext);
		su.service(request, response);
		su.upload();
		File file = su.getFiles().getFile(0);
		
		request.setCharacterEncoding("utf-8");
		User userInfo = new User();
		userInfo.setEmail(su.getRequest().getParameter("email"));
		userInfo.setUserName(su.getRequest().getParameter("name"));
		userInfo.setSelfDescription(su.getRequest().getParameter("regUserInfo"));
		
		session.setAttribute("email", userInfo.getEmail());
		session.setAttribute("userNname", userInfo.getUserName());
		session.setAttribute("oldSelfDesc", userInfo
				.getSelfDescription());
		String vcode = (String) session.getAttribute("vcode");
		String input = su.getRequest().getParameter("vcode");
		
		if (!input.equals(vcode)) {
			session.setAttribute("errMsg", new String("验证码错误！"));
			response.sendRedirect("/register");
		} else {
			userInfo.setPassword(su.getRequest().getParameter("password"));
			userInfo.setRole(0);

			if (file.getSize() > 1048576)
				throw new Exception("文件大小不能超过1MB");
			String userIconPath=null;
			try{
				userIconPath = (String)session.getAttribute("userIconPath");
			}finally{
				String ext = file.getFileExt().toLowerCase();
				String storeName = NameGenerater.generate(file.getFileName(), ext);
				userIconPath = "/files/userIcons/" + storeName;
				session.setAttribute("userIconPath", userIconPath);
			}


			file.saveAs(userIconPath,File.SAVEAS_VIRTUAL);
			userInfo.setUserIconPath(userIconPath);			
			userBean.regist(userInfo);

			session.setAttribute("userId", userBean.getUserId(userInfo.getEmail()));
			session.setAttribute("attentionMeNum","0");
			session.setAttribute("isLog", new String("1"));
			response.sendRedirect("/myIndex");
		}
	} catch (SQLException e) {
		//if (e.getErrorCode() == 0) {
		//	session.setAttribute("errMsg", new String(
		//			"注册失败：连接数据库失败！可能数据库已关闭"));
		//}//else 
		if(e.getErrorCode() == 2601){
			session.setAttribute("errMsg", new String("您注册的用户已存在！请使用其它Email注册"));
		}else {
			session.setAttribute("errMsg", new String("注册失败（数据库操作失败）："+ e.getErrorCode() + e.getMessage()));
		}
		response.sendRedirect("/register");
	} catch (Exception e) {
		session.setAttribute("errMsg", new String("注册失败："+ e.getMessage()));
		response.sendRedirect("/register");
	}
%>
</body>
</html>
