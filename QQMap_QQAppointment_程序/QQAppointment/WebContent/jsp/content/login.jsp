<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage="/jsp/error/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="form_login" method="post">
<table align="center" width="100%" cellpadding="0" cellspacing="0"
	border="0">
	<tr>
		<td width="28%" height="30px" align="right" id="blackText">用户名</td>
		<td width="2%"></td>
		<td width="70%" align="left" height="30px"><input type="text"
			name="username" id="username" style="width: 150px" /></td>
	</tr>
	<tr>
		<td height="30px" align="right" id="blackText">密码</td>
		<td></td>
		<td height="30px" align="left"><input type="password"
			name="password" id="password" style="width: 150px" /></td>
	</tr>
	<tr>
		<td colspan="3" height="20px">
		<div class="errorText" id="loginMsg" style="text-align: center;"></div>
		</td>
	</tr>
	<tr>
		<td colspan="3" align="center" valign="top"><input type="submit"
			value="登录" class="button" onclick="return doLogin()" /></td>
	</tr>
</table>
</form>
<script type="text/javascript">
function doLogin(){
	if(checkLogin()){
		$J.post("/doLogin", $J("#form_login").serialize(),function(data) {
            if (typeof(data.msg) != 'undefined' && data.msg == 'success') {
            	//关闭登录框
            	closeModalDialog();
            	load('controlTab','/jsp/tabs/userTab.jsp');
            }
            else {
            	$J("#loginMsg").html(data.msg?data.msg:data.error);
            }
			
		},"json");
	}
	return false;
}
</script>