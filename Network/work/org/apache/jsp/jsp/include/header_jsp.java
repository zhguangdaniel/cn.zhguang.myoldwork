package org.apache.jsp.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			"", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/main.js\"></script>\r\n");
      out.write("<link href=\"/css/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<div class=\"banner\">\r\n");
      out.write("  <div class=\"headerRightFrame\">\r\n");
      out.write("    <div class=\"searchFrame\">\r\n");
      out.write("      <select name=\"fLinks\" size=\"1\" id=\"fLinks\" style=\"font-size:12px; color:#505050; width:120px; height:23px;float:left; margin-left:25px;\" onchange=\"goWeb()\">\r\n");
      out.write("        <option selected=\"selected\" value=\"#\">友情链接</option>\r\n");
      out.write("        <option value=\"http://www.sysu.edu.cn\">中山大学</option>\r\n");
      out.write("        <option value=\"http://sist.sysu.edu.cn\">中大信科院</option>\r\n");
      out.write("        <option value=\"http://www.tsinghua.edu.cn/\">清华大学</option>\r\n");
      out.write("        <option value=\"http://www.pku.edu.cn/\">北京大学</option>\r\n");
      out.write("        <option value=\"http://www.zju.edu.cn/\">浙江大学</option>\r\n");
      out.write("        <option value=\"http://www.sjtu.edu.cn/\">上海交通大学</option>\r\n");
      out.write("        <option value=\"http://www.ustc.edu.cn/\">中国科学技术大学</option>\r\n");
      out.write("        <option value=\"http://www.fudan.edu.cn/\">复旦大学</option>\r\n");
      out.write("        <option value=\"http://www.ruc.edu.cn/\">中国人民大学</option>\r\n");
      out.write("        <option value=\"http://www.xjtu.edu.cn/\">西安交通大学</option>\r\n");
      out.write("        <option value=\"http://www.hit.edu.cn/\">哈尔滨工业大学</option>\r\n");
      out.write("        <option value=\"http://www.nankai.edu.cn/\">南开大学</option>\r\n");
      out.write("        <option value=\"http://www.whu.edu.cn/\">武汉大学</option>\r\n");
      out.write("        <option value=\"http://www.hnu.cn/\">湖南大学</option>\r\n");
      out.write("        <option value=\"http://www.scut.edu.cn/\">华南理工大学</option>\r\n");
      out.write("        <option value=\"http://www.tongji.edu.cn/\">同济大学</option>\r\n");
      out.write("      </select>\r\n");
      out.write("      <form id=\"form_search\" action=\"/jsp/search/search.jsp\" method=\"post\" style=\" text-align:left;width:220px; height:30px;margin:0px; padding:0px; float:right;\">\r\n");
      out.write("        <input type=\"text\" name=\"searchKeyword\" id=\"searchKeyword\" class=\"blackText\" style=\"width:140px;\" value=\"Search...\" onclick=\"clearSearchText()\" />\r\n");
      out.write("        <input type=\"submit\" class=\"blackText\" value=\"搜索\" onclick=\"return checkSearch()\" />\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"headerMenu\">\r\n");
      out.write("      <ul>\r\n");
      out.write("        <li><a href=\"/\" target=\"_self\">&nbsp;首页</a></li>\r\n");
      out.write("        <li><a href=\"/old_1/\" target=\"_blank\">&nbsp;本站旧版</a></li>\r\n");
      out.write("        <li><a href=\"/jsp/message/message.jsp?page=1\" target=\"_blank\">&nbsp;访客留言</a></li>\r\n");
      out.write("        <li><a href=\"/jsp/manage/\" target=\"_blank\">&nbsp;后台管理</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
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
