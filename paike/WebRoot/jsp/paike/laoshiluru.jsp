
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
  function chick()
			{
				if (document.form.name.value == "" ) 
				{
					alert("请输入姓名!");
					document.form.name.focus();
					return false;
				}
				else
				{
					form.action="LuruServlet?laoshi=1";
	  				form.submit();
				}
			}
</script>

  <body bgcolor="#E1F0FF">
  <jsp:include page="/AllServlet"></jsp:include>
  <%
  ArrayList kecheng = (ArrayList)request.getAttribute("kecheng");
  String laoshi = (String)request.getAttribute("laoshiluru");
  %>
  <form name="form" method="post" action="">
  	<div align="center">
  	<table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1">
  		<tr>
  			<td colspan="2" align="center"><font face="隶书" size="5">教师录入</font></td>
  		</tr>
  		<tr>
  			<td>姓&nbsp;&nbsp;&nbsp; 名：</td>
  			<td><input type="text" name="name" size="20"></td>
  		</tr>
  		<tr>
  			<td>所教课程：</td>
  			<td align="center">
  			<select name="kecheng">
  			<%
  			if(kecheng != null && kecheng.size() != 0){
  				for(int i = 0;i < kecheng.size();i++){
  					ArrayList kechengRow = (ArrayList)kecheng.get(i);
  			%>
  			<option value="<%=kechengRow.get(0)%>"><%=kechengRow.get(1)%></option>
  			<%}}%>
  			</select></td>
  		</tr>
  		<tr>
  			<td colspan="2" align="center">
			<input type="button" value="录入" onclick="chick()"></td>
  		</tr>
  		<%if(laoshi != null && laoshi.equals("1")){%>
  		<tr>
  			<td colspan="2" align="center">
			<font color="red">录入成功!</font></td>
  		</tr>
  		<%}%>
	</table>
	</div>
	</form>
  </body>
</html>