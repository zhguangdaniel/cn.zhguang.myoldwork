<%@ page contentType="text/html; charset=utf-8" language="java"
	import="files.*,java.sql.*,java.util.ArrayList"
	errorPage="jsp/error/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网工－文件下载</title>
<link href="/old_1/css/style.css" rel="stylesheet" type="text/css" />
<link href="/old_1/css/file.css" rel="stylesheet" type="text/css" />
<jsp:useBean id="filesBean" class="files.FilesBean" scope="page" />
<jsp:useBean id="pageCtrl" class="page.PageBean" scope="page" />
</head>
<body>
<!--主体容器container-->
<div id="container">
    <!--主头部mainHeader-->
    <div id="mainHeader">
        <jsp:include page="/old_1/jsp/include/mainHeader.jsp" flush="true"></jsp:include>
    </div>
    <!--//mainHeader-->
    <!--主信息区-->
    <div id="mainContent">
        <div id="breadcrumbs"><a href="/old_1/index.jsp" class="normalLink">首页</a>&nbsp;&gt;&nbsp;文件下载 </div>
        <%
	int curPage = Integer.parseInt(request.getParameter("page"));
	pageCtrl = filesBean.getPage(curPage, 8);
	String currentURL = "http://"+request.getServerName()+":"+request.getServerPort()+request.getRequestURI()+"?"+request.getQueryString();
%>
        <table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
                    <tr>
                <td width="20px" height="20px"></td>
                <td width="110px" align="left"></td>
                <td width="540px" align="right"></td>
                <td width="90px" align="right"></td>
                <td width="20px"></td>
            </tr>
            <%
			while (pageCtrl.resultList.size() != 0) {
			SingleFile f = (SingleFile) pageCtrl.resultList.remove(0);
			String name = f.getName();
			int id = f.getId();
			String description = f.getDescription();
			if(description==null)description="";
			String aDescription = description;
			String aName = name;
			if (name.length() > 36) {
				aName = name.substring(0, 35) + "...";
			}
			if (description.length() > 90) {
				aDescription = description.substring(0, 89) + "...";
			}
	%>
            <tr>
                <td height="30px"></td>
                <td height="30px" align="left" colspan="2" style="border-bottom: dashed 1px #AAA;">
                <img src="/old_1/images/news.png" width="12" height="12" /><span id="fileName" title=<%=name.replaceAll(" ","")%>><%=aName%>&nbsp;&nbsp;&nbsp;</span><img src="/old_1/images/download.png" width="12" height="9" /><a
                href="/old_1/jsp/files/download.jsp?name=<%=aName%>&amp;id=<%=id %>" target="_blank" class="normalLink" >点击下载</a>
                </td>
                <td align="right" style="border-bottom:dashed 1px #AAA;"><span id="newsDate">[<%=f.getUploadtime().substring(0, 10)%>]</span></td>
                <td></td>
            </tr>
            <tr>
                    <td height="40px"></td>
                    <td height="40px" align="right" valign="top" colspan="2" >
                    <div style="font-family:Arial, '宋体'; font-size:12px; color: #999; line-height:20px; float:left; text-align:right; width:16%;">相关描述：&nbsp;&nbsp;</div>
                    <div id="fileDescription" style="float:right; width:83%;" title="<%=description%>"><%=aDescription%></div></td>
                    <td></td>
                    <td></td>
            </tr>

            <%
	}
	%>
            <tr>
                <td height="10px" colspan="5"></td>
            </tr>
        </table>
        <div id="pageCtrlFrame">
            <%
out.print(pageCtrl.printCtrl());
%>
        </div>
    </div>
    <!--//mainContent-->
    <!--尾部bottom-->
    <div id="bottom">
        <jsp:include page="/old_1/jsp/include/bottom.jsp"
	flush="true"></jsp:include>
    </div>
    <!--//bottom-->
</div>
<!--container-->
</body>
</html>
