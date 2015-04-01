<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/manage.css" rel="stylesheet" type="text/css" />
<!--[if lte IE 6]>
<link href="/css/contentButtonIE6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<title>网工后台管理－技术支持</title>
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
	}else{
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
          <div id="websiteInfo">
        <table align="center" cellpadding="2" cellspacing="0" border="0">
          <tr>
            <td colspan="2" height="30px" id="bar" style="text-align:center;">技术支持</td>
          </tr>
          <tr>
            <td align="center" width="20%" height="30px" valign="middle" style="border:solid 1px #AAA; border-left-width:0;">网站名称</td>
            <td align="left" width="80%" valign="middle" style="border:solid  #AAA; border-width:1px 0 1px;">中山大学网络工程专业本科教学网站</td>
          </tr>
          <tr>
            <td align="center" width="20%" height="30px" valign="middle" style="border:solid 0 #AAA; border-bottom-width:1px;border-right-width:1px;">开发周期</td>
            <td align="left" width="80%" valign="middle" style="border:solid  #AAA; border-width:0 0 1px;">2009年8月－2009年9月</td>
          </tr>
          <tr>
            <td align="center" width="20%" height="30px" valign="middle" style="border:solid 0 #AAA; border-bottom-width:1px;border-right-width:1px;">开发者</td>
            <td align="left" width="80%" valign="middle" style="border:solid  #AAA; border-width:0 0 1px;">中山大学 张广  (zhguang_sysu@163.com)</td>
          </tr>
          <tr>
            <td align="center" width="20%" height="30px" valign="middle" style="border:solid 0 #AAA; border-bottom-width:1px;border-right-width:1px;">主要编程语言</td>
            <td align="left" width="80%" valign="middle" style="border:solid  #AAA; border-width:0 0 1px;">JSP</td>
          </tr>
          <tr>
            <td align="center" width="20%" height="30px" valign="middle" style="border:solid 0 #AAA; border-bottom-width:1px;border-right-width:1px;">运行环境</td>
            <td align="left" width="80%" valign="middle" style="border:solid  #AAA; border-width:0 0 1px;">JDK 1.6 以上 + Apache Tomcat 6.0</td>
          </tr>
          <tr>
            <td align="center" width="20%" height="30px" valign="middle" style="border:solid 0 #AAA; border-bottom-width:1px;border-right-width:1px;">数据库</td>
            <td align="left" width="80%" valign="middle" style="border:solid  #AAA; border-width:0 0 1px;">Microsoft SQL Server 2005</td>
          </tr>
          <tr>
            <td align="center" width="20%" height="30px" valign="middle" style="border:solid 0 #AAA; border-bottom-width:1px;border-right-width:1px;">维护</td>
            <td align="left" width="80%" valign="middle" style="border:solid  #AAA; border-width:0 0 1px;">中山大学 张广 (zhguang_sysu@163.com)</td>
          </tr>
          <tr>
            <td align="center" width="20%" height="40px" valign="middle" style="border:solid 0 #AAA;border-right-width:1px; border-bottom-width:1px;">管理员列表</td>
            <td align="left" width="80%" valign="middle" style="border:solid 0 #AAA; border-width:0 0 1px;"><ul>
                <li>张永民老师</li>
                <li>张广</li>
              </ul></td>
          </tr>
          <tr>
            <td align="center" width="20%" valign="middle" style="border:solid 0 #AAA;border-right-width:1px;">网站通告</td>
            <td align="left" width="80%" valign="middle" style="border:solid 0 #AAA;padding-left:20px;padding-right:20px;"><span style="color:#808080;"> 各位使用本后台的管理员请<span style="color:#F00;">注意：</span><br/>
              <br/>如遇到技术问题，可以在前台留言板发布留言，或者直接Email：zhguang_sysu@163.com </span></td>
          </tr>
        </table>
      </div>
    </div>
  </div>
      <div id="bottom">
      <jsp:include page="/jsp/manage/include/bottom.jsp" flush="true"></jsp:include>
    </div>
</div>
<%	
	}
%>
</body>
</html>
