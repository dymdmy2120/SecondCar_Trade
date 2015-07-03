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
<style type="text/css">
<!--
.STYLE1 {font-size: medium}
-->
</style></head>
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
          <h1> <span style="font-size: medium">问题：竞拍保证金的缴纳以及退还？</span> </h1>
          <p> <span style="font-size: medium">1竞价保证金：
            为了更好的体现公开公平的网络竞价环境，我们要求所有意向参加车辆竞价的用户都需要缴纳足额的保证金才可以参加网络竞价。我们会根据车辆的底价不同制定该车的保证金金额，保证金金额为竞拍底价的15%。最低5000，当竞价结束后，如果您的出价不是最高出价，未成交的话，则保证金会在2小时之内退回您的账户。</span> </p>
          <p> <span style="font-size: medium">2、维修时效保证金：<br />
            ：
            对用户的一种约束措施。本站在竞价公告中会明确说明，该车的维修过户时间，为了更好的体现公开公平的网络竞价环境，更好的约束用户遵守竞拍规则。所有参加网络竞价并最终成交的用户，需要缴纳的维修时效保证金，作为对维修过户时间的保证。 </span> </p>
          <p> <span style="font-size: medium">3、过户时效保证金：<br />
            对车主的一种约束措施。为了保障交易双方的权益，我们会向车主收取一定金额的过户时效保证金。收取金额在竞价公告中明示。</span> </p>
          <p> <span style="font-size: medium">4、网络服务费：：<br />
            我公司对每台竞价成功的车辆都会收取一定额度的服务费即网络服务费。收费的标准为成交金额的10%。</span> </p>
          <p> <span style="font-size: medium">5、协助提车费用：<br />
            为提高工作效率，规范化工作流程，咨立拍车将后续为成交车辆业务人员协助提车，所需的费用由竞买人承担，具体收费标准咨询客服：</span> </p>
          <table class="ttt" width="100%">
            <tbody>
              <tr>
                <td align="center"><span style="font-size: medium"><b>车辆停放地</b> </span> </td>
                <td align="center"><span style="font-size: medium"><b>协助提车费用</b> </span> </td>
              </tr>
              <tr>
                <td>南昌市区</td>
                <td><span style="font-size: medium">免费</span> </td>
              </tr>
              <tr>
                <td><p >抚州、鹰潭、九江、新余&nbsp;</p></td>
                <td><span style="font-size: medium">300</span> </td>
              </tr>
              <tr>
                <td><p >景德镇、上饶、宜春、吉安</p></td>
                <td><span style="font-size: medium">500</span> </td>
              </tr>
              <tr>
                <td><p >萍乡、赣州&nbsp;</p></td>
                <td><span style="font-size: medium">800</span> </td>
              </tr>
            </tbody>
          </table>
          <p style="font-size: 15px; line-height: 30px"> <span style="font-size: medium"><b>省外提车费用按实际消费情况收取，如因成交会员原因造成当天无法完成提车，需住宿的，费用由成交会员承担。</b> </span> </p>
          <p style="font-size: 14px; line-height: 30px"> <span style="font-size: medium"><b>其他费用</b>：部分车辆在停放地会产生一定金额的停车管理费或拆检费，该费用以事故车信息栏备注为准，均由竞买方承担</span> </p>
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
