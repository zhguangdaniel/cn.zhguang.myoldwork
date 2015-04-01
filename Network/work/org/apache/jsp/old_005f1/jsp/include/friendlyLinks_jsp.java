package org.apache.jsp.old_005f1.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class friendlyLinks_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link href=\"/old_1/css/style.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("        function goWeb()\r\n");
      out.write("        {\r\n");
      out.write("            if(document.getElementById(\"fLinks\").value!='')\r\n");
      out.write("            {\r\n");
      out.write("                location.href=document.getElementById(\"fLinks\").value;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("<table width=\"200\" height=\"79\" align=\"center\"  cellpadding=\"0\"\r\n");
      out.write("\tcellspacing=\"0\" border=\"0\">\r\n");
      out.write("    <tr class=\"bar\">\r\n");
      out.write("        <td colspan=\"2\" style=\"padding-left:10px;\">友情链接</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td height=\"30px\" align=\"center\" valign=\"middle\" colspan=\"2\"><select size=\"1\" style=\"font-size:12px; color:#505050; width:150px;\">\r\n");
      out.write("                <option selected=\"selected\" value=\"http://www.sysu.edu.cn\">中山大学</option>\r\n");
      out.write("                <option value=\"http://sist.sysu.edu.cn\">中大信科院</option>\r\n");
      out.write("                <option value=\"http://www.tsinghua.edu.cn/docsn/lxy/\">清华大学</option>\r\n");
      out.write("                <option value=\"http://www.math.pku.edu.cn/\">北京大学</option>\r\n");
      out.write("                <option value=\"http://www.math.zju.edu.cn/webpagenew/homepage.asp\">浙江大学</option>\r\n");
      out.write("                <option value=\"http://math.sjtu.edu.cn/\">上海交通大学</option>\r\n");
      out.write("                <option value=\"http://math.ustc.edu.cn/Ch/\">中国科学技术大学</option>\r\n");
      out.write("                <option value=\"http://njumaths.nju.edu.cn/\">南京大学</option>\r\n");
      out.write("                <option value=\"http://www.fudan.edu.cn/new_dep/shuxue.htm\">复旦大学</option>\r\n");
      out.write("                <option value=\"http://info.ruc.edu.cn/professor/math.asp\">中国人民大学</option>\r\n");
      out.write("                <option value=\"http://www.xjtu.edu.cn/yxsz/lxy.html\">西安交通大学</option>\r\n");
      out.write("                <option value=\"http://202.118.250.18/index.html\">哈尔滨工业大学</option>\r\n");
      out.write("                <option value=\"http://202.113.29.3/math/\">南开大学</option>\r\n");
      out.write("                <option value=\"http://202.113.13.67/colleges/science/math/index.htm\">天津大学</option>\r\n");
      out.write("                <option value=\"http://math.seu.edu.cn/math/\">东南大学</option>\r\n");
      out.write("                <option value=\"http://maths.hust.edu.cn/new/index.asp\">华中科技大学</option>\r\n");
      out.write("                <option value=\"http://maths.whu.edu.cn/\">武汉大学</option>\r\n");
      out.write("                <option value=\"http://math.xmu.edu.cn/\">厦门大学</option>\r\n");
      out.write("                <option value=\"http://www.math.nthu.edu.tw/main.php\">山东大学 </option>\r\n");
      out.write("                <option value=\"http://math.hnu.cn/\">湖南大学</option>\r\n");
      out.write("                <option value=\"http://222.195.158.131/math/\">中国海洋大学</option>\r\n");
      out.write("                <option value=\"http://math.csu.edu.cn/\">中南大学</option>\r\n");
      out.write("                <option value=\"http://math.jlu.edu.cn/\">吉林大学</option>\r\n");
      out.write("                <option value=\"http://science.bit.edu.cn/\">北京理工大学</option>\r\n");
      out.write("                <option value=\"http://math.dlut.edu.cn/\">大连理工大学</option>\r\n");
      out.write("                <option value=\"http://www.ss.buaa.edu.cn/math/math.htm\">北京航空航天大学</option>\r\n");
      out.write("                <option value=\"http://202.202.11.135/\">重庆大学</option>\r\n");
      out.write("                <option value=\"http://www.math.uestc.edu.cn/\">电子科技大学</option>\r\n");
      out.write("                <option value=\"http://math.scu.edu.cn/\">四川大学</option>\r\n");
      out.write("                <option value=\"http://www.scut.edu.cn/science/\">华南理工大学</option>\r\n");
      out.write("                <option value=\"http://210.26.51.126/\">兰州大学</option>\r\n");
      out.write("                <option value=\"http://math.neu.edu.cn/asp/index.asp\">东北大学</option>\r\n");
      out.write("                <option value=\"http://www.nwpu.edu.cn/web/lixue/xygk/\">西北工业大学</option>\r\n");
      out.write("                <option value=\"http://web.tongji.edu.cn/~lixuebu/h-shuxue-all.html\">同济大学</option>\r\n");
      out.write("                <option value=\"http://59.64.61.2/\">北京师范大学</option>\r\n");
      out.write("            </select></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td width=\"120px\">&nbsp;</td>\r\n");
      out.write("        <td width=\"80px\" height=\"29px\" align=\"left\" valign=\"middle\"><input id=\"goWeb\" type=\"button\" value=\"go>>\" onclick=\"goWeb()\" /></td>\r\n");
      out.write("    </tr>\r\n");
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
