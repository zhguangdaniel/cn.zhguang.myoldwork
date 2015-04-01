<%@ page contentType="text/html; charset=utf-8" language="java"
	import="message.*,java.sql.*,java.util.ArrayList"
	errorPage="/jsp/error/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网工－留言版</title>
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<link href="/css/message.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/msgManage.js"></script>
<jsp:useBean id="msgBean" class="message.MsgBean" scope="page" />
<jsp:useBean id="pageCtrl" class="page.PageBean" scope="page"/>
</head>
<body>
<%
String errMsg = null;
String oldCreator = null;
String oldMsgContent = null;
try {
	errMsg = (String) session.getAttribute("errMsg");
} catch (Exception e) {
}
if (errMsg == null) {
	errMsg = "";
}
try {
	oldCreator = (String) session.getAttribute("creator");
} catch (Exception e) {
}
if (oldCreator== null) {
	oldCreator = "";
}
try {
	oldMsgContent = (String) session.getAttribute("msgContent");
} catch (Exception e) {
}
if (oldMsgContent == null) {
	oldMsgContent = "";
}
%>
<!--头部header-->
<div class="header">
  <jsp:include page="/jsp/include/header.jsp"
	flush="true"></jsp:include>
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
        <jsp:include
	page="/jsp/include/leftMenu.jsp" flush="true"></jsp:include>
      </div>
      <!--//leftMenuFrame-->
      <div class="imgLinksFrame">
        <jsp:include
	page="/jsp/include/imgLinks.jsp" flush="true"></jsp:include>
      </div>
      <div class="customLinksFrame">
        <jsp:include
	page="/jsp/include/customLinks.jsp" flush="true"></jsp:include>
      </div>
    </div>
    <!--右边内容框rightContentFrame-->
    <div class="rightContentFrame">
      <div class="breadcrumbs"><a href="/">首页</a> &nbsp;&gt;&nbsp;留言板&nbsp;&nbsp;&nbsp;&nbsp;<img src="/images/message.png" /><a href="#publishMsg">发表留言</a></div>
      <%
      int curPage = Integer.parseInt(request.getParameter("page"));
      pageCtrl=msgBean.getPage(curPage,10);
      int floor = (curPage-1)*10;//记录是多少楼
      int totalMsg = msgBean.getTotalMsgsCount();
	  while(pageCtrl.resultList.size()!=0){
        	Message msg = (Message)pageCtrl.resultList.remove(0);
			String msgContent = msg.getMessage();
			String time= msg.getCreateTime().substring(0,16);
      %>
      <div class="msgFrame">
        <div class="msgInfo"> <font color="#505050"><%=(totalMsg - floor++)%>楼</font>&nbsp;&nbsp;<font color="#505050"><%=msg.getCreator() %></font>&nbsp;&nbsp;<font color="#999999"><%=time%></font></div>
        <div class="msgText"><%=msgContent %></div>
        <%
      int id = msg.getId();
      ArrayList<Message> replyList = msgBean.getReplyMsgs(id);
      while(replyList.size()!=0){
      	Message r = replyList.remove(0);
    	  %>
        <div class="replyInfo"><font color="#006699" style="font-weight:bold;">管理员 <%=r.getCreator() %> 回复:</font>&nbsp;&nbsp;<font color="#999999"><%=r.getCreateTime().substring(0,16)%></font></div>
        <div class="replyText"><%= r.getMessage()%></div>
        <%} %>
      </div>
      <%}%>
      <div class="pageCtrlFrame">
        <%out.print(pageCtrl.printCtrl());%>
      </div>
      <a name="publishMsg" id="publishMsg"></a>
      <div class="bar">发表留言</div>
      <form name="form_message" method="post" target="_self" action="/jsp/message/saveMsg.jsp?isReply=0">
        <table width="100%" border="0" cellpadding="0" cellspacing="5" class="editMsgFrame">
          <tr>
            <td width="13%" align="right">姓名：</td>
            <td colspan="2"><input name="creator" id="creator" type="text" style="width:120px; height:20px;"/>
              留空则匿名发表</td>
          </tr>
          <tr>
            <td valign="top"align="right">内容：</td>
            <td colspan="2"><textarea id="msgContent" name="msgContent" style="width: 90%; height:150px; font-family: Arial, '宋体'; font-size:13px;"></textarea></td>
          </tr>
           <tr>
            <td align="right">验证码：</td>
            <td width="15%"><input   type="text" size="10" id="vcode" name="vcode"/></td>
            <td valign="top"><img id="vcodeImg" src="/jsp/vcode/image.jsp" onclick="javascript:reloadVCode();" style="border:none; width:60px; height:20px; margin-top:3px;"/> &nbsp;&nbsp;&nbsp;<a href="javascript:reloadVCode();" style="font-family: Arial, '宋体';font-size:12px;color:#006699;">看不清楚？换张图片！</a></td>
          </tr>
          <tr>
            <td></td>
            <td width="15%"><input type="submit" name="publish" value="提交" onclick="return checkPublishMsg()" />
              <input type="reset" name="reset" value="重置" onclick="clearMsgInfo()" /></td>
            <td><span id = "errMsg" name = "errMsg" class="errMsgFrame"></span></td>
          </tr>
        </table>
      </form>
    </div>
    <!--//rightContentFrame-->
  </div>
  <!--content-->
</div>
<!--container-->
<!--底部bottom-->
<div class="footer">
  <jsp:include page="/jsp/include/footer.jsp"
	flush="true"></jsp:include>
</div>
<!--//bottom-->

<script language="javascript">
<!--
	document.getElementById("errMsg").innerHTML="<font color='#FF0000' size='-1' face='Arial, 宋体'>"+<%=("\""+errMsg+"\"")%>+"</font>";
	document.getElementById("creator").value=<%=("\""+oldCreator +"\"")%>;
	document.getElementById("msgContent").value=<%=("\""+oldMsgContent+"\"")%>;
//-->
</script>
<%	
	errMsg = "";
	session.setAttribute("errMsg",new String(""));
%>
</body>
</html>
