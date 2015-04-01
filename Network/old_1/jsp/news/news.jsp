<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="/old_1/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网工－新闻</title>
<link href="/old_1/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!--主体容器container-->
<div id="container">
    <!--主头部mainHeader-->
    <div id="mainHeader">
        <jsp:include page="/old_1/jsp/include/mainHeader.jsp" flush="true"></jsp:include>
    </div>
    <!--//mainHeader-->
    <!--主信息区-->
    <div id="mainContent">
        <jsp:include page="/old_1/jsp/news/newsContent.jsp" flush="true"></jsp:include>
    </div>
    <!--//mainContent-->
    <!--尾部bottom-->
    <div id="bottom">
        <jsp:include page="/old_1/jsp/include/bottom.jsp" flush="true"></jsp:include>
    </div>
    <!--//bottom-->
</div>
<!--container-->
</body>
</html>