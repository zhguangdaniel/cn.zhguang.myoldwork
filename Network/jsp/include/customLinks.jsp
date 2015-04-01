<%@ page contentType="text/html; charset=utf-8" language="java" import="customLinks.*,java.sql.*,java.util.ArrayList" errorPage="/jsp/error/error.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/main.css" type="text/css" rel="stylesheet" />
<jsp:useBean id="links" class="customLinks.LinksBean" scope="page"/>
<%
ArrayList<Link> linksList = links.getTopCountLinks(5);
%>
<div style="width:150px;">
  <div class="titleItemsFrame">
    <ul>
      <%
        while(linksList.size()!=0){
        	Link l = linksList.remove(0);
			String lText = l.getText();
			String time = l.getCreateTime().substring(0,10);
        %>
      <li><a href="<%=l.getLink()%>" target="_blank" class="text" title=<%=time%>><%=lText%></a></li>
      <%}%>
    </ul>
  </div>
</div>
