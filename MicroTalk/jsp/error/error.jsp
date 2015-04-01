<%@ page contentType="text/html; charset=utf-8" language="java" import="java.io.*" isErrorPage ="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>出错了！</title>
</head>
<body>
<p>出错了！</p>
<p>发生了以下错误：</p>
<hr />
<font color="red">
消息：<br/>
<%=exception.getMessage()%><br />
<hr />

堆栈：<br />
<%
StringWriter sw = new StringWriter();
PrintWriter pw = new PrintWriter(sw);
exception.printStackTrace(pw);
out.println(sw);
%>
<br />
</font>
</body>
</html>