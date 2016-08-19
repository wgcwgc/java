
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
 <script language="JavaScript">
  function update(id,i)
  	{
		form.action="KechenganpaiServlet?kechenganpaiUpdate=1&id="+id+"&i="+i;
		form.submit();
	}
</script>

  <body bgcolor="#E1F0FF">
  <jsp:include page="/AllServlet"></jsp:include>
  <%
  ArrayList kechengtime = (ArrayList)request.getAttribute("kechengtime");
  String beginError = (String)request.getAttribute("beginError");
  String endError = (String)request.getAttribute("endError");
  %>
  <form name="form" method="post" action="">
  	<div align="center">
  	<font face="隶书" size="5">课程安排</font>
	<p>
  	<table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1" width="500">
  		<tr bgcolor="#F2DF91">
  			<td align="center">课程号</td>
  			<td align="center">课程名</td>
  			<td align="center">开始时间</td>
  			<td align="center">结束时间</td>
  			<td align="center" bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE"> </td>
  		</tr>
  		<%
  		if(kechengtime != null && kechengtime.size() != 0){
  			for(int i = 0;i < kechengtime.size();i++){
  				ArrayList kechengtimeRow = (ArrayList)kechengtime.get(i);
  				String[] begin = null;
  				if(kechengtimeRow.get(2) != null && !kechengtimeRow.get(2).equals("")){
  					begin = kechengtimeRow.get(2).toString().split("-");
  				}
  				String[] end = null;
  				if(kechengtimeRow.get(3) != null && !kechengtimeRow.get(3).equals("")){
  					end = kechengtimeRow.get(3).toString().split("-");
  				}
  		%>
  		<tr bgcolor="#FBEEC8">
  			<td align="center"><%=kechengtimeRow.get(0)%></td>
  			<td align="center"><%=kechengtimeRow.get(1)%></td>
  			<td align="center">
  			<select size="1" name="beginyue<%=i%>">
  			<%
  			for(int a = 1; a < 13;a++){
  				if(begin != null && begin[1].equals(""+a)){
  			%>
  			<option value="<%=a%>" selected><%=a%></option>
  			<%}else{%>
  			<option value="<%=a%>"><%=a%></option>
  			<%}}%>
  			</select>月
  			<select size="1" name="beginri<%=i%>">
  			<%
  			for(int a = 1; a < 32;a++){
  				if(begin != null && begin[2].equals(""+a)){
  			%>
  			<option value="<%=a%>" selected><%=a%></option>
  			<%}else{%>
  			<option value="<%=a%>"><%=a%></option>
  			<%}}%>
  			</select>日</td>
  			<td align="center">
  			<select size="1" name="endyue<%=i%>">
  			<%
  			for(int a = 1; a < 13;a++){
  				if(end != null && end[1].equals(""+a)){
  			%>
  			<option value="<%=a%>" selected><%=a%></option>
  			<%}else{%>
  			<option value="<%=a%>"><%=a%></option>
  			<%}}%>
  			</select>月
  			<select size="1" name="endri<%=i%>">
  			<%
  			for(int a = 1; a < 32;a++){
  				if(end != null && end[2].equals(""+a)){
  			%>
  			<option value="<%=a%>" selected><%=a%></option>
  			<%}else{%>
  			<option value="<%=a%>"><%=a%></option>
  			<%}}%>
  			</select>日</td>
  			<td align="center"><input type="button" value="提交" onclick="update(<%=kechengtimeRow.get(0)%>,<%=i%>)"></td>
  		</tr>
  		<%}}%>
  		<%if(beginError != null && beginError.equals("1")){%>
  		<font color="red">开 始 时 间 选 择 错 误!</font>
  		<%}%>
  		<%if(endError != null && endError.equals("1")){%>
  		<font color="red">结 束 时 间 选 择 错 误!</font>
  		<%}%>
	</table>
	</div>
	</form>
  </body>
</html>