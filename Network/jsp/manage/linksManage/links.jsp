<%@ page contentType="text/html; charset=utf-8" language="java" import="customLinks.*,java.sql.*,java.util.ArrayList,user.*" errorPage="/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/manage.css" rel="stylesheet" type="text/css" />
<link href="/css/manageContent.css" rel="stylesheet" type="text/css" />
<!--[if lte IE 6]>
<link href="/css/contentButtonIE6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<jsp:useBean id="links" class="customLinks.LinksBean" scope="page"/>
<script type="text/javascript" src="/js/manage.js"></script>
<script type="text/javascript" src="/js/linksManage.js"></script>
<title>网工后台管理－自定义链接管理</title>
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
		String auth = (String) session.getAttribute("userAuthority");
		String curUser = (String) session.getAttribute("userName");
		ArrayList<Link> linksList = links.getAllLinks();
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
      <div id="contentHeader">
        <div style="float:left;">&nbsp;&nbsp;所有链接：（注意：在前台首页只会显示下面链接的前5条，5条之后的链接不会显示，请自行删除）</div>
        <%if(User.checkHaveAuthority(auth,User.addLink)){ %>
        <div id="tempContentHeader">
          <div id="contentButton">
            <ul>
              <li><a href="javascript:showHide('addLink');" target="_self"><img src="/images/linksManage.png" width="15" height="15" />&nbsp;&nbsp;添加链接</a></li>
            </ul>
          </div>
        </div>
        <%} %>
      </div>
      <table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tr>
          <td width="20px"></td>
          <td width="110px" align="left"></td>
          <td align="right"></td>
          <td width="90px" align="right"></td>
          <td width="20px"></td>
        </tr>
        <tr>
          <td></td>
          <td colspan="3"><div class="addLinkFrame" id="addLink">
              <form id="form_linksEdit" action="/jsp/manage/linksManage/saveLink.jsp?isModify=0" method="post">
                <span style="color:#069; font-size:14px;">添加新的自定义链接：</span><br />
                新链接名称：
                <input type="text" name="lText0" id="lText0" style=" width:480px; margin-bottom:5px; margin-top:10px;"/>
                <br />
                新链接地址：
                <input type="text" name="lLink0" id="lLink0" style=" width:480px; margin-bottom:10px;"/>
                <br />
                <input name="saveLink" type="submit" value="保存" onclick="return check('lText0','lLink0')" style="margin-left:230px;" />
                <input type="reset" name="reset" value="重置" />
              </form>
            </div></td>
          <td></td>
        </tr>
        <%
                int i=0;//用来记录当前显示的是第几条链接
	        while(linksList.size()!=0){
				Link l = linksList.remove(0);
				String text = l.getText();
				String aText = text;
				String link = l.getLink();
				String creator = l.getCreator();
				int id = l.getId();
				String linkEditID="linkEditFrame"+id;
				String textID = "text"+id;
				String linkID = "link"+id;
				if(text.length()>31){
					aText=text.substring(0,30)+"...";
				}
				i++;
			%>
        <tr>
          <td height="30px"></td>
          <td height="30px" align="left" colspan="2" style="border-bottom: dashed 1px #AAA;"><img src="/images/news.png" width="14" height="14" /><span style="color:#1B25F3; font-family:Arial, '宋体'; font-size:12px;"><%=i%>，</span><a href="<%=link%>" target="_blank" class="customLink" title=<%=text%>><%=aText%>&nbsp;&nbsp;&nbsp;</a><%if(User.checkHaveAuthority(auth,User.editLink)||curUser.equals(creator)){ %> &nbsp;&nbsp;&nbsp;<img src="/images/Edit.png" width="12" height="12" /><a href="javascript:showHide(<%=("\'"+linkEditID+"\'")%>);" class="normalLink" >修改</a><%};if(User.checkHaveAuthority(auth,User.delLink)||curUser.equals(creator)){ %>&nbsp;&nbsp;&nbsp;<img src="/images/Delete.png" width="12" height="12" /><a href="/jsp/manage/linksManage/delLink.jsp?id=<%=id%>" target="_self" class="normalLink" onclick="return onDelete()" >删除</a><%} %></td>
          <td align="right" style="border-bottom:dashed 1px #AAA;"><span id="date">[<%=l.getCreateTime().substring(0, 10)%>]</span></td>
          <td></td>
        </tr>
        <tr>
          <td ></td>
          <td align="right" valign="top" style="font-family:Arial, '宋体'; font-size:12px; color: #999; line-height:20px;">当前链接地址：&nbsp;&nbsp;</td>
          <td valign="top" id="summary" ><%=link%></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td></td>
          <td colspan="3"><div class="linksEditFrame" id="<%=linkEditID%>">
              <form id="form_linksEdit" action="/jsp/manage/linksManage/saveLink.jsp?isModify=1&id=<%=id %>" method="post">
                修改链接名称：&nbsp;&nbsp;
                <input type="text" name="<%=textID%>" id="<%=textID%>" style=" width:480px; margin-bottom:5px;" value="<%=text%>"/>
                <br />
                修改链接地址：&nbsp;&nbsp;
                <input type="text" name="<%=linkID%>" id="<%=linkID%>" style=" width:480px; margin-right:10px;" value="<%=link%>"/>
                <input name="saveLink" type="submit" value="保存" onclick="return check(<%="\'"+textID+"\'"%>,<%=("\'"+linkID+"\'")%>)" />
                <input type="reset" name="reset" value="重置" />
              </form>
            </div></td>
          <td></td>
        </tr>
        <%} //while%>
        <tr>
          <td height="10px" colspan="5"></td>
        </tr>
      </table>
    </div>
  </div>
  <div id="bottom">
    <jsp:include page="/jsp/manage/include/bottom.jsp" flush="true"></jsp:include>
  </div>
</div>
<%	
	}//else
%>
</body>
</html>
