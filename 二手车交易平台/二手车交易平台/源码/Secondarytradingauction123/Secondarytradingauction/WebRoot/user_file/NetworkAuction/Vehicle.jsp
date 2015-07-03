<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" />
<script type="text/javascript" src="js/jquery1.6.2min.js"></script>
<title>咨立拍车-网站</title>
<link type="text/css" href="css/common.css" rel="stylesheet" />
<link type="text/css" href="css/car.css" rel="stylesheet" />
<link type="text/css" href="css/picture-slides.css"
	rel="stylesheet" />
<link href="css/default.css" rel="stylesheet" type="text/css" />
<link href="css/shiguche.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.6.min.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<link type="text/css" href="css/foot.css" rel="stylesheet" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/main.js"></script>
<script src="js/select/AttestAndAttention.js"></script>
<meta content=" " name="description" />
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
<style>
   #div1 img{width:650px;height:487px;}
   #div2 img{width:80px;height:90px;margin:0px;padding:0px;}
 </style>
</head>
<body>
		
<jsp:include page="../top.jsp" flush="true" />

<div class="menu_navcc">
		<div class="menu_nav clearfix">
				<ul class="nav_content" id="nav">
				<li ><a href="index.html" title="首页"> <span>
							首页 </span> </a>
				</li>
					<li class="current"><a href="paimai.html"
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
				</li><li> <a href="company.html" title="公司简介">
						<span> 关于我们 </span> </a>
				</li>
			</ul>
			<div class="menu_nav_right"></div>
		</div>
	</div>
	<script>
   window.onload=function(){
 
    var div2=document.getElementById("div2");
 
    var imgs=div2.getElementsByTagName("img");
 
    var imgBig=document.getElementById("big");
 
    for(var i=0;i<imgs.length;i++){
 
     imgs[i].onclick=function(){
 
      imgBig.src=this.src;
     }
    }
   }
  </script>
	<div id="main1_x" align="center">
		<div id="w970">
			<div
				style="margin-bottom:5px; border-top:solid 1px #c2d5e3; border-bottom:solid 1px #c2d5e3; " align="left">
				<span id="blacktag" >事故车</span> <span
					style="font-size:20px;font-weight:bold">${requestScope.list[0].vname }</span>,由${requestScope.list[0].source }提供
				<a href="javascript:setRequest('${sessionScope.user.u_id }','${entry.v_id}','state' , '0')" class="downpic">竞价登记</a> <input
					title="加入关注，我们的客服会主动与您联系，提供更为细致的服务！" class="button2"
					onClick="javascript:setRequest('${sessionScope.user.u_id }','${entry.v_id}','attention' , '1')" value="加入关注" type="button" />
			</div>
			<div id="detail-photo">
				<div id="container">
					<div class="picture-slides-container" >
						<div id="div1" style="opacity: 1;" class="picture-slides-fade-container">
							<a class="picture-slides-image-link"> <span
								style="display: none;" class="picture-slides-image-load-fail">图片加载失败</span>
								<img title="" class="picture-slides-image"
								src="${image}" alt="" height="487" width="650" id="big"/>
							</a>
						</div>
						<div id="div2">
						<ul class="picture-slides-thumbnails">
						<c:forEach var="entry" items="${imageList}">
							<li><img src="${entry}" alt="车辆图片"  height="90" width="80"/>
							</li>
						</c:forEach>
							<li><img src="img/nocar.gif"
									alt="查看更多照片请先注册会员或登陆网站" title="查看更多照片请先注册会员或登陆网站" /> </li>
						</ul>
						</div>
					</div>
				</div>
				<div class="picture-slides-dim-overlay" ></div>
				<div align="left">
					<a href="javascript:alert('请先登录')" class="downpic">下载更多照片</a>
				</div>
			</div>
			<div id="detail" style="margin-bottom:5px;">
				<div id="redtag" style="margin-bottom:2px;" align="left">
					以下损失说明只作为购买方参考，如有部分出入请谅解，本公司建议购买方实地看车。由于事故车辆目前无法启动，无法了解正确的公里数；且该车所有商业保险已终止。
				</div>
				
				<table bgcolor="#cccccc" border="0" width="310" cellpadding="0"
					cellspacing="1">
					<tbody>
						<tr>
							<td width="152" height="25" bgcolor="#f7f7f7">
								<div align="right">
									<strong>车辆名称：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25">${requestScope.list[0].vname}</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>车辆型号：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25">${requestScope.list[0].version}</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>车牌号：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25">${requestScope.list[0].v_id}</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>停放地：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25">${requestScope.list[0].loc}</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>初次登记：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25">${requestScope.list[0].regTime}</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>档位：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155">${requestScope.list[0].gear}</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>车架号：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155">${requestScope.list[0].vframe}</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>发动机：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155">${requestScope.list[0].motor}</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>变速箱：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155">${requestScope.list[0].gearBox}</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>排量：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155">${requestScope.list[0].output}</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>主气囊：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155">${requestScope.list[0].mairSac}</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>副气囊：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155">${requestScope.list[0].sairSac}</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>变速箱：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155">${requestScope.list[0].gearBox}</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>车辆状态：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155"><strong>公示车辆</strong>
							</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>车架号是否受损：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155">${requestScope.list[0].strfBroke}</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>是否过过户：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155">${requestScope.list[0].strfTransfer}
							</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>是否有过二次事故：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155">${requestScope.list[0].strfAgain}
							</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>是否拆解：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155">${requestScope.list[0].strfDisass}
							</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>是否违章：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155">${requestScope.list[0].strfBRule}
							</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>是否抵押：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155">${requestScope.list[0].strfMort}
							</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>联系方式：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155">${requestScope.list[0].tel}</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25" valign="top">
								<div align="right">
									<strong>注意事项：</strong>
								</div></td>
							<td style="color:#FF0000" bgcolor="#FFFFFF" height="25"
								width="155">${requestScope.list[0].note}</td>
						</tr>
						<tr>
							<td bgcolor="#f7f7f7" height="25">
								<div align="right">
									<strong>关注人数：</strong>
								</div></td>
							<td bgcolor="#FFFFFF" height="25" width="155">${requestScope.list[0].attentionCounts} 人</td>
						</tr>
					</tbody>
				</table>
				
			</div>
		</div>
	</div>
	</div>
	<script type="text/javascript">
		var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://"
				: " http://");
		document
				.write(unescape("%3Cscript src='"
						+ _bdhmProtocol
						+ "hm.baidu.com/h.js%3F9f76d5edb5f4d98c9a23c7034c4f8df0' type='text/javascript'%3E%3C/script%3E"));
	</script>
	<script
		src=" http://hm.baidu.com/h.js?9f76d5edb5f4d98c9a23c7034c4f8df0"
		type="text/javascript"></script>
	<div style="display: none;">
		<img src="images/201311219500.jpg" alt="" /> <img
			src="images/201311219500.jpg" alt="" /> <img
			src="images/201311219500.jpg" alt="" /> <img
			src="images/201311219500.jpg" alt="" /> <img
			src="images/201311219500.jpg" alt="" /> <img
			src="images/201311219500.jpg" alt="" /> <img
			src="images/201311219500.jpg" alt="" /> <img
			src="images/201311219500.jpg" alt="" /> <img src="images/lnocar.gif"
			alt="" />
	</div>

	<!-- 尾部开始 -->
<jsp:include page="../foot.jsp" flush="true" />
	<!-- 尾部结束  -->

</body>
</html>