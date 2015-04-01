<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,database.*,user.*" errorPage="/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/manage.css" rel="stylesheet" type="text/css" />
<link href="/css/manageContent.css" rel="stylesheet" type="text/css" />
<!--[if lte IE 6]>
<link href="/css/contentButtonIE6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<jsp:useBean id="filesBean" class="files.FilesBean" scope="page" />
<script type="text/javascript" src="/js/files.js"></script>
<title>网工后台管理－文件上传</title>
</head>
<body>
<%
	boolean isLog = false;
		try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
	if (!isLog) {
		session.setAttribute("isLog",new String("0"));
		session.setAttribute("loginMsg", new String("您还未登录，请先登录！"));
		response.sendRedirect("/jsp/manage/");
	}else if(!User.checkHaveAuthority(((String)session.getAttribute("userAuthority")),User.uploadFile)){
		out.println("<center>你没有打开该页面的权限...</center>");
	}else{
		String errMsg = null;
		try {
			errMsg = (String) session.getAttribute("errMsg");
		} catch (Exception e) {
		}
		if (errMsg == null) {
			errMsg = "";
		}
		String parentURL = request.getParameter("parent");
%>
<!--全部区域-->
<div id="container">
    <!--头部-->
    <div id="header">
        <jsp:include page="/jsp/manage/include/header.jsp" flush="true"></jsp:include>
    </div>
    <!--主区，包括菜单区（垂直导航条）和工作区-->
    <div id="mainContent">
        <div id="leftMenu">
            <jsp:include page="/jsp/manage/include/leftMenu.jsp" flush="true"></jsp:include>
        </div>
        <div id="rightMain">
        <div id="contentHeader">&nbsp;&nbsp;<a href="/jsp/manage/" class="normalLink">后台管理</a> &nbsp;&gt;&nbsp;<a href="/jsp/manage/filesManage/files.jsp?page=1" class="normalLink">文件管理</a> &nbsp;&gt;&nbsp;上传文件&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="/images/Return.png" width="12" height="12" /><a
                href="<%=parentURL%>" target="_self" class="normalLink" style="color:#069" >返回</a></div>
            <div id="uploadFrame">
                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                    <tr>
                        <td height="30px" id="bar" style="text-align:center;">文件上传</td>
                    </tr>
                    <tr>
                        <td height="10px">&nbsp;</td>
                    </tr>
                    <tr>
                        <td id="tdTitle" height="20px" valign="middle" align="left" style="padding-left:20px;font-family:Arial, '宋体'; font-size:14px;"><img
			src="/images/saveFile.png" width="14" height="14" />&nbsp;请选择要上传的文件：</td>
                    </tr>
                    <tr>
                        <td valign="top" align="center"><form id="formUpload" method="post" action="/jsp/manage/filesManage/saveFile.jsp"
			enctype="multipart/form-data" target="_self">
                                <input type="file" name="fileUpload" id="fileUpload" size="41" style=" margin-top:3px; margin-bottom:5px;" onchange="return setItemName()" />
                                <br />
                                <div style=" width:360px; height:25px; line-height:25px; font-family:Arial, '宋体'; font-size:14px; text-align:left; margin:0 auto;">显示名称：<span style="color:#999; font-size:12px;">（你可以自定义名称，也可以由系统指定）</span></div>
                                <input type="text" name="fileName" id="fileName" style=" width:360px; font-size:12px; font-family:Arial, '宋体'; margin-top:3px; margin-bottom:5px;" title="该名称会显示在文件列表"/>
                                <div style=" width:360px; height:25px; line-height:25px; font-family:Arial, '宋体'; font-size:14px; text-align:left; margin:0 auto;">文件描述：<span style="color:#999; font-size:12px;">（建议填写，没有文件描述也可以留空）</span></div>
                                <textarea name="fileDescription" id="fileDescription" class="fileDescription" cols="" rows=""></textarea>
                                <div class="errMsgFrame" id="errMsg"></div>
                                <input type="submit" name="submit" value="上传" onclick="return checkFile()" />
                                <input type="reset" name="reset" value="重置" />
                            </form>
                            </td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                </table>
            </div>
        </div>
    </div>
    <div id="bottom">
        <jsp:include page="/jsp/manage/include/bottom.jsp" flush="true"></jsp:include>
    </div>
</div>
<script language="javascript">
<!--
	document.getElementById("errMsg").innerHTML="<font color='#FF0000' size='-1' face='Arial, 宋体'>"+<%=("\""+errMsg+"\"")%>+"</font>";
//-->
</script>
<%	
	errMsg = "";
	session.setAttribute("errMsg",new String(""));
	}
%>
</body>
</html>
