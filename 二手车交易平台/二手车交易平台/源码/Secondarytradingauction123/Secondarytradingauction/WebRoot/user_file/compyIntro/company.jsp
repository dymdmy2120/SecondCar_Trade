<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!--[if IE 8 ]> <html class="ie ie8 lte_ie8" lang="zh-CN"> <![endif]-->
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>咨立拍车-网站</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
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
				<li><a href="Notice_front.html" title="帮助中心"> <span>
							帮助中心 </span> </a>
				</li>
				<li class="current"><a href="company.html" title="公司简介">
						<span> 关于我们 </span> </a>
				</li>
			</ul>
			<div class="menu_nav_right"></div>
		</div>
	</div>
	<!-- 头部加上导航栏结束-->

	<!-- 内容开始 -->

	<div id="main1_x" style="margin-left:180px;">
		<div id="w970">
			<div class="top3">
				<div class="top4">关于我们</div>
				<div id="navi">
					首页&nbsp; <img style="vertical-align: middle;"
						src="img/1250(1).jpg"
						tppabs="http://www.cygpm.com/images/1250.gif"> &nbsp; 关于我们;&nbsp; 
						<a href="AdminLogin.html">系统</a>
				</div>
			</div>

			<div id="index-k" style="margin-bottom: 5px; border: 1px solid #66F;">
				<img alt="" width="998" height="320" src="img/service.jpg"
					style="cursor: pointer" />&nbsp;&nbsp;

				<div class="con_zh" style="margin-bottom: 0px">
					<div class="contact0" style=" height:150px;  *height:120px;">
						<div class="contact_con">
							<font size="+1" color="#000000">公司联系方式:</font>
							<ul>
								<li>公司网站：<a target="_blank" href="http://www.cygpm.com">www.zlpaiche.com</a>&nbsp;</li>
								<li>投诉电话：0791-83963313</li>
								<li style="text-align: left">邮&nbsp;&nbsp;&nbsp;箱&nbsp;：<a
									href="mailto:2256941245@qq.com">zlpaiche_mail@sina.com</a>
								</li>
								<li>公司地址：江西省南昌市红谷滩丰和中大道1869号中华庭二号楼二单元908</li>
								<li>负责人&nbsp;&nbsp;:林洋盛 电话：18942216833</li>
								<div style="clear: both"></div>

							</ul>
						</div>
					</div>

					<div class="zh">
						<div class="contact_con"
							style="background-image: url(img/zhpic.gif); width: 470px;
                            background-repeat: no-repeat;  background-position: right bottom; height: 170px">
							<font size="+1" color="#000000">公司账户信息:</font>
							<ul>
								<li style="text-align: justify; margin-left: 25px">开户行:中国工商银行江西省南昌市庐山南大道支行</li>
								<li style="text-align: justify; margin-left: 25px">林洋盛/6212-2515-0200-0104-774</li>
								<li style="text-align: justify; margin-left: 25px">开户行:中国农业银行江西省南昌市凯旋支行</li>
								<li style="text-align: justify; margin-left: 25px">林洋盛/6228-4809-2833-2868-571</li>
								<li style="text-align: justify; margin-left: 25px">开户行:中国建设银行江西省南昌市南昌住房城市建设支行</li>
								<li style="text-align: justify; margin-left: 25px">林洋盛/6217-0020-2003-1364-359</li>

								<div style="clear: both"></div>
							</ul>
						</div>
					</div>
					<div style="clear: both"></div>
				</div>

				<div class="intro">
					<div
						style="border: 1px solid #66F; margin-left:-30px; margin-top:10px; width:490px">

						<font size="+1" color="#000000"> &nbsp;&nbsp;操作流程:</font>
						<ol style="margin-left:45px">
							<li>1.注册会员</li>
							<li>2.竞价登记</li>
							<li style="text-align: left">3.联系客服支付保证金</a>
							</li>
							<li>4.参与竞拍</li>
							<li>5.付款提车</li>
						</ol>
						</span>
					</div>

					<div
						style="border: 1px solid #66F; margin-left:-30px; margin-top:10px; width:490px">

						<font size="+1" color="#000000"> &nbsp;&nbsp;公司简介:</font>
						<p style="text-align: left">
							<span
								style="font-family: 宋体; mso-ascii-font-family: 'Times New Roman'; mso-hansi-font-family: 'Times New Roman'">
								&nbsp;&nbsp;&nbsp;
								咨立拍车依托江西省银海拍卖有限公司共同开发主营事故车拍卖业务，以www.zlpaiche.com为公司发展平台。是国内专业的事故车拍卖平台。同时有事故车、拆车件信息免费发布，维修资料，行业新闻免费查询。是保险公司、4s店、汽修厂、维修行业人员的门户网站。
  咨立拍车网以尊客重德、诚信厚道为经营理念；以认真、专业规范为工作理念；以真诚打造放心服务的服务理念；为保险公司和车主提供优质服务。
  本公司面向保险公司，针对重损事故车，提供更合理的理赔方案。为保险公司更加精确评估重损事故车残值价格。使重大事故车的赔偿更加合理，降低实际赔付金额，提高理赔速度，使车主的满意度提高。同时根据各保险公司的需求，提供个性化服务，签订三方监管协议，达到保险公司、车主、买家三方放心、满意。</span>
						</p>
					</div>
					<p style="text-align: left">&nbsp;</p>
					<table>
						<tbody>
							<tr>
								<td>
									<!-- Baidu Button BEGIN -->


									<div id="bdshare"
										class="bdshare_t bds_tools_32 get-codes-bdshare">
										<a class="bds_qzone"></a> <a class="bds_tsina"></a> <a
											class="bds_tqq"></a> <a class="bds_renren"></a> <span
											class="bds_more"></span> <a class="shareCount"></a>
									</div> <script type="text/javascript" id="bdshare_js"
										data="type=tools"></script> <script type="text/javascript"
										id="bdshell_js"></script> <script type="text/javascript">
											document
													.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion="
													+ new Date().getHours();
										</script> <!-- Baidu Button END --></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>





	<!-- 内容结束 -->


	<!-- 尾部开始 -->
	<jsp:include page="../foot.jsp" flush="true" />
	<!-- 尾部结束  -->

</body>
</html>
