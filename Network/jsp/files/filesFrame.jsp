<%@ page contentType="text/html; charset=utf-8" language="java" import="files.*,java.sql.*,java.util.ArrayList"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/main.css" type="text/css" rel="stylesheet" />
<jsp:useBean id="files" class="files.FilesBean" scope="page"/>
<%
ArrayList<SingleFile> filesList = files.getTopCountFiles(8);
%>
<div style="width:240px;">
  <div class="bar">文件下载</div>
  <div class="titleItemsFrame">
    <ul>
      <%
	    while(filesList.size()!=0){
        	SingleFile f = filesList.remove(0);
			String name = f.getName();
			String time = f.getUploadtime().substring(0,16);
        %>
      <li><a href="/jsp/files/download.jsp?id=<%=f.getId() %>" title="<%=time%>" target="_blank"><%=name%></a></li>
      <%}%>
      <div style="text-align:right; padding-right:10px;"><a href="/jsp/files/files.jsp?page=1"><img src="/images/moreFiles.jpg" /></a></div>
    </ul>
  </div>
</div>
