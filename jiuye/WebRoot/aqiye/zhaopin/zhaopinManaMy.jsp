<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
        <script language="javascript">
           function zhaopinDelMy(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/zhaopinDelMy.action?id="+id;
               }
           } 
           
            function toudijianliChakan_qiye(zhaopinId)
		    {
		        var url="<%=path %>/toudijianliChakan_qiye.action?zhaopinId="+zhaopinId;
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:800,height:500});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","文件上传");
	            pop.build();
	            pop.show();
	            //另一红上传方式可以参照进销存
		    }          
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="9" background="<%=path %>/img/tbg.gif"></td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">招聘职位</td>
					<td width="10%">待遇</td>
					<td width="10%">学历要求</td>
					<td width="10%">工作地点</td>
					<td width="10%">工作经验</td>
					<td width="20%">详细信息</td>
					<td width="10%">招聘类型</td>
					<td width="10%">发布时间</td>
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.zhaopinList" id="zhaopin">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#zhaopin.zhiwei"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#zhaopin.daiyui"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   <s:property value="#zhaopin.xuliyaoqiu"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#zhaopin.gongzuodidian"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#zhaopin.gongzuojingyan"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#zhaopin.qitashuoming" escape="false"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:if test="#zhaopin.zhaopinType=='shixizhaopin'">
					         实习招聘
					    </s:if>
					    <s:if test="#zhaopin.zhaopinType=='jiuyezhaopin'">
					         就业招聘
					    </s:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#zhaopin.fabushijian"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="zhaopinDelMy(<s:property value="#zhaopin.id"/>)" class="pn-loperator">删除</a>
						<a href="#" onclick="toudijianliChakan_qiye(<s:property value="#zhaopin.id"/>)" class="pn-loperator">查看应聘信息</a>
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
