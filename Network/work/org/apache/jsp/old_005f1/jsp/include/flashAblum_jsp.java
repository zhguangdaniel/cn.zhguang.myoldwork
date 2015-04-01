package org.apache.jsp.old_005f1.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class flashAblum_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\r\n");
      out.write("<table border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"center\"><script type=\"text/javascript\">\r\n");
      out.write("imgUrl1=\"/old_1/images/flashAblum/1.jpg\";\r\n");
      out.write("imgtext1=\"图片链接01\"\r\n");
      out.write("imgLink1=\"#\";\r\n");
      out.write("imgUrl2=\"/old_1/images/flashAblum/2.jpg\";\r\n");
      out.write("imgtext2=\"图片链接02\"\r\n");
      out.write("imgLink2=\"#\";\r\n");
      out.write("imgUrl3=\"/old_1/images/flashAblum/3.jpg\";\r\n");
      out.write("imgtext3=\"图片链接03\"\r\n");
      out.write("imgLink3=\"#\";\r\n");
      out.write("imgUrl4=\"/old_1/images/flashAblum/4.jpg\";\r\n");
      out.write("imgtext4=\"图片链接04\"\r\n");
      out.write("imgLink4=\"#\";\r\n");
      out.write("imgUrl5=\"/old_1/images/flashAblum/5.jpg\";\r\n");
      out.write("imgtext5=\"图片链接05\"\r\n");
      out.write("imgLink5=\"#\";\r\n");
      out.write("\r\n");
      out.write(" var focus_width=202;\r\n");
      out.write(" var focus_height=214;\r\n");
      out.write(" var text_height=0;\r\n");
      out.write(" var swf_height = focus_height+text_height;\r\n");
      out.write(" \r\n");
      out.write(" var pics=imgUrl1+\"|\"+imgUrl2+\"|\"+imgUrl3+\"|\"+imgUrl4+\"|\"+imgUrl5;\r\n");
      out.write(" var links=imgLink1+\"|\"+imgLink2+\"|\"+imgLink3+\"|\"+imgLink4+\"|\"+imgLink5;\r\n");
      out.write(" var texts=imgtext1+\"|\"+imgtext2+\"|\"+imgtext3+\"|\"+imgtext4+\"|\"+imgtext5;\r\n");
      out.write(" \r\n");
      out.write("\tdocument.write('<object classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" codebase=\"http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0\" width=\"'+ focus_width +'\" height=\"'+ swf_height +'\">');\r\n");
      out.write(" \t/*IE*/\r\n");
      out.write("\tdocument.write('<param name=\"allowScriptAccess\" value=\"sameDomain\"><param name=\"movie\" value=\"/old_1/flash/picView.swf\"><param name=\"quality\" value=\"high\"><param name=\"bgcolor\" value=\"#BBD8F8\">');\r\n");
      out.write("\tdocument.write('<param name=\"menu\" value=\"false\"><param name=wmode value=\"opaque\">');\r\n");
      out.write("\tdocument.write('<param name=\"FlashVars\" value=\"pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'\">');\r\n");
      out.write(" \t/*FireFox*/\r\n");
      out.write("\tdocument.write('<embed src=\"/flash/picView.swf\" wmode=\"opaque\" FlashVars=\"pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'\" menu=\"false\" bgcolor=\"#BBD8F8\" quality=\"high\" width=\"'+ focus_width +'\" height=\"'+ swf_height +'\" allowScriptAccess=\"sameDomain\" type=\"application/x-shockwave-flash\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" />');\r\n");
      out.write(" \tdocument.write('</object>');\r\n");
      out.write("    </script></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
