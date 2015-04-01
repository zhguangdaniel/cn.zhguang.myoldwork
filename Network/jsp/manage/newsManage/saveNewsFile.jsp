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
		//String title = EncodeTrans.trans(su.getRequest().getParameter("newsTitle"));
		//String htmlText = EncodeTrans.trans(su.getRequest().getParameter("newsContent"));
		String title = su.getRequest().getParameter("newsTitle");
		String htmlText = su.getRequest().getParameter("newsContent");
		String addText = "";//要添加的内容
		session.setAttribute("title", title);
		session.setAttribute("newsContent", htmlText);
		File file = su.getFiles().getFile(0);
		
		if(file.getSize()>2097152)
			throw new Exception("文件大小不能超过2MB");
		
		String ext = file.getFileExt().toLowerCase();
		String storeName = NameGenerater.generate(file.getFileName(),ext);

		
		//String currentURL = "http://"+request.getServerName()+":"+request.getServerPort();
		if (ext.equals("jpg") || ext.equals("gif")
		|| ext.equals("bmp")
		|| ext.equals("png")
		|| ext.equals("jpeg")
		|| ext.equals("tif")) {
			file.saveAs("/files/upload_for_article/images/"+ storeName, File.SAVEAS_VIRTUAL);
			addText = "<img src='/files/upload_for_article/images/"+storeName+"' border='0' alt='' /><br />";
		} else {
			file.saveAs("/files/upload_for_article/files/"+ file.getFileName(), File.SAVEAS_VIRTUAL);
			addText = "<a href='/files/upload_for_article/files/"+file.getFileName()+"' target='_blank'>"+file.getFileName()+"</a><br />";
		}
		htmlText += addText;
		session.setAttribute("errMsg", new String("上传成功！"));

		session.setAttribute("newsContent", htmlText);
		
	} catch (Exception e) {
		session.setAttribute("errMsg","上传失败，" + e.getMessage());
	}
	
	int isModify = Integer.parseInt(request.getParameter("isModify"));//判断是不是修改文章
	if(isModify==0){
		response.sendRedirect("/jsp/manage/newsManage/publishNews.jsp");
	}else{
		session.setAttribute("isUpload", new String("1"));//当前是否是上传文件
		String parentURL = request.getParameter("parent");
		int id = Integer.parseInt(request.getParameter("id"));
		response.sendRedirect("/jsp/manage/newsManage/editNews.jsp?id="+id+"&parent="+parentURL);
	}
%>
</body>
</html>
