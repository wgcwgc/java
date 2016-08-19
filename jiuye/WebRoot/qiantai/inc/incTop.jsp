<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <style type="text/css">
        .Header {background: url(<%=path %>/img/banner.jpg) #d10e00 repeat-x left top; height: 70px;width: 966px;}
        .HeaderTop {margin: 0px auto;}
      </style>
      <script type="text/javascript">
          function zhaopinhui()
          {
              var url="<%=path %>/zhaopinhuiAll.action";
              window.open(url,"_self");
          }
          
          function docAll()
          {
              var url="<%=path %>/docAll.action";
              window.open(url,"_self");
          }
          
          function liuyanAll()
	      {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                 var url="<%=path %>/liuyanAll.action";
				     window.open(url,"_blank");
	            </s:else>
	      }
	      function zhongxin()
	      {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                 <s:if test="#session.userType=='qiye'">
	                    var url="<%=path %>/aqiye/index.jsp";
				        window.open(url,"_blank");
	                 </s:if>
	                 <s:if test="#session.userType=='stu'">
	                    var url="<%=path %>/astu/index.jsp";
				        window.open(url,"_blank");
	                 </s:if>
	            </s:else>
	      }
      </script>
  </head>
  
  <body>
        <div class="Header HeaderTop">
			<br/>
			<font style="font-size: 40px;color: white;font-weight: bolder;display: block;text-align: center;">大学生求职就业网</font>
		</div>
		<div class="topmenu cbody1">
			<ul>
				<li class="thisclass">
					<A href="<%=path %>/qiantai/default.jsp">网站首页</A>
				</li>
				<li class="thisclass">
					<A href="<%=path %>/newsAll.action">就业新闻</A>
				</li>
				<li class="thisclass">
					<A href="#" onclick="zhaopinhui()">招聘会信息</A>
				</li>
				<li class="thisclass">
					<A href="#" onclick="docAll()">招聘文档下载</A>
				</li>
				<li class="thisclass">
					<A href="<%=path %>/zhaopin_all_shixi.action">实习招聘信息</A>
				</li>
				<li class="thisclass">
					<A href="<%=path %>/zhaopin_all_jiuye.action">就业招聘信息</A>
				</li>
				<li class="thisclass">
					<A href="#" onclick="liuyanAll()">系统留言板</A>
				</li>
				<li class="thisclass">
					<A href="#" onclick="zhongxin()">会员中心</A>
				</li>
			</ul>
		</div>
		<form id="searchForm" action="<%=path %>/zhaopinSearch.action" method="post">
			<div class="topsearch">
				<div class="title"></div>
				<div id="page_search_left">
					<input class="inputText" id="" size="16" onkeypress="if(event.keyCode==13){searchFormSubmit();return false;}" name="zhiwei" type="text" />
				</div>
				<div id="page_search_btn">
					<input type="submit" value="搜索">
				</div>
				<div id="page_search_right">
					<script>
						<!--var day="";
						var month="";
						var ampm="";
						var ampmhour="";
						var myweekday="";
						var year="";
						mydate=new Date();
						myweekday=mydate.getDay();
						mymonth=mydate.getMonth()+1;
						myday= mydate.getDate();
						year= mydate.getFullYear();
						if(myweekday == 0)
						weekday=" 星期日 ";
						else if(myweekday == 1)
						weekday=" 星期一 ";
						else if(myweekday == 2)
						weekday=" 星期二 ";
						else if(myweekday == 3)
						weekday=" 星期三 ";
						else if(myweekday == 4)
						weekday=" 星期四 ";
						else if(myweekday == 5)
						weekday=" 星期五 ";
						else if(myweekday == 6)
						weekday=" 星期六 ";
						document.write(year+"年"+mymonth+"月"+myday+"日 "+weekday);
						//-->
					</script>
				</div>
				<div style="clear: both"></div>
			</div>
		</form>
  </body>
</html>
