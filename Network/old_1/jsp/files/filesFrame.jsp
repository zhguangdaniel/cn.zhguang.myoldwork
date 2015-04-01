<%@ page contentType="text/html; charset=utf-8" language="java" import="files.*,java.sql.*,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/old_1/css/style.css" type="text/css" rel="stylesheet" />
<jsp:useBean id="files" class="files.FilesBean" scope="page"/>

<%
ArrayList<SingleFile> filesList = files.getTopCountFiles(7);

%>
<table width="569" height="207" align="center"  cellpadding="0"
	cellspacing="0" border="0">
    <tr class="bar">
        <td align="left" style="padding-left:10px;">最新文件下载</td>
    </tr>
    <tr>
        <td height="167px" align="left" valign="top"><table width="100%" border="0"cellpadding="0" cellspacing="0">
        <%
        while(filesList.size()!=0){
        	SingleFile f = filesList.remove(0);
			String name = f.getName();
			String aName = name;
			if(name.length()>35){
				aName=name.substring(0,34)+"...";
			}
        %>
        	<tr>
                <td width="86%" height="24px" align="left"><img src="/old_1/images/news.png" width="12" height="12" />
                <span id="blackText" title=<%=name.replaceAll(" ","")%>><%=aName%>&nbsp;&nbsp;&nbsp;</span><a href="/old_1/jsp/files/download.jsp?name=<%=aName%>&amp;id=<%=f.getId() %>" target="_blank" class="normalLink" >下载</a></td>
                <td width="14%"><span id="newsDate">[<%=f.getUploadtime().substring(0,10)%>]</span></td>
            </tr>
        <% 
        }
        %>
            </table></td>
    </tr>
    <tr>
    <td align="right" valign="middle"><a href="/old_1/jsp/files/files.jsp?page=1" class="more">>>more&nbsp;&nbsp;</a></td>
    </tr>
</table>
