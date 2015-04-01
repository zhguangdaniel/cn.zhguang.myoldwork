<%@ page contentType="text/html; charset=utf-8" language="java" import="info.*,java.sql.*,java.util.ArrayList"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/main.css" type="text/css" rel="stylesheet" />
<jsp:useBean id="info" class="info.InfoBean" scope="page"/>
<%
ArrayList<Info> infoList = info.getTopCountInfo(8);
%>
<div style="width:240px;">
  <div class="bar">通知</div>
  <div class="titleItemsFrame">
    <ul>
      <%
        while(infoList.size()!=0){
        	Info i =infoList.remove(0);
			String title = i.getTitle();
			String time = i.getCreateTime().substring(0,16);
        %>
      <li><a href="/jsp/info/info.jsp?id=<%=i.getId()%>" target="_blank"><%=title%></a><span><%=time%></span></li>
      <% 
        }
        %>
      <div style="text-align:right; padding-right:10px;"><a href="/jsp/info/infoList.jsp?page=1"><img src="/images/moreInfo.jpg" /></a></div>
    </ul>
  </div>
</div>
