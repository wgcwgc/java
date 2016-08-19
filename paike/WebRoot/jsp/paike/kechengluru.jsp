
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
					alert("请输入课程名!");
					document.form.name.focus();
					return false;
				}
				if (document.form.jiaoxuezhou.value == "" ) 
				{
					alert("请输入教学周!");
					document.form.jiaoxuezhou.focus();
					return false;
				}
				if (isNaN(document.form.jiaoxuezhou.value)) 
				{
					alert("教学周只能是数字!");
					document.form.jiaoxuezhou.focus();
					return false;
				}
				if (document.form.keshi.value == "" ) 
				{
					alert("请输入课时!");
					document.form.keshi.focus();
					return false;
				}
				if (isNaN(document.form.keshi.value)) 
				{
					alert("课时只能是数字!");
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
  			<td colspan="2" align="center"><font face="隶书" size="5">课程录入</font></td>
  		</tr>
  		<tr>
  			<td>课&nbsp;&nbsp; 程&nbsp;&nbsp; 名：</td>
  			<td><input type="text" name="name" size="20"></td>
  		</tr>
  		<tr>
  			<td>教&nbsp;&nbsp; 学&nbsp;&nbsp; 周：</td>
  			<td><input type="text" name="jiaoxuezhou" size="20"></td>
  		</tr>
  		<tr>
  			<td>课&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 时：</td>
  			<td><input type="text" name="keshi" size="20"></td>
  		</tr>
  		<tr>
  			<td>专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 业：</td>
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
  			<td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 级：</td>
  			<td align="center">
  			<select size="1" name="nianji">
  			<option value="一年">一年级</option>
  			<option value="二年">二年级</option>
  			<option value="三年">三年级</option>
  			<option value="四年">四年级</option>
  			</select></td>
  		</tr>
  		<tr>
  			<td>是否为公共课：</td>
  			<td align="center"><input type="radio" value="1" checked name="gong">是&nbsp;&nbsp; <input type="radio" name="gong" value="0">否</td>
  		</tr>
  		<tr>
  			<td colspan="2" align="center">
			<input type="button" value="录入" onclick="chick()"></td>
  		</tr>
  		<%if(kecheng != null && kecheng.equals("1")){%>
  		<tr>
  			<td colspan="2" align="center">
			<font color="red">录入成功!</font></td>
  		</tr>
  		<%}%>
	</table>
	</div>
	</form>
  </body>
</html>