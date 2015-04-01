<%@ page contentType="text/html; charset=utf-8" language="java" import="news.*,java.sql.*,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/old_1/css/style.css" type="text/css" rel="stylesheet" />
<jsp:useBean id="news" class="news.NewsBean" scope="page"/>

<%
ArrayList<SingleNews> newsList = news.getTopCountNews(8);

%>
<table width="358" height="213" align="center"  cellpadding="0"
	cellspacing="0" border="0">
    <tr class="bar">
        <td align="left" style="padding-left:10px;">新闻中心</td>
    </tr>
    <tr>
        <td height="173px" align="left" valign="top"><table width="100%" border="0"cellpadding="0" cellspacing="0">
        <%
        while(newsList.size()!=0){
        	SingleNews aNews = newsList.remove(0);
			String title = aNews.getTitle();
			String aTitle = title;
			if(title.length()>24){
				aTitle=title.substring(0,23)+"...";
			}
        %>
        	<tr>
                <td width="87%" height="22px" align="left"><img src="/old_1/images/news.png" width="12" height="12" /><a href="/old_1/jsp/news/news.jsp?id=<%=aNews.getId()%>" target="_blank" class="text" title=<%=title%>><%=aTitle%></a></td>
                <td width="83%"><span id="newsDate">[<%=aNews.getCreateTime().substring(5,10)%>]</span></td>
            </tr>
        <% 
        }
        %>
            </table></td>
    </tr>
    <tr>
    <td align="right" valign="middle"><a href="/old_1/jsp/news/newsList.jsp?page=1" class="more">>>more&nbsp;&nbsp;</a></td>
    </tr>
</table>
