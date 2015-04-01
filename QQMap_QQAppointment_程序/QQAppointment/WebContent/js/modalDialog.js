/**
 * @charset "utf-8"
 * @author Daniel Zhang
 */
//var DialogOptions = function(){
//    this.width = 200;
//    this.height = 150;
//    this.x = 0;
//    this.y = 0;
//    this.title = "";
//    this.content = "";
//}

var ModalDialog = function(dialogOptions){
    var isIe = (document.all) ? true : false;
    var width = dialogOptions.width ? dialogOptions.width : 200;
    var height = dialogOptions.height ? dialogOptions.height : 150;
    var x = dialogOptions.x ? dialogOptions.x : ((document.documentElement.clientWidth - width) / 2);
    var y = dialogOptions.y ? dialogOptions.y : ((document.documentElement.clientHeight - height) / 2);
    var title = dialogOptions.title ? dialogOptions.title : "未命名窗口";
    var content = dialogOptions.content ? dialogOptions.content : "";
    var _backgroundId = '_background';
    var _modalWindowId = '_modalWindow';
    
    //弹出窗口
    this.showDialog = function(){
        //关闭已有的模式框
        close();
        
        //在IE下屏蔽所有select控件
        if (isIe) {
            setSelectState('hidden');
        }
        //半透明背景
        var background = document.createElement("div");
        background.id = _backgroundId;
        background.className = _backgroundId;
        document.body.appendChild(background);
        
        //弹出模式对话框
        var modalWindow = document.createElement("div");
        modalWindow.id = _modalWindowId;
        modalWindow.className = _modalWindowId;
        modalWindow.innerHTML = "<div class='windowTop'><span>" +
        title +
        "</span><input type='button' id='closeWindowLabel' class='closeWindowLabel' title='关闭窗口'/></div>" +
        "<div class='windowContent' id='modalWindowContent'>" +
        content +
        "</div>";
        var modalStyleStr = "left:" + x + "px;top:" + y + "px;position:absolute;width:" + width + "px;height:" + height + "px;";
        modalWindow.style.cssText = modalStyleStr;
        document.body.appendChild(modalWindow);
        e('closeWindowLabel').onclick = function(){
            close();
        }
    }
    
    //关闭
    this.closeDialog = function(){
        close();
    }
    //设置select的可见状态
    function setSelectState(state){
        var objl = document.getElementsByTagName('select');
        for (var i = 0; i < objl.length; i++) {
            objl[i].style.visibility = state;
        }
    }
    
    //关闭窗口
    function close(){
        var backgroundNode = e(_backgroundId);
        var modalWindowNode = e(_modalWindowId);
        if (backgroundNode != null) {
            backgroundNode.parentNode.removeChild(backgroundNode);
        }
        if (modalWindowNode != null) {
            modalWindowNode.parentNode.removeChild(modalWindowNode);
        }
        if (isIe) {
            setSelectState('');
        }
    }
}

function closeModalDialog(){
    var dialog = new ModalDialog({});
    dialog.closeDialog()
}
