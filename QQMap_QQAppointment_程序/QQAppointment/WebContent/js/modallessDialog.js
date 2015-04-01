/**
 * @charset "utf-8"
 * @author Daniel Zhang
 */
//var DialogOptions = function(){
//    this.width = 200;
//    this.height = 150;
//    this.x = 0;
//    this.y = 0;
//    this.id = "";
//    this.title = "";
//    this.content = "";
//}

var ModallessDialog = function(dialogOptions){

    var isIe = (document.all) ? true : false;
    var width = dialogOptions.width ? dialogOptions.width : 200;
    var height = dialogOptions.height ? dialogOptions.height : 150;
    var x = dialogOptions.x ? dialogOptions.x : ((document.documentElement.clientWidth - width) / 2);
    var y = dialogOptions.y ? dialogOptions.y : ((document.documentElement.clientHeight - height) / 2);
    var title = dialogOptions.title ? dialogOptions.title : "未命名窗口";
    var content = dialogOptions.content ? dialogOptions.content : "";
    var id = dialogOptions.id ? dialogOptions.id : "modallessDialog";
    var x_mouseX = 0;//当鼠标在弹出框的标题栏按下时，弹出框左上角x与鼠标x的距离
    var y_mouseY = 0;//当鼠标在弹出框的标题栏按下时，弹出框左上角y与鼠标y的距离
    var isMouseDown = false;//鼠标是否在弹出框的标题栏按下
    var isWindowMaximal = false;//窗口是否已经最大化
    //弹出非模式对话框
    this.showDialog = function(){
        if (e(id)) {
            //若窗口已经存在，则不再创建
            return false;
        }
        var modallessWindow = document.createElement("div");
        modallessWindow.id = id;
        modallessWindow.className = '_modallessWindow';
        var resizeWindowLabelId = "resize" + id + "Label";
        var closeWindowLabelId = "close" + id + "Label";
        modallessWindow.innerHTML = "<div id='" + id + "Top' class='windowTop' style='cursor:move;'><span>" +
        title +
        "</span>" +
        "<input type='button' id='" +
        resizeWindowLabelId +
        "' class='maximizeWindowLabel' title='最大化窗口'/>" +
        "<input type='button' id='" +
        closeWindowLabelId +
        "' class='closeWindowLabel' title='关闭窗口'/></div>" +
        "<div class='windowContent' id='modalWindowContent'>" +
        content +
        "</div>";
        var styleStr = "left:" + x + "px;top:" + y + "px;position:absolute;width:" + width + "px;height:" + height + "px;";
        modallessWindow.style.cssText = styleStr;
        document.body.appendChild(modallessWindow);
        e(closeWindowLabelId).onclick = function(){
            closeDialog();
        }
        e(resizeWindowLabelId).onclick = function(){
            resizeDialog();
        }
        e(id + 'Top').ondblclick = function(){
            resizeDialog();
        }
        e(id + 'Top').onmousemove = onDragDialog;
        e(id + 'Top').onmouseout = onMouseOutTopBar
        e(id + 'Top').onmousedown = onMouseDownTopBar;
        e(id + 'Top').onmouseup = onMouseUpTopBar;
        e(id + 'Top').onselectstart = function(){
            return false;
        }
        window.onresize = onWindowResize;
    }
    
    //获得当前鼠标位置
    function mousePosition(ev){
        ev = ev || window.event;
        if (ev.pageX || ev.pageY) {
            return {
                x: ev.pageX,
                y: ev.pageY
            };
        }
        return {
            x: ev.clientX + document.documentElement.scrollLeft - document.documentElement.clientLeft,
            y: ev.clientY + document.documentElement.scrollTop - document.documentElement.clientTop
        };
    }
    
    //关闭窗口
    function closeDialog(){
        var modalWindowNode = e(id);
        if (modalWindowNode != null) {
            modalWindowNode.parentNode.removeChild(modalWindowNode);
        }
    }
    
    //最大化或恢复窗口
    function resizeDialog(){
        var resizeWindowLabel = "resize" + id + "Label";
        if (!isWindowMaximal) {
            e(id).style.top = "0px";
            e(id).style.left = "0px";
            e(id).style.width = (document.documentElement.clientWidth - 3) + "px";
            e(id).style.height = (document.documentElement.clientHeight - 3) + "px";
            e(resizeWindowLabel).title = '恢复窗口';
            e(resizeWindowLabel).className = "restoreWindowLabel";
            isWindowMaximal = true;
        }
        else {
            e(id).style.top = y + "px";
            e(id).style.left = x + "px";
            e(id).style.width = width + "px";
            e(id).style.height = height + "px";
            e(resizeWindowLabel).title = '最大化窗口';
            e(resizeWindowLabel).className = "maximizeWindowLabel";
            isWindowMaximal = false;
        }
    }
    
    //窗口Resize事件
    function onWindowResize(){
        if (e(id)) {
            if (isWindowMaximal) {
                e(id).style.top = "0px";
                e(id).style.left = "0px";
                e(id).style.width = (document.documentElement.clientWidth - 3) + "px";
                e(id).style.height = (document.documentElement.clientHeight - 3) + "px";
            }
        }
    }
    
    //鼠标移出TopBar
    function onMouseOutTopBar(){
        isMouseDown = false;
    }
    
    //鼠标左键弹起
    function onMouseUpTopBar(ev){
        isMouseDown = false;
    }
    
    //鼠标按下左键
    function onMouseDownTopBar(ev){
        var mousePos = mousePosition(ev);
        x_mouseX = x - mousePos.x;
        y_mouseY = y - mousePos.y;
        isMouseDown = true;
    }
    
    //窗口拖动
    function onDragDialog(ev){
        if (isMouseDown) {
            if (!isWindowMaximal) {
                //获得当前鼠标的坐标
                var mousePos = mousePosition(ev);
                x = x_mouseX + mousePos.x;
                y = y_mouseY + mousePos.y;
                e(id).style.left = x + 'px';
                e(id).style.top = y + 'px';
            }
        }
    }
}
//关闭窗口
function closeModallessDialog(winId){
    var modalWindowNode = e(winId);
    if (modalWindowNode != null) {
        modalWindowNode.parentNode.removeChild(modalWindowNode);
    }
}

//测试
function showAppDetailDialog(){
    var dialog = new ModallessDialog({
        width: 500,
        height: 460,
        x: 650,
        y: 200,
        id: "firstTestWindows",
        title: 'Appointment - “玫瑰之约”相亲活动',
        content: "<div id='appDetailContent'></div>"
    });
    dialog.showDialog();
    load("appDetailContent", "/jsp/content/appTabPanel.jsp");
}

function showAddAppDialog(){
    var dialog = new ModallessDialog({
        width: 530,
        height: 490,
        x: 400,
        y: 100,
        id: "addAppointemntDialog",
        title: 'Appointment - 新建...',
        content: "<div id='addAppContainer'></div>"
    });
    dialog.showDialog();
}
