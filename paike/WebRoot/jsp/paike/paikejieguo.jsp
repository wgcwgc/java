
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
  function tijiao()
  	{
		form.action="PaikejieguoServlet";
		form.submit();
	}
  function update(i,id,nianjiid,zhuanyeid)
  	{
		form.action="UpdateKebiaoServlet?id="+id+"&i="+i+"&nianjiid="+nianjiid+"&zhuanyeid="+zhuanyeid;
		form.submit();
	}
</script>

  <body bgcolor="#E1F0FF">
  <jsp:include page="/AllServlet"></jsp:include>
  <%
  ArrayList zhuanye = (ArrayList)request.getAttribute("zhuanye");
  ArrayList jiaoshi = (ArrayList)request.getAttribute("jiaoshi");
  ArrayList laoshi = (ArrayList)request.getAttribute("laoshi");
  ArrayList list = (ArrayList)request.getAttribute("list");
  String zhuanyeid = (String)request.getAttribute("zhuanyeid");
  String nianji = (String)request.getAttribute("nianji");
  ArrayList kecheng = (ArrayList)request.getAttribute("kecheng");
  ArrayList banji = (ArrayList)request.getAttribute("banji");
  String zhuanyeming = "";
  String chenggong = (String)request.getAttribute("chenggong");
  String nianjiid ="";
  if(nianji != null && nianji.equals("һ��")){
  	nianjiid = "1";
  }
  if(nianji != null && nianji.equals("����")){
  	nianjiid = "2";
  }
  if(nianji != null && nianji.equals("����")){
  	nianjiid = "3";
  }
  if(nianji != null && nianji.equals("����")){
  	nianjiid = "4";
  }
  %>
  <form name="form" method="post" action="">
  	<div align="center">
  	<font face="����" size="5">�γ̱�</font>
	<p>��ѡ��רҵ��
	<select size="1" name="zhuanye">
	<%
  	if(zhuanye != null && zhuanye.size() != 0){
  		for(int i = 0;i < zhuanye.size();i++){  		
  			ArrayList zhuanyeRow = (ArrayList)zhuanye.get(i);
  			if(zhuanyeid != null && zhuanyeRow.get(0).equals(zhuanyeid)){
  				zhuanyeming = (String)zhuanyeRow.get(1);
  			}
  	%>
  	<option value="<%=zhuanyeRow.get(0)%>"><%=zhuanyeRow.get(1)%></option>
  	<%}}%>
	</select>&nbsp;&nbsp; 
	��ѡ���꼶��
	<select size="1" name="nianji">
	<option value="һ��">һ�꼶</option>
	<option value="����">���꼶</option>
	<option value="����">���꼶</option>
	<option value="����">���꼶</option>
	</select>&nbsp;&nbsp;&nbsp; 
	<input type="button" value="�ύ" onclick="tijiao()"></p>
	<p>
	<%if((zhuanyeid != null && !zhuanyeid.equals("")) && (nianji != null && !nianji.equals(""))){%>
	<table border="0" width="500"><tr><td align="left">&nbsp;רҵ��<%=zhuanyeming%>&nbsp;&nbsp;&nbsp;&nbsp;�꼶��<%=nianji%>��</td></tr></table>
	<%}%>
  	<table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1" width="500">
  		<%if(chenggong != null && chenggong.equals("1")){%>
  		<tr><td colspan="7" align="center"><font color="red">�γ̱��޸ĳɹ���</font></td></tr>
  		<%}%>
  		<tr bgcolor="#F2DF91">
  			<td align="center">����</td>
  			<td align="center">�ڼ��ڿ�</td>
  			<td align="center">�γ�</td>
  			<td align="center">�༶</td>
  			<td align="center">��ʦ</td>
  			<td align="center">����</td>
  			<td align="center"></td>
  		</tr>
  		<%
  		if(list != null && list.size() != 0){
  			for(int i = 0;i < list.size();i++){
  				String kechengming = "";
  				String banjiming = "";
  				ArrayList listRow = (ArrayList)list.get(i);  				
  		%>
  		<tr bgcolor="#FBEEC8">
  			<td align="center">����<%=Integer.parseInt(listRow.get(3).toString())+1%></td>
  			<td align="center">��<%=Integer.parseInt(listRow.get(4).toString())+1%>�ڿ�</td>
  			<%
  			if(kecheng != null && kecheng.size() != 0){
  				for(int j = 0;j < kecheng.size();j++){
  					ArrayList kechengRow = (ArrayList)kecheng.get(j);
  					if(kechengRow.get(0).equals(listRow.get(5))){
  						kechengming = (String)kechengRow.get(1);
  						break;
  					}
  				}
  			}
  			if(banji != null && banji.size() != 0){
  				for(int j = 0;j < banji.size();j++){
  					ArrayList banjiRow = (ArrayList)banji.get(j);
  					if(banjiRow.get(0).equals(listRow.get(6))){
  						banjiming = (String)banjiRow.get(1);
  						break;
  					}
  				}
  			}
  			%>
  			<td align="center"><%=kechengming%></td>
  			<td align="center"><%=banjiming%></td>
  			<td align="center">
  			<select name="laoshi<%=i%>">
  			<%
  			if(laoshi != null && laoshi.size() != 0){
  				for(int j = 0;j < laoshi.size();j++){
  					ArrayList laoshiRow = (ArrayList)laoshi.get(j);
  					if(laoshiRow.get(2).equals(listRow.get(5))){
  						if(laoshiRow.get(0).equals(listRow.get(7))){
  			%>
  			<option value="<%=laoshiRow.get(0)%>" selected><%=laoshiRow.get(1)%></option>
  			<%}else{%>
  			<option value="<%=laoshiRow.get(0)%>"><%=laoshiRow.get(1)%></option>  			
  			<%}}}}%>
   			</select>
  			</td>
  			<td align="center">
  			<select size="1" name="jiaoshi<%=i%>">
  			<%
  			if(jiaoshi != null && jiaoshi.size() != 0){
  				for(int j = 0;j < jiaoshi.size();j++){
  					ArrayList jiaoshiRow = (ArrayList)jiaoshi.get(j);
  					if(jiaoshiRow.get(0).equals(listRow.get(8))){
  			%>
  			<option value="<%=jiaoshiRow.get(0)%>" selected><%=jiaoshiRow.get(1)%></option>
  			<%}else{%>
  			<option value="<%=jiaoshiRow.get(0)%>"><%=jiaoshiRow.get(1)%></option>
  			<%}}}%>
  			</select></td>
  			<td align="center"><input type="button" value="�޸�" onclick="update(<%=i%>,<%=listRow.get(0)%>,<%=nianjiid%>,<%=zhuanyeid%>)"/></td>
  		</tr>
  		<%}}%> 		
	</table>	
	</div>
	</form>
  </body>
</html>