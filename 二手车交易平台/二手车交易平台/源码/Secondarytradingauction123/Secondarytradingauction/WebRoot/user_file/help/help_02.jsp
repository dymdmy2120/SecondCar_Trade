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
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/tab.js"></script>
<SCRIPT type=text/javascript>
	var _c = _h = 0;
	$(document).ready(function() {
		$('#play  li').click(function() {
			var i = $(this).attr('alt') - 1;
			clearInterval(_h);
			_c = i;
			//play();
			change(i);
		})
		$("#pic img").hover(function() {
			clearInterval(_h)
		}, function() {
			play()
		});
		play();
	})
	function play() {
		_h = setInterval("auto()", 3000);

	}
	function change(i) {
		$('#play li').css('background-color', '#000000').eq(i).css(
				'background-color', '#FF3000').blur();
		$("#pic img").fadeOut('slow').eq(i).fadeIn('slow');
	}
	function auto() {
		_c = _c > 6 ? 0 : _c + 1;

		change(_c);
	}
</SCRIPT>
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
				<li  class="current"><a href="Notice_front.html" title="帮助中心"> <span>
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
							<span style="font-size: medium">问题：如何取得拍卖权限？</span>
						</h1>
						
							<p><br/><br/>
							<span style="font-size: medium"><strong>1、若不是会员的用户要注册会员。</strong></span>
							
						</p>
						
						<p>
							<span style="font-size: medium"><strong>2、在首页中竞拍车辆公告中点击竞价登记,或在预拍公告中点击竞价登记。</strong>
							</span>
						</p>
						<img style="vertical-align: middle;" src="img/pic1.jpg"><br/><br/>
					
						<p>
							<span style="font-size: medium"><strong>3、竞价登记成功联系右边的客户缴纳保证金等待客户开通竞价拍卖权限。</strong></span>
						</p>
							<img style="vertical-align: middle;" src="img/pic2.jpg"><br/><br/><br/><br/>
						<p>
							<span style="font-size: medium"><strong>4、权限开通成功可以竞价拍卖车辆。</strong></span>
						</p>
						

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