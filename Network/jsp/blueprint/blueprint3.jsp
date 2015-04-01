<%@ page contentType="text/html; charset=utf-8"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网工－核心知识模块与课程路线图</title>
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<link href="/css/blueprint.css" rel="stylesheet" type="text/css" />
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
      <div class="breadcrumbs"> <a href="/">首页</a> &nbsp;&gt;&nbsp;教学路线图</div>
      <div id = "blueprintFrame">
        <h1>网络工程专业核心知识模块及课程路线图 </h1>
        <p style="font-family: '楷体_GB2312'; font-size: 14px; text-align: center; color: #F60;">（2009年4月）</p>
        <h2>一、图例说明</h2>
        <p>实线框是必修课程，虚线框是选修课程，带颜色框是课程群内的课程，无颜色框是相关的课程。带箭头的实线表示必需有的先修课程，带箭头的虚线表示一般有但非必需有的先修课程（只需要补充少量相关知识）。</p>
        <h2>二、数理基础课程</h2>
        <ol>
          <li>数学物理及相关课程</li>
          <img src="/images/blueprint/2.1.JPG" width="490" height="184" />
          <p>&nbsp; </p>
          <li>离散结构及相关课程</li>
          <img src="/images/blueprint/2.2.JPG" width="408" height="181" />
        </ol>
        <h2>三、硬件与网络课程</h2>
        <ol>
          <li>电路与计算机组成相关课程</li>
          <img src="/images/blueprint/3.1.JPG" width="581" height="200" />
          <p>&nbsp; </p>
          <li>网络与通信相关课程</li>
          <img src="/images/blueprint/3.2.JPG" width="442" height="410" />
        </ol>
        <h2>四、软件课程</h2>
        <ol>
          <li>程序设计语言与数据管理相关课程</li>
          <img src="/images/blueprint/4.1.JPG" width="603" height="276" />
          <p>&nbsp; </p>
          <li>人工智能相关课程</li>
          <img src="/images/blueprint/4.2.JPG" width="556" height="236" />
          <p>&nbsp; </p>
          <li>图形与图像类课程</li>
          <img src="/images/blueprint/4.3.JPG" width="432" height="211" />
        </ol>
        <h2>五、实践课程 </h2>
        <ol>
          <img src="/images/blueprint/5.JPG" width="554" height="263" />
        </ol>
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
</body>
</html>