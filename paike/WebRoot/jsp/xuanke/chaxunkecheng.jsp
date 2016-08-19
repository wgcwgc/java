
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="img/css.css" type="text/css" rel="stylesheet">
  </head>
 

  <body bgcolor="#E1F0FF">
  <%
  if(request.getSession().getAttribute("login") == null || request.getSession().getAttribute("login").equals("")){
  %>
  <script>alert('您还没有登陆!');window.navigate('/paike/jsp/login/xueshengLogin.jsp');</script>
  <%
  }else{
  	ArrayList login = (ArrayList)request.getSession().getAttribute("login");
  	if(login.get(2).equals("0")){
  	%>
  	<script>alert('您没有权限查看此网页!');window.navigate('/paike/jsp/login/xueshengLogin.jsp');</script>
  	<%
  	}}
  %>
  <jsp:include page="/AllServlet"></jsp:include>
  <%
  ArrayList xueshengchaxun = (ArrayList)request.getAttribute("xueshengchaxun");
  %>
  <form name="form" method="post" action="">
  	<div align="center">
  	<font face="隶书" size="5">查询课程</font><p>
  	<p><table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1" width="500">
  		<tr bgcolor="#F2DF91">
  			<td align="center">课程号</td>
  			<td align="center">课程名</td>
  			<td align="center">开始时间</td>
  			<td align="center">结束时间</td>
  			<td align="center">授课老师</td>
  		</tr>
  		<%
  		if(xueshengchaxun != null && xueshengchaxun.size() != 0){
  			for(int i = 0;i < xueshengchaxun.size();i++){
  				ArrayList al = (ArrayList)xueshengchaxun.get(i);
  		%>
  		<tr bgcolor="#FBEEC8">
  			<td align="center"><%=al.get(0)%></td>
  			<td align="center"><a href="XueshengChaxunServlet?kecheng=<%=al.get(0)%>&kechengid=1" title="点击查看详细信息"><%=al.get(1)%></a></td>
  			<td align="center"><%=al.get(2)%></td>
  			<td align="center"><%=al.get(3)%></td>
  			<td align="center"><a href="XueshengChaxunServlet?laoshi=<%=al.get(4)%>&laoshiid=1" title="点击查看详细信息"><%=al.get(5)%></a></td>
  		</tr>
  		<%}}%>
	</table></div>
	</form>
  </body>
</html>