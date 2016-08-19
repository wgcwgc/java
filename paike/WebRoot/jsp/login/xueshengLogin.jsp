
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
					alert("请输入学号!");
					document.form.username.focus();
					return false;
				}
				if (isNaN(document.form.username.value)) 
				{
					alert("学号必须是数字!");
					document.form.username.focus();
					return false;
				}
				if (document.form.userpwd.value == "" ) 
				{
					alert("请输入密码!");
					document.form.userpwd.focus();
					return false;
				}
				if (isNaN(document.form.userpwd.value)) 
				{
					alert("密码必须是数字!");
					document.form.userpwd.focus();
					return false;
				}
				else
				{
					form.action="LoginServlet?xuesheng=1";
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
  String xuesheng = (String)request.getAttribute("xuesheng");
  %>
  <form name="form" method="post" action="">
  	<div align="center">
  	<table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1">
  		<tr>
  			<td colspan="2" align="center"><font face="隶书" size="5">学生登陆</font></td>
  		</tr>
  		<tr>
  			<td>学号：</td>
  			<td><input type="text" name="username" size="20"></td>
  		</tr>
  		<tr>
  			<td>密码：</td>
  			<td><input type="password" name="userpwd" size="20"></td>
  		</tr>
  		<tr>
  			<td colspan="2" align="center">
			<input type="button" value="登陆" onclick="chick()">&nbsp;
			<input type="button" value="注册" onclick="reg()"></td>
  		</tr>
  		<%if(xuesheng != null && xuesheng.equals("1")){%>
  		<tr>
  			<td colspan="2" align="center"><font color="red">学号或密码错误!</font></td>
  		</tr>
  		<%}%>
	</table>
	</div>
	</form>
  </body>
</html>