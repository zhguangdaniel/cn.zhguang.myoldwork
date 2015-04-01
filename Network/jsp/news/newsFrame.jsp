<%@ page contentType="text/html; charset=utf-8" language="java" import="news.*,java.sql.*,java.util.ArrayList"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/main.css" type="text/css" rel="stylesheet" />
<jsp:useBean id="news" class="news.NewsBean" scope="page"/>
<%
ArrayList<SingleNews> newsList = news.getTopCountNews(8);
%>
<div style="width:240px;">
  <div class="bar">新闻</div>
  <div class="titleItemsFrame">
    <ul>
      <%
        while(newsList.size()!=0){
        	SingleNews aNews = newsList.remove(0);
			String title = aNews.getTitle();
			String time = aNews.getCreateTime().substring(0,16);
        %>
      <li><a href="/jsp/news/news.jsp?id=<%=aNews.getId()%>" target="_blank"><%=title%></a><span><%=time%></span></li>
      <% 
        }
        %>
      <div style="text-align:right; padding-right:10px;"><a href="/jsp/news/newsList.jsp?page=1"><img src="/images/moreNews.jpg" /></a></div>
    </ul>
  </div>
</div>
