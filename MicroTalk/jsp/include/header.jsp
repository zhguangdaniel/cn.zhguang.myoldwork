<%@ page contentType="text/html; charset=utf-8"
	errorPage="/jsp/error/error.jsp"%>
<link href="/css/main.css" rel="stylesheet" type="text/css" />

<%
	boolean isLog = false;
	try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
%>
<div class="headerTop">
  <div class="headerTopContent"> <span id="showTime" class="clockFrame"></span>
    <% if (!isLog) {%>
    <span><a href="/" target="_self">登录</a></span> <span
	class="headerTopShortLine">|</span> <span><a href="/register" target="_blank">注册</a></span>
    <%}else{ %>
    <span><a href="/logout" target="_self">退出</a></span>
    <%} %>
    <span
	class="headerTopShortLine">|</span> <span><a href="/">搜索</a></span></div>
</div>
<div class="banner">
  <div class="bannerContent"><span><img
	src="/images/enjoybyself.png" /><a href="/">随便看看</a></span> <span><img
	src="/images/recommand.png" /><a href="/">推荐给朋友</a></span></div>
</div>
<div id="headerNav" class="nav">
  <ul>
    <li><a href="/" target="_self">&nbsp;首页</a></li>
    <li><a href="/" target="_blank">&nbsp;话题动态</a></li>
    <li><a href="/" target="_blank">&nbsp;人气榜</a></li>
    <% if (isLog) {%>
    <li><a href="/myIndex" target="_blank">&nbsp;我的首页</a></li>
    <%}%>
    <li><a href="/" target="_blank">&nbsp;部落</a></li>
  </ul>
</div>
