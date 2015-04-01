<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,database.*,files.*,com.jspsmart.upload.*"
	errorPage="/jsp/error/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:useBean id="su" class="com.jspsmart.upload.SmartUpload" scope="page" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上传文件</title>
</head>

<body>
<center>正在上传...</center>
<%
	try {
		request.setCharacterEncoding("utf-8");
		su.initialize(pageContext);
		su.service(request, response);
		su.upload();
		File file = su.getFiles().getFile(0);
		String storeName = NameGenerater.generate(file.getFileName(), file
		.getFileExt());
		
		String description = su.getRequest().getParameter("fileDescription");
		String name = su.getRequest().getParameter("fileName");
		file.saveAs("/files/" + storeName, File.SAVEAS_VIRTUAL);

		// 下面写入数据库
		Connection con = new DBConnection().getConnection();
		String reg = "insert into files values(?,?,?,?,?,?,?)";
		String uploadTime = new Timestamp(new java.util.Date().getTime()).toString();
		PreparedStatement pstmt = con.prepareStatement(reg);
		pstmt.setString(1, name);
		pstmt.setString(2, file.getFileExt());//type
		pstmt.setInt(3, file.getSize());//size
		pstmt.setString(4, uploadTime);//uploadTime
		pstmt.setString(5, storeName);//storeName
		pstmt.setString(6, description);//description
		pstmt.setString(7, (String)session.getAttribute("userName"));//creator
		pstmt.executeUpdate();

		if (pstmt != null) {
			pstmt.close();
			pstmt = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}
		session.setAttribute("errMsg", new String(""));
		response.sendRedirect("/jsp/manage/filesManage/files.jsp?page=1");
	}catch (SQLException e) {
		session.setAttribute("errMsg", new String("上传失败，数据库错误：<br/>" + e.getMessage()));
		response.sendRedirect("/jsp/manage/filesManage/upload.jsp");
	} catch (Exception e) {
		session.setAttribute("errMsg", new String("上传失败，存在如下错误：<br/>" + e.getMessage()));
		response.sendRedirect("/jsp/manage/filesManage/upload.jsp");
	}
%>
</body>
</html>
