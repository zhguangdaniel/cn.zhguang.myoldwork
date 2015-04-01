package org.apache.jsp.jsp.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class versionHistory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			"/jsp/error/error.jsp", true, 8192, true);
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
      out.write("<link href=\"/css/manage.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<!--[if lte IE 6]>\r\n");
      out.write("<link href=\"/css/contentButtonIE6.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<title>网工后台管理－版本历史</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	boolean isLog = false;
		try {
		isLog = ((String) session.getAttribute("isLog")).equals("1");//获得用户是否已经登录的消息
	} catch (Exception e) {
	}
	if (!isLog) {
		session.setAttribute("isLog",new String("0"));
		session.setAttribute("loginMsg", new String("您还未登录，请先登录！"));
		response.sendRedirect("/jsp/manage/");
	}else{

      out.write("\r\n");
      out.write("<!--全部区域-->\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("  <!--头部-->\r\n");
      out.write("  <div id=\"header\">\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/header.jsp", out, true);
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("  <!--主区，包括菜单区（垂直导航条）和工作区-->\r\n");
      out.write("  <div id=\"mainContent\">\r\n");
      out.write("    <div id=\"leftMenu\">\r\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/leftMenu.jsp", out, true);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"rightMain\">\r\n");
      out.write("      <div class=\"versionHistory\">\r\n");
      out.write("        <table align=\"center\" width=\"100%\" cellpadding=\"2\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td colspan=\"4\" height=\"30px\" id=\"bar\" style=\"text-align:center;border:solid 0 #AAA; border-width:0 0 1px;\">版本历史</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"5%\" rowspan=\"2\" style=\"border:solid 0 #AAA; border-width:0 1px 1px 0;\">1</td>\r\n");
      out.write("            <td width=\"12%\" style=\"border:solid 0 #AAA; border-width:0 1px 1px 0;\">2009年9月</td>\r\n");
      out.write("            <td width=\"18%\" style=\"border:solid 0 #AAA; border-width:0 1px 1px 0;\">前台1.0版，后台1.0版</td>\r\n");
      out.write("            <td align=\"left\" style=\"border:solid 0 #AAA; border-width:0 0 1px;\">初始开发</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"left\" colspan=\"3\" valign=\"middle\" style=\"border:solid 0 #AAA; border-width:0 0 1px;\"><ul>\r\n");
      out.write("              </ul></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"5%\" rowspan=\"2\" style=\"border:solid 0 #AAA; border-width:0 1px 1px 0;\">2</td>\r\n");
      out.write("            <td width=\"12%\" style=\"border:solid 0 #AAA; border-width:0 1px 1px 0;\">2009年9月</td>\r\n");
      out.write("            <td width=\"18%\" style=\"border:solid 0 #AAA; border-width:0 1px 1px 0;\">前台1.1版，后台1.0版</td>\r\n");
      out.write("            <td align=\"left\" style=\"border:solid 0 #AAA; border-width:0 0 1px;\">内部测试，针对测试中出现的Bug进行小规模修改</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"left\" colspan=\"3\" valign=\"middle\" style=\"border:solid 0 #AAA; border-width:0 0 1px;\"><ul>\r\n");
      out.write("              </ul></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"5%\" rowspan=\"2\" style=\"border:solid 0 #AAA; border-width:0 1px 1px 0;\">3</td>\r\n");
      out.write("            <td width=\"12%\" style=\"border:solid 0 #AAA; border-width:0 1px 1px 0;\">2009年10月</td>\r\n");
      out.write("            <td width=\"18%\" style=\"border:solid 0 #AAA; border-width:0 1px 1px 0;\">前台1.2版，后台1.1版</td>\r\n");
      out.write("            <td align=\"left\" style=\"border:solid 0 #AAA; border-width:0 0 1px;\">试运行，针对前期运行阶段出现的问题进行修改和维护</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"left\" colspan=\"3\" valign=\"middle\" style=\"border:solid 0 #AAA; border-width:0 0 1px;\"><ul>\r\n");
      out.write("                <li>调整前台首页布局</li>\r\n");
      out.write("                <li>增加访问统计</li>\r\n");
      out.write("                <li>修改文件下载时出现乱码的Bug</li>\r\n");
      out.write("                <li>发表新闻或通知时可以上传本地图片或文件</li>\r\n");
      out.write("              </ul></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"5%\" rowspan=\"2\" style=\"border:solid 0 #AAA; border-width:0 1px 1px 0;\">4</td>\r\n");
      out.write("            <td width=\"12%\" style=\"border:solid 0 #AAA; border-width:0 1px 1px 0;\">2010年2月</td>\r\n");
      out.write("            <td width=\"18%\" style=\"border:solid 0 #AAA; border-width:0 1px 1px 0;\">前台2.0版，后台1.2版</td>\r\n");
      out.write("            <td align=\"left\" style=\"border:solid 0 #AAA; border-width:0 0 1px;\">较大规模升级</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"left\" colspan=\"3\" valign=\"middle\" style=\"border:solid 0 #AAA; border-width:0 0 1px;\"><ul>\r\n");
      out.write("                <li>前台界面重新设计并对某些页面进行重写</li>\r\n");
      out.write("                <li>前台、后台增加搜索功能</li>\r\n");
      out.write("                <li>前台增加访客留言功能</li>\r\n");
      out.write("                <li>后台增加用户注册功能，允许多个管理员的存在</li>\r\n");
      out.write("                <li>后台增加用户管理和权限管理功能</li>\r\n");
      out.write("                <li>后台增加留言管理功能</li>\r\n");
      out.write("                <li>后台增加发布首页公告功能</li>\r\n");
      out.write("              </ul></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"5%\" rowspan=\"2\" style=\"border:solid 0 #AAA; border-width:0 1px 1px 0;\">5</td>\r\n");
      out.write("            <td width=\"12%\" style=\"border:solid 0 #AAA; border-width:0 1px 1px 0;\">2010年8月</td>\r\n");
      out.write("            <td width=\"18%\" style=\"border:solid 0 #AAA; border-width:0 1px 1px 0;\">前台2.1版，后台1.3版</td>\r\n");
      out.write("            <td align=\"left\" style=\"border:solid 0 #AAA; border-width:0 0 1px;\">添加部分功能，修改一些小bug</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"left\" colspan=\"3\" valign=\"middle\" style=\"border:solid 0 #AAA; border-width:0 0 1px;\"><ul>\r\n");
      out.write("                <li>所有源代码改为UTF-8编码</li>\r\n");
      out.write("                <li>解决改变编码后文章发布和文件上传时的乱码问题</li>\r\n");
      out.write("                <li>增加用户验证，使得未授予权限的管理员只能修改自己发布的内容，不能修改他人的内容</li>\r\n");
      out.write("                <li>增加用户唯一性验证，保证Email和用户名不重复</li>\r\n");
      out.write("                <li>解决了验证码难以辨认的问题</li>\r\n");
      out.write("                <li>后台增加“版本历史”页面</li>\r\n");
      out.write("                <li>修改了前台“友情链接”的bug</li>\r\n");
      out.write("                <li>修改了邮箱地址不支持gmail点分邮箱的bug</li>\r\n");
      out.write("              </ul></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div id=\"bottom\">\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/manage/include/bottom.jsp", out, true);
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
	
	}

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
