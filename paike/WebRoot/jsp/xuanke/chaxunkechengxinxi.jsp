
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
  function laoshichaxun()
  	{
		form.action="XueshengChaxunServlet?laoshiid=1";
		form.submit();
	}
  function kechengchaxun()
  	{
		form.action="XueshengChaxunServlet?kechengid=1";
		form.submit();
	}
  function kebiaochaxun()
  	{
		form.action="jsp/paike/kebiaochaxun.jsp";
		form.submit();
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
  	if(login.get(2).equals("0")){
  	%>
  	<script>alert('��û��Ȩ�޲鿴����ҳ!');window.navigate('/paike/jsp/login/xueshengLogin.jsp');</script>
  	<%
  	}}
  %>
  <jsp:include page="/AllServlet"></jsp:include>
  <%
  ArrayList laoshi = (ArrayList)request.getAttribute("laoshi");
  ArrayList kecheng = (ArrayList)request.getAttribute("kecheng");
  ArrayList kechenglist = (ArrayList)request.getAttribute("kechenglist");
  ArrayList kebiaolist = (ArrayList)request.getAttribute("kebiaolist");
  %>
  <form name="form" method="post" action="">
  	<div align="center">
  	<font face="����" size="5">��ѯ�γ���Ϣ</font><p>
	<table border="1" bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" id="table1">
		<tr>
			<td>����ʦ��ѯ��<select size="1" name="laoshi">
			<%
			if(laoshi != null && laoshi.size() != 0){
				for(int i = 0;i < laoshi.size();i++){
					ArrayList laoshiRow = (ArrayList)laoshi.get(i);
			%>
			<option value="<%=laoshiRow.get(0)%>"><%=laoshiRow.get(1)%></option>
			<%}}%>
			</select></td>
			<td><input type="button" value="��ѯ" onclick="laoshichaxun()"></td>
		</tr>
		<tr>
			<td>���γ̲�ѯ��<select size="1" name="kecheng">
			<%
			if(kecheng != null && kecheng.size() != 0){
				for(int i = 0;i < kecheng.size();i++){
					ArrayList kechengRow = (ArrayList)kecheng.get(i);
			%>
			<option value="<%=kechengRow.get(0)%>"><%=kechengRow.get(1)%></option>
			<%}}%>
			</select></td>
			<td><input type="button" value="��ѯ" onclick="kechengchaxun()"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button" value="��ѯ�γ̱�" onclick="kebiaochaxun()"></td>
		</tr>
	</table>
  	<p>
	<table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1" width="600">
  		<tr bgcolor="#F2DF91">
  			<td align="center">�γ̺�</td>
  			<td align="center">�γ���</td>
  			<td align="center">��ʼʱ��</td>
  			<td align="center">����ʱ��</td>
  			<td align="center">��ѧ��</td>
  			<td align="center">�ܿ�ʱ</td>
  			<td align="center">רҵ</td>
  			<td align="center">�����꼶</td>
  			<td align="center">�ڿ���ʦ</td>
  		</tr>
  		<%
  		if(kechenglist != null && kechenglist.size() != 0){
	  		for(int i = 0;i < kechenglist.size();i++){
	  			ArrayList kechenglistRow = (ArrayList)kechenglist.get(i);
  		%>
   		<tr bgcolor="#FBEEC8">
  			<td align="center"><%=kechenglistRow.get(0)%></td>
  			<td align="center"><%=kechenglistRow.get(1)%></td>
  			<td align="center"><%=kechenglistRow.get(2)%></td>
  			<td align="center"><%=kechenglistRow.get(3)%></td>
  			<td align="center"><%=kechenglistRow.get(4)%></td>
  			<td align="center"><%=kechenglistRow.get(5)%></td>
  			<td align="center"><%=kechenglistRow.get(6)%></td>
  			<td align="center"><%=kechenglistRow.get(7)%>��</td>
  			<td align="center"><%=kechenglistRow.get(8)%></td>
  		</tr>
  		<%}}%>
  		<tr bgcolor="#FBEEC8">
  			<td align="center" colspan="9">
			<table border="1" bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" id="table2" width="100%">
				<tr>
					<td colspan="5" align="center">�γ̰���</td>
				</tr>
				<tr bgcolor="#F2DF91">
					<td align="center">����</td>
					<td align="center">�ν�</td>
					<td align="center">�༶</td>
					<td align="center">��ʦ</td>
					<td align="center">����</td>
				</tr>
				<%
				if(kebiaolist != null && kebiaolist.size() != 0){
	  				for(int i = 0;i < kebiaolist.size();i++){
	  					ArrayList kebiaolistRow = (ArrayList)kebiaolist.get(i);
  				%>
				<tr>
					<td align="center">����<%=Integer.parseInt(kebiaolistRow.get(0).toString())+1%></td>
					<td align="center">��<%=Integer.parseInt(kebiaolistRow.get(1).toString())+1%>�ڿ�</td>
					<td align="center"><%=kebiaolistRow.get(2)%></td>
					<td align="center"><%=kebiaolistRow.get(3)%></td>
					<td align="center"><%=kebiaolistRow.get(4)%></td>
				</tr>
				<%}}else{%>
				<tr><td colspan="5" align="center"><font color="red">���γ̻�û�а��ſα�</font></td></tr>
				<%}%>
			</table>
			</td>
  		</tr>
	</table>
	</div>
	</form>
  </body>
</html>