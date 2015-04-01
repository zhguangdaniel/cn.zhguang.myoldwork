<%@ page contentType="text/html; charset=utf-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/manage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/main.js"></script>
<!--[if lte IE 6]>
<style type="text/css">
#headerButton ul li a{
	height:23px;
	line-height:23px;
	padding-top:8px;
}
#headerButton ul li a:hover {
	height:23px;
	line-height:23px;
	padding-top:8px;
}
</style>
<![endif]-->
<div id="headerButton">
  <ul>
    <li style="width:180px;">
      <form id="form_search" action="/jsp/manage/search/search.jsp" method="post" style=" text-align:left;width:180px; height:30px;margin:0px; padding:0px; float:right;">
        <input type="text" name="searchKeyword" id="searchKeyword" class="blackText" style="width:120px;" value="Search..." onclick="clearSearchText()" />
        <input type="submit" class="blackText" value="搜索" onclick="return checkSearch()" />
      </form>
    </li>
    <li><a href="/" target="_blank"><img src="/images/ReturnHome.png" width="14" height="14" border="0" />&nbsp;前台首页</a></li>
    <li><a href="/jsp/manage/users/logout.jsp" target="_self"><img src="/images/logout.PNG" width="14" height="14" border="0" />&nbsp;退出系统</a></li>
  </ul>
</div>
