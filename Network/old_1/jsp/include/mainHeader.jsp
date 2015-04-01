<%@ page contentType="text/html; charset=utf-8" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/old_1/css/style.css" rel="stylesheet" type="text/css" />
<link href="/old_1/css/menu.css" rel="stylesheet" type="text/css" />
<!--[if lte IE 6]>
<link href="/old_1/css/menuIE6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<!--头部，含顶部菜单和Banner条-->
<div id="header">
    <!--顶部菜单-->
    <div id="topMenu">
        <table width="120" border="0" align="right">
            <tr>
                <td width="60px" style="text-align:right;"><a href="mailto:zhguang_sysu@163.com" class="topMenu">联系我们</a></td>
                <td width="60px" style="text-align:right;"><a href="/jsp/manage/" class="topMenu">后台管理</a></td>
            </tr>
        </table>
    </div>
    <!--//顶部菜单-->
    <!--Banner条-->
    <div id="banner"> <img src="/old_1/images/banner.jpg" width="780" height="110" /></div>
</div>
<!--头部header-->
<!--导航条-->
<div id="nav">
    <table width="780px" border="0"  height="30px" cellpadding="0" cellspacing="0">
        <!-- cellpadding="7" cellspacing="0"-->
        <tr style="text-align: center;">
            <td ><a href="/old_1/index.jsp" class="nav" target="_self">首页</a></td>
            <td style="font-size:15px">|</td>
            <td><a href="/old_1/jsp/introduce.jsp" class="nav" target="_self">专业概况</a></td>
            <td style="font-size:15px">|</td>
            <td ><a href="/old_1/jsp/blueprint/blueprint1.jsp" class="nav" target="_self">教学方案</a></td>
            <td style="font-size:15px">|</td>
            <td><div class="menu">
                    <ul>
                        <li><a class="hide" href="#">新闻通知</a>
                            <!--[if lte IE 6]>
                            <a href="#">新闻通知
                            <table cellpadding="0" cellspacing="0" border="0" style=" float:right;"><tr><td>
                            <![endif]-->
                            <ul>
                                <li><a href="/old_1/jsp/news/newsList.jsp?page=1" target="_self">新闻中心</a></li>
                                <li style="border-width:0 0 0;"><a href="/old_1/jsp/info/infoList.jsp?page=1" target="_self">通知信息</a></li>
                            </ul>
                            <!--[if lte IE 6]>
                            </td></tr></table>
                            </a>
                            <![endif]-->
                        </li>
                    </ul>
                </div></td>
            <td style="font-size:15px">|</td>
            <td><a href="/old_1/jsp/course/courses.jsp" class="nav" target="_self">课程学习</a></td>
            <td style="font-size:15px">|</td>
            <td><div class="menu">
                    <ul>
                        <li><a href="#" class="hide">创新活动</a>
                            <!--[if lte IE 6]>
                            <a href="#">创新活动
                            <table cellpadding="0" cellspacing="0" border="0" style="float:right;"><tr><td>
                            <![endif]-->
                            <ul>
                                <li><a href="/old_1/jsp/networkActivity/networkActivity.jsp" target="_self">活动介绍</a></li><li>
                                <a href="/old_1/jsp/networkActivity/networkActivity.jsp" target="_self">活动规则</a></li><li>
                                <a href="/old_1/jsp/networkActivity/networkActivity.jsp" target="_self">活动内容</a></li><li>
                                <a href="/old_1/jsp/networkActivity/networkActivity.jsp" target="_self">活动资料</a></li><li
                                 style="border-width:0 0 0;"><a href="/old_1/jsp/networkActivity/networkActivity.jsp" target="_self">表格下载</a></li>
                            </ul>
                            <!--[if lte IE 6]>
                            </td></tr></table>
                            </a>
                            <![endif]-->
                        </li>
                    </ul>
                </div></td>
            <td style="font-size:15px">|</td>
            <td><a href="/old_1/jsp/files/files.jsp?page=1" class="nav" target="_self">文件下载</a></td>
        </tr>
    </table>
</div>
<!--//导航条nav-->
