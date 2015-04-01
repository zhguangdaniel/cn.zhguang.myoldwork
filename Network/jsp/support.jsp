<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网工－技术支持</title>
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
      <div class="breadcrumbs"> <a href="/">首页</a> &nbsp;&gt;&nbsp;技术支持 </div>
      <table width="100%" cellpadding="0" cellspacing="0" border="0" id="blackText">
        <tr>
          <td width="20%" height="10px;"></td>
          <td width="80%" align="left" ></td>
        </tr>
        <tr>
          <td height="30px;" colspan="2" align="left" style="padding-left:20px;">在您的使用过程中出现任何问题，或者您对本网站有任何意见或建议，请您与网站技术支持人员联系，技术支持人员的信息如下：</td>
        </tr>
        <tr>
          <td height="30px;" align="right" style="padding-right:20px;">技术支持</td>
          <td align="left" >张广</td>
        </tr>
        <tr>
          <td height="30px;" align="right" style="padding-right:20px;">负责内容</td>
          <td align="left">本网站开发、维护、升级</td>
        </tr>
        <tr>
          <td height="30px;" align="right" style="padding-right:20px;">联系方式</td>
          <td align="left">zhguang_sysu@163.com / QQ:544321856</td>
        </tr>
        <tr>
          <td height="10px;"></td>
          <td align="left" ></td>
        </tr>
        <tr>
          <td height="30px;" colspan="2" align="left" style="padding-left:20px;">如果您是对本网站所发布的内容（新闻、通知、文件下载）等存在疑问，请到<a href="/jsp/message/message.jsp?page=1">留言板</a>提问，本站管理员会回答您的问题。</td>
        </tr>
      </table>
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