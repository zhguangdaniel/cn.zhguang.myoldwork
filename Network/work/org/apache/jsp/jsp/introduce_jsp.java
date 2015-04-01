package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class introduce_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>网工－专业概况</title>\r\n");
      out.write("<link href=\"/css/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"/css/blueprint.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!--头部header-->\r\n");
      out.write("<div class=\"header\">\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/header.jsp", out, true);
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!--//header-->\r\n");
      out.write("<!--主体容器container-->\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("  <!--内容区content，包括菜单和主内容-->\r\n");
      out.write("  <div class=\"content\">\r\n");
      out.write("    <!--左边内容框leftContentFrame-->\r\n");
      out.write("    <div class=\"leftContentFrame\">\r\n");
      out.write("      <!--左边菜单框leftMenuFrame-->\r\n");
      out.write("      <div class=\"leftMenuFrame\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/leftMenu.jsp", out, true);
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      <!--//leftMenuFrame-->\r\n");
      out.write("      <div class=\"imgLinksFrame\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/imgLinks.jsp", out, true);
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"customLinksFrame\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/customLinks.jsp", out, true);
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--右边内容框rightContentFrame-->\r\n");
      out.write("    <div class=\"rightContentFrame\">\r\n");
      out.write("      <div class=\"breadcrumbs\"> <a href=\"/\">首页</a> &nbsp;&gt;&nbsp;专业简介 </div>\r\n");
      out.write("      <div id = \"blueprintFrame\">\r\n");
      out.write("        <h1>网络工程专业概况 </h1>\r\n");
      out.write("        <p style=\"font-family: '楷体_GB2312'; font-size: 14px; text-align: center; color: #F60;\">（2009）</p>\r\n");
      out.write("        <h2>一、培养目标</h2>\r\n");
      out.write("        <p>培养德、智、体、美、劳全面发展，具有良好综合素质和开拓创新能力，系统掌握本专业的基本理论、基础知识和基本技能与方法，具有实际应用和科学研究能力的计算机网络及其相关技术与产业领域的复合型应用技术人才 。</p>\r\n");
      out.write("        <h2>二、培养要求</h2>\r\n");
      out.write("        <p>系统掌握计算机网络方面的基本理论、基础知识和基本技能和方法，受到良好的科学思维和科学实验的基本训练。对计算机网络的技术发展及其应用前景有较好的理解，受到网络技术应用方法和开发技能的一定的训练，具有较强的计算机网络应用系统分析和设计能力。 </p>\r\n");
      out.write("        <p>注重德、智、体、美、劳全面发展，掌握所必需的人文科学和自然科学的基本知识，并具有学习与应用这些知识的基本能力。具有一定的科学研究、应用研究、科技开发和解决一般实际问题的能力。掌握一门外语，能熟练查阅本专业有关外文资料。</p>\r\n");
      out.write("        <h2>三、培养对象</h2>\r\n");
      out.write("        <p>学历层次为本科四年。 </p>\r\n");
      out.write("        <h2>四、师资情况</h2>\r\n");
      out.write("        <p>a．本专业在编教师总数35人。其中：正教授9人，占26%；副教授16人，占46%；讲师8人，占22%；助教2人，占6%； </p>\r\n");
      out.write("        <p>b．高资历教师：国家教学指导委员会会员1人，博士生导师5人。</p>\r\n");
      out.write("        <p> c．45岁以下教师21人，其中，博士7人，占45岁以下教师比例33%；硕士14人，占45岁以下教师比例67%； </p>\r\n");
      out.write("        <p>d．为本科生主讲专业及专业基础课的教师数为32人，其中正副教授22人，所占比例为69%。</p>\r\n");
      out.write("        <p> e．省、部级重点培养教师数1人；“千百十”之“千”数3人；校级重点培养教师数3人。 </p>\r\n");
      out.write("        <p>f．省、部级先进教师数4人。 </p>\r\n");
      out.write("        <p>g．使用英语授课课程门数3门；课程名称：通讯网络、计算机体系结构、电子商务。 </p>\r\n");
      out.write("        <p>（<font color=\"#FF0000\">注：</font>博士、硕士指已获得学位者，不含课程进修班和在读博士生、硕士生。）</p>\r\n");
      out.write("        <h2>五、主干学科</h2>\r\n");
      out.write("        <p>计算机网络工程 </p>\r\n");
      out.write("        <h2>六、主要课程</h2>\r\n");
      out.write("        <p>高等数学、离散数学、计算机组成原理、程序设计、数据结构与算法、操作系统、计算机网络、数据库系统、网络与信息安全、软件体系结构、并行与分布计算、ATM交换技术、B-ISDN原理、计算机接口技术、数理逻辑、数据安全与密码学、软件工程、人工智能、分布式系统、网络协议、计算机协同工作、计算机通信、移动计算、企业计算环境、Internet与Intranet技术等。</p>\r\n");
      out.write("        <p>三年级将安排相关的课程设计或社会实践，以加强学生的实践能力与开拓能力。高年级同学还可以选修本学院其它专业的相关课程。 </p>\r\n");
      out.write("        <h2>七、主要实践性教学环节</h2>\r\n");
      out.write("        <p>主要课程均安排相应的实验与实习，部分主干课和专业课安排课程设计或课程论文，第八学期安排不少于十周的毕业论文。</p>\r\n");
      out.write("        <p>（<font color=\"#FF0000\">注：</font>实验课程的教学大纲详见《计算机网络工程专业教学计划》） </p>\r\n");
      out.write("        <h2>八、主要专业实践</h2>\r\n");
      out.write("        <p>软件系统分析、设计及实现；课程设计；产业调研与生产实践；参加相关的学术活动与学术竞赛；参加科学研究和应用开发项目；毕业论文。 </p>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--//rightContentFrame-->\r\n");
      out.write("  </div>\r\n");
      out.write("  <!--content-->\r\n");
      out.write("</div>\r\n");
      out.write("<!--container-->\r\n");
      out.write("<!--底部bottom-->\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/include/footer.jsp", out, true);
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!--//bottom-->\r\n");
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
