<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="/old_1/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>中山大学网络工程专业－首页</title>
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
            <!--左信息区-->
        <div id="leftMain">
        <div id="firstLineContentFrame">
            <div id="newsFrame">
                <jsp:include page="/old_1/jsp/news/newsFrame.jsp" flush="true"></jsp:include>
            </div>
            <div id="flashAblumFrame">
                <jsp:include page="/old_1/jsp/include/flashAblum.jsp" flush="true"></jsp:include>
            </div>
         </div>

            <div id="infoFrame">
                <jsp:include page="/old_1/jsp/info/infoFrame.jsp" flush="true"></jsp:include>
            </div>
            <div id="filesFrame">
                <jsp:include page="/old_1/jsp/files/filesFrame.jsp" flush="true"></jsp:include>
            </div>
        </div>
        <!--//leftMain-->
        <!--右信息区-->
        <div id="rightMain">
            <div id="courseFrame">
            	<jsp:include page="/old_1/jsp/course/courseFrame.jsp" flush="true"></jsp:include>
            </div>
            <div id="customLinksFrame">
                <jsp:include page="/old_1/jsp/include/customLinks.jsp" flush="true"></jsp:include>
            </div>
            <div id="friendlyLinksFrame">
                <jsp:include page="/old_1/jsp/include/friendlyLinks.jsp" flush="true"></jsp:include>
            </div>
            <div id="statFrame">
                <jsp:include page="/old_1/jsp/include/siteStat.jsp" flush="true"></jsp:include>
            </div>
        </div>
        <!--//rightMain-->
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