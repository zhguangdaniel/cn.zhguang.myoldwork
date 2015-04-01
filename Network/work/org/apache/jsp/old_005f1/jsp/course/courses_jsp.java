package org.apache.jsp.old_005f1.jsp.course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class courses_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>网工－课程学习</title>\r\n");
      out.write("<link href=\"/old_1/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"/old_1/css/course.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!--主体容器container-->\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("    <!--主头部mainHeader-->\r\n");
      out.write("    <div id=\"mainHeader\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/old_1/jsp/include/mainHeader.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--//mainHeader-->\r\n");
      out.write("    <!--主信息区-->\r\n");
      out.write("    <div id=\"mainContent\">\r\n");
      out.write("        <div id=\"breadcrumbs\"> <a href=\"/old_1/index.jsp\" class=\"normalLink\">首页</a>&nbsp;&gt;&nbsp;课程学习 </div>\r\n");
      out.write("        <div id=\"course\">\r\n");
      out.write("            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td height=\"20px\" colspan=\"3\">&nbsp;</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"49%\" id=\"tdTitle\"><img src=\"/old_1/images/tdTitle.png\" width=\"15\" height=\"15\" />&nbsp;自然科学基础课程</td>\r\n");
      out.write("                    <td width=\"2%\" rowspan=\"6\">&nbsp;</td>\r\n");
      out.write("                    <td  width=\"49%\" id=\"tdTitle\"><img src=\"/old_1/images/tdTitle.png\" width=\"15\" height=\"15\" />&nbsp;IT平台基础课程</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td valign=\"top\"><ul>\r\n");
      out.write("                            <li><a href=\"#\">数学分析</a></li>\r\n");
      out.write("                            <li><a href=\"#\">高等代数</a></li>\r\n");
      out.write("                            <li><a href=\"#\">集合论与图论</a></li>\r\n");
      out.write("                            <li><a href=\"#\">概率论与数理统计</a></li>\r\n");
      out.write("                            <li><a href=\"#\">数理逻辑</a></li>\r\n");
      out.write("                            <li><a href=\"#\">代数结构</a></li>\r\n");
      out.write("                            <li><a href=\"#\">数值计算方法</a></li>\r\n");
      out.write("                        </ul></td>\r\n");
      out.write("                    <td valign=\"top\"><ul>\r\n");
      out.write("                            <li><a href=\"#\">程序设计I</a></li>\r\n");
      out.write("                            <li><a href=\"#\">数据结构与算法</a></li>\r\n");
      out.write("                            <li><a href=\"#\">数字电路与逻辑设计</a></li>\r\n");
      out.write("                            <li><a href=\"#\">信号与系统</a></li>\r\n");
      out.write("                            <li><a href=\"#\">电路与电子学</a></li>\r\n");
      out.write("                        </ul></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td id=\"tdTitle\"><img src=\"/old_1/images/tdTitle.png\" width=\"15\" height=\"15\" />&nbsp;专业基础课程</td>\r\n");
      out.write("                    <td id=\"tdTitle\"><img src=\"/old_1/images/tdTitle.png\" width=\"15\" height=\"15\" />&nbsp;专业技术课程</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td valign=\"top\"><ul>\r\n");
      out.write("                            <li><a href=\"#\">程序设计II</a></li>\r\n");
      out.write("                            <li><a href=\"#\">计算机组成原理</a></li>\r\n");
      out.write("                            <li><a href=\"#\">操作系统</a></li>\r\n");
      out.write("                            <li><a href=\"#\">计算机网络</a></li>\r\n");
      out.write("                            <li><a href=\"#\">计算机接口技术及实践</a></li>\r\n");
      out.write("                            <li><a href=\"#\">编译原理及实践</a></li>\r\n");
      out.write("                            <li><a href=\"#\">软件工程导论及实践</a></li>\r\n");
      out.write("                            <li><a href=\"#\">数据库系统原理及实践</a></li>\r\n");
      out.write("                            <li><a href=\"#\">人工智能及实践</a></li>\r\n");
      out.write("                        </ul></td>\r\n");
      out.write("                    <td valign=\"top\"><ul>\r\n");
      out.write("                            <li><a href=\"#\">通信原理</a></li>\r\n");
      out.write("                            <li><a href=\"#\">无线通信与网络</a></li>\r\n");
      out.write("                            <li><a href=\"#\">密码学与网络安全</a></li>\r\n");
      out.write("                            <li><a href=\"#\">计算机网络主题讲座</a></li>\r\n");
      out.write("                            <li><a href=\"#\">网络优化与网络管理</a></li>\r\n");
      out.write("                            <li><a href=\"#\">网络存储技术及实践</a></li>\r\n");
      out.write("                            <li><a href=\"#\">网络处理器与网络系统设计</a></li>\r\n");
      out.write("                            <li><a href=\"#\">网络协议分析与设计</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Web信息检索</a></li>\r\n");
      out.write("                            <li><a href=\"#\">并行与分布式计算</a></li>\r\n");
      out.write("                            <li><a href=\"#\">电子商务</a></li>\r\n");
      out.write("                        </ul></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td id=\"tdTitle\"><img src=\"/old_1/images/tdTitle.png\" width=\"15\" height=\"15\" />&nbsp;选修课</td>\r\n");
      out.write("                    <td id=\"tdTitle\"><img src=\"/old_1/images/tdTitle.png\" width=\"15\" height=\"15\" />&nbsp;实践课程</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td valign=\"top\"><ul>\r\n");
      out.write("                            <li><a href=\"#\">多核程序设计及实践</a></li>\r\n");
      out.write("                            <li><a href=\"#\">高级数据库技术及实践</a></li>\r\n");
      out.write("                            <li><a href=\"#\">工作流技术</a></li>\r\n");
      out.write("                            <li><a href=\"#\">计算机图形学</a></li>\r\n");
      out.write("                            <li><a href=\"#\">数字图像处理</a></li>\r\n");
      out.write("                            <li><a href=\"#\">模式识别</a></li>\r\n");
      out.write("                            <li><a href=\"#\">数据挖掘</a></li>\r\n");
      out.write("                            <li><a href=\"#\">虚拟现实</a></li>\r\n");
      out.write("                            <li><a href=\"#\">多媒体技术</a></li>\r\n");
      out.write("                            <li><a href=\"#\">算法设计与应用</a></li>\r\n");
      out.write("                            <li><a href=\"#\">智能算法及应用</a></li>\r\n");
      out.write("                            <li><a href=\"#\">形式语言与自动机</a></li>\r\n");
      out.write("                            <li><a href=\"#\">计算机体系结构</a></li>\r\n");
      out.write("                            <li><a href=\"#\">人机交互设计</a></li>\r\n");
      out.write("                            <li><a href=\"#\">嵌入式系统原理与应用</a></li>\r\n");
      out.write("                            <li><a href=\"#\">信息科学技术导论</a></li>\r\n");
      out.write("                        </ul></td>\r\n");
      out.write("                    <td valign=\"top\"><ul>\r\n");
      out.write("                            <li><a href=\"#\">军事理论与技能训练</a></li>\r\n");
      out.write("                            <li><a href=\"#\">网络工程专业综合实践</a></li>\r\n");
      out.write("                            <li><a href=\"#\">数学建模训练</a></li>\r\n");
      out.write("                            <li><a href=\"#\">数据结构与程序设计综合实践</a></li>\r\n");
      out.write("                            <li><a href=\"#\">网络与操作系统综合实践</a></li>\r\n");
      out.write("                            <li><a href=\"#\">生产实习与社会实践</a></li>\r\n");
      out.write("                            <li><a href=\"#\">自主实践</a></li>\r\n");
      out.write("                        </ul></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--//mainContent-->\r\n");
      out.write("    <!--尾部bottom-->\r\n");
      out.write("    <div id=\"bottom\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/old_1/jsp/include/bottom.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--//bottom-->\r\n");
      out.write("</div>\r\n");
      out.write("<!--container-->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
