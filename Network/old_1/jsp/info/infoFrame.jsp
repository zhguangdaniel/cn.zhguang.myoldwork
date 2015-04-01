<%@ page contentType="text/html; charset=utf-8" language="java" import="info.*,java.sql.*,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/old_1/css/style.css" type="text/css" rel="stylesheet" />
<jsp:useBean id="info" class="info.InfoBean" scope="page"/>

<%
ArrayList<Info> infoList = info.getTopCountInfo(8);

%>
<table width="569" height="220" align="center"  cellpadding="0"
	cellspacing="0" border="0">
    <tr class="bar">
        <td align="left" style="padding-left:10px;">通知信息</td>
    </tr>
    <tr>
        <td height="180px" align="left" valign="top"><table width="100%" border="0"cellpadding="0" cellspacing="0">
        <%
        while(infoList.size()!=0){
        	Info i =infoList.remove(0);
			String title = i.getTitle();
			String aTitle = title;
			if(title.length()>39){
				aTitle=title.substring(0,38)+"...";
			}
        %>
        	<tr>
                <td width="86%" height="23px" align="left"><img src="/old_1/images/news.png" width="12" height="12" /><a href="/old_1/jsp/info/info.jsp?id=<%=i.getId()%>" target="_blank" class="text" title=<%=title%>><%=aTitle%></a></td>
                <td width="14%" align="left"><span id="newsDate">[<%=i.getCreateTime().substring(0,10)%>]</span></td>
            </tr>
        <% 
        }
        %>
            </table></td>
    </tr>
    <tr>
    <td align="right" valign="middle"><a href="/old_1/jsp/info/infoList.jsp?page=1" class="more">>>more&nbsp;&nbsp;</a></td>
    </tr>
</table>
