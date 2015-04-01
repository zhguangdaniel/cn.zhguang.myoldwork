<%@ page contentType="text/html; charset=utf-8" language="java" import="news.*,java.lang.Integer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网工－新闻中心</title>
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<link href="/css/news.css" rel="stylesheet" type="text/css" />
<jsp:useBean id="newsBean" class="news.NewsBean" scope="page"/>
<jsp:useBean id="pageCtrl" class="page.PageBean" scope="page"/>
</head>
<body>
<%
int curPage = Integer.parseInt(request.getParameter("page"));
pageCtrl=newsBean.getPage(curPage,20);
%>
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
      <div class="breadcrumbs"> <a href="/">首页</a> &nbsp;&gt;&nbsp;新闻中心 </div>
      <table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
        <%
        while(pageCtrl.resultList.size()!=0){
        	SingleNews aNews = (SingleNews)pageCtrl.resultList.remove(0);
			String title = aNews.getTitle();
			String time= aNews.getCreateTime().substring(0,16);
        %>
        <tr>
          <td width="10%" height="30px" align="right"><img src="/images/sectionArrow.gif" width="12" height="12" /></td>
          <td width="60%" height="30px" align="left"><a href="/jsp/news/news.jsp?id=<%=aNews.getId()%>" target="_blank" class="text"><%=title%></a></td>
          <td width="20%"><span class="dateText">[<%=time%>]</span></td>
          <td width="10%"></td>
        </tr>
        <%}%>
        <tr>
          <td height="10px" colspan="4"></td>
        </tr>
      </table>
      <div class="pageCtrlFrame">
        <%out.print(pageCtrl.printCtrl());%>
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