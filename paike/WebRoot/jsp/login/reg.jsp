
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
					alert("请输入用户名!");
					document.form.username.focus();
					return false;
				}
				if (isNaN(document.form.username.value)) 
				{
					alert("用户名必须是数字!");
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
					form.action="RegServlet";
	  				form.submit();
				}
			}
</script>

  <body bgcolor="#E1F0FF">
<%
String name = (String)request.getAttribute("name");
String xuesheng = (String)request.getAttribute("xuesheng");
String laoshi = (String)request.getAttribute("laoshi");
%>  
  <form name="form" method="post" action="">
  	<div align="center">
  	<table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1">
  		<tr>
  			<td colspan="2" align="center"><font face="隶书" size="5">注册</font></td>
  		</tr>
  		<tr>
  			<td>用户名：</td>
  			<td><input type="text" name="username" size="20"></td>
  		</tr>
  		<%if(name != null && name.equals("1")){%>
  		<tr>
  			<td colspan="2" align="center"><font color="red">用户名重复！</font></td>
  		</tr>
  		<%}%>
  		<%if(xuesheng != null && xuesheng.equals("1")){%>
  		<tr>
  			<td colspan="2" align="center"><font color="red">您填写的学号不存在！</font></td>
  		</tr>
  		<%}%>
  		<%if(laoshi != null && laoshi.equals("1")){%>
  		<tr>
  			<td colspan="2" align="center"><font color="red">您填写的教师号不存在！</font></td>
  		</tr>
  		<%}%>
  		<tr>
  			<td>密&nbsp; 码：</td>
  			<td><input type="password" name="userpwd" size="20"></td>
  		</tr>
  		<tr>
  			<td>
			身&nbsp; 份：</td>
  			<td align="center">
			<select size="1" name="shenfen">
			<option value="1">学生</option>
			<option value="2">老师</option>
			</select></td>
  		</tr>
  		<tr>
  			<td colspan="2" align="center">
			<font color="#FF0000">*用户名是您的学号或教师号</font></td>
  		</tr>
  		<tr>
  			<td colspan="2" align="center">
			<input type="button" value="注册" onclick="chick()"></td>
  		</tr>
	</table>
	</div>
	</form>
  </body>
</html>