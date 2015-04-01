<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注销</title>
</head>

<body>
<%
session.setAttribute("isLog",new String("0"));
session.invalidate();
response.sendRedirect("/jsp/manage/");
%>
<center><p>正在注销...</p></center>
</body>
</html>