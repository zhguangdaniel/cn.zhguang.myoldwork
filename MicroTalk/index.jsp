<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MicroTalk微博 -- 分享你的生活！</title>
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/main.js"></script>
</head>
<body onload="time()">
<!--头部header-->
<div class="header">
  <jsp:include page="/jsp/include/header.jsp" flush="true"></jsp:include>
</div>
<!--//header-->
<!--主体容器container-->
<div class="container">
  <!--内容区content，包括菜单和主内容-->
  <div id="main" class="content">
    <!--左边内容框leftContentFrame-->
    <div id="leftFrame" class="leftContentFrame">
      <div class="searchFrame">
        <jsp:include page="/jsp/search/searchFrame.jsp" flush="true"></jsp:include>
      </div>
      <div class="msgFrame">
        <jsp:include page="/jsp/msg/msgFrame.jsp" flush="true"></jsp:include>
      </div>
    </div>
    <!--右边内容框rightContentFrame-->
    <div id="rightFrame" class="rightContentFrame">
      <div class="rightSubFrame">
        <jsp:include page="/jsp/user/userInfoFrame.jsp" flush="true"></jsp:include>
      </div>
            <div class="rightSubFrame">
        <jsp:include page="/jsp/include/hotUserFrame.jsp" flush="true"></jsp:include>
      </div>
            <div class="rightSubFrame">
        <jsp:include page="/jsp/include/hotGroupFrame.jsp" flush="true"></jsp:include>
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
<script type="text/javascript">
document.getElementById("rightFrame").style.height=document.getElementById("main").scrollHeight+"px";
document.getElementById("leftFrame").style.height=document.getElementById("main").scrollHeight+"px";
</script>
</body>
</html>