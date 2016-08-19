
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
				if (document.form.username.value == "" ) 
				{
					alert("ÇëÊäÈëÕÊºÅ!");
					document.form.username.focus();
					return false;
				}
				if (document.form.userpwd.value == "" ) 
				{
					alert("ÇëÊäÈëÃÜÂë!");
					document.form.userpwd.focus();
					return false;
				}
				if (isNaN(document.form.userpwd.value)) 
				{
					alert("ÃÜÂë±ØĞëÊÇÊı×Ö!");
					document.form.userpwd.focus();
					return false;
				}
				else
				{
					form.action="LoginServlet?admin=1";
	  				form.submit();
				}
			}
			function reg()
			{
				form.action="jsp/login/reg.jsp";
	  			form.submit();
			}
</script>

  <body bgcolor="#E1F0FF">
  <%
  String admin = (String)request.getAttribute("admin");
  %>
  <form name="form" method="post" action="">
  	<div align="center">
  	<table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1">
  		<tr>
  			<td colspan="2" align="center"><font face="Á¥Êé" size="5">¹ÜÀíÔ±µÇÂ½</font></td>
  		</tr>
  		<tr>
  			<td>ÕÊºÅ£º</td>
  			<td><input type="text" name="username" size="20"></td>
  		</tr>
  		<tr>
  			<td>ÃÜÂë£º</td>
  			<td><input type="password" name="userpwd" size="20"></td>
  		</tr>
  		<tr>
  			<td colspan="2" align="center">
			<input type="button" value="µÇÂ½" onclick="chick()"></td>
  		</tr>
  		<%if(admin != null && admin.equals("1")){%>
  		<tr>
  			<td colspan="2" align="center"><font color="red">ÕÊºÅ»òÃÜÂë´íÎó£¡</font></td>
  		</tr>
  		<%}%>
	</table>
	</div>
	</form>
  </body>
</html>
