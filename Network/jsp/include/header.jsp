<%@ page contentType="text/html; charset=utf-8" errorPage="" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="/js/main.js"></script>
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<div class="banner">
  <div class="headerRightFrame">
    <div class="searchFrame">
      <select name="fLinks" size="1" id="fLinks" style="font-size:12px; color:#505050; width:120px; height:23px;float:left; margin-left:25px;" onchange="goWeb()">
        <option selected="selected" value="#">友情链接</option>
        <option value="http://www.sysu.edu.cn">中山大学</option>
        <option value="http://sist.sysu.edu.cn">中大信科院</option>
        <option value="http://www.tsinghua.edu.cn/">清华大学</option>
        <option value="http://www.pku.edu.cn/">北京大学</option>
        <option value="http://www.zju.edu.cn/">浙江大学</option>
        <option value="http://www.sjtu.edu.cn/">上海交通大学</option>
        <option value="http://www.ustc.edu.cn/">中国科学技术大学</option>
        <option value="http://www.fudan.edu.cn/">复旦大学</option>
        <option value="http://www.ruc.edu.cn/">中国人民大学</option>
        <option value="http://www.xjtu.edu.cn/">西安交通大学</option>
        <option value="http://www.hit.edu.cn/">哈尔滨工业大学</option>
        <option value="http://www.nankai.edu.cn/">南开大学</option>
        <option value="http://www.whu.edu.cn/">武汉大学</option>
        <option value="http://www.hnu.cn/">湖南大学</option>
        <option value="http://www.scut.edu.cn/">华南理工大学</option>
        <option value="http://www.tongji.edu.cn/">同济大学</option>
      </select>
      <form id="form_search" action="/jsp/search/search.jsp" method="post" style=" text-align:left;width:220px; height:30px;margin:0px; padding:0px; float:right;">
        <input type="text" name="searchKeyword" id="searchKeyword" class="blackText" style="width:140px;" value="Search..." onclick="clearSearchText()" />
        <input type="submit" class="blackText" value="搜索" onclick="return checkSearch()" />
      </form>
    </div>
    <div class="headerMenu">
      <ul>
        <li><a href="/" target="_self">&nbsp;首页</a></li>
        <li><a href="/old_1/" target="_blank">&nbsp;本站旧版</a></li>
        <li><a href="/jsp/message/message.jsp?page=1" target="_blank">&nbsp;访客留言</a></li>
        <li><a href="/jsp/manage/" target="_blank">&nbsp;后台管理</a></li>
      </ul>
    </div>
  </div>
</div>
