
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
					alert("�����������!");
					document.form.name.focus();
					return false;
				}
				if (document.form.renshu.value == "" ) 
				{
					alert("��������������!");
					document.form.renshu.focus();
					return false;
				}
				if (isNaN(document.form.renshu.value)) 
				{
					alert("��������ֻ��������!");
					document.form.renshu.focus();
					return false;
				}
				else
				{
					form.action="LuruServlet?jiaoshi=1";
	  				form.submit();
				}
			}
</script>

  <body bgcolor="#E1F0FF">
  <%
  String jiaoshi = (String)request.getAttribute("jiaoshiluru");
  %>
  <form name="form" method="post" action="">
  	<div align="center">
  	<table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1">
  		<tr>
  			<td colspan="2" align="center"><font face="����" size="5">����¼��</font></td>
  		</tr>
  		<tr>
  			<td>�� �� ����</td>
  			<td><input type="text" name="name" size="20"></td>
  		</tr>
  		<tr>
  			<td>����������</td>
  			<td><input type="text" name="renshu" size="20"></td>
  		</tr>
  		<tr>
  			<td colspan="2" align="center">
			<input type="button" value="¼��" onclick="chick()"></td>
  		</tr>
  		<%if(jiaoshi != null && jiaoshi.equals("1")){%>
  		<tr>
  			<td colspan="2" align="center">
			<font color="red">¼��ɹ�!</font></td>
  		</tr>
  		<%}%>
	</table>
	</div>
	</form>
  </body>
</html>