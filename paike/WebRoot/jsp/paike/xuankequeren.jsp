
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
 <script language="JavaScript">
  function chick(i)
	{
		form.action="XuankeQuerenServlet?i="+i;
		form.submit();
	}
</script>

  <body bgcolor="#E1F0FF">
  <%
  if(request.getSession().getAttribute("login") == null || request.getSession().getAttribute("login").equals("")){
  %>
  <script>alert('您还没有登陆!');window.navigate('/paike/jsp/login/xueshengLogin.jsp');</script>
  <%
  }else{
  	ArrayList login = (ArrayList)request.getSession().getAttribute("login");
  	if(!login.get(2).equals("0")){
  	%>
  	<script>alert('您没有权限查看此网页!');window.navigate('/paike/jsp/login/xueshengLogin.jsp');</script>
  	<%
  	}}
  %>
  <jsp:include page="/AllServlet"></jsp:include>
  <%
  ArrayList xuanke = (ArrayList)request.getAttribute("xuanke");
  String queren = (String)request.getAttribute("queren");
  %>
  <form name="form" method="post" action="">
  	<div align="center">
  	<table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1" width="500">
  		<tr>
  			<td colspan="3" align="center"><font face="隶书" size="5">选课确认</font></td>
  		</tr>
  		<tr>
  			<td align="center">学号</td>
  			<td align="center">姓名</td>
  			<td align="center">所选课程</td>
  		</tr>
  		<%
  		int i = 0;
  		if(xuanke != null && xuanke.size() != 0){
  			for(i = 0;i < xuanke.size();i++){
  				ArrayList alRow = (ArrayList)xuanke.get(i);
  		%>
  		<input type="hidden" name="xuankeid<%=i%>" value="<%=alRow.get(0)%>"/>
  		<tr>
  			<td align="center"><%=alRow.get(1)%></td>
  			<td align="center"><%=alRow.get(2)%></td>
  			<td align="center"><%=alRow.get(3)%></td>
  		</tr>
  		<%}%>
  		<tr>
  			<td align="center" colspan="3">
			<input type="button" value="选课确认" onclick="chick(<%=i%>)"></td>
  		</tr>
  		<%}%>
  		<%if(queren != null && queren.equals("1")){%>
  		<tr>
  			<td align="center" colspan="3">
  			<font color="red">选课已经确认！</font>
			</td>
  		</tr>
  		<%}%>
	</table>
	</div>
	</form>
  </body>
</html>