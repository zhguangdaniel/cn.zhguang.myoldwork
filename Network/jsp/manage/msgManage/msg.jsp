<%@ page contentType="text/html; charset=utf-8" language="java" import="message.*,java.sql.*,java.util.ArrayList,user.*" errorPage="/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/manage.css" rel="stylesheet" type="text/css" />
<link href="/css/manageContent.css" rel="stylesheet" type="text/css" />
<link href="/css/message.css" rel="stylesheet" type="text/css" />
<!--[if lte IE 6]>
<link href="/css/contentButtonIE6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<jsp:useBean id="msgBean" class="message.MsgBean" scope="page"/>
<jsp:useBean id="pageCtrl" class="page.PageBean" scope="page"/>
<script type="text/javascript" src="/js/manage.js"></script>
<script type="text/javascript" src="/js/msgManage.js"></script>
<title>网工后台管理－留言管理</title>
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
        <div style="float:left;">&nbsp;&nbsp;所有留言：</div>
      </div>
      <%
      int curPage = Integer.parseInt(request.getParameter("page"));
      pageCtrl=msgBean.getPage(curPage,10);
      int floor = (curPage-1)*10;//记录是多少楼
      int totalMsg = msgBean.getTotalMsgsCount();
	  while(pageCtrl.resultList.size()!=0){
        	Message msg = (Message)pageCtrl.resultList.remove(0);
			String msgContent = msg.getMessage();
			String time= msg.getCreateTime().substring(0,16);
			int id = msg.getId();
			String replyFrameID="replyFrame"+id;
			String msgID = "msg"+id;
			ArrayList<Message> replyList = msgBean.getReplyMsgs(id);
      %>
      <div class="msgFrame">
        <div class="msgInfo"> <font color="#505050"><%=(totalMsg - floor++)%>楼</font><%if(replyList.size()==0){ %>&nbsp;&nbsp;<font color="#FF0000">(未回复)</font><%} %>&nbsp;&nbsp;<font color="#505050"><%=msg.getCreator() %></font>&nbsp;&nbsp;<font color="#999999"><%=time%></font><%if(User.checkHaveAuthority(auth,User.replyMsg)){ %>&nbsp;&nbsp;&nbsp;&nbsp;<img src="/images/reply.png" width="12" height="12" /><a href="javascript:showHide(<%=("\'"+replyFrameID+"\'")%>);" class="normalLink" >回复</a><%};if(User.checkHaveAuthority(auth,User.delMsg)){ %>&nbsp;&nbsp;<img src="/images/Delete.png" width="12" height="12" /><a href="/jsp/manage/msgManage/delMsg.jsp?curPage=<%=curPage%>&id=<%=id%>&type=<%=0%>" target="_self" class="normalLink" onclick="return onDelete()">删除</a><%} %></div>
        <div class="msgText"><%=msgContent %></div>
        <%
      while(replyList.size()!=0){
      	Message r = replyList.remove(0);
    	  %>
        <div class="replyInfo"><font color="#006699" style="font-weight:bold;">管理员 <%=r.getCreator() %> 回复:</font>&nbsp;&nbsp;<font color="#999999"><%=r.getCreateTime().substring(0,16)%></font><%if(User.checkHaveAuthority(auth,User.delMsgReply)||curUser.equals(r.getCreator())){ %>&nbsp;&nbsp;<img src="/images/Delete.png" width="12" height="12" /><a href="/jsp/manage/msgManage/delMsg.jsp?curPage=<%=curPage%>&id=<%=r.getId()%>&type=<%=1%>" target="_self" class="normalLink" onclick="return onDelete()">删除此回复</a><%} %></div>
        <div class="replyText"><%= r.getMessage()%></div>
        <%};if(User.checkHaveAuthority(auth,User.replyMsg)){ %>
        <div class="replyFrame" id="<%=replyFrameID%>">
          <form name="form_reply" method="post" action="/jsp/message/saveMsg.jsp?isReply=1&id=<%=id %>&curPage=<%=curPage %>">
            <table border="0" cellpadding="0" cellspacing="5">
              <tr>
                <td width="80px" height="10px"></td>
                <td width="480px"></td>
                <td></td>
              </tr>
              <tr>
                <td valign="top"align="right">回复内容：</td>
                <td ><textarea name="<%=msgID%>" id="<%=msgID%>" style="width:480px;height:120px; font-family: Arial, '宋体'; font-size:13px;"></textarea></td>
                <td></td>
              </tr>
              <tr>
                <td></td>
                <td><input name="saveReply" type="submit" value="回复" onclick="return checkReplyLength(<%="\'"+msgID+"\'"%>)" />
                  <input type="reset" name="reset" value="重置" /></td>
                <td></td>
              </tr>
            </table>
          </form>
        </div>
        <%} %>
      </div>
      <%}%>
      <div class="pageCtrlFrame">
        <%out.print(pageCtrl.printCtrl());%>
      </div>
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
