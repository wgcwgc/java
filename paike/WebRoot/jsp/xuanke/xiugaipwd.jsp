
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
  function chick(pwd)
			{
				if (document.form.oldpwd.value == "" ) 
				{
					alert("请输入旧密码!");
					document.form.oldpwd.focus();
					return false;
				}
				if (document.form.oldpwd.value != pwd) 
				{
					alert("旧密码错误!");
					document.form.oldpwd.focus();
					return false;
				}
				if (isNaN(document.form.oldpwd.value)) 
				{
					alert("密码必须是数字!");
					document.form.oldpwd.focus();
					return false;
				}
				if (document.form.nwepwd.value == "" ) 
				{
					alert("请输入新密码!");
					document.form.nwepwd.focus();
					return false;
				}
				if (isNaN(document.form.nwepwd.value)) 
				{
					alert("密码必须是数字!");
					document.form.nwepwd.focus();
					return false;
				}
				if (document.form.querenpwd.value == "") 
				{
					alert("请再输入一次新密码!");
					document.form.querenpwd.focus();
					return false;
				}
				if (document.form.querenpwd.value != document.form.nwepwd.value) 
				{
					alert("两次输入的新密码不一致!");
					document.form.querenpwd.focus();
					return false;
				}
				else
				{
					form.action="XiugaipwdServlet?xiugaipwd=1";
	  				form.submit();
				}
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
  	if(!login.get(2).equals("1")){
  	%>
  	<script>alert('您没有权限查看此网页!');window.navigate('/paike/jsp/login/xueshengLogin.jsp');</script>
  	<%}else{%>
  <%
  String chenggong = (String)request.getAttribute("chenggong");
  %>
    <form name="form" method="post" action="">
  	<div align="center">
  	<jsp:include page="xuanketop.jsp"></jsp:include>
  	<br><br>
  	<table border="1" bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" id="table1">
		<tr>
			<td colspan="2" align="center">
			<font face="隶书" size="5" color="#FF0000">修改密码</font></td>
		</tr>
		<tr>
			<td align="center">旧 密 码：</td>
			<td align="center"><input type="password" name="oldpwd" size="20"></td>
		</tr>
		<tr>
			<td align="center">新 密 码：</td>
			<td align="center"><input type="password" name="nwepwd" size="20"></td>
		</tr>
		<tr>
			<td align="center">确认密码：</td>
			<td align="center"><input type="password" name="querenpwd" size="20"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="button" value="提交修改" onclick="chick(<%=login.get(1)%>)"></td>
		</tr>
		<%if(chenggong != null && chenggong.equals("1")){%>
		<tr>
			<td colspan="2" align="center">
			<font color="red">密码修改成功！</font>
			</td>
		</tr>
		<%}%>
		</table>
	</div>
	</form>
  </body>
  <%}}%>
</html>