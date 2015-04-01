<%@ page contentType="text/html; charset=utf-8" language="java" import="customLinks.*,java.sql.*,java.util.ArrayList" errorPage="jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/old_1/css/style.css" type="text/css" rel="stylesheet" />
<jsp:useBean id="links" class="customLinks.LinksBean" scope="page"/>
<%
ArrayList<Link> linksList = links.getTopCountLinks(15);
%>
<table width="200" height="200" align="center"  cellpadding="0"
	cellspacing="0" border="0">
    <tr class="bar">
        <td align="left" style="padding-left:10px;">相关链接</td>
    </tr>
    <tr>
        <td height="180px" align="left" valign="top">
        <marquee direction="up" scrollamount="1" scrolldelay="50" onmouseover="this.stop()" onmouseout="this.start()" width="100%" height="100%">
        <%
        while(linksList.size()!=0){
        	Link l = linksList.remove(0);
			String lText = l.getText();
			String aText = lText;
			if(lText.length()>15){
				aText=lText.substring(0,14)+"...";
			}
        %>
        <a href="<%=l.getLink()%>" target="_blank" class="text" style="line-height:20px;" title=<%=lText %>>&nbsp;&middot;<%=aText%></a><br />
		<%}%> 
        </marquee>
        </td>
    </tr>
</table>
