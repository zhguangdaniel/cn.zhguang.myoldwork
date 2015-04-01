<%@ page contentType="text/html; charset=utf-8" language="java" import="files.*,java.io.FileNotFoundException" errorPage="jsp/error/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:useBean id="su" class="com.jspsmart.upload.SmartUpload" scope="page"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:useBean id="filesBean" class="files.FilesBean" scope="page"/>
</head>
<%
	request.setCharacterEncoding("utf-8");
   // int downloadType = Integer.parseInt(request.getParameter("downType"));
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	//if(downloadType == 0){//上传的文件下载
		SingleFile f = filesBean.getFile(Integer.parseInt(request.getParameter("id")));
		String storeName = f.getStoreName();  
		String name = f.getName();
		String type = f.getType();
		try {
			su.initialize(pageContext);
			su.setContentDisposition(null);
			out.clear();
			out = pageContext.pushBody();
			su.downloadFile("/files/"+storeName,type,name+"."+type);
		} catch (Exception e) {
			out.println("<p><center>指定的文件 "+ basePath +"files/"+ storeName+"（"+name+"） 不存在，可能已被删除</center></p>");
		}
	//}
	//else{//文章中的文件下载
	//	String name= request.getParameter("name");
	//	String storeName= request.getParameter("storeName");
	//	String type= request.getParameter("type");
	//	try {
	//		su.initialize(pageContext);
	//		su.setContentDisposition(null);
	//		su.downloadFile("/files/upload_for_article/files/"+storeName,type,name+"."+type);
	//	} catch (Exception e) {
	//		out.println("<p><center>指定的文件 "+ basePath +"files/"+ storeName+"（"+EncodeTrans.trans(name)+"） 不存在，可能已被删除</center></p>");
	//	}
	//}
%>
</html>
