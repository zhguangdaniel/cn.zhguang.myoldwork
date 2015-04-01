<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/manage.css" rel="stylesheet" type="text/css" />
<!--[if lte IE 6]>
<link href="/css/contentButtonIE6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<title>网工后台管理－版本历史</title>
</head>
<body>
<%
	boolean isLog = false;
		try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
	if (!isLog) {
		session.setAttribute("isLog",new String("0"));
		session.setAttribute("loginMsg", new String("您还未登录，请先登录！"));
		response.sendRedirect("/jsp/manage/");
	}else{
%>
<!--全部区域-->
<div id="container">
  <!--头部-->
  <div id="header">
    <jsp:include page="/jsp/manage/include/header.jsp" flush="true"></jsp:include>
  </div>
  <!--主区，包括菜单区（垂直导航条）和工作区-->
  <div id="mainContent">
    <div id="leftMenu">
      <jsp:include page="/jsp/manage/include/leftMenu.jsp" flush="true"></jsp:include>
    </div>
    <div id="rightMain">
      <div class="versionHistory">
        <table align="center" width="100%" cellpadding="2" cellspacing="0" border="0">
          <tr>
            <td colspan="4" height="30px" id="bar" style="text-align:center;border:solid 0 #AAA; border-width:0 0 1px;">版本历史</td>
          </tr>
          <tr>
            <td width="5%" rowspan="2" style="border:solid 0 #AAA; border-width:0 1px 1px 0;">1</td>
            <td width="12%" style="border:solid 0 #AAA; border-width:0 1px 1px 0;">2009年9月</td>
            <td width="18%" style="border:solid 0 #AAA; border-width:0 1px 1px 0;">前台1.0版，后台1.0版</td>
            <td align="left" style="border:solid 0 #AAA; border-width:0 0 1px;">初始开发</td>
          </tr>
          <tr>
            <td align="left" colspan="3" valign="middle" style="border:solid 0 #AAA; border-width:0 0 1px;"><ul>
              </ul></td>
          </tr>
          <tr>
            <td width="5%" rowspan="2" style="border:solid 0 #AAA; border-width:0 1px 1px 0;">2</td>
            <td width="12%" style="border:solid 0 #AAA; border-width:0 1px 1px 0;">2009年9月</td>
            <td width="18%" style="border:solid 0 #AAA; border-width:0 1px 1px 0;">前台1.1版，后台1.0版</td>
            <td align="left" style="border:solid 0 #AAA; border-width:0 0 1px;">内部测试，针对测试中出现的Bug进行小规模修改</td>
          </tr>
          <tr>
            <td align="left" colspan="3" valign="middle" style="border:solid 0 #AAA; border-width:0 0 1px;"><ul>
              </ul></td>
          </tr>
          <tr>
            <td width="5%" rowspan="2" style="border:solid 0 #AAA; border-width:0 1px 1px 0;">3</td>
            <td width="12%" style="border:solid 0 #AAA; border-width:0 1px 1px 0;">2009年10月</td>
            <td width="18%" style="border:solid 0 #AAA; border-width:0 1px 1px 0;">前台1.2版，后台1.1版</td>
            <td align="left" style="border:solid 0 #AAA; border-width:0 0 1px;">试运行，针对前期运行阶段出现的问题进行修改和维护</td>
          </tr>
          <tr>
            <td align="left" colspan="3" valign="middle" style="border:solid 0 #AAA; border-width:0 0 1px;"><ul>
                <li>调整前台首页布局</li>
                <li>增加访问统计</li>
                <li>修改文件下载时出现乱码的Bug</li>
                <li>发表新闻或通知时可以上传本地图片或文件</li>
              </ul></td>
          </tr>
          <tr>
            <td width="5%" rowspan="2" style="border:solid 0 #AAA; border-width:0 1px 1px 0;">4</td>
            <td width="12%" style="border:solid 0 #AAA; border-width:0 1px 1px 0;">2010年2月</td>
            <td width="18%" style="border:solid 0 #AAA; border-width:0 1px 1px 0;">前台2.0版，后台1.2版</td>
            <td align="left" style="border:solid 0 #AAA; border-width:0 0 1px;">较大规模升级</td>
          </tr>
          <tr>
            <td align="left" colspan="3" valign="middle" style="border:solid 0 #AAA; border-width:0 0 1px;"><ul>
                <li>前台界面重新设计并对某些页面进行重写</li>
                <li>前台、后台增加搜索功能</li>
                <li>前台增加访客留言功能</li>
                <li>后台增加用户注册功能，允许多个管理员的存在</li>
                <li>后台增加用户管理和权限管理功能</li>
                <li>后台增加留言管理功能</li>
                <li>后台增加发布首页公告功能</li>
              </ul></td>
          </tr>
          <tr>
            <td width="5%" rowspan="2" style="border:solid 0 #AAA; border-width:0 1px 1px 0;">5</td>
            <td width="12%" style="border:solid 0 #AAA; border-width:0 1px 1px 0;">2010年8月</td>
            <td width="18%" style="border:solid 0 #AAA; border-width:0 1px 1px 0;">前台2.1版，后台1.3版</td>
            <td align="left" style="border:solid 0 #AAA; border-width:0 0 1px;">添加部分功能，修改一些小bug</td>
          </tr>
          <tr>
            <td align="left" colspan="3" valign="middle" style="border:solid 0 #AAA; border-width:0 0 1px;"><ul>
                <li>所有源代码改为UTF-8编码</li>
                <li>解决改变编码后文章发布和文件上传时的乱码问题</li>
                <li>增加用户验证，使得未授予权限的管理员只能修改自己发布的内容，不能修改他人的内容</li>
                <li>增加用户唯一性验证，保证Email和用户名不重复</li>
                <li>解决了验证码难以辨认的问题</li>
                <li>后台增加“版本历史”页面</li>
                <li>修改了前台“友情链接”的bug</li>
                <li>修改了邮箱地址不支持gmail点分邮箱的bug</li>
              </ul></td>
          </tr>
        </table>
      </div>
    </div>
  </div>
  <div id="bottom">
    <jsp:include page="/jsp/manage/include/bottom.jsp" flush="true"></jsp:include>
  </div>
</div>
<%	
	}
%>
</body>
</html>
