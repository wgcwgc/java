
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
  <script>alert('您还没有登陆!');window.navigate('/paike/jsp/login/xueshengLogin.jsp');</script>
  <%
  }else{
  	ArrayList login = (ArrayList)request.getSession().getAttribute("login");
  	if(!login.get(2).equals("1")){
  	%>
  	<script>alert('您没有权限查看此网页!');window.navigate('/paike/jsp/login/xueshengLogin.jsp');</script>
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
			<font color="#FF0000" face="隶书" size="5">选课</font></td>
		</tr>
		<tr>
			<td width="201" align="center">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 号：</td>
			<td width="183">&nbsp;&nbsp;<%=xuesheng.get(0)%></td>
		</tr>
		<tr>
			<td width="201" align="center">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 名：</td>
			<td width="183">&nbsp;&nbsp;<%=xuesheng.get(1)%></td>
		</tr>
		<tr>
			<td width="201" align="center">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 级：</td>
			<td width="183">&nbsp;&nbsp;<%=xuesheng.get(3)%></td>
		</tr>
		<tr>
			<td width="201" align="center">班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 级：</td>
			<td width="183">&nbsp;&nbsp;<%=xuesheng.get(2)%></td>
		</tr>
		<tr>
			<td width="201" align="center">专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 业：</td>
			<td width="183">&nbsp;&nbsp;<%=xuesheng.get(4)%></td>
		</tr>
		<tr>
			<td width="201" align="center">本专业所有课程：</td>
			<td width="183">
			<%
			for(int i = 0;i < allkecheng.size();i++){
			%>
			&nbsp;&nbsp;<%=allkecheng.get(i)%><br>
			<%}%>
			</td>
		</tr>
		<tr>
			<td width="201" align="center">本年级所开课程：</td>
			<td width="183">
			<%
			if(xuankecheng.size() == 0){
			%>
			<font color="red">本年级所开课程您已全部选择！</font>
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
		<tr><td colspan="2" align="center"><font color="red">您已累积有5门功课没有学分，所以不能在选课了！</font></td></tr>
		<%}%>
		<%if(feiyong != null && feiyong.equals("1")){%>
		<tr><td colspan="2" align="center"><font color="red">您有2门或2门以上的课程没有缴费，所以不能在选课了！</font></td></tr>
		<%}%>
		<%if(((xuefen == null || xuefen.equals("")) && (feiyong == null || feiyong.equals(""))) && xuankecheng.size() != 0){%>
		<tr><td colspan="2" align="center"><input type="button" value="提交选课" onclick="chick(<%=xuankecheng.size()%>,<%=xuesheng.get(0)%>)"/></td></tr>
		<%}%>
		<%if(chenggong != null && chenggong.equals("1")){%>
		<tr><td colspan="2" align="center"><font color="red">选课申请已提交,管理员将在24小时内审核,请在24小时后登陆查看结果!</font></td></tr>
		<%}%>
	</table>
	</div>
	</form>
	<%}}%>
  </body>
</html>