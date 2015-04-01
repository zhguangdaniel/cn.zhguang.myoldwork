<%@ page contentType="text/html; charset=utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript">
imgUrl1="/images/flashAblum/1.jpg";
imgtext1="img01"
imgLink1="";
imgUrl2="/images/flashAblum/2.jpg";
imgtext2="img02"
imgLink2="";
imgUrl3="/images/flashAblum/3.jpg";
imgtext3="img03"
imgLink3="";
imgUrl4="/images/flashAblum/4.jpg";
imgtext4="img04"
imgLink4="";
imgUrl5="/images/flashAblum/5.jpg";
imgtext5="img05"
imgLink5="";

 var focus_width=740;
 var focus_height=230;
 var text_height=0;
 var swf_height = focus_height+text_height;
 
 var pics=imgUrl1+"|"+imgUrl2+"|"+imgUrl3+"|"+imgUrl4+"|"+imgUrl5;
 var links=imgLink1+"|"+imgLink2+"|"+imgLink3+"|"+imgLink4+"|"+imgLink5;
 var texts=imgtext1+"|"+imgtext2+"|"+imgtext3+"|"+imgtext4+"|"+imgtext5;
 
	document.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="'+ focus_width +'" height="'+ swf_height +'">');
 	/*IE*/
	document.write('<param name="allowScriptAccess" value="sameDomain"><param name="movie" value="/flash/picView.swf"><param name="quality" value="high"><param name="bgcolor" value="#BBD8F8">');
	document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
	document.write('<param name="FlashVars" value="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'">');
 	/*FireFox*/
	document.write('<embed src="/flash/picView.swf" wmode="opaque" FlashVars="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'" menu="false" bgcolor="#BBD8F8" quality="high" width="'+ focus_width +'" height="'+ swf_height +'" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />');
 	document.write('</object>');
    </script>