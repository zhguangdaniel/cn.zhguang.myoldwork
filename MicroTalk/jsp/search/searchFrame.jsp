<%@ page contentType="text/html; charset=utf-8" errorPage="/jsp/error/error.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/main.js"></script>
<div class="webIntro"><span>MicroTalk是一个专业微博网站，在<a href="/register" style="color:#006699;">注册</a>成为用户后，你可以通过发布简短的微博消息，记录你日常生活中的点点滴滴。你可以关注感兴趣的用户并与这些用户共享信息。</span></div>
<div class="searchLineFrame"> <span id="blackText" style="float:left; margin-left:20px;">搜搜看：</span>
  <form id="form_search" method="post">
    <input type="text" name="searchKeyword" id="searchKeyword" class="blackText" style="width:350px"  value="Search..." onclick="clearSearchText()" />
    <a href="return doSearch('/')" class="searchButton">搜话题</a> <a href="" class="searchButton">搜人</a>
  </form>
</div>
