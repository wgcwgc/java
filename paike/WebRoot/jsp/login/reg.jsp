
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
					alert("�������û���!");
					document.form.username.focus();
					return false;
				}
				if (isNaN(document.form.username.value)) 
				{
					alert("�û�������������!");
					document.form.username.focus();
					return false;
				}
				if (document.form.userpwd.value == "" ) 
				{
					alert("����������!");
					document.form.userpwd.focus();
					return false;
				}
				if (isNaN(document.form.userpwd.value)) 
				{
					alert("�������������!");
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
  			<td colspan="2" align="center"><font face="����" size="5">ע��</font></td>
  		</tr>
  		<tr>
  			<td>�û�����</td>
  			<td><input type="text" name="username" size="20"></td>
  		</tr>
  		<%if(name != null && name.equals("1")){%>
  		<tr>
  			<td colspan="2" align="center"><font color="red">�û����ظ���</font></td>
  		</tr>
  		<%}%>
  		<%if(xuesheng != null && xuesheng.equals("1")){%>
  		<tr>
  			<td colspan="2" align="center"><font color="red">����д��ѧ�Ų����ڣ�</font></td>
  		</tr>
  		<%}%>
  		<%if(laoshi != null && laoshi.equals("1")){%>
  		<tr>
  			<td colspan="2" align="center"><font color="red">����д�Ľ�ʦ�Ų����ڣ�</font></td>
  		</tr>
  		<%}%>
  		<tr>
  			<td>��&nbsp; �룺</td>
  			<td><input type="password" name="userpwd" size="20"></td>
  		</tr>
  		<tr>
  			<td>
			��&nbsp; �ݣ�</td>
  			<td align="center">
			<select size="1" name="shenfen">
			<option value="1">ѧ��</option>
			<option value="2">��ʦ</option>
			</select></td>
  		</tr>
  		<tr>
  			<td colspan="2" align="center">
			<font color="#FF0000">*�û���������ѧ�Ż��ʦ��</font></td>
  		</tr>
  		<tr>
  			<td colspan="2" align="center">
			<input type="button" value="ע��" onclick="chick()"></td>
  		</tr>
	</table>
	</div>
	</form>
  </body>
</html>