
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
  function update(id,i)
  	{
		form.action="WeihuServlet?kechengUpdate=1&id="+id+"&i="+i;
		form.submit();
	}
	function del(id)
  	{
		form.action="WeihuServlet?kechengDel=1&id="+id;
		form.submit();
	}
</script>

  <body bgcolor="#E1F0FF">
  <jsp:include page="/AllServlet"></jsp:include>
  <%
  ArrayList kecheng = (ArrayList)request.getAttribute("kecheng");
  %>
  <form name="form" method="post" action="">
  	<div align="center">
  	<font face="隶书" size="5">课程维护</font>
	<p>
  	<table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1" width="600">
  		<tr bgcolor="#F2DF91">
  			<td align="center">课程号</td>
  			<td align="center">课程名</td>
  			<td align="center">教学周</td>
  			<td align="center">课时</td>
  			<td align="center">所属专业</td>
  			<td align="center">开课年级</td>
  			<td align="center">　</td>
  			<td align="center">　</td>
  		</tr>
  		<%
  		if(kecheng != null && kecheng.size() != 0){
  			for(int i = 0;i < kecheng.size();i++){
  				ArrayList kechengRow = (ArrayList)kecheng.get(i);
  		%>
  		<tr bgcolor="#FBEEC8">
  			<td align="center"><%=kechengRow.get(0)%></td>
  			<td align="center"><%=kechengRow.get(1)%></td>
  			<td align="center"><input type="text" name="jiaoxuezhou<%=i%>" size="5" value="<%=kechengRow.get(2)%>"></td>
  			<td align="center"><input type="text" name="keshi<%=i%>" size="5" value="<%=kechengRow.get(3)%>"></td>
  			<td align="center"><%=kechengRow.get(7)%></td>
  			<td align="center"><%=kechengRow.get(6)%>级</td>
  			<%if(kechengRow.get(4).equals("1")){%>
  			<td align="center">公共课</td>
  			<%}%>
  			<%if(kechengRow.get(4).equals("0")){%>
  			<td align="center">非公共课</td>
  			<%}%>
  			<td align="center"><input type="button" value="修改" onclick="update(<%=kechengRow.get(0)%>,<%=i%>)">&nbsp;&nbsp; <input type="button" value="删除" onclick="del(<%=kechengRow.get(0)%>)"></td>
  		</tr>
  		<%}}%>
	</table>
	</div>
	</form>
  </body>
</html>