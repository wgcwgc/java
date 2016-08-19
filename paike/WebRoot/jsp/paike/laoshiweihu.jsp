
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
  function update(id,i)
  	{
		form.action="WeihuServlet?laoshiUpdate=1&id="+id+"&i="+i;
		form.submit();
	}
	function del(id)
  	{
		form.action="WeihuServlet?laoshiDel=1&id="+id;
		form.submit();
	}
</script>

  <body bgcolor="#E1F0FF">
  <jsp:include page="/AllServlet"></jsp:include>
  <%
  ArrayList kecheng = (ArrayList)request.getAttribute("kecheng");
  ArrayList laoshi = (ArrayList)request.getAttribute("laoshi");
  %>
  <form name="form" method="post" action="">
  	<div align="center">
  	<font face="隶书" size="5">教师维护</font>
	<p>
  	<table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1" width="500">
  		<tr bgcolor="#F2DF91">
  			<td align="center">教师号</td>
  			<td align="center">姓名</td>
  			<td align="center">所教课程</td>
  			<td align="center">　</td>
  		</tr>
  		<%
  		if(laoshi != null && laoshi.size() != 0){
  			for(int i = 0;i < laoshi.size();i++){
  				ArrayList laoshiRow = (ArrayList)laoshi.get(i);
  		%>
  		<tr bgcolor="#FBEEC8">
  			<td align="center"><%=laoshiRow.get(0)%></td>
  			<td align="center"><%=laoshiRow.get(1)%></td>
  			<td align="center">
  			<select name="kecheng<%=i%>">
  			<%
  			if(kecheng != null && kecheng.size() != 0){
  				for(int j = 0;j < kecheng.size();j++){
  					ArrayList kechengRow = (ArrayList)kecheng.get(j);
  					if(kechengRow.get(0).equals(laoshiRow.get(2))){
  			%>
  			<option value="<%=kechengRow.get(0)%>" selected><%=kechengRow.get(1)%></option>
  			<%}else{%>
  			<option value="<%=kechengRow.get(0)%>"><%=kechengRow.get(1)%></option>
  			<%}}}%>
  			</select></td>
  			<td align="center"><input type="button" value="修改" onclick="update(<%=laoshiRow.get(0)%>,<%=i%>)">&nbsp;&nbsp; <input type="button" value="删除" onclick="del(<%=laoshiRow.get(0)%>)"></td>
  		</tr>
  		<%}}%>
	</table>
	</div>
	</form>
  </body>
</html>