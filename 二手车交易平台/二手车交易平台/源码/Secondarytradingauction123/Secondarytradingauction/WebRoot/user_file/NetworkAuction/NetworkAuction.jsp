﻿<%@page import="cn.zlpc.dwr.InitManagerServlet"%>
<%@page import="tool.mastery.core.CharacterUtil"%>
<%@page import="cn.zlpc.dao.impl.*"%>
<%@page import="cn.zlpc.vo.CurrContest"%>
<%@page import="cn.zlpc.po.*"%>
<%@page import="cn.zlpc.servlet.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String vid = request.getParameter("v_id");
	String user = null;
	String auction = null;
	if (request.getParameter("auction") != null) {
		auction = request.getParameter("auction");
	}
	CurrContest curr = new CurrContest();
	if (vid != null
			&& request.getSession().getAttribute("user") != null) {
		user = ((User) request.getSession().getAttribute("user"))
				.getU_id();
		curr = new AuctionDaoImpl().getCurrContest(Integer.parseInt(vid), user);
	}
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<html>
<head>
<base href="<%=basePath%>">
<title>咨立拍车-网站</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="css/foot.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/saveAuction.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/verifyown.js"></script>
<script type="text/javascript" src="<%=path%>/dwr/engine.js"></script>
<script type="text/javascript"
	src="<%=path%>/dwr/interface/SellManager.js"></script>
<script type="text/javascript" src="<%=path%>/dwr/util.js"></script>
<script type="text/javascript">
	var re = /^[0-9]*[0-9]$/i;
	var time = 0;
	setInterval("init()", 1000);
	function setStart() {
		var message = document.getElementById("mytext").value;
		var text = document.getElementById("textarea").value;
		var value = document.getElementById("dqj").innerHTML;
		var beginAuction = 0;
		var stopAuction = 0;
		var vid = "<%=vid%>";
		if (vid != null) {
			beginAuction =
<%=curr.getBeginAuction()%>
	;
			stopAuction =
<%=curr.getStopAuction()%>
	;
	if(re.test(message)) {
		if((message-value) >= <%=curr.getPlusPri()%>) {
			if (beginAuction == 1
					&& stopAuction == 0) {
				document.getElementById("mm").innerHTML = message;
				SellManager.send(message,text);
			} else if (message != "" && beginAuction == 0) {
				alert("马上进行拍卖，请等待管理员开启拍卖！");
			} else if (message != "" && stopAuction == 1) {
				alert("管理员终止本次拍卖，拍卖结束请及时与客服联系！");
			}
			} else {
			alert("加价幅度必须大于等于"+<%=curr.getPlusPri()%>);
			}
		} else {
			alert("请输入数字");
			}
		}	
	}
	//300秒倒计时
	function count() {
			if (time > 0) {
				document.getElementById("show").innerHTML = time;
				time = time - 1;
				setTimeout("count()", 1000);
				SellManager.getTotalTime(function(data){
					if(data <= 0){
						alert("竞价结束！"); 
						getFiledNames("user="+document.getElementById("user").value + "&finalPrice="
								+ document.getElementById("dqj").innerHTML + "&v_id=<%=vid%>");
						document.forms[0].action = "AuctionStateServlet?user="
								+ document.getElementById("user").value;
						document.forms[0].submit();
					}
				});
			} else {
				alert("竞价结束！"); 
				getFiledNames("user="+document.getElementById("user").value + "&finalPrice="
						+ document.getElementById("dqj").innerHTML + "&v_id=<%=vid%>");
			document.forms[0].action = "AuctionStateServlet?user="
					+ document.getElementById("user").value;
			document.forms[0].submit();
		}
		document.getElementById("show").innerHTML = time;
	}
	function setTime(timeBuffer) {
		if (time != 0) {
			time = timeBuffer;
		} else {
			time = timeBuffer;
			count();
		}
	}
	function addPrice() {
		var nowPrice = document.getElementById("dqj").innerHTML;
		if (nowPrice == 0) {

		} else {
			document.getElementById("mytext").value = parseInt(nowPrice)
					+
<%=curr.getPlusPri()%>
	;
		}
	}
	function init() {
		var t = 0;
		SellManager.send(t, "");
	}
	function checkAuction() {
		/* var text = document.getElementById("textarea").value; */
		SellManager.CalculTimeAndMaxPrice();
		SellManager.getUserAuction();
		var auction =
<%=auction%>
	;
		if (auction == 1) {
			document.getElementById("show").innerHTML = "<font size='4' color='red'>恭喜你，竞拍成功请与客服联系确定去提车！</font>";
			SellManager.InitManagerOper();
		} else if (auction == 0) {
			document.getElementById("show").innerHTML = "<font size='4' color='red'>竞拍结束，请与客服联系返回保证金！</font>";
			SellManager.InitManagerOper();
		}
	}
</script>
</head>

<body onload="checkAuction()">
	<form name="success" method="post" action=""></form>
	<input type="hidden" id="user" name="user" value="" />

	<jsp:include page="../top.jsp" flush="true" />

	<div class="menu_navcc">
		<div class="menu_nav clearfix">
			<ul class="nav_content">
				<li><a href="index.jsp" title="首页"> <span> 首页 </span>
				</a></li>
				<li class="current"><a href="AutionForListServlet" title="网络拍卖">
						<span> 网络拍卖 </span>
				</a></li>
				<li><a href="user_file/UserInfo/User.jsp" title="会员中心"> <span>
							会员中心 </span>
				</a></li>
				<li><a href="#" title="VIP大厅"> <span> VIP大厅 </span>
				</a></li>
				<li><a href="user_file/AdvanceCar/AdvanceCar.jsp" title="预拍公告">
						<span> 预拍公告 </span>
				</a></li>
				<li><a href="user_file/help/help.jsp" title="帮助中心"> <span>
							帮助中心 </span>
				</a></li>
				<li><a href="user_file/compyIntro/company.jsp" title="公司简介">
						<span> 关于我们 </span>
				</a></li>
			</ul>
			<div class="menu_nav_right"></div>
		</div>
	</div>


	<!-- 导航条 -->
	<div id="main1_x">
		<div id="w970" style="height:700;">
			<div
				style="margin-bottom:4px; border-top:solid 0px #c2d5e3; border-bottom:solid 0px #c2d5e3; ">


				<div style="width: 970px; text-align: left; margin: 0 auto;">
					<p style="font-size: 16px; font-weight: bold; color: #66F;">
						倒计时竞价操作说明：</p>
					<div style="border: 1px dashed #C0C0C0; background-color: #F6F6F6;">
						<div>
							<img src="img/top.gif" style="margin-top: 0px;" />
						</div>
						<p style="font-size: 14px; color: #808080; line-height: 24px;">
							所有参与竞价的会员在竞价开始后，300秒倒计时开始，会员每次出价必须高于前次会员出价，出价后，300秒倒计时重新开始，300秒倒计时结束时，如果没有会员再次出价，则竞价结束，最后出价的会员为最终成交会员。</p>
						<div
							style="border: 1px solid #C0C0C0; background-color: #FFFFFF; width: 900px; margin: 0 auto;
                font-size: 12px;">
							<div>
								<table>

									<c:set var="curr" value="<%=curr%>"></c:set>
									<tr>
										<td style="border: 1px solid #C0C0C0"><img
											src="${curr.imagePath}"
											tppabs="http://www.cygpm.com/flash/2014101795703.jpg"
											width="90px" height="80px" /></td>
										<td style="border: 1px solid #C0C0C0"><div
												style="height: 40px; border-bottom: 1px solid #C0C0C0; vertical-align: middle;
                                    line-height: 40px; width: 800px;">
												<b>${curr.vname}</b> <span>${curr.v_id}</span> <b>初次登记时间</b>
												<span>: ${curr.regTime }</span>
											</div>
											<div
												style="height: 40px; vertical-align: middle; line-height: 40px;">
												<span>倒计时竞价</span> <b>竞价开始：</b> <span> <fmt:formatDate
														pattern="yyyy-MM-dd HH:mm:ss" value="${curr.bidTime }"
														type="both" />
												</span> <b>竞价结束：</b> <span><fmt:formatDate
														pattern="yyyy-MM-dd HH:mm:ss" value="${curr.bidEndTime}"
														type="both" /> </span>
											</div></td>
									</tr>
								</table>
								<table style="vertical-align: middle;">
									<tr>
										<td width="110px" align="right"
											style="border: 1px solid #C0C0C0; background-color: #F5F5F5;
                                height: 30px;">
											关注度</td>
										<td width="190px" align="center"
											style="border: 1px solid #C0C0C0;">${curr.attCou}</td>
										<td width="110px" align="right"
											style="border: 1px solid #C0C0C0; background-color: #F5F5F5;">
											竞价公告</td>
										<td width="190px" align="center"
											style="border: 1px solid #C0C0C0;"><a href="#">查看</a></td>
										<td width="110px" align="right"
											style="border: 1px solid #C0C0C0; background-color: #F5F5F5;">
											活动折扣</td>
										<td width="190px" align="center"
											style="border: 1px solid #C0C0C0;"><span
											style="font-size: 14px; font-weight: bold; color: Red;">
												无</span></td>
									</tr>
									<tr>
										<td width="110px" align="right"
											style="border: 1px solid #C0C0C0; background-color: #F5F5F5;
                                height: 30px;">
											保证金</td>
										<td width="190px" align="center"
											style="border: 1px solid #C0C0C0;"><span
											style="font-size: 14px; font-weight: bold; color: Red;">
												${curr.bidSpri * 0.10}</span>元</td>
										<td width="110px" align="right"
											style="border: 1px solid #C0C0C0; background-color: #F5F5F5;">
											底价</td>
										<td width="190px" align="center"
											style="border: 1px solid #C0C0C0;"><span
											style="font-size: 14px; font-weight: bold; color: Red;">
												${curr.bidSpri}</span>元</td>
										<td width="110px" align="right"
											style="border: 1px solid #C0C0C0; background-color: #F5F5F5;">
											最低加价幅度</td>
										<td width="190px" align="center"
											style="border: 1px solid #C0C0C0;"><span
											style="font-size: 14px; font-weight: bold; color: Red;">
												${curr.plusPri}</span>元</td>
									</tr>
								</table>
							</div>
							<div style="height: 484px;">
								<div style="float: right; width: 360px;">
									<br />
									<div style="text-align: right">
										<a
											onClick="javascript:openWin('rizhi1.aspx-id=944.htm'/*tpa=http://www.cygpm.com/rizhi1.aspx?id=944*/);"
											target="_blank" style="cursor: pointer;">查看全部竞价日志</a>
									</div>

									<div>
										<textarea name="textarea" rows="2" cols="10" id="textarea"
											disabled="disabled" style="height: 180px; width: 352px;"></textarea>
										<div style="width: 358px; height: 20px; overflow: hidden">
											<div id="allVisit"></div>
										</div>
										<textarea name="textarea2" rows="2" cols="10" id="textarea2"
											disabled="disabled" style="height: 180px; width: 352px;"></textarea>
										<div style="width: 358px; height: 200px; overflow: hidden">
											<div id="allVisit"></div>
										</div>
									</div>

								</div>
								<div style="width: 500px; float: left; margin-right: 2px;">
									<div style="height: 440px; border: 1px solid #C0C0C0;">
										<div
											style="height: 39px; background-color: #F4EFAE; line-height: 39px; vertical-align: middle;
                                text-align: center; font-size: 14px; font-weight: bold; color: #666666; border-bottom: 1px solid #C0C0C0;">
											倒计时(秒)</div>
										<div id="show"
											style="height: 79px; line-height: 79px; font-size: 52px; vertical-align: middle;
                                text-align: center; font-weight: bold; color: #666666; border-bottom: 1px solid #C0C0C0;">
											当前无人竞拍</div>
										<div
											style="height: 39px; background-color: #F4EFAE; line-height: 39px; vertical-align: middle;
                                text-align: center; font-size: 14px; font-weight: bold; color: #666666; border-bottom: 1px solid #C0C0C0;">
											当前价(元)</div>
										<div id="dqj"
											style="height: 99px; line-height: 99px; font-size: 72px; vertical-align: middle;
                                text-align: center; font-weight: bold; color: #666666; border-bottom: 1px solid #C0C0C0;">
											${curr.bidSpri}</div>
										<div style="background-color: #F6F6F6;">
											<div style="text-align: center">
												我最近一次出价：<span id="mm">无</span>
											</div>

											<div
												style="height: 40px; line-height: 40px; margin-left: 8px; vertical-align: baseline;">
												<span> 我的出价 </span>
											</div>
											<div
												style="margin-left: 8px; height: 52px; width: 260px; vertical-align: middle;">
												<input name="mytext" type="text" id="mytext"
													style="border: 1px solid #C0C0C0; height: 49px; width: 260px;
	                                                color: #11F928; line-height: 49px; vertical-align: middle; font-size: 48px;" />
											</div>
											<div style="width: 150px; float: right;">
												<div
													style="width: 150px; float: left;margin-left:-40px; margin-top: -55px; cursor: pointer;">
													<c:choose>
														<c:when test="${curr.getPlusPri() == null}">
															<input name="addPrice" type="button" id="addPrice"
																style="height: 50px; width:100px;"
																value="+0元" onClick="addPrice()" />
														</c:when>
														<c:otherwise>
															<input name="addPrice" type="button" id="addPrice"
																style="height: 50px; width:100px;"
																value="+<%=curr.getPlusPri()%>元" onClick="addPrice()" />
														
														</c:otherwise>
													</c:choose>
												</div>
											</div>
											<div style="margin-left: 8px; height: 50px; width: 417px;">
												<div style="margin-top: 24px;">
													<input name="button" type="button" id="ImageButton1"
														style="background: url(img/chujia.gif) no-repeat; border:none;
	                                     height: 29px; width: 219px; cursor:pointer;"
														onClick="setStart()" value="" /> &nbsp;&nbsp; <input
														type="button" value="校验是否开始竞拍" onclick="verify()" />
												</div>
											</div>
										</div>
									</div>
									<div style="border: 1px solid #C0C0C0; margin: 2px 0 2px 0;">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 尾部开始 -->
	<div id="footer" style="text-align: center; width: 1002px;">
		<div class="footer-container">
			<div class="copyright-info">
				<div class="footer-nav-links-list">
					<ul>
						<li><a href="">关于咨立拍车</a></li>
						<li>|</li>
						<li><a href="">竞价流程</a></li>
						<li>|</li>
						<li><a href="">公司账户</a></li>
						<li>|</li>
						<li><a href="" target="_blank">网站导航</a></li>
					</ul>
				</div>
				版权所有<a href="http://ruanjianxy.jxau.edu.cn/" target="_blank">江西农业大学软件学院
					<img src="img/bluedot.jpg" width="31">
				</a><a href="http://baike.baidu.com/view/6177001.htm?fr=aladdin">蓝点工作室</a>
				<br> 地址：南昌市昌北区沙井小区23号楼 电话：0791-83963313
			</div>
			<div class="footer-nav-links">
				<div class="footer-nav-links-title">友情链接 | Frends Link</div>
				<div class="footer-nav-links-list">
					<ul>

						<li><a href="http://www.iauto8.com/" target="_blank">
								汽车销量排行</a></li>

						<li><a href="http://www.che168.com/henan/" target="_blank">
								二手车之家</a></li>

						<li><a href="http://www.carschina.com/" target="_blank">
								汽车中国</a></li>

						<li><a href="http://www.autohome.com.cn/" target="_blank">
								汽车之家</a></li>


						<li><a href="http://www.7c8.cc" target="_blank"> 汽车吧</a></li>

					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- 尾部结束  -->
</body>
</html>