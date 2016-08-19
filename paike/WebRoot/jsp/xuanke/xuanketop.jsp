
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Language" content="zh-cn">
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="img/css.css" type="text/css" rel="stylesheet">
  </head>
 

  <body bgcolor="#E1F0FF">
  	<div align="center">
  	<a href="jsp/xuanke/xuanke.jsp">选课</a>&nbsp;&nbsp; 
  	<a href="jsp/xuanke/tuike.jsp">退课</a>&nbsp;&nbsp; 
  	<a href="jsp/xuanke/xiugaipwd.jsp">修改密码</a>&nbsp;&nbsp; 
	<a href="XiugaipwdServlet?zhuxiao=1">注销退出</a></div>
  </body>
</html>