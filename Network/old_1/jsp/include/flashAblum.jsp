<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<table border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center"><script type="text/javascript">
imgUrl1="/old_1/images/flashAblum/1.jpg";
imgtext1="图片链接01"
imgLink1="#";
imgUrl2="/old_1/images/flashAblum/2.jpg";
imgtext2="图片链接02"
imgLink2="#";
imgUrl3="/old_1/images/flashAblum/3.jpg";
imgtext3="图片链接03"
imgLink3="#";
imgUrl4="/old_1/images/flashAblum/4.jpg";
imgtext4="图片链接04"
imgLink4="#";
imgUrl5="/old_1/images/flashAblum/5.jpg";
imgtext5="图片链接05"
imgLink5="#";

 var focus_width=202;
 var focus_height=214;
 var text_height=0;
 var swf_height = focus_height+text_height;
 
 var pics=imgUrl1+"|"+imgUrl2+"|"+imgUrl3+"|"+imgUrl4+"|"+imgUrl5;
 var links=imgLink1+"|"+imgLink2+"|"+imgLink3+"|"+imgLink4+"|"+imgLink5;
 var texts=imgtext1+"|"+imgtext2+"|"+imgtext3+"|"+imgtext4+"|"+imgtext5;
 
	document.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="'+ focus_width +'" height="'+ swf_height +'">');
 	/*IE*/
	document.write('<param name="allowScriptAccess" value="sameDomain"><param name="movie" value="/old_1/flash/picView.swf"><param name="quality" value="high"><param name="bgcolor" value="#BBD8F8">');
	document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
	document.write('<param name="FlashVars" value="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'">');
 	/*FireFox*/
	document.write('<embed src="/flash/picView.swf" wmode="opaque" FlashVars="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'" menu="false" bgcolor="#BBD8F8" quality="high" width="'+ focus_width +'" height="'+ swf_height +'" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />');
 	document.write('</object>');
    </script></td>
	</tr>
</table>
