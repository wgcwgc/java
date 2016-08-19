
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
  function zhuanye1()
  	{
		form.action="KebiaochaxunServlet?zhuanyeid=1";
		form.submit();
	}
  function kecheng1()
  	{
		form.action="KebiaochaxunServlet?kechengid=1";
		form.submit();
	}
  function nianji1()
  	{
		form.action="KebiaochaxunServlet?nianjiid=1";
		form.submit();
	}
  function banji1()
  	{
		form.action="KebiaochaxunServlet?banjiid=1";
		form.submit();
	}
  function xingxi1()
  	{
		form.action="KebiaochaxunServlet?xingqiid=1";
		form.submit();
	}
  function laoshi1()
  	{
		form.action="KebiaochaxunServlet?laoshiid=1";
		form.submit();
	}
  function kejie1()
  	{
		form.action="KebiaochaxunServlet?kejieid=1";
		form.submit();
	}
  function jiaoshi1()
  	{
		form.action="KebiaochaxunServlet?jiaoshiid=1";
		form.submit();
	}
</script>

  <body bgcolor="#E1F0FF">
  <%
  if(request.getSession().getAttribute("login") == null || request.getSession().getAttribute("login").equals("")){
  %>
  <script>alert('您还没有登陆!');window.navigate('/paike/jsp/login/xueshengLogin.jsp');</script>
  <%}%>
  <jsp:include page="/AllServlet"></jsp:include>
  <%
  ArrayList zhuanye = (ArrayList)request.getAttribute("zhuanye");
  ArrayList jiaoshi = (ArrayList)request.getAttribute("jiaoshi");
  ArrayList laoshi = (ArrayList)request.getAttribute("laoshi");
  ArrayList kecheng = (ArrayList)request.getAttribute("kecheng");
  ArrayList banji = (ArrayList)request.getAttribute("banji");
  ArrayList list = (ArrayList)request.getAttribute("list");
  %>
  <form name="form" method="post" action="">
  	<div align="center">
  	<font face="隶书" size="5">课程表查询</font><br><br>
	<table border="1" bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE">
		<tr>
			<td>专业：<select size="1" name="zhuanye">
	<%
  	if(zhuanye != null && zhuanye.size() != 0){
  		for(int i = 0;i < zhuanye.size();i++){  		
  			ArrayList zhuanyeRow = (ArrayList)zhuanye.get(i);
  	%>
  	<option value="<%=zhuanyeRow.get(0)%>"><%=zhuanyeRow.get(1)%></option>
  	<%}}%>
	</select>
	</td>
			<td align="center"> 
	<input type="button" value="查询" onclick="zhuanye1()"></td>
			<td align="center"> 
		课程：<select name="kecheng">
			<%
			if(kecheng != null && kecheng.size() != 0){
				for(int i = 0;i < kecheng.size();i++){
					ArrayList kechengRow = (ArrayList)kecheng.get(i);
			%>
			<option value="<%=kechengRow.get(0)%>"><%=kechengRow.get(1)%></option>
			<%}}%>
			</select></td>
			<td align="center"><input type="button" value="查询" onclick="kecheng1()"></td>
		</tr>
		<tr>
			<td>年级：<select size="1" name="nianji">
			<option value="一年">一年级</option>
			<option value="二年">二年级</option>
			<option value="三年">三年级</option>
			<option value="四年">四年级</option>
			</select></td>
			<td align="center"><input type="button" value="查询" onclick="nianji1()"></td>
			<td align="center">班级：<select name="banji">
			<%
			if(banji != null && banji.size() != 0){
				for(int i = 0;i < banji.size();i++){
					ArrayList banjiRow = (ArrayList)banji.get(i);
			%>
			<option value="<%=banjiRow.get(0)%>"><%=banjiRow.get(1)%></option>
			<%}}%>
			</select></td>
			<td align="center"><input type="button" value="查询" onclick="banji1()"></td>
		</tr>
		<tr>
			<td>星期：<select size="1" name="xingqi">
			<option value="0">星期一</option>
			<option value="1">星期二</option>
			<option value="2">星期三</option>
			<option value="3">星期四</option>
			<option value="4">星期五</option>
			</select></td>
			<td align="center"><input type="button" value="查询" onclick="xingxi1()"></td>
			<td align="center">老师：<select name="laoshi">
			<%
			if(laoshi != null && laoshi.size() != 0){
				for(int i = 0;i < laoshi.size();i++){
					ArrayList laoshiRow = (ArrayList)laoshi.get(i);
			%>
			<option value="<%=laoshiRow.get(0)%>"><%=laoshiRow.get(1)%></option>
			<%}}%>
			</select></td>
			<td align="center"><input type="button" value="查询" onclick="laoshi1()"></td>
		</tr>
		<tr>
			<td>课节：<select size="1" name="kejie">
			<option value="0">第一节课</option>
			<option value="1">第二节课</option>
			<option value="2">第三节课</option>
			<option value="3">第四节课</option>
			<option value="4">第五节课</option>
			<option value="5">第六节课</option>
			</select></td>
			<td align="center"><input type="button" value="查询" onclick="kejie1()"></td>
			<td align="center">教室：<select name="jiaoshi">
			<%
			if(jiaoshi != null && jiaoshi.size() != 0){
				for(int i = 0;i < jiaoshi.size();i++){
					ArrayList jiaoshiRow = (ArrayList)jiaoshi.get(i);
			%>
			<option value="<%=jiaoshiRow.get(0)%>"><%=jiaoshiRow.get(1)%></option>
			<%}}%>
			</select></td>
			<td align="center"><input type="button" value="查询" onclick="jiaoshi1()"></td>
		</tr>
		</table>
	<p>
  	<table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1" width="600">
  		<tr bgcolor="#F2DF91">
  			<td align="center">专业</td>
  			<td align="center">年级</td>
  			<td align="center">星期</td>
  			<td align="center">第几节课</td>
  			<td align="center">课程</td>
  			<td align="center">班级</td>
  			<td align="center">老师</td>
  			<td align="center">教室</td>
  		</tr>
  		<%
  		if(list != null && list.size() != 0){
  			for(int i = 0;i < list.size();i++){
  				ArrayList listRow = (ArrayList)list.get(i);
  		%>
  		<tr bgcolor="#FBEEC8">
  		<%
  		if(zhuanye != null && zhuanye.size() != 0){
  			for(int j = 0;j < zhuanye.size();j++){
  				ArrayList zhuanyeRow = (ArrayList)zhuanye.get(j);
  				if(zhuanyeRow.get(0).equals(listRow.get(1))){
  		%>
  			<td align="center"><%=zhuanyeRow.get(1)%></td>
  			<%break;}}}%>
  			<td align="center"><%=listRow.get(2)%></td>
  			<td align="center">星期<%=Integer.parseInt(listRow.get(3).toString())+1%></td>
  			<td align="center">第<%=Integer.parseInt(listRow.get(4).toString())+1%>节课</td>
  			<%
  			if(kecheng != null && kecheng.size() != 0){
	  			for(int j = 0;j < kecheng.size();j++){
	  				ArrayList kechengRow = (ArrayList)kecheng.get(j);
	  				if(kechengRow.get(0).equals(listRow.get(5))){
  			%>
  			<td align="center"><%=kechengRow.get(1)%></td>
  			<%break;}}}%>
  			<%
  			if(banji != null && banji.size() != 0){
	  			for(int j = 0;j < banji.size();j++){
	  				ArrayList banjiRow = (ArrayList)banji.get(j);
	  				if(banjiRow.get(0).equals(listRow.get(6))){
  			%>
  			<td align="center"><%=banjiRow.get(1)%></td>
  			<%break;}}}%>
  			<%
  			if(laoshi != null && laoshi.size() != 0){
	  			for(int j = 0;j < banji.size();j++){
	  				ArrayList laoshiRow = (ArrayList)laoshi.get(j);
	  				if(laoshiRow.get(0).equals(listRow.get(7))){
  			%>
  			<td align="center"><%=laoshiRow.get(1)%></td>
  			<%break;}}}%>
  			<%
  			if(jiaoshi != null && jiaoshi.size() != 0){
	  			for(int j = 0;j < jiaoshi.size();j++){
	  				ArrayList jiaoshiRow = (ArrayList)jiaoshi.get(j);
	  				if(jiaoshiRow.get(0).equals(listRow.get(8))){
  			%>
  			<td align="center"><%=jiaoshiRow.get(1)%></td>
  			<%break;}}}%>
  		</tr>
  		<%}}%>	
	</table>	
	</div>
	</form>
  </body>
</html>