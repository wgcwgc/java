<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		
		<link href="<%=path %>/css/layout.css" type="text/css" rel="stylesheet" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
	    <script type="text/javascript">
	    </script>
	</head>

	<body>
		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>
		<div class="page_row">
			<div class="page_main_msg left">
		         <div class="left_row">
		              <div class="list pic_news" style="height: 600px;">
				          <div class="list_bar">招聘会信息</div>
				          <div class="list_content">
                              <div class="c1-body">
                                  <table width="99%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF" align="center" style="margin-top:8px">
						              <tr align="center" bgcolor="#FAFAF1" height="22">
						                  <td>招聘会名称</td>
						                  <td>时间</td>
						                  <td>地点</td>
						              </tr>
									  <s:iterator value="#request.zhaopinhuiList" id="zhaopinhui">
									  <tr align='center' bgcolor="#FFFFFF" height="22">
										  <td><s:property value="#zhaopinhui.mingcheng"/></td>
										  <td><s:property value="#zhaopinhui.shijian"/></td>
										  <td><s:property value="#zhaopinhui.didian"/></td>
									  </tr>
									  </s:iterator>
			        			  </table>
						      </div>
						  </div>
					  </div>	
				      <div style="clear:both;"></div>
			     </div>
			</div>
			
			<!-- 右边的用户登录。留言。投票 -->
			<div class="page_other_msg right">
				<div class="left_row">
					<div class="list">
						<div class="list_bar">用户登录</div>
						<div class="list_content">
							<div id="div">
								<jsp:include flush="true" page="/qiantai/userlogin/userlogin.jsp"></jsp:include>
							</div>
						</div>
					</div>
				</div>
				<div class="left_row">
				    <div class="list">
				        <div class="list_bar">网站公告</div>
				        <div class="list_content">
				            <div id="div"> 
								<s:action name="gonggaoQian5" executeResult="true" flush="true"></s:action>
					        </div>
					    </div>
				    </div>
				</div>
				<div class="left_row">
				    <div class="list">
				        <div class="list_bar">网站日历表</div>
				        <div class="list_content">
				            <jsp:include flush="true" page="/qiantai/rili/rili.jsp"></jsp:include>
					    </div>
				    </div>
			    </div>
			</div>
			<!-- 右边的用户登录。留言。投票 -->
		</div>
		
		<div class="foot">
		   <jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
	    </div>
	</body>
</html>
