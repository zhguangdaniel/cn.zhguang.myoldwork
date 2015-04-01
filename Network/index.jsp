<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>中山大学网络工程专业－首页</title>
<link href="/css/main.css" rel="stylesheet" type="text/css" />
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
      <div class="flashAblumFrame">
        <jsp:include page="/jsp/include/flashAblum.jsp" flush="true"></jsp:include>
      </div>
      <div class="newsFrame">
        <jsp:include page="/jsp/news/newsFrame.jsp" flush="true"></jsp:include>
      </div>
      <div class="infoFrame">
        <jsp:include page="/jsp/info/infoFrame.jsp" flush="true"></jsp:include>
      </div>
      <div class="filesFrame">
        <jsp:include page="/jsp/files/filesFrame.jsp" flush="true"></jsp:include>
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
<div class="siteStatFrame">
<jsp:include page="/jsp/include/siteStat.jsp" flush="true"></jsp:include>
</div>
</body>
</html>