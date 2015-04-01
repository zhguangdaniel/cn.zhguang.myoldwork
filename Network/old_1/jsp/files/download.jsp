<%@ page contentType="text/html; charset=utf-8" language="java" import="files.*,java.io.FileNotFoundException" errorPage="jsp/error/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:useBean id="su" class="com.jspsmart.upload.SmartUpload" scope="page"/>
<%@page import="files.FilesBean"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:useBean id="filesBean" class="files.FilesBean" scope="page"/>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	String name= request.getParameter("name").replaceAll(" ","");
	SingleFile f = filesBean.getFile(Integer.parseInt(request.getParameter("id")));
	String storeName = f.getStoreName();
	String type = f.getType();
%>
<title>文件下载</title>
</head>
<body>
<%
	try {
		su.initialize(pageContext);
		su.setContentDisposition(null);
		out.clear();
		out = pageContext.pushBody();
		su.downloadFile("/files/"+storeName,type,name+"."+type);
	} catch (Exception e) {
		out.println("<p><center>指定的文件 "+ basePath +"files/"+ storeName+"（"+EncodeTrans.trans(name)+"） 不存在，可能已被删除</center></p>");
	}
%>
</body>
</html>
