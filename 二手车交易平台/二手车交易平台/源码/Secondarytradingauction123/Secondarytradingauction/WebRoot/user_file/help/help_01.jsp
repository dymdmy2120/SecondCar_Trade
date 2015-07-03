<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>咨立拍车-网站</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="js/slider.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<link href="css/index.css" rel="stylesheet" type="text/css" />
</head>
<!--
 <script language='javascript' defer>if(confirm('您还没有登录，没有此权限；立即登录吗？')){top.location.href='../index.jsp'/*tpa=http://www.cygpm.com/loginhui.aspx*/}else{top.location.href='../index.htm'/*tpa=http://www.cygpm.com/Default.aspx*/}</script>-->

<body>
		
<jsp:include page="../top.jsp" flush="true" />
<div class="menu_navcc">
		<div class="menu_nav clearfix">
				<ul class="nav_content" id="nav">
				<li ><a href="index.html" title="首页"> <span>
							首页 </span> </a>
				</li>
					<li><a href="paimai.html"
					title="网络拍卖"> <span> 网络拍卖 </span>
				</a></li>
				<li><a href="user.html" title="会员中心"> <span>
							会员中心 </span> </a>
				</li>
				<li><a href="#" title="VIP大厅"> <span> VIP大厅 </span> </a>
				</li>

				<li><a href="ypgonggao.html"
					title="预拍公告"> <span> 预拍公告 </span> </a>
				</li>
				<li class="current"><a href="Notice_front.html" title="帮助中心"> <span>
							帮助中心 </span> </a>
				</li><li><a href="company.html" title="公司简介">
						<span> 关于我们 </span> </a>
				</li>
			</ul>
			<div class="menu_nav_right"></div>
		</div>
	</div>
	<!--头部结束-->
	<div id="main1_x">
		<div id="w970">
			<div class="top3">
				<div class="top4">

					帮助中心 <img style="vertical-align: middle;"
						src="img/1250(1).jpg"
						tppabs="http://www.cygpm.com/images/1250.gif"> <a
						href="QueryServlet?view=Notice&param=front">返回问题列表</a>

				</div>
				<div id="navi">
					首页&nbsp; <img style="vertical-align: middle;"
						src="img/1250(1).jpg"
						tppabs="http://www.cygpm.com/images/1250.gif"> &nbsp; 帮助中心 
				</div>
			</div>

			<div style="width: 720px; float: left;">
				<div id="index-k2" style="margin-bottom: 15px">
					<div class="question">
						<h1>
							<span style="font-size: medium">问题：如何成为注册会员？</span>
						</h1>

						<p>
							<span style="font-size: medium">用户点击上方的用户注册按钮，将跳转到会员注册的页面，并且填写以下需要信息注册即可。（注：打*号的为必填项）</span>
						</p>
						<img style="vertical-align: middle;" src="img/regedit.png">
					</div>
				</div>
			</div>
			<div style="width: 266px;float: right;text-align: left;padding-right: 4px;">
				<jsp:include page="/user_file/help/dynamic.jsp" flush="true"  /> 
			
			</div>
		</div>

	</div>


	<!-- 内容结束 -->


	<!-- 尾部开始 -->
	<jsp:include page="../foot.jsp" flush="true" />
	<!-- 尾部结束  -->
</body>
</html>
