<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%> <%
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
<script language="javascript">
	function banjiluru()
	{
		form.action="XinxiluruServlet?banjiluru=1";
	  	form.submit();
	}
	function xueshengluru()
	{
		form.action="XinxiluruServlet?xueshengluru=1";
	  	form.submit();
	}
	function qingkuangluru()
	{
		form.action="XinxiluruServlet?qingkuangluru=1";
	  	form.submit();
	}
	function zhuanyeluru()
	{
		form.action="XinxiluruServlet?zhuanyeluru=1";
	  	form.submit();
	}
</script>
<body bgcolor="#E7F3FF">
<form name="form" method="post" action>
<jsp:include page="/AllServlet"></jsp:include>
<%
ArrayList zhuanye = (ArrayList)request.getAttribute("zhuanye");
ArrayList kecheng = (ArrayList)request.getAttribute("kecheng");
ArrayList banji = (ArrayList)request.getAttribute("banji");
%>
	<div align="center">
	<table cellspacing="10">
		<tr>
			<td>
			<table border="1">
				<tr>
					<td colspan="2" align="center">�༶¼��</td>
				</tr>
				<tr>
					<td align="center">�༶��</td>
					<td align="center">
					<input type="text" name="banjiming" size="20"></td>
				</tr>
				<tr>
					<td align="center">�꼶</td>
					<td align="center"><select size="1" name="nianji">
					<option value="һ��">һ�꼶</option>
					<option value="����">���꼶</option>
					<option value="����">���꼶</option>
					<option value="����">���꼶</option>
					</select></td>
				</tr>
				<tr>
					<td align="center">����</td>
					<td align="center">
					<input type="text" name="renshu" size="20"></td>
				</tr>
				<tr>
					<td align="center">רҵ</td>
					<td align="center"><select size="1" name="zhuanye">
					<%
					for(int i = 0;i < zhuanye.size();i++){
						ArrayList al = (ArrayList)zhuanye.get(i);
					%>
					<option value="<%=al.get(0)%>"><%=al.get(1)%></option>
					<%}%>
					</select></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
					<input type="button" value="¼��" onclick="banjiluru()"></td>
				</tr>
			</table>
			</td>
			</tr>
			<tr>
			<td>
			<table border="1">
				<tr>
					<td colspan="2" align="center">ѧ��¼��</td>
				</tr>
				<tr>
					<td align="center">ѧ��</td>
					<td align="center">
					<input type="text" name="xuehao" size="20"></td>
				</tr>
				<tr>
					<td align="center">����</td>
					<td align="center">
					<input type="text" name="xingming" size="20"></td>
				</tr>
				<tr>
					<td align="center">�༶</td>
					<td align="center"><select size="1" name="banji">
					<%
					for(int i = 0;i < banji.size();i++){
						ArrayList al = (ArrayList)banji.get(i);
					%>
					<option value="<%=al.get(0)%>"><%=al.get(1)%></option>
					<%}%>
					</select></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
					<input type="button" value="¼��" onclick="xueshengluru()"></td>
				</tr>
			</table>
			</td>
			</tr>
			<tr>
			<td align="center"> 
			<table border="1">
				<tr>
					<td colspan="2" align="center">ѧ������ѧ�ּ��ɷ����¼��</td>
				</tr>
				<tr>
					<td align="center">ѧ��</td>
					<td align="center"><input type="text" name="xueshengid" size="20"></td>
				</tr>
				<tr>
					<td align="center">�γ�</td>
					<td align="center"><select size="1" name="kecheng">
					<%
					for(int i = 0;i < kecheng.size();i++){
						ArrayList al = (ArrayList)kecheng.get(i);
					%>
					<option value="<%=al.get(0)%>"><%=al.get(1)%></option>
					<%}%>
					</select></td>
				</tr>
				<tr>
					<td align="center">ѧ��</td>
					<td align="center"><input type="text" name="xuefen" size="20"></td>
				</tr>
				<tr>
					<td align="center">�Ƿ�ɷ�</td>
					<td align="center">
					<input type="radio" value="1" checked name="feiyong">��&nbsp; 
					<input type="radio" name="feiyong" value="0">��</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="button" value="¼��" onclick="qingkuangluru()"></td>
				</tr>
			</table>
			</td>
			</tr>
			<tr>
			<td align="center"> 
			<table border="1">
				<tr>
					<td colspan="2" align="center">רҵ¼��</td>
				</tr>
				<tr>
					<td align="center">רҵ��</td>
					<td align="center"><input type="text" name="zhuanyeming" size="20"></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
					<input type="button" value="¼��" onclick="zhuanyeluru()"></td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	</div>
</form>

</body>

</html>