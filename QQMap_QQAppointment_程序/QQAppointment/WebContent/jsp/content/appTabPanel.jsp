<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="tabNavigation">
<ul>
<li><a id="appDetailTab" href="javascript:loadTabContent('appDetailTab')" class="ajaxCurrentTab">详情</a></li>
<li><a id="appDiscussTab" href="javascript:loadTabContent('appDiscussTab')">评论</a></li>
<li><a id="appResourceTab" href="javascript:loadTabContent('appResourceTab')">资源</a></li>
</ul>
</div>
<div id="tabContent" class="tabContent"></div>
<script type="text/javascript">
function loadTabContent(id){
	$J(".tabNavigation ul li a").removeClass("ajaxCurrentTab");
	$J("#" +id).addClass("ajaxCurrentTab");
	load("tabContent","/jsp/tabs/"+id+".jsp");
}
</script>