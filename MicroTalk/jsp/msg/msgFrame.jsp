<%@ page contentType="text/html; charset=utf-8" language="java" import="msg.*,user.*,java.sql.*,java.util.ArrayList" errorPage="/jsp/error/error.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/main.js"></script>
<jsp:useBean id="msgCtrl" class="msg.MsgCtrl" scope="page"/>
<jsp:useBean id="userCtrl" class="user.UserCtrl" scope="page"/>
<div class="msgFrameTitle">
  <ul>
    <li><a id="hotMsgA" href="javascript:showMsgBlock('hotMsg');" style="background-image:url(/images/nav5.png)">热门消息</a></li>
    <li><a id="newMsgA" href="javascript:showMsgBlock('newMsg');">最新消息</a></li>
  </ul>
</div>
<div class="msgFrameContent" id="hotMsg"  style="display:block;">
  <ul>
    <%
		ArrayList<Msg> hotMsgList = msgCtrl.getTopHotMsgs(8);
        while(hotMsgList.size()!=0){
        	Msg aMsg = hotMsgList.remove(0);
			String time =  aMsg.getCreateTime().substring(0,16);
			String content = aMsg.getMsgContent();
			int userId = aMsg.getCreateUserId();
			User u = userCtrl.getUserBrief(userId);
			
        %>
    <li>
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="70px" rowspan="2" align="right"><img class="borderImg" src="<%=u.getUserIconPath()%>" width="50px" height="50px" /></td>
          <td valign="top" style="padding-left:10px;" ><span><a class="userNameInMsgFrame"><%=u.getUserName()%>：</a><%=content %></span></td>
        </tr>
        <tr>
          <td valign="bottom" class="TimeFrameInMsgFrame" ><%=time%></td>
        </tr>
      </table>
    </li>
    <%}%>
  </ul>
</div>
<div class="msgFrameContent" id="newMsg"  style="display:none;">
  <ul>
    <%
		ArrayList<Msg> newMsgList = msgCtrl.getTopNewMsgs(8);
        while(newMsgList.size()!=0){
        	Msg aMsg = newMsgList.remove(0);
			String time =  aMsg.getCreateTime().substring(0,16);
			String content = aMsg.getMsgContent();
			int userId = aMsg.getCreateUserId();
			User u = userCtrl.getUserBrief(userId);
			
        %>
    <li>
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="70px" rowspan="2" align="right"><img class="borderImg" src="<%=u.getUserIconPath()%>" width="50px" height="50px" /></td>
          <td valign="top" style="padding-left:10px;" ><span><a class="userNameInMsgFrame"><%=u.getUserName()%>：</a><%=content %></span></td>
        </tr>
        <tr>
          <td valign="bottom" class="TimeFrameInMsgFrame" ><%=time%></td>
        </tr>
      </table>
    </li>
    <%}%>
  </ul>
</div>
