<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage="/jsp/error/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="regDiv">
<div class="regTopTipsDiv">欢迎注册，请填写以下内容，打 * 的是必填项：</div>
<form id="form_reg" method="post" action="/doRegist"
	enctype="multipart/form-data">
<table width="100%" align="center" cellpadding="0" cellspacing="0"
	border="0">
	<tr>
		<td width="80px" height="35px" align="right">用户名：</td>
		<td width="15px"></td>
		<td width="140px" align="left"><input type="text" name="userName"
			id="userName" style="width: 120px;"
			onfocus="onRegFocus(this.id,'userName_tips')"
			onblur="onRegBlur(id,'userName_tips')" /> *</td>
		<td align="left"><span id="userName_tips"></span></td>
	</tr>
	<tr>
		<td height="35px" align="right">昵称：</td>
		<td></td>
		<td align="left"><input type="text" name="nickName" id="nickName"
			style="width: 120px;" onfocus="onRegFocus(this.id,'nickName_tips')"
			onblur="onRegBlur(id,'nickName_tips')" /></td>
		<td align="left"><span id="nickName_tips"></span></td>
	</tr>
	<tr>
		<td height="35px" align="right">密码：</td>
		<td></td>
		<td align="left"><input type="password" name="password"
			id="password" style="width: 120px;"
			onfocus="onRegFocus(this.id,'password_tips')"
			onblur="onRegBlur(id,'password_tips')" /> *</td>
		<td align="left"><span id="password_tips"></span></td>
	</tr>
	<tr>
		<td height="35px" align="right">确认密码：</td>
		<td></td>
		<td align="left"><input type="password" name="password2"
			id="password2" style="width: 120px;"
			onfocus="onRegFocus(this.id,'password2_tips')"
			onblur="onRegBlur(id,'password2_tips')" /> *</td>
		<td align="left"><span id="password2_tips"></span></td>
	</tr>
	<tr>
		<td height="35px" align="right">上传头像：</td>
		<td></td>
		<td align="left" colspan="2"><input type="file" name="userIcon"
			id="userIcon" size="16" onchange="return checkUploadUserIcon();"
			style="vertical-align: middle;" /> <img id="loading"
			style="vertical-align: middle; display: none"
			src="/image/loading.gif" /><input type="text" id="userIconUrl"
			name="userIconUrl" value=""
			style="vertical-align: middle; display: none" /></td>
	</tr>
	<tr>
		<td height="35px" align="right" valign="top">我的标签：</td>
		<td></td>
		<td align="left"><textarea id="userKeyWords" name="userKeyWords"
			style="height: 50px; width: 120px;"
			onfocus="onRegFocus(this.id,'userKeyWords_tips')"
			onblur="onRegBlur(id,'userKeyWords_tips')"></textarea></td>
		<td align="left"><span id="userKeyWords_tips"></span></td>
	</tr>
	<tr>
		<td height="35px" align="right">验证码：</td>
		<td></td>
		<td align="left">
		<div style="height: auto; width: auto; text-align: left; float: left;">
		<input type="text" name="vcode" id="vcode" style="width: 50px;"
			onfocus="onRegFocus(this.id,'vcode_tips')"
			onblur="onRegBlur(id,'vcode_tips')" /> *&nbsp;&nbsp;&nbsp;</div>
		<img id="vcodeImg" onclick="javascript:reloadVCode();"
			style="border: none; width: 60px; height: 20px;" /></td>
		<td align="left"><a href="javascript:reloadVCode();"
			style="font-family: Arial, '宋体'; font-size: 12px; color: #006699;">看不清楚？换张图片！</a>
		<div><span id="vcode_tips"></span></div>
		</td>
	</tr>
	<tr>
		<td height="20px">&nbsp;</td>
		<td height="20px" align="left" colspan="3"><span
			class="errorText" id="regErrInfo"></span></td>
	</tr>
	<tr>
		<td height="35px">&nbsp;</td>
		<td height="35px">&nbsp;</td>
		<td height="35px" align="left" colspan="2"><input type="submit"
			id="blackText" value="提交" onclick="return doRegist()" /> <input
			type="reset" id="blackText" value="重置" /></td>
	</tr>
</table>
</form>
</div>
<script type="text/javascript">
reloadVCode();
function ajaxUserIconUpload(){
    $J("#loading").ajaxStart(function(){
        $J(this).show();
        $J(this).src = "/image/loading.gif";
    }).ajaxComplete(function(){
        $J(this).show();
    });
    $J.ajaxFileUpload({
        url: '/uploadImage?type=userIcon',
        secureuri: false,
        fileElementId: 'userIcon',
        dataType: 'json',
        success: function(data, status){
            if (typeof(data.error) != 'undefined') {
                if (data.error != '') {
                    alert(data.error);
                }
            }
            else {
                e("loading").src = data.msg;
                e("userIconUrl").value = data.msg;
            }
        },
        error: function(data, status, e){
            alert(e);
        }
    });
    
    return false;
}
function doRegist(){
    if(checkRegist()){
        $J.post("/doRegist", $J("#form_reg").serialize(),function(data) {
            if (typeof(data.msg) != 'undefined' && data.msg == 'success') {
                //关闭注册框
                closeModalDialog();
                load('controlTab','/jsp/tabs/userTab.jsp');
            }
            else {
                $J("#regErrInfo").html(data.msg?data.msg:data.error);
            }
            
        },"json");
    }
    return false;
}
</script>