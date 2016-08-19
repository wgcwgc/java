
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
  <script language="javascript">
	function opencat(cat,img)
	{
 	 	if(cat.style.display=="none"){
     	cat.style.display="";
    	 img.src="img/class2.gif";
  		} else {
     	cat.style.display="none";
     	img.src="img/class1.gif";
  		}
	}
	function opencat1(cat,img)
	{
 	 	if(cat.style.display=="none"){
     	cat.style.display="";
    	 img.src="img/class2.gif";
  		} else {
     	cat.style.display="none";
     	img.src="img/class1.gif";
  		}
	}
	function opencat2(cat,img)
	{
 	 	if(cat.style.display=="none"){
     	cat.style.display="";
    	 img.src="img/class2.gif";
  		} else {
     	cat.style.display="none";
     	img.src="img/class1.gif";
  		}
	}
</script>
  <body bgcolor="#E1F0FF">
  <table cellspacing="0" cellpadding="0" width="100%" align="center" bgcolor="#e6e6e6" border="0">
			<tr bgcolor="#E1F0FF">
				<td language="javascript" onmouseup="opencat(cat101000,img101000);" id="item$pval[CatID])" onmouseover="this.bgColor='#A2DBCE';" style="CURSOR: hand" onmouseout="this.bgColor='#E1F0FF';" height="24">
					<img id="img101000" height="20" src="img/class1.gif" width="20" align="absMiddle" />
					用户登陆
				</td>
			</tr>
			<tr>
				<%-- 类型树--%>
				<td id="cat101000" style="DISPLAY: none" bgcolor="#fefdf5">
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" />
					<a target="mainFrame" href="jsp/login/xueshengLogin.jsp">学生登陆</a><br />
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" />
					<a target="mainFrame" href="jsp/login/laoshiLogin.jsp">老师登陆</a><br />
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" />
					<a target="mainFrame" href="jsp/login/adminiLogin.jsp">管理员登陆</a><br />
				</td>
			</tr>
			<tr bgcolor="#E1F0FF">
				<td language="javascript" onmouseup="opencat1(cat101001,img101001);" id="item$pval[CatID])" onmouseover="this.bgColor='#A2DBCE';" style="CURSOR: hand" onmouseout="this.bgColor='#E1F0FF';" height="24">
					<img id="img101001" height="20" src="img/class1.gif" width="20" align="absMiddle" />
					学生选课
				</td>
			</tr>
			<tr>
				<%-- 类型树--%>
				<td id="cat101001" style="DISPLAY: none" bgcolor="#fefdf5">
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" />
					<a target="mainFrame" href="jsp/xuanke/chaxunkecheng.jsp">查询课程</a><br />
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" />
					<a target="mainFrame" href="jsp/xuanke/chaxunkechengxinxi.jsp">查询课程信息</a><br />
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" />
					<a  target="mainFrame" href="jsp/xuanke/xuanke.jsp">选课和退课</a><br />
				</td>
			</tr>
			<tr bgcolor="#E1F0FF">
				<td language="javascript" onmouseup="opencat2(cat101002,img101002);" id="item$pval[CatID])" onmouseover="this.bgColor='#A2DBCE';" style="CURSOR: hand" onmouseout="this.bgColor='#E1F0FF';" height="24">
					<img id="img101002" height="20" src="img/class1.gif" width="20" align="absMiddle" />
					课程管理
				</td>
			</tr>
			<tr>
				<%-- 类型树--%>
				<td id="cat101002" style="DISPLAY: none" bgcolor="#fefdf5">
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" />
					<a target="mainFrame" href="jsp/paike/kebiaochaxun.jsp">课表查询</a><br />
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" />
					<a target="mainFrame" href="jsp/paike/xuankequeren.jsp">选课确认</a><br />
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" />
					<a target="_blank" href="jsp/paike/paikeindex.jsp">排课管理</a><br />
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" />
					<a target="mainFrame" href="jsp/xinxiluru/xinxiluru.jsp">其它信息录入</a><br />
				</td>
			</tr>
		</table>
  </body>
</html>
