<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage="/jsp/error/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
String rootPath = "http://" + request.getServerName() + ":"+ request.getServerPort() + request.getContextPath()+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<c:set value="<%=rootPath %>" var="rootPath" scope="session" />
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<link href="/css/dialog.css" rel="stylesheet" type="text/css" />
<script charset="utf-8" src="http://s.map.qq.com/api/js/beta/v2.1/QQMapAPI.js"></script>
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
<script type="text/javascript" src="/js/modalDialog.js"></script>
<script type="text/javascript" src="/js/modallessDialog.js"></script>
<script type="text/javascript" src="/js/register.js"></script>
<script type="text/javascript" src="/js/login.js"></script>
<title>QQ Appointment</title>
</head>
<body onload="init()">
<%-- 左边的控制面板 --%>
<div id="controlPanel" class="controlPanel">
<div id="banner" class="banner">
<div id="logo" class="logo"><img align="middle"
	src="/image/logo.png" /></div>
<div id="controlTabBar" class="controlTabBar">
<ul>
	<li><a id="userTab"
		href="javascript:showControlTab('userTab');" title="用户"
		style="background-position: -67px 0px"></a></li>
	<li><a id="searchTab"
		href="javascript:showControlTab('searchTab');" title="搜索"
		style="background-position: 0px -30px"></a></li>
	<li><a id="scheduleTab"
		href="javascript:showControlTab('scheduleTab');" title="日程"
		style="background-position: 0px -60px"></a></li>
	<li><a id="appointmentTab"
		href="javascript:showControlTab('appointmentTab');" title="活动"
		style="background-position: 0px -90px"></a></li>
</ul>
</div>
</div>
<div id="container" class="container">
<div id="controlTab" class="controlTab"><jsp:include
    page="/jsp/tabs/userTab.jsp" flush="true"></jsp:include></div>
</div>
<div id="footer" class="footer">腾讯2011年度校园之星大赛&nbsp;&bull;&nbsp;参赛作品</div>
</div>
<%-- 中间的边界 --%>
<div id="middleBorder" class="middleBorder"></div>
<%-- 右边的地图面板 --%>
<div id="mapPanel" class="mapPanel">
<noscript>
<div class="noScriptTip">对不起，本网站需要JavaScript支持，但您的浏览器目前不支持或已禁用JavaScript</div>
</noscript>
<div id="mapTopBar" class="mapTopBar">
<div id="toolItemsDiv" class="toolItemsDiv">
<ul>
	<li style="background-position: 0px 0px"><a href="javascript:openNewApp()">新建Appointment</a></li>
	<li style="background-position: 0px -20px"><a href="">热门推荐</a></li>
	<li style="background-position: 0px -40px"><a href="">随便看看</a></li>
</ul>
</div>
</div>
<div id="mapView" class="mapView"></div>
</div>
</body>
</html>