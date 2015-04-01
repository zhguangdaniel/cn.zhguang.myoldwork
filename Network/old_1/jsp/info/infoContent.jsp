<%@ page contentType="text/html; charset=utf-8" language="java" import="info.*,java.sql.*,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/old_1/css/info.css" type="text/css" rel="stylesheet" />
<link href="/old_1/css/style.css" type="text/css" rel="stylesheet" />
<jsp:useBean id="infoBean" class="info.InfoBean" scope="page"/>
<div id="breadcrumbs">
<a href="/old_1/index.jsp" class="normalLink">首页</a>&nbsp;&gt;&nbsp;<a href="/old_1/jsp/info/infoList.jsp?page=1" class="normalLink">通知列表</a> &nbsp;&gt;&nbsp;通知
</div>
<%
Info i = infoBean.getInfo(Integer.parseInt(request.getParameter("id")));
%>
<div id="info">
<table width="100%" cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td align="center" height="30px" valign="middle" id="title"><%=i.getTitle()%></td>        
    </tr>
    <tr>
        <td align="center" height="20px" valign="bottom" id="articleInfo">
        <%
		if (!i.getCreater().equals("") && !(i.getCreater() == null)) {
		%>发布者：<%=i.getCreater()%>&nbsp;&nbsp;&nbsp;<%
		}
		%>
		发布于：<%=i.getCreateTime().substring(0, 16)%>
        </td>
    </tr>
    <tr>
        <td height="5px" width="100%" valign="top"></td>        
    </tr>
    <tr>
        <td align="left" width="100%" valign="top"><span><%=i.getContent()%></span></td>        
    </tr>
    <tr>
        <td height="20px" width="100%" valign="top"></td>        
    </tr>
        <%
	if (i.getModifyTime() != null) {
	%>
        <tr>
            <td align="left" height="20px" width="100%" valign="middle"><span
			id="bottomTips">本文于&nbsp;<%=i.getModifyTime().substring(0, 16)%>&nbsp;被<%
		if ((i.getModifyUser()!=null) && !i.getModifyUser().equals("")) {
		%>
                &nbsp;<%=i.getModifyUser()%>&nbsp;
        <%}%>修改</span></td>
        </tr>
        <%
	}
	%>
</table>

</div>