
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
  </head>
   <body>
   
  <div align="center">
	<table border="0" width="800" cellspacing="0" cellpadding="0" id="table1" bgcolor="#E1F0FF">
		<tr>
			<td colspan="3" align="center"><jsp:include page="top.jsp"/></td>
		</tr>
		<tr>
			<td colspan="3"><hr></td>
		</tr>
		<tr>
			<td width="150" align="center" valign="top">
			<iframe name="muluFrame" src="jsp/mulu.jsp" align="middle" width="150" height="366" border="0" frameborder="0">浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe></td>
			<td background="img/bj_x.gif" width="2"></td>
			<td align="center" valign="top">
			<iframe name="mainFrame" width="640" height="530" src="jsp/login/xueshengLogin.jsp" border="0" frameborder="0">浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe></td>
		</tr>
	</table>
	</div>
   
  </body>
</html>
