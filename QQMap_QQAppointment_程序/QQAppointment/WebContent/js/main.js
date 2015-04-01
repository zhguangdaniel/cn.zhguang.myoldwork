/**
 * @charset "utf-8"
 * @author Daniel Zhang
 */
var $J = jQuery.noConflict();
var lng = 0;
var lat = 0;
var map;
function v(id){
    return document.getElementById(id).value;
}

function e(id){
    return document.getElementById(id);
}

function load(id, url){
    $J('#' + id).html("<div style='width:100%;text-align:center;'>正在载入...</div>");
    $J('#' + id).load(url);
}

var init = function(){
    var mapCenter = new QQMap.QLatLng(39.916527, 116.397128);
    map = new QQMap.QMap(e("mapView"), {
        center: mapCenter,
        zoomLevel: 12
    });
    // 设置鼠标样式
    // map.setCursor('imgs/c1.cur');
    // map.setDraggingCursor('imgs/c2.cur');
    
    // 添加导航控件
    var navControl = new QQMap.QNavigationControl({
        align: QQMap.QALIGN.TOP_LEFT,
        margin: new QQMap.QSize(10, 15),
        map: map,
        style: QQMap.QNavigationControlStyle.LARGE
    });
    
    // 添加标尺控件
    var scaleControl = new QQMap.QScaleControl({
        align: QQMap.QALIGN.BOTTOM_LEFT,
        margin: new QQMap.QSize(85, 15),
        map: map
    });
    
    // 添加右键菜单
    var contextMenu = new QQMap.QContextMenuControl();
    contextMenu.setMap(map);
    contextMenu.addItem('在这里创建Appointment', openNewApp);
    contextMenu.addTarget(map);
    
    // 添加自定义控件，显示或隐藏左边控制栏
    var leftPanelControl = new QQMap.QControl({
        content: '<div id="expander" class="expanderShow" onclick="showHideControlPanel()"></div>',
        align: QQMap.QALIGN.LEFT,
        map: map
    });
    
    // 添加标记
    var marker = new QQMap.QMarker({
        position: new QQMap.QLatLng(39.92623, 116.28560),
        draggable: true,
        map: map
    });
    
    //添加标记的内容
    var decor = new QQMap.QMarkerDecoration({
        content: "<span class='markerText'>聚</span>",
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
        "<div class='appPic'><img src='/files/images/2.jpg' width='50px' height='50px' /></div>" +
        "<div class='appInfo'><span class='appTitle'>“玫瑰之约”相亲活动</span><br/>" +
        "<span class='appInfoContent'>时间：2011年7月15日</span><br/>" +
        "<span class='appInfoContent'>地点：北京市海淀区玲珑园</span><br/>" +
        "<span class='appInfoContent'>人数：50</span><br/>" +
        "<span class='appInfoContent'>发起：爱情公寓Ipart网站</span><br/>" +
        "<span class='appInfoContent'>链接：<a href='http://www.ipart.cn'>www.ipart.cn</a></span><br/>" +
        "<span class='showDetail'><a onclick='showAppDetailDialog()'>查看详情</a></span><br/>" +
        "</div>" +
        "</div>";
        infoWin.open(infoContent, marker);
    });
    
    //右击地图
    QQMap.QEvent.addListener(map, 'rightclick', function(event){
        lng = event.qLatLng.getLng();
        lat = event.qLatLng.getLat();
    });
    
    // 添加标记
    var marker2 = new QQMap.QMarker({
        position: new QQMap.QLatLng(39.88027, 116.25330),
        draggable: true,
        map: map
    });
    
    //添加标记的内容
    var decor2 = new QQMap.QMarkerDecoration({
        content: "<span class='markerText'>会</span>",
        margin: new QQMap.QSize(0, -5),
        align: QQMap.QALIGN.CENTER,
        marker: marker2
    });
    // 添加标记
    var marker3 = new QQMap.QMarker({
        position: new QQMap.QLatLng(39.87576, 116.33825),
        draggable: true,
        map: map
    });
    
    //添加标记的内容
    var decor3 = new QQMap.QMarkerDecoration({
        content: "<span class='markerText'>约</span>",
        margin: new QQMap.QSize(0, -5),
        align: QQMap.QALIGN.CENTER,
        marker: marker3
    });
}

function showHide(showID){
    if (showID != null) {
        if (e(showID).style.display != "block") {
            e(showID).style.display = "block";
        }
        else {
            e(showID).style.display = "none";
        }
    }
}

function showHideControlPanel(){
    if (e('controlPanel').style.display != "none") {
        e('controlPanel').style.display = "none";
        e('mapPanel').style.left = "0";
        e('middleBorder').style.display = "none";
        e('expander').className = "expanderHide";
    }
    else {
        e('controlPanel').style.display = "block";
        e('mapPanel').style.left = "300px";
        e('middleBorder').style.display = "block";
        e('expander').className = "expanderShow";
    }
}

function showControlTab(tabId){
    tabIdArray = ['userTab', 'searchTab', 'scheduleTab', 'appointmentTab'];
    for (var i = 0; i < tabIdArray.length; i++) {
        if (tabIdArray[i] == tabId) {
            e(tabId).style.backgroundPosition = "-67px " + (i * (-30)) + "px";
        }
        else {
            e(tabIdArray[i]).style.backgroundPosition = "0px " + (i * (-30)) + "px";
        }
    }
    load('controlTab', '/jsp/tabs/' + tabId + '.jsp');
}

function openNewApp(){
    showAddAppDialog();
    load("addAppContainer", "/jsp/content/addApp.jsp");
}
