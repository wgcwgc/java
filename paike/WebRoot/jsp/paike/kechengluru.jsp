
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
					alert("������γ���!");
					document.form.name.focus();
					return false;
				}
				if (document.form.jiaoxuezhou.value == "" ) 
				{
					alert("�������ѧ��!");
					document.form.jiaoxuezhou.focus();
					return false;
				}
				if (isNaN(document.form.jiaoxuezhou.value)) 
				{
					alert("��ѧ��ֻ��������!");
					document.form.jiaoxuezhou.focus();
					return false;
				}
				if (document.form.keshi.value == "" ) 
				{
					alert("�������ʱ!");
					document.form.keshi.focus();
					return false;
				}
				if (isNaN(document.form.keshi.value)) 
				{
					alert("��ʱֻ��������!");
					document.form.keshi.focus();
					return false;
				}
				else
				{
					form.action="LuruServlet?kechengluru=1";
	  				form.submit();
				}
			}
</script>

  <body bgcolor="#E1F0FF">
  <jsp:include page="/AllServlet"></jsp:include>
  <%
  ArrayList zhuanye = (ArrayList)request.getAttribute("zhuanye");
  String kecheng = (String)request.getAttribute("kechengluru");
  %>
  <form name="form" method="post" action="">
  	<div align="center">
  	<table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1">
  		<tr>
  			<td colspan="2" align="center"><font face="����" size="5">�γ�¼��</font></td>
  		</tr>
  		<tr>
  			<td>��&nbsp;&nbsp; ��&nbsp;&nbsp; ����</td>
  			<td><input type="text" name="name" size="20"></td>
  		</tr>
  		<tr>
  			<td>��&nbsp;&nbsp; ѧ&nbsp;&nbsp; �ܣ�</td>
  			<td><input type="text" name="jiaoxuezhou" size="20"></td>
  		</tr>
  		<tr>
  			<td>��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ʱ��</td>
  			<td><input type="text" name="keshi" size="20"></td>
  		</tr>
  		<tr>
  			<td>ר&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ҵ��</td>
  			<td align="center"><select size="1" name="zhuanye">
  			<%
  			if(zhuanye != null && zhuanye.size() != 0){
  				for(int i = 0;i < zhuanye.size();i++){
  					ArrayList alRow = (ArrayList)zhuanye.get(i);
  			%>
  			<option value="<%=alRow.get(0)%>"><%=alRow.get(1)%></option>
  			<%}}%>
  			</select></td>
  		</tr>
  		<tr>
  			<td>��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ����</td>
  			<td align="center">
  			<select size="1" name="nianji">
  			<option value="һ��">һ�꼶</option>
  			<option value="����">���꼶</option>
  			<option value="����">���꼶</option>
  			<option value="����">���꼶</option>
  			</select></td>
  		</tr>
  		<tr>
  			<td>�Ƿ�Ϊ�����Σ�</td>
  			<td align="center"><input type="radio" value="1" checked name="gong">��&nbsp;&nbsp; <input type="radio" name="gong" value="0">��</td>
  		</tr>
  		<tr>
  			<td colspan="2" align="center">
			<input type="button" value="¼��" onclick="chick()"></td>
  		</tr>
  		<%if(kecheng != null && kecheng.equals("1")){%>
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