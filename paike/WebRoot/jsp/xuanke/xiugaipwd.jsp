
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
					alert("�����������!");
					document.form.oldpwd.focus();
					return false;
				}
				if (document.form.oldpwd.value != pwd) 
				{
					alert("���������!");
					document.form.oldpwd.focus();
					return false;
				}
				if (isNaN(document.form.oldpwd.value)) 
				{
					alert("�������������!");
					document.form.oldpwd.focus();
					return false;
				}
				if (document.form.nwepwd.value == "" ) 
				{
					alert("������������!");
					document.form.nwepwd.focus();
					return false;
				}
				if (isNaN(document.form.nwepwd.value)) 
				{
					alert("�������������!");
					document.form.nwepwd.focus();
					return false;
				}
				if (document.form.querenpwd.value == "") 
				{
					alert("��������һ��������!");
					document.form.querenpwd.focus();
					return false;
				}
				if (document.form.querenpwd.value != document.form.nwepwd.value) 
				{
					alert("��������������벻һ��!");
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
  <script>alert('����û�е�½!');window.navigate('/paike/jsp/login/xueshengLogin.jsp');</script>
  <%
  }else{
  	ArrayList login = (ArrayList)request.getSession().getAttribute("login");
  	if(!login.get(2).equals("1")){
  	%>
  	<script>alert('��û��Ȩ�޲鿴����ҳ!');window.navigate('/paike/jsp/login/xueshengLogin.jsp');</script>
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
			<font face="����" size="5" color="#FF0000">�޸�����</font></td>
		</tr>
		<tr>
			<td align="center">�� �� �룺</td>
			<td align="center"><input type="password" name="oldpwd" size="20"></td>
		</tr>
		<tr>
			<td align="center">�� �� �룺</td>
			<td align="center"><input type="password" name="nwepwd" size="20"></td>
		</tr>
		<tr>
			<td align="center">ȷ�����룺</td>
			<td align="center"><input type="password" name="querenpwd" size="20"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="button" value="�ύ�޸�" onclick="chick(<%=login.get(1)%>)"></td>
		</tr>
		<%if(chenggong != null && chenggong.equals("1")){%>
		<tr>
			<td colspan="2" align="center">
			<font color="red">�����޸ĳɹ���</font>
			</td>
		</tr>
		<%}%>
		</table>
	</div>
	</form>
  </body>
  <%}}%>
</html>