<%@ page language="java" import="java.util.*,cn.zlpc.vo.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<html>
<head>
<base href="<%=basePath%>">
<title>咨立拍车-网站</title>
<link rel="stylesheet" type="text/css" href="css/first.css" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="css/foot.css" rel="stylesheet" />
<script type="text/javascript" src="<%=path%>/dwr/engine.js"></script>
<script type="text/javascript"
	src="<%=path%>/dwr/interface/AjaxRefresh.js"></script>
<script type="text/javascript" src="<%=path%>/dwr/util.js"></script>
<script type="text/javascript">
<!--	
	window.onload = function(){
		var auction = document.getElementById("auction");
		var browerFlag = getOS();
		if(browerFlag){
	
		}else{
			alert("为了保证竞拍的成功，请不要使用IE浏览器"); 
			auction.href = "";
		}
		
	};
	 function getOS() {/* 
	 	var OsObject = ""; */
	 	if(isIE = navigator.userAgent.indexOf("MSIE")!=-1) {
	 			
	 			return false; 
	 	}
	 	return true;
	 }

-->
</script>
</head>
<!--
 <script language='javascript' defer>if(confirm('您还没有登录，没有此权限；立即登录吗？')){top.location.href='../index.html'/*tpa=http://www.cygpm.com/loginhui.aspx*/}else{top.location.href='../index.htm'/*tpa=http://www.cygpm.com/Default.aspx*/}</script>-->

<body>
		
<jsp:include page="../top.jsp" flush="true" />
<div class="menu_navcc">
		<div class="menu_nav clearfix">
			<ul class="nav_content">
				<li><a href="index.jsp" title="首页"> <span> 首页
					</span>
				</a></li>
				<li class="current"><a href="AutionForListServlet"
					title="网络拍卖"> <span> 网络拍卖 </span>
				</a></li>
				<li><a href="user_file/UserInfo/User.jsp" title="会员中心"> <span>
							会员中心 </span>
				</a></li>
				<li><a href="#" title="VIP大厅"> <span>VIP大厅</span>
				</a></li>
				<li><a href="user_file/AdvanceCar/AdvanceCar.jsp" title="预拍公告"> <span>
							预拍公告 </span>
				</a></li>
				<li><a href="user_file/help/help.jsp" title="帮助中心"> <span>
							帮助中心 </span>
				</a></li>
				<li><a href="user_file/compyIntro/company.jsp" title="公司简介"> <span>
							关于我们 </span>
				</a></li>
			</ul>
			<div class="menu_nav_right"></div>
		</div>
	</div>
	<br />
	<br />
	<br />
	<br />
	<br />
	<div style="height:auto !important;height:10px;min-height:10px;">
		<div
			style="margin-bottom:5px;  border-bottom:solid 1px #c2d5e3;margin-left:180px; margin-right:185px;">
			<c:choose>
				<c:when test="${requestScope.message != null}">
					<font size="5" color="red">${requestScope.message}</font>
				</c:when>
				<c:otherwise>
					<table width="1000" border="0" cellpadding="0" cellspacing="0">

						<tbody>
							<tr>
								<td width="450" align="center"><strong>车辆简介</strong></td>
								<td width="250" height="25" align="center"><strong>来源</strong></td>
								<td width="250" height="25" align="center"><strong>竞价时间</strong></td>
								<td width="200" height="25" align="center"><strong>当前价</strong></td>
								<td width="200" height="25" align="center"><strong>竞拍状态</strong></td>
							</tr>
							<c:forEach var="auctionInfo" varStatus="st"
								items="${requestScope.auctionInfo}">
								<tr style="border-bottom:solid 1px #c2d5e3;">
									<td>
										<div style="float:left;width:42%">
											<a href="QueryServlet?view=VehicleVo&queryCondition=v_id&queryValue=${auctionInfo.v_id }" target="_blank"><img
												src="${auctionInfo.imagePath}" style="display:block"
												border="0" height="90px" width=130px; /></a>
											<!-- <td align="left" width="100"><a href="#" target="_blank"> -->
										</div>
										<div style="float:right;width:58%">
											<a style="font-size: 8px"> <a href="QueryServlet?view=VehicleVo&queryCondition=v_id&queryValue=${auctionInfo.v_id }" target="_blank"><strong>${auctionInfo.vname}</strong></a>
											</a>
											<ul style="font-size: 10px">
												<li>底价：<strong>${auctionInfo.bidSpri}元</strong></li>
												<li>保证金：<strong>${auctionInfo.bidSpri * 0.15}元</strong></li>
												<li>车源地：<strong>${auctionInfo.source}</strong></li>
												<li>初次登记：<strong>${auctionInfo.regTime}</strong></li>
											</ul>
										</div>
									</td>
									<td>
										<div align="center">
											<img alt="中国人保浙江省分公司" src="${auctionInfo.v_source }"
												height="50" width="130" />
										</div>
									</td>
									<td>
										<div
											style="font-weight:bold;font-size: 10px;text-align: center;"
											class="timeCss"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
										value="${auctionInfo.bidTime}" type="both" />
											 <img src="img/clock0.gif"
												border="0" /> <br /> -- <br />
												<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
										value="${auctionInfo.bidEndTime}" type="both" />
												
										</div>
									</td>
									<td>
										<div align="center">${auctionInfo.bidSpri}元</div>
									</td>
									<td>
										<div align="center">
											<%
												Date date = new Date();
															long dateTime = date.getTime();
											%>
											<c:set var="dateTime" value="<%=dateTime%>"></c:set>
											<c:choose>
												<c:when test="${dateTime >= auctionInfo.bidTime.getTime()}">
													<a href="user_file/NetworkAuction/NetworkAuction.jsp?v_id=${auctionInfo.v_id}" id="auction">正在拍卖</a>
												</c:when>
												<c:when
													test="${dateTime > auctionInfo.bidEndTime.getTime()}">
											拍卖结束
										</c:when>
												<c:otherwise>
													<c:choose>
													<c:when test="${auctionInfo.stopAuction == 1}">
													拍卖已终止,请等待开启
													</c:when>
													<c:otherwise>
													还未开启
													</c:otherwise>
													</c:choose>
										</c:otherwise>
											</c:choose>
										</div>
									</td>
								</tr>
							</c:forEach>

						</tbody>


					</table>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
	<!-- 底部信息 -->
	<jsp:include page="../foot.jsp" flush="true" />
	<!-- 尾部结束  -->
</body>
</html>
