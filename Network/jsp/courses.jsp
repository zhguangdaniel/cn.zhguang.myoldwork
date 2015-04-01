<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网工－课程学习</title>
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<link href="/css/course.css" rel="stylesheet" type="text/css" />
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
      <div class="breadcrumbs"> <a href="/">首页</a> &nbsp;&gt;&nbsp;课程学习 </div>
      <div id="course" style="margin-top:5px;">
        <table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
          <tr>
            <td width="49%" id="tdTitle"><img src="/images/tdTitle.png" width="15" height="15" />&nbsp;自然科学基础课程</td>
            <td width="2%" rowspan="6">&nbsp;</td>
            <td  width="49%" id="tdTitle"><img src="/images/tdTitle.png" width="15" height="15" />&nbsp;IT平台基础课程</td>
          </tr>
          <tr>
            <td valign="top"><ul>
                <li><a href="#">数学分析</a></li>
                <li><a href="#">高等代数</a></li>
                <li><a href="#">集合论与图论</a></li>
                <li><a href="#">概率论与数理统计</a></li>
                <li><a href="#">数理逻辑</a></li>
                <li><a href="#">代数结构</a></li>
                <li><a href="#">数值计算方法</a></li>
              </ul></td>
            <td valign="top"><ul>
                <li><a href="#">程序设计I</a></li>
                <li><a href="#">数据结构与算法</a></li>
                <li><a href="#">数字电路与逻辑设计</a></li>
                <li><a href="#">信号与系统</a></li>
                <li><a href="#">电路与电子学</a></li>
              </ul></td>
          </tr>
          <tr>
            <td id="tdTitle"><img src="/images/tdTitle.png" width="15" height="15" />&nbsp;专业基础课程</td>
            <td id="tdTitle"><img src="/images/tdTitle.png" width="15" height="15" />&nbsp;专业技术课程</td>
          </tr>
          <tr>
            <td valign="top"><ul>
                <li><a href="#">程序设计II</a></li>
                <li><a href="#">计算机组成原理</a></li>
                <li><a href="#">操作系统</a></li>
                <li><a href="#">计算机网络</a></li>
                <li><a href="#">计算机接口技术及实践</a></li>
                <li><a href="#">编译原理及实践</a></li>
                <li><a href="#">软件工程导论及实践</a></li>
                <li><a href="#">数据库系统原理及实践</a></li>
                <li><a href="#">人工智能及实践</a></li>
              </ul></td>
            <td valign="top"><ul>
                <li><a href="#">通信原理</a></li>
                <li><a href="#">无线通信与网络</a></li>
                <li><a href="#">密码学与网络安全</a></li>
                <li><a href="#">计算机网络主题讲座</a></li>
                <li><a href="#">网络优化与网络管理</a></li>
                <li><a href="#">网络存储技术及实践</a></li>
                <li><a href="#">网络处理器与网络系统设计</a></li>
                <li><a href="#">网络协议分析与设计</a></li>
                <li><a href="#">Web信息检索</a></li>
                <li><a href="#">并行与分布式计算</a></li>
                <li><a href="#">电子商务</a></li>
              </ul></td>
          </tr>
          <tr>
            <td id="tdTitle"><img src="/images/tdTitle.png" width="15" height="15" />&nbsp;选修课</td>
            <td id="tdTitle"><img src="/images/tdTitle.png" width="15" height="15" />&nbsp;实践课程</td>
          </tr>
          <tr>
            <td valign="top"><ul>
                <li><a href="#">多核程序设计及实践</a></li>
                <li><a href="#">高级数据库技术及实践</a></li>
                <li><a href="#">工作流技术</a></li>
                <li><a href="#">计算机图形学</a></li>
                <li><a href="#">数字图像处理</a></li>
                <li><a href="#">模式识别</a></li>
                <li><a href="#">数据挖掘</a></li>
                <li><a href="#">虚拟现实</a></li>
                <li><a href="#">多媒体技术</a></li>
                <li><a href="#">算法设计与应用</a></li>
                <li><a href="#">智能算法及应用</a></li>
                <li><a href="#">形式语言与自动机</a></li>
                <li><a href="#">计算机体系结构</a></li>
                <li><a href="#">人机交互设计</a></li>
                <li><a href="#">嵌入式系统原理与应用</a></li>
                <li><a href="#">信息科学技术导论</a></li>
              </ul></td>
            <td valign="top"><ul>
                <li><a href="#">军事理论与技能训练</a></li>
                <li><a href="#">网络工程专业综合实践</a></li>
                <li><a href="#">数学建模训练</a></li>
                <li><a href="#">数据结构与程序设计综合实践</a></li>
                <li><a href="#">网络与操作系统综合实践</a></li>
                <li><a href="#">生产实习与社会实践</a></li>
                <li><a href="#">自主实践</a></li>
              </ul></td>
          </tr>
        </table>
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