<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/jsp/error/error.jsp" import="com.google.gson.Gson,java.util.List,com.qq.map.qqappointment.model.*,com.qq.map.qqappointment.dao.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%
    List<Appointment> appList = new AppointmentDAO().getTopAppointments(5);
    Gson gson = new Gson();
%>
<c:choose>
    <c:when test="${isLogin=='true'}">
    <div class="userInfo">
      <table align="center" width="100%" cellpadding="0" cellspacing="0"
			border="0">
        <tr>
          <td width="30%" rowspan="2" align="center" valign="middle"><img
					class="borderImg" src="${user.iconUrl}" width="50px" height="50px" /></td>
          <td class="blackText" align="left"><span
					style="margin-right: 10px">${user.nickName}</span><a
					href="javascript:doLogout();" class="greenLink">退出</a></td>
        </tr>
        <tr>
          <td class="blackText" align="left">当前所在位置：北京</td>
        </tr>
      </table>
      </div>
      <div class="userTabContent">
        <div class="newRequests">
          <ul>
            <li style="background-position: 0px 0px"><a href="#">1个约会需要参加</a></li>
            <li style="background-position: 0px -25px"><a href="#">5个Appointment邀请</a></li>
            <li style="background-position: 0px -50px"><a href="#">3个新回复</a></li>
          </ul>
        </div>
        <div class="sideItem">
          <div class="titleBar">我的标签</div>
          <%
          User u = (User)session.getAttribute("user");
          String[] keywords=u.getKeyWords().split(" ");
          %>
          <c:forEach var="keyword"  items="<%=keywords %>"><span><a href="">${keyword}</a></span></c:forEach></div>
        <div class="sideItem">
          <div class="titleBar">你可能会感兴趣</div>
          <ul>
          <c:forEach var="app" items="<%=appList%>">
            <li>
              <div class="appPic"><a href=""><img
                src="${app.iconUrl}" width="50px" height="50px" /></a></div>
              <div class="appInfo"><a class="appTitle">${app.title}</a><br />
                <span class="appTimeAddr">${app.startTime}</span></div>
            </li>
            </c:forEach>
          </ul>
        </div>
      </div>
    </c:when>
    <c:otherwise>
      <div class="userInfo">
      <div style="margin-bottom: 5px;"><span class="blackText">当前所在位置：北京</span></div>
      <div><a id="loginBtn" class="button" onclick="openLoginDiv()">登录</a><a
			id="regLink" class="greenLink" onclick="openRegisterDiv()">立即注册</a></div>
	</div>
	  <div class="userTabContent">
        <div class="sideItem">
          <div class="titleBar">随便看看</div>
          <ul>
          <c:forEach var="app" items="<%=appList%>">
            <li>
              <div class="appPic"><a href=""><img
                src="${app.iconUrl}" width="50px" height="50px" /></a></div>
              <div class="appInfo"><a class="appTitle">${app.title}</a><br />
                <span class="appTimeAddr">${app.startTime}</span></div>
            </li>
            </c:forEach>
          </ul>
        </div>
      </div>
    </c:otherwise>
  </c:choose>
<script type="text/javascript">
function showLoginDialog(){
    var dialog = new ModalDialog({
        width: 300,
        height: 150,
        //x: 100,
        //y: 100,
        title: '用户登录',
        content: "<div id='loginContent'></div>"
    });
    dialog.showDialog();
}

function showRegisterDialog(){
    var dialog = new ModalDialog({
        width: 500,
        height: 400,
        //x: 100,
        //y: 100,
        title: '用户注册',
        content: "<div id='registerContent'></div>"
    });
    dialog.showDialog();
}

function openLoginDiv(){
    showLoginDialog();
    load('loginContent','/jsp/content/login.jsp');
}

function openRegisterDiv(){
    showRegisterDialog();
    load('registerContent','/jsp/content/register.jsp');
}
function doLogout(){
    $J.post("/doLogout", function(data) {
        if (typeof(data.error) != 'undefined' && data.error != '') {
            alert(data.error);
        }
        else {
            load('controlTab','/jsp/tabs/userTab.jsp');
        }},
    "json");
}
</script>
