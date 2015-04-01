<%@ page contentType="text/html; charset=utf-8" language="java" import="info.*,java.lang.Integer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网工－通知信息</title>
<link href="/old_1/css/style.css" rel="stylesheet" type="text/css" />
<link href="/old_1/css/info.css" rel="stylesheet" type="text/css" />
<jsp:useBean id="infoBean" class="info.InfoBean" scope="page"/>
<jsp:useBean id="pageCtrl" class="page.PageBean" scope="page"/>
</head>
<body>
<%
int curPage = Integer.parseInt(request.getParameter("page"));
pageCtrl=infoBean.getPage(curPage,20);
%>
<!--主体容器container-->
<div id="container">
    <!--主头部mainHeader-->
    <div id="mainHeader">
        <jsp:include page="/old_1/jsp/include/mainHeader.jsp" flush="true"></jsp:include>
    </div>
    <!--//mainHeader-->
    <!--主信息区-->
    <div id="mainContent">
        <div id="breadcrumbs"> <a href="/old_1/index.jsp" class="normalLink">首页</a> &gt;通知列表 </div>
        <table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
            <%
        while(pageCtrl.resultList.size()!=0){
        	Info i = (Info)pageCtrl.resultList.remove(0);
			String title = i.getTitle();
			String aTitle = title;
			if(title.length()>31){
				aTitle=title.substring(0,30)+"...";
			}
        %>
            <tr>
                <td width="15%" height="30px"></td>
                <td width="55%" height="30px" align="left"><img src="/old_1/images/news.png" width="12" height="12" /><a href="/old_1/jsp/info/info.jsp?id=<%=i.getId()%>" target="_blank" class="text" title=<%=title%>><%=aTitle%></a></td>
                <td width="15%" align="left"><span id="newsDate">[<%=i.getCreateTime().substring(0,10)%>]</span></td>
                <td width="15%"></td>
            </tr>
            <%}%>
            <tr><td height="10px" colspan="4"></td></tr>
        </table>
        <div id="pageCtrlFrame">
            <%out.print(pageCtrl.printCtrl());%>
        </div>
    </div>
    <!--//mainContent-->
    <!--尾部bottom-->
    <div id="bottom">
        <jsp:include page="/old_1/jsp/include/bottom.jsp" flush="true"></jsp:include>
    </div>
    <!--//bottom-->
</div>
<!--container-->
</body>
</html>