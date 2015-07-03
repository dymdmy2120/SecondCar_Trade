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
      <div class="top4"> 帮助中心 <img style="vertical-align: middle;"
						src="img/1250(1).jpg"
						tppabs="http://www.cygpm.com/images/1250.gif"> <a
						href="QueryServlet?view=Notice&param=front">返回问题列表</a> </div>
      <div id="navi"> 首页&nbsp; <img style="vertical-align: middle;"
						src="img/1250(1).jpg"
						tppabs="http://www.cygpm.com/images/1250.gif"> &nbsp; 帮助中心 </div>
    </div>
    <div style="width: 720px; float: left;">
      <div id="index-k2" style="margin-bottom: 15px">
        <div class="question">
          <h1> <span style="font-size: medium">竞拍指南</span> </h1>
          <p> <span style="font-size: medium">1、浏览网站车辆公示信息：
            选择您感兴趣的车辆，打开车辆页面，了解参拍车辆公示信息。
            。</span> </p>
          <p> <span style="font-size: medium">2、参拍申请：
            标的车辆图片右侧“您没有参与拍卖权限”的右侧“点击申请参与拍卖”，进行申请参拍。申请说明上填写您的姓名、联系电话等，我们会有专人与您联系。</strong> </span> </p>
          <p> <span style="font-size: medium">3、交纳保证金：
            请在拍卖前提前一小时以上将拍卖保证金到账，保证金为起拍价的15%。最低5000元，最高30000元（每个车辆公示信息会有说明）。参拍中标后，保证金冻结，可用作手续费扣除。参拍未中标者，会将该保证金退回您在腾信的基金账户中，以备下次拍卖使用；也可以根据您的要求退回到您银行账户里（需要您主动提出），该退款过程约需三个工作日。
            保证金等相关费用的充值交纳，周一到周五请汇入腾信对公账户，周六银行非对公工作日可汇到腾信私人账户。详见网站的“帮助中心”—“公司账户”。</span> </p>
          <p> <span style="font-size: medium">4、参与竞拍：
            您在做好参拍申请并获得腾信参拍资格确认后进行出价。
            参拍期间有任何疑问，均可与您所在区域的对应服务专员联系。</span> </p>
          <p> <span style="font-size: medium">5、车辆中标：
            当您参拍车辆且中标后，需要交纳该车拍卖手续费，要求24小时内到账。拍卖手续费为中标价的10%，最低1000元，最高30000元。</span> </p>
          <p> <span style="font-size: medium"> 6、提车过户：
            您在中标后，腾信客服人员会与您联系，通知您具体的提车事宜（具体的时间、地点、车款费用等）。提车时腾信人员将与您签署相关车辆销售协议，并向您收取维修过户保证金。，最高30000元。</span> </p>
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
