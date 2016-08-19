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
		
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
	    <script type="text/javascript">
	      function toudijianli()
	      {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                 document.getElementById("div1").style.display="block"; 
	            </s:else>
	      }
	      
	    function up()
	    {
	        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
            pop.setContent("contentUrl","<%=path %>/upload/upload.jsp");
            pop.setContent("title","文件上传");
            pop.build();
            pop.show();
            //另一红上传方式可以参照进销存
	    }
	    </script>
	</head>

	<body>
		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>
		<div class="page_row">
			<div class="page_main_msg left">		
		        <div class="left_row">
		            <div class="list pic_news">
		  	                <div class="list_bar">&nbsp;招聘详细信息</div>
						  	<div class="ctitle ctitle1">招聘职位：<s:property value="#request.zhaopin.zhiwei"/></div>
							<div class="ctitleinfo">待遇：<s:property value="#request.zhaopin.daiyui"/></div>
							<div class="ctitleinfo">学历要求：<s:property value="#request.zhaopin.xuliyaoqiu" escape="false"/></div>
							<div class="ctitleinfo">工作地点：<s:property value="#request.zhaopin.gongzuodidian" escape="false"/></div>
							<div class="ctitleinfo">工作经验：<s:property value="#request.zhaopin.gongzuojingyan" escape="false"/></div>
							<div class="ctitleinfo"><s:property value="#request.zhaopin.qitashuoming" escape="false"/></div>
							<div class="ctitleinfo">发布时间：<s:property value="#request.zhaopin.fabushijian" escape="false"/></div>
							<div class="ctitleinfo">
							    <input type="button" value="投递简历" onclick="toudijianli()"/>
						    </div>
						    <div class="ctitleinfo" id="div1" style="display: none">
							    <form action="<%=path %>/toudijianliAddMy.action" name="form1" id="form1" method="post">
							         简历：<input type="text" name="fujian" id="fujian" size="30" readonly="readonly"/>
							        <input type="hidden" name="fujianYuanshiming" id="fujianYuanshiming"/>  
							        <input type="button" value="选择简历" onclick="up()"/>
							       
							        <input type="hidden" name="zhaopinId" value="<s:property value="#request.zhaopin.id"/>"/>
							        <input type="submit" value="提交"/>&nbsp; 
							        <input type="reset" value="重置"/>&nbsp;
							    </form>
						    </div>
		             </div>
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
