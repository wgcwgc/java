
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
	function opencat3(cat,img)
	{
 	 	if(cat.style.display=="none"){
     	cat.style.display="";
    	 img.src="img/class2.gif";
  		} else {
     	cat.style.display="none";
     	img.src="img/class1.gif";
  		}
	}
	function opencat4(cat,img)
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
					教师信息管理
				</td>
			</tr>
			<tr>
				<%-- 类型树--%>
				<td id="cat101000" style="DISPLAY: none" bgcolor="#fefdf5">
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" />
					<a target="mainFrame" href="jsp/paike/laoshiluru.jsp">信息录入</a><br />
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" />
					<a target="mainFrame" href="jsp/paike/laoshiweihu.jsp">信息维护</a><br />
				</td>
			</tr>
			<tr bgcolor="#E1F0FF">
				<td language="javascript" onmouseup="opencat1(cat101001,img101001);" id="item$pval[CatID])" onmouseover="this.bgColor='#A2DBCE';" style="CURSOR: hand" onmouseout="this.bgColor='#E1F0FF';" height="24">
					<img id="img101001" height="20" src="img/class1.gif" width="20" align="absMiddle" /> 
					课程信息管理</td>
			</tr>
			<tr>
				<%-- 类型树--%>
				<td id="cat101001" style="DISPLAY: none" bgcolor="#fefdf5">
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" /> 
					<a target="mainFrame" href="jsp/paike/kechengluru.jsp">信息录入</a><br />
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" /> 
					<a target="mainFrame" href="jsp/paike/kechengweihu.jsp">信息维护</a><br />
				</td>
			</tr>
			<tr bgcolor="#E1F0FF">
				<td language="javascript" onmouseup="opencat2(cat101002,img101002);" id="item$pval[CatID])" onmouseover="this.bgColor='#A2DBCE';" style="CURSOR: hand" onmouseout="this.bgColor='#E1F0FF';" height="24">
					<img id="img101002" height="20" src="img/class1.gif" width="20" align="absMiddle" /> 
					教室信息管理</td>
			</tr>
			<tr>
				<%-- 类型树--%>
				<td id="cat101002" style="DISPLAY: none" bgcolor="#fefdf5">
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" /> 
					<a target="mainFrame" href="jsp/paike/jiaoshiluru.jsp">信息录入</a><br />
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" /> 
					<a target="mainFrame" href="jsp/paike/jiaoshiweihu.jsp">信息维护</a><br />
				</td>
			</tr>
			<tr bgcolor="#E1F0FF">
				<td language="javascript" onmouseup="opencat3(cat101003,img101003);" id="item$pval[CatID])" onmouseover="this.bgColor='#A2DBCE';" style="CURSOR: hand" onmouseout="this.bgColor='#E1F0FF';" height="24">
					<img id="img101003" height="20" src="img/class1.gif" width="20" align="absMiddle" /> 
					课程安排</td>
			</tr>
			<tr>
				<%-- 类型树--%>
				<td id="cat101003" style="DISPLAY: none" bgcolor="#fefdf5">
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" /> 
					<a target="mainFrame" href="jsp/paike/kechenganpai.jsp">课程安排</a><br />
				</td>
			</tr>
			<tr bgcolor="#E1F0FF">
				<td language="javascript" onmouseup="opencat4(cat101004,img101004);" id="item$pval[CatID])" onmouseover="this.bgColor='#A2DBCE';" style="CURSOR: hand" onmouseout="this.bgColor='#E1F0FF';" height="24">
					<img id="img101004" height="20" src="img/class1.gif" width="20" align="absMiddle" /> 
					排课管理</td>
			</tr>
			<tr>
				<%-- 类型树--%>
				<td id="cat101004" style="DISPLAY: none" bgcolor="#fefdf5">
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" /> 
					<a target="mainFrame" href="jsp/paike/aptitudepaike.jsp">智能排课</a><br />
					<img height="20" src="img/class3.gif" width="36" align="absMiddle" border="0" alt="" /> 
					<a target="mainFrame" href="jsp/paike/paikejieguo.jsp">排课结果</a><br />
				</td>
			</tr>
		</table>
  </body>
</html>