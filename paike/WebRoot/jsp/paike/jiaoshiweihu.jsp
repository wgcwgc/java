
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
		form.action="WeihuServlet?jiaoshiUpdate=1&id="+id+"&i="+i;
		form.submit();
	}
	function del(id)
  	{
		form.action="WeihuServlet?jiaoshiDel=1&id="+id;
		form.submit();
	}
</script>

  <body bgcolor="#E1F0FF">
  <jsp:include page="/AllServlet"></jsp:include>
  <%
  ArrayList jiaoshi = (ArrayList)request.getAttribute("jiaoshi");
  %>
  <form name="form" method="post" action="">
  	<div align="center">
  	<font face="隶书" size="5">教室维护</font>
	<p>
  	<table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1" width="500">
  		<tr bgcolor="#F2DF91">
  			<td align="center">教室号</td>
  			<td align="center">教室名</td>
  			<td align="center">容纳人数</td>
  			<td align="center">　</td>
  		</tr>
  		<%
  		if(jiaoshi != null && jiaoshi.size() != 0){
  			for(int i = 0;i < jiaoshi.size();i++){
  				ArrayList jiaoshiRow = (ArrayList)jiaoshi.get(i);
  		%>
  		<tr bgcolor="#FBEEC8">
  			<td align="center"><%=jiaoshiRow.get(0)%></td>
  			<td align="center"><%=jiaoshiRow.get(1)%></td>
  			<td align="center">
  			<input type="text" name="renshu<%=i%>" size="10" value="<%=jiaoshiRow.get(2)%>"></td>
  			<td align="center"><input type="button" value="修改" onclick="update(<%=jiaoshiRow.get(0)%>,<%=i%>)">&nbsp;&nbsp; <input type="button" value="删除" onclick="del(<%=jiaoshiRow.get(0)%>)"></td>
  		</tr>
  		<%}}%>
	</table>
	</div>
	</form>
  </body>
</html>