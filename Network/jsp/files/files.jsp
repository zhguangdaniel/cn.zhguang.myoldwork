<%@ page contentType="text/html; charset=utf-8" language="java"
	import="files.*,java.sql.*,java.util.ArrayList"
	errorPage="jsp/error/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网工－文件下载</title>
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<link href="/css/file.css" rel="stylesheet" type="text/css" />
<jsp:useBean id="filesBean" class="files.FilesBean" scope="page" />
<jsp:useBean id="pageCtrl" class="page.PageBean" scope="page" />
</head>
<body>
<!--头部header-->
<div class="header">
  <jsp:include page="/jsp/include/header.jsp" flush="true"></jsp:include>
</div>
<!--//header-->
<!--主体容器container-->
<div class="container">
  <!--内容区content，包括菜单和主内容-->
  <div class="content">
    <!--左边内容框leftContentFrame-->
    <div class="leftContentFrame">
      <!--左边菜单框leftMenuFrame-->
      <div class="leftMenuFrame">
        <jsp:include page="/jsp/include/leftMenu.jsp" flush="true"></jsp:include>
      </div>
      <!--//leftMenuFrame-->
      <div class="imgLinksFrame">
        <jsp:include page="/jsp/include/imgLinks.jsp" flush="true"></jsp:include>
      </div>
      <div class="customLinksFrame">
        <jsp:include page="/jsp/include/customLinks.jsp" flush="true"></jsp:include>
      </div>
    </div>
    <!--右边内容框rightContentFrame-->
    <div class="rightContentFrame">
      <div class="breadcrumbs"> <a href="/">首页</a> &nbsp;&gt;&nbsp;文件下载 </div>
      <%
	int curPage = Integer.parseInt(request.getParameter("page"));
	pageCtrl = filesBean.getPage(curPage, 8);
	String currentURL = "http://"+request.getServerName()+":"+request.getServerPort()+request.getRequestURI()+"?"+request.getQueryString();
%>
      <table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tr>
          <td width="30px" height="10px"></td>
          <td align="right"></td>
          <td width="90px" align="right"></td>
          <td width="15px"></td>
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
          <td height="30px" align="right"><img src="/images/sectionArrow.gif" width="12" height="12" /></td>
          <td height="30px" align="left" style="border-bottom: dashed 1px #AAA;"><span class="fileName" title=<%=name.replaceAll(" ","")%>><%=aName%>&nbsp;&nbsp;&nbsp;</span><a
                href="/jsp/files/download.jsp?id=<%=id %>" target="_blank" class="blueText" >点击下载</a></td>
          <td align="right" style="border-bottom:dashed 1px #AAA;"><span class="dateText">[<%=f.getUploadtime().substring(0, 10)%>]</span></td>
          <td></td>
        </tr>
        <tr>
          <td height="40px"></td>
          <td height="40px" align="right" valign="top"><div style="font-family:Arial, '宋体'; font-size:12px; color: #999; line-height:20px; float:left; text-align:right; width:16%;">相关描述：&nbsp;&nbsp;</div>
            <div class="fileDescription" style="float:right; width:83%;" title="<%=description%>"><%=aDescription%></div></td>
          <td></td>
          <td></td>
        </tr>
        <%
	}
	%>
      </table>
      <div class="pageCtrlFrame">
        <%
out.print(pageCtrl.printCtrl());
%>
      </div>
    </div>
    <!--//rightContentFrame-->
  </div>
  <!--content-->
</div>
<!--container-->
<!--底部bottom-->
<div class="footer">
  <jsp:include page="/jsp/include/footer.jsp" flush="true"></jsp:include>
</div>
<!--//bottom-->
</body>
</html>