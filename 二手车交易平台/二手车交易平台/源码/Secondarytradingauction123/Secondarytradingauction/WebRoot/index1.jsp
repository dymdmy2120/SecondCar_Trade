<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
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
<!-- 

用于遍历竞拍公告的一个相当于ajax的自动提交Servlet -->
<title>咨立拍车网站</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
<link rel="stylesheet" type="text/css" href="css/first.css" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="css/foot.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/tab.js"></script>
<script language="JavaScript"> 
function isBrowser(){  
 var result;  
 var Sys={};  
 var ua=navigator.userAgent.toLowerCase();  
 var s;  
 (s=ua.match(/msie ([\d.]+)/))?Sys.ie=s[1]:  
 (s=ua.match(/firefox\/([\d.]+)/))?Sys.firefox=s[1]:  
 (s=ua.match(/chrome\/([\d.]+)/))?Sys.chrome=s[1]:  
 (s=ua.match(/opera.([\d.]+)/))?Sys.opera=s[1]:  
 (s=ua.match(/version\/([\d.]+).*safari/))?Sys.safari=s[1]:0;  
 if(Sys.ie){//Js判断为IE浏览器  
     result="ie";  
 }  
  
 if(Sys.firefox){//Js判断为火狐(firefox)浏览器  
     result="firefox"; 
 }  
  
 if(Sys.chrome){//Js判断为谷歌chrome浏览器  
     result="chrome"; 
}  
  
 if(Sys.opera){//Js判断为opera浏览器  
     result="opera"; 
 }  
 if(Sys.safari){//Js判断为苹果safari浏览器  
     result="safari"; 
 }  
 return result;  
 }

 var result=isBrowser();
 alert(result);
if(result.toString()=='chrome'&&result.toString()!='firefox'){
 alert("您使用的不是360浏览器 ，火狐浏览器，谷歌浏览器 请下载以上浏览器 ");
 window.location.href="download.jsp";
}
</script> 
<SCRIPT type="text/javascript">
	var _c = _h = 0;
	$(document).ready(function() {
		$('#play  li').click(function() {
			var i = $(this).attr('alt') - 1;
			clearInterval(_h);
			_c = i;
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
<script>
	function checkForm2(){
		if(document.loginForm2.u_id.value == ""){
			alert("请输入账号！");
			return false;
		}
		if(document.loginForm2.psword.value == ""){
			alert("请输入密码！");
			return false;
		}
		return true;
	}
  function Method(){
  //执行action
   document.action = "ptns?view=haha";
   document.submit();
  }
</script>
<script src="js/select/error.js"></script>
<link href="css/page.css" rel="stylesheet" type="text/css" />
<script src="js/select/AttestAndAttention.js"></script>
</head>
<body>
	<jsp:include page="user_file/top.jsp" flush="true" />
	<input type="hidden" id="msg" value=${info[0] } />
	<div class="menu_navcc">
		<div class="menu_nav clearfix">
			<ul class="nav_content" id="nav">
				<li class="current"><a href="index.html" title="首页"> <span>
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
				<li><a href="company.html" title="公司简介">
						<span> 关于我们 </span> </a>
				</li>
			</ul>
			<div class="menu_nav_right"></div>
		</div>
	</div>
	<div class="container" style="margin-left:180px; clear:both;">
		<c:if test="${sessionScope.user == null }">
		<form method="post" name="loginForm2"
			action="zlpc/login" onsubmit="return checkForm2()">
			<div class="denglu">
				<div class="tabbox">
					<div class="menu5"></div>
					<div class="con_t1" id="con_one_1">
						<table width="100%" border="0">
							<tr>
								<td width="60" height="40" align="right">用户名&nbsp;</td>
								<td><input type="text" name="u_id" class="text2" />
								</td>
							</tr>
							<tr>
								<td width="60" height="40" align="right">
									密&nbsp;&nbsp;码&nbsp;</td>
								<td><input type="password" name="psword" class="text2" />
								</td>
							</tr>
							<tr>
								<td width="60" height="40" align="right">&nbsp;</td>
								<td>
									<div class="c4">
										<input type="submit" value="" class="btn2" /> &nbsp;&nbsp; <a
											href="login/forget"
											style="font-weight:normal; font-size:12px; color:#610007">
											忘记密码 </a>
									</div>
								</td>
							</tr>
						</table>
					</div>

				</div>
			</div>
		</form>
		</c:if>
		<DIV class="img_switch">
			<DIV class="img_switch_content" id="pic">
				<a href="#"> <IMG src="VehiclePicture/banner1.jpg">
				</a> <a href="#"> <IMG src="VehiclePicture/banner3.jpg">
				</a> <a href="#"> <IMG src="VehiclePicture/banner4.jpg">
				</a> <a href="#"> <IMG src="VehiclePicture/banner1.jpg">
				</a> <a href="#"> <IMG src="VehiclePicture/banner3.jpg">
				</a> <a href="#"> <IMG src="VehiclePicture/banner4.jpg">
				</a> <a href="#"> <IMG src="VehiclePicture/banner1.jpg">
				</a> <a href="#"> <IMG src="VehiclePicture/banner3.jpg">
				</a>
				<DIV class="img_switch_text">
					<DIV class="number_nav">
						<UL id="play">
							<LI alt="1" style="background:#f00;">1</LI>
							<LI alt="2">2</LI>
							<LI alt="3">3</LI>
							<LI alt="4">4</LI>
							<LI alt="5">5</LI>
							<LI alt="6">6</LI>
							<LI alt="7">7</LI>
							<LI alt="8">8</LI>
						</UL>
					</DIV>
				</DIV>
			</DIV>
		</div>
	</div>
	<div style="height:170px;">
		<div
			style="width:700px; height:170px; margin-left:180px;border: 2px solid #66F; float:left;"
			class="diva">
			<a href="#"><img src="img/auction-flow.png"
				style="height:170px; width:700px;" /> </a>
		</div>
		<div
			style="float:left; background:url(img/gonggao.png) no-repeat; width:300px; height:170px; left:884px; position:absolute;">
			<div class="nri">
				<div class="to1">&nbsp;最新动态</div>
				<div class="mi1">
					<ul>
						<c:forEach var="notice" items="${requestScope.list}">
							<li><div class="test_demo_ellipsis">
									<font size="+1"><a href="notice/${notice.n_id }.html" tppabs="#"
										target="_blank" title="${notice.title}"> ${notice.title}</a></font>
										<strong>
										【<span class="date" style="font-size: 10px"><fmt:formatDate
											pattern="yyyy年MM月dd日" value="${notice.n_time }" type="both" />
										</span>】
										</strong>
								</div></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div style="width:600px; margin-left:180px; clear:both;">
		<div id="w970">
			<div
				style="margin-bottom:5px; border-top:solid 1px #c2d5e3; border-bottom:solid 1px #c2d5e3; ">
				<form>
					<table border="0" width="1004px;" cellpadding="0" cellspacing="0">
						<thead>
							<tr>
								<td width="164" height="25" ><font size="+1"> 竞拍车辆公告
								</font>
								</td>
								<td height="25" colspan="2"></td>
								<td height="25" colspan="2"></td>
								<td height="25" colspan="2"  align="right"><a href="ypgonggao.html" target="_blank"> &nbsp;&nbsp;<font
										color="#FF0000">＋查看更多竞拍车辆</font> </a></td>
							</tr>
							<tr>
								<td height="25" colspan="2" bgcolor="#66f"  align="center"><font size="+1">
										竞拍车辆基本信息</font></td>
								<td width="210" height="25" bgcolor="#66f"  align="center">&nbsp;
									&nbsp;&nbsp; 竞拍时间
								</td>
								<td width="78" height="25" bgcolor="#66f"  align="center"><font size="+1">
										竞拍底价 </font><b id="ss_pro__1" class="font14"> <span
										id="img_pro_1"> </span> </b></td>
								<td width="173" height="25" bgcolor="#66f"  align="center"><font size="+1"> 竞拍车辆来源</font>
								</td>
								<td width="245" height="25" bgcolor="#66f"  align="center"> <font size="+1"> 竞拍/关注</font>
								</td>
							</tr>
						</thead>
						<c:forEach var="entry" items="${PrTaNoticeList}">
							<tbody>
								<tr>
									<td style="border-bottom: 1px #ccc solid;padding:2px;"
										width="164"><a href="vihicle-${entry.v_id }.html" target="_blank"><img
											src="${entry.imageName}" style="display:block" border="0"
											height="88" width="160" /> </a></td>
									<td align="left" width="100"><a href="vihicle-${entry.v_id }.html" target="_blank" target="_blank">
											<strong>${entry.vname}</strong> </a>
										<ul>
											<li>底价：<strong>${entry.bidSpri } 元</strong></li>
											<li>保证金：<strong>${entry.pledge} 元</strong></li>
											<li>车源地：<strong>${entry.source}</strong></li>
											<li>初次登记：<br/><strong>
											<fmt:formatDate pattern="yyyy-MM-dd"
										value="${entry.regTime }" type="both" />
											</strong></li>
										</ul></td>
									<td align="center" width="210">
										<div style="font-weight:bold" class="timeCss">竞价开始时间	<br /> &nbsp;&nbsp;&nbsp;&nbsp;
											<font color="#CC0000" size="+1"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
										value="${entry.bidTime }" type="both" /></font>
											<img src="img/clock0.gif" border="0" /> <br /> -- <br />
											竞价结束时间<br />
											<font color="#000000" size="+1"> 
											<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
										value="${entry.bidEndTime}" type="both" /></font>
										</div>
									</td>
									<td align="center" width="78"><b id="ss_pro__1"
										class="font14"> <span id="img_pro_1"> </span> ￥ <span
											id="newprice_1"> ${entry.bidSpri} </span> </b>
									</td>
									<td width="173">
										<div align="center">
											<img alt="" src="${entry.v_source }" height="50"
												width="160" />
										</div>
									</td>
									<td align="center" valign="center" width="245">
										<div id="xpp">
											<a href="javascript:void(0)" rel="freezeUsers-24253"
												id="tooltip_1" title="${entry.attCout}人登记" style="color: black;"> <img
												alt="查看竞价会员" src="img/heart.png" /> <font id="appCount${entry.v_id }" color="#F00" >${entry.attCout}</font></a>
										</div>
										<div>
											<a
												href="javascript:setRequest('${sessionScope.user.u_id }','${entry.v_id}','state' , '0' , '${entry.attCout}')"
												class="indexchk"> <strong>竞价登记</strong> </a> <a
												href="javascript:setRequest('${sessionScope.user.u_id }','${entry.v_id}','attention' , '1' , '${entry.attCout}')"
												class="indexchk"> <strong> 加入关注</strong> </a>
										</div>
									</td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
				</form>
				
			</div>
		</div>
	</div>
	<div align="center">
						<ul class="pagination">
						<li><a>共有${page.count}条记录</a></li>
						<li><a>第${page.page}页</a></li>	
						<li><a href="PrTaNoticeServlet?view=PrTaNotice&firstIndex=1">首页</a></li>
						<li><a
							href="PrTaNoticeServlet?view=PrTaNotice&firstIndex=${page.page-1<=1?1:page.page- 1}">
								上一页 </a></li>
						<li><a
							href="PrTaNoticeServlet?view=PrTaNotice&firstIndex=${page.page + 1 >=page.lastPage?page.lastPage:page.page + 1}">
								下一页</a></li>
						<li><a
							href="PrTaNoticeServlet?view=PrTaNotice&firstIndex=${page.lastPage}">
								末页</a></li>
					</ul>
					</div>
	<!-- 内容结束 -->
	<!-- 尾部开始 -->
	<jsp:include page="user_file/foot.jsp" flush="true" />
	<!-- 尾部结束  -->
</body>
</html>
