package org.apache.jsp.jsp.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class help_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link href=\"/css/manageContent.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<!--[if lte IE 6]>\r\n");
      out.write("<link href=\"/css/contentButtonIE6.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<title>网工后台管理－帮助</title>\r\n");
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
      out.write("      <ul>\r\n");
      out.write("        <li><font style=\"font-size:15px; color:#0000FF; font-weight:bold;\">用户管理</font>\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"#regUser\" class=\"normalLink\">注册用户</a></li>\r\n");
      out.write("            <li><a href=\"#addUser\" class=\"normalLink\">添加用户</a></li>\r\n");
      out.write("            <li><a href=\"#delUser\" class=\"normalLink\">删除用户</a></li>\r\n");
      out.write("            <li><a href=\"#allowUser\" class=\"normalLink\">审核</a></li>\r\n");
      out.write("            <li><a href=\"#editUser\" class=\"normalLink\">修改用户权限</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("      <ul>\r\n");
      out.write("        <li><font style=\"font-size:15px; color:#0000FF; font-weight:bold;\">权限管理</font>\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"#superAdmin\" class=\"normalLink\">超级管理员</a></li>\r\n");
      out.write("            <li><a href=\"#admin\" class=\"normalLink\">管理员</a></li>\r\n");
      out.write("            <li><a href=\"#regedUser\" class=\"normalLink\">已注册的用户</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("            <ul>\r\n");
      out.write("        <li><font style=\"font-size:15px; color:#0000FF; font-weight:bold;\">其它</font>\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"#editAuthority\" class=\"normalLink\">修改权限</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("      <h2>用户管理</h2>\r\n");
      out.write("      <p><a id=\"regUser\" name=\"regUser\" style=\" font-size:15px; font-weight:bold\">注册用户</a> </p>\r\n");
      out.write("      <p>在<a href=\"/jsp/manage/\">&ldquo;后台管理&rdquo;首页</a>的登录框下点击&ldquo;<a href=\"/jsp/manage/users/register.jsp\">管理员注册</a>&rdquo;，并完成相关表单，则可以注册一个用户，注册成功之后的用户自动获得了&ldquo;<a href=\"#regedUser\">已注册用户</a>&rdquo;的身份。</p>\r\n");
      out.write("      <p><a name=\"addUser\" id=\"addUser\" style=\" font-size:15px; font-weight:bold\">添加用户</a></p>\r\n");
      out.write("      <p>如果你具有<a href=\"#superAdmin\">超级管理员</a>的身份，并且你被赋予了&rdquo;添加用户&rdquo;的权限，那么你就可以添加用户，在<a href=\"/jsp/manage/users/usersManage.jsp\">&ldquo;用户管理&rdquo;页面</a>（不是每个人都能打开这个页面的，如果你没有相应的身份和权限，你无法打开该页面）中点击上方的&rdquo;添加用户&ldquo;按钮，你就可以以超级管理员的身份主动添加一个用户并赋予权限，你也可以直接提升该用户为&ldquo;超级管理员&rdquo;。此用户不需要再注册，可以使用你添加的Email和密码直接登录，且该用户不需要再接受审核。</p>\r\n");
      out.write("      <p><a name=\"delUser\" id=\"delUser\"  style=\" font-size:15px; font-weight:bold\">删除用户</a></p>\r\n");
      out.write("      <p>如果你具有<a href=\"#superAdmin\">超级管理员</a>的身份，并且你被赋予了&rdquo;删除用户&ldquo;的权限，那么你可以在&ldquo;用户管理&rdquo;页面的每个用户后面看到一个&ldquo;删除用户&rdquo;按钮，点击此按钮并确认之后，就可以将该用户从数据库中彻底删除。</p>\r\n");
      out.write("      <p><a name=\"allowUser\" id=\"allowUser\"  style=\" font-size:15px; font-weight:bold\">审核</a></p>\r\n");
      out.write("      <p>如果你具有<a href=\"#superAdmin\">超级管理员</a>的身份，并且你被赋予了&ldquo;审核用户&rdquo;的权限，那么你可以在&ldquo;用户管理&rdquo;页面的每个新注册的用户后面看到一个&ldquo;审核&rdquo;按钮，点击该按钮后就可以对该用户进行审核，你可以根据用户注册时提供的身份确认信息选择要不要赋予其管理员的身份，以及赋予他哪些权限。如果此用户的条件不符合，你可以勾选&ldquo;不批准该用户成为管理员&rdquo;，这样该用户的信息就会从数据库中删除；如果此用户合格，不勾选&quot;不批准该用户成为管理员&quot;就算是审批通过，此时你可以赋予他相应的权限，如果你希望他具有用户管理和权限管理的权限，则可以勾选&ldquo;设置该用户为超级管理员&rdquo;。（超级管理员的权限很高，所以赋予该身份一定要慎重）。</p>\r\n");
      out.write("      <p><a name=\"editUser\" id=\"editUser\"  style=\" font-size:15px; font-weight:bold\">修改用户权限</a></p>\r\n");
      out.write("      <p>如果你具有<a href=\"#superAdmin\">超级管理员</a>的身份，并且你被赋予了&ldquo;修改用户权限&rdquo;的权限，那么你可以在&ldquo;用户管理&rdquo;页面的每个已审核用户后面看到一个&ldquo;修改权限&rdquo;按钮（你自己除外，你无法修改自己的权限，你自己的名字会以蓝色高亮显示），点击该按钮后就可以修改该用户的权限，勾选某个权限就是赋予用户该权限，你可以通过勾选&ldquo;设置该用户为超级管理员&rdquo;来使该用户成为超级管理员。</p>\r\n");
      out.write("      <h2>权限管理</h2>\r\n");
      out.write("      <p>本网站不设置专门的&ldquo;权限管理&rdquo;页面，权限管理被包含在用户管理中，通过修改、赋予权限等方式实现。</p>\r\n");
      out.write("      <p><a id=\"superAdmin\" name=\"superAdmin\" style=\" font-size:15px; font-weight:bold\">超级管理员</a> </p>\r\n");
      out.write("      <p>超级管理员是本网站后台管理系统中权限最高的用户，通过设置可以拥有一切权限，包括用户管理和权限管理的权限。一般用户是看不到&ldquo;用户管理&rdquo;的菜单项的，只有超级管理员可以看到。需要注意的是，并不是每个超级管理员都具有所有权限，&ldquo;超级&rdquo;的意义只是你可以拥有一切权限，但是否拥有这些权限还要看其它权限所有者是否赋予你这项权限。</p>\r\n");
      out.write("      <p><a id=\"admin\" name=\"admin\" style=\" font-size:15px; font-weight:bold\">管理员</a> </p>\r\n");
      out.write("      <p>管理员是本网站后台的普通用户，可以拥有超级管理员已经赋予的权限，但肯定不具备用户管理和权限管理的权限。如果你是一名管理员，你可以做你权限之内的事，对于你没有的权限，系统不会给你提供相应的链接，你也无法打开相应的页面。</p>\r\n");
      out.write("      <p><a id=\"regedUser\" name=\"regedUser\" style=\" font-size:15px; font-weight:bold\">已注册用户</a> </p>\r\n");
      out.write("      <p>已注册用户是只在后台进行注册的用户，但没有经过审核。你成为&ldquo;已注册用户&rdquo;后可以登录后台，<a href=\"/jsp/manage/\">修改自己的资料和密码</a>，但你没有任何进行其它操作的权限。当超级管理员对你的身份进行审核和确认时，他会赋予你相应的权限（如：发布新闻，发布通知，回复留言等）。在你获得这些普通权限之后，你就成为&rdquo;管理员&ldquo;，如果超级管理员还给予了你&rdquo;超级管理员&ldquo;的身份，你就成为&rdquo;超级管理员&ldquo;，此时，你可以进行用户管理和权限管理。</p>\r\n");
      out.write("      <h2>其它</h2>\r\n");
      out.write("      <p><a id=\"editAuthority\" name=\"editAuthority\" style=\" font-size:15px; font-weight:bold\">修改文章</a></p>\r\n");
      out.write("      <p>需要注意的是，在本网站管理系统中，&ldquo;修改文章（包括修改新闻，修改通知）&rdquo;指的是修改所有人的文章，如果是你自己发表的文章，不需要这个权限你也可以修改。删除文章也是如此，你有权删除自己的文章，无论你是否有删除文章的权限。</p>\r\n");
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
