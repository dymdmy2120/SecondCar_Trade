<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
<title>咨立拍车-网站</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js" type="text/javascript"></script>
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
      <li ><a href="index.html" title="首页"> <span> 首页 </span> </a> </li>
      <li><a href="paimai.html"
					title="网络拍卖"> <span> 网络拍卖 </span> </a></li>
      <li><a href="user.html" title="会员中心"> <span> 会员中心 </span> </a> </li>
      <li><a href="#" title="VIP大厅"> <span> VIP大厅 </span> </a> </li>
      <li><a href="ypgonggao.html"
					title="预拍公告"> <span> 预拍公告 </span> </a> </li>
      <li  class="current"><a href="Notice_front.html" title="帮助中心"> <span> 帮助中心 </span> </a> </li>
      <li><a href="company.html" title="公司简介"> <span> 关于我们 </span> </a> </li>
    </ul>
    <div class="menu_nav_right"></div>
  </div>
</div>
<!--头部结束-->
<div id="main1_x">
  <div id="w970">
    <div class="top3">
      <div class="top4">帮助中心</div>
      <div id="navi"> 首页&nbsp; <img style="vertical-align: middle;"
						src="img/1250(1).jpg"
						tppabs="http://www.cygpm.com/images/1250.gif"> &nbsp; 帮助中心 </div>
    </div>
    <div style="float: left; width: 720px;">
      <div style="width: 720px; float: left;">
        <div id="index-k2" style="margin-bottom: 15px">
          <div class="question">
            <div class="ques"> <a href="help/1.html">
              <h3> <span style="font-size: medium">1、如何成为注册会员？</span> </h3>
              </a> </div>
          </div>
          <div class="question">
            <div class="ques"> <a href="help/2.html">
              <h3> <span style="font-size: medium">2、如何取得拍卖权限？</span> </h3>
              </a> </div>
          </div>
          <div class="question">
            <div class="ques"> <a href="help/4.html">
              <h3> <span style="font-size: medium">3、费用说明</span> </h3>
              </a> </div>
          </div>
          <div class="question">
            <div class="ques"> <a href="help/5.html">
              <h3> <span style="font-size: medium">4、竞价指南</span> </h3>
              </a> </div>
          </div>
        </div>
        <div id="index-k3"
						style="border-bottom: #66F 1px solid; border-left: #66F 1px solid; margin-bottom: 0px; border-top: #66F 1px solid; border-right: #66F 1px solid">
          <div id="bk-b"
							style="filter: alpha(opacity=60); background: #66F; color: white">
            <div id="left" style="font-weight: bold"> <span style="font-size: medium">站内名词解释</span> </div>
          </div>
          <div class="explain">
            <div class="text"> <span style="font-size: medium"><strong
									style="color: #F00">实时竞价：</strong> 网络竞价的一种方式。在竞价公示的网络竞价时间段内，所有确认了竞价公告，签订了网络竞价服务协议的网站用户，可以进入网络竞价厅，进行实时竞价。您可以根据竞价规则，多次出价，您可以随时了解其他用户的出价和当前最高价。在截至竞价结束时间到达后，出价最高的用户为成交用户。网站会在竞价结束后三十分钟内公示最终竞价结果。</span> </div>
            <div class="text" style="background-color: #fde1a7"> <span style="font-size: medium"><strong
									style="color: #F00">一次性竞价：</strong>网络竞价的一种方式。在竞价公示的网络竞价时间段内，所有确认了竞价公告，签订了网络竞价服务协议的网站用户，可以进入网络竞价厅，进行一次性竞价。您可以根据竞价规则，出价一次，在竞价过程中，每位用户的出价都是严格保密的。在截至竞价结束时间到达后，网站会根据出价最高的原则，确认成交用户。并在竞价结束后三十分钟内公示最终竞价结果。</span> </div>
            <div class="text"> <span style="font-size: medium"><strong
									style="color: #F00">倒计时竞价：</strong>网络竞价的一种方式。所有参与竞价的会员在竞价开始后，300秒倒计时开始，会员每次出价必须高于前次会员出价，出价后，300秒倒计时重新开始，直到300秒倒计时结束，期间如果没有会员再次出价，则竞价结束，最后出价的会员为最终成交会员。</span> </div>
          </div>
        </div>
        <p> <span style="font-size: medium">&nbsp;</span> </p>
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
