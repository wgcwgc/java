
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
	  function chick(i,xueshengid)
	  {
	  	form.action="TijiaoXuankeServlet?i="+i+"&xueshengid="+xueshengid;
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
  	if(!login.get(2).equals("1")){
  	%>
  	<script>alert('��û��Ȩ�޲鿴����ҳ!');window.navigate('/paike/jsp/login/xueshengLogin.jsp');</script>
  	<%}else{
  %>
  <jsp:include page="/XuankeServlet"></jsp:include>
  <%
	String xuefen = (String)request.getAttribute("xuefen");
	String feiyong = (String)request.getAttribute("feiyong");
	ArrayList xuesheng = (ArrayList)request.getAttribute("xuesheng");
	ArrayList allkecheng = (ArrayList)request.getAttribute("allkecheng");
	ArrayList xuankecheng = (ArrayList)request.getAttribute("xuankecheng");
	String chenggong = (String)request.getAttribute("chenggong");
  %>
    <form name="form" method="post" action="">
  	<div align="center">
  	<jsp:include page="xuanketop.jsp"></jsp:include>
  	<br><br>
  	<table border="1" bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" id="table1" width="400">
		<tr>
			<td colspan="2" align="center">
			<font color="#FF0000" face="����" size="5">ѡ��</font></td>
		</tr>
		<tr>
			<td width="201" align="center">ѧ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; �ţ�</td>
			<td width="183">&nbsp;&nbsp;<%=xuesheng.get(0)%></td>
		</tr>
		<tr>
			<td width="201" align="center">��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ����</td>
			<td width="183">&nbsp;&nbsp;<%=xuesheng.get(1)%></td>
		</tr>
		<tr>
			<td width="201" align="center">��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ����</td>
			<td width="183">&nbsp;&nbsp;<%=xuesheng.get(3)%></td>
		</tr>
		<tr>
			<td width="201" align="center">��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ����</td>
			<td width="183">&nbsp;&nbsp;<%=xuesheng.get(2)%></td>
		</tr>
		<tr>
			<td width="201" align="center">ר&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ҵ��</td>
			<td width="183">&nbsp;&nbsp;<%=xuesheng.get(4)%></td>
		</tr>
		<tr>
			<td width="201" align="center">��רҵ���пγ̣�</td>
			<td width="183">
			<%
			for(int i = 0;i < allkecheng.size();i++){
			%>
			&nbsp;&nbsp;<%=allkecheng.get(i)%><br>
			<%}%>
			</td>
		</tr>
		<tr>
			<td width="201" align="center">���꼶�����γ̣�</td>
			<td width="183">
			<%
			if(xuankecheng.size() == 0){
			%>
			<font color="red">���꼶�����γ�����ȫ��ѡ��</font>
			<%}else{
			for(int i = 0;i < xuankecheng.size();i++){
				ArrayList alRow = (ArrayList)xuankecheng.get(i);
					if((xuefen != null && xuefen.equals("1")) || (feiyong != null && feiyong.equals("1"))){
			%>
			&nbsp;<input type="checkbox" name="xuanke<%=i%>" value="<%=alRow.get(0)%>" disabled="disabled"/><%=alRow.get(1)%><br>
			<%}else{%>
			&nbsp;<input type="checkbox" name="xuanke<%=i%>" value="<%=alRow.get(0)%>"/><%=alRow.get(1)%><br>
			<%}}}%>
			</td>
		</tr>
		<%if(xuefen != null && xuefen.equals("1")){%>
		<tr><td colspan="2" align="center"><font color="red">�����ۻ���5�Ź���û��ѧ�֣����Բ�����ѡ���ˣ�</font></td></tr>
		<%}%>
		<%if(feiyong != null && feiyong.equals("1")){%>
		<tr><td colspan="2" align="center"><font color="red">����2�Ż�2�����ϵĿγ�û�нɷѣ����Բ�����ѡ���ˣ�</font></td></tr>
		<%}%>
		<%if(((xuefen == null || xuefen.equals("")) && (feiyong == null || feiyong.equals(""))) && xuankecheng.size() != 0){%>
		<tr><td colspan="2" align="center"><input type="button" value="�ύѡ��" onclick="chick(<%=xuankecheng.size()%>,<%=xuesheng.get(0)%>)"/></td></tr>
		<%}%>
		<%if(chenggong != null && chenggong.equals("1")){%>
		<tr><td colspan="2" align="center"><font color="red">ѡ���������ύ,����Ա����24Сʱ�����,����24Сʱ���½�鿴���!</font></td></tr>
		<%}%>
	</table>
	</div>
	</form>
	<%}}%>
  </body>
</html>