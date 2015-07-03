<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>咨立拍车-网站</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="js/slider.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="css/foot.css" rel="stylesheet" />
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
<style type="text/css">
.news{
	
	font-size: 18px;
	
}
</style>
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
				</li>
				<li><a href="company.html" title="公司简介">
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

					显示公告 <img style="vertical-align: middle;"
						src="img/1250(1).jpg"
						tppabs="http://www.cygpm.com/images/1250.gif">
                 <a href="index.jsp">返回首页</a>
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
				<c:forEach var="announce"  varStatus="st"
							items="${requestScope.list1}">
					<table class="news" width="690px">
				
					<tr>
					<td align="center"><h2><font size="5">${announce.title}</font></h2></td>
					
					</tr>
					<tr>
					<td>&nbsp;</td>
					</tr>
					<tr>
					<td align="center"><span class="date"><fmt:formatDate pattern="yyyy年MM月dd日"
										value="${announce.n_time }" type="both" /></span></td>
					</tr>
					<tr>
					<td>&nbsp;</td>
					</tr>
					<tr>
					<td align="left"><font color="#F00">广大会员朋友们：</font></td>
					
					</tr>
					<tr>
					<td>&nbsp;</td>
					</tr>
					<tr>
					<td><font style="line-height:200%;letter-spacing:2px">${announce.content}</font></td>
					
					</tr>
					<tr>
					<td>&nbsp;</td>
					</tr>
					<tr>
					<td align="left" ><font color="#F00">特此公告！</font></td>
					
					</tr>
					
					<tr>
					<td align="right"><font color="#F00">咨立拍车竞价平台</font></td>
					
					</tr>
					
					</table>
                    </c:forEach>
					</div>
				</div>
			</div>
		<div style="width: 266px;float: right;text-align: left;padding-right: 4px;">
				<jsp:include  page="/user_file/help/dynamic.jsp"/>
			
			</div>
		</div>

	</div>


	<!-- 内容结束 -->


	<!-- 尾部开始 -->
	<jsp:include page="../foot.jsp" flush="true" />
	<!-- 尾部结束  -->
</body>
</html>
