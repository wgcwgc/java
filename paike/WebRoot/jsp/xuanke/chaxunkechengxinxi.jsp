
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
  function laoshichaxun()
  	{
		form.action="XueshengChaxunServlet?laoshiid=1";
		form.submit();
	}
  function kechengchaxun()
  	{
		form.action="XueshengChaxunServlet?kechengid=1";
		form.submit();
	}
  function kebiaochaxun()
  	{
		form.action="jsp/paike/kebiaochaxun.jsp";
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
  	if(login.get(2).equals("0")){
  	%>
  	<script>alert('您没有权限查看此网页!');window.navigate('/paike/jsp/login/xueshengLogin.jsp');</script>
  	<%
  	}}
  %>
  <jsp:include page="/AllServlet"></jsp:include>
  <%
  ArrayList laoshi = (ArrayList)request.getAttribute("laoshi");
  ArrayList kecheng = (ArrayList)request.getAttribute("kecheng");
  ArrayList kechenglist = (ArrayList)request.getAttribute("kechenglist");
  ArrayList kebiaolist = (ArrayList)request.getAttribute("kebiaolist");
  %>
  <form name="form" method="post" action="">
  	<div align="center">
  	<font face="隶书" size="5">查询课程信息</font><p>
	<table border="1" bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" id="table1">
		<tr>
			<td>按老师查询：<select size="1" name="laoshi">
			<%
			if(laoshi != null && laoshi.size() != 0){
				for(int i = 0;i < laoshi.size();i++){
					ArrayList laoshiRow = (ArrayList)laoshi.get(i);
			%>
			<option value="<%=laoshiRow.get(0)%>"><%=laoshiRow.get(1)%></option>
			<%}}%>
			</select></td>
			<td><input type="button" value="查询" onclick="laoshichaxun()"></td>
		</tr>
		<tr>
			<td>按课程查询：<select size="1" name="kecheng">
			<%
			if(kecheng != null && kecheng.size() != 0){
				for(int i = 0;i < kecheng.size();i++){
					ArrayList kechengRow = (ArrayList)kecheng.get(i);
			%>
			<option value="<%=kechengRow.get(0)%>"><%=kechengRow.get(1)%></option>
			<%}}%>
			</select></td>
			<td><input type="button" value="查询" onclick="kechengchaxun()"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button" value="查询课程表" onclick="kebiaochaxun()"></td>
		</tr>
	</table>
  	<p>
	<table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1" width="600">
  		<tr bgcolor="#F2DF91">
  			<td align="center">课程号</td>
  			<td align="center">课程名</td>
  			<td align="center">开始时间</td>
  			<td align="center">结束时间</td>
  			<td align="center">教学周</td>
  			<td align="center">总课时</td>
  			<td align="center">专业</td>
  			<td align="center">开课年级</td>
  			<td align="center">授课老师</td>
  		</tr>
  		<%
  		if(kechenglist != null && kechenglist.size() != 0){
	  		for(int i = 0;i < kechenglist.size();i++){
	  			ArrayList kechenglistRow = (ArrayList)kechenglist.get(i);
  		%>
   		<tr bgcolor="#FBEEC8">
  			<td align="center"><%=kechenglistRow.get(0)%></td>
  			<td align="center"><%=kechenglistRow.get(1)%></td>
  			<td align="center"><%=kechenglistRow.get(2)%></td>
  			<td align="center"><%=kechenglistRow.get(3)%></td>
  			<td align="center"><%=kechenglistRow.get(4)%></td>
  			<td align="center"><%=kechenglistRow.get(5)%></td>
  			<td align="center"><%=kechenglistRow.get(6)%></td>
  			<td align="center"><%=kechenglistRow.get(7)%>级</td>
  			<td align="center"><%=kechenglistRow.get(8)%></td>
  		</tr>
  		<%}}%>
  		<tr bgcolor="#FBEEC8">
  			<td align="center" colspan="9">
			<table border="1" bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" id="table2" width="100%">
				<tr>
					<td colspan="5" align="center">课程安排</td>
				</tr>
				<tr bgcolor="#F2DF91">
					<td align="center">星期</td>
					<td align="center">课节</td>
					<td align="center">班级</td>
					<td align="center">老师</td>
					<td align="center">教室</td>
				</tr>
				<%
				if(kebiaolist != null && kebiaolist.size() != 0){
	  				for(int i = 0;i < kebiaolist.size();i++){
	  					ArrayList kebiaolistRow = (ArrayList)kebiaolist.get(i);
  				%>
				<tr>
					<td align="center">星期<%=Integer.parseInt(kebiaolistRow.get(0).toString())+1%></td>
					<td align="center">第<%=Integer.parseInt(kebiaolistRow.get(1).toString())+1%>节课</td>
					<td align="center"><%=kebiaolistRow.get(2)%></td>
					<td align="center"><%=kebiaolistRow.get(3)%></td>
					<td align="center"><%=kebiaolistRow.get(4)%></td>
				</tr>
				<%}}else{%>
				<tr><td colspan="5" align="center"><font color="red">本课程还没有安排课表！</font></td></tr>
				<%}%>
			</table>
			</td>
  		</tr>
	</table>
	</div>
	</form>
  </body>
</html>