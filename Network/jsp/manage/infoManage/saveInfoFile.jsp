<%@ page contentType="text/html; charset=utf-8" language="java" import="files.*,com.jspsmart.upload.*"
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
		su.initialize(pageContext);
		su.service(request, response);
		
		//su.setAllowedFilesList("jpg,gif,bmp,png,jpeg,tif,rar,zip,txt,doc,xls,ppt,docx,xlsx,pptx,pdf,,");//允许上传的文件类型，,,表示不含后缀名的文件
		//su.setMaxFileSize(2097152);//每个文件的最大size,2097152=2*1024*1024，以B（比特）为单位，这里最大限制为2M
		//su.setTotalMaxFileSize(2097152);
		su.upload();
		String title = su.getRequest().getParameter("infoTitle");
		String htmlText = su.getRequest().getParameter("infoContent");
		String addText = "";//要添加的内容
		session.setAttribute("title", title);
		session.setAttribute("infoContent", htmlText);
		
		File file = su.getFiles().getFile(0);
		if(file.getSize()>2097152)
			throw new Exception("文件大小不能超过2MB");
		
		String ext = file.getFileExt().toLowerCase();
		String storeName = NameGenerater.generate(file.getFileName(),ext);
		request.setCharacterEncoding("utf-8");
		
		//String currentURL = "http://"+request.getServerName()+":"+request.getServerPort();
		if (ext.equals("jpg") || ext.equals("gif")
		|| ext.equals("bmp")
		|| ext.equals("png")
		|| ext.equals("jpeg")
		|| ext.equals("tif")) {
			file.saveAs("/files/upload_for_article/images/"+ storeName, File.SAVEAS_VIRTUAL);
			addText = "<img src='/files/upload_for_article/images/"+storeName+"' border='0' alt='' /><br />";
			//<p><img src="" alt="" width="10" height="20" /></p>
		} else {
			file.saveAs("/files/upload_for_article/files/"+ file.getFileName(), File.SAVEAS_VIRTUAL);
			addText = "<a href='/files/upload_for_article/files/"+file.getFileName()+"' target='_blank'>"+file.getFileName()+"</a><br />";
		}
		htmlText += addText;
		//out.println(title);out.println(htmlText);out.println(publisher);
		session.setAttribute("errMsg", new String("上传成功！"));
		session.setAttribute("infoContent", htmlText);
	} catch (Exception e) {
		session.setAttribute("errMsg","上传失败，" + e.getMessage());
	}
	int isModify = Integer.parseInt(request.getParameter("isModify"));//判断是不是修改文章
	if(isModify==0){
		response.sendRedirect("/jsp/manage/infoManage/publishInfo.jsp");
	}else{
		session.setAttribute("isUpload", new String("1"));//当前是否是上传文件
		String parentURL = request.getParameter("parent");
		int id = Integer.parseInt(request.getParameter("id"));
		response.sendRedirect("/jsp/manage/infoManage/editInfo.jsp?id="+id+"&parent="+parentURL);
	}
%>
</body>
</html>
