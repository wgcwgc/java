
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
		form.action="AptitudePaikeServlet";
		form.submit();
	}
  function save(a,b,c)
  	{
		form.action="SaveKechengbiaoServlet?a="+a+"&b="+b+"&c="+c;
		form.submit();
	}
</script>

  <body bgcolor="#E1F0FF">
  <jsp:include page="/AllServlet"></jsp:include>
  <%
  ArrayList zhuanye = (ArrayList)request.getAttribute("zhuanye");
  ArrayList jiaoshi = (ArrayList)request.getAttribute("jiaoshi");
  ArrayList laoshi = (ArrayList)request.getAttribute("laoshi");
  String zhuanyeid = (String)request.getAttribute("zhuanyeid");
  String nianji = (String)request.getAttribute("nianji");
  ArrayList paike = (ArrayList)request.getAttribute("paike");
  ArrayList kecheng = (ArrayList)request.getAttribute("kecheng");
  ArrayList save = new ArrayList();
  String zhuanyeming = "";
  int select1 = 0,select2 = 0,select3 = 0;
  String chenggong = (String)request.getAttribute("chenggong");
  String chongfu = (String)request.getAttribute("chongfu");
  %>
  <form name="form" method="post" action="">
  	<div align="center">
  	<font face="隶书" size="5">课程表</font>
	<p>请选择专业：
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
	请选择年级：
	<select size="1" name="nianji">
	<option value="一年">一年级</option>
	<option value="二年">二年级</option>
	<option value="三年">三年级</option>
	<option value="四年">四年级</option>
	</select>&nbsp;&nbsp;&nbsp; 
	<input type="button" value="提交" onclick="tijiao()"></p>
	<p>
	<%if((zhuanyeid != null && !zhuanyeid.equals("")) && (nianji != null && !nianji.equals(""))){%>
	<table border="0" width="500"><tr><td align="left">&nbsp;专业：<%=zhuanyeming%>&nbsp;&nbsp;&nbsp;&nbsp;年级：<%=nianji%>级</td></tr></table>
	<%}%>
  	<table bordercolorlight="#D7D3CE" bordercolordark="#D7D3CE" border="1" width="500">
  		<%if(chenggong != null && chenggong.equals("1")){%>
  		<tr><td colspan="6" align="center"><font color="red">课程表存储成功！</font></td></tr>
  		<%}%>
  		<%if(chongfu != null && chongfu.equals("1")){%>
  		<tr><td colspan="6" align="center"><font color="red">此组数据在数据库中已存在，请不要重复插入！</font></td></tr>
  		<%}%>
  		<tr bgcolor="#F2DF91">
  			<td align="center">星期</td>
  			<td align="center">第几节课</td>
  			<td align="center">课程</td>
  			<td align="center">班级</td>
  			<td align="center">老师</td>
  			<td align="center">教室</td>
  		</tr>
  		<%
  		if(paike != null && paike.size() != 0){
  			for(int j = 0;j < paike.size();j++){
  				select1 = paike.size();
  				ArrayList paikeRow = (ArrayList)paike.get(j);
  				ArrayList allRow = (ArrayList)paikeRow.get(0);
  				ArrayList paikeCol = (ArrayList)paikeRow.get(1);
		  		for(int x = 0;x < allRow.size();x++){
		  			select2 = allRow.size();
		  			ArrayList allCol = (ArrayList)allRow.get(x);
		  			for(int y = 0; y <allCol.size();y++){
		  				select3 = allCol.size();
			  			if(allCol.get(y).equals("0")){
			  				break;
			  			}
  		%>
  		<tr bgcolor="#FBEEC8">
  			<td align="center">星期<%=x+1%></td>
  			<td align="center">第<%=y+1%>节课</td>
  			<%
  			if(kecheng != null && kecheng.size() != 0){
  				for(int i = 0;i < kecheng.size();i++){
  					ArrayList al = (ArrayList)kecheng.get(i);
  					if(al.get(0).equals(allCol.get(y))){
  			%>
  			<td align="center"><%=al.get(1)%></td>
  			<%break;}if(allCol.get(y).equals("0")){%>
  			<td align="center">无课</td>
  			<%break;}}}%>
  			<td align="center"><%=paikeCol.get(1)%></td>
  			<td align="center">
  			<select name="laoshi<%=j%><%=x%><%=y%>">
  			<%
  			if(laoshi != null && laoshi.size() != 0){
  				for(int i = 0;i < laoshi.size();i++){  				
  					ArrayList laoshiRow = (ArrayList)laoshi.get(i);
  					if(laoshiRow.get(2).equals(allCol.get(y))){  						
  			%>
  			<option value="<%=laoshiRow.get(0)%>"><%=laoshiRow.get(1)%></option>
  			<%}}}%>
  			</select>
  			</td>
  			<td align="center">
  			<select size="1" name="jiaoshi<%=j%><%=x%><%=y%>">
  			<%
  			if(jiaoshi != null && jiaoshi.size() != 0){
  				for(int i = 0;i < jiaoshi.size();i++){
  					ArrayList jiaoshiRow = (ArrayList)jiaoshi.get(i);
  			%>
  			<option value="<%=jiaoshiRow.get(0)%>"><%=jiaoshiRow.get(1)%></option>
  			<%}}%>
  			</select></td>
  		</tr> 
  		<%
  		ArrayList saveRow = new ArrayList();
  		saveRow.add(zhuanyeid);//专业id
  		saveRow.add(nianji);//年级
  		saveRow.add(""+x);//星期
  		saveRow.add(""+y);//课节
  		saveRow.add(allCol.get(y));//课程id
  		saveRow.add(paikeCol.get(0));//班级id
  		save.add(saveRow);
  		}}}
  		session.setAttribute("save",save);
  		%>
  		<tr><td colspan="6" align="center"><input type="button" value="存储课程表" onclick="save(<%=select1%>,<%=select2%>,<%=select3%>)"></td></tr>
  		<%}%> 		
	</table>	
	</div>
	</form>
  </body>
</html>