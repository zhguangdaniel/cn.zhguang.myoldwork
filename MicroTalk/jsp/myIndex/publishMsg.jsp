<%@ page contentType="text/html; charset=utf-8" language="java" import="msg.*,user.*,java.sql.*,java.util.ArrayList" errorPage="/jsp/error/error.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/msg.js"></script>
<jsp:useBean id="msgCtrl" class="msg.MsgCtrl" scope="page"/>
<jsp:useBean id="userCtrl" class="user.UserCtrl" scope="page"/>
 <%
	String errMsg = null;
	try {
		errMsg = (String) session.getAttribute("errMsg");
	} catch (Exception e) {
	}

%>
<div style="height:65px; width:100%; background-image:url(/images/postbg.png)"></div>
<div style="text-align:right; width:90%; margin:auto;">
<form name="form_msg" method="post" target="_self" action="/jsp/msg/saveMsg.jsp?isComment=0">
  <textarea id="msgContent" name="msgContent" style=" width:100%; height:120px; margin-bottom:10px; font-family: Arial, '宋体'; font-size:13px;"></textarea>
  <br />
  <div class="loginErrMsgFrame" id = "msgErrInfo"></div>
   <input type="submit" onclick="return checkMsg()" class="postBtn" value=""/>
</form>
</div>
<script language="javascript">
<!--
document.getElementById("msgErrInfo").innerHTML=<%=("'"+errMsg+"'")%>;
//-->
</script>
<%
errMsg = "";
session.setAttribute("errMsg",new String(""));
%>
<div class="bar" style=" font-size:16px;border-bottom:solid 1px #999999">我的消息</div>
<div class="msgFrameContent"  style="display:block;">
  <ul>
    <%
		ArrayList<Msg> newMsgList = msgCtrl.getTopNewMsgsOfUser(10,(Integer)session.getAttribute("userId"));
        while(newMsgList.size()!=0){
        	Msg aMsg = newMsgList.remove(0);
        	int id = (Integer)session.getAttribute("userId");
			String time =  aMsg.getCreateTime().substring(0,16);
			String content = aMsg.getMsgContent();
			String userIconPath = (String)session.getAttribute("userIconPath");
			String userName = (String)session.getAttribute("userName");
			
        %>
    <li>
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="70px" rowspan="2" align="right"><img class="borderImg" src="<%=userIconPath%>" width="50px" height="50px" /></td>
          <td valign="top" style="padding-left:10px;" ><span><a class="userNameInMsgFrame"><%=userName%>：</a><%=content %></span></td>
        </tr>
        <tr>
          <td valign="bottom" class="TimeFrameInMsgFrame" ><%=time%></td>
        </tr>
      </table>
    </li>
    <%}%>
  </ul>
</div>