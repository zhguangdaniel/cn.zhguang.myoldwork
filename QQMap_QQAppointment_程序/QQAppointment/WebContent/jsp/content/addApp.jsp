<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="addAppDiv"><c:choose>
	<c:when test="${isLogin!='true'}">
		<div style="width: 100%; text-align: center">请先登录，才能创建Appointment</div>
	</c:when>
	<c:otherwise>
		<form id="form_newapp" method="post" action="/doAddAppointment"
			enctype="multipart/form-data">
		<table width="100%" align="center" cellpadding="0" cellspacing="0"
			border="0">
			<tr>
				<td width="80px" height="35px" align="right">名称：</td>
				<td align="left" style="padding: 0px 10px"><input type="text"
					name="apptitle" id="apptitle" style="width: 250px;" /></td>
				<td rowspan="3" width="120px" align="center">
				<div style="width: 100%; text-align: center"><img id="appIcon"
					src="/image/loading.gif" style="display: none" /></div>
				<input type="text" id="appIconUrl" name="appIconUrl" value=""
					style="display: none" /> <input name="button" type="button"
					id="uploadIconBtn" class="button" value="Logo" /> <input type="file"
					id="appIconUpload" name="appIconUpload" class="uploadFileInput"
					onchange="return ajaxAppIconUpload()" UNSELECTABLE="on" value=" "
					size="1"></td>
			</tr>
			<tr>
				<td width="80px" height="35px" align="right">类型：</td>
				<td align="left" style="padding: 0px 10px"><select
					name="apptype" size="1" id="apptype" style="width: 255px">
					<option selected="selected" value="Dating">约会</option>
					<option value="Party">聚会</option>
					<option value="Discussion">讨论</option>
					<option value="Meeting">会议</option>
					<option value="Activity">活动</option>
				</select></td>
			</tr>
			<tr>
				<td width="80px" height="35px" align="right">参与方式：</td>
				<td align="left" style="padding: 0px 10px"><select
					name="attendtype" size="1" id="attendtype" style="width: 255px">
					<option selected="selected" value="1">开放式</option>
					<option value="2">审批式</option>
					<option value="3">邀请式</option>
					<option value="4">限定式</option>
				</select></td>
			</tr>
			<tr>
				<td width="80px" height="35px" align="right">人数限制：</td>
				<td align="left" style="padding: 0px 10px"><input type="text"
					name="userCountLimited" id="userCountLimited" style="width: 250px;" /></td>
				<td rowspan="4" width="120px" align="center">
				<div style="width: 100%; text-align: center"><img
					id="appImage" src="/image/loading.gif" style="display: none" /></div>
				<input type="text" id="appImageUrl" name="appImageUrl" value=""
					style="display: none" /> <input name="button" type="button"
					id="uploadImageBtn" class="button" value="缩略图" /> <input
					type="file" id="appImageUpload" name="appImageUpload"
					class="uploadFileInput" UNSELECTABLE="on"
					onchange="return ajaxAppImageUpload()" value=" " size="1"></td>
			</tr>
			<tr>
				<td width="80px" height="35px" align="right">时间：</td>
				<td align="left" style="padding: 0px 10px"><input type="text"
					name="startTime" id="startTime" style="width: 115px;" value="yyyy-MM-dd HH:mm"
					title="yyyy-MM-dd HH:mm" /> 至 <input type="text" name="endTime"
					id="endTime" style="width: 115px;" value="yyyy-MM-dd HH:mm" title="yyyy-MM-dd HH:mm" /></td>
			</tr>
			<tr>
				<td width="80px" height="35px" align="right">地址：</td>
				<td align="left" style="padding: 0px 10px"><input type="text"
					name="address" id="address" style="width: 250px;" /></td>
			</tr>
			<tr>
				<td width="80px" height="35px" align="right">经纬度：</td>
				<td align="left" style="padding: 0px 10px">经 <input type="text"
					name="lng" id="lng" style="width: 103px; margin-right: 8px;" /> 纬
				<input type="text" name="lat" id="lat" style="width: 103px;" /></td>
			</tr>
			<tr>
				<td width="80px" height="35px" align="right" valign="top">简介：</td>
				<td colspan="2" align="left" style="padding: 0px 10px"><textarea
					name="appintro" id="appintro" class="blackText" style="width: 250px; height: 120px"></textarea></td>
			</tr>
			<tr>
				<td height="20px">&nbsp;</td>
				<td height="20px" align="left" colspan="2"><span
					class="errorText" id="appErrInfo"></span></td>
			</tr>
			<tr>
				<td colspan="3" height="35px" align="center"><input
					type="submit" id="blackText" value="提交"
					onclick="return addAppointment()" /> <input type="reset"
					id="blackText" value="重置" /></td>
			</tr>
		</table>
		</form>
<script type="text/javascript">
	if(lat==0)lat=map.getCenter().getLat();
	if(lng==0)lng=map.getCenter().getLng();
    e("lat").value=lat;
    e("lng").value=lng;
    lat=0;
    lng=0;
function ajaxAppImageUpload(){
    $J.ajaxFileUpload({
        url: '/uploadImage?type=appImage&width=100&height=80',
        secureuri: false,
        fileElementId: 'appImageUpload',
        dataType: 'json',
        beforeSend:function()
        { 
            $J("#appImage").show();
    	    $J("#appImage").attr("src","/image/loading.gif");
        },
        complete:function()
        {
        	$J("#appImage").show();
        },      
        success: function(data, status){
            if (typeof(data.error) != 'undefined') {
                if (data.error != '') {
                }
            }
            else {
                e("appImage").src = data.msg;
                e("appImageUrl").value = data.msg;
            }
        },
        error: function(data, status, e){
            alert(e);
        }
    })
    
    return false;
}
function ajaxAppIconUpload(){
    $J.ajaxFileUpload({
        url: '/uploadImage?type=appIcon',
        secureuri: false,
        fileElementId: 'appIconUpload',
        dataType: 'json',
        beforeSend:function()
        { 
            $J("#appIcon").show();
            $J("#appIcon").attr("src","/image/loading.gif");
        },
        complete:function()
        {
            $J("#appIcon").show();
        }, 
        success: function(data, status){
            if (typeof(data.error) != 'undefined') {
                if (data.error != '') {
                    alert(data.error);
                }
            }
            else {
                e("appIcon").src = data.msg;
                e("appIconUrl").value = data.msg;
            }
        },
        error: function(data, status, e){
            alert(e);
        }
    })
    
    return false;
}

function addAppointment(){
    $J.post("/doAddAppointment", $J("#form_newapp").serialize(),function(data) {
        if (typeof(data.msg) != 'undefined' && data.msg == 'success') {
            // 添加标记
            var marker = new QQMap.QMarker({
                position: new QQMap.QLatLng(data.lat, data.lng),
                draggable: true,
                map: map
            });
            
            //添加标记的内容
            var decor = new QQMap.QMarkerDecoration({
                content: "<span class='markerText'>"+data.type+"</span>",
                margin: new QQMap.QSize(0, -5),
                align: QQMap.QALIGN.CENTER,
                marker: marker
            });
            
            
            //信息窗口
            var infoWin = new QQMap.QInfoWindow({
                map: map
            });

            //标记点击事件
            QQMap.QEvent.addListener(marker, 'click', function(){
                var infoContent = "<div class='markerInfoWin'>" +
                "<div class='appPic'><img src='"+data.iconUrl+"' width='50px' height='50px' /></div>" +
                "<div class='appInfo'><span class='appTitle'>"+data.title+"</span><br/>" +
                "<span class='appInfoContent'>时间："+data.startTime+"</span><br/>" +
                "<span class='appInfoContent'>&nbsp;&nbsp;至："+data.endTime+"</span><br/>" +
                "<span class='appInfoContent'>地点："+data.address+"</span><br/>" +
                "<span class='appInfoContent'>人数："+data.attendeeCount+"</span><br/>" +
                "<span class='appInfoContent'>发起："+data.creator+"</span><br/>" +
                "<span class='showDetail'><a onclick='showAppDetailDialog()'>查看详情</a></span><br/>" +
                "</div>" +
                "</div>";
                infoWin.open(infoContent, marker);
            });
            closeModallessDialog("addAppointemntDialog");
        }
        else {
            $J("#appErrInfo").html(data.msg?data.msg:data.error);
        }
        
    },"json");
    return false;
}
</script>
	</c:otherwise>
</c:choose></div>
